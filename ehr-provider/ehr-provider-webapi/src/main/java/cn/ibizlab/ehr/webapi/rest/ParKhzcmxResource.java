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
import cn.ibizlab.ehr.core.par.domain.ParKhzcmx;
import cn.ibizlab.ehr.core.par.service.IParKhzcmxService;
import cn.ibizlab.ehr.core.par.filter.ParKhzcmxSearchContext;

@Slf4j
@Api(tags = {"考核模板明细" })
@RestController("WebApi-parkhzcmx")
@RequestMapping("")
public class ParKhzcmxResource {

    @Autowired
    public IParKhzcmxService parkhzcmxService;

    @Autowired
    @Lazy
    public ParKhzcmxMapping parkhzcmxMapping;

    @PreAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(#parkhzcmxdto),'ehr-ParKhzcmx-Create')")
    @ApiOperation(value = "新建考核模板明细", tags = {"考核模板明细" },  notes = "新建考核模板明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhzcmxes")
    @Transactional
    public ResponseEntity<ParKhzcmxDTO> create(@RequestBody ParKhzcmxDTO parkhzcmxdto) {
        ParKhzcmx domain = parkhzcmxMapping.toDomain(parkhzcmxdto);
		parkhzcmxService.create(domain);
        ParKhzcmxDTO dto = parkhzcmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(#parkhzcmxdtos),'ehr-ParKhzcmx-Create')")
    @ApiOperation(value = "批量新建考核模板明细", tags = {"考核模板明细" },  notes = "批量新建考核模板明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhzcmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ParKhzcmxDTO> parkhzcmxdtos) {
        parkhzcmxService.createBatch(parkhzcmxMapping.toDomain(parkhzcmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(#parkhzcmxdto),'ehr-ParKhzcmx-Save')")
    @ApiOperation(value = "保存考核模板明细", tags = {"考核模板明细" },  notes = "保存考核模板明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhzcmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody ParKhzcmxDTO parkhzcmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(parkhzcmxService.save(parkhzcmxMapping.toDomain(parkhzcmxdto)));
    }

    @PreAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(#parkhzcmxdtos),'ehr-ParKhzcmx-Save')")
    @ApiOperation(value = "批量保存考核模板明细", tags = {"考核模板明细" },  notes = "批量保存考核模板明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhzcmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ParKhzcmxDTO> parkhzcmxdtos) {
        parkhzcmxService.saveBatch(parkhzcmxMapping.toDomain(parkhzcmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(returnObject.body),'ehr-ParKhzcmx-Get')")
    @ApiOperation(value = "获取考核模板明细", tags = {"考核模板明细" },  notes = "获取考核模板明细")
	@RequestMapping(method = RequestMethod.GET, value = "/parkhzcmxes/{parkhzcmx_id}")
    public ResponseEntity<ParKhzcmxDTO> get(@PathVariable("parkhzcmx_id") String parkhzcmx_id) {
        ParKhzcmx domain = parkhzcmxService.get(parkhzcmx_id);
        ParKhzcmxDTO dto = parkhzcmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取考核模板明细草稿", tags = {"考核模板明细" },  notes = "获取考核模板明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/parkhzcmxes/getdraft")
    public ResponseEntity<ParKhzcmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(parkhzcmxMapping.toDto(parkhzcmxService.getDraft(new ParKhzcmx())));
    }

    @PreAuthorize("hasPermission(this.parkhzcmxService.get(#parkhzcmx_id),'ehr-ParKhzcmx-Remove')")
    @ApiOperation(value = "删除考核模板明细", tags = {"考核模板明细" },  notes = "删除考核模板明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parkhzcmxes/{parkhzcmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("parkhzcmx_id") String parkhzcmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(parkhzcmxService.remove(parkhzcmx_id));
    }

    @PreAuthorize("hasPermission(this.parkhzcmxService.getParkhzcmxByIds(#ids),'ehr-ParKhzcmx-Remove')")
    @ApiOperation(value = "批量删除考核模板明细", tags = {"考核模板明细" },  notes = "批量删除考核模板明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parkhzcmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        parkhzcmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查考核模板明细", tags = {"考核模板明细" },  notes = "检查考核模板明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parkhzcmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ParKhzcmxDTO parkhzcmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parkhzcmxService.checkKey(parkhzcmxMapping.toDomain(parkhzcmxdto)));
    }

    @PreAuthorize("hasPermission(this.parkhzcmxService.get(#parkhzcmx_id),'ehr-ParKhzcmx-Update')")
    @ApiOperation(value = "更新考核模板明细", tags = {"考核模板明细" },  notes = "更新考核模板明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/parkhzcmxes/{parkhzcmx_id}")
    @Transactional
    public ResponseEntity<ParKhzcmxDTO> update(@PathVariable("parkhzcmx_id") String parkhzcmx_id, @RequestBody ParKhzcmxDTO parkhzcmxdto) {
		ParKhzcmx domain  = parkhzcmxMapping.toDomain(parkhzcmxdto);
        domain .setParkhzcmxid(parkhzcmx_id);
		parkhzcmxService.update(domain );
		ParKhzcmxDTO dto = parkhzcmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parkhzcmxService.getParkhzcmxByEntities(this.parkhzcmxMapping.toDomain(#parkhzcmxdtos)),'ehr-ParKhzcmx-Update')")
    @ApiOperation(value = "批量更新考核模板明细", tags = {"考核模板明细" },  notes = "批量更新考核模板明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/parkhzcmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ParKhzcmxDTO> parkhzcmxdtos) {
        parkhzcmxService.updateBatch(parkhzcmxMapping.toDomain(parkhzcmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParKhzcmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"考核模板明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parkhzcmxes/fetchdefault")
	public ResponseEntity<List<ParKhzcmxDTO>> fetchDefault(ParKhzcmxSearchContext context) {
        Page<ParKhzcmx> domains = parkhzcmxService.searchDefault(context) ;
        List<ParKhzcmxDTO> list = parkhzcmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParKhzcmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"考核模板明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parkhzcmxes/searchdefault")
	public ResponseEntity<Page<ParKhzcmxDTO>> searchDefault(@RequestBody ParKhzcmxSearchContext context) {
        Page<ParKhzcmx> domains = parkhzcmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parkhzcmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(#parkhzcmxdto),'ehr-ParKhzcmx-Create')")
    @ApiOperation(value = "根据考核模板建立考核模板明细", tags = {"考核模板明细" },  notes = "根据考核模板建立考核模板明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parassesstemplates/{parassesstemplate_id}/parkhzcmxes")
    @Transactional
    public ResponseEntity<ParKhzcmxDTO> createByParAssessTemplate(@PathVariable("parassesstemplate_id") String parassesstemplate_id, @RequestBody ParKhzcmxDTO parkhzcmxdto) {
        ParKhzcmx domain = parkhzcmxMapping.toDomain(parkhzcmxdto);
        domain.setParassesstemplateid(parassesstemplate_id);
		parkhzcmxService.create(domain);
        ParKhzcmxDTO dto = parkhzcmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(#parkhzcmxdtos),'ehr-ParKhzcmx-Create')")
    @ApiOperation(value = "根据考核模板批量建立考核模板明细", tags = {"考核模板明细" },  notes = "根据考核模板批量建立考核模板明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parassesstemplates/{parassesstemplate_id}/parkhzcmxes/batch")
    public ResponseEntity<Boolean> createBatchByParAssessTemplate(@PathVariable("parassesstemplate_id") String parassesstemplate_id, @RequestBody List<ParKhzcmxDTO> parkhzcmxdtos) {
        List<ParKhzcmx> domainlist=parkhzcmxMapping.toDomain(parkhzcmxdtos);
        for(ParKhzcmx domain:domainlist){
            domain.setParassesstemplateid(parassesstemplate_id);
        }
        parkhzcmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(#parkhzcmxdto),'ehr-ParKhzcmx-Save')")
    @ApiOperation(value = "根据考核模板保存考核模板明细", tags = {"考核模板明细" },  notes = "根据考核模板保存考核模板明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parassesstemplates/{parassesstemplate_id}/parkhzcmxes/save")
    public ResponseEntity<Boolean> saveByParAssessTemplate(@PathVariable("parassesstemplate_id") String parassesstemplate_id, @RequestBody ParKhzcmxDTO parkhzcmxdto) {
        ParKhzcmx domain = parkhzcmxMapping.toDomain(parkhzcmxdto);
        domain.setParassesstemplateid(parassesstemplate_id);
        return ResponseEntity.status(HttpStatus.OK).body(parkhzcmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(#parkhzcmxdtos),'ehr-ParKhzcmx-Save')")
    @ApiOperation(value = "根据考核模板批量保存考核模板明细", tags = {"考核模板明细" },  notes = "根据考核模板批量保存考核模板明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parassesstemplates/{parassesstemplate_id}/parkhzcmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByParAssessTemplate(@PathVariable("parassesstemplate_id") String parassesstemplate_id, @RequestBody List<ParKhzcmxDTO> parkhzcmxdtos) {
        List<ParKhzcmx> domainlist=parkhzcmxMapping.toDomain(parkhzcmxdtos);
        for(ParKhzcmx domain:domainlist){
             domain.setParassesstemplateid(parassesstemplate_id);
        }
        parkhzcmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(returnObject.body),'ehr-ParKhzcmx-Get')")
    @ApiOperation(value = "根据考核模板获取考核模板明细", tags = {"考核模板明细" },  notes = "根据考核模板获取考核模板明细")
	@RequestMapping(method = RequestMethod.GET, value = "/parassesstemplates/{parassesstemplate_id}/parkhzcmxes/{parkhzcmx_id}")
    public ResponseEntity<ParKhzcmxDTO> getByParAssessTemplate(@PathVariable("parassesstemplate_id") String parassesstemplate_id, @PathVariable("parkhzcmx_id") String parkhzcmx_id) {
        ParKhzcmx domain = parkhzcmxService.get(parkhzcmx_id);
        ParKhzcmxDTO dto = parkhzcmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据考核模板获取考核模板明细草稿", tags = {"考核模板明细" },  notes = "根据考核模板获取考核模板明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/parassesstemplates/{parassesstemplate_id}/parkhzcmxes/getdraft")
    public ResponseEntity<ParKhzcmxDTO> getDraftByParAssessTemplate(@PathVariable("parassesstemplate_id") String parassesstemplate_id) {
        ParKhzcmx domain = new ParKhzcmx();
        domain.setParassesstemplateid(parassesstemplate_id);
        return ResponseEntity.status(HttpStatus.OK).body(parkhzcmxMapping.toDto(parkhzcmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.parkhzcmxService.get(#parkhzcmx_id),'ehr-ParKhzcmx-Remove')")
    @ApiOperation(value = "根据考核模板删除考核模板明细", tags = {"考核模板明细" },  notes = "根据考核模板删除考核模板明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parassesstemplates/{parassesstemplate_id}/parkhzcmxes/{parkhzcmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByParAssessTemplate(@PathVariable("parassesstemplate_id") String parassesstemplate_id, @PathVariable("parkhzcmx_id") String parkhzcmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parkhzcmxService.remove(parkhzcmx_id));
    }

    @PreAuthorize("hasPermission(this.parkhzcmxService.getParkhzcmxByIds(#ids),'ehr-ParKhzcmx-Remove')")
    @ApiOperation(value = "根据考核模板批量删除考核模板明细", tags = {"考核模板明细" },  notes = "根据考核模板批量删除考核模板明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parassesstemplates/{parassesstemplate_id}/parkhzcmxes/batch")
    public ResponseEntity<Boolean> removeBatchByParAssessTemplate(@RequestBody List<String> ids) {
        parkhzcmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据考核模板检查考核模板明细", tags = {"考核模板明细" },  notes = "根据考核模板检查考核模板明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parassesstemplates/{parassesstemplate_id}/parkhzcmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByParAssessTemplate(@PathVariable("parassesstemplate_id") String parassesstemplate_id, @RequestBody ParKhzcmxDTO parkhzcmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parkhzcmxService.checkKey(parkhzcmxMapping.toDomain(parkhzcmxdto)));
    }

    @PreAuthorize("hasPermission(this.parkhzcmxService.get(#parkhzcmx_id),'ehr-ParKhzcmx-Update')")
    @ApiOperation(value = "根据考核模板更新考核模板明细", tags = {"考核模板明细" },  notes = "根据考核模板更新考核模板明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/parassesstemplates/{parassesstemplate_id}/parkhzcmxes/{parkhzcmx_id}")
    @Transactional
    public ResponseEntity<ParKhzcmxDTO> updateByParAssessTemplate(@PathVariable("parassesstemplate_id") String parassesstemplate_id, @PathVariable("parkhzcmx_id") String parkhzcmx_id, @RequestBody ParKhzcmxDTO parkhzcmxdto) {
        ParKhzcmx domain = parkhzcmxMapping.toDomain(parkhzcmxdto);
        domain.setParassesstemplateid(parassesstemplate_id);
        domain.setParkhzcmxid(parkhzcmx_id);
		parkhzcmxService.update(domain);
        ParKhzcmxDTO dto = parkhzcmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parkhzcmxService.getParkhzcmxByEntities(this.parkhzcmxMapping.toDomain(#parkhzcmxdtos)),'ehr-ParKhzcmx-Update')")
    @ApiOperation(value = "根据考核模板批量更新考核模板明细", tags = {"考核模板明细" },  notes = "根据考核模板批量更新考核模板明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/parassesstemplates/{parassesstemplate_id}/parkhzcmxes/batch")
    public ResponseEntity<Boolean> updateBatchByParAssessTemplate(@PathVariable("parassesstemplate_id") String parassesstemplate_id, @RequestBody List<ParKhzcmxDTO> parkhzcmxdtos) {
        List<ParKhzcmx> domainlist=parkhzcmxMapping.toDomain(parkhzcmxdtos);
        for(ParKhzcmx domain:domainlist){
            domain.setParassesstemplateid(parassesstemplate_id);
        }
        parkhzcmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParKhzcmx-Default-all')")
	@ApiOperation(value = "根据考核模板获取DEFAULT", tags = {"考核模板明细" } ,notes = "根据考核模板获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parassesstemplates/{parassesstemplate_id}/parkhzcmxes/fetchdefault")
	public ResponseEntity<List<ParKhzcmxDTO>> fetchParKhzcmxDefaultByParAssessTemplate(@PathVariable("parassesstemplate_id") String parassesstemplate_id,ParKhzcmxSearchContext context) {
        context.setN_parassesstemplateid_eq(parassesstemplate_id);
        Page<ParKhzcmx> domains = parkhzcmxService.searchDefault(context) ;
        List<ParKhzcmxDTO> list = parkhzcmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParKhzcmx-Default-all')")
	@ApiOperation(value = "根据考核模板查询DEFAULT", tags = {"考核模板明细" } ,notes = "根据考核模板查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parassesstemplates/{parassesstemplate_id}/parkhzcmxes/searchdefault")
	public ResponseEntity<Page<ParKhzcmxDTO>> searchParKhzcmxDefaultByParAssessTemplate(@PathVariable("parassesstemplate_id") String parassesstemplate_id, @RequestBody ParKhzcmxSearchContext context) {
        context.setN_parassesstemplateid_eq(parassesstemplate_id);
        Page<ParKhzcmx> domains = parkhzcmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parkhzcmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(#parkhzcmxdto),'ehr-ParKhzcmx-Create')")
    @ApiOperation(value = "根据考核方案建立考核模板明细", tags = {"考核模板明细" },  notes = "根据考核方案建立考核模板明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes")
    @Transactional
    public ResponseEntity<ParKhzcmxDTO> createByParJxkhjcsz(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id, @RequestBody ParKhzcmxDTO parkhzcmxdto) {
        ParKhzcmx domain = parkhzcmxMapping.toDomain(parkhzcmxdto);
        domain.setParjxkhjcszid(parjxkhjcsz_id);
		parkhzcmxService.create(domain);
        ParKhzcmxDTO dto = parkhzcmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(#parkhzcmxdtos),'ehr-ParKhzcmx-Create')")
    @ApiOperation(value = "根据考核方案批量建立考核模板明细", tags = {"考核模板明细" },  notes = "根据考核方案批量建立考核模板明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes/batch")
    public ResponseEntity<Boolean> createBatchByParJxkhjcsz(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id, @RequestBody List<ParKhzcmxDTO> parkhzcmxdtos) {
        List<ParKhzcmx> domainlist=parkhzcmxMapping.toDomain(parkhzcmxdtos);
        for(ParKhzcmx domain:domainlist){
            domain.setParjxkhjcszid(parjxkhjcsz_id);
        }
        parkhzcmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(#parkhzcmxdto),'ehr-ParKhzcmx-Save')")
    @ApiOperation(value = "根据考核方案保存考核模板明细", tags = {"考核模板明细" },  notes = "根据考核方案保存考核模板明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes/save")
    public ResponseEntity<Boolean> saveByParJxkhjcsz(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id, @RequestBody ParKhzcmxDTO parkhzcmxdto) {
        ParKhzcmx domain = parkhzcmxMapping.toDomain(parkhzcmxdto);
        domain.setParjxkhjcszid(parjxkhjcsz_id);
        return ResponseEntity.status(HttpStatus.OK).body(parkhzcmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(#parkhzcmxdtos),'ehr-ParKhzcmx-Save')")
    @ApiOperation(value = "根据考核方案批量保存考核模板明细", tags = {"考核模板明细" },  notes = "根据考核方案批量保存考核模板明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByParJxkhjcsz(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id, @RequestBody List<ParKhzcmxDTO> parkhzcmxdtos) {
        List<ParKhzcmx> domainlist=parkhzcmxMapping.toDomain(parkhzcmxdtos);
        for(ParKhzcmx domain:domainlist){
             domain.setParjxkhjcszid(parjxkhjcsz_id);
        }
        parkhzcmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.parkhzcmxMapping.toDomain(returnObject.body),'ehr-ParKhzcmx-Get')")
    @ApiOperation(value = "根据考核方案获取考核模板明细", tags = {"考核模板明细" },  notes = "根据考核方案获取考核模板明细")
	@RequestMapping(method = RequestMethod.GET, value = "/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes/{parkhzcmx_id}")
    public ResponseEntity<ParKhzcmxDTO> getByParJxkhjcsz(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id, @PathVariable("parkhzcmx_id") String parkhzcmx_id) {
        ParKhzcmx domain = parkhzcmxService.get(parkhzcmx_id);
        ParKhzcmxDTO dto = parkhzcmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据考核方案获取考核模板明细草稿", tags = {"考核模板明细" },  notes = "根据考核方案获取考核模板明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes/getdraft")
    public ResponseEntity<ParKhzcmxDTO> getDraftByParJxkhjcsz(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id) {
        ParKhzcmx domain = new ParKhzcmx();
        domain.setParjxkhjcszid(parjxkhjcsz_id);
        return ResponseEntity.status(HttpStatus.OK).body(parkhzcmxMapping.toDto(parkhzcmxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.parkhzcmxService.get(#parkhzcmx_id),'ehr-ParKhzcmx-Remove')")
    @ApiOperation(value = "根据考核方案删除考核模板明细", tags = {"考核模板明细" },  notes = "根据考核方案删除考核模板明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes/{parkhzcmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByParJxkhjcsz(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id, @PathVariable("parkhzcmx_id") String parkhzcmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(parkhzcmxService.remove(parkhzcmx_id));
    }

    @PreAuthorize("hasPermission(this.parkhzcmxService.getParkhzcmxByIds(#ids),'ehr-ParKhzcmx-Remove')")
    @ApiOperation(value = "根据考核方案批量删除考核模板明细", tags = {"考核模板明细" },  notes = "根据考核方案批量删除考核模板明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes/batch")
    public ResponseEntity<Boolean> removeBatchByParJxkhjcsz(@RequestBody List<String> ids) {
        parkhzcmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据考核方案检查考核模板明细", tags = {"考核模板明细" },  notes = "根据考核方案检查考核模板明细")
	@RequestMapping(method = RequestMethod.POST, value = "/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByParJxkhjcsz(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id, @RequestBody ParKhzcmxDTO parkhzcmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(parkhzcmxService.checkKey(parkhzcmxMapping.toDomain(parkhzcmxdto)));
    }

    @PreAuthorize("hasPermission(this.parkhzcmxService.get(#parkhzcmx_id),'ehr-ParKhzcmx-Update')")
    @ApiOperation(value = "根据考核方案更新考核模板明细", tags = {"考核模板明细" },  notes = "根据考核方案更新考核模板明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes/{parkhzcmx_id}")
    @Transactional
    public ResponseEntity<ParKhzcmxDTO> updateByParJxkhjcsz(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id, @PathVariable("parkhzcmx_id") String parkhzcmx_id, @RequestBody ParKhzcmxDTO parkhzcmxdto) {
        ParKhzcmx domain = parkhzcmxMapping.toDomain(parkhzcmxdto);
        domain.setParjxkhjcszid(parjxkhjcsz_id);
        domain.setParkhzcmxid(parkhzcmx_id);
		parkhzcmxService.update(domain);
        ParKhzcmxDTO dto = parkhzcmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.parkhzcmxService.getParkhzcmxByEntities(this.parkhzcmxMapping.toDomain(#parkhzcmxdtos)),'ehr-ParKhzcmx-Update')")
    @ApiOperation(value = "根据考核方案批量更新考核模板明细", tags = {"考核模板明细" },  notes = "根据考核方案批量更新考核模板明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes/batch")
    public ResponseEntity<Boolean> updateBatchByParJxkhjcsz(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id, @RequestBody List<ParKhzcmxDTO> parkhzcmxdtos) {
        List<ParKhzcmx> domainlist=parkhzcmxMapping.toDomain(parkhzcmxdtos);
        for(ParKhzcmx domain:domainlist){
            domain.setParjxkhjcszid(parjxkhjcsz_id);
        }
        parkhzcmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParKhzcmx-Default-all')")
	@ApiOperation(value = "根据考核方案获取DEFAULT", tags = {"考核模板明细" } ,notes = "根据考核方案获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes/fetchdefault")
	public ResponseEntity<List<ParKhzcmxDTO>> fetchParKhzcmxDefaultByParJxkhjcsz(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id,ParKhzcmxSearchContext context) {
        context.setN_parjxkhjcszid_eq(parjxkhjcsz_id);
        Page<ParKhzcmx> domains = parkhzcmxService.searchDefault(context) ;
        List<ParKhzcmxDTO> list = parkhzcmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ParKhzcmx-Default-all')")
	@ApiOperation(value = "根据考核方案查询DEFAULT", tags = {"考核模板明细" } ,notes = "根据考核方案查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/parjxkhjcszs/{parjxkhjcsz_id}/parkhzcmxes/searchdefault")
	public ResponseEntity<Page<ParKhzcmxDTO>> searchParKhzcmxDefaultByParJxkhjcsz(@PathVariable("parjxkhjcsz_id") String parjxkhjcsz_id, @RequestBody ParKhzcmxSearchContext context) {
        context.setN_parjxkhjcszid_eq(parjxkhjcsz_id);
        Page<ParKhzcmx> domains = parkhzcmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(parkhzcmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

