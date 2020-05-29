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
import cn.ibizlab.ehr.core.pim.domain.DateRule;
import cn.ibizlab.ehr.core.pim.service.IDateRuleService;
import cn.ibizlab.ehr.core.pim.filter.DateRuleSearchContext;

@Slf4j
@Api(tags = {"生效日期规则" })
@RestController("WebApi-daterule")
@RequestMapping("")
public class DateRuleResource {

    @Autowired
    public IDateRuleService dateruleService;

    @Autowired
    @Lazy
    public DateRuleMapping dateruleMapping;

    @ApiOperation(value = "获取生效日期规则草稿", tags = {"生效日期规则" },  notes = "获取生效日期规则草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/daterules/getdraft")
    public ResponseEntity<DateRuleDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(dateruleMapping.toDto(dateruleService.getDraft(new DateRule())));
    }

    @PreAuthorize("hasPermission(this.dateruleService.get(#daterule_id),'ehr-DateRule-Update')")
    @ApiOperation(value = "更新生效日期规则", tags = {"生效日期规则" },  notes = "更新生效日期规则")
	@RequestMapping(method = RequestMethod.PUT, value = "/daterules/{daterule_id}")
    @Transactional
    public ResponseEntity<DateRuleDTO> update(@PathVariable("daterule_id") String daterule_id, @RequestBody DateRuleDTO dateruledto) {
		DateRule domain  = dateruleMapping.toDomain(dateruledto);
        domain .setDateruleid(daterule_id);
		dateruleService.update(domain );
		DateRuleDTO dto = dateruleMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.dateruleService.getDateruleByEntities(this.dateruleMapping.toDomain(#dateruledtos)),'ehr-DateRule-Update')")
    @ApiOperation(value = "批量更新生效日期规则", tags = {"生效日期规则" },  notes = "批量更新生效日期规则")
	@RequestMapping(method = RequestMethod.PUT, value = "/daterules/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<DateRuleDTO> dateruledtos) {
        dateruleService.updateBatch(dateruleMapping.toDomain(dateruledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.dateruleService.get(#daterule_id),'ehr-DateRule-Remove')")
    @ApiOperation(value = "删除生效日期规则", tags = {"生效日期规则" },  notes = "删除生效日期规则")
	@RequestMapping(method = RequestMethod.DELETE, value = "/daterules/{daterule_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("daterule_id") String daterule_id) {
         return ResponseEntity.status(HttpStatus.OK).body(dateruleService.remove(daterule_id));
    }

    @PreAuthorize("hasPermission(this.dateruleService.getDateruleByIds(#ids),'ehr-DateRule-Remove')")
    @ApiOperation(value = "批量删除生效日期规则", tags = {"生效日期规则" },  notes = "批量删除生效日期规则")
	@RequestMapping(method = RequestMethod.DELETE, value = "/daterules/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        dateruleService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.dateruleMapping.toDomain(#dateruledto),'ehr-DateRule-Create')")
    @ApiOperation(value = "新建生效日期规则", tags = {"生效日期规则" },  notes = "新建生效日期规则")
	@RequestMapping(method = RequestMethod.POST, value = "/daterules")
    @Transactional
    public ResponseEntity<DateRuleDTO> create(@RequestBody DateRuleDTO dateruledto) {
        DateRule domain = dateruleMapping.toDomain(dateruledto);
		dateruleService.create(domain);
        DateRuleDTO dto = dateruleMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.dateruleMapping.toDomain(#dateruledtos),'ehr-DateRule-Create')")
    @ApiOperation(value = "批量新建生效日期规则", tags = {"生效日期规则" },  notes = "批量新建生效日期规则")
	@RequestMapping(method = RequestMethod.POST, value = "/daterules/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<DateRuleDTO> dateruledtos) {
        dateruleService.createBatch(dateruleMapping.toDomain(dateruledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查生效日期规则", tags = {"生效日期规则" },  notes = "检查生效日期规则")
	@RequestMapping(method = RequestMethod.POST, value = "/daterules/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody DateRuleDTO dateruledto) {
        return  ResponseEntity.status(HttpStatus.OK).body(dateruleService.checkKey(dateruleMapping.toDomain(dateruledto)));
    }

    @PreAuthorize("hasPermission(this.dateruleMapping.toDomain(#dateruledto),'ehr-DateRule-Save')")
    @ApiOperation(value = "保存生效日期规则", tags = {"生效日期规则" },  notes = "保存生效日期规则")
	@RequestMapping(method = RequestMethod.POST, value = "/daterules/save")
    public ResponseEntity<Boolean> save(@RequestBody DateRuleDTO dateruledto) {
        return ResponseEntity.status(HttpStatus.OK).body(dateruleService.save(dateruleMapping.toDomain(dateruledto)));
    }

    @PreAuthorize("hasPermission(this.dateruleMapping.toDomain(#dateruledtos),'ehr-DateRule-Save')")
    @ApiOperation(value = "批量保存生效日期规则", tags = {"生效日期规则" },  notes = "批量保存生效日期规则")
	@RequestMapping(method = RequestMethod.POST, value = "/daterules/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DateRuleDTO> dateruledtos) {
        dateruleService.saveBatch(dateruleMapping.toDomain(dateruledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.dateruleMapping.toDomain(returnObject.body),'ehr-DateRule-Get')")
    @ApiOperation(value = "获取生效日期规则", tags = {"生效日期规则" },  notes = "获取生效日期规则")
	@RequestMapping(method = RequestMethod.GET, value = "/daterules/{daterule_id}")
    public ResponseEntity<DateRuleDTO> get(@PathVariable("daterule_id") String daterule_id) {
        DateRule domain = dateruleService.get(daterule_id);
        DateRuleDTO dto = dateruleMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DateRule-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"生效日期规则" } ,notes = "获取{deds.getLogicName()}")
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

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-DateRule-Default-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"生效日期规则" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/daterules/searchdefault")
	public ResponseEntity<Page<DateRuleDTO>> searchDefault(@RequestBody DateRuleSearchContext context) {
        Page<DateRule> domains = dateruleService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(dateruleMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

