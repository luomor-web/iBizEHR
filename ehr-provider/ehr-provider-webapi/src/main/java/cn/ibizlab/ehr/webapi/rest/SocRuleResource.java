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
import cn.ibizlab.ehr.core.soc.domain.SocRule;
import cn.ibizlab.ehr.core.soc.service.ISocRuleService;
import cn.ibizlab.ehr.core.soc.filter.SocRuleSearchContext;

@Slf4j
@Api(tags = {"社保规则" })
@RestController("WebApi-socrule")
@RequestMapping("")
public class SocRuleResource {

    @Autowired
    public ISocRuleService socruleService;

    @Autowired
    @Lazy
    public SocRuleMapping socruleMapping;

    @PostAuthorize("hasPermission(this.socruleMapping.toDomain(returnObject.body),'ehr-SocRule-Get')")
    @ApiOperation(value = "获取社保规则", tags = {"社保规则" },  notes = "获取社保规则")
	@RequestMapping(method = RequestMethod.GET, value = "/socrules/{socrule_id}")
    public ResponseEntity<SocRuleDTO> get(@PathVariable("socrule_id") String socrule_id) {
        SocRule domain = socruleService.get(socrule_id);
        SocRuleDTO dto = socruleMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取社保规则草稿", tags = {"社保规则" },  notes = "获取社保规则草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/socrules/getdraft")
    public ResponseEntity<SocRuleDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(socruleMapping.toDto(socruleService.getDraft(new SocRule())));
    }

    @PreAuthorize("hasPermission(this.socruleMapping.toDomain(#socruledto),'ehr-SocRule-Create')")
    @ApiOperation(value = "新建社保规则", tags = {"社保规则" },  notes = "新建社保规则")
	@RequestMapping(method = RequestMethod.POST, value = "/socrules")
    @Transactional
    public ResponseEntity<SocRuleDTO> create(@RequestBody SocRuleDTO socruledto) {
        SocRule domain = socruleMapping.toDomain(socruledto);
		socruleService.create(domain);
        SocRuleDTO dto = socruleMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socruleMapping.toDomain(#socruledtos),'ehr-SocRule-Create')")
    @ApiOperation(value = "批量新建社保规则", tags = {"社保规则" },  notes = "批量新建社保规则")
	@RequestMapping(method = RequestMethod.POST, value = "/socrules/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SocRuleDTO> socruledtos) {
        socruleService.createBatch(socruleMapping.toDomain(socruledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.socruleService.get(#socrule_id),'ehr-SocRule-Update')")
    @ApiOperation(value = "更新社保规则", tags = {"社保规则" },  notes = "更新社保规则")
	@RequestMapping(method = RequestMethod.PUT, value = "/socrules/{socrule_id}")
    @Transactional
    public ResponseEntity<SocRuleDTO> update(@PathVariable("socrule_id") String socrule_id, @RequestBody SocRuleDTO socruledto) {
		SocRule domain  = socruleMapping.toDomain(socruledto);
        domain .setSocruleid(socrule_id);
		socruleService.update(domain );
		SocRuleDTO dto = socruleMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socruleService.getSocruleByEntities(this.socruleMapping.toDomain(#socruledtos)),'ehr-SocRule-Update')")
    @ApiOperation(value = "批量更新社保规则", tags = {"社保规则" },  notes = "批量更新社保规则")
	@RequestMapping(method = RequestMethod.PUT, value = "/socrules/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SocRuleDTO> socruledtos) {
        socruleService.updateBatch(socruleMapping.toDomain(socruledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.socruleMapping.toDomain(#socruledto),'ehr-SocRule-Save')")
    @ApiOperation(value = "保存社保规则", tags = {"社保规则" },  notes = "保存社保规则")
	@RequestMapping(method = RequestMethod.POST, value = "/socrules/save")
    public ResponseEntity<Boolean> save(@RequestBody SocRuleDTO socruledto) {
        return ResponseEntity.status(HttpStatus.OK).body(socruleService.save(socruleMapping.toDomain(socruledto)));
    }

    @PreAuthorize("hasPermission(this.socruleMapping.toDomain(#socruledtos),'ehr-SocRule-Save')")
    @ApiOperation(value = "批量保存社保规则", tags = {"社保规则" },  notes = "批量保存社保规则")
	@RequestMapping(method = RequestMethod.POST, value = "/socrules/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SocRuleDTO> socruledtos) {
        socruleService.saveBatch(socruleMapping.toDomain(socruledtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查社保规则", tags = {"社保规则" },  notes = "检查社保规则")
	@RequestMapping(method = RequestMethod.POST, value = "/socrules/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SocRuleDTO socruledto) {
        return  ResponseEntity.status(HttpStatus.OK).body(socruleService.checkKey(socruleMapping.toDomain(socruledto)));
    }

    @PreAuthorize("hasPermission(this.socruleService.get(#socrule_id),'ehr-SocRule-Remove')")
    @ApiOperation(value = "删除社保规则", tags = {"社保规则" },  notes = "删除社保规则")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socrules/{socrule_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("socrule_id") String socrule_id) {
         return ResponseEntity.status(HttpStatus.OK).body(socruleService.remove(socrule_id));
    }

    @PreAuthorize("hasPermission(this.socruleService.getSocruleByIds(#ids),'ehr-SocRule-Remove')")
    @ApiOperation(value = "批量删除社保规则", tags = {"社保规则" },  notes = "批量删除社保规则")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socrules/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        socruleService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocRule-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"社保规则" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/socrules/fetchdefault")
	public ResponseEntity<List<SocRuleDTO>> fetchDefault(SocRuleSearchContext context) {
        Page<SocRule> domains = socruleService.searchDefault(context) ;
        List<SocRuleDTO> list = socruleMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocRule-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"社保规则" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/socrules/searchdefault")
	public ResponseEntity<Page<SocRuleDTO>> searchDefault(@RequestBody SocRuleSearchContext context) {
        Page<SocRule> domains = socruleService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(socruleMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

