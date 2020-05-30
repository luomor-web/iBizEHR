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
import cn.ibizlab.ehr.core.pim.domain.PimResearchFindings;
import cn.ibizlab.ehr.core.pim.service.IPimResearchFindingsService;
import cn.ibizlab.ehr.core.pim.filter.PimResearchFindingsSearchContext;

@Slf4j
@Api(tags = {"科研成果" })
@RestController("WebApi-pimresearchfindings")
@RequestMapping("")
public class PimResearchFindingsResource {

    @Autowired
    public IPimResearchFindingsService pimresearchfindingsService;

    @Autowired
    @Lazy
    public PimResearchFindingsMapping pimresearchfindingsMapping;

    @PreAuthorize("hasPermission(this.pimresearchfindingsService.get(#pimresearchfindings_id),'ehr-PimResearchFindings-Update')")
    @ApiOperation(value = "更新科研成果", tags = {"科研成果" },  notes = "更新科研成果")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimresearchfindings/{pimresearchfindings_id}")
    @Transactional
    public ResponseEntity<PimResearchFindingsDTO> update(@PathVariable("pimresearchfindings_id") String pimresearchfindings_id, @RequestBody PimResearchFindingsDTO pimresearchfindingsdto) {
		PimResearchFindings domain  = pimresearchfindingsMapping.toDomain(pimresearchfindingsdto);
        domain .setPimresearchfindingsid(pimresearchfindings_id);
		pimresearchfindingsService.update(domain );
		PimResearchFindingsDTO dto = pimresearchfindingsMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsService.getPimresearchfindingsByEntities(this.pimresearchfindingsMapping.toDomain(#pimresearchfindingsdtos)),'ehr-PimResearchFindings-Update')")
    @ApiOperation(value = "批量更新科研成果", tags = {"科研成果" },  notes = "批量更新科研成果")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimresearchfindings/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimResearchFindingsDTO> pimresearchfindingsdtos) {
        pimresearchfindingsService.updateBatch(pimresearchfindingsMapping.toDomain(pimresearchfindingsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsService.get(#pimresearchfindings_id),'ehr-PimResearchFindings-Remove')")
    @ApiOperation(value = "删除科研成果", tags = {"科研成果" },  notes = "删除科研成果")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimresearchfindings/{pimresearchfindings_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimresearchfindings_id") String pimresearchfindings_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimresearchfindingsService.remove(pimresearchfindings_id));
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsService.getPimresearchfindingsByIds(#ids),'ehr-PimResearchFindings-Remove')")
    @ApiOperation(value = "批量删除科研成果", tags = {"科研成果" },  notes = "批量删除科研成果")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimresearchfindings/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimresearchfindingsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimresearchfindingsMapping.toDomain(returnObject.body),'ehr-PimResearchFindings-Get')")
    @ApiOperation(value = "获取科研成果", tags = {"科研成果" },  notes = "获取科研成果")
	@RequestMapping(method = RequestMethod.GET, value = "/pimresearchfindings/{pimresearchfindings_id}")
    public ResponseEntity<PimResearchFindingsDTO> get(@PathVariable("pimresearchfindings_id") String pimresearchfindings_id) {
        PimResearchFindings domain = pimresearchfindingsService.get(pimresearchfindings_id);
        PimResearchFindingsDTO dto = pimresearchfindingsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取科研成果草稿", tags = {"科研成果" },  notes = "获取科研成果草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimresearchfindings/getdraft")
    public ResponseEntity<PimResearchFindingsDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimresearchfindingsMapping.toDto(pimresearchfindingsService.getDraft(new PimResearchFindings())));
    }

    @ApiOperation(value = "检查科研成果", tags = {"科研成果" },  notes = "检查科研成果")
	@RequestMapping(method = RequestMethod.POST, value = "/pimresearchfindings/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimResearchFindingsDTO pimresearchfindingsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimresearchfindingsService.checkKey(pimresearchfindingsMapping.toDomain(pimresearchfindingsdto)));
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsMapping.toDomain(#pimresearchfindingsdto),'ehr-PimResearchFindings-Save')")
    @ApiOperation(value = "保存科研成果", tags = {"科研成果" },  notes = "保存科研成果")
	@RequestMapping(method = RequestMethod.POST, value = "/pimresearchfindings/save")
    public ResponseEntity<Boolean> save(@RequestBody PimResearchFindingsDTO pimresearchfindingsdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimresearchfindingsService.save(pimresearchfindingsMapping.toDomain(pimresearchfindingsdto)));
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsMapping.toDomain(#pimresearchfindingsdtos),'ehr-PimResearchFindings-Save')")
    @ApiOperation(value = "批量保存科研成果", tags = {"科研成果" },  notes = "批量保存科研成果")
	@RequestMapping(method = RequestMethod.POST, value = "/pimresearchfindings/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimResearchFindingsDTO> pimresearchfindingsdtos) {
        pimresearchfindingsService.saveBatch(pimresearchfindingsMapping.toDomain(pimresearchfindingsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsMapping.toDomain(#pimresearchfindingsdto),'ehr-PimResearchFindings-Create')")
    @ApiOperation(value = "新建科研成果", tags = {"科研成果" },  notes = "新建科研成果")
	@RequestMapping(method = RequestMethod.POST, value = "/pimresearchfindings")
    @Transactional
    public ResponseEntity<PimResearchFindingsDTO> create(@RequestBody PimResearchFindingsDTO pimresearchfindingsdto) {
        PimResearchFindings domain = pimresearchfindingsMapping.toDomain(pimresearchfindingsdto);
		pimresearchfindingsService.create(domain);
        PimResearchFindingsDTO dto = pimresearchfindingsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsMapping.toDomain(#pimresearchfindingsdtos),'ehr-PimResearchFindings-Create')")
    @ApiOperation(value = "批量新建科研成果", tags = {"科研成果" },  notes = "批量新建科研成果")
	@RequestMapping(method = RequestMethod.POST, value = "/pimresearchfindings/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimResearchFindingsDTO> pimresearchfindingsdtos) {
        pimresearchfindingsService.createBatch(pimresearchfindingsMapping.toDomain(pimresearchfindingsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimResearchFindings-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"科研成果" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimresearchfindings/fetchdefault")
	public ResponseEntity<List<PimResearchFindingsDTO>> fetchDefault(PimResearchFindingsSearchContext context) {
        Page<PimResearchFindings> domains = pimresearchfindingsService.searchDefault(context) ;
        List<PimResearchFindingsDTO> list = pimresearchfindingsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimResearchFindings-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"科研成果" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimresearchfindings/searchdefault")
	public ResponseEntity<Page<PimResearchFindingsDTO>> searchDefault(@RequestBody PimResearchFindingsSearchContext context) {
        Page<PimResearchFindings> domains = pimresearchfindingsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimresearchfindingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimResearchFindings-JLSSGLY-all')")
	@ApiOperation(value = "获取记录所属（管理员）", tags = {"科研成果" } ,notes = "获取记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimresearchfindings/fetchjlssgly")
	public ResponseEntity<List<PimResearchFindingsDTO>> fetchJLSSGLY(PimResearchFindingsSearchContext context) {
        Page<PimResearchFindings> domains = pimresearchfindingsService.searchJLSSGLY(context) ;
        List<PimResearchFindingsDTO> list = pimresearchfindingsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimResearchFindings-JLSSGLY-all')")
	@ApiOperation(value = "查询记录所属（管理员）", tags = {"科研成果" } ,notes = "查询记录所属（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimresearchfindings/searchjlssgly")
	public ResponseEntity<Page<PimResearchFindingsDTO>> searchJLSSGLY(@RequestBody PimResearchFindingsSearchContext context) {
        Page<PimResearchFindings> domains = pimresearchfindingsService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimresearchfindingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimResearchFindings-JLSSGR-all')")
	@ApiOperation(value = "获取记录所属（个人）", tags = {"科研成果" } ,notes = "获取记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimresearchfindings/fetchjlssgr")
	public ResponseEntity<List<PimResearchFindingsDTO>> fetchJLSSGR(PimResearchFindingsSearchContext context) {
        Page<PimResearchFindings> domains = pimresearchfindingsService.searchJLSSGR(context) ;
        List<PimResearchFindingsDTO> list = pimresearchfindingsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimResearchFindings-JLSSGR-all')")
	@ApiOperation(value = "查询记录所属（个人）", tags = {"科研成果" } ,notes = "查询记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimresearchfindings/searchjlssgr")
	public ResponseEntity<Page<PimResearchFindingsDTO>> searchJLSSGR(@RequestBody PimResearchFindingsSearchContext context) {
        Page<PimResearchFindings> domains = pimresearchfindingsService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimresearchfindingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimresearchfindingsService.get(#pimresearchfindings_id),'ehr-PimResearchFindings-Update')")
    @ApiOperation(value = "根据人员信息更新科研成果", tags = {"科研成果" },  notes = "根据人员信息更新科研成果")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimresearchfindings/{pimresearchfindings_id}")
    @Transactional
    public ResponseEntity<PimResearchFindingsDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimresearchfindings_id") String pimresearchfindings_id, @RequestBody PimResearchFindingsDTO pimresearchfindingsdto) {
        PimResearchFindings domain = pimresearchfindingsMapping.toDomain(pimresearchfindingsdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimresearchfindingsid(pimresearchfindings_id);
		pimresearchfindingsService.update(domain);
        PimResearchFindingsDTO dto = pimresearchfindingsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsService.getPimresearchfindingsByEntities(this.pimresearchfindingsMapping.toDomain(#pimresearchfindingsdtos)),'ehr-PimResearchFindings-Update')")
    @ApiOperation(value = "根据人员信息批量更新科研成果", tags = {"科研成果" },  notes = "根据人员信息批量更新科研成果")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimresearchfindings/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimResearchFindingsDTO> pimresearchfindingsdtos) {
        List<PimResearchFindings> domainlist=pimresearchfindingsMapping.toDomain(pimresearchfindingsdtos);
        for(PimResearchFindings domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimresearchfindingsService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsService.get(#pimresearchfindings_id),'ehr-PimResearchFindings-Remove')")
    @ApiOperation(value = "根据人员信息删除科研成果", tags = {"科研成果" },  notes = "根据人员信息删除科研成果")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimresearchfindings/{pimresearchfindings_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimresearchfindings_id") String pimresearchfindings_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimresearchfindingsService.remove(pimresearchfindings_id));
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsService.getPimresearchfindingsByIds(#ids),'ehr-PimResearchFindings-Remove')")
    @ApiOperation(value = "根据人员信息批量删除科研成果", tags = {"科研成果" },  notes = "根据人员信息批量删除科研成果")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimresearchfindings/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimresearchfindingsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimresearchfindingsMapping.toDomain(returnObject.body),'ehr-PimResearchFindings-Get')")
    @ApiOperation(value = "根据人员信息获取科研成果", tags = {"科研成果" },  notes = "根据人员信息获取科研成果")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimresearchfindings/{pimresearchfindings_id}")
    public ResponseEntity<PimResearchFindingsDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimresearchfindings_id") String pimresearchfindings_id) {
        PimResearchFindings domain = pimresearchfindingsService.get(pimresearchfindings_id);
        PimResearchFindingsDTO dto = pimresearchfindingsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据人员信息获取科研成果草稿", tags = {"科研成果" },  notes = "根据人员信息获取科研成果草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimresearchfindings/getdraft")
    public ResponseEntity<PimResearchFindingsDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PimResearchFindings domain = new PimResearchFindings();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimresearchfindingsMapping.toDto(pimresearchfindingsService.getDraft(domain)));
    }

    @ApiOperation(value = "根据人员信息检查科研成果", tags = {"科研成果" },  notes = "根据人员信息检查科研成果")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimresearchfindings/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimResearchFindingsDTO pimresearchfindingsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimresearchfindingsService.checkKey(pimresearchfindingsMapping.toDomain(pimresearchfindingsdto)));
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsMapping.toDomain(#pimresearchfindingsdto),'ehr-PimResearchFindings-Save')")
    @ApiOperation(value = "根据人员信息保存科研成果", tags = {"科研成果" },  notes = "根据人员信息保存科研成果")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimresearchfindings/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimResearchFindingsDTO pimresearchfindingsdto) {
        PimResearchFindings domain = pimresearchfindingsMapping.toDomain(pimresearchfindingsdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimresearchfindingsService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsMapping.toDomain(#pimresearchfindingsdtos),'ehr-PimResearchFindings-Save')")
    @ApiOperation(value = "根据人员信息批量保存科研成果", tags = {"科研成果" },  notes = "根据人员信息批量保存科研成果")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimresearchfindings/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimResearchFindingsDTO> pimresearchfindingsdtos) {
        List<PimResearchFindings> domainlist=pimresearchfindingsMapping.toDomain(pimresearchfindingsdtos);
        for(PimResearchFindings domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimresearchfindingsService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsMapping.toDomain(#pimresearchfindingsdto),'ehr-PimResearchFindings-Create')")
    @ApiOperation(value = "根据人员信息建立科研成果", tags = {"科研成果" },  notes = "根据人员信息建立科研成果")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimresearchfindings")
    @Transactional
    public ResponseEntity<PimResearchFindingsDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimResearchFindingsDTO pimresearchfindingsdto) {
        PimResearchFindings domain = pimresearchfindingsMapping.toDomain(pimresearchfindingsdto);
        domain.setPimpersonid(pimperson_id);
		pimresearchfindingsService.create(domain);
        PimResearchFindingsDTO dto = pimresearchfindingsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsMapping.toDomain(#pimresearchfindingsdtos),'ehr-PimResearchFindings-Create')")
    @ApiOperation(value = "根据人员信息批量建立科研成果", tags = {"科研成果" },  notes = "根据人员信息批量建立科研成果")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimresearchfindings/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimResearchFindingsDTO> pimresearchfindingsdtos) {
        List<PimResearchFindings> domainlist=pimresearchfindingsMapping.toDomain(pimresearchfindingsdtos);
        for(PimResearchFindings domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimresearchfindingsService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimResearchFindings-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"科研成果" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimresearchfindings/fetchdefault")
	public ResponseEntity<List<PimResearchFindingsDTO>> fetchPimResearchFindingsDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimResearchFindingsSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimResearchFindings> domains = pimresearchfindingsService.searchDefault(context) ;
        List<PimResearchFindingsDTO> list = pimresearchfindingsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimResearchFindings-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"科研成果" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimresearchfindings/searchdefault")
	public ResponseEntity<Page<PimResearchFindingsDTO>> searchPimResearchFindingsDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimResearchFindingsSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimResearchFindings> domains = pimresearchfindingsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimresearchfindingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimResearchFindings-JLSSGLY-all')")
	@ApiOperation(value = "根据人员信息获取记录所属（管理员）", tags = {"科研成果" } ,notes = "根据人员信息获取记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimresearchfindings/fetchjlssgly")
	public ResponseEntity<List<PimResearchFindingsDTO>> fetchPimResearchFindingsJLSSGLYByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimResearchFindingsSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimResearchFindings> domains = pimresearchfindingsService.searchJLSSGLY(context) ;
        List<PimResearchFindingsDTO> list = pimresearchfindingsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimResearchFindings-JLSSGLY-all')")
	@ApiOperation(value = "根据人员信息查询记录所属（管理员）", tags = {"科研成果" } ,notes = "根据人员信息查询记录所属（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimresearchfindings/searchjlssgly")
	public ResponseEntity<Page<PimResearchFindingsDTO>> searchPimResearchFindingsJLSSGLYByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimResearchFindingsSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimResearchFindings> domains = pimresearchfindingsService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimresearchfindingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimResearchFindings-JLSSGR-all')")
	@ApiOperation(value = "根据人员信息获取记录所属（个人）", tags = {"科研成果" } ,notes = "根据人员信息获取记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimresearchfindings/fetchjlssgr")
	public ResponseEntity<List<PimResearchFindingsDTO>> fetchPimResearchFindingsJLSSGRByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimResearchFindingsSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimResearchFindings> domains = pimresearchfindingsService.searchJLSSGR(context) ;
        List<PimResearchFindingsDTO> list = pimresearchfindingsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimResearchFindings-JLSSGR-all')")
	@ApiOperation(value = "根据人员信息查询记录所属（个人）", tags = {"科研成果" } ,notes = "根据人员信息查询记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimresearchfindings/searchjlssgr")
	public ResponseEntity<Page<PimResearchFindingsDTO>> searchPimResearchFindingsJLSSGRByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimResearchFindingsSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimResearchFindings> domains = pimresearchfindingsService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimresearchfindingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

