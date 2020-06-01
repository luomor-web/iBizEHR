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
import cn.ibizlab.ehr.core.par.domain.ParZnbmmx;
import cn.ibizlab.ehr.core.par.service.IParZnbmmxService;
import cn.ibizlab.ehr.core.par.filter.ParZnbmmxSearchContext;

@Slf4j
@Api(tags = {"通知选择职能部门明细" })
@RestController("WebApi-parznbmmx")
@RequestMapping("")
public class ParZnbmmxResource {

    @Autowired
    public IParZnbmmxService parznbmmxService;

    @Autowired
    @Lazy
    public ParZnbmmxMapping parznbmmxMapping;

    @ApiOperation(value = "检查通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "检查通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParZnbmmxDTO parznbmmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.checkKey(parznbmmxMapping.toDomain(parznbmmxdto)));
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.get(#parznbmmx_id),'ehr-ParZnbmmx-Update')")
    @ApiOperation(value = "更新通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "更新通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/parznbmmxes/{parznbmmx_id}")
    @Transactional
    public ResponseEntity<ParZnbmmxDTO> update(@PathVariable("parznbmmx_id") String parznbmmx_id, @RequestBody ParZnbmmxDTO parznbmmxdto) {
		ParZnbmmx domain  = parznbmmxMapping.toDomain(parznbmmxdto);
        domain .setParznbmmxid(parznbmmx_id);
		parznbmmxService.update(domain );
		ParZnbmmxDTO dto = parznbmmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.getParznbmmxByEntities(this.parznbmmxMapping.toDomain(#parznbmmxdtos)),'ehr-ParZnbmmx-Update')")
    @ApiOperation(value = "批量更新通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "批量更新通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/parznbmmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParZnbmmxDTO> parznbmmxdtos) {
        parznbmmxService.updateBatch(parznbmmxMapping.toDomain(parznbmmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取通知选择职能部门明细草稿", tags = {"通知选择职能部门明细" },  notes = "获取通知选择职能部门明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parznbmmxes/getdraft")
    public ResponseEntity<ParZnbmmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parznbmmxMapping.toDto(parznbmmxService.getDraft(new ParZnbmmx())));
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdto),'ehr-ParZnbmmx-Create')")
    @ApiOperation(value = "新建通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "新建通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmmxes")
    @Transactional
    public ResponseEntity<ParZnbmmxDTO> create(@RequestBody ParZnbmmxDTO parznbmmxdto) {
        ParZnbmmx domain = parznbmmxMapping.toDomain(parznbmmxdto);
		parznbmmxService.create(domain);
        ParZnbmmxDTO dto = parznbmmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdtos),'ehr-ParZnbmmx-Create')")
    @ApiOperation(value = "批量新建通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "批量新建通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParZnbmmxDTO> parznbmmxdtos) {
        parznbmmxService.createBatch(parznbmmxMapping.toDomain(parznbmmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.get(#parznbmmx_id),'ehr-ParZnbmmx-Remove')")
    @ApiOperation(value = "删除通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "删除通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parznbmmxes/{parznbmmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parznbmmx_id") String parznbmmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.remove(parznbmmx_id));
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.getParznbmmxByIds(#ids),'ehr-ParZnbmmx-Remove')")
    @ApiOperation(value = "批量删除通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "批量删除通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parznbmmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parznbmmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdto),'ehr-ParZnbmmx-Save')")
    @ApiOperation(value = "保存通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "保存通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody ParZnbmmxDTO parznbmmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.save(parznbmmxMapping.toDomain(parznbmmxdto)));
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdtos),'ehr-ParZnbmmx-Save')")
    @ApiOperation(value = "批量保存通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "批量保存通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parznbmmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParZnbmmxDTO> parznbmmxdtos) {
        parznbmmxService.saveBatch(parznbmmxMapping.toDomain(parznbmmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parznbmmxMapping.toDomain(returnObject.body),'ehr-ParZnbmmx-Get')")
    @ApiOperation(value = "获取通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "获取通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.GET, value = "/parznbmmxes/{parznbmmx_id}")
    public ResponseEntity<ParZnbmmxDTO> get(@PathVariable("parznbmmx_id") String parznbmmx_id) {
        ParZnbmmx domain = parznbmmxService.get(parznbmmx_id);
        ParZnbmmxDTO dto = parznbmmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParZnbmmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"通知选择职能部门明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parznbmmxes/fetchdefault")
	public ResponseEntity<List<ParZnbmmxDTO>> fetchDefault(ParZnbmmxSearchContext context) {
        Page<ParZnbmmx> domains = parznbmmxService.searchDefault(context) ;
        List<ParZnbmmxDTO> list = parznbmmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParZnbmmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"通知选择职能部门明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parznbmmxes/searchdefault")
	public ResponseEntity<Page<ParZnbmmxDTO>> searchDefault(@RequestBody ParZnbmmxSearchContext context) {
        Page<ParZnbmmx> domains = parznbmmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parznbmmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据部门管理检查通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据部门管理检查通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ParZnbmmxDTO parznbmmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.checkKey(parznbmmxMapping.toDomain(parznbmmxdto)));
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.get(#parznbmmx_id),'ehr-ParZnbmmx-Update')")
    @ApiOperation(value = "根据部门管理更新通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据部门管理更新通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/{parznbmmx_id}")
    @Transactional
    public ResponseEntity<ParZnbmmxDTO> updateByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("parznbmmx_id") String parznbmmx_id, @RequestBody ParZnbmmxDTO parznbmmxdto) {
        ParZnbmmx domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setParznbmmxid(parznbmmx_id);
		parznbmmxService.update(domain);
        ParZnbmmxDTO dto = parznbmmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.getParznbmmxByEntities(this.parznbmmxMapping.toDomain(#parznbmmxdtos)),'ehr-ParZnbmmx-Update')")
    @ApiOperation(value = "根据部门管理批量更新通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据部门管理批量更新通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ParZnbmmxDTO> parznbmmxdtos) {
        List<ParZnbmmx> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(ParZnbmmx domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        parznbmmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据部门管理获取通知选择职能部门明细草稿", tags = {"通知选择职能部门明细" },  notes = "根据部门管理获取通知选择职能部门明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/getdraft")
    public ResponseEntity<ParZnbmmxDTO> getDraftByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id) {
        ParZnbmmx domain = new ParZnbmmx();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(parznbmmxMapping.toDto(parznbmmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdto),'ehr-ParZnbmmx-Create')")
    @ApiOperation(value = "根据部门管理建立通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据部门管理建立通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes")
    @Transactional
    public ResponseEntity<ParZnbmmxDTO> createByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ParZnbmmxDTO parznbmmxdto) {
        ParZnbmmx domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
		parznbmmxService.create(domain);
        ParZnbmmxDTO dto = parznbmmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdtos),'ehr-ParZnbmmx-Create')")
    @ApiOperation(value = "根据部门管理批量建立通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据部门管理批量建立通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ParZnbmmxDTO> parznbmmxdtos) {
        List<ParZnbmmx> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(ParZnbmmx domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        parznbmmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.get(#parznbmmx_id),'ehr-ParZnbmmx-Remove')")
    @ApiOperation(value = "根据部门管理删除通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据部门管理删除通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/{parznbmmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("parznbmmx_id") String parznbmmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.remove(parznbmmx_id));
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.getParznbmmxByIds(#ids),'ehr-ParZnbmmx-Remove')")
    @ApiOperation(value = "根据部门管理批量删除通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据部门管理批量删除通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgsector(@RequestBody List<String> ids) {
        parznbmmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdto),'ehr-ParZnbmmx-Save')")
    @ApiOperation(value = "根据部门管理保存通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据部门管理保存通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/save")
    public ResponseEntity<Boolean> saveByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ParZnbmmxDTO parznbmmxdto) {
        ParZnbmmx domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdtos),'ehr-ParZnbmmx-Save')")
    @ApiOperation(value = "根据部门管理批量保存通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据部门管理批量保存通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ParZnbmmxDTO> parznbmmxdtos) {
        List<ParZnbmmx> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(ParZnbmmx domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        parznbmmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parznbmmxMapping.toDomain(returnObject.body),'ehr-ParZnbmmx-Get')")
    @ApiOperation(value = "根据部门管理获取通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据部门管理获取通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgsectors/{ormorgsector_id}/parznbmmxes/{parznbmmx_id}")
    public ResponseEntity<ParZnbmmxDTO> getByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("parznbmmx_id") String parznbmmx_id) {
        ParZnbmmx domain = parznbmmxService.get(parznbmmx_id);
        ParZnbmmxDTO dto = parznbmmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParZnbmmx-Default-all')")
	@ApiOperation(value = "根据部门管理获取DEFAULT", tags = {"通知选择职能部门明细" } ,notes = "根据部门管理获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgsectors/{ormorgsector_id}/parznbmmxes/fetchdefault")
	public ResponseEntity<List<ParZnbmmxDTO>> fetchParZnbmmxDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id,ParZnbmmxSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<ParZnbmmx> domains = parznbmmxService.searchDefault(context) ;
        List<ParZnbmmxDTO> list = parznbmmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParZnbmmx-Default-all')")
	@ApiOperation(value = "根据部门管理查询DEFAULT", tags = {"通知选择职能部门明细" } ,notes = "根据部门管理查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgsectors/{ormorgsector_id}/parznbmmxes/searchdefault")
	public ResponseEntity<Page<ParZnbmmxDTO>> searchParZnbmmxDefaultByOrmOrgsector(@PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ParZnbmmxSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<ParZnbmmx> domains = parznbmmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parznbmmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据通知发布检查通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据通知发布检查通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parznbmmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody ParZnbmmxDTO parznbmmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.checkKey(parznbmmxMapping.toDomain(parznbmmxdto)));
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.get(#parznbmmx_id),'ehr-ParZnbmmx-Update')")
    @ApiOperation(value = "根据通知发布更新通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据通知发布更新通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/partzggs/{partzgg_id}/parznbmmxes/{parznbmmx_id}")
    @Transactional
    public ResponseEntity<ParZnbmmxDTO> updateByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @PathVariable("parznbmmx_id") String parznbmmx_id, @RequestBody ParZnbmmxDTO parznbmmxdto) {
        ParZnbmmx domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setPartzggid(partzgg_id);
        domain.setParznbmmxid(parznbmmx_id);
		parznbmmxService.update(domain);
        ParZnbmmxDTO dto = parznbmmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.getParznbmmxByEntities(this.parznbmmxMapping.toDomain(#parznbmmxdtos)),'ehr-ParZnbmmx-Update')")
    @ApiOperation(value = "根据通知发布批量更新通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据通知发布批量更新通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/partzggs/{partzgg_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> updateBatchByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody List<ParZnbmmxDTO> parznbmmxdtos) {
        List<ParZnbmmx> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(ParZnbmmx domain:domainlist){
            domain.setPartzggid(partzgg_id);
        }
        parznbmmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据通知发布获取通知选择职能部门明细草稿", tags = {"通知选择职能部门明细" },  notes = "根据通知发布获取通知选择职能部门明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/partzggs/{partzgg_id}/parznbmmxes/getdraft")
    public ResponseEntity<ParZnbmmxDTO> getDraftByParTzgg(@PathVariable("partzgg_id") String partzgg_id) {
        ParZnbmmx domain = new ParZnbmmx();
        domain.setPartzggid(partzgg_id);
        return ResponseEntity.status(HttpStatus.OK).body(parznbmmxMapping.toDto(parznbmmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdto),'ehr-ParZnbmmx-Create')")
    @ApiOperation(value = "根据通知发布建立通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据通知发布建立通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parznbmmxes")
    @Transactional
    public ResponseEntity<ParZnbmmxDTO> createByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody ParZnbmmxDTO parznbmmxdto) {
        ParZnbmmx domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setPartzggid(partzgg_id);
		parznbmmxService.create(domain);
        ParZnbmmxDTO dto = parznbmmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdtos),'ehr-ParZnbmmx-Create')")
    @ApiOperation(value = "根据通知发布批量建立通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据通知发布批量建立通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> createBatchByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody List<ParZnbmmxDTO> parznbmmxdtos) {
        List<ParZnbmmx> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(ParZnbmmx domain:domainlist){
            domain.setPartzggid(partzgg_id);
        }
        parznbmmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.get(#parznbmmx_id),'ehr-ParZnbmmx-Remove')")
    @ApiOperation(value = "根据通知发布删除通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据通知发布删除通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/partzggs/{partzgg_id}/parznbmmxes/{parznbmmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @PathVariable("parznbmmx_id") String parznbmmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.remove(parznbmmx_id));
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.getParznbmmxByIds(#ids),'ehr-ParZnbmmx-Remove')")
    @ApiOperation(value = "根据通知发布批量删除通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据通知发布批量删除通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/partzggs/{partzgg_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> removeBatchByParTzgg(@RequestBody List<String> ids) {
        parznbmmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdto),'ehr-ParZnbmmx-Save')")
    @ApiOperation(value = "根据通知发布保存通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据通知发布保存通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parznbmmxes/save")
    public ResponseEntity<Boolean> saveByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody ParZnbmmxDTO parznbmmxdto) {
        ParZnbmmx domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setPartzggid(partzgg_id);
        return ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdtos),'ehr-ParZnbmmx-Save')")
    @ApiOperation(value = "根据通知发布批量保存通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据通知发布批量保存通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.POST, value = "/partzggs/{partzgg_id}/parznbmmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody List<ParZnbmmxDTO> parznbmmxdtos) {
        List<ParZnbmmx> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(ParZnbmmx domain:domainlist){
             domain.setPartzggid(partzgg_id);
        }
        parznbmmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parznbmmxMapping.toDomain(returnObject.body),'ehr-ParZnbmmx-Get')")
    @ApiOperation(value = "根据通知发布获取通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据通知发布获取通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.GET, value = "/partzggs/{partzgg_id}/parznbmmxes/{parznbmmx_id}")
    public ResponseEntity<ParZnbmmxDTO> getByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @PathVariable("parznbmmx_id") String parznbmmx_id) {
        ParZnbmmx domain = parznbmmxService.get(parznbmmx_id);
        ParZnbmmxDTO dto = parznbmmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParZnbmmx-Default-all')")
	@ApiOperation(value = "根据通知发布获取DEFAULT", tags = {"通知选择职能部门明细" } ,notes = "根据通知发布获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/partzggs/{partzgg_id}/parznbmmxes/fetchdefault")
	public ResponseEntity<List<ParZnbmmxDTO>> fetchParZnbmmxDefaultByParTzgg(@PathVariable("partzgg_id") String partzgg_id,ParZnbmmxSearchContext context) {
        context.setN_partzggid_eq(partzgg_id);
        Page<ParZnbmmx> domains = parznbmmxService.searchDefault(context) ;
        List<ParZnbmmxDTO> list = parznbmmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParZnbmmx-Default-all')")
	@ApiOperation(value = "根据通知发布查询DEFAULT", tags = {"通知选择职能部门明细" } ,notes = "根据通知发布查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/partzggs/{partzgg_id}/parznbmmxes/searchdefault")
	public ResponseEntity<Page<ParZnbmmxDTO>> searchParZnbmmxDefaultByParTzgg(@PathVariable("partzgg_id") String partzgg_id, @RequestBody ParZnbmmxSearchContext context) {
        context.setN_partzggid_eq(partzgg_id);
        Page<ParZnbmmx> domains = parznbmmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parznbmmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据组织管理部门管理检查通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据组织管理部门管理检查通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ParZnbmmxDTO parznbmmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.checkKey(parznbmmxMapping.toDomain(parznbmmxdto)));
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.get(#parznbmmx_id),'ehr-ParZnbmmx-Update')")
    @ApiOperation(value = "根据组织管理部门管理更新通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据组织管理部门管理更新通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/{parznbmmx_id}")
    @Transactional
    public ResponseEntity<ParZnbmmxDTO> updateByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("parznbmmx_id") String parznbmmx_id, @RequestBody ParZnbmmxDTO parznbmmxdto) {
        ParZnbmmx domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        domain.setParznbmmxid(parznbmmx_id);
		parznbmmxService.update(domain);
        ParZnbmmxDTO dto = parznbmmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.getParznbmmxByEntities(this.parznbmmxMapping.toDomain(#parznbmmxdtos)),'ehr-ParZnbmmx-Update')")
    @ApiOperation(value = "根据组织管理部门管理批量更新通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据组织管理部门管理批量更新通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> updateBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ParZnbmmxDTO> parznbmmxdtos) {
        List<ParZnbmmx> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(ParZnbmmx domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        parznbmmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据组织管理部门管理获取通知选择职能部门明细草稿", tags = {"通知选择职能部门明细" },  notes = "根据组织管理部门管理获取通知选择职能部门明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/getdraft")
    public ResponseEntity<ParZnbmmxDTO> getDraftByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id) {
        ParZnbmmx domain = new ParZnbmmx();
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(parznbmmxMapping.toDto(parznbmmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdto),'ehr-ParZnbmmx-Create')")
    @ApiOperation(value = "根据组织管理部门管理建立通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据组织管理部门管理建立通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes")
    @Transactional
    public ResponseEntity<ParZnbmmxDTO> createByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ParZnbmmxDTO parznbmmxdto) {
        ParZnbmmx domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
		parznbmmxService.create(domain);
        ParZnbmmxDTO dto = parznbmmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdtos),'ehr-ParZnbmmx-Create')")
    @ApiOperation(value = "根据组织管理部门管理批量建立通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据组织管理部门管理批量建立通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> createBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ParZnbmmxDTO> parznbmmxdtos) {
        List<ParZnbmmx> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(ParZnbmmx domain:domainlist){
            domain.setOrmorgsectorid(ormorgsector_id);
        }
        parznbmmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.get(#parznbmmx_id),'ehr-ParZnbmmx-Remove')")
    @ApiOperation(value = "根据组织管理部门管理删除通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据组织管理部门管理删除通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/{parznbmmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("parznbmmx_id") String parznbmmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.remove(parznbmmx_id));
    }

    @PreAuthorize("hasPermission(this.parznbmmxService.getParznbmmxByIds(#ids),'ehr-ParZnbmmx-Remove')")
    @ApiOperation(value = "根据组织管理部门管理批量删除通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据组织管理部门管理批量删除通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/batch")
    public ResponseEntity<Boolean> removeBatchByOrmOrgOrmOrgsector(@RequestBody List<String> ids) {
        parznbmmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdto),'ehr-ParZnbmmx-Save')")
    @ApiOperation(value = "根据组织管理部门管理保存通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据组织管理部门管理保存通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/save")
    public ResponseEntity<Boolean> saveByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ParZnbmmxDTO parznbmmxdto) {
        ParZnbmmx domain = parznbmmxMapping.toDomain(parznbmmxdto);
        domain.setOrmorgsectorid(ormorgsector_id);
        return ResponseEntity.status(HttpStatus.OK).body(parznbmmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parznbmmxMapping.toDomain(#parznbmmxdtos),'ehr-ParZnbmmx-Save')")
    @ApiOperation(value = "根据组织管理部门管理批量保存通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据组织管理部门管理批量保存通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.POST, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody List<ParZnbmmxDTO> parznbmmxdtos) {
        List<ParZnbmmx> domainlist=parznbmmxMapping.toDomain(parznbmmxdtos);
        for(ParZnbmmx domain:domainlist){
             domain.setOrmorgsectorid(ormorgsector_id);
        }
        parznbmmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parznbmmxMapping.toDomain(returnObject.body),'ehr-ParZnbmmx-Get')")
    @ApiOperation(value = "根据组织管理部门管理获取通知选择职能部门明细", tags = {"通知选择职能部门明细" },  notes = "根据组织管理部门管理获取通知选择职能部门明细")
	@RequestMapping(method = RequestMethod.GET, value = "/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/{parznbmmx_id}")
    public ResponseEntity<ParZnbmmxDTO> getByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @PathVariable("parznbmmx_id") String parznbmmx_id) {
        ParZnbmmx domain = parznbmmxService.get(parznbmmx_id);
        ParZnbmmxDTO dto = parznbmmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParZnbmmx-Default-all')")
	@ApiOperation(value = "根据组织管理部门管理获取DEFAULT", tags = {"通知选择职能部门明细" } ,notes = "根据组织管理部门管理获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/fetchdefault")
	public ResponseEntity<List<ParZnbmmxDTO>> fetchParZnbmmxDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id,ParZnbmmxSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<ParZnbmmx> domains = parznbmmxService.searchDefault(context) ;
        List<ParZnbmmxDTO> list = parznbmmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParZnbmmx-Default-all')")
	@ApiOperation(value = "根据组织管理部门管理查询DEFAULT", tags = {"通知选择职能部门明细" } ,notes = "根据组织管理部门管理查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormorgs/{ormorg_id}/ormorgsectors/{ormorgsector_id}/parznbmmxes/searchdefault")
	public ResponseEntity<Page<ParZnbmmxDTO>> searchParZnbmmxDefaultByOrmOrgOrmOrgsector(@PathVariable("ormorg_id") String ormorg_id, @PathVariable("ormorgsector_id") String ormorgsector_id, @RequestBody ParZnbmmxSearchContext context) {
        context.setN_ormorgsectorid_eq(ormorgsector_id);
        Page<ParZnbmmx> domains = parznbmmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parznbmmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

