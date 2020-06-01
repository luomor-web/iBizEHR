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
import cn.ibizlab.ehr.core.sal.domain.SalRule;
import cn.ibizlab.ehr.core.sal.service.ISalRuleService;
import cn.ibizlab.ehr.core.sal.filter.SalRuleSearchContext;

@Slf4j
@Api(tags = {"薪酬规则" })
@RestController("WebApi-salrule")
@RequestMapping("")
public class SalRuleResource {

    @Autowired
    public ISalRuleService salruleService;

    @Autowired
    @Lazy
    public SalRuleMapping salruleMapping;

    @ApiOperation(value = "获取薪酬规则草稿", tags = {"薪酬规则" },  notes = "获取薪酬规则草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/salrules/getdraft")
    public ResponseEntity<SalRuleDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(salruleMapping.toDto(salruleService.getDraft(new SalRule())));
    }

    @PreAuthorize("hasPermission(this.salruleService.get(#salrule_id),'ehr-SalRule-Remove')")
    @ApiOperation(value = "删除薪酬规则", tags = {"薪酬规则" },  notes = "删除薪酬规则")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salrules/{salrule_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("salrule_id") String salrule_id) {
         return ResponseEntity.status(HttpStatus.OK).body(salruleService.remove(salrule_id));
    }

    @PreAuthorize("hasPermission(this.salruleService.getSalruleByIds(#ids),'ehr-SalRule-Remove')")
    @ApiOperation(value = "批量删除薪酬规则", tags = {"薪酬规则" },  notes = "批量删除薪酬规则")
	@RequestMapping(method = RequestMethod.DELETE, value = "/salrules/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        salruleService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.salruleMapping.toDomain(returnObject.body),'ehr-SalRule-Get')")
    @ApiOperation(value = "获取薪酬规则", tags = {"薪酬规则" },  notes = "获取薪酬规则")
	@RequestMapping(method = RequestMethod.GET, value = "/salrules/{salrule_id}")
    public ResponseEntity<SalRuleDTO> get(@PathVariable("salrule_id") String salrule_id) {
        SalRule domain = salruleService.get(salrule_id);
        SalRuleDTO dto = salruleMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salruleMapping.toDomain(#salruledto),'ehr-SalRule-Create')")
    @ApiOperation(value = "新建薪酬规则", tags = {"薪酬规则" },  notes = "新建薪酬规则")
	@RequestMapping(method = RequestMethod.POST, value = "/salrules")
    @Transactional
    public ResponseEntity<SalRuleDTO> create(@RequestBody SalRuleDTO salruledto) {
        SalRule domain = salruleMapping.toDomain(salruledto);
		salruleService.create(domain);
        SalRuleDTO dto = salruleMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salruleMapping.toDomain(#salruledtos),'ehr-SalRule-Create')")
    @ApiOperation(value = "批量新建薪酬规则", tags = {"薪酬规则" },  notes = "批量新建薪酬规则")
	@RequestMapping(method = RequestMethod.POST, value = "/salrules/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SalRuleDTO> salruledtos) {
        salruleService.createBatch(salruleMapping.toDomain(salruledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salruleService.get(#salrule_id),'ehr-SalRule-Update')")
    @ApiOperation(value = "更新薪酬规则", tags = {"薪酬规则" },  notes = "更新薪酬规则")
	@RequestMapping(method = RequestMethod.PUT, value = "/salrules/{salrule_id}")
    @Transactional
    public ResponseEntity<SalRuleDTO> update(@PathVariable("salrule_id") String salrule_id, @RequestBody SalRuleDTO salruledto) {
		SalRule domain  = salruleMapping.toDomain(salruledto);
        domain .setSalruleid(salrule_id);
		salruleService.update(domain );
		SalRuleDTO dto = salruleMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.salruleService.getSalruleByEntities(this.salruleMapping.toDomain(#salruledtos)),'ehr-SalRule-Update')")
    @ApiOperation(value = "批量更新薪酬规则", tags = {"薪酬规则" },  notes = "批量更新薪酬规则")
	@RequestMapping(method = RequestMethod.PUT, value = "/salrules/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SalRuleDTO> salruledtos) {
        salruleService.updateBatch(salruleMapping.toDomain(salruledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.salruleMapping.toDomain(#salruledto),'ehr-SalRule-Save')")
    @ApiOperation(value = "保存薪酬规则", tags = {"薪酬规则" },  notes = "保存薪酬规则")
	@RequestMapping(method = RequestMethod.POST, value = "/salrules/save")
    public ResponseEntity<Boolean> save(@RequestBody SalRuleDTO salruledto) {
        return ResponseEntity.status(HttpStatus.OK).body(salruleService.save(salruleMapping.toDomain(salruledto)));
    }

    @PreAuthorize("hasPermission(this.salruleMapping.toDomain(#salruledtos),'ehr-SalRule-Save')")
    @ApiOperation(value = "批量保存薪酬规则", tags = {"薪酬规则" },  notes = "批量保存薪酬规则")
	@RequestMapping(method = RequestMethod.POST, value = "/salrules/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SalRuleDTO> salruledtos) {
        salruleService.saveBatch(salruleMapping.toDomain(salruledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查薪酬规则", tags = {"薪酬规则" },  notes = "检查薪酬规则")
	@RequestMapping(method = RequestMethod.POST, value = "/salrules/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SalRuleDTO salruledto) {
        return  ResponseEntity.status(HttpStatus.OK).body(salruleService.checkKey(salruleMapping.toDomain(salruledto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalRule-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"薪酬规则" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/salrules/fetchdefault")
	public ResponseEntity<List<SalRuleDTO>> fetchDefault(SalRuleSearchContext context) {
        Page<SalRule> domains = salruleService.searchDefault(context) ;
        List<SalRuleDTO> list = salruleMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SalRule-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"薪酬规则" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/salrules/searchdefault")
	public ResponseEntity<Page<SalRuleDTO>> searchDefault(@RequestBody SalRuleSearchContext context) {
        Page<SalRule> domains = salruleService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(salruleMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

