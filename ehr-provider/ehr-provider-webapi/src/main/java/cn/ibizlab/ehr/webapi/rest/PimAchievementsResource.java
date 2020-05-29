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
import cn.ibizlab.ehr.core.pim.domain.PimAchievements;
import cn.ibizlab.ehr.core.pim.service.IPimAchievementsService;
import cn.ibizlab.ehr.core.pim.filter.PimAchievementsSearchContext;

@Slf4j
@Api(tags = {"绩效信息" })
@RestController("WebApi-pimachievements")
@RequestMapping("")
public class PimAchievementsResource {

    @Autowired
    public IPimAchievementsService pimachievementsService;

    @Autowired
    @Lazy
    public PimAchievementsMapping pimachievementsMapping;

    @PreAuthorize("hasPermission(this.pimachievementsService.get(#pimachievements_id),'ehr-PimAchievements-Update')")
    @ApiOperation(value = "更新绩效信息", tags = {"绩效信息" },  notes = "更新绩效信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimachievements/{pimachievements_id}")
    @Transactional
    public ResponseEntity<PimAchievementsDTO> update(@PathVariable("pimachievements_id") String pimachievements_id, @RequestBody PimAchievementsDTO pimachievementsdto) {
		PimAchievements domain  = pimachievementsMapping.toDomain(pimachievementsdto);
        domain .setPimachievementsid(pimachievements_id);
		pimachievementsService.update(domain );
		PimAchievementsDTO dto = pimachievementsMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimachievementsService.getPimachievementsByEntities(this.pimachievementsMapping.toDomain(#pimachievementsdtos)),'ehr-PimAchievements-Update')")
    @ApiOperation(value = "批量更新绩效信息", tags = {"绩效信息" },  notes = "批量更新绩效信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimachievements/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimAchievementsDTO> pimachievementsdtos) {
        pimachievementsService.updateBatch(pimachievementsMapping.toDomain(pimachievementsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimachievementsMapping.toDomain(#pimachievementsdto),'ehr-PimAchievements-Save')")
    @ApiOperation(value = "保存绩效信息", tags = {"绩效信息" },  notes = "保存绩效信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimachievements/save")
    public ResponseEntity<Boolean> save(@RequestBody PimAchievementsDTO pimachievementsdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimachievementsService.save(pimachievementsMapping.toDomain(pimachievementsdto)));
    }

    @PreAuthorize("hasPermission(this.pimachievementsMapping.toDomain(#pimachievementsdtos),'ehr-PimAchievements-Save')")
    @ApiOperation(value = "批量保存绩效信息", tags = {"绩效信息" },  notes = "批量保存绩效信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimachievements/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimAchievementsDTO> pimachievementsdtos) {
        pimachievementsService.saveBatch(pimachievementsMapping.toDomain(pimachievementsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取绩效信息草稿", tags = {"绩效信息" },  notes = "获取绩效信息草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimachievements/getdraft")
    public ResponseEntity<PimAchievementsDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimachievementsMapping.toDto(pimachievementsService.getDraft(new PimAchievements())));
    }

    @PreAuthorize("hasPermission(this.pimachievementsService.get(#pimachievements_id),'ehr-PimAchievements-Remove')")
    @ApiOperation(value = "删除绩效信息", tags = {"绩效信息" },  notes = "删除绩效信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimachievements/{pimachievements_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimachievements_id") String pimachievements_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimachievementsService.remove(pimachievements_id));
    }

    @PreAuthorize("hasPermission(this.pimachievementsService.getPimachievementsByIds(#ids),'ehr-PimAchievements-Remove')")
    @ApiOperation(value = "批量删除绩效信息", tags = {"绩效信息" },  notes = "批量删除绩效信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimachievements/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimachievementsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimachievementsMapping.toDomain(returnObject.body),'ehr-PimAchievements-Get')")
    @ApiOperation(value = "获取绩效信息", tags = {"绩效信息" },  notes = "获取绩效信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pimachievements/{pimachievements_id}")
    public ResponseEntity<PimAchievementsDTO> get(@PathVariable("pimachievements_id") String pimachievements_id) {
        PimAchievements domain = pimachievementsService.get(pimachievements_id);
        PimAchievementsDTO dto = pimachievementsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查绩效信息", tags = {"绩效信息" },  notes = "检查绩效信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimachievements/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimAchievementsDTO pimachievementsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimachievementsService.checkKey(pimachievementsMapping.toDomain(pimachievementsdto)));
    }

    @PreAuthorize("hasPermission(this.pimachievementsMapping.toDomain(#pimachievementsdto),'ehr-PimAchievements-Create')")
    @ApiOperation(value = "新建绩效信息", tags = {"绩效信息" },  notes = "新建绩效信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimachievements")
    @Transactional
    public ResponseEntity<PimAchievementsDTO> create(@RequestBody PimAchievementsDTO pimachievementsdto) {
        PimAchievements domain = pimachievementsMapping.toDomain(pimachievementsdto);
		pimachievementsService.create(domain);
        PimAchievementsDTO dto = pimachievementsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimachievementsMapping.toDomain(#pimachievementsdtos),'ehr-PimAchievements-Create')")
    @ApiOperation(value = "批量新建绩效信息", tags = {"绩效信息" },  notes = "批量新建绩效信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimachievements/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimAchievementsDTO> pimachievementsdtos) {
        pimachievementsService.createBatch(pimachievementsMapping.toDomain(pimachievementsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimAchievements-JLSS-all')")
	@ApiOperation(value = "获取记录所属和人员ID不符的", tags = {"绩效信息" } ,notes = "获取记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.GET , value="/pimachievements/fetchjlss")
	public ResponseEntity<List<PimAchievementsDTO>> fetchJLSS(PimAchievementsSearchContext context) {
        Page<PimAchievements> domains = pimachievementsService.searchJLSS(context) ;
        List<PimAchievementsDTO> list = pimachievementsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimAchievements-JLSS-all')")
	@ApiOperation(value = "查询记录所属和人员ID不符的", tags = {"绩效信息" } ,notes = "查询记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.POST , value="/pimachievements/searchjlss")
	public ResponseEntity<Page<PimAchievementsDTO>> searchJLSS(@RequestBody PimAchievementsSearchContext context) {
        Page<PimAchievements> domains = pimachievementsService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimachievementsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimAchievements-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"绩效信息" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimachievements/fetchdefault")
	public ResponseEntity<List<PimAchievementsDTO>> fetchDefault(PimAchievementsSearchContext context) {
        Page<PimAchievements> domains = pimachievementsService.searchDefault(context) ;
        List<PimAchievementsDTO> list = pimachievementsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimAchievements-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"绩效信息" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimachievements/searchdefault")
	public ResponseEntity<Page<PimAchievementsDTO>> searchDefault(@RequestBody PimAchievementsSearchContext context) {
        Page<PimAchievements> domains = pimachievementsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimachievementsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimAchievements-ZIZHU-all')")
	@ApiOperation(value = "获取自助(绩效信息)", tags = {"绩效信息" } ,notes = "获取自助(绩效信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimachievements/fetchzizhu")
	public ResponseEntity<List<PimAchievementsDTO>> fetchZIZHU(PimAchievementsSearchContext context) {
        Page<PimAchievements> domains = pimachievementsService.searchZIZHU(context) ;
        List<PimAchievementsDTO> list = pimachievementsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimAchievements-ZIZHU-all')")
	@ApiOperation(value = "查询自助(绩效信息)", tags = {"绩效信息" } ,notes = "查询自助(绩效信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimachievements/searchzizhu")
	public ResponseEntity<Page<PimAchievementsDTO>> searchZIZHU(@RequestBody PimAchievementsSearchContext context) {
        Page<PimAchievements> domains = pimachievementsService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimachievementsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimachievementsService.get(#pimachievements_id),'ehr-PimAchievements-Update')")
    @ApiOperation(value = "根据人员信息更新绩效信息", tags = {"绩效信息" },  notes = "根据人员信息更新绩效信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimachievements/{pimachievements_id}")
    @Transactional
    public ResponseEntity<PimAchievementsDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimachievements_id") String pimachievements_id, @RequestBody PimAchievementsDTO pimachievementsdto) {
        PimAchievements domain = pimachievementsMapping.toDomain(pimachievementsdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimachievementsid(pimachievements_id);
		pimachievementsService.update(domain);
        PimAchievementsDTO dto = pimachievementsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimachievementsService.getPimachievementsByEntities(this.pimachievementsMapping.toDomain(#pimachievementsdtos)),'ehr-PimAchievements-Update')")
    @ApiOperation(value = "根据人员信息批量更新绩效信息", tags = {"绩效信息" },  notes = "根据人员信息批量更新绩效信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimachievements/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimAchievementsDTO> pimachievementsdtos) {
        List<PimAchievements> domainlist=pimachievementsMapping.toDomain(pimachievementsdtos);
        for(PimAchievements domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimachievementsService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimachievementsMapping.toDomain(#pimachievementsdto),'ehr-PimAchievements-Save')")
    @ApiOperation(value = "根据人员信息保存绩效信息", tags = {"绩效信息" },  notes = "根据人员信息保存绩效信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimachievements/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimAchievementsDTO pimachievementsdto) {
        PimAchievements domain = pimachievementsMapping.toDomain(pimachievementsdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimachievementsService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimachievementsMapping.toDomain(#pimachievementsdtos),'ehr-PimAchievements-Save')")
    @ApiOperation(value = "根据人员信息批量保存绩效信息", tags = {"绩效信息" },  notes = "根据人员信息批量保存绩效信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimachievements/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimAchievementsDTO> pimachievementsdtos) {
        List<PimAchievements> domainlist=pimachievementsMapping.toDomain(pimachievementsdtos);
        for(PimAchievements domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimachievementsService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息获取绩效信息草稿", tags = {"绩效信息" },  notes = "根据人员信息获取绩效信息草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimachievements/getdraft")
    public ResponseEntity<PimAchievementsDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PimAchievements domain = new PimAchievements();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimachievementsMapping.toDto(pimachievementsService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pimachievementsService.get(#pimachievements_id),'ehr-PimAchievements-Remove')")
    @ApiOperation(value = "根据人员信息删除绩效信息", tags = {"绩效信息" },  notes = "根据人员信息删除绩效信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimachievements/{pimachievements_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimachievements_id") String pimachievements_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimachievementsService.remove(pimachievements_id));
    }

    @PreAuthorize("hasPermission(this.pimachievementsService.getPimachievementsByIds(#ids),'ehr-PimAchievements-Remove')")
    @ApiOperation(value = "根据人员信息批量删除绩效信息", tags = {"绩效信息" },  notes = "根据人员信息批量删除绩效信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimachievements/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimachievementsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimachievementsMapping.toDomain(returnObject.body),'ehr-PimAchievements-Get')")
    @ApiOperation(value = "根据人员信息获取绩效信息", tags = {"绩效信息" },  notes = "根据人员信息获取绩效信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimachievements/{pimachievements_id}")
    public ResponseEntity<PimAchievementsDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimachievements_id") String pimachievements_id) {
        PimAchievements domain = pimachievementsService.get(pimachievements_id);
        PimAchievementsDTO dto = pimachievementsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据人员信息检查绩效信息", tags = {"绩效信息" },  notes = "根据人员信息检查绩效信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimachievements/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimAchievementsDTO pimachievementsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimachievementsService.checkKey(pimachievementsMapping.toDomain(pimachievementsdto)));
    }

    @PreAuthorize("hasPermission(this.pimachievementsMapping.toDomain(#pimachievementsdto),'ehr-PimAchievements-Create')")
    @ApiOperation(value = "根据人员信息建立绩效信息", tags = {"绩效信息" },  notes = "根据人员信息建立绩效信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimachievements")
    @Transactional
    public ResponseEntity<PimAchievementsDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimAchievementsDTO pimachievementsdto) {
        PimAchievements domain = pimachievementsMapping.toDomain(pimachievementsdto);
        domain.setPimpersonid(pimperson_id);
		pimachievementsService.create(domain);
        PimAchievementsDTO dto = pimachievementsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimachievementsMapping.toDomain(#pimachievementsdtos),'ehr-PimAchievements-Create')")
    @ApiOperation(value = "根据人员信息批量建立绩效信息", tags = {"绩效信息" },  notes = "根据人员信息批量建立绩效信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimachievements/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimAchievementsDTO> pimachievementsdtos) {
        List<PimAchievements> domainlist=pimachievementsMapping.toDomain(pimachievementsdtos);
        for(PimAchievements domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimachievementsService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimAchievements-JLSS-all')")
	@ApiOperation(value = "根据人员信息获取记录所属和人员ID不符的", tags = {"绩效信息" } ,notes = "根据人员信息获取记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimachievements/fetchjlss")
	public ResponseEntity<List<PimAchievementsDTO>> fetchPimAchievementsJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimAchievementsSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimAchievements> domains = pimachievementsService.searchJLSS(context) ;
        List<PimAchievementsDTO> list = pimachievementsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimAchievements-JLSS-all')")
	@ApiOperation(value = "根据人员信息查询记录所属和人员ID不符的", tags = {"绩效信息" } ,notes = "根据人员信息查询记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimachievements/searchjlss")
	public ResponseEntity<Page<PimAchievementsDTO>> searchPimAchievementsJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimAchievementsSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimAchievements> domains = pimachievementsService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimachievementsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimAchievements-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"绩效信息" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimachievements/fetchdefault")
	public ResponseEntity<List<PimAchievementsDTO>> fetchPimAchievementsDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimAchievementsSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimAchievements> domains = pimachievementsService.searchDefault(context) ;
        List<PimAchievementsDTO> list = pimachievementsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimAchievements-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"绩效信息" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimachievements/searchdefault")
	public ResponseEntity<Page<PimAchievementsDTO>> searchPimAchievementsDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimAchievementsSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimAchievements> domains = pimachievementsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimachievementsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimAchievements-ZIZHU-all')")
	@ApiOperation(value = "根据人员信息获取自助(绩效信息)", tags = {"绩效信息" } ,notes = "根据人员信息获取自助(绩效信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimachievements/fetchzizhu")
	public ResponseEntity<List<PimAchievementsDTO>> fetchPimAchievementsZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimAchievementsSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimAchievements> domains = pimachievementsService.searchZIZHU(context) ;
        List<PimAchievementsDTO> list = pimachievementsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimAchievements-ZIZHU-all')")
	@ApiOperation(value = "根据人员信息查询自助(绩效信息)", tags = {"绩效信息" } ,notes = "根据人员信息查询自助(绩效信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimachievements/searchzizhu")
	public ResponseEntity<Page<PimAchievementsDTO>> searchPimAchievementsZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimAchievementsSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimAchievements> domains = pimachievementsService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimachievementsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

