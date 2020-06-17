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
import cn.ibizlab.ehr.core.soc.domain.SocRuleDetail;
import cn.ibizlab.ehr.core.soc.service.ISocRuleDetailService;
import cn.ibizlab.ehr.core.soc.filter.SocRuleDetailSearchContext;

@Slf4j
@Api(tags = {"社保规则明细" })
@RestController("WebApi-socruledetail")
@RequestMapping("")
public class SocRuleDetailResource {

    @Autowired
    public ISocRuleDetailService socruledetailService;

    @Autowired
    @Lazy
    public SocRuleDetailMapping socruledetailMapping;

    @ApiOperation(value = "获取社保规则明细草稿", tags = {"社保规则明细" },  notes = "获取社保规则明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/socruledetails/getdraft")
    public ResponseEntity<SocRuleDetailDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(socruledetailMapping.toDto(socruledetailService.getDraft(new SocRuleDetail())));
    }

    @PreAuthorize("hasPermission(this.socruledetailService.get(#socruledetail_id),'ehr-SocRuleDetail-Update')")
    @ApiOperation(value = "更新社保规则明细", tags = {"社保规则明细" },  notes = "更新社保规则明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/socruledetails/{socruledetail_id}")
    @Transactional
    public ResponseEntity<SocRuleDetailDTO> update(@PathVariable("socruledetail_id") String socruledetail_id, @RequestBody SocRuleDetailDTO socruledetaildto) {
		SocRuleDetail domain  = socruledetailMapping.toDomain(socruledetaildto);
        domain .setSocruledetailid(socruledetail_id);
		socruledetailService.update(domain );
		SocRuleDetailDTO dto = socruledetailMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socruledetailService.getSocruledetailByEntities(this.socruledetailMapping.toDomain(#socruledetaildtos)),'ehr-SocRuleDetail-Update')")
    @ApiOperation(value = "批量更新社保规则明细", tags = {"社保规则明细" },  notes = "批量更新社保规则明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/socruledetails/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SocRuleDetailDTO> socruledetaildtos) {
        socruledetailService.updateBatch(socruledetailMapping.toDomain(socruledetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.socruledetailMapping.toDomain(returnObject.body),'ehr-SocRuleDetail-Get')")
    @ApiOperation(value = "获取社保规则明细", tags = {"社保规则明细" },  notes = "获取社保规则明细")
	@RequestMapping(method = RequestMethod.GET, value = "/socruledetails/{socruledetail_id}")
    public ResponseEntity<SocRuleDetailDTO> get(@PathVariable("socruledetail_id") String socruledetail_id) {
        SocRuleDetail domain = socruledetailService.get(socruledetail_id);
        SocRuleDetailDTO dto = socruledetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socruledetailMapping.toDomain(#socruledetaildto),'ehr-SocRuleDetail-Create')")
    @ApiOperation(value = "新建社保规则明细", tags = {"社保规则明细" },  notes = "新建社保规则明细")
	@RequestMapping(method = RequestMethod.POST, value = "/socruledetails")
    @Transactional
    public ResponseEntity<SocRuleDetailDTO> create(@RequestBody SocRuleDetailDTO socruledetaildto) {
        SocRuleDetail domain = socruledetailMapping.toDomain(socruledetaildto);
		socruledetailService.create(domain);
        SocRuleDetailDTO dto = socruledetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socruledetailMapping.toDomain(#socruledetaildtos),'ehr-SocRuleDetail-Create')")
    @ApiOperation(value = "批量新建社保规则明细", tags = {"社保规则明细" },  notes = "批量新建社保规则明细")
	@RequestMapping(method = RequestMethod.POST, value = "/socruledetails/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SocRuleDetailDTO> socruledetaildtos) {
        socruledetailService.createBatch(socruledetailMapping.toDomain(socruledetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.socruledetailMapping.toDomain(#socruledetaildto),'ehr-SocRuleDetail-Save')")
    @ApiOperation(value = "保存社保规则明细", tags = {"社保规则明细" },  notes = "保存社保规则明细")
	@RequestMapping(method = RequestMethod.POST, value = "/socruledetails/save")
    public ResponseEntity<Boolean> save(@RequestBody SocRuleDetailDTO socruledetaildto) {
        return ResponseEntity.status(HttpStatus.OK).body(socruledetailService.save(socruledetailMapping.toDomain(socruledetaildto)));
    }

    @PreAuthorize("hasPermission(this.socruledetailMapping.toDomain(#socruledetaildtos),'ehr-SocRuleDetail-Save')")
    @ApiOperation(value = "批量保存社保规则明细", tags = {"社保规则明细" },  notes = "批量保存社保规则明细")
	@RequestMapping(method = RequestMethod.POST, value = "/socruledetails/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SocRuleDetailDTO> socruledetaildtos) {
        socruledetailService.saveBatch(socruledetailMapping.toDomain(socruledetaildtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.socruledetailService.get(#socruledetail_id),'ehr-SocRuleDetail-Remove')")
    @ApiOperation(value = "删除社保规则明细", tags = {"社保规则明细" },  notes = "删除社保规则明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socruledetails/{socruledetail_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("socruledetail_id") String socruledetail_id) {
         return ResponseEntity.status(HttpStatus.OK).body(socruledetailService.remove(socruledetail_id));
    }

    @PreAuthorize("hasPermission(this.socruledetailService.getSocruledetailByIds(#ids),'ehr-SocRuleDetail-Remove')")
    @ApiOperation(value = "批量删除社保规则明细", tags = {"社保规则明细" },  notes = "批量删除社保规则明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socruledetails/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        socruledetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查社保规则明细", tags = {"社保规则明细" },  notes = "检查社保规则明细")
	@RequestMapping(method = RequestMethod.POST, value = "/socruledetails/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SocRuleDetailDTO socruledetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(socruledetailService.checkKey(socruledetailMapping.toDomain(socruledetaildto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocRuleDetail-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"社保规则明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/socruledetails/fetchdefault")
	public ResponseEntity<List<SocRuleDetailDTO>> fetchDefault(SocRuleDetailSearchContext context) {
        Page<SocRuleDetail> domains = socruledetailService.searchDefault(context) ;
        List<SocRuleDetailDTO> list = socruledetailMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocRuleDetail-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"社保规则明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/socruledetails/searchdefault")
	public ResponseEntity<Page<SocRuleDetailDTO>> searchDefault(@RequestBody SocRuleDetailSearchContext context) {
        Page<SocRuleDetail> domains = socruledetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(socruledetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "根据社保规则获取社保规则明细草稿", tags = {"社保规则明细" },  notes = "根据社保规则获取社保规则明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/socrules/{socrule_id}/socruledetails/getdraft")
    public ResponseEntity<SocRuleDetailDTO> getDraftBySocRule(@PathVariable("socrule_id") String socrule_id) {
        SocRuleDetail domain = new SocRuleDetail();
        domain.setSocruleid(socrule_id);
        return ResponseEntity.status(HttpStatus.OK).body(socruledetailMapping.toDto(socruledetailService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.socruledetailService.get(#socruledetail_id),'ehr-SocRuleDetail-Update')")
    @ApiOperation(value = "根据社保规则更新社保规则明细", tags = {"社保规则明细" },  notes = "根据社保规则更新社保规则明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/socrules/{socrule_id}/socruledetails/{socruledetail_id}")
    @Transactional
    public ResponseEntity<SocRuleDetailDTO> updateBySocRule(@PathVariable("socrule_id") String socrule_id, @PathVariable("socruledetail_id") String socruledetail_id, @RequestBody SocRuleDetailDTO socruledetaildto) {
        SocRuleDetail domain = socruledetailMapping.toDomain(socruledetaildto);
        domain.setSocruleid(socrule_id);
        domain.setSocruledetailid(socruledetail_id);
		socruledetailService.update(domain);
        SocRuleDetailDTO dto = socruledetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socruledetailService.getSocruledetailByEntities(this.socruledetailMapping.toDomain(#socruledetaildtos)),'ehr-SocRuleDetail-Update')")
    @ApiOperation(value = "根据社保规则批量更新社保规则明细", tags = {"社保规则明细" },  notes = "根据社保规则批量更新社保规则明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/socrules/{socrule_id}/socruledetails/batch")
    public ResponseEntity<Boolean> updateBatchBySocRule(@PathVariable("socrule_id") String socrule_id, @RequestBody List<SocRuleDetailDTO> socruledetaildtos) {
        List<SocRuleDetail> domainlist=socruledetailMapping.toDomain(socruledetaildtos);
        for(SocRuleDetail domain:domainlist){
            domain.setSocruleid(socrule_id);
        }
        socruledetailService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.socruledetailMapping.toDomain(returnObject.body),'ehr-SocRuleDetail-Get')")
    @ApiOperation(value = "根据社保规则获取社保规则明细", tags = {"社保规则明细" },  notes = "根据社保规则获取社保规则明细")
	@RequestMapping(method = RequestMethod.GET, value = "/socrules/{socrule_id}/socruledetails/{socruledetail_id}")
    public ResponseEntity<SocRuleDetailDTO> getBySocRule(@PathVariable("socrule_id") String socrule_id, @PathVariable("socruledetail_id") String socruledetail_id) {
        SocRuleDetail domain = socruledetailService.get(socruledetail_id);
        SocRuleDetailDTO dto = socruledetailMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socruledetailMapping.toDomain(#socruledetaildto),'ehr-SocRuleDetail-Create')")
    @ApiOperation(value = "根据社保规则建立社保规则明细", tags = {"社保规则明细" },  notes = "根据社保规则建立社保规则明细")
	@RequestMapping(method = RequestMethod.POST, value = "/socrules/{socrule_id}/socruledetails")
    @Transactional
    public ResponseEntity<SocRuleDetailDTO> createBySocRule(@PathVariable("socrule_id") String socrule_id, @RequestBody SocRuleDetailDTO socruledetaildto) {
        SocRuleDetail domain = socruledetailMapping.toDomain(socruledetaildto);
        domain.setSocruleid(socrule_id);
		socruledetailService.create(domain);
        SocRuleDetailDTO dto = socruledetailMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socruledetailMapping.toDomain(#socruledetaildtos),'ehr-SocRuleDetail-Create')")
    @ApiOperation(value = "根据社保规则批量建立社保规则明细", tags = {"社保规则明细" },  notes = "根据社保规则批量建立社保规则明细")
	@RequestMapping(method = RequestMethod.POST, value = "/socrules/{socrule_id}/socruledetails/batch")
    public ResponseEntity<Boolean> createBatchBySocRule(@PathVariable("socrule_id") String socrule_id, @RequestBody List<SocRuleDetailDTO> socruledetaildtos) {
        List<SocRuleDetail> domainlist=socruledetailMapping.toDomain(socruledetaildtos);
        for(SocRuleDetail domain:domainlist){
            domain.setSocruleid(socrule_id);
        }
        socruledetailService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.socruledetailMapping.toDomain(#socruledetaildto),'ehr-SocRuleDetail-Save')")
    @ApiOperation(value = "根据社保规则保存社保规则明细", tags = {"社保规则明细" },  notes = "根据社保规则保存社保规则明细")
	@RequestMapping(method = RequestMethod.POST, value = "/socrules/{socrule_id}/socruledetails/save")
    public ResponseEntity<Boolean> saveBySocRule(@PathVariable("socrule_id") String socrule_id, @RequestBody SocRuleDetailDTO socruledetaildto) {
        SocRuleDetail domain = socruledetailMapping.toDomain(socruledetaildto);
        domain.setSocruleid(socrule_id);
        return ResponseEntity.status(HttpStatus.OK).body(socruledetailService.save(domain));
    }

    @PreAuthorize("hasPermission(this.socruledetailMapping.toDomain(#socruledetaildtos),'ehr-SocRuleDetail-Save')")
    @ApiOperation(value = "根据社保规则批量保存社保规则明细", tags = {"社保规则明细" },  notes = "根据社保规则批量保存社保规则明细")
	@RequestMapping(method = RequestMethod.POST, value = "/socrules/{socrule_id}/socruledetails/savebatch")
    public ResponseEntity<Boolean> saveBatchBySocRule(@PathVariable("socrule_id") String socrule_id, @RequestBody List<SocRuleDetailDTO> socruledetaildtos) {
        List<SocRuleDetail> domainlist=socruledetailMapping.toDomain(socruledetaildtos);
        for(SocRuleDetail domain:domainlist){
             domain.setSocruleid(socrule_id);
        }
        socruledetailService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.socruledetailService.get(#socruledetail_id),'ehr-SocRuleDetail-Remove')")
    @ApiOperation(value = "根据社保规则删除社保规则明细", tags = {"社保规则明细" },  notes = "根据社保规则删除社保规则明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socrules/{socrule_id}/socruledetails/{socruledetail_id}")
    @Transactional
    public ResponseEntity<Boolean> removeBySocRule(@PathVariable("socrule_id") String socrule_id, @PathVariable("socruledetail_id") String socruledetail_id) {
		return ResponseEntity.status(HttpStatus.OK).body(socruledetailService.remove(socruledetail_id));
    }

    @PreAuthorize("hasPermission(this.socruledetailService.getSocruledetailByIds(#ids),'ehr-SocRuleDetail-Remove')")
    @ApiOperation(value = "根据社保规则批量删除社保规则明细", tags = {"社保规则明细" },  notes = "根据社保规则批量删除社保规则明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socrules/{socrule_id}/socruledetails/batch")
    public ResponseEntity<Boolean> removeBatchBySocRule(@RequestBody List<String> ids) {
        socruledetailService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据社保规则检查社保规则明细", tags = {"社保规则明细" },  notes = "根据社保规则检查社保规则明细")
	@RequestMapping(method = RequestMethod.POST, value = "/socrules/{socrule_id}/socruledetails/checkkey")
    public ResponseEntity<Boolean> checkKeyBySocRule(@PathVariable("socrule_id") String socrule_id, @RequestBody SocRuleDetailDTO socruledetaildto) {
        return  ResponseEntity.status(HttpStatus.OK).body(socruledetailService.checkKey(socruledetailMapping.toDomain(socruledetaildto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocRuleDetail-Default-all')")
	@ApiOperation(value = "根据社保规则获取DEFAULT", tags = {"社保规则明细" } ,notes = "根据社保规则获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/socrules/{socrule_id}/socruledetails/fetchdefault")
	public ResponseEntity<List<SocRuleDetailDTO>> fetchSocRuleDetailDefaultBySocRule(@PathVariable("socrule_id") String socrule_id,SocRuleDetailSearchContext context) {
        context.setN_socruleid_eq(socrule_id);
        Page<SocRuleDetail> domains = socruledetailService.searchDefault(context) ;
        List<SocRuleDetailDTO> list = socruledetailMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocRuleDetail-Default-all')")
	@ApiOperation(value = "根据社保规则查询DEFAULT", tags = {"社保规则明细" } ,notes = "根据社保规则查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/socrules/{socrule_id}/socruledetails/searchdefault")
	public ResponseEntity<Page<SocRuleDetailDTO>> searchSocRuleDetailDefaultBySocRule(@PathVariable("socrule_id") String socrule_id, @RequestBody SocRuleDetailSearchContext context) {
        context.setN_socruleid_eq(socrule_id);
        Page<SocRuleDetail> domains = socruledetailService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(socruledetailMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

