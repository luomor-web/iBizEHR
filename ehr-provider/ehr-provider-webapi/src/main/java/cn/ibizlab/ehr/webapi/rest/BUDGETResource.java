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
import cn.ibizlab.ehr.core.pim.domain.BUDGET;
import cn.ibizlab.ehr.core.pim.service.IBUDGETService;
import cn.ibizlab.ehr.core.pim.filter.BUDGETSearchContext;

@Slf4j
@Api(tags = {"年度预算" })
@RestController("WebApi-budget")
@RequestMapping("")
public class BUDGETResource {

    @Autowired
    public IBUDGETService budgetService;

    @Autowired
    @Lazy
    public BUDGETMapping budgetMapping;

    @ApiOperation(value = "检查年度预算", tags = {"年度预算" },  notes = "检查年度预算")
	@RequestMapping(method = RequestMethod.POST, value = "/budgets/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody BUDGETDTO budgetdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(budgetService.checkKey(budgetMapping.toDomain(budgetdto)));
    }

    @PreAuthorize("hasPermission(this.budgetMapping.toDomain(#budgetdto),'ehr-BUDGET-Save')")
    @ApiOperation(value = "保存年度预算", tags = {"年度预算" },  notes = "保存年度预算")
	@RequestMapping(method = RequestMethod.POST, value = "/budgets/save")
    public ResponseEntity<Boolean> save(@RequestBody BUDGETDTO budgetdto) {
        return ResponseEntity.status(HttpStatus.OK).body(budgetService.save(budgetMapping.toDomain(budgetdto)));
    }

    @PreAuthorize("hasPermission(this.budgetMapping.toDomain(#budgetdtos),'ehr-BUDGET-Save')")
    @ApiOperation(value = "批量保存年度预算", tags = {"年度预算" },  notes = "批量保存年度预算")
	@RequestMapping(method = RequestMethod.POST, value = "/budgets/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<BUDGETDTO> budgetdtos) {
        budgetService.saveBatch(budgetMapping.toDomain(budgetdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.budgetMapping.toDomain(#budgetdto),'ehr-BUDGET-Create')")
    @ApiOperation(value = "新建年度预算", tags = {"年度预算" },  notes = "新建年度预算")
	@RequestMapping(method = RequestMethod.POST, value = "/budgets")
    @Transactional
    public ResponseEntity<BUDGETDTO> create(@RequestBody BUDGETDTO budgetdto) {
        BUDGET domain = budgetMapping.toDomain(budgetdto);
		budgetService.create(domain);
        BUDGETDTO dto = budgetMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.budgetMapping.toDomain(#budgetdtos),'ehr-BUDGET-Create')")
    @ApiOperation(value = "批量新建年度预算", tags = {"年度预算" },  notes = "批量新建年度预算")
	@RequestMapping(method = RequestMethod.POST, value = "/budgets/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<BUDGETDTO> budgetdtos) {
        budgetService.createBatch(budgetMapping.toDomain(budgetdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取年度预算草稿", tags = {"年度预算" },  notes = "获取年度预算草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/budgets/getdraft")
    public ResponseEntity<BUDGETDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(budgetMapping.toDto(budgetService.getDraft(new BUDGET())));
    }

    @PreAuthorize("hasPermission(this.budgetService.get(#budget_id),'ehr-BUDGET-Update')")
    @ApiOperation(value = "更新年度预算", tags = {"年度预算" },  notes = "更新年度预算")
	@RequestMapping(method = RequestMethod.PUT, value = "/budgets/{budget_id}")
    @Transactional
    public ResponseEntity<BUDGETDTO> update(@PathVariable("budget_id") String budget_id, @RequestBody BUDGETDTO budgetdto) {
		BUDGET domain  = budgetMapping.toDomain(budgetdto);
        domain .setBudgetid(budget_id);
		budgetService.update(domain );
		BUDGETDTO dto = budgetMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.budgetService.getBudgetByEntities(this.budgetMapping.toDomain(#budgetdtos)),'ehr-BUDGET-Update')")
    @ApiOperation(value = "批量更新年度预算", tags = {"年度预算" },  notes = "批量更新年度预算")
	@RequestMapping(method = RequestMethod.PUT, value = "/budgets/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<BUDGETDTO> budgetdtos) {
        budgetService.updateBatch(budgetMapping.toDomain(budgetdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.budgetMapping.toDomain(returnObject.body),'ehr-BUDGET-Get')")
    @ApiOperation(value = "获取年度预算", tags = {"年度预算" },  notes = "获取年度预算")
	@RequestMapping(method = RequestMethod.GET, value = "/budgets/{budget_id}")
    public ResponseEntity<BUDGETDTO> get(@PathVariable("budget_id") String budget_id) {
        BUDGET domain = budgetService.get(budget_id);
        BUDGETDTO dto = budgetMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.budgetService.get(#budget_id),'ehr-BUDGET-Remove')")
    @ApiOperation(value = "删除年度预算", tags = {"年度预算" },  notes = "删除年度预算")
	@RequestMapping(method = RequestMethod.DELETE, value = "/budgets/{budget_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("budget_id") String budget_id) {
         return ResponseEntity.status(HttpStatus.OK).body(budgetService.remove(budget_id));
    }

    @PreAuthorize("hasPermission(this.budgetService.getBudgetByIds(#ids),'ehr-BUDGET-Remove')")
    @ApiOperation(value = "批量删除年度预算", tags = {"年度预算" },  notes = "批量删除年度预算")
	@RequestMapping(method = RequestMethod.DELETE, value = "/budgets/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        budgetService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-BUDGET-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"年度预算" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/budgets/fetchdefault")
	public ResponseEntity<List<BUDGETDTO>> fetchDefault(BUDGETSearchContext context) {
        Page<BUDGET> domains = budgetService.searchDefault(context) ;
        List<BUDGETDTO> list = budgetMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-BUDGET-Default-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"年度预算" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/budgets/searchdefault")
	public ResponseEntity<Page<BUDGETDTO>> searchDefault(@RequestBody BUDGETSearchContext context) {
        Page<BUDGET> domains = budgetService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(budgetMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

