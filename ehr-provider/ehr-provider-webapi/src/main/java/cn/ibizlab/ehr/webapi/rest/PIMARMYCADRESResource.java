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
import cn.ibizlab.ehr.core.pim.domain.PIMARMYCADRES;
import cn.ibizlab.ehr.core.pim.service.IPIMARMYCADRESService;
import cn.ibizlab.ehr.core.pim.filter.PIMARMYCADRESSearchContext;

@Slf4j
@Api(tags = {"军转干部" })
@RestController("WebApi-pimarmycadres")
@RequestMapping("")
public class PIMARMYCADRESResource {

    @Autowired
    public IPIMARMYCADRESService pimarmycadresService;

    @Autowired
    @Lazy
    public PIMARMYCADRESMapping pimarmycadresMapping;

    @PreAuthorize("hasPermission(this.pimarmycadresService.get(#pimarmycadres_id),'ehr-PIMARMYCADRES-Remove')")
    @ApiOperation(value = "删除军转干部", tags = {"军转干部" },  notes = "删除军转干部")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarmycadres/{pimarmycadres_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimarmycadres_id") String pimarmycadres_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimarmycadresService.remove(pimarmycadres_id));
    }

    @PreAuthorize("hasPermission(this.pimarmycadresService.getPimarmycadresByIds(#ids),'ehr-PIMARMYCADRES-Remove')")
    @ApiOperation(value = "批量删除军转干部", tags = {"军转干部" },  notes = "批量删除军转干部")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimarmycadres/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimarmycadresService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取军转干部草稿", tags = {"军转干部" },  notes = "获取军转干部草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarmycadres/getdraft")
    public ResponseEntity<PIMARMYCADRESDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimarmycadresMapping.toDto(pimarmycadresService.getDraft(new PIMARMYCADRES())));
    }

    @ApiOperation(value = "检查军转干部", tags = {"军转干部" },  notes = "检查军转干部")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarmycadres/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMARMYCADRESDTO pimarmycadresdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarmycadresService.checkKey(pimarmycadresMapping.toDomain(pimarmycadresdto)));
    }

    @PreAuthorize("hasPermission(this.pimarmycadresMapping.toDomain(#pimarmycadresdto),'ehr-PIMARMYCADRES-Create')")
    @ApiOperation(value = "新建军转干部", tags = {"军转干部" },  notes = "新建军转干部")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarmycadres")
    @Transactional
    public ResponseEntity<PIMARMYCADRESDTO> create(@RequestBody PIMARMYCADRESDTO pimarmycadresdto) {
        PIMARMYCADRES domain = pimarmycadresMapping.toDomain(pimarmycadresdto);
		pimarmycadresService.create(domain);
        PIMARMYCADRESDTO dto = pimarmycadresMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarmycadresMapping.toDomain(#pimarmycadresdtos),'ehr-PIMARMYCADRES-Create')")
    @ApiOperation(value = "批量新建军转干部", tags = {"军转干部" },  notes = "批量新建军转干部")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarmycadres/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMARMYCADRESDTO> pimarmycadresdtos) {
        pimarmycadresService.createBatch(pimarmycadresMapping.toDomain(pimarmycadresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarmycadresService.get(#pimarmycadres_id),'ehr-PIMARMYCADRES-Update')")
    @ApiOperation(value = "更新军转干部", tags = {"军转干部" },  notes = "更新军转干部")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarmycadres/{pimarmycadres_id}")
    @Transactional
    public ResponseEntity<PIMARMYCADRESDTO> update(@PathVariable("pimarmycadres_id") String pimarmycadres_id, @RequestBody PIMARMYCADRESDTO pimarmycadresdto) {
		PIMARMYCADRES domain  = pimarmycadresMapping.toDomain(pimarmycadresdto);
        domain .setPimarmycadresid(pimarmycadres_id);
		pimarmycadresService.update(domain );
		PIMARMYCADRESDTO dto = pimarmycadresMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarmycadresService.getPimarmycadresByEntities(this.pimarmycadresMapping.toDomain(#pimarmycadresdtos)),'ehr-PIMARMYCADRES-Update')")
    @ApiOperation(value = "批量更新军转干部", tags = {"军转干部" },  notes = "批量更新军转干部")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimarmycadres/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMARMYCADRESDTO> pimarmycadresdtos) {
        pimarmycadresService.updateBatch(pimarmycadresMapping.toDomain(pimarmycadresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimarmycadresMapping.toDomain(returnObject.body),'ehr-PIMARMYCADRES-Get')")
    @ApiOperation(value = "获取军转干部", tags = {"军转干部" },  notes = "获取军转干部")
	@RequestMapping(method = RequestMethod.GET, value = "/pimarmycadres/{pimarmycadres_id}")
    public ResponseEntity<PIMARMYCADRESDTO> get(@PathVariable("pimarmycadres_id") String pimarmycadres_id) {
        PIMARMYCADRES domain = pimarmycadresService.get(pimarmycadres_id);
        PIMARMYCADRESDTO dto = pimarmycadresMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarmycadresMapping.toDomain(#pimarmycadresdto),'ehr-PIMARMYCADRES-Save')")
    @ApiOperation(value = "保存军转干部", tags = {"军转干部" },  notes = "保存军转干部")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarmycadres/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMARMYCADRESDTO pimarmycadresdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimarmycadresService.save(pimarmycadresMapping.toDomain(pimarmycadresdto)));
    }

    @PreAuthorize("hasPermission(this.pimarmycadresMapping.toDomain(#pimarmycadresdtos),'ehr-PIMARMYCADRES-Save')")
    @ApiOperation(value = "批量保存军转干部", tags = {"军转干部" },  notes = "批量保存军转干部")
	@RequestMapping(method = RequestMethod.POST, value = "/pimarmycadres/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMARMYCADRESDTO> pimarmycadresdtos) {
        pimarmycadresService.saveBatch(pimarmycadresMapping.toDomain(pimarmycadresdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"军转干部" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimarmycadres/fetchdefault")
	public ResponseEntity<List<PIMARMYCADRESDTO>> fetchDefault(PIMARMYCADRESSearchContext context) {
        Page<PIMARMYCADRES> domains = pimarmycadresService.searchDefault(context) ;
        List<PIMARMYCADRESDTO> list = pimarmycadresMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"军转干部" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimarmycadres/searchdefault")
	public ResponseEntity<Page<PIMARMYCADRESDTO>> searchDefault(@RequestBody PIMARMYCADRESSearchContext context) {
        Page<PIMARMYCADRES> domains = pimarmycadresService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarmycadresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-JLSSGLY-all')")
	@ApiOperation(value = "获取记录所属（管理员）", tags = {"军转干部" } ,notes = "获取记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimarmycadres/fetchjlssgly")
	public ResponseEntity<List<PIMARMYCADRESDTO>> fetchJLSSGLY(PIMARMYCADRESSearchContext context) {
        Page<PIMARMYCADRES> domains = pimarmycadresService.searchJLSSGLY(context) ;
        List<PIMARMYCADRESDTO> list = pimarmycadresMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-JLSSGLY-all')")
	@ApiOperation(value = "查询记录所属（管理员）", tags = {"军转干部" } ,notes = "查询记录所属（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimarmycadres/searchjlssgly")
	public ResponseEntity<Page<PIMARMYCADRESDTO>> searchJLSSGLY(@RequestBody PIMARMYCADRESSearchContext context) {
        Page<PIMARMYCADRES> domains = pimarmycadresService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarmycadresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-JLSSGR-all')")
	@ApiOperation(value = "获取记录所属（个人）", tags = {"军转干部" } ,notes = "获取记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimarmycadres/fetchjlssgr")
	public ResponseEntity<List<PIMARMYCADRESDTO>> fetchJLSSGR(PIMARMYCADRESSearchContext context) {
        Page<PIMARMYCADRES> domains = pimarmycadresService.searchJLSSGR(context) ;
        List<PIMARMYCADRESDTO> list = pimarmycadresMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-JLSSGR-all')")
	@ApiOperation(value = "查询记录所属（个人）", tags = {"军转干部" } ,notes = "查询记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimarmycadres/searchjlssgr")
	public ResponseEntity<Page<PIMARMYCADRESDTO>> searchJLSSGR(@RequestBody PIMARMYCADRESSearchContext context) {
        Page<PIMARMYCADRES> domains = pimarmycadresService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarmycadresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimarmycadresService.get(#pimarmycadres_id),'ehr-PIMARMYCADRES-Remove')")
    @ApiOperation(value = "根据人员信息删除军转干部", tags = {"军转干部" },  notes = "根据人员信息删除军转干部")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarmycadres/{pimarmycadres_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarmycadres_id") String pimarmycadres_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimarmycadresService.remove(pimarmycadres_id));
    }

    @PreAuthorize("hasPermission(this.pimarmycadresService.getPimarmycadresByIds(#ids),'ehr-PIMARMYCADRES-Remove')")
    @ApiOperation(value = "根据人员信息批量删除军转干部", tags = {"军转干部" },  notes = "根据人员信息批量删除军转干部")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimarmycadres/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimarmycadresService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息获取军转干部草稿", tags = {"军转干部" },  notes = "根据人员信息获取军转干部草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarmycadres/getdraft")
    public ResponseEntity<PIMARMYCADRESDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PIMARMYCADRES domain = new PIMARMYCADRES();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarmycadresMapping.toDto(pimarmycadresService.getDraft(domain)));
    }

    @ApiOperation(value = "根据人员信息检查军转干部", tags = {"军转干部" },  notes = "根据人员信息检查军转干部")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarmycadres/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMARMYCADRESDTO pimarmycadresdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimarmycadresService.checkKey(pimarmycadresMapping.toDomain(pimarmycadresdto)));
    }

    @PreAuthorize("hasPermission(this.pimarmycadresMapping.toDomain(#pimarmycadresdto),'ehr-PIMARMYCADRES-Create')")
    @ApiOperation(value = "根据人员信息建立军转干部", tags = {"军转干部" },  notes = "根据人员信息建立军转干部")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarmycadres")
    @Transactional
    public ResponseEntity<PIMARMYCADRESDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMARMYCADRESDTO pimarmycadresdto) {
        PIMARMYCADRES domain = pimarmycadresMapping.toDomain(pimarmycadresdto);
        domain.setPimpersonid(pimperson_id);
		pimarmycadresService.create(domain);
        PIMARMYCADRESDTO dto = pimarmycadresMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarmycadresMapping.toDomain(#pimarmycadresdtos),'ehr-PIMARMYCADRES-Create')")
    @ApiOperation(value = "根据人员信息批量建立军转干部", tags = {"军转干部" },  notes = "根据人员信息批量建立军转干部")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarmycadres/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMARMYCADRESDTO> pimarmycadresdtos) {
        List<PIMARMYCADRES> domainlist=pimarmycadresMapping.toDomain(pimarmycadresdtos);
        for(PIMARMYCADRES domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimarmycadresService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimarmycadresService.get(#pimarmycadres_id),'ehr-PIMARMYCADRES-Update')")
    @ApiOperation(value = "根据人员信息更新军转干部", tags = {"军转干部" },  notes = "根据人员信息更新军转干部")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarmycadres/{pimarmycadres_id}")
    @Transactional
    public ResponseEntity<PIMARMYCADRESDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarmycadres_id") String pimarmycadres_id, @RequestBody PIMARMYCADRESDTO pimarmycadresdto) {
        PIMARMYCADRES domain = pimarmycadresMapping.toDomain(pimarmycadresdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimarmycadresid(pimarmycadres_id);
		pimarmycadresService.update(domain);
        PIMARMYCADRESDTO dto = pimarmycadresMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarmycadresService.getPimarmycadresByEntities(this.pimarmycadresMapping.toDomain(#pimarmycadresdtos)),'ehr-PIMARMYCADRES-Update')")
    @ApiOperation(value = "根据人员信息批量更新军转干部", tags = {"军转干部" },  notes = "根据人员信息批量更新军转干部")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimarmycadres/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMARMYCADRESDTO> pimarmycadresdtos) {
        List<PIMARMYCADRES> domainlist=pimarmycadresMapping.toDomain(pimarmycadresdtos);
        for(PIMARMYCADRES domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimarmycadresService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimarmycadresMapping.toDomain(returnObject.body),'ehr-PIMARMYCADRES-Get')")
    @ApiOperation(value = "根据人员信息获取军转干部", tags = {"军转干部" },  notes = "根据人员信息获取军转干部")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimarmycadres/{pimarmycadres_id}")
    public ResponseEntity<PIMARMYCADRESDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimarmycadres_id") String pimarmycadres_id) {
        PIMARMYCADRES domain = pimarmycadresService.get(pimarmycadres_id);
        PIMARMYCADRESDTO dto = pimarmycadresMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimarmycadresMapping.toDomain(#pimarmycadresdto),'ehr-PIMARMYCADRES-Save')")
    @ApiOperation(value = "根据人员信息保存军转干部", tags = {"军转干部" },  notes = "根据人员信息保存军转干部")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarmycadres/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMARMYCADRESDTO pimarmycadresdto) {
        PIMARMYCADRES domain = pimarmycadresMapping.toDomain(pimarmycadresdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimarmycadresService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimarmycadresMapping.toDomain(#pimarmycadresdtos),'ehr-PIMARMYCADRES-Save')")
    @ApiOperation(value = "根据人员信息批量保存军转干部", tags = {"军转干部" },  notes = "根据人员信息批量保存军转干部")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimarmycadres/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMARMYCADRESDTO> pimarmycadresdtos) {
        List<PIMARMYCADRES> domainlist=pimarmycadresMapping.toDomain(pimarmycadresdtos);
        for(PIMARMYCADRES domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimarmycadresService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"军转干部" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarmycadres/fetchdefault")
	public ResponseEntity<List<PIMARMYCADRESDTO>> fetchPIMARMYCADRESDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMARMYCADRESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARMYCADRES> domains = pimarmycadresService.searchDefault(context) ;
        List<PIMARMYCADRESDTO> list = pimarmycadresMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"军转干部" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarmycadres/searchdefault")
	public ResponseEntity<Page<PIMARMYCADRESDTO>> searchPIMARMYCADRESDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMARMYCADRESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARMYCADRES> domains = pimarmycadresService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarmycadresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-JLSSGLY-all')")
	@ApiOperation(value = "根据人员信息获取记录所属（管理员）", tags = {"军转干部" } ,notes = "根据人员信息获取记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarmycadres/fetchjlssgly")
	public ResponseEntity<List<PIMARMYCADRESDTO>> fetchPIMARMYCADRESJLSSGLYByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMARMYCADRESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARMYCADRES> domains = pimarmycadresService.searchJLSSGLY(context) ;
        List<PIMARMYCADRESDTO> list = pimarmycadresMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-JLSSGLY-all')")
	@ApiOperation(value = "根据人员信息查询记录所属（管理员）", tags = {"军转干部" } ,notes = "根据人员信息查询记录所属（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarmycadres/searchjlssgly")
	public ResponseEntity<Page<PIMARMYCADRESDTO>> searchPIMARMYCADRESJLSSGLYByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMARMYCADRESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARMYCADRES> domains = pimarmycadresService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarmycadresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-JLSSGR-all')")
	@ApiOperation(value = "根据人员信息获取记录所属（个人）", tags = {"军转干部" } ,notes = "根据人员信息获取记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimarmycadres/fetchjlssgr")
	public ResponseEntity<List<PIMARMYCADRESDTO>> fetchPIMARMYCADRESJLSSGRByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMARMYCADRESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARMYCADRES> domains = pimarmycadresService.searchJLSSGR(context) ;
        List<PIMARMYCADRESDTO> list = pimarmycadresMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMARMYCADRES-JLSSGR-all')")
	@ApiOperation(value = "根据人员信息查询记录所属（个人）", tags = {"军转干部" } ,notes = "根据人员信息查询记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimarmycadres/searchjlssgr")
	public ResponseEntity<Page<PIMARMYCADRESDTO>> searchPIMARMYCADRESJLSSGRByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMARMYCADRESSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMARMYCADRES> domains = pimarmycadresService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimarmycadresMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

