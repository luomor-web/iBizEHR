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
@Api(tags = {"BUDGET" })
@RestController("WebApi-budget")
@RequestMapping("")
public class BUDGETResource {

    @Autowired
    private IBUDGETService budgetService;

    @Autowired
    @Lazy
    private BUDGETMapping budgetMapping;




    @ApiOperation(value = "CheckKey", tags = {"BUDGET" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/budgets/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody BUDGETDTO budgetdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(budgetService.checkKey(budgetMapping.toDomain(budgetdto)));
    }




    @ApiOperation(value = "Save", tags = {"BUDGET" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/budgets/save")
    public ResponseEntity<Boolean> save(@RequestBody BUDGETDTO budgetdto) {
        return ResponseEntity.status(HttpStatus.OK).body(budgetService.save(budgetMapping.toDomain(budgetdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"BUDGET" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/budgets/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<BUDGETDTO> budgetdtos) {
        budgetService.saveBatch(budgetMapping.toDomain(budgetdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"BUDGET" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/budgets")
    @Transactional
    public ResponseEntity<BUDGETDTO> create(@RequestBody BUDGETDTO budgetdto) {
        BUDGET domain = budgetMapping.toDomain(budgetdto);
		budgetService.create(domain);
        BUDGETDTO dto = budgetMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"BUDGET" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/budgets/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<BUDGETDTO> budgetdtos) {
        budgetService.createBatch(budgetMapping.toDomain(budgetdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "GetDraft", tags = {"BUDGET" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/budgets/getdraft")
    public ResponseEntity<BUDGETDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(budgetMapping.toDto(budgetService.getDraft(new BUDGET())));
    }




    @PreAuthorize("hasPermission(#budget_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"BUDGET" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/budgets/{budget_id}")
    @Transactional
    public ResponseEntity<BUDGETDTO> update(@PathVariable("budget_id") String budget_id, @RequestBody BUDGETDTO budgetdto) {
		BUDGET domain = budgetMapping.toDomain(budgetdto);
        domain.setBudgetid(budget_id);
		budgetService.update(domain);
		BUDGETDTO dto = budgetMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#budget_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"BUDGET" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/budgets/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<BUDGETDTO> budgetdtos) {
        budgetService.updateBatch(budgetMapping.toDomain(budgetdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#budget_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"BUDGET" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/budgets/{budget_id}")
    public ResponseEntity<BUDGETDTO> get(@PathVariable("budget_id") String budget_id) {
        BUDGET domain = budgetService.get(budget_id);
        BUDGETDTO dto = budgetMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#budget_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"BUDGET" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/budgets/{budget_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("budget_id") String budget_id) {
         return ResponseEntity.status(HttpStatus.OK).body(budgetService.remove(budget_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"BUDGET" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/budgets/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        budgetService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-BUDGET-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"BUDGET" } ,notes = "fetchDEFAULT")
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
	@ApiOperation(value = "searchDEFAULT", tags = {"BUDGET" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/budgets/searchdefault")
	public ResponseEntity<Page<BUDGETDTO>> searchDefault(@RequestBody BUDGETSearchContext context) {
        Page<BUDGET> domains = budgetService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(budgetMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public BUDGET getEntity(){
        return new BUDGET();
    }

}
