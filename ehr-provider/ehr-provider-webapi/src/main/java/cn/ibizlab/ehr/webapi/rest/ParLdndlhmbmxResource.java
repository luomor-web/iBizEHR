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
import cn.ibizlab.ehr.core.par.domain.ParLdndlhmbmx;
import cn.ibizlab.ehr.core.par.service.IParLdndlhmbmxService;
import cn.ibizlab.ehr.core.par.filter.ParLdndlhmbmxSearchContext;

@Slf4j
@Api(tags = {"年度量化目标明细（公司领导类 ）" })
@RestController("WebApi-parldndlhmbmx")
@RequestMapping("")
public class ParLdndlhmbmxResource {

    @Autowired
    public IParLdndlhmbmxService parldndlhmbmxService;

    @Autowired
    @Lazy
    public ParLdndlhmbmxMapping parldndlhmbmxMapping;

    @PostAuthorize("hasPermission(this.parldndlhmbmxMapping.toDomain(returnObject.body),'ehr-ParLdndlhmbmx-Get')")
    @ApiOperation(value = "获取年度量化目标明细（公司领导类 ）", tags = {"年度量化目标明细（公司领导类 ）" },  notes = "获取年度量化目标明细（公司领导类 ）")
	@RequestMapping(method = RequestMethod.GET, value = "/parldndlhmbmxes/{parldndlhmbmx_id}")
    public ResponseEntity<ParLdndlhmbmxDTO> get(@PathVariable("parldndlhmbmx_id") String parldndlhmbmx_id) {
        ParLdndlhmbmx domain = parldndlhmbmxService.get(parldndlhmbmx_id);
        ParLdndlhmbmxDTO dto = parldndlhmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取年度量化目标明细（公司领导类 ）草稿", tags = {"年度量化目标明细（公司领导类 ）" },  notes = "获取年度量化目标明细（公司领导类 ）草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parldndlhmbmxes/getdraft")
    public ResponseEntity<ParLdndlhmbmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parldndlhmbmxMapping.toDto(parldndlhmbmxService.getDraft(new ParLdndlhmbmx())));
    }

    @PreAuthorize("hasPermission(this.parldndlhmbmxMapping.toDomain(#parldndlhmbmxdto),'ehr-ParLdndlhmbmx-Create')")
    @ApiOperation(value = "新建年度量化目标明细（公司领导类 ）", tags = {"年度量化目标明细（公司领导类 ）" },  notes = "新建年度量化目标明细（公司领导类 ）")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbmxes")
    @Transactional
    public ResponseEntity<ParLdndlhmbmxDTO> create(@RequestBody ParLdndlhmbmxDTO parldndlhmbmxdto) {
        ParLdndlhmbmx domain = parldndlhmbmxMapping.toDomain(parldndlhmbmxdto);
		parldndlhmbmxService.create(domain);
        ParLdndlhmbmxDTO dto = parldndlhmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parldndlhmbmxMapping.toDomain(#parldndlhmbmxdtos),'ehr-ParLdndlhmbmx-Create')")
    @ApiOperation(value = "批量新建年度量化目标明细（公司领导类 ）", tags = {"年度量化目标明细（公司领导类 ）" },  notes = "批量新建年度量化目标明细（公司领导类 ）")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParLdndlhmbmxDTO> parldndlhmbmxdtos) {
        parldndlhmbmxService.createBatch(parldndlhmbmxMapping.toDomain(parldndlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parldndlhmbmxMapping.toDomain(#parldndlhmbmxdto),'ehr-ParLdndlhmbmx-Save')")
    @ApiOperation(value = "保存年度量化目标明细（公司领导类 ）", tags = {"年度量化目标明细（公司领导类 ）" },  notes = "保存年度量化目标明细（公司领导类 ）")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody ParLdndlhmbmxDTO parldndlhmbmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parldndlhmbmxService.save(parldndlhmbmxMapping.toDomain(parldndlhmbmxdto)));
    }

    @PreAuthorize("hasPermission(this.parldndlhmbmxMapping.toDomain(#parldndlhmbmxdtos),'ehr-ParLdndlhmbmx-Save')")
    @ApiOperation(value = "批量保存年度量化目标明细（公司领导类 ）", tags = {"年度量化目标明细（公司领导类 ）" },  notes = "批量保存年度量化目标明细（公司领导类 ）")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParLdndlhmbmxDTO> parldndlhmbmxdtos) {
        parldndlhmbmxService.saveBatch(parldndlhmbmxMapping.toDomain(parldndlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parldndlhmbmxService.get(#parldndlhmbmx_id),'ehr-ParLdndlhmbmx-Remove')")
    @ApiOperation(value = "删除年度量化目标明细（公司领导类 ）", tags = {"年度量化目标明细（公司领导类 ）" },  notes = "删除年度量化目标明细（公司领导类 ）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parldndlhmbmxes/{parldndlhmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parldndlhmbmx_id") String parldndlhmbmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parldndlhmbmxService.remove(parldndlhmbmx_id));
    }

    @PreAuthorize("hasPermission(this.parldndlhmbmxService.getParldndlhmbmxByIds(#ids),'ehr-ParLdndlhmbmx-Remove')")
    @ApiOperation(value = "批量删除年度量化目标明细（公司领导类 ）", tags = {"年度量化目标明细（公司领导类 ）" },  notes = "批量删除年度量化目标明细（公司领导类 ）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parldndlhmbmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parldndlhmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查年度量化目标明细（公司领导类 ）", tags = {"年度量化目标明细（公司领导类 ）" },  notes = "检查年度量化目标明细（公司领导类 ）")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParLdndlhmbmxDTO parldndlhmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parldndlhmbmxService.checkKey(parldndlhmbmxMapping.toDomain(parldndlhmbmxdto)));
    }

    @PreAuthorize("hasPermission(this.parldndlhmbmxService.get(#parldndlhmbmx_id),'ehr-ParLdndlhmbmx-Update')")
    @ApiOperation(value = "更新年度量化目标明细（公司领导类 ）", tags = {"年度量化目标明细（公司领导类 ）" },  notes = "更新年度量化目标明细（公司领导类 ）")
	@RequestMapping(method = RequestMethod.PUT, value = "/parldndlhmbmxes/{parldndlhmbmx_id}")
    @Transactional
    public ResponseEntity<ParLdndlhmbmxDTO> update(@PathVariable("parldndlhmbmx_id") String parldndlhmbmx_id, @RequestBody ParLdndlhmbmxDTO parldndlhmbmxdto) {
		ParLdndlhmbmx domain  = parldndlhmbmxMapping.toDomain(parldndlhmbmxdto);
        domain .setParldndlhmbmxid(parldndlhmbmx_id);
		parldndlhmbmxService.update(domain );
		ParLdndlhmbmxDTO dto = parldndlhmbmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parldndlhmbmxService.getParldndlhmbmxByEntities(this.parldndlhmbmxMapping.toDomain(#parldndlhmbmxdtos)),'ehr-ParLdndlhmbmx-Update')")
    @ApiOperation(value = "批量更新年度量化目标明细（公司领导类 ）", tags = {"年度量化目标明细（公司领导类 ）" },  notes = "批量更新年度量化目标明细（公司领导类 ）")
	@RequestMapping(method = RequestMethod.PUT, value = "/parldndlhmbmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParLdndlhmbmxDTO> parldndlhmbmxdtos) {
        parldndlhmbmxService.updateBatch(parldndlhmbmxMapping.toDomain(parldndlhmbmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParLdndlhmbmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"年度量化目标明细（公司领导类 ）" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parldndlhmbmxes/fetchdefault")
	public ResponseEntity<List<ParLdndlhmbmxDTO>> fetchDefault(ParLdndlhmbmxSearchContext context) {
        Page<ParLdndlhmbmx> domains = parldndlhmbmxService.searchDefault(context) ;
        List<ParLdndlhmbmxDTO> list = parldndlhmbmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParLdndlhmbmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"年度量化目标明细（公司领导类 ）" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parldndlhmbmxes/searchdefault")
	public ResponseEntity<Page<ParLdndlhmbmxDTO>> searchDefault(@RequestBody ParLdndlhmbmxSearchContext context) {
        Page<ParLdndlhmbmx> domains = parldndlhmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parldndlhmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.parldndlhmbmxMapping.toDomain(returnObject.body),'ehr-ParLdndlhmbmx-Get')")
    @ApiOperation(value = "根据年度量化目标（公司领导类）获取年度量化目标明细（公司领导类 ）", tags = {"年度量化目标明细（公司领导类 ）" },  notes = "根据年度量化目标（公司领导类）获取年度量化目标明细（公司领导类 ）")
	@RequestMapping(method = RequestMethod.GET, value = "/parldndlhmbs/{parldndlhmb_id}/parldndlhmbmxes/{parldndlhmbmx_id}")
    public ResponseEntity<ParLdndlhmbmxDTO> getByParLdndlhmb(@PathVariable("parldndlhmb_id") String parldndlhmb_id, @PathVariable("parldndlhmbmx_id") String parldndlhmbmx_id) {
        ParLdndlhmbmx domain = parldndlhmbmxService.get(parldndlhmbmx_id);
        ParLdndlhmbmxDTO dto = parldndlhmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据年度量化目标（公司领导类）获取年度量化目标明细（公司领导类 ）草稿", tags = {"年度量化目标明细（公司领导类 ）" },  notes = "根据年度量化目标（公司领导类）获取年度量化目标明细（公司领导类 ）草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/parldndlhmbs/{parldndlhmb_id}/parldndlhmbmxes/getdraft")
    public ResponseEntity<ParLdndlhmbmxDTO> getDraftByParLdndlhmb(@PathVariable("parldndlhmb_id") String parldndlhmb_id) {
        ParLdndlhmbmx domain = new ParLdndlhmbmx();
        domain.setParldndlhmbid(parldndlhmb_id);
        return ResponseEntity.status(HttpStatus.OK).body(parldndlhmbmxMapping.toDto(parldndlhmbmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.parldndlhmbmxMapping.toDomain(#parldndlhmbmxdto),'ehr-ParLdndlhmbmx-Create')")
    @ApiOperation(value = "根据年度量化目标（公司领导类）建立年度量化目标明细（公司领导类 ）", tags = {"年度量化目标明细（公司领导类 ）" },  notes = "根据年度量化目标（公司领导类）建立年度量化目标明细（公司领导类 ）")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbs/{parldndlhmb_id}/parldndlhmbmxes")
    @Transactional
    public ResponseEntity<ParLdndlhmbmxDTO> createByParLdndlhmb(@PathVariable("parldndlhmb_id") String parldndlhmb_id, @RequestBody ParLdndlhmbmxDTO parldndlhmbmxdto) {
        ParLdndlhmbmx domain = parldndlhmbmxMapping.toDomain(parldndlhmbmxdto);
        domain.setParldndlhmbid(parldndlhmb_id);
		parldndlhmbmxService.create(domain);
        ParLdndlhmbmxDTO dto = parldndlhmbmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parldndlhmbmxMapping.toDomain(#parldndlhmbmxdtos),'ehr-ParLdndlhmbmx-Create')")
    @ApiOperation(value = "根据年度量化目标（公司领导类）批量建立年度量化目标明细（公司领导类 ）", tags = {"年度量化目标明细（公司领导类 ）" },  notes = "根据年度量化目标（公司领导类）批量建立年度量化目标明细（公司领导类 ）")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbs/{parldndlhmb_id}/parldndlhmbmxes/batch")
    public ResponseEntity<Boolean> createBatchByParLdndlhmb(@PathVariable("parldndlhmb_id") String parldndlhmb_id, @RequestBody List<ParLdndlhmbmxDTO> parldndlhmbmxdtos) {
        List<ParLdndlhmbmx> domainlist=parldndlhmbmxMapping.toDomain(parldndlhmbmxdtos);
        for(ParLdndlhmbmx domain:domainlist){
            domain.setParldndlhmbid(parldndlhmb_id);
        }
        parldndlhmbmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parldndlhmbmxMapping.toDomain(#parldndlhmbmxdto),'ehr-ParLdndlhmbmx-Save')")
    @ApiOperation(value = "根据年度量化目标（公司领导类）保存年度量化目标明细（公司领导类 ）", tags = {"年度量化目标明细（公司领导类 ）" },  notes = "根据年度量化目标（公司领导类）保存年度量化目标明细（公司领导类 ）")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbs/{parldndlhmb_id}/parldndlhmbmxes/save")
    public ResponseEntity<Boolean> saveByParLdndlhmb(@PathVariable("parldndlhmb_id") String parldndlhmb_id, @RequestBody ParLdndlhmbmxDTO parldndlhmbmxdto) {
        ParLdndlhmbmx domain = parldndlhmbmxMapping.toDomain(parldndlhmbmxdto);
        domain.setParldndlhmbid(parldndlhmb_id);
        return ResponseEntity.status(HttpStatus.OK).body(parldndlhmbmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parldndlhmbmxMapping.toDomain(#parldndlhmbmxdtos),'ehr-ParLdndlhmbmx-Save')")
    @ApiOperation(value = "根据年度量化目标（公司领导类）批量保存年度量化目标明细（公司领导类 ）", tags = {"年度量化目标明细（公司领导类 ）" },  notes = "根据年度量化目标（公司领导类）批量保存年度量化目标明细（公司领导类 ）")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbs/{parldndlhmb_id}/parldndlhmbmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByParLdndlhmb(@PathVariable("parldndlhmb_id") String parldndlhmb_id, @RequestBody List<ParLdndlhmbmxDTO> parldndlhmbmxdtos) {
        List<ParLdndlhmbmx> domainlist=parldndlhmbmxMapping.toDomain(parldndlhmbmxdtos);
        for(ParLdndlhmbmx domain:domainlist){
             domain.setParldndlhmbid(parldndlhmb_id);
        }
        parldndlhmbmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parldndlhmbmxService.get(#parldndlhmbmx_id),'ehr-ParLdndlhmbmx-Remove')")
    @ApiOperation(value = "根据年度量化目标（公司领导类）删除年度量化目标明细（公司领导类 ）", tags = {"年度量化目标明细（公司领导类 ）" },  notes = "根据年度量化目标（公司领导类）删除年度量化目标明细（公司领导类 ）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parldndlhmbs/{parldndlhmb_id}/parldndlhmbmxes/{parldndlhmbmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByParLdndlhmb(@PathVariable("parldndlhmb_id") String parldndlhmb_id, @PathVariable("parldndlhmbmx_id") String parldndlhmbmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parldndlhmbmxService.remove(parldndlhmbmx_id));
    }

    @PreAuthorize("hasPermission(this.parldndlhmbmxService.getParldndlhmbmxByIds(#ids),'ehr-ParLdndlhmbmx-Remove')")
    @ApiOperation(value = "根据年度量化目标（公司领导类）批量删除年度量化目标明细（公司领导类 ）", tags = {"年度量化目标明细（公司领导类 ）" },  notes = "根据年度量化目标（公司领导类）批量删除年度量化目标明细（公司领导类 ）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parldndlhmbs/{parldndlhmb_id}/parldndlhmbmxes/batch")
    public ResponseEntity<Boolean> removeBatchByParLdndlhmb(@RequestBody List<String> ids) {
        parldndlhmbmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据年度量化目标（公司领导类）检查年度量化目标明细（公司领导类 ）", tags = {"年度量化目标明细（公司领导类 ）" },  notes = "根据年度量化目标（公司领导类）检查年度量化目标明细（公司领导类 ）")
	@RequestMapping(method = RequestMethod.POST, value = "/parldndlhmbs/{parldndlhmb_id}/parldndlhmbmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByParLdndlhmb(@PathVariable("parldndlhmb_id") String parldndlhmb_id, @RequestBody ParLdndlhmbmxDTO parldndlhmbmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parldndlhmbmxService.checkKey(parldndlhmbmxMapping.toDomain(parldndlhmbmxdto)));
    }

    @PreAuthorize("hasPermission(this.parldndlhmbmxService.get(#parldndlhmbmx_id),'ehr-ParLdndlhmbmx-Update')")
    @ApiOperation(value = "根据年度量化目标（公司领导类）更新年度量化目标明细（公司领导类 ）", tags = {"年度量化目标明细（公司领导类 ）" },  notes = "根据年度量化目标（公司领导类）更新年度量化目标明细（公司领导类 ）")
	@RequestMapping(method = RequestMethod.PUT, value = "/parldndlhmbs/{parldndlhmb_id}/parldndlhmbmxes/{parldndlhmbmx_id}")
    @Transactional
    public ResponseEntity<ParLdndlhmbmxDTO> updateByParLdndlhmb(@PathVariable("parldndlhmb_id") String parldndlhmb_id, @PathVariable("parldndlhmbmx_id") String parldndlhmbmx_id, @RequestBody ParLdndlhmbmxDTO parldndlhmbmxdto) {
        ParLdndlhmbmx domain = parldndlhmbmxMapping.toDomain(parldndlhmbmxdto);
        domain.setParldndlhmbid(parldndlhmb_id);
        domain.setParldndlhmbmxid(parldndlhmbmx_id);
		parldndlhmbmxService.update(domain);
        ParLdndlhmbmxDTO dto = parldndlhmbmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parldndlhmbmxService.getParldndlhmbmxByEntities(this.parldndlhmbmxMapping.toDomain(#parldndlhmbmxdtos)),'ehr-ParLdndlhmbmx-Update')")
    @ApiOperation(value = "根据年度量化目标（公司领导类）批量更新年度量化目标明细（公司领导类 ）", tags = {"年度量化目标明细（公司领导类 ）" },  notes = "根据年度量化目标（公司领导类）批量更新年度量化目标明细（公司领导类 ）")
	@RequestMapping(method = RequestMethod.PUT, value = "/parldndlhmbs/{parldndlhmb_id}/parldndlhmbmxes/batch")
    public ResponseEntity<Boolean> updateBatchByParLdndlhmb(@PathVariable("parldndlhmb_id") String parldndlhmb_id, @RequestBody List<ParLdndlhmbmxDTO> parldndlhmbmxdtos) {
        List<ParLdndlhmbmx> domainlist=parldndlhmbmxMapping.toDomain(parldndlhmbmxdtos);
        for(ParLdndlhmbmx domain:domainlist){
            domain.setParldndlhmbid(parldndlhmb_id);
        }
        parldndlhmbmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParLdndlhmbmx-Default-all')")
	@ApiOperation(value = "根据年度量化目标（公司领导类）获取DEFAULT", tags = {"年度量化目标明细（公司领导类 ）" } ,notes = "根据年度量化目标（公司领导类）获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parldndlhmbs/{parldndlhmb_id}/parldndlhmbmxes/fetchdefault")
	public ResponseEntity<List<ParLdndlhmbmxDTO>> fetchParLdndlhmbmxDefaultByParLdndlhmb(@PathVariable("parldndlhmb_id") String parldndlhmb_id,ParLdndlhmbmxSearchContext context) {
        context.setN_parldndlhmbid_eq(parldndlhmb_id);
        Page<ParLdndlhmbmx> domains = parldndlhmbmxService.searchDefault(context) ;
        List<ParLdndlhmbmxDTO> list = parldndlhmbmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParLdndlhmbmx-Default-all')")
	@ApiOperation(value = "根据年度量化目标（公司领导类）查询DEFAULT", tags = {"年度量化目标明细（公司领导类 ）" } ,notes = "根据年度量化目标（公司领导类）查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parldndlhmbs/{parldndlhmb_id}/parldndlhmbmxes/searchdefault")
	public ResponseEntity<Page<ParLdndlhmbmxDTO>> searchParLdndlhmbmxDefaultByParLdndlhmb(@PathVariable("parldndlhmb_id") String parldndlhmb_id, @RequestBody ParLdndlhmbmxSearchContext context) {
        context.setN_parldndlhmbid_eq(parldndlhmb_id);
        Page<ParLdndlhmbmx> domains = parldndlhmbmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parldndlhmbmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

