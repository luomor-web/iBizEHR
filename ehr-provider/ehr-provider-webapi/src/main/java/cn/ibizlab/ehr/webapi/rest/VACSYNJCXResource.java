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
import cn.ibizlab.ehr.core.vac.domain.VACSYNJCX;
import cn.ibizlab.ehr.core.vac.service.IVACSYNJCXService;
import cn.ibizlab.ehr.core.vac.filter.VACSYNJCXSearchContext;

@Slf4j
@Api(tags = {"年休假查询" })
@RestController("WebApi-vacsynjcx")
@RequestMapping("")
public class VACSYNJCXResource {

    @Autowired
    public IVACSYNJCXService vacsynjcxService;

    @Autowired
    @Lazy
    public VACSYNJCXMapping vacsynjcxMapping;

    @PreAuthorize("hasPermission(this.vacsynjcxService.get(#vacsynjcx_id),'ehr-VACSYNJCX-Remove')")
    @ApiOperation(value = "删除年休假查询", tags = {"年休假查询" },  notes = "删除年休假查询")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacsynjcxes/{vacsynjcx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("vacsynjcx_id") String vacsynjcx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(vacsynjcxService.remove(vacsynjcx_id));
    }

    @PreAuthorize("hasPermission(this.vacsynjcxService.getVacsynjcxByIds(#ids),'ehr-VACSYNJCX-Remove')")
    @ApiOperation(value = "批量删除年休假查询", tags = {"年休假查询" },  notes = "批量删除年休假查询")
	@RequestMapping(method = RequestMethod.DELETE, value = "/vacsynjcxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        vacsynjcxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.vacsynjcxService.get(#vacsynjcx_id),'ehr-VACSYNJCX-Update')")
    @ApiOperation(value = "更新年休假查询", tags = {"年休假查询" },  notes = "更新年休假查询")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacsynjcxes/{vacsynjcx_id}")
    @Transactional
    public ResponseEntity<VACSYNJCXDTO> update(@PathVariable("vacsynjcx_id") String vacsynjcx_id, @RequestBody VACSYNJCXDTO vacsynjcxdto) {
		VACSYNJCX domain  = vacsynjcxMapping.toDomain(vacsynjcxdto);
        domain .setVacsynjcxid(vacsynjcx_id);
		vacsynjcxService.update(domain );
		VACSYNJCXDTO dto = vacsynjcxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacsynjcxService.getVacsynjcxByEntities(this.vacsynjcxMapping.toDomain(#vacsynjcxdtos)),'ehr-VACSYNJCX-Update')")
    @ApiOperation(value = "批量更新年休假查询", tags = {"年休假查询" },  notes = "批量更新年休假查询")
	@RequestMapping(method = RequestMethod.PUT, value = "/vacsynjcxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<VACSYNJCXDTO> vacsynjcxdtos) {
        vacsynjcxService.updateBatch(vacsynjcxMapping.toDomain(vacsynjcxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查年休假查询", tags = {"年休假查询" },  notes = "检查年休假查询")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsynjcxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody VACSYNJCXDTO vacsynjcxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(vacsynjcxService.checkKey(vacsynjcxMapping.toDomain(vacsynjcxdto)));
    }

    @PostAuthorize("hasPermission(this.vacsynjcxMapping.toDomain(returnObject.body),'ehr-VACSYNJCX-Get')")
    @ApiOperation(value = "获取年休假查询", tags = {"年休假查询" },  notes = "获取年休假查询")
	@RequestMapping(method = RequestMethod.GET, value = "/vacsynjcxes/{vacsynjcx_id}")
    public ResponseEntity<VACSYNJCXDTO> get(@PathVariable("vacsynjcx_id") String vacsynjcx_id) {
        VACSYNJCX domain = vacsynjcxService.get(vacsynjcx_id);
        VACSYNJCXDTO dto = vacsynjcxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacsynjcxMapping.toDomain(#vacsynjcxdto),'ehr-VACSYNJCX-Save')")
    @ApiOperation(value = "保存年休假查询", tags = {"年休假查询" },  notes = "保存年休假查询")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsynjcxes/save")
    public ResponseEntity<Boolean> save(@RequestBody VACSYNJCXDTO vacsynjcxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(vacsynjcxService.save(vacsynjcxMapping.toDomain(vacsynjcxdto)));
    }

    @PreAuthorize("hasPermission(this.vacsynjcxMapping.toDomain(#vacsynjcxdtos),'ehr-VACSYNJCX-Save')")
    @ApiOperation(value = "批量保存年休假查询", tags = {"年休假查询" },  notes = "批量保存年休假查询")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsynjcxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<VACSYNJCXDTO> vacsynjcxdtos) {
        vacsynjcxService.saveBatch(vacsynjcxMapping.toDomain(vacsynjcxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACSYNJCX-JSTS-all')")
    @ApiOperation(value = "计算剩余天数", tags = {"年休假查询" },  notes = "计算剩余天数")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsynjcxes/{vacsynjcx_id}/jsts")
    @Transactional
    public ResponseEntity<VACSYNJCXDTO> jSTS(@PathVariable("vacsynjcx_id") String vacsynjcx_id, @RequestBody VACSYNJCXDTO vacsynjcxdto) {
        VACSYNJCX vacsynjcx = vacsynjcxMapping.toDomain(vacsynjcxdto);
        vacsynjcx.setVacsynjcxid(vacsynjcx_id);
        vacsynjcx = vacsynjcxService.jSTS(vacsynjcx);
        vacsynjcxdto = vacsynjcxMapping.toDto(vacsynjcx);
        return ResponseEntity.status(HttpStatus.OK).body(vacsynjcxdto);
    }

    @PreAuthorize("hasPermission(this.vacsynjcxMapping.toDomain(#vacsynjcxdto),'ehr-VACSYNJCX-Create')")
    @ApiOperation(value = "新建年休假查询", tags = {"年休假查询" },  notes = "新建年休假查询")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsynjcxes")
    @Transactional
    public ResponseEntity<VACSYNJCXDTO> create(@RequestBody VACSYNJCXDTO vacsynjcxdto) {
        VACSYNJCX domain = vacsynjcxMapping.toDomain(vacsynjcxdto);
		vacsynjcxService.create(domain);
        VACSYNJCXDTO dto = vacsynjcxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.vacsynjcxMapping.toDomain(#vacsynjcxdtos),'ehr-VACSYNJCX-Create')")
    @ApiOperation(value = "批量新建年休假查询", tags = {"年休假查询" },  notes = "批量新建年休假查询")
	@RequestMapping(method = RequestMethod.POST, value = "/vacsynjcxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<VACSYNJCXDTO> vacsynjcxdtos) {
        vacsynjcxService.createBatch(vacsynjcxMapping.toDomain(vacsynjcxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取年休假查询草稿", tags = {"年休假查询" },  notes = "获取年休假查询草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/vacsynjcxes/getdraft")
    public ResponseEntity<VACSYNJCXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(vacsynjcxMapping.toDto(vacsynjcxService.getDraft(new VACSYNJCX())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACSYNJCX-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"年休假查询" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/vacsynjcxes/fetchdefault")
	public ResponseEntity<List<VACSYNJCXDTO>> fetchDefault(VACSYNJCXSearchContext context) {
        Page<VACSYNJCX> domains = vacsynjcxService.searchDefault(context) ;
        List<VACSYNJCXDTO> list = vacsynjcxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-VACSYNJCX-Default-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"年休假查询" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/vacsynjcxes/searchdefault")
	public ResponseEntity<Page<VACSYNJCXDTO>> searchDefault(@RequestBody VACSYNJCXSearchContext context) {
        Page<VACSYNJCX> domains = vacsynjcxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(vacsynjcxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

