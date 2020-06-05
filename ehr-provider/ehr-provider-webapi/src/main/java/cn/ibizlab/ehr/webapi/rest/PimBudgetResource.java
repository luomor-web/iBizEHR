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
import cn.ibizlab.ehr.core.pim.domain.PimBudget;
import cn.ibizlab.ehr.core.pim.service.IPimBudgetService;
import cn.ibizlab.ehr.core.pim.filter.PimBudgetSearchContext;

@Slf4j
@Api(tags = {"年度预算" })
@RestController("WebApi-pimbudget")
@RequestMapping("")
public class PimBudgetResource {

    @Autowired
    public IPimBudgetService pimbudgetService;

    @Autowired
    @Lazy
    public PimBudgetMapping pimbudgetMapping;

    @ApiOperation(value = "检查年度预算", tags = {"年度预算" },  notes = "检查年度预算")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbudgets/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimBudgetDTO pimbudgetdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimbudgetService.checkKey(pimbudgetMapping.toDomain(pimbudgetdto)));
    }

    @PreAuthorize("hasPermission(this.pimbudgetMapping.toDomain(#pimbudgetdto),'ehr-PimBudget-Save')")
    @ApiOperation(value = "保存年度预算", tags = {"年度预算" },  notes = "保存年度预算")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbudgets/save")
    public ResponseEntity<Boolean> save(@RequestBody PimBudgetDTO pimbudgetdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimbudgetService.save(pimbudgetMapping.toDomain(pimbudgetdto)));
    }

    @PreAuthorize("hasPermission(this.pimbudgetMapping.toDomain(#pimbudgetdtos),'ehr-PimBudget-Save')")
    @ApiOperation(value = "批量保存年度预算", tags = {"年度预算" },  notes = "批量保存年度预算")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbudgets/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimBudgetDTO> pimbudgetdtos) {
        pimbudgetService.saveBatch(pimbudgetMapping.toDomain(pimbudgetdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimbudgetMapping.toDomain(#pimbudgetdto),'ehr-PimBudget-Create')")
    @ApiOperation(value = "新建年度预算", tags = {"年度预算" },  notes = "新建年度预算")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbudgets")
    @Transactional
    public ResponseEntity<PimBudgetDTO> create(@RequestBody PimBudgetDTO pimbudgetdto) {
        PimBudget domain = pimbudgetMapping.toDomain(pimbudgetdto);
		pimbudgetService.create(domain);
        PimBudgetDTO dto = pimbudgetMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimbudgetMapping.toDomain(#pimbudgetdtos),'ehr-PimBudget-Create')")
    @ApiOperation(value = "批量新建年度预算", tags = {"年度预算" },  notes = "批量新建年度预算")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbudgets/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimBudgetDTO> pimbudgetdtos) {
        pimbudgetService.createBatch(pimbudgetMapping.toDomain(pimbudgetdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取年度预算草稿", tags = {"年度预算" },  notes = "获取年度预算草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimbudgets/getdraft")
    public ResponseEntity<PimBudgetDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimbudgetMapping.toDto(pimbudgetService.getDraft(new PimBudget())));
    }

    @PreAuthorize("hasPermission(this.pimbudgetService.get(#pimbudget_id),'ehr-PimBudget-Update')")
    @ApiOperation(value = "更新年度预算", tags = {"年度预算" },  notes = "更新年度预算")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbudgets/{pimbudget_id}")
    @Transactional
    public ResponseEntity<PimBudgetDTO> update(@PathVariable("pimbudget_id") String pimbudget_id, @RequestBody PimBudgetDTO pimbudgetdto) {
		PimBudget domain  = pimbudgetMapping.toDomain(pimbudgetdto);
        domain .setBudgetid(pimbudget_id);
		pimbudgetService.update(domain );
		PimBudgetDTO dto = pimbudgetMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimbudgetService.getPimbudgetByEntities(this.pimbudgetMapping.toDomain(#pimbudgetdtos)),'ehr-PimBudget-Update')")
    @ApiOperation(value = "批量更新年度预算", tags = {"年度预算" },  notes = "批量更新年度预算")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbudgets/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimBudgetDTO> pimbudgetdtos) {
        pimbudgetService.updateBatch(pimbudgetMapping.toDomain(pimbudgetdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimbudgetMapping.toDomain(returnObject.body),'ehr-PimBudget-Get')")
    @ApiOperation(value = "获取年度预算", tags = {"年度预算" },  notes = "获取年度预算")
	@RequestMapping(method = RequestMethod.GET, value = "/pimbudgets/{pimbudget_id}")
    public ResponseEntity<PimBudgetDTO> get(@PathVariable("pimbudget_id") String pimbudget_id) {
        PimBudget domain = pimbudgetService.get(pimbudget_id);
        PimBudgetDTO dto = pimbudgetMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimbudgetService.get(#pimbudget_id),'ehr-PimBudget-Remove')")
    @ApiOperation(value = "删除年度预算", tags = {"年度预算" },  notes = "删除年度预算")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimbudgets/{pimbudget_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimbudget_id") String pimbudget_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimbudgetService.remove(pimbudget_id));
    }

    @PreAuthorize("hasPermission(this.pimbudgetService.getPimbudgetByIds(#ids),'ehr-PimBudget-Remove')")
    @ApiOperation(value = "批量删除年度预算", tags = {"年度预算" },  notes = "批量删除年度预算")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimbudgets/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimbudgetService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimBudget-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"年度预算" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimbudgets/fetchdefault")
	public ResponseEntity<List<PimBudgetDTO>> fetchDefault(PimBudgetSearchContext context) {
        Page<PimBudget> domains = pimbudgetService.searchDefault(context) ;
        List<PimBudgetDTO> list = pimbudgetMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimBudget-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"年度预算" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimbudgets/searchdefault")
	public ResponseEntity<Page<PimBudgetDTO>> searchDefault(@RequestBody PimBudgetSearchContext context) {
        Page<PimBudget> domains = pimbudgetService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbudgetMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

