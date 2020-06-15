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
import cn.ibizlab.ehr.core.par.domain.ParAssessTemplate;
import cn.ibizlab.ehr.core.par.service.IParAssessTemplateService;
import cn.ibizlab.ehr.core.par.filter.ParAssessTemplateSearchContext;

@Slf4j
@Api(tags = {"考核模板" })
@RestController("WebApi-parassesstemplate")
@RequestMapping("")
public class ParAssessTemplateResource {

    @Autowired
    public IParAssessTemplateService parassesstemplateService;

    @Autowired
    @Lazy
    public ParAssessTemplateMapping parassesstemplateMapping;

    @PreAuthorize("hasPermission(this.parassesstemplateService.get(#parassesstemplate_id),'ehr-ParAssessTemplate-Remove')")
    @ApiOperation(value = "删除考核模板", tags = {"考核模板" },  notes = "删除考核模板")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parassesstemplates/{parassesstemplate_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parassesstemplate_id") String parassesstemplate_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parassesstemplateService.remove(parassesstemplate_id));
    }

    @PreAuthorize("hasPermission(this.parassesstemplateService.getParassesstemplateByIds(#ids),'ehr-ParAssessTemplate-Remove')")
    @ApiOperation(value = "批量删除考核模板", tags = {"考核模板" },  notes = "批量删除考核模板")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parassesstemplates/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parassesstemplateService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取考核模板草稿", tags = {"考核模板" },  notes = "获取考核模板草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parassesstemplates/getdraft")
    public ResponseEntity<ParAssessTemplateDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parassesstemplateMapping.toDto(parassesstemplateService.getDraft(new ParAssessTemplate())));
    }

    @PostAuthorize("hasPermission(this.parassesstemplateMapping.toDomain(returnObject.body),'ehr-ParAssessTemplate-Get')")
    @ApiOperation(value = "获取考核模板", tags = {"考核模板" },  notes = "获取考核模板")
	@RequestMapping(method = RequestMethod.GET, value = "/parassesstemplates/{parassesstemplate_id}")
    public ResponseEntity<ParAssessTemplateDTO> get(@PathVariable("parassesstemplate_id") String parassesstemplate_id) {
        ParAssessTemplate domain = parassesstemplateService.get(parassesstemplate_id);
        ParAssessTemplateDTO dto = parassesstemplateMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查考核模板", tags = {"考核模板" },  notes = "检查考核模板")
	@RequestMapping(method = RequestMethod.POST, value = "/parassesstemplates/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParAssessTemplateDTO parassesstemplatedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parassesstemplateService.checkKey(parassesstemplateMapping.toDomain(parassesstemplatedto)));
    }

    @PreAuthorize("hasPermission(this.parassesstemplateService.get(#parassesstemplate_id),'ehr-ParAssessTemplate-Update')")
    @ApiOperation(value = "更新考核模板", tags = {"考核模板" },  notes = "更新考核模板")
	@RequestMapping(method = RequestMethod.PUT, value = "/parassesstemplates/{parassesstemplate_id}")
    @Transactional
    public ResponseEntity<ParAssessTemplateDTO> update(@PathVariable("parassesstemplate_id") String parassesstemplate_id, @RequestBody ParAssessTemplateDTO parassesstemplatedto) {
		ParAssessTemplate domain  = parassesstemplateMapping.toDomain(parassesstemplatedto);
        domain .setParassesstemplateid(parassesstemplate_id);
		parassesstemplateService.update(domain );
		ParAssessTemplateDTO dto = parassesstemplateMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parassesstemplateService.getParassesstemplateByEntities(this.parassesstemplateMapping.toDomain(#parassesstemplatedtos)),'ehr-ParAssessTemplate-Update')")
    @ApiOperation(value = "批量更新考核模板", tags = {"考核模板" },  notes = "批量更新考核模板")
	@RequestMapping(method = RequestMethod.PUT, value = "/parassesstemplates/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParAssessTemplateDTO> parassesstemplatedtos) {
        parassesstemplateService.updateBatch(parassesstemplateMapping.toDomain(parassesstemplatedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parassesstemplateMapping.toDomain(#parassesstemplatedto),'ehr-ParAssessTemplate-Save')")
    @ApiOperation(value = "保存考核模板", tags = {"考核模板" },  notes = "保存考核模板")
	@RequestMapping(method = RequestMethod.POST, value = "/parassesstemplates/save")
    public ResponseEntity<Boolean> save(@RequestBody ParAssessTemplateDTO parassesstemplatedto) {
        return ResponseEntity.status(HttpStatus.OK).body(parassesstemplateService.save(parassesstemplateMapping.toDomain(parassesstemplatedto)));
    }

    @PreAuthorize("hasPermission(this.parassesstemplateMapping.toDomain(#parassesstemplatedtos),'ehr-ParAssessTemplate-Save')")
    @ApiOperation(value = "批量保存考核模板", tags = {"考核模板" },  notes = "批量保存考核模板")
	@RequestMapping(method = RequestMethod.POST, value = "/parassesstemplates/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParAssessTemplateDTO> parassesstemplatedtos) {
        parassesstemplateService.saveBatch(parassesstemplateMapping.toDomain(parassesstemplatedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parassesstemplateMapping.toDomain(#parassesstemplatedto),'ehr-ParAssessTemplate-Create')")
    @ApiOperation(value = "新建考核模板", tags = {"考核模板" },  notes = "新建考核模板")
	@RequestMapping(method = RequestMethod.POST, value = "/parassesstemplates")
    @Transactional
    public ResponseEntity<ParAssessTemplateDTO> create(@RequestBody ParAssessTemplateDTO parassesstemplatedto) {
        ParAssessTemplate domain = parassesstemplateMapping.toDomain(parassesstemplatedto);
		parassesstemplateService.create(domain);
        ParAssessTemplateDTO dto = parassesstemplateMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parassesstemplateMapping.toDomain(#parassesstemplatedtos),'ehr-ParAssessTemplate-Create')")
    @ApiOperation(value = "批量新建考核模板", tags = {"考核模板" },  notes = "批量新建考核模板")
	@RequestMapping(method = RequestMethod.POST, value = "/parassesstemplates/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParAssessTemplateDTO> parassesstemplatedtos) {
        parassesstemplateService.createBatch(parassesstemplateMapping.toDomain(parassesstemplatedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParAssessTemplate-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"考核模板" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parassesstemplates/fetchdefault")
	public ResponseEntity<List<ParAssessTemplateDTO>> fetchDefault(ParAssessTemplateSearchContext context) {
        Page<ParAssessTemplate> domains = parassesstemplateService.searchDefault(context) ;
        List<ParAssessTemplateDTO> list = parassesstemplateMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParAssessTemplate-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"考核模板" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parassesstemplates/searchdefault")
	public ResponseEntity<Page<ParAssessTemplateDTO>> searchDefault(@RequestBody ParAssessTemplateSearchContext context) {
        Page<ParAssessTemplate> domains = parassesstemplateService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parassesstemplateMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

