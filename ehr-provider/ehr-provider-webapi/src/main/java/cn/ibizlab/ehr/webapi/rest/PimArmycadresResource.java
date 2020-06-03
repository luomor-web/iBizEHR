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
import cn.ibizlab.ehr.core.pim.domain.PimArmycadres;
import cn.ibizlab.ehr.core.pim.service.IPimArmycadresService;
import cn.ibizlab.ehr.core.pim.filter.PimArmycadresSearchContext;

@Slf4j
@Api(tags = {"军转干部" })
@RestController("WebApi-pimarmycadres")
@RequestMapping("")
public class PimArmycadresResource {

    @Autowired
    public IPimArmycadresService pimarmycadresService;

    @Autowired
    @Lazy
    public PimArmycadresMapping pimarmycadresMapping;

    @PreAuthorize("hasPermission(this.pimarmycadresService.get(#pimarmycadres_id),'ehr-PimArmycadres-Remove')")
    @ApiOperation(value = "删除军转干部", tags = {"军转干部" },  notes = "删除军转干部")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarmycadres/{pimarmycadres_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimarmycadres_id") String pimarmycadres_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimarmycadresService.remove(pimarmycadres_id));
    }

    @PreAuthorize("hasPermission(this.pimarmycadresService.getPimarmycadresByIds(#ids),'ehr-PimArmycadres-Remove')")
    @ApiOperation(value = "批量删除军转干部", tags = {"军转干部" },  notes = "批量删除军转干部")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarmycadres/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimarmycadresService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取军转干部草稿", tags = {"军转干部" },  notes = "获取军转干部草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarmycadres/getdraft")
    public ResponseEntity<PimArmycadresDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimarmycadresMapping.toDto(pimarmycadresService.getDraft(new PimArmycadres())));
    }

    @ApiOperation(value = "检查军转干部", tags = {"军转干部" },  notes = "检查军转干部")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarmycadres/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimArmycadresDTO pimarmycadresdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarmycadresService.checkKey(pimarmycadresMapping.toDomain(pimarmycadresdto)));
    }

    @PreAuthorize("hasPermission(this.pimarmycadresMapping.toDomain(#pimarmycadresdto),'ehr-PimArmycadres-Create')")
    @ApiOperation(value = "新建军转干部", tags = {"军转干部" },  notes = "新建军转干部")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarmycadres")
    @Transactional
    public ResponseEntity<PimArmycadresDTO> create(@RequestBody PimArmycadresDTO pimarmycadresdto) {
        PimArmycadres domain = pimarmycadresMapping.toDomain(pimarmycadresdto);
		pimarmycadresService.create(domain);
        PimArmycadresDTO dto = pimarmycadresMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarmycadresMapping.toDomain(#pimarmycadresdtos),'ehr-PimArmycadres-Create')")
    @ApiOperation(value = "批量新建军转干部", tags = {"军转干部" },  notes = "批量新建军转干部")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarmycadres/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimArmycadresDTO> pimarmycadresdtos) {
        pimarmycadresService.createBatch(pimarmycadresMapping.toDomain(pimarmycadresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarmycadresService.get(#pimarmycadres_id),'ehr-PimArmycadres-Update')")
    @ApiOperation(value = "更新军转干部", tags = {"军转干部" },  notes = "更新军转干部")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarmycadres/{pimarmycadres_id}")
    @Transactional
    public ResponseEntity<PimArmycadresDTO> update(@PathVariable("pimarmycadres_id") String pimarmycadres_id, @RequestBody PimArmycadresDTO pimarmycadresdto) {
		PimArmycadres domain  = pimarmycadresMapping.toDomain(pimarmycadresdto);
        domain .setPimarmycadresid(pimarmycadres_id);
		pimarmycadresService.update(domain );
		PimArmycadresDTO dto = pimarmycadresMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarmycadresService.getPimarmycadresByEntities(this.pimarmycadresMapping.toDomain(#pimarmycadresdtos)),'ehr-PimArmycadres-Update')")
    @ApiOperation(value = "批量更新军转干部", tags = {"军转干部" },  notes = "批量更新军转干部")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarmycadres/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimArmycadresDTO> pimarmycadresdtos) {
        pimarmycadresService.updateBatch(pimarmycadresMapping.toDomain(pimarmycadresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimarmycadresMapping.toDomain(returnObject.body),'ehr-PimArmycadres-Get')")
    @ApiOperation(value = "获取军转干部", tags = {"军转干部" },  notes = "获取军转干部")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarmycadres/{pimarmycadres_id}")
    public ResponseEntity<PimArmycadresDTO> get(@PathVariable("pimarmycadres_id") String pimarmycadres_id) {
        PimArmycadres domain = pimarmycadresService.get(pimarmycadres_id);
        PimArmycadresDTO dto = pimarmycadresMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarmycadresMapping.toDomain(#pimarmycadresdto),'ehr-PimArmycadres-Save')")
    @ApiOperation(value = "保存军转干部", tags = {"军转干部" },  notes = "保存军转干部")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarmycadres/save")
    public ResponseEntity<Boolean> save(@RequestBody PimArmycadresDTO pimarmycadresdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimarmycadresService.save(pimarmycadresMapping.toDomain(pimarmycadresdto)));
    }

    @PreAuthorize("hasPermission(this.pimarmycadresMapping.toDomain(#pimarmycadresdtos),'ehr-PimArmycadres-Save')")
    @ApiOperation(value = "批量保存军转干部", tags = {"军转干部" },  notes = "批量保存军转干部")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarmycadres/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimArmycadresDTO> pimarmycadresdtos) {
        pimarmycadresService.saveBatch(pimarmycadresMapping.toDomain(pimarmycadresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArmycadres-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"军转干部" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimarmycadres/fetchdefault")
	public ResponseEntity<List<PimArmycadresDTO>> fetchDefault(PimArmycadresSearchContext context) {
        Page<PimArmycadres> domains = pimarmycadresService.searchDefault(context) ;
        List<PimArmycadresDTO> list = pimarmycadresMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArmycadres-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"军转干部" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimarmycadres/searchdefault")
	public ResponseEntity<Page<PimArmycadresDTO>> searchDefault(@RequestBody PimArmycadresSearchContext context) {
        Page<PimArmycadres> domains = pimarmycadresService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarmycadresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArmycadres-JLSSGLY-all')")
	@ApiOperation(value = "获取记录所属（管理员）", tags = {"军转干部" } ,notes = "获取记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimarmycadres/fetchjlssgly")
	public ResponseEntity<List<PimArmycadresDTO>> fetchJLSSGLY(PimArmycadresSearchContext context) {
        Page<PimArmycadres> domains = pimarmycadresService.searchJLSSGLY(context) ;
        List<PimArmycadresDTO> list = pimarmycadresMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArmycadres-JLSSGLY-all')")
	@ApiOperation(value = "查询记录所属（管理员）", tags = {"军转干部" } ,notes = "查询记录所属（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimarmycadres/searchjlssgly")
	public ResponseEntity<Page<PimArmycadresDTO>> searchJLSSGLY(@RequestBody PimArmycadresSearchContext context) {
        Page<PimArmycadres> domains = pimarmycadresService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarmycadresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArmycadres-JLSSGR-all')")
	@ApiOperation(value = "获取记录所属（个人）", tags = {"军转干部" } ,notes = "获取记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimarmycadres/fetchjlssgr")
	public ResponseEntity<List<PimArmycadresDTO>> fetchJLSSGR(PimArmycadresSearchContext context) {
        Page<PimArmycadres> domains = pimarmycadresService.searchJLSSGR(context) ;
        List<PimArmycadresDTO> list = pimarmycadresMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArmycadres-JLSSGR-all')")
	@ApiOperation(value = "查询记录所属（个人）", tags = {"军转干部" } ,notes = "查询记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimarmycadres/searchjlssgr")
	public ResponseEntity<Page<PimArmycadresDTO>> searchJLSSGR(@RequestBody PimArmycadresSearchContext context) {
        Page<PimArmycadres> domains = pimarmycadresService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarmycadresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimarmycadresService.get(#pimarmycadres_id),'ehr-PimArmycadres-Remove')")
    @ApiOperation(value = "根据人员信息删除军转干部", tags = {"军转干部" },  notes = "根据人员信息删除军转干部")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarmycadres/{pimarmycadres_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarmycadres_id") String pimarmycadres_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimarmycadresService.remove(pimarmycadres_id));
    }

    @PreAuthorize("hasPermission(this.pimarmycadresService.getPimarmycadresByIds(#ids),'ehr-PimArmycadres-Remove')")
    @ApiOperation(value = "根据人员信息批量删除军转干部", tags = {"军转干部" },  notes = "根据人员信息批量删除军转干部")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarmycadres/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimarmycadresService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息获取军转干部草稿", tags = {"军转干部" },  notes = "根据人员信息获取军转干部草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarmycadres/getdraft")
    public ResponseEntity<PimArmycadresDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PimArmycadres domain = new PimArmycadres();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarmycadresMapping.toDto(pimarmycadresService.getDraft(domain)));
    }

    @ApiOperation(value = "根据人员信息检查军转干部", tags = {"军转干部" },  notes = "根据人员信息检查军转干部")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarmycadres/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimArmycadresDTO pimarmycadresdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarmycadresService.checkKey(pimarmycadresMapping.toDomain(pimarmycadresdto)));
    }

    @PreAuthorize("hasPermission(this.pimarmycadresMapping.toDomain(#pimarmycadresdto),'ehr-PimArmycadres-Create')")
    @ApiOperation(value = "根据人员信息建立军转干部", tags = {"军转干部" },  notes = "根据人员信息建立军转干部")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarmycadres")
    @Transactional
    public ResponseEntity<PimArmycadresDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimArmycadresDTO pimarmycadresdto) {
        PimArmycadres domain = pimarmycadresMapping.toDomain(pimarmycadresdto);
        domain.setPimpersonid(pimperson_id);
		pimarmycadresService.create(domain);
        PimArmycadresDTO dto = pimarmycadresMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarmycadresMapping.toDomain(#pimarmycadresdtos),'ehr-PimArmycadres-Create')")
    @ApiOperation(value = "根据人员信息批量建立军转干部", tags = {"军转干部" },  notes = "根据人员信息批量建立军转干部")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarmycadres/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimArmycadresDTO> pimarmycadresdtos) {
        List<PimArmycadres> domainlist=pimarmycadresMapping.toDomain(pimarmycadresdtos);
        for(PimArmycadres domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimarmycadresService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarmycadresService.get(#pimarmycadres_id),'ehr-PimArmycadres-Update')")
    @ApiOperation(value = "根据人员信息更新军转干部", tags = {"军转干部" },  notes = "根据人员信息更新军转干部")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarmycadres/{pimarmycadres_id}")
    @Transactional
    public ResponseEntity<PimArmycadresDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarmycadres_id") String pimarmycadres_id, @RequestBody PimArmycadresDTO pimarmycadresdto) {
        PimArmycadres domain = pimarmycadresMapping.toDomain(pimarmycadresdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimarmycadresid(pimarmycadres_id);
		pimarmycadresService.update(domain);
        PimArmycadresDTO dto = pimarmycadresMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarmycadresService.getPimarmycadresByEntities(this.pimarmycadresMapping.toDomain(#pimarmycadresdtos)),'ehr-PimArmycadres-Update')")
    @ApiOperation(value = "根据人员信息批量更新军转干部", tags = {"军转干部" },  notes = "根据人员信息批量更新军转干部")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarmycadres/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimArmycadresDTO> pimarmycadresdtos) {
        List<PimArmycadres> domainlist=pimarmycadresMapping.toDomain(pimarmycadresdtos);
        for(PimArmycadres domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimarmycadresService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimarmycadresMapping.toDomain(returnObject.body),'ehr-PimArmycadres-Get')")
    @ApiOperation(value = "根据人员信息获取军转干部", tags = {"军转干部" },  notes = "根据人员信息获取军转干部")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarmycadres/{pimarmycadres_id}")
    public ResponseEntity<PimArmycadresDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarmycadres_id") String pimarmycadres_id) {
        PimArmycadres domain = pimarmycadresService.get(pimarmycadres_id);
        PimArmycadresDTO dto = pimarmycadresMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarmycadresMapping.toDomain(#pimarmycadresdto),'ehr-PimArmycadres-Save')")
    @ApiOperation(value = "根据人员信息保存军转干部", tags = {"军转干部" },  notes = "根据人员信息保存军转干部")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarmycadres/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimArmycadresDTO pimarmycadresdto) {
        PimArmycadres domain = pimarmycadresMapping.toDomain(pimarmycadresdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarmycadresService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimarmycadresMapping.toDomain(#pimarmycadresdtos),'ehr-PimArmycadres-Save')")
    @ApiOperation(value = "根据人员信息批量保存军转干部", tags = {"军转干部" },  notes = "根据人员信息批量保存军转干部")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarmycadres/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimArmycadresDTO> pimarmycadresdtos) {
        List<PimArmycadres> domainlist=pimarmycadresMapping.toDomain(pimarmycadresdtos);
        for(PimArmycadres domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimarmycadresService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArmycadres-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"军转干部" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarmycadres/fetchdefault")
	public ResponseEntity<List<PimArmycadresDTO>> fetchPimArmycadresDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimArmycadresSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimArmycadres> domains = pimarmycadresService.searchDefault(context) ;
        List<PimArmycadresDTO> list = pimarmycadresMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArmycadres-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"军转干部" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarmycadres/searchdefault")
	public ResponseEntity<Page<PimArmycadresDTO>> searchPimArmycadresDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimArmycadresSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimArmycadres> domains = pimarmycadresService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarmycadresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArmycadres-JLSSGLY-all')")
	@ApiOperation(value = "根据人员信息获取记录所属（管理员）", tags = {"军转干部" } ,notes = "根据人员信息获取记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarmycadres/fetchjlssgly")
	public ResponseEntity<List<PimArmycadresDTO>> fetchPimArmycadresJLSSGLYByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimArmycadresSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimArmycadres> domains = pimarmycadresService.searchJLSSGLY(context) ;
        List<PimArmycadresDTO> list = pimarmycadresMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArmycadres-JLSSGLY-all')")
	@ApiOperation(value = "根据人员信息查询记录所属（管理员）", tags = {"军转干部" } ,notes = "根据人员信息查询记录所属（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarmycadres/searchjlssgly")
	public ResponseEntity<Page<PimArmycadresDTO>> searchPimArmycadresJLSSGLYByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimArmycadresSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimArmycadres> domains = pimarmycadresService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarmycadresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArmycadres-JLSSGR-all')")
	@ApiOperation(value = "根据人员信息获取记录所属（个人）", tags = {"军转干部" } ,notes = "根据人员信息获取记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarmycadres/fetchjlssgr")
	public ResponseEntity<List<PimArmycadresDTO>> fetchPimArmycadresJLSSGRByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimArmycadresSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimArmycadres> domains = pimarmycadresService.searchJLSSGR(context) ;
        List<PimArmycadresDTO> list = pimarmycadresMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimArmycadres-JLSSGR-all')")
	@ApiOperation(value = "根据人员信息查询记录所属（个人）", tags = {"军转干部" } ,notes = "根据人员信息查询记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarmycadres/searchjlssgr")
	public ResponseEntity<Page<PimArmycadresDTO>> searchPimArmycadresJLSSGRByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimArmycadresSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimArmycadres> domains = pimarmycadresService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarmycadresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

