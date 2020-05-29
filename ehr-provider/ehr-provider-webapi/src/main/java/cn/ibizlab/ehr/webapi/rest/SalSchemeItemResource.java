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
import cn.ibizlab.ehr.core.sal.domain.SalSchemeItem;
import cn.ibizlab.ehr.core.sal.service.ISalSchemeItemService;
import cn.ibizlab.ehr.core.sal.filter.SalSchemeItemSearchContext;

@Slf4j
@Api(tags = {"工资单要素项" })
@RestController("WebApi-salschemeitem")
@RequestMapping("")
public class SalSchemeItemResource {

    @Autowired
    public ISalSchemeItemService salschemeitemService;

    @Autowired
    @Lazy
    public SalSchemeItemMapping salschemeitemMapping;

    @PreAuthorize("hasPermission(this.salschemeitemService.get(#salschemeitem_id),'ehr-SalSchemeItem-Update')")
    @ApiOperation(value = "更新工资单要素项", tags = {"工资单要素项" },  notes = "更新工资单要素项")
	@RequestMapping(method = RequestMethod.PUT, value = "/salschemeitems/{salschemeitem_id}")
    @Transactional
    public ResponseEntity<SalSchemeItemDTO> update(@PathVariable("salschemeitem_id") String salschemeitem_id, @RequestBody SalSchemeItemDTO salschemeitemdto) {
		SalSchemeItem domain  = salschemeitemMapping.toDomain(salschemeitemdto);
        domain .setSalschemeitemid(salschemeitem_id);
		salschemeitemService.update(domain );
		SalSchemeItemDTO dto = salschemeitemMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.getSalschemeitemByEntities(this.salschemeitemMapping.toDomain(#salschemeitemdtos)),'ehr-SalSchemeItem-Update')")
    @ApiOperation(value = "批量更新工资单要素项", tags = {"工资单要素项" },  notes = "批量更新工资单要素项")
	@RequestMapping(method = RequestMethod.PUT, value = "/salschemeitems/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalSchemeItemDTO> salschemeitemdtos) {
        salschemeitemService.updateBatch(salschemeitemMapping.toDomain(salschemeitemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdto),'ehr-SalSchemeItem-Save')")
    @ApiOperation(value = "保存工资单要素项", tags = {"工资单要素项" },  notes = "保存工资单要素项")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemeitems/save")
    public ResponseEntity<Boolean> save(@RequestBody SalSchemeItemDTO salschemeitemdto) {
        return ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.save(salschemeitemMapping.toDomain(salschemeitemdto)));
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdtos),'ehr-SalSchemeItem-Save')")
    @ApiOperation(value = "批量保存工资单要素项", tags = {"工资单要素项" },  notes = "批量保存工资单要素项")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemeitems/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalSchemeItemDTO> salschemeitemdtos) {
        salschemeitemService.saveBatch(salschemeitemMapping.toDomain(salschemeitemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salschemeitemMapping.toDomain(returnObject.body),'ehr-SalSchemeItem-Get')")
    @ApiOperation(value = "获取工资单要素项", tags = {"工资单要素项" },  notes = "获取工资单要素项")
	@RequestMapping(method = RequestMethod.GET, value = "/salschemeitems/{salschemeitem_id}")
    public ResponseEntity<SalSchemeItemDTO> get(@PathVariable("salschemeitem_id") String salschemeitem_id) {
        SalSchemeItem domain = salschemeitemService.get(salschemeitem_id);
        SalSchemeItemDTO dto = salschemeitemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.get(#salschemeitem_id),'ehr-SalSchemeItem-Remove')")
    @ApiOperation(value = "删除工资单要素项", tags = {"工资单要素项" },  notes = "删除工资单要素项")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salschemeitems/{salschemeitem_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salschemeitem_id") String salschemeitem_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.remove(salschemeitem_id));
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.getSalschemeitemByIds(#ids),'ehr-SalSchemeItem-Remove')")
    @ApiOperation(value = "批量删除工资单要素项", tags = {"工资单要素项" },  notes = "批量删除工资单要素项")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salschemeitems/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salschemeitemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查工资单要素项", tags = {"工资单要素项" },  notes = "检查工资单要素项")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemeitems/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalSchemeItemDTO salschemeitemdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.checkKey(salschemeitemMapping.toDomain(salschemeitemdto)));
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdto),'ehr-SalSchemeItem-Create')")
    @ApiOperation(value = "新建工资单要素项", tags = {"工资单要素项" },  notes = "新建工资单要素项")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemeitems")
    @Transactional
    public ResponseEntity<SalSchemeItemDTO> create(@RequestBody SalSchemeItemDTO salschemeitemdto) {
        SalSchemeItem domain = salschemeitemMapping.toDomain(salschemeitemdto);
		salschemeitemService.create(domain);
        SalSchemeItemDTO dto = salschemeitemMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdtos),'ehr-SalSchemeItem-Create')")
    @ApiOperation(value = "批量新建工资单要素项", tags = {"工资单要素项" },  notes = "批量新建工资单要素项")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemeitems/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalSchemeItemDTO> salschemeitemdtos) {
        salschemeitemService.createBatch(salschemeitemMapping.toDomain(salschemeitemdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取工资单要素项草稿", tags = {"工资单要素项" },  notes = "获取工资单要素项草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/salschemeitems/getdraft")
    public ResponseEntity<SalSchemeItemDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salschemeitemMapping.toDto(salschemeitemService.getDraft(new SalSchemeItem())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalSchemeItem-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"工资单要素项" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salschemeitems/fetchdefault")
	public ResponseEntity<List<SalSchemeItemDTO>> fetchDefault(SalSchemeItemSearchContext context) {
        Page<SalSchemeItem> domains = salschemeitemService.searchDefault(context) ;
        List<SalSchemeItemDTO> list = salschemeitemMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalSchemeItem-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"工资单要素项" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salschemeitems/searchdefault")
	public ResponseEntity<Page<SalSchemeItemDTO>> searchDefault(@RequestBody SalSchemeItemSearchContext context) {
        Page<SalSchemeItem> domains = salschemeitemService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salschemeitemMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.salschemeitemService.get(#salschemeitem_id),'ehr-SalSchemeItem-Update')")
    @ApiOperation(value = "根据薪酬要素项更新工资单要素项", tags = {"工资单要素项" },  notes = "根据薪酬要素项更新工资单要素项")
	@RequestMapping(method = RequestMethod.PUT, value = "/salitems/{salitem_id}/salschemeitems/{salschemeitem_id}")
    @Transactional
    public ResponseEntity<SalSchemeItemDTO> updateBySalItem(@PathVariable("salitem_id") String salitem_id, @PathVariable("salschemeitem_id") String salschemeitem_id, @RequestBody SalSchemeItemDTO salschemeitemdto) {
        SalSchemeItem domain = salschemeitemMapping.toDomain(salschemeitemdto);
        domain.setSalitemid(salitem_id);
        domain.setSalschemeitemid(salschemeitem_id);
		salschemeitemService.update(domain);
        SalSchemeItemDTO dto = salschemeitemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.getSalschemeitemByEntities(this.salschemeitemMapping.toDomain(#salschemeitemdtos)),'ehr-SalSchemeItem-Update')")
    @ApiOperation(value = "根据薪酬要素项批量更新工资单要素项", tags = {"工资单要素项" },  notes = "根据薪酬要素项批量更新工资单要素项")
	@RequestMapping(method = RequestMethod.PUT, value = "/salitems/{salitem_id}/salschemeitems/batch")
    public ResponseEntity<Boolean> updateBatchBySalItem(@PathVariable("salitem_id") String salitem_id, @RequestBody List<SalSchemeItemDTO> salschemeitemdtos) {
        List<SalSchemeItem> domainlist=salschemeitemMapping.toDomain(salschemeitemdtos);
        for(SalSchemeItem domain:domainlist){
            domain.setSalitemid(salitem_id);
        }
        salschemeitemService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdto),'ehr-SalSchemeItem-Save')")
    @ApiOperation(value = "根据薪酬要素项保存工资单要素项", tags = {"工资单要素项" },  notes = "根据薪酬要素项保存工资单要素项")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems/{salitem_id}/salschemeitems/save")
    public ResponseEntity<Boolean> saveBySalItem(@PathVariable("salitem_id") String salitem_id, @RequestBody SalSchemeItemDTO salschemeitemdto) {
        SalSchemeItem domain = salschemeitemMapping.toDomain(salschemeitemdto);
        domain.setSalitemid(salitem_id);
        return ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.save(domain));
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdtos),'ehr-SalSchemeItem-Save')")
    @ApiOperation(value = "根据薪酬要素项批量保存工资单要素项", tags = {"工资单要素项" },  notes = "根据薪酬要素项批量保存工资单要素项")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems/{salitem_id}/salschemeitems/savebatch")
    public ResponseEntity<Boolean> saveBatchBySalItem(@PathVariable("salitem_id") String salitem_id, @RequestBody List<SalSchemeItemDTO> salschemeitemdtos) {
        List<SalSchemeItem> domainlist=salschemeitemMapping.toDomain(salschemeitemdtos);
        for(SalSchemeItem domain:domainlist){
             domain.setSalitemid(salitem_id);
        }
        salschemeitemService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salschemeitemMapping.toDomain(returnObject.body),'ehr-SalSchemeItem-Get')")
    @ApiOperation(value = "根据薪酬要素项获取工资单要素项", tags = {"工资单要素项" },  notes = "根据薪酬要素项获取工资单要素项")
	@RequestMapping(method = RequestMethod.GET, value = "/salitems/{salitem_id}/salschemeitems/{salschemeitem_id}")
    public ResponseEntity<SalSchemeItemDTO> getBySalItem(@PathVariable("salitem_id") String salitem_id, @PathVariable("salschemeitem_id") String salschemeitem_id) {
        SalSchemeItem domain = salschemeitemService.get(salschemeitem_id);
        SalSchemeItemDTO dto = salschemeitemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.get(#salschemeitem_id),'ehr-SalSchemeItem-Remove')")
    @ApiOperation(value = "根据薪酬要素项删除工资单要素项", tags = {"工资单要素项" },  notes = "根据薪酬要素项删除工资单要素项")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salitems/{salitem_id}/salschemeitems/{salschemeitem_id}")
    @Transactional
    public ResponseEntity<Boolean> removeBySalItem(@PathVariable("salitem_id") String salitem_id, @PathVariable("salschemeitem_id") String salschemeitem_id) {
		return ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.remove(salschemeitem_id));
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.getSalschemeitemByIds(#ids),'ehr-SalSchemeItem-Remove')")
    @ApiOperation(value = "根据薪酬要素项批量删除工资单要素项", tags = {"工资单要素项" },  notes = "根据薪酬要素项批量删除工资单要素项")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salitems/{salitem_id}/salschemeitems/batch")
    public ResponseEntity<Boolean> removeBatchBySalItem(@RequestBody List<String> ids) {
        salschemeitemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据薪酬要素项检查工资单要素项", tags = {"工资单要素项" },  notes = "根据薪酬要素项检查工资单要素项")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems/{salitem_id}/salschemeitems/checkkey")
    public ResponseEntity<Boolean> checkKeyBySalItem(@PathVariable("salitem_id") String salitem_id, @RequestBody SalSchemeItemDTO salschemeitemdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.checkKey(salschemeitemMapping.toDomain(salschemeitemdto)));
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdto),'ehr-SalSchemeItem-Create')")
    @ApiOperation(value = "根据薪酬要素项建立工资单要素项", tags = {"工资单要素项" },  notes = "根据薪酬要素项建立工资单要素项")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems/{salitem_id}/salschemeitems")
    @Transactional
    public ResponseEntity<SalSchemeItemDTO> createBySalItem(@PathVariable("salitem_id") String salitem_id, @RequestBody SalSchemeItemDTO salschemeitemdto) {
        SalSchemeItem domain = salschemeitemMapping.toDomain(salschemeitemdto);
        domain.setSalitemid(salitem_id);
		salschemeitemService.create(domain);
        SalSchemeItemDTO dto = salschemeitemMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdtos),'ehr-SalSchemeItem-Create')")
    @ApiOperation(value = "根据薪酬要素项批量建立工资单要素项", tags = {"工资单要素项" },  notes = "根据薪酬要素项批量建立工资单要素项")
	@RequestMapping(method = RequestMethod.POST, value = "/salitems/{salitem_id}/salschemeitems/batch")
    public ResponseEntity<Boolean> createBatchBySalItem(@PathVariable("salitem_id") String salitem_id, @RequestBody List<SalSchemeItemDTO> salschemeitemdtos) {
        List<SalSchemeItem> domainlist=salschemeitemMapping.toDomain(salschemeitemdtos);
        for(SalSchemeItem domain:domainlist){
            domain.setSalitemid(salitem_id);
        }
        salschemeitemService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据薪酬要素项获取工资单要素项草稿", tags = {"工资单要素项" },  notes = "根据薪酬要素项获取工资单要素项草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/salitems/{salitem_id}/salschemeitems/getdraft")
    public ResponseEntity<SalSchemeItemDTO> getDraftBySalItem(@PathVariable("salitem_id") String salitem_id) {
        SalSchemeItem domain = new SalSchemeItem();
        domain.setSalitemid(salitem_id);
        return ResponseEntity.status(HttpStatus.OK).body(salschemeitemMapping.toDto(salschemeitemService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalSchemeItem-Default-all')")
	@ApiOperation(value = "根据薪酬要素项获取DEFAULT", tags = {"工资单要素项" } ,notes = "根据薪酬要素项获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salitems/{salitem_id}/salschemeitems/fetchdefault")
	public ResponseEntity<List<SalSchemeItemDTO>> fetchSalSchemeItemDefaultBySalItem(@PathVariable("salitem_id") String salitem_id,SalSchemeItemSearchContext context) {
        context.setN_salitemid_eq(salitem_id);
        Page<SalSchemeItem> domains = salschemeitemService.searchDefault(context) ;
        List<SalSchemeItemDTO> list = salschemeitemMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalSchemeItem-Default-all')")
	@ApiOperation(value = "根据薪酬要素项查询DEFAULT", tags = {"工资单要素项" } ,notes = "根据薪酬要素项查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salitems/{salitem_id}/salschemeitems/searchdefault")
	public ResponseEntity<Page<SalSchemeItemDTO>> searchSalSchemeItemDefaultBySalItem(@PathVariable("salitem_id") String salitem_id, @RequestBody SalSchemeItemSearchContext context) {
        context.setN_salitemid_eq(salitem_id);
        Page<SalSchemeItem> domains = salschemeitemService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salschemeitemMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.salschemeitemService.get(#salschemeitem_id),'ehr-SalSchemeItem-Update')")
    @ApiOperation(value = "根据工资单更新工资单要素项", tags = {"工资单要素项" },  notes = "根据工资单更新工资单要素项")
	@RequestMapping(method = RequestMethod.PUT, value = "/salschemes/{salscheme_id}/salschemeitems/{salschemeitem_id}")
    @Transactional
    public ResponseEntity<SalSchemeItemDTO> updateBySalScheme(@PathVariable("salscheme_id") String salscheme_id, @PathVariable("salschemeitem_id") String salschemeitem_id, @RequestBody SalSchemeItemDTO salschemeitemdto) {
        SalSchemeItem domain = salschemeitemMapping.toDomain(salschemeitemdto);
        domain.setSalschemeid(salscheme_id);
        domain.setSalschemeitemid(salschemeitem_id);
		salschemeitemService.update(domain);
        SalSchemeItemDTO dto = salschemeitemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.getSalschemeitemByEntities(this.salschemeitemMapping.toDomain(#salschemeitemdtos)),'ehr-SalSchemeItem-Update')")
    @ApiOperation(value = "根据工资单批量更新工资单要素项", tags = {"工资单要素项" },  notes = "根据工资单批量更新工资单要素项")
	@RequestMapping(method = RequestMethod.PUT, value = "/salschemes/{salscheme_id}/salschemeitems/batch")
    public ResponseEntity<Boolean> updateBatchBySalScheme(@PathVariable("salscheme_id") String salscheme_id, @RequestBody List<SalSchemeItemDTO> salschemeitemdtos) {
        List<SalSchemeItem> domainlist=salschemeitemMapping.toDomain(salschemeitemdtos);
        for(SalSchemeItem domain:domainlist){
            domain.setSalschemeid(salscheme_id);
        }
        salschemeitemService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdto),'ehr-SalSchemeItem-Save')")
    @ApiOperation(value = "根据工资单保存工资单要素项", tags = {"工资单要素项" },  notes = "根据工资单保存工资单要素项")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes/{salscheme_id}/salschemeitems/save")
    public ResponseEntity<Boolean> saveBySalScheme(@PathVariable("salscheme_id") String salscheme_id, @RequestBody SalSchemeItemDTO salschemeitemdto) {
        SalSchemeItem domain = salschemeitemMapping.toDomain(salschemeitemdto);
        domain.setSalschemeid(salscheme_id);
        return ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.save(domain));
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdtos),'ehr-SalSchemeItem-Save')")
    @ApiOperation(value = "根据工资单批量保存工资单要素项", tags = {"工资单要素项" },  notes = "根据工资单批量保存工资单要素项")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes/{salscheme_id}/salschemeitems/savebatch")
    public ResponseEntity<Boolean> saveBatchBySalScheme(@PathVariable("salscheme_id") String salscheme_id, @RequestBody List<SalSchemeItemDTO> salschemeitemdtos) {
        List<SalSchemeItem> domainlist=salschemeitemMapping.toDomain(salschemeitemdtos);
        for(SalSchemeItem domain:domainlist){
             domain.setSalschemeid(salscheme_id);
        }
        salschemeitemService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salschemeitemMapping.toDomain(returnObject.body),'ehr-SalSchemeItem-Get')")
    @ApiOperation(value = "根据工资单获取工资单要素项", tags = {"工资单要素项" },  notes = "根据工资单获取工资单要素项")
	@RequestMapping(method = RequestMethod.GET, value = "/salschemes/{salscheme_id}/salschemeitems/{salschemeitem_id}")
    public ResponseEntity<SalSchemeItemDTO> getBySalScheme(@PathVariable("salscheme_id") String salscheme_id, @PathVariable("salschemeitem_id") String salschemeitem_id) {
        SalSchemeItem domain = salschemeitemService.get(salschemeitem_id);
        SalSchemeItemDTO dto = salschemeitemMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.get(#salschemeitem_id),'ehr-SalSchemeItem-Remove')")
    @ApiOperation(value = "根据工资单删除工资单要素项", tags = {"工资单要素项" },  notes = "根据工资单删除工资单要素项")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salschemes/{salscheme_id}/salschemeitems/{salschemeitem_id}")
    @Transactional
    public ResponseEntity<Boolean> removeBySalScheme(@PathVariable("salscheme_id") String salscheme_id, @PathVariable("salschemeitem_id") String salschemeitem_id) {
		return ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.remove(salschemeitem_id));
    }

    @PreAuthorize("hasPermission(this.salschemeitemService.getSalschemeitemByIds(#ids),'ehr-SalSchemeItem-Remove')")
    @ApiOperation(value = "根据工资单批量删除工资单要素项", tags = {"工资单要素项" },  notes = "根据工资单批量删除工资单要素项")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salschemes/{salscheme_id}/salschemeitems/batch")
    public ResponseEntity<Boolean> removeBatchBySalScheme(@RequestBody List<String> ids) {
        salschemeitemService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据工资单检查工资单要素项", tags = {"工资单要素项" },  notes = "根据工资单检查工资单要素项")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes/{salscheme_id}/salschemeitems/checkkey")
    public ResponseEntity<Boolean> checkKeyBySalScheme(@PathVariable("salscheme_id") String salscheme_id, @RequestBody SalSchemeItemDTO salschemeitemdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salschemeitemService.checkKey(salschemeitemMapping.toDomain(salschemeitemdto)));
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdto),'ehr-SalSchemeItem-Create')")
    @ApiOperation(value = "根据工资单建立工资单要素项", tags = {"工资单要素项" },  notes = "根据工资单建立工资单要素项")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes/{salscheme_id}/salschemeitems")
    @Transactional
    public ResponseEntity<SalSchemeItemDTO> createBySalScheme(@PathVariable("salscheme_id") String salscheme_id, @RequestBody SalSchemeItemDTO salschemeitemdto) {
        SalSchemeItem domain = salschemeitemMapping.toDomain(salschemeitemdto);
        domain.setSalschemeid(salscheme_id);
		salschemeitemService.create(domain);
        SalSchemeItemDTO dto = salschemeitemMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salschemeitemMapping.toDomain(#salschemeitemdtos),'ehr-SalSchemeItem-Create')")
    @ApiOperation(value = "根据工资单批量建立工资单要素项", tags = {"工资单要素项" },  notes = "根据工资单批量建立工资单要素项")
	@RequestMapping(method = RequestMethod.POST, value = "/salschemes/{salscheme_id}/salschemeitems/batch")
    public ResponseEntity<Boolean> createBatchBySalScheme(@PathVariable("salscheme_id") String salscheme_id, @RequestBody List<SalSchemeItemDTO> salschemeitemdtos) {
        List<SalSchemeItem> domainlist=salschemeitemMapping.toDomain(salschemeitemdtos);
        for(SalSchemeItem domain:domainlist){
            domain.setSalschemeid(salscheme_id);
        }
        salschemeitemService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据工资单获取工资单要素项草稿", tags = {"工资单要素项" },  notes = "根据工资单获取工资单要素项草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/salschemes/{salscheme_id}/salschemeitems/getdraft")
    public ResponseEntity<SalSchemeItemDTO> getDraftBySalScheme(@PathVariable("salscheme_id") String salscheme_id) {
        SalSchemeItem domain = new SalSchemeItem();
        domain.setSalschemeid(salscheme_id);
        return ResponseEntity.status(HttpStatus.OK).body(salschemeitemMapping.toDto(salschemeitemService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalSchemeItem-Default-all')")
	@ApiOperation(value = "根据工资单获取DEFAULT", tags = {"工资单要素项" } ,notes = "根据工资单获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salschemes/{salscheme_id}/salschemeitems/fetchdefault")
	public ResponseEntity<List<SalSchemeItemDTO>> fetchSalSchemeItemDefaultBySalScheme(@PathVariable("salscheme_id") String salscheme_id,SalSchemeItemSearchContext context) {
        context.setN_salschemeid_eq(salscheme_id);
        Page<SalSchemeItem> domains = salschemeitemService.searchDefault(context) ;
        List<SalSchemeItemDTO> list = salschemeitemMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalSchemeItem-Default-all')")
	@ApiOperation(value = "根据工资单查询DEFAULT", tags = {"工资单要素项" } ,notes = "根据工资单查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salschemes/{salscheme_id}/salschemeitems/searchdefault")
	public ResponseEntity<Page<SalSchemeItemDTO>> searchSalSchemeItemDefaultBySalScheme(@PathVariable("salscheme_id") String salscheme_id, @RequestBody SalSchemeItemSearchContext context) {
        context.setN_salschemeid_eq(salscheme_id);
        Page<SalSchemeItem> domains = salschemeitemService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salschemeitemMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

