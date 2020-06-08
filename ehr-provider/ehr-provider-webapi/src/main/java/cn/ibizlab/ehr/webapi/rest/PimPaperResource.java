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
import cn.ibizlab.ehr.core.pim.domain.PimPaper;
import cn.ibizlab.ehr.core.pim.service.IPimPaperService;
import cn.ibizlab.ehr.core.pim.filter.PimPaperSearchContext;

@Slf4j
@Api(tags = {"论文信息" })
@RestController("WebApi-pimpaper")
@RequestMapping("")
public class PimPaperResource {

    @Autowired
    public IPimPaperService pimpaperService;

    @Autowired
    @Lazy
    public PimPaperMapping pimpaperMapping;

    @PreAuthorize("hasPermission(this.pimpaperService.get(#pimpaper_id),'ehr-PimPaper-Update')")
    @ApiOperation(value = "更新论文信息", tags = {"论文信息" },  notes = "更新论文信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpapers/{pimpaper_id}")
    @Transactional
    public ResponseEntity<PimPaperDTO> update(@PathVariable("pimpaper_id") String pimpaper_id, @RequestBody PimPaperDTO pimpaperdto) {
		PimPaper domain  = pimpaperMapping.toDomain(pimpaperdto);
        domain .setPimpaperid(pimpaper_id);
		pimpaperService.update(domain );
		PimPaperDTO dto = pimpaperMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpaperService.getPimpaperByEntities(this.pimpaperMapping.toDomain(#pimpaperdtos)),'ehr-PimPaper-Update')")
    @ApiOperation(value = "批量更新论文信息", tags = {"论文信息" },  notes = "批量更新论文信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpapers/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimPaperDTO> pimpaperdtos) {
        pimpaperService.updateBatch(pimpaperMapping.toDomain(pimpaperdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取论文信息草稿", tags = {"论文信息" },  notes = "获取论文信息草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpapers/getdraft")
    public ResponseEntity<PimPaperDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimpaperMapping.toDto(pimpaperService.getDraft(new PimPaper())));
    }

    @PreAuthorize("hasPermission(this.pimpaperService.get(#pimpaper_id),'ehr-PimPaper-Remove')")
    @ApiOperation(value = "删除论文信息", tags = {"论文信息" },  notes = "删除论文信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpapers/{pimpaper_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimpaper_id") String pimpaper_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimpaperService.remove(pimpaper_id));
    }

    @PreAuthorize("hasPermission(this.pimpaperService.getPimpaperByIds(#ids),'ehr-PimPaper-Remove')")
    @ApiOperation(value = "批量删除论文信息", tags = {"论文信息" },  notes = "批量删除论文信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpapers/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimpaperService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpaperMapping.toDomain(#pimpaperdto),'ehr-PimPaper-Create')")
    @ApiOperation(value = "新建论文信息", tags = {"论文信息" },  notes = "新建论文信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpapers")
    @Transactional
    public ResponseEntity<PimPaperDTO> create(@RequestBody PimPaperDTO pimpaperdto) {
        PimPaper domain = pimpaperMapping.toDomain(pimpaperdto);
		pimpaperService.create(domain);
        PimPaperDTO dto = pimpaperMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpaperMapping.toDomain(#pimpaperdtos),'ehr-PimPaper-Create')")
    @ApiOperation(value = "批量新建论文信息", tags = {"论文信息" },  notes = "批量新建论文信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpapers/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimPaperDTO> pimpaperdtos) {
        pimpaperService.createBatch(pimpaperMapping.toDomain(pimpaperdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimpaperMapping.toDomain(returnObject.body),'ehr-PimPaper-Get')")
    @ApiOperation(value = "获取论文信息", tags = {"论文信息" },  notes = "获取论文信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpapers/{pimpaper_id}")
    public ResponseEntity<PimPaperDTO> get(@PathVariable("pimpaper_id") String pimpaper_id) {
        PimPaper domain = pimpaperService.get(pimpaper_id);
        PimPaperDTO dto = pimpaperMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpaperMapping.toDomain(#pimpaperdto),'ehr-PimPaper-Save')")
    @ApiOperation(value = "保存论文信息", tags = {"论文信息" },  notes = "保存论文信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpapers/save")
    public ResponseEntity<Boolean> save(@RequestBody PimPaperDTO pimpaperdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimpaperService.save(pimpaperMapping.toDomain(pimpaperdto)));
    }

    @PreAuthorize("hasPermission(this.pimpaperMapping.toDomain(#pimpaperdtos),'ehr-PimPaper-Save')")
    @ApiOperation(value = "批量保存论文信息", tags = {"论文信息" },  notes = "批量保存论文信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpapers/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimPaperDTO> pimpaperdtos) {
        pimpaperService.saveBatch(pimpaperMapping.toDomain(pimpaperdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查论文信息", tags = {"论文信息" },  notes = "检查论文信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpapers/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimPaperDTO pimpaperdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimpaperService.checkKey(pimpaperMapping.toDomain(pimpaperdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPaper-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"论文信息" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpapers/fetchdefault")
	public ResponseEntity<List<PimPaperDTO>> fetchDefault(PimPaperSearchContext context) {
        Page<PimPaper> domains = pimpaperService.searchDefault(context) ;
        List<PimPaperDTO> list = pimpaperMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPaper-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"论文信息" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpapers/searchdefault")
	public ResponseEntity<Page<PimPaperDTO>> searchDefault(@RequestBody PimPaperSearchContext context) {
        Page<PimPaper> domains = pimpaperService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpaperMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPaper-JLSSGR-all')")
	@ApiOperation(value = "获取记录所属（个人）", tags = {"论文信息" } ,notes = "获取记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpapers/fetchjlssgr")
	public ResponseEntity<List<PimPaperDTO>> fetchJLSSGR(PimPaperSearchContext context) {
        Page<PimPaper> domains = pimpaperService.searchJLSSGR(context) ;
        List<PimPaperDTO> list = pimpaperMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPaper-JLSSGR-all')")
	@ApiOperation(value = "查询记录所属（个人）", tags = {"论文信息" } ,notes = "查询记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpapers/searchjlssgr")
	public ResponseEntity<Page<PimPaperDTO>> searchJLSSGR(@RequestBody PimPaperSearchContext context) {
        Page<PimPaper> domains = pimpaperService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpaperMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPaper-JLSSGLY-all')")
	@ApiOperation(value = "获取记录所属（管理员）", tags = {"论文信息" } ,notes = "获取记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpapers/fetchjlssgly")
	public ResponseEntity<List<PimPaperDTO>> fetchJLSSGLY(PimPaperSearchContext context) {
        Page<PimPaper> domains = pimpaperService.searchJLSSGLY(context) ;
        List<PimPaperDTO> list = pimpaperMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPaper-JLSSGLY-all')")
	@ApiOperation(value = "查询记录所属（管理员）", tags = {"论文信息" } ,notes = "查询记录所属（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpapers/searchjlssgly")
	public ResponseEntity<Page<PimPaperDTO>> searchJLSSGLY(@RequestBody PimPaperSearchContext context) {
        Page<PimPaper> domains = pimpaperService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpaperMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimpaperService.get(#pimpaper_id),'ehr-PimPaper-Update')")
    @ApiOperation(value = "根据人员信息更新论文信息", tags = {"论文信息" },  notes = "根据人员信息更新论文信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimpapers/{pimpaper_id}")
    @Transactional
    public ResponseEntity<PimPaperDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpaper_id") String pimpaper_id, @RequestBody PimPaperDTO pimpaperdto) {
        PimPaper domain = pimpaperMapping.toDomain(pimpaperdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimpaperid(pimpaper_id);
		pimpaperService.update(domain);
        PimPaperDTO dto = pimpaperMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpaperService.getPimpaperByEntities(this.pimpaperMapping.toDomain(#pimpaperdtos)),'ehr-PimPaper-Update')")
    @ApiOperation(value = "根据人员信息批量更新论文信息", tags = {"论文信息" },  notes = "根据人员信息批量更新论文信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimpapers/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimPaperDTO> pimpaperdtos) {
        List<PimPaper> domainlist=pimpaperMapping.toDomain(pimpaperdtos);
        for(PimPaper domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimpaperService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息获取论文信息草稿", tags = {"论文信息" },  notes = "根据人员信息获取论文信息草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimpapers/getdraft")
    public ResponseEntity<PimPaperDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PimPaper domain = new PimPaper();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimpaperMapping.toDto(pimpaperService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pimpaperService.get(#pimpaper_id),'ehr-PimPaper-Remove')")
    @ApiOperation(value = "根据人员信息删除论文信息", tags = {"论文信息" },  notes = "根据人员信息删除论文信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimpapers/{pimpaper_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpaper_id") String pimpaper_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimpaperService.remove(pimpaper_id));
    }

    @PreAuthorize("hasPermission(this.pimpaperService.getPimpaperByIds(#ids),'ehr-PimPaper-Remove')")
    @ApiOperation(value = "根据人员信息批量删除论文信息", tags = {"论文信息" },  notes = "根据人员信息批量删除论文信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimpapers/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimpaperService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimpaperMapping.toDomain(#pimpaperdto),'ehr-PimPaper-Create')")
    @ApiOperation(value = "根据人员信息建立论文信息", tags = {"论文信息" },  notes = "根据人员信息建立论文信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpapers")
    @Transactional
    public ResponseEntity<PimPaperDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPaperDTO pimpaperdto) {
        PimPaper domain = pimpaperMapping.toDomain(pimpaperdto);
        domain.setPimpersonid(pimperson_id);
		pimpaperService.create(domain);
        PimPaperDTO dto = pimpaperMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpaperMapping.toDomain(#pimpaperdtos),'ehr-PimPaper-Create')")
    @ApiOperation(value = "根据人员信息批量建立论文信息", tags = {"论文信息" },  notes = "根据人员信息批量建立论文信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpapers/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimPaperDTO> pimpaperdtos) {
        List<PimPaper> domainlist=pimpaperMapping.toDomain(pimpaperdtos);
        for(PimPaper domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimpaperService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimpaperMapping.toDomain(returnObject.body),'ehr-PimPaper-Get')")
    @ApiOperation(value = "根据人员信息获取论文信息", tags = {"论文信息" },  notes = "根据人员信息获取论文信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimpapers/{pimpaper_id}")
    public ResponseEntity<PimPaperDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimpaper_id") String pimpaper_id) {
        PimPaper domain = pimpaperService.get(pimpaper_id);
        PimPaperDTO dto = pimpaperMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimpaperMapping.toDomain(#pimpaperdto),'ehr-PimPaper-Save')")
    @ApiOperation(value = "根据人员信息保存论文信息", tags = {"论文信息" },  notes = "根据人员信息保存论文信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpapers/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPaperDTO pimpaperdto) {
        PimPaper domain = pimpaperMapping.toDomain(pimpaperdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimpaperService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimpaperMapping.toDomain(#pimpaperdtos),'ehr-PimPaper-Save')")
    @ApiOperation(value = "根据人员信息批量保存论文信息", tags = {"论文信息" },  notes = "根据人员信息批量保存论文信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpapers/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimPaperDTO> pimpaperdtos) {
        List<PimPaper> domainlist=pimpaperMapping.toDomain(pimpaperdtos);
        for(PimPaper domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimpaperService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息检查论文信息", tags = {"论文信息" },  notes = "根据人员信息检查论文信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimpapers/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPaperDTO pimpaperdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimpaperService.checkKey(pimpaperMapping.toDomain(pimpaperdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPaper-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"论文信息" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpapers/fetchdefault")
	public ResponseEntity<List<PimPaperDTO>> fetchPimPaperDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimPaperSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPaper> domains = pimpaperService.searchDefault(context) ;
        List<PimPaperDTO> list = pimpaperMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPaper-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"论文信息" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpapers/searchdefault")
	public ResponseEntity<Page<PimPaperDTO>> searchPimPaperDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPaperSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPaper> domains = pimpaperService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpaperMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPaper-JLSSGR-all')")
	@ApiOperation(value = "根据人员信息获取记录所属（个人）", tags = {"论文信息" } ,notes = "根据人员信息获取记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpapers/fetchjlssgr")
	public ResponseEntity<List<PimPaperDTO>> fetchPimPaperJLSSGRByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimPaperSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPaper> domains = pimpaperService.searchJLSSGR(context) ;
        List<PimPaperDTO> list = pimpaperMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPaper-JLSSGR-all')")
	@ApiOperation(value = "根据人员信息查询记录所属（个人）", tags = {"论文信息" } ,notes = "根据人员信息查询记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpapers/searchjlssgr")
	public ResponseEntity<Page<PimPaperDTO>> searchPimPaperJLSSGRByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPaperSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPaper> domains = pimpaperService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpaperMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPaper-JLSSGLY-all')")
	@ApiOperation(value = "根据人员信息获取记录所属（管理员）", tags = {"论文信息" } ,notes = "根据人员信息获取记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimpapers/fetchjlssgly")
	public ResponseEntity<List<PimPaperDTO>> fetchPimPaperJLSSGLYByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimPaperSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPaper> domains = pimpaperService.searchJLSSGLY(context) ;
        List<PimPaperDTO> list = pimpaperMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimPaper-JLSSGLY-all')")
	@ApiOperation(value = "根据人员信息查询记录所属（管理员）", tags = {"论文信息" } ,notes = "根据人员信息查询记录所属（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimpapers/searchjlssgly")
	public ResponseEntity<Page<PimPaperDTO>> searchPimPaperJLSSGLYByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimPaperSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimPaper> domains = pimpaperService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimpaperMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

