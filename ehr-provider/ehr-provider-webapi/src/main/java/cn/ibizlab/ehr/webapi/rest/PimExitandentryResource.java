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
import cn.ibizlab.ehr.core.pim.domain.PimExitandentry;
import cn.ibizlab.ehr.core.pim.service.IPimExitandentryService;
import cn.ibizlab.ehr.core.pim.filter.PimExitandentrySearchContext;

@Slf4j
@Api(tags = {"出入境管理" })
@RestController("WebApi-pimexitandentry")
@RequestMapping("")
public class PimExitandentryResource {

    @Autowired
    public IPimExitandentryService pimexitandentryService;

    @Autowired
    @Lazy
    public PimExitandentryMapping pimexitandentryMapping;

    @PreAuthorize("hasPermission(this.pimexitandentryService.get(#pimexitandentry_id),'ehr-PimExitandentry-Update')")
    @ApiOperation(value = "更新出入境管理", tags = {"出入境管理" },  notes = "更新出入境管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimexitandentries/{pimexitandentry_id}")
    @Transactional
    public ResponseEntity<PimExitandentryDTO> update(@PathVariable("pimexitandentry_id") String pimexitandentry_id, @RequestBody PimExitandentryDTO pimexitandentrydto) {
		PimExitandentry domain  = pimexitandentryMapping.toDomain(pimexitandentrydto);
        domain .setPimexitandentryid(pimexitandentry_id);
		pimexitandentryService.update(domain );
		PimExitandentryDTO dto = pimexitandentryMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimexitandentryService.getPimexitandentryByEntities(this.pimexitandentryMapping.toDomain(#pimexitandentrydtos)),'ehr-PimExitandentry-Update')")
    @ApiOperation(value = "批量更新出入境管理", tags = {"出入境管理" },  notes = "批量更新出入境管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimexitandentries/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimExitandentryDTO> pimexitandentrydtos) {
        pimexitandentryService.updateBatch(pimexitandentryMapping.toDomain(pimexitandentrydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimexitandentryMapping.toDomain(#pimexitandentrydto),'ehr-PimExitandentry-Save')")
    @ApiOperation(value = "保存出入境管理", tags = {"出入境管理" },  notes = "保存出入境管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexitandentries/save")
    public ResponseEntity<Boolean> save(@RequestBody PimExitandentryDTO pimexitandentrydto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimexitandentryService.save(pimexitandentryMapping.toDomain(pimexitandentrydto)));
    }

    @PreAuthorize("hasPermission(this.pimexitandentryMapping.toDomain(#pimexitandentrydtos),'ehr-PimExitandentry-Save')")
    @ApiOperation(value = "批量保存出入境管理", tags = {"出入境管理" },  notes = "批量保存出入境管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexitandentries/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimExitandentryDTO> pimexitandentrydtos) {
        pimexitandentryService.saveBatch(pimexitandentryMapping.toDomain(pimexitandentrydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-CX-all')")
    @ApiOperation(value = "撤销", tags = {"出入境管理" },  notes = "撤销")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexitandentries/{pimexitandentry_id}/cx")
    @Transactional
    public ResponseEntity<PimExitandentryDTO> cX(@PathVariable("pimexitandentry_id") String pimexitandentry_id, @RequestBody PimExitandentryDTO pimexitandentrydto) {
        PimExitandentry pimexitandentry = pimexitandentryMapping.toDomain(pimexitandentrydto);
        pimexitandentry.setPimexitandentryid(pimexitandentry_id);
        pimexitandentry = pimexitandentryService.cX(pimexitandentry);
        pimexitandentrydto = pimexitandentryMapping.toDto(pimexitandentry);
        return ResponseEntity.status(HttpStatus.OK).body(pimexitandentrydto);
    }

    @PostAuthorize("hasPermission(this.pimexitandentryMapping.toDomain(returnObject.body),'ehr-PimExitandentry-Get')")
    @ApiOperation(value = "获取出入境管理", tags = {"出入境管理" },  notes = "获取出入境管理")
	@RequestMapping(method = RequestMethod.GET, value = "/pimexitandentries/{pimexitandentry_id}")
    public ResponseEntity<PimExitandentryDTO> get(@PathVariable("pimexitandentry_id") String pimexitandentry_id) {
        PimExitandentry domain = pimexitandentryService.get(pimexitandentry_id);
        PimExitandentryDTO dto = pimexitandentryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取出入境管理草稿", tags = {"出入境管理" },  notes = "获取出入境管理草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimexitandentries/getdraft")
    public ResponseEntity<PimExitandentryDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimexitandentryMapping.toDto(pimexitandentryService.getDraft(new PimExitandentry())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-MobStart-all')")
    @ApiOperation(value = "移动端启动流程", tags = {"出入境管理" },  notes = "移动端启动流程")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexitandentries/{pimexitandentry_id}/mobstart")
    @Transactional
    public ResponseEntity<PimExitandentryDTO> mobStart(@PathVariable("pimexitandentry_id") String pimexitandentry_id, @RequestBody PimExitandentryDTO pimexitandentrydto) {
        PimExitandentry pimexitandentry = pimexitandentryMapping.toDomain(pimexitandentrydto);
        pimexitandentry.setPimexitandentryid(pimexitandentry_id);
        pimexitandentry = pimexitandentryService.mobStart(pimexitandentry);
        pimexitandentrydto = pimexitandentryMapping.toDto(pimexitandentry);
        return ResponseEntity.status(HttpStatus.OK).body(pimexitandentrydto);
    }

    @PreAuthorize("hasPermission(this.pimexitandentryMapping.toDomain(#pimexitandentrydto),'ehr-PimExitandentry-Create')")
    @ApiOperation(value = "新建出入境管理", tags = {"出入境管理" },  notes = "新建出入境管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexitandentries")
    @Transactional
    public ResponseEntity<PimExitandentryDTO> create(@RequestBody PimExitandentryDTO pimexitandentrydto) {
        PimExitandentry domain = pimexitandentryMapping.toDomain(pimexitandentrydto);
		pimexitandentryService.create(domain);
        PimExitandentryDTO dto = pimexitandentryMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimexitandentryMapping.toDomain(#pimexitandentrydtos),'ehr-PimExitandentry-Create')")
    @ApiOperation(value = "批量新建出入境管理", tags = {"出入境管理" },  notes = "批量新建出入境管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexitandentries/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimExitandentryDTO> pimexitandentrydtos) {
        pimexitandentryService.createBatch(pimexitandentryMapping.toDomain(pimexitandentrydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimexitandentryService.get(#pimexitandentry_id),'ehr-PimExitandentry-Remove')")
    @ApiOperation(value = "删除出入境管理", tags = {"出入境管理" },  notes = "删除出入境管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimexitandentries/{pimexitandentry_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimexitandentry_id") String pimexitandentry_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimexitandentryService.remove(pimexitandentry_id));
    }

    @PreAuthorize("hasPermission(this.pimexitandentryService.getPimexitandentryByIds(#ids),'ehr-PimExitandentry-Remove')")
    @ApiOperation(value = "批量删除出入境管理", tags = {"出入境管理" },  notes = "批量删除出入境管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimexitandentries/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimexitandentryService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-CB-all')")
    @ApiOperation(value = "催办", tags = {"出入境管理" },  notes = "催办")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexitandentries/{pimexitandentry_id}/cb")
    @Transactional
    public ResponseEntity<PimExitandentryDTO> cB(@PathVariable("pimexitandentry_id") String pimexitandentry_id, @RequestBody PimExitandentryDTO pimexitandentrydto) {
        PimExitandentry pimexitandentry = pimexitandentryMapping.toDomain(pimexitandentrydto);
        pimexitandentry.setPimexitandentryid(pimexitandentry_id);
        pimexitandentry = pimexitandentryService.cB(pimexitandentry);
        pimexitandentrydto = pimexitandentryMapping.toDto(pimexitandentry);
        return ResponseEntity.status(HttpStatus.OK).body(pimexitandentrydto);
    }

    @ApiOperation(value = "检查出入境管理", tags = {"出入境管理" },  notes = "检查出入境管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexitandentries/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimExitandentryDTO pimexitandentrydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimexitandentryService.checkKey(pimexitandentryMapping.toDomain(pimexitandentrydto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-Start-all')")
    @ApiOperation(value = "启动流程", tags = {"出入境管理" },  notes = "启动流程")
	@RequestMapping(method = RequestMethod.POST, value = "/pimexitandentries/{pimexitandentry_id}/start")
    @Transactional
    public ResponseEntity<PimExitandentryDTO> start(@PathVariable("pimexitandentry_id") String pimexitandentry_id, @RequestBody PimExitandentryDTO pimexitandentrydto) {
        PimExitandentry pimexitandentry = pimexitandentryMapping.toDomain(pimexitandentrydto);
        pimexitandentry.setPimexitandentryid(pimexitandentry_id);
        pimexitandentry = pimexitandentryService.start(pimexitandentry);
        pimexitandentrydto = pimexitandentryMapping.toDto(pimexitandentry);
        return ResponseEntity.status(HttpStatus.OK).body(pimexitandentrydto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-YGCGJ-all')")
	@ApiOperation(value = "获取因公出国境", tags = {"出入境管理" } ,notes = "获取因公出国境")
    @RequestMapping(method= RequestMethod.GET , value="/pimexitandentries/fetchygcgj")
	public ResponseEntity<List<PimExitandentryDTO>> fetchYGCGJ(PimExitandentrySearchContext context) {
        Page<PimExitandentry> domains = pimexitandentryService.searchYGCGJ(context) ;
        List<PimExitandentryDTO> list = pimexitandentryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-YGCGJ-all')")
	@ApiOperation(value = "查询因公出国境", tags = {"出入境管理" } ,notes = "查询因公出国境")
    @RequestMapping(method= RequestMethod.POST , value="/pimexitandentries/searchygcgj")
	public ResponseEntity<Page<PimExitandentryDTO>> searchYGCGJ(@RequestBody PimExitandentrySearchContext context) {
        Page<PimExitandentry> domains = pimexitandentryService.searchYGCGJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexitandentryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-YGZZ-all')")
	@ApiOperation(value = "获取员工自助", tags = {"出入境管理" } ,notes = "获取员工自助")
    @RequestMapping(method= RequestMethod.GET , value="/pimexitandentries/fetchygzz")
	public ResponseEntity<List<PimExitandentryDTO>> fetchYGZZ(PimExitandentrySearchContext context) {
        Page<PimExitandentry> domains = pimexitandentryService.searchYGZZ(context) ;
        List<PimExitandentryDTO> list = pimexitandentryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-YGZZ-all')")
	@ApiOperation(value = "查询员工自助", tags = {"出入境管理" } ,notes = "查询员工自助")
    @RequestMapping(method= RequestMethod.POST , value="/pimexitandentries/searchygzz")
	public ResponseEntity<Page<PimExitandentryDTO>> searchYGZZ(@RequestBody PimExitandentrySearchContext context) {
        Page<PimExitandentry> domains = pimexitandentryService.searchYGZZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexitandentryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-MOBJLSS-all')")
	@ApiOperation(value = "获取记录所属（移动端）", tags = {"出入境管理" } ,notes = "获取记录所属（移动端）")
    @RequestMapping(method= RequestMethod.GET , value="/pimexitandentries/fetchmobjlss")
	public ResponseEntity<List<PimExitandentryDTO>> fetchMOBJLSS(PimExitandentrySearchContext context) {
        Page<PimExitandentry> domains = pimexitandentryService.searchMOBJLSS(context) ;
        List<PimExitandentryDTO> list = pimexitandentryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-MOBJLSS-all')")
	@ApiOperation(value = "查询记录所属（移动端）", tags = {"出入境管理" } ,notes = "查询记录所属（移动端）")
    @RequestMapping(method= RequestMethod.POST , value="/pimexitandentries/searchmobjlss")
	public ResponseEntity<Page<PimExitandentryDTO>> searchMOBJLSS(@RequestBody PimExitandentrySearchContext context) {
        Page<PimExitandentry> domains = pimexitandentryService.searchMOBJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexitandentryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-YSCGJ-all')")
	@ApiOperation(value = "获取因私出国境", tags = {"出入境管理" } ,notes = "获取因私出国境")
    @RequestMapping(method= RequestMethod.GET , value="/pimexitandentries/fetchyscgj")
	public ResponseEntity<List<PimExitandentryDTO>> fetchYSCGJ(PimExitandentrySearchContext context) {
        Page<PimExitandentry> domains = pimexitandentryService.searchYSCGJ(context) ;
        List<PimExitandentryDTO> list = pimexitandentryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-YSCGJ-all')")
	@ApiOperation(value = "查询因私出国境", tags = {"出入境管理" } ,notes = "查询因私出国境")
    @RequestMapping(method= RequestMethod.POST , value="/pimexitandentries/searchyscgj")
	public ResponseEntity<Page<PimExitandentryDTO>> searchYSCGJ(@RequestBody PimExitandentrySearchContext context) {
        Page<PimExitandentry> domains = pimexitandentryService.searchYSCGJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexitandentryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-FormType-all')")
	@ApiOperation(value = "获取FormType", tags = {"出入境管理" } ,notes = "获取FormType")
    @RequestMapping(method= RequestMethod.GET , value="/pimexitandentries/fetchformtype")
	public ResponseEntity<List<PimExitandentryDTO>> fetchFormType(PimExitandentrySearchContext context) {
        Page<PimExitandentry> domains = pimexitandentryService.searchFormType(context) ;
        List<PimExitandentryDTO> list = pimexitandentryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-FormType-all')")
	@ApiOperation(value = "查询FormType", tags = {"出入境管理" } ,notes = "查询FormType")
    @RequestMapping(method= RequestMethod.POST , value="/pimexitandentries/searchformtype")
	public ResponseEntity<Page<PimExitandentryDTO>> searchFormType(@RequestBody PimExitandentrySearchContext context) {
        Page<PimExitandentry> domains = pimexitandentryService.searchFormType(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexitandentryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"出入境管理" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimexitandentries/fetchdefault")
	public ResponseEntity<List<PimExitandentryDTO>> fetchDefault(PimExitandentrySearchContext context) {
        Page<PimExitandentry> domains = pimexitandentryService.searchDefault(context) ;
        List<PimExitandentryDTO> list = pimexitandentryMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"出入境管理" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimexitandentries/searchdefault")
	public ResponseEntity<Page<PimExitandentryDTO>> searchDefault(@RequestBody PimExitandentrySearchContext context) {
        Page<PimExitandentry> domains = pimexitandentryService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexitandentryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimexitandentryService.get(#pimexitandentry_id),'ehr-PimExitandentry-Update')")
    @ApiOperation(value = "根据人员信息更新出入境管理", tags = {"出入境管理" },  notes = "根据人员信息更新出入境管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimexitandentries/{pimexitandentry_id}")
    @Transactional
    public ResponseEntity<PimExitandentryDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimexitandentry_id") String pimexitandentry_id, @RequestBody PimExitandentryDTO pimexitandentrydto) {
        PimExitandentry domain = pimexitandentryMapping.toDomain(pimexitandentrydto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimexitandentryid(pimexitandentry_id);
		pimexitandentryService.update(domain);
        PimExitandentryDTO dto = pimexitandentryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimexitandentryService.getPimexitandentryByEntities(this.pimexitandentryMapping.toDomain(#pimexitandentrydtos)),'ehr-PimExitandentry-Update')")
    @ApiOperation(value = "根据人员信息批量更新出入境管理", tags = {"出入境管理" },  notes = "根据人员信息批量更新出入境管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimexitandentries/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimExitandentryDTO> pimexitandentrydtos) {
        List<PimExitandentry> domainlist=pimexitandentryMapping.toDomain(pimexitandentrydtos);
        for(PimExitandentry domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimexitandentryService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimexitandentryMapping.toDomain(#pimexitandentrydto),'ehr-PimExitandentry-Save')")
    @ApiOperation(value = "根据人员信息保存出入境管理", tags = {"出入境管理" },  notes = "根据人员信息保存出入境管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimexitandentries/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimExitandentryDTO pimexitandentrydto) {
        PimExitandentry domain = pimexitandentryMapping.toDomain(pimexitandentrydto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimexitandentryService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimexitandentryMapping.toDomain(#pimexitandentrydtos),'ehr-PimExitandentry-Save')")
    @ApiOperation(value = "根据人员信息批量保存出入境管理", tags = {"出入境管理" },  notes = "根据人员信息批量保存出入境管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimexitandentries/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimExitandentryDTO> pimexitandentrydtos) {
        List<PimExitandentry> domainlist=pimexitandentryMapping.toDomain(pimexitandentrydtos);
        for(PimExitandentry domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimexitandentryService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-CX-all')")
    @ApiOperation(value = "根据人员信息出入境管理", tags = {"出入境管理" },  notes = "根据人员信息出入境管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimexitandentries/{pimexitandentry_id}/cx")
    @Transactional
    public ResponseEntity<PimExitandentryDTO> cXByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimexitandentry_id") String pimexitandentry_id, @RequestBody PimExitandentryDTO pimexitandentrydto) {
        PimExitandentry domain = pimexitandentryMapping.toDomain(pimexitandentrydto);
        domain.setPimpersonid(pimperson_id);
        domain = pimexitandentryService.cX(domain) ;
        pimexitandentrydto = pimexitandentryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimexitandentrydto);
    }

    @PostAuthorize("hasPermission(this.pimexitandentryMapping.toDomain(returnObject.body),'ehr-PimExitandentry-Get')")
    @ApiOperation(value = "根据人员信息获取出入境管理", tags = {"出入境管理" },  notes = "根据人员信息获取出入境管理")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimexitandentries/{pimexitandentry_id}")
    public ResponseEntity<PimExitandentryDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimexitandentry_id") String pimexitandentry_id) {
        PimExitandentry domain = pimexitandentryService.get(pimexitandentry_id);
        PimExitandentryDTO dto = pimexitandentryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据人员信息获取出入境管理草稿", tags = {"出入境管理" },  notes = "根据人员信息获取出入境管理草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimexitandentries/getdraft")
    public ResponseEntity<PimExitandentryDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PimExitandentry domain = new PimExitandentry();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimexitandentryMapping.toDto(pimexitandentryService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-MobStart-all')")
    @ApiOperation(value = "根据人员信息出入境管理", tags = {"出入境管理" },  notes = "根据人员信息出入境管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimexitandentries/{pimexitandentry_id}/mobstart")
    @Transactional
    public ResponseEntity<PimExitandentryDTO> mobStartByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimexitandentry_id") String pimexitandentry_id, @RequestBody PimExitandentryDTO pimexitandentrydto) {
        PimExitandentry domain = pimexitandentryMapping.toDomain(pimexitandentrydto);
        domain.setPimpersonid(pimperson_id);
        domain = pimexitandentryService.mobStart(domain) ;
        pimexitandentrydto = pimexitandentryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimexitandentrydto);
    }

    @PreAuthorize("hasPermission(this.pimexitandentryMapping.toDomain(#pimexitandentrydto),'ehr-PimExitandentry-Create')")
    @ApiOperation(value = "根据人员信息建立出入境管理", tags = {"出入境管理" },  notes = "根据人员信息建立出入境管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimexitandentries")
    @Transactional
    public ResponseEntity<PimExitandentryDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimExitandentryDTO pimexitandentrydto) {
        PimExitandentry domain = pimexitandentryMapping.toDomain(pimexitandentrydto);
        domain.setPimpersonid(pimperson_id);
		pimexitandentryService.create(domain);
        PimExitandentryDTO dto = pimexitandentryMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimexitandentryMapping.toDomain(#pimexitandentrydtos),'ehr-PimExitandentry-Create')")
    @ApiOperation(value = "根据人员信息批量建立出入境管理", tags = {"出入境管理" },  notes = "根据人员信息批量建立出入境管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimexitandentries/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimExitandentryDTO> pimexitandentrydtos) {
        List<PimExitandentry> domainlist=pimexitandentryMapping.toDomain(pimexitandentrydtos);
        for(PimExitandentry domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimexitandentryService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimexitandentryService.get(#pimexitandentry_id),'ehr-PimExitandentry-Remove')")
    @ApiOperation(value = "根据人员信息删除出入境管理", tags = {"出入境管理" },  notes = "根据人员信息删除出入境管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimexitandentries/{pimexitandentry_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimexitandentry_id") String pimexitandentry_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimexitandentryService.remove(pimexitandentry_id));
    }

    @PreAuthorize("hasPermission(this.pimexitandentryService.getPimexitandentryByIds(#ids),'ehr-PimExitandentry-Remove')")
    @ApiOperation(value = "根据人员信息批量删除出入境管理", tags = {"出入境管理" },  notes = "根据人员信息批量删除出入境管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimexitandentries/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimexitandentryService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-CB-all')")
    @ApiOperation(value = "根据人员信息出入境管理", tags = {"出入境管理" },  notes = "根据人员信息出入境管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimexitandentries/{pimexitandentry_id}/cb")
    @Transactional
    public ResponseEntity<PimExitandentryDTO> cBByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimexitandentry_id") String pimexitandentry_id, @RequestBody PimExitandentryDTO pimexitandentrydto) {
        PimExitandentry domain = pimexitandentryMapping.toDomain(pimexitandentrydto);
        domain.setPimpersonid(pimperson_id);
        domain = pimexitandentryService.cB(domain) ;
        pimexitandentrydto = pimexitandentryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimexitandentrydto);
    }

    @ApiOperation(value = "根据人员信息检查出入境管理", tags = {"出入境管理" },  notes = "根据人员信息检查出入境管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimexitandentries/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimExitandentryDTO pimexitandentrydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimexitandentryService.checkKey(pimexitandentryMapping.toDomain(pimexitandentrydto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-Start-all')")
    @ApiOperation(value = "根据人员信息出入境管理", tags = {"出入境管理" },  notes = "根据人员信息出入境管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimexitandentries/{pimexitandentry_id}/start")
    @Transactional
    public ResponseEntity<PimExitandentryDTO> startByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimexitandentry_id") String pimexitandentry_id, @RequestBody PimExitandentryDTO pimexitandentrydto) {
        PimExitandentry domain = pimexitandentryMapping.toDomain(pimexitandentrydto);
        domain.setPimpersonid(pimperson_id);
        domain = pimexitandentryService.start(domain) ;
        pimexitandentrydto = pimexitandentryMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimexitandentrydto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-YGCGJ-all')")
	@ApiOperation(value = "根据人员信息获取因公出国境", tags = {"出入境管理" } ,notes = "根据人员信息获取因公出国境")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimexitandentries/fetchygcgj")
	public ResponseEntity<List<PimExitandentryDTO>> fetchPimExitandentryYGCGJByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimExitandentrySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimExitandentry> domains = pimexitandentryService.searchYGCGJ(context) ;
        List<PimExitandentryDTO> list = pimexitandentryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-YGCGJ-all')")
	@ApiOperation(value = "根据人员信息查询因公出国境", tags = {"出入境管理" } ,notes = "根据人员信息查询因公出国境")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimexitandentries/searchygcgj")
	public ResponseEntity<Page<PimExitandentryDTO>> searchPimExitandentryYGCGJByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimExitandentrySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimExitandentry> domains = pimexitandentryService.searchYGCGJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexitandentryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-YGZZ-all')")
	@ApiOperation(value = "根据人员信息获取员工自助", tags = {"出入境管理" } ,notes = "根据人员信息获取员工自助")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimexitandentries/fetchygzz")
	public ResponseEntity<List<PimExitandentryDTO>> fetchPimExitandentryYGZZByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimExitandentrySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimExitandentry> domains = pimexitandentryService.searchYGZZ(context) ;
        List<PimExitandentryDTO> list = pimexitandentryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-YGZZ-all')")
	@ApiOperation(value = "根据人员信息查询员工自助", tags = {"出入境管理" } ,notes = "根据人员信息查询员工自助")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimexitandentries/searchygzz")
	public ResponseEntity<Page<PimExitandentryDTO>> searchPimExitandentryYGZZByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimExitandentrySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimExitandentry> domains = pimexitandentryService.searchYGZZ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexitandentryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-MOBJLSS-all')")
	@ApiOperation(value = "根据人员信息获取记录所属（移动端）", tags = {"出入境管理" } ,notes = "根据人员信息获取记录所属（移动端）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimexitandentries/fetchmobjlss")
	public ResponseEntity<List<PimExitandentryDTO>> fetchPimExitandentryMOBJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimExitandentrySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimExitandentry> domains = pimexitandentryService.searchMOBJLSS(context) ;
        List<PimExitandentryDTO> list = pimexitandentryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-MOBJLSS-all')")
	@ApiOperation(value = "根据人员信息查询记录所属（移动端）", tags = {"出入境管理" } ,notes = "根据人员信息查询记录所属（移动端）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimexitandentries/searchmobjlss")
	public ResponseEntity<Page<PimExitandentryDTO>> searchPimExitandentryMOBJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimExitandentrySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimExitandentry> domains = pimexitandentryService.searchMOBJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexitandentryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-YSCGJ-all')")
	@ApiOperation(value = "根据人员信息获取因私出国境", tags = {"出入境管理" } ,notes = "根据人员信息获取因私出国境")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimexitandentries/fetchyscgj")
	public ResponseEntity<List<PimExitandentryDTO>> fetchPimExitandentryYSCGJByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimExitandentrySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimExitandentry> domains = pimexitandentryService.searchYSCGJ(context) ;
        List<PimExitandentryDTO> list = pimexitandentryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-YSCGJ-all')")
	@ApiOperation(value = "根据人员信息查询因私出国境", tags = {"出入境管理" } ,notes = "根据人员信息查询因私出国境")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimexitandentries/searchyscgj")
	public ResponseEntity<Page<PimExitandentryDTO>> searchPimExitandentryYSCGJByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimExitandentrySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimExitandentry> domains = pimexitandentryService.searchYSCGJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexitandentryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-FormType-all')")
	@ApiOperation(value = "根据人员信息获取FormType", tags = {"出入境管理" } ,notes = "根据人员信息获取FormType")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimexitandentries/fetchformtype")
	public ResponseEntity<List<PimExitandentryDTO>> fetchPimExitandentryFormTypeByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimExitandentrySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimExitandentry> domains = pimexitandentryService.searchFormType(context) ;
        List<PimExitandentryDTO> list = pimexitandentryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-FormType-all')")
	@ApiOperation(value = "根据人员信息查询FormType", tags = {"出入境管理" } ,notes = "根据人员信息查询FormType")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimexitandentries/searchformtype")
	public ResponseEntity<Page<PimExitandentryDTO>> searchPimExitandentryFormTypeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimExitandentrySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimExitandentry> domains = pimexitandentryService.searchFormType(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexitandentryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"出入境管理" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimexitandentries/fetchdefault")
	public ResponseEntity<List<PimExitandentryDTO>> fetchPimExitandentryDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimExitandentrySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimExitandentry> domains = pimexitandentryService.searchDefault(context) ;
        List<PimExitandentryDTO> list = pimexitandentryMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimExitandentry-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"出入境管理" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimexitandentries/searchdefault")
	public ResponseEntity<Page<PimExitandentryDTO>> searchPimExitandentryDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimExitandentrySearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimExitandentry> domains = pimexitandentryService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimexitandentryMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

