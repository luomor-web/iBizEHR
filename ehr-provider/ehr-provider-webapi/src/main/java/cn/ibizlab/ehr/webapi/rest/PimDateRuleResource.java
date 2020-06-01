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
import cn.ibizlab.ehr.core.pim.domain.PimDateRule;
import cn.ibizlab.ehr.core.pim.service.IPimDateRuleService;
import cn.ibizlab.ehr.core.pim.filter.PimDateRuleSearchContext;

@Slf4j
@Api(tags = {"生效日期规则" })
@RestController("WebApi-pimdaterule")
@RequestMapping("")
public class PimDateRuleResource {

    @Autowired
    public IPimDateRuleService pimdateruleService;

    @Autowired
    @Lazy
    public PimDateRuleMapping pimdateruleMapping;

    @ApiOperation(value = "获取生效日期规则草稿", tags = {"生效日期规则" },  notes = "获取生效日期规则草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimdaterules/getdraft")
    public ResponseEntity<PimDateRuleDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimdateruleMapping.toDto(pimdateruleService.getDraft(new PimDateRule())));
    }

    @PreAuthorize("hasPermission(this.pimdateruleService.get(#pimdaterule_id),'ehr-PimDateRule-Update')")
    @ApiOperation(value = "更新生效日期规则", tags = {"生效日期规则" },  notes = "更新生效日期规则")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimdaterules/{pimdaterule_id}")
    @Transactional
    public ResponseEntity<PimDateRuleDTO> update(@PathVariable("pimdaterule_id") String pimdaterule_id, @RequestBody PimDateRuleDTO pimdateruledto) {
		PimDateRule domain  = pimdateruleMapping.toDomain(pimdateruledto);
        domain .setDateruleid(pimdaterule_id);
		pimdateruleService.update(domain );
		PimDateRuleDTO dto = pimdateruleMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimdateruleService.getPimdateruleByEntities(this.pimdateruleMapping.toDomain(#pimdateruledtos)),'ehr-PimDateRule-Update')")
    @ApiOperation(value = "批量更新生效日期规则", tags = {"生效日期规则" },  notes = "批量更新生效日期规则")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimdaterules/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimDateRuleDTO> pimdateruledtos) {
        pimdateruleService.updateBatch(pimdateruleMapping.toDomain(pimdateruledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimdateruleService.get(#pimdaterule_id),'ehr-PimDateRule-Remove')")
    @ApiOperation(value = "删除生效日期规则", tags = {"生效日期规则" },  notes = "删除生效日期规则")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimdaterules/{pimdaterule_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimdaterule_id") String pimdaterule_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimdateruleService.remove(pimdaterule_id));
    }

    @PreAuthorize("hasPermission(this.pimdateruleService.getPimdateruleByIds(#ids),'ehr-PimDateRule-Remove')")
    @ApiOperation(value = "批量删除生效日期规则", tags = {"生效日期规则" },  notes = "批量删除生效日期规则")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimdaterules/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimdateruleService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimdateruleMapping.toDomain(#pimdateruledto),'ehr-PimDateRule-Create')")
    @ApiOperation(value = "新建生效日期规则", tags = {"生效日期规则" },  notes = "新建生效日期规则")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdaterules")
    @Transactional
    public ResponseEntity<PimDateRuleDTO> create(@RequestBody PimDateRuleDTO pimdateruledto) {
        PimDateRule domain = pimdateruleMapping.toDomain(pimdateruledto);
		pimdateruleService.create(domain);
        PimDateRuleDTO dto = pimdateruleMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimdateruleMapping.toDomain(#pimdateruledtos),'ehr-PimDateRule-Create')")
    @ApiOperation(value = "批量新建生效日期规则", tags = {"生效日期规则" },  notes = "批量新建生效日期规则")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdaterules/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimDateRuleDTO> pimdateruledtos) {
        pimdateruleService.createBatch(pimdateruleMapping.toDomain(pimdateruledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查生效日期规则", tags = {"生效日期规则" },  notes = "检查生效日期规则")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdaterules/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimDateRuleDTO pimdateruledto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimdateruleService.checkKey(pimdateruleMapping.toDomain(pimdateruledto)));
    }

    @PreAuthorize("hasPermission(this.pimdateruleMapping.toDomain(#pimdateruledto),'ehr-PimDateRule-Save')")
    @ApiOperation(value = "保存生效日期规则", tags = {"生效日期规则" },  notes = "保存生效日期规则")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdaterules/save")
    public ResponseEntity<Boolean> save(@RequestBody PimDateRuleDTO pimdateruledto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimdateruleService.save(pimdateruleMapping.toDomain(pimdateruledto)));
    }

    @PreAuthorize("hasPermission(this.pimdateruleMapping.toDomain(#pimdateruledtos),'ehr-PimDateRule-Save')")
    @ApiOperation(value = "批量保存生效日期规则", tags = {"生效日期规则" },  notes = "批量保存生效日期规则")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdaterules/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimDateRuleDTO> pimdateruledtos) {
        pimdateruleService.saveBatch(pimdateruleMapping.toDomain(pimdateruledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimdateruleMapping.toDomain(returnObject.body),'ehr-PimDateRule-Get')")
    @ApiOperation(value = "获取生效日期规则", tags = {"生效日期规则" },  notes = "获取生效日期规则")
	@RequestMapping(method = RequestMethod.GET, value = "/pimdaterules/{pimdaterule_id}")
    public ResponseEntity<PimDateRuleDTO> get(@PathVariable("pimdaterule_id") String pimdaterule_id) {
        PimDateRule domain = pimdateruleService.get(pimdaterule_id);
        PimDateRuleDTO dto = pimdateruleMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDateRule-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"生效日期规则" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimdaterules/fetchdefault")
	public ResponseEntity<List<PimDateRuleDTO>> fetchDefault(PimDateRuleSearchContext context) {
        Page<PimDateRule> domains = pimdateruleService.searchDefault(context) ;
        List<PimDateRuleDTO> list = pimdateruleMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDateRule-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"生效日期规则" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimdaterules/searchdefault")
	public ResponseEntity<Page<PimDateRuleDTO>> searchDefault(@RequestBody PimDateRuleSearchContext context) {
        Page<PimDateRule> domains = pimdateruleService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdateruleMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

