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
import cn.ibizlab.ehr.core.par.domain.ParIntegralRule;
import cn.ibizlab.ehr.core.par.service.IParIntegralRuleService;
import cn.ibizlab.ehr.core.par.filter.ParIntegralRuleSearchContext;

@Slf4j
@Api(tags = {"积分规则" })
@RestController("WebApi-parintegralrule")
@RequestMapping("")
public class ParIntegralRuleResource {

    @Autowired
    public IParIntegralRuleService parintegralruleService;

    @Autowired
    @Lazy
    public ParIntegralRuleMapping parintegralruleMapping;

    @ApiOperation(value = "检查积分规则", tags = {"积分规则" },  notes = "检查积分规则")
	@RequestMapping(method = RequestMethod.POST, value = "/parintegralrules/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParIntegralRuleDTO parintegralruledto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parintegralruleService.checkKey(parintegralruleMapping.toDomain(parintegralruledto)));
    }

    @PreAuthorize("hasPermission(this.parintegralruleService.get(#parintegralrule_id),'ehr-ParIntegralRule-Remove')")
    @ApiOperation(value = "删除积分规则", tags = {"积分规则" },  notes = "删除积分规则")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parintegralrules/{parintegralrule_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parintegralrule_id") String parintegralrule_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parintegralruleService.remove(parintegralrule_id));
    }

    @PreAuthorize("hasPermission(this.parintegralruleService.getParintegralruleByIds(#ids),'ehr-ParIntegralRule-Remove')")
    @ApiOperation(value = "批量删除积分规则", tags = {"积分规则" },  notes = "批量删除积分规则")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parintegralrules/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parintegralruleService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parintegralruleService.get(#parintegralrule_id),'ehr-ParIntegralRule-Update')")
    @ApiOperation(value = "更新积分规则", tags = {"积分规则" },  notes = "更新积分规则")
	@RequestMapping(method = RequestMethod.PUT, value = "/parintegralrules/{parintegralrule_id}")
    @Transactional
    public ResponseEntity<ParIntegralRuleDTO> update(@PathVariable("parintegralrule_id") String parintegralrule_id, @RequestBody ParIntegralRuleDTO parintegralruledto) {
		ParIntegralRule domain  = parintegralruleMapping.toDomain(parintegralruledto);
        domain .setParintegralruleid(parintegralrule_id);
		parintegralruleService.update(domain );
		ParIntegralRuleDTO dto = parintegralruleMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parintegralruleService.getParintegralruleByEntities(this.parintegralruleMapping.toDomain(#parintegralruledtos)),'ehr-ParIntegralRule-Update')")
    @ApiOperation(value = "批量更新积分规则", tags = {"积分规则" },  notes = "批量更新积分规则")
	@RequestMapping(method = RequestMethod.PUT, value = "/parintegralrules/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParIntegralRuleDTO> parintegralruledtos) {
        parintegralruleService.updateBatch(parintegralruleMapping.toDomain(parintegralruledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parintegralruleMapping.toDomain(returnObject.body),'ehr-ParIntegralRule-Get')")
    @ApiOperation(value = "获取积分规则", tags = {"积分规则" },  notes = "获取积分规则")
	@RequestMapping(method = RequestMethod.GET, value = "/parintegralrules/{parintegralrule_id}")
    public ResponseEntity<ParIntegralRuleDTO> get(@PathVariable("parintegralrule_id") String parintegralrule_id) {
        ParIntegralRule domain = parintegralruleService.get(parintegralrule_id);
        ParIntegralRuleDTO dto = parintegralruleMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取积分规则草稿", tags = {"积分规则" },  notes = "获取积分规则草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parintegralrules/getdraft")
    public ResponseEntity<ParIntegralRuleDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parintegralruleMapping.toDto(parintegralruleService.getDraft(new ParIntegralRule())));
    }

    @PreAuthorize("hasPermission(this.parintegralruleMapping.toDomain(#parintegralruledto),'ehr-ParIntegralRule-Create')")
    @ApiOperation(value = "新建积分规则", tags = {"积分规则" },  notes = "新建积分规则")
	@RequestMapping(method = RequestMethod.POST, value = "/parintegralrules")
    @Transactional
    public ResponseEntity<ParIntegralRuleDTO> create(@RequestBody ParIntegralRuleDTO parintegralruledto) {
        ParIntegralRule domain = parintegralruleMapping.toDomain(parintegralruledto);
		parintegralruleService.create(domain);
        ParIntegralRuleDTO dto = parintegralruleMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parintegralruleMapping.toDomain(#parintegralruledtos),'ehr-ParIntegralRule-Create')")
    @ApiOperation(value = "批量新建积分规则", tags = {"积分规则" },  notes = "批量新建积分规则")
	@RequestMapping(method = RequestMethod.POST, value = "/parintegralrules/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParIntegralRuleDTO> parintegralruledtos) {
        parintegralruleService.createBatch(parintegralruleMapping.toDomain(parintegralruledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parintegralruleMapping.toDomain(#parintegralruledto),'ehr-ParIntegralRule-Save')")
    @ApiOperation(value = "保存积分规则", tags = {"积分规则" },  notes = "保存积分规则")
	@RequestMapping(method = RequestMethod.POST, value = "/parintegralrules/save")
    public ResponseEntity<Boolean> save(@RequestBody ParIntegralRuleDTO parintegralruledto) {
        return ResponseEntity.status(HttpStatus.OK).body(parintegralruleService.save(parintegralruleMapping.toDomain(parintegralruledto)));
    }

    @PreAuthorize("hasPermission(this.parintegralruleMapping.toDomain(#parintegralruledtos),'ehr-ParIntegralRule-Save')")
    @ApiOperation(value = "批量保存积分规则", tags = {"积分规则" },  notes = "批量保存积分规则")
	@RequestMapping(method = RequestMethod.POST, value = "/parintegralrules/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParIntegralRuleDTO> parintegralruledtos) {
        parintegralruleService.saveBatch(parintegralruleMapping.toDomain(parintegralruledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParIntegralRule-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"积分规则" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parintegralrules/fetchdefault")
	public ResponseEntity<List<ParIntegralRuleDTO>> fetchDefault(ParIntegralRuleSearchContext context) {
        Page<ParIntegralRule> domains = parintegralruleService.searchDefault(context) ;
        List<ParIntegralRuleDTO> list = parintegralruleMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParIntegralRule-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"积分规则" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parintegralrules/searchdefault")
	public ResponseEntity<Page<ParIntegralRuleDTO>> searchDefault(@RequestBody ParIntegralRuleSearchContext context) {
        Page<ParIntegralRule> domains = parintegralruleService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parintegralruleMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

