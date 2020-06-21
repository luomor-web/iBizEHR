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
import cn.ibizlab.ehr.core.par.domain.ParJxkhxhz;
import cn.ibizlab.ehr.core.par.service.IParJxkhxhzService;
import cn.ibizlab.ehr.core.par.filter.ParJxkhxhzSearchContext;

@Slf4j
@Api(tags = {"考核方案" })
@RestController("WebApi-parjxkhxhz")
@RequestMapping("")
public class ParJxkhxhzResource {

    @Autowired
    public IParJxkhxhzService parjxkhxhzService;

    @Autowired
    @Lazy
    public ParJxkhxhzMapping parjxkhxhzMapping;

    @ApiOperation(value = "获取考核方案草稿", tags = {"考核方案" },  notes = "获取考核方案草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxkhxhzs/getdraft")
    public ResponseEntity<ParJxkhxhzDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parjxkhxhzMapping.toDto(parjxkhxhzService.getDraft(new ParJxkhxhz())));
    }

    @PreAuthorize("hasPermission(this.parjxkhxhzService.get(#parjxkhxhz_id),'ehr-ParJxkhxhz-Update')")
    @ApiOperation(value = "更新考核方案", tags = {"考核方案" },  notes = "更新考核方案")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxkhxhzs/{parjxkhxhz_id}")
    @Transactional
    public ResponseEntity<ParJxkhxhzDTO> update(@PathVariable("parjxkhxhz_id") String parjxkhxhz_id, @RequestBody ParJxkhxhzDTO parjxkhxhzdto) {
		ParJxkhxhz domain  = parjxkhxhzMapping.toDomain(parjxkhxhzdto);
        domain .setParjxkhxhzid(parjxkhxhz_id);
		parjxkhxhzService.update(domain );
		ParJxkhxhzDTO dto = parjxkhxhzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxkhxhzService.getParjxkhxhzByEntities(this.parjxkhxhzMapping.toDomain(#parjxkhxhzdtos)),'ehr-ParJxkhxhz-Update')")
    @ApiOperation(value = "批量更新考核方案", tags = {"考核方案" },  notes = "批量更新考核方案")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxkhxhzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParJxkhxhzDTO> parjxkhxhzdtos) {
        parjxkhxhzService.updateBatch(parjxkhxhzMapping.toDomain(parjxkhxhzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查考核方案", tags = {"考核方案" },  notes = "检查考核方案")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhxhzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParJxkhxhzDTO parjxkhxhzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxkhxhzService.checkKey(parjxkhxhzMapping.toDomain(parjxkhxhzdto)));
    }

    @PostAuthorize("hasPermission(this.parjxkhxhzMapping.toDomain(returnObject.body),'ehr-ParJxkhxhz-Get')")
    @ApiOperation(value = "获取考核方案", tags = {"考核方案" },  notes = "获取考核方案")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxkhxhzs/{parjxkhxhz_id}")
    public ResponseEntity<ParJxkhxhzDTO> get(@PathVariable("parjxkhxhz_id") String parjxkhxhz_id) {
        ParJxkhxhz domain = parjxkhxhzService.get(parjxkhxhz_id);
        ParJxkhxhzDTO dto = parjxkhxhzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxkhxhzService.get(#parjxkhxhz_id),'ehr-ParJxkhxhz-Remove')")
    @ApiOperation(value = "删除考核方案", tags = {"考核方案" },  notes = "删除考核方案")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxkhxhzs/{parjxkhxhz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parjxkhxhz_id") String parjxkhxhz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parjxkhxhzService.remove(parjxkhxhz_id));
    }

    @PreAuthorize("hasPermission(this.parjxkhxhzService.getParjxkhxhzByIds(#ids),'ehr-ParJxkhxhz-Remove')")
    @ApiOperation(value = "批量删除考核方案", tags = {"考核方案" },  notes = "批量删除考核方案")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxkhxhzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parjxkhxhzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxkhxhzMapping.toDomain(#parjxkhxhzdto),'ehr-ParJxkhxhz-Create')")
    @ApiOperation(value = "新建考核方案", tags = {"考核方案" },  notes = "新建考核方案")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhxhzs")
    @Transactional
    public ResponseEntity<ParJxkhxhzDTO> create(@RequestBody ParJxkhxhzDTO parjxkhxhzdto) {
        ParJxkhxhz domain = parjxkhxhzMapping.toDomain(parjxkhxhzdto);
		parjxkhxhzService.create(domain);
        ParJxkhxhzDTO dto = parjxkhxhzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxkhxhzMapping.toDomain(#parjxkhxhzdtos),'ehr-ParJxkhxhz-Create')")
    @ApiOperation(value = "批量新建考核方案", tags = {"考核方案" },  notes = "批量新建考核方案")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhxhzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParJxkhxhzDTO> parjxkhxhzdtos) {
        parjxkhxhzService.createBatch(parjxkhxhzMapping.toDomain(parjxkhxhzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxkhxhzMapping.toDomain(#parjxkhxhzdto),'ehr-ParJxkhxhz-Save')")
    @ApiOperation(value = "保存考核方案", tags = {"考核方案" },  notes = "保存考核方案")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhxhzs/save")
    public ResponseEntity<Boolean> save(@RequestBody ParJxkhxhzDTO parjxkhxhzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parjxkhxhzService.save(parjxkhxhzMapping.toDomain(parjxkhxhzdto)));
    }

    @PreAuthorize("hasPermission(this.parjxkhxhzMapping.toDomain(#parjxkhxhzdtos),'ehr-ParJxkhxhz-Save')")
    @ApiOperation(value = "批量保存考核方案", tags = {"考核方案" },  notes = "批量保存考核方案")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhxhzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParJxkhxhzDTO> parjxkhxhzdtos) {
        parjxkhxhzService.saveBatch(parjxkhxhzMapping.toDomain(parjxkhxhzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxkhxhz-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"考核方案" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxkhxhzs/fetchdefault")
	public ResponseEntity<List<ParJxkhxhzDTO>> fetchDefault(ParJxkhxhzSearchContext context) {
        Page<ParJxkhxhz> domains = parjxkhxhzService.searchDefault(context) ;
        List<ParJxkhxhzDTO> list = parjxkhxhzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxkhxhz-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"考核方案" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxkhxhzs/searchdefault")
	public ResponseEntity<Page<ParJxkhxhzDTO>> searchDefault(@RequestBody ParJxkhxhzSearchContext context) {
        Page<ParJxkhxhz> domains = parjxkhxhzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxkhxhzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据考核模板获取考核方案草稿", tags = {"考核方案" },  notes = "根据考核模板获取考核方案草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/parassesstemplates/{parassesstemplate_id}/parjxkhxhzs/getdraft")
    public ResponseEntity<ParJxkhxhzDTO> getDraftByParAssessTemplate(@PathVariable("parassesstemplate_id") String parassesstemplate_id) {
        ParJxkhxhz domain = new ParJxkhxhz();
        domain.setParassesstemplateid(parassesstemplate_id);
        return ResponseEntity.status(HttpStatus.OK).body(parjxkhxhzMapping.toDto(parjxkhxhzService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.parjxkhxhzService.get(#parjxkhxhz_id),'ehr-ParJxkhxhz-Update')")
    @ApiOperation(value = "根据考核模板更新考核方案", tags = {"考核方案" },  notes = "根据考核模板更新考核方案")
	@RequestMapping(method = RequestMethod.PUT, value = "/parassesstemplates/{parassesstemplate_id}/parjxkhxhzs/{parjxkhxhz_id}")
    @Transactional
    public ResponseEntity<ParJxkhxhzDTO> updateByParAssessTemplate(@PathVariable("parassesstemplate_id") String parassesstemplate_id, @PathVariable("parjxkhxhz_id") String parjxkhxhz_id, @RequestBody ParJxkhxhzDTO parjxkhxhzdto) {
        ParJxkhxhz domain = parjxkhxhzMapping.toDomain(parjxkhxhzdto);
        domain.setParassesstemplateid(parassesstemplate_id);
        domain.setParjxkhxhzid(parjxkhxhz_id);
		parjxkhxhzService.update(domain);
        ParJxkhxhzDTO dto = parjxkhxhzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxkhxhzService.getParjxkhxhzByEntities(this.parjxkhxhzMapping.toDomain(#parjxkhxhzdtos)),'ehr-ParJxkhxhz-Update')")
    @ApiOperation(value = "根据考核模板批量更新考核方案", tags = {"考核方案" },  notes = "根据考核模板批量更新考核方案")
	@RequestMapping(method = RequestMethod.PUT, value = "/parassesstemplates/{parassesstemplate_id}/parjxkhxhzs/batch")
    public ResponseEntity<Boolean> updateBatchByParAssessTemplate(@PathVariable("parassesstemplate_id") String parassesstemplate_id, @RequestBody List<ParJxkhxhzDTO> parjxkhxhzdtos) {
        List<ParJxkhxhz> domainlist=parjxkhxhzMapping.toDomain(parjxkhxhzdtos);
        for(ParJxkhxhz domain:domainlist){
            domain.setParassesstemplateid(parassesstemplate_id);
        }
        parjxkhxhzService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据考核模板检查考核方案", tags = {"考核方案" },  notes = "根据考核模板检查考核方案")
	@RequestMapping(method = RequestMethod.POST, value = "/parassesstemplates/{parassesstemplate_id}/parjxkhxhzs/checkkey")
    public ResponseEntity<Boolean> checkKeyByParAssessTemplate(@PathVariable("parassesstemplate_id") String parassesstemplate_id, @RequestBody ParJxkhxhzDTO parjxkhxhzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parjxkhxhzService.checkKey(parjxkhxhzMapping.toDomain(parjxkhxhzdto)));
    }

    @PostAuthorize("hasPermission(this.parjxkhxhzMapping.toDomain(returnObject.body),'ehr-ParJxkhxhz-Get')")
    @ApiOperation(value = "根据考核模板获取考核方案", tags = {"考核方案" },  notes = "根据考核模板获取考核方案")
	@RequestMapping(method = RequestMethod.GET, value = "/parassesstemplates/{parassesstemplate_id}/parjxkhxhzs/{parjxkhxhz_id}")
    public ResponseEntity<ParJxkhxhzDTO> getByParAssessTemplate(@PathVariable("parassesstemplate_id") String parassesstemplate_id, @PathVariable("parjxkhxhz_id") String parjxkhxhz_id) {
        ParJxkhxhz domain = parjxkhxhzService.get(parjxkhxhz_id);
        ParJxkhxhzDTO dto = parjxkhxhzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxkhxhzService.get(#parjxkhxhz_id),'ehr-ParJxkhxhz-Remove')")
    @ApiOperation(value = "根据考核模板删除考核方案", tags = {"考核方案" },  notes = "根据考核模板删除考核方案")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parassesstemplates/{parassesstemplate_id}/parjxkhxhzs/{parjxkhxhz_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByParAssessTemplate(@PathVariable("parassesstemplate_id") String parassesstemplate_id, @PathVariable("parjxkhxhz_id") String parjxkhxhz_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parjxkhxhzService.remove(parjxkhxhz_id));
    }

    @PreAuthorize("hasPermission(this.parjxkhxhzService.getParjxkhxhzByIds(#ids),'ehr-ParJxkhxhz-Remove')")
    @ApiOperation(value = "根据考核模板批量删除考核方案", tags = {"考核方案" },  notes = "根据考核模板批量删除考核方案")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parassesstemplates/{parassesstemplate_id}/parjxkhxhzs/batch")
    public ResponseEntity<Boolean> removeBatchByParAssessTemplate(@RequestBody List<String> ids) {
        parjxkhxhzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxkhxhzMapping.toDomain(#parjxkhxhzdto),'ehr-ParJxkhxhz-Create')")
    @ApiOperation(value = "根据考核模板建立考核方案", tags = {"考核方案" },  notes = "根据考核模板建立考核方案")
	@RequestMapping(method = RequestMethod.POST, value = "/parassesstemplates/{parassesstemplate_id}/parjxkhxhzs")
    @Transactional
    public ResponseEntity<ParJxkhxhzDTO> createByParAssessTemplate(@PathVariable("parassesstemplate_id") String parassesstemplate_id, @RequestBody ParJxkhxhzDTO parjxkhxhzdto) {
        ParJxkhxhz domain = parjxkhxhzMapping.toDomain(parjxkhxhzdto);
        domain.setParassesstemplateid(parassesstemplate_id);
		parjxkhxhzService.create(domain);
        ParJxkhxhzDTO dto = parjxkhxhzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parjxkhxhzMapping.toDomain(#parjxkhxhzdtos),'ehr-ParJxkhxhz-Create')")
    @ApiOperation(value = "根据考核模板批量建立考核方案", tags = {"考核方案" },  notes = "根据考核模板批量建立考核方案")
	@RequestMapping(method = RequestMethod.POST, value = "/parassesstemplates/{parassesstemplate_id}/parjxkhxhzs/batch")
    public ResponseEntity<Boolean> createBatchByParAssessTemplate(@PathVariable("parassesstemplate_id") String parassesstemplate_id, @RequestBody List<ParJxkhxhzDTO> parjxkhxhzdtos) {
        List<ParJxkhxhz> domainlist=parjxkhxhzMapping.toDomain(parjxkhxhzdtos);
        for(ParJxkhxhz domain:domainlist){
            domain.setParassesstemplateid(parassesstemplate_id);
        }
        parjxkhxhzService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parjxkhxhzMapping.toDomain(#parjxkhxhzdto),'ehr-ParJxkhxhz-Save')")
    @ApiOperation(value = "根据考核模板保存考核方案", tags = {"考核方案" },  notes = "根据考核模板保存考核方案")
	@RequestMapping(method = RequestMethod.POST, value = "/parassesstemplates/{parassesstemplate_id}/parjxkhxhzs/save")
    public ResponseEntity<Boolean> saveByParAssessTemplate(@PathVariable("parassesstemplate_id") String parassesstemplate_id, @RequestBody ParJxkhxhzDTO parjxkhxhzdto) {
        ParJxkhxhz domain = parjxkhxhzMapping.toDomain(parjxkhxhzdto);
        domain.setParassesstemplateid(parassesstemplate_id);
        return ResponseEntity.status(HttpStatus.OK).body(parjxkhxhzService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parjxkhxhzMapping.toDomain(#parjxkhxhzdtos),'ehr-ParJxkhxhz-Save')")
    @ApiOperation(value = "根据考核模板批量保存考核方案", tags = {"考核方案" },  notes = "根据考核模板批量保存考核方案")
	@RequestMapping(method = RequestMethod.POST, value = "/parassesstemplates/{parassesstemplate_id}/parjxkhxhzs/savebatch")
    public ResponseEntity<Boolean> saveBatchByParAssessTemplate(@PathVariable("parassesstemplate_id") String parassesstemplate_id, @RequestBody List<ParJxkhxhzDTO> parjxkhxhzdtos) {
        List<ParJxkhxhz> domainlist=parjxkhxhzMapping.toDomain(parjxkhxhzdtos);
        for(ParJxkhxhz domain:domainlist){
             domain.setParassesstemplateid(parassesstemplate_id);
        }
        parjxkhxhzService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxkhxhz-Default-all')")
	@ApiOperation(value = "根据考核模板获取DEFAULT", tags = {"考核方案" } ,notes = "根据考核模板获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parassesstemplates/{parassesstemplate_id}/parjxkhxhzs/fetchdefault")
	public ResponseEntity<List<ParJxkhxhzDTO>> fetchParJxkhxhzDefaultByParAssessTemplate(@PathVariable("parassesstemplate_id") String parassesstemplate_id,ParJxkhxhzSearchContext context) {
        context.setN_parassesstemplateid_eq(parassesstemplate_id);
        Page<ParJxkhxhz> domains = parjxkhxhzService.searchDefault(context) ;
        List<ParJxkhxhzDTO> list = parjxkhxhzMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParJxkhxhz-Default-all')")
	@ApiOperation(value = "根据考核模板查询DEFAULT", tags = {"考核方案" } ,notes = "根据考核模板查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parassesstemplates/{parassesstemplate_id}/parjxkhxhzs/searchdefault")
	public ResponseEntity<Page<ParJxkhxhzDTO>> searchParJxkhxhzDefaultByParAssessTemplate(@PathVariable("parassesstemplate_id") String parassesstemplate_id, @RequestBody ParJxkhxhzSearchContext context) {
        context.setN_parassesstemplateid_eq(parassesstemplate_id);
        Page<ParJxkhxhz> domains = parjxkhxhzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parjxkhxhzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

