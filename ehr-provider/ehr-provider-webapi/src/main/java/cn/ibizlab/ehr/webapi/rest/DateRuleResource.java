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
import cn.ibizlab.ehr.core.pim.domain.DateRule;
import cn.ibizlab.ehr.core.pim.service.IDateRuleService;
import cn.ibizlab.ehr.core.pim.filter.DateRuleSearchContext;




@Slf4j
@Api(tags = {"DateRule" })
@RestController("WebApi-daterule")
@RequestMapping("")
public class DateRuleResource {

    @Autowired
    private IDateRuleService dateruleService;

    @Autowired
    @Lazy
    private DateRuleMapping dateruleMapping;




    @ApiOperation(value = "GetDraft", tags = {"DateRule" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/daterules/getdraft")
    public ResponseEntity<DateRuleDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(dateruleMapping.toDto(dateruleService.getDraft(new DateRule())));
    }




    @PreAuthorize("hasPermission(#daterule_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"DateRule" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/daterules/{daterule_id}")
    @Transactional
    public ResponseEntity<DateRuleDTO> update(@PathVariable("daterule_id") String daterule_id, @RequestBody DateRuleDTO dateruledto) {
		DateRule domain = dateruleMapping.toDomain(dateruledto);
        domain.setDateruleid(daterule_id);
		dateruleService.update(domain);
		DateRuleDTO dto = dateruleMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#daterule_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"DateRule" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/daterules/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<DateRuleDTO> dateruledtos) {
        dateruleService.updateBatch(dateruleMapping.toDomain(dateruledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#daterule_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"DateRule" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/daterules/{daterule_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("daterule_id") String daterule_id) {
         return ResponseEntity.status(HttpStatus.OK).body(dateruleService.remove(daterule_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"DateRule" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/daterules/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        dateruleService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"DateRule" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/daterules")
    @Transactional
    public ResponseEntity<DateRuleDTO> create(@RequestBody DateRuleDTO dateruledto) {
        DateRule domain = dateruleMapping.toDomain(dateruledto);
		dateruleService.create(domain);
        DateRuleDTO dto = dateruleMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"DateRule" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/daterules/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<DateRuleDTO> dateruledtos) {
        dateruleService.createBatch(dateruleMapping.toDomain(dateruledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"DateRule" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/daterules/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody DateRuleDTO dateruledto) {
        return  ResponseEntity.status(HttpStatus.OK).body(dateruleService.checkKey(dateruleMapping.toDomain(dateruledto)));
    }




    @ApiOperation(value = "Save", tags = {"DateRule" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/daterules/save")
    public ResponseEntity<Boolean> save(@RequestBody DateRuleDTO dateruledto) {
        return ResponseEntity.status(HttpStatus.OK).body(dateruleService.save(dateruleMapping.toDomain(dateruledto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"DateRule" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/daterules/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DateRuleDTO> dateruledtos) {
        dateruleService.saveBatch(dateruleMapping.toDomain(dateruledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#daterule_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"DateRule" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/daterules/{daterule_id}")
    public ResponseEntity<DateRuleDTO> get(@PathVariable("daterule_id") String daterule_id) {
        DateRule domain = dateruleService.get(daterule_id);
        DateRuleDTO dto = dateruleMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

	@ApiOperation(value = "fetchDEFAULT", tags = {"DateRule" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/daterules/fetchdefault")
	public ResponseEntity<List<DateRuleDTO>> fetchDefault(DateRuleSearchContext context) {
        Page<DateRule> domains = dateruleService.searchDefault(context) ;
        List<DateRuleDTO> list = dateruleMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "searchDEFAULT", tags = {"DateRule" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/daterules/searchdefault")
	public ResponseEntity<Page<DateRuleDTO>> searchDefault(@RequestBody DateRuleSearchContext context) {
        Page<DateRule> domains = dateruleService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(dateruleMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public DateRule getEntity(){
        return new DateRule();
    }

}
