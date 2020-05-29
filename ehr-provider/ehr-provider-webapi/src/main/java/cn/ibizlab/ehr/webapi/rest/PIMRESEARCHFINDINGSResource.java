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
import cn.ibizlab.ehr.core.pim.domain.PIMRESEARCHFINDINGS;
import cn.ibizlab.ehr.core.pim.service.IPIMRESEARCHFINDINGSService;
import cn.ibizlab.ehr.core.pim.filter.PIMRESEARCHFINDINGSSearchContext;

@Slf4j
@Api(tags = {"科研成果" })
@RestController("WebApi-pimresearchfindings")
@RequestMapping("")
public class PIMRESEARCHFINDINGSResource {

    @Autowired
    public IPIMRESEARCHFINDINGSService pimresearchfindingsService;

    @Autowired
    @Lazy
    public PIMRESEARCHFINDINGSMapping pimresearchfindingsMapping;

    @PreAuthorize("hasPermission(this.pimresearchfindingsService.get(#pimresearchfindings_id),'ehr-PIMRESEARCHFINDINGS-Update')")
    @ApiOperation(value = "更新科研成果", tags = {"科研成果" },  notes = "更新科研成果")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimresearchfindings/{pimresearchfindings_id}")
    @Transactional
    public ResponseEntity<PIMRESEARCHFINDINGSDTO> update(@PathVariable("pimresearchfindings_id") String pimresearchfindings_id, @RequestBody PIMRESEARCHFINDINGSDTO pimresearchfindingsdto) {
		PIMRESEARCHFINDINGS domain  = pimresearchfindingsMapping.toDomain(pimresearchfindingsdto);
        domain .setPimresearchfindingsid(pimresearchfindings_id);
		pimresearchfindingsService.update(domain );
		PIMRESEARCHFINDINGSDTO dto = pimresearchfindingsMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsService.getPimresearchfindingsByEntities(this.pimresearchfindingsMapping.toDomain(#pimresearchfindingsdtos)),'ehr-PIMRESEARCHFINDINGS-Update')")
    @ApiOperation(value = "批量更新科研成果", tags = {"科研成果" },  notes = "批量更新科研成果")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimresearchfindings/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMRESEARCHFINDINGSDTO> pimresearchfindingsdtos) {
        pimresearchfindingsService.updateBatch(pimresearchfindingsMapping.toDomain(pimresearchfindingsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsService.get(#pimresearchfindings_id),'ehr-PIMRESEARCHFINDINGS-Remove')")
    @ApiOperation(value = "删除科研成果", tags = {"科研成果" },  notes = "删除科研成果")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimresearchfindings/{pimresearchfindings_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimresearchfindings_id") String pimresearchfindings_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimresearchfindingsService.remove(pimresearchfindings_id));
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsService.getPimresearchfindingsByIds(#ids),'ehr-PIMRESEARCHFINDINGS-Remove')")
    @ApiOperation(value = "批量删除科研成果", tags = {"科研成果" },  notes = "批量删除科研成果")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimresearchfindings/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimresearchfindingsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimresearchfindingsMapping.toDomain(returnObject.body),'ehr-PIMRESEARCHFINDINGS-Get')")
    @ApiOperation(value = "获取科研成果", tags = {"科研成果" },  notes = "获取科研成果")
	@RequestMapping(method = RequestMethod.GET, value = "/pimresearchfindings/{pimresearchfindings_id}")
    public ResponseEntity<PIMRESEARCHFINDINGSDTO> get(@PathVariable("pimresearchfindings_id") String pimresearchfindings_id) {
        PIMRESEARCHFINDINGS domain = pimresearchfindingsService.get(pimresearchfindings_id);
        PIMRESEARCHFINDINGSDTO dto = pimresearchfindingsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取科研成果草稿", tags = {"科研成果" },  notes = "获取科研成果草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimresearchfindings/getdraft")
    public ResponseEntity<PIMRESEARCHFINDINGSDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimresearchfindingsMapping.toDto(pimresearchfindingsService.getDraft(new PIMRESEARCHFINDINGS())));
    }

    @ApiOperation(value = "检查科研成果", tags = {"科研成果" },  notes = "检查科研成果")
	@RequestMapping(method = RequestMethod.POST, value = "/pimresearchfindings/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMRESEARCHFINDINGSDTO pimresearchfindingsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimresearchfindingsService.checkKey(pimresearchfindingsMapping.toDomain(pimresearchfindingsdto)));
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsMapping.toDomain(#pimresearchfindingsdto),'ehr-PIMRESEARCHFINDINGS-Save')")
    @ApiOperation(value = "保存科研成果", tags = {"科研成果" },  notes = "保存科研成果")
	@RequestMapping(method = RequestMethod.POST, value = "/pimresearchfindings/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMRESEARCHFINDINGSDTO pimresearchfindingsdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimresearchfindingsService.save(pimresearchfindingsMapping.toDomain(pimresearchfindingsdto)));
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsMapping.toDomain(#pimresearchfindingsdtos),'ehr-PIMRESEARCHFINDINGS-Save')")
    @ApiOperation(value = "批量保存科研成果", tags = {"科研成果" },  notes = "批量保存科研成果")
	@RequestMapping(method = RequestMethod.POST, value = "/pimresearchfindings/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMRESEARCHFINDINGSDTO> pimresearchfindingsdtos) {
        pimresearchfindingsService.saveBatch(pimresearchfindingsMapping.toDomain(pimresearchfindingsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsMapping.toDomain(#pimresearchfindingsdto),'ehr-PIMRESEARCHFINDINGS-Create')")
    @ApiOperation(value = "新建科研成果", tags = {"科研成果" },  notes = "新建科研成果")
	@RequestMapping(method = RequestMethod.POST, value = "/pimresearchfindings")
    @Transactional
    public ResponseEntity<PIMRESEARCHFINDINGSDTO> create(@RequestBody PIMRESEARCHFINDINGSDTO pimresearchfindingsdto) {
        PIMRESEARCHFINDINGS domain = pimresearchfindingsMapping.toDomain(pimresearchfindingsdto);
		pimresearchfindingsService.create(domain);
        PIMRESEARCHFINDINGSDTO dto = pimresearchfindingsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsMapping.toDomain(#pimresearchfindingsdtos),'ehr-PIMRESEARCHFINDINGS-Create')")
    @ApiOperation(value = "批量新建科研成果", tags = {"科研成果" },  notes = "批量新建科研成果")
	@RequestMapping(method = RequestMethod.POST, value = "/pimresearchfindings/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMRESEARCHFINDINGSDTO> pimresearchfindingsdtos) {
        pimresearchfindingsService.createBatch(pimresearchfindingsMapping.toDomain(pimresearchfindingsdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMRESEARCHFINDINGS-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"科研成果" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/pimresearchfindings/fetchdefault")
	public ResponseEntity<List<PIMRESEARCHFINDINGSDTO>> fetchDefault(PIMRESEARCHFINDINGSSearchContext context) {
        Page<PIMRESEARCHFINDINGS> domains = pimresearchfindingsService.searchDefault(context) ;
        List<PIMRESEARCHFINDINGSDTO> list = pimresearchfindingsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMRESEARCHFINDINGS-Default-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"科研成果" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/pimresearchfindings/searchdefault")
	public ResponseEntity<Page<PIMRESEARCHFINDINGSDTO>> searchDefault(@RequestBody PIMRESEARCHFINDINGSSearchContext context) {
        Page<PIMRESEARCHFINDINGS> domains = pimresearchfindingsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimresearchfindingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMRESEARCHFINDINGS-JLSSGLY-all')")
	@ApiOperation(value = "获取记录所属（管理员）", tags = {"科研成果" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/pimresearchfindings/fetchjlssgly")
	public ResponseEntity<List<PIMRESEARCHFINDINGSDTO>> fetchJLSSGLY(PIMRESEARCHFINDINGSSearchContext context) {
        Page<PIMRESEARCHFINDINGS> domains = pimresearchfindingsService.searchJLSSGLY(context) ;
        List<PIMRESEARCHFINDINGSDTO> list = pimresearchfindingsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMRESEARCHFINDINGS-JLSSGLY-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"科研成果" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/pimresearchfindings/searchjlssgly")
	public ResponseEntity<Page<PIMRESEARCHFINDINGSDTO>> searchJLSSGLY(@RequestBody PIMRESEARCHFINDINGSSearchContext context) {
        Page<PIMRESEARCHFINDINGS> domains = pimresearchfindingsService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimresearchfindingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMRESEARCHFINDINGS-JLSSGR-all')")
	@ApiOperation(value = "获取记录所属（个人）", tags = {"科研成果" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/pimresearchfindings/fetchjlssgr")
	public ResponseEntity<List<PIMRESEARCHFINDINGSDTO>> fetchJLSSGR(PIMRESEARCHFINDINGSSearchContext context) {
        Page<PIMRESEARCHFINDINGS> domains = pimresearchfindingsService.searchJLSSGR(context) ;
        List<PIMRESEARCHFINDINGSDTO> list = pimresearchfindingsMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMRESEARCHFINDINGS-JLSSGR-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"科研成果" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/pimresearchfindings/searchjlssgr")
	public ResponseEntity<Page<PIMRESEARCHFINDINGSDTO>> searchJLSSGR(@RequestBody PIMRESEARCHFINDINGSSearchContext context) {
        Page<PIMRESEARCHFINDINGS> domains = pimresearchfindingsService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimresearchfindingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimresearchfindingsService.get(#pimresearchfindings_id),'ehr-PIMRESEARCHFINDINGS-Update')")
    @ApiOperation(value = "根据人员信息更新科研成果", tags = {"科研成果" },  notes = "根据人员信息更新科研成果")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimresearchfindings/{pimresearchfindings_id}")
    @Transactional
    public ResponseEntity<PIMRESEARCHFINDINGSDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimresearchfindings_id") String pimresearchfindings_id, @RequestBody PIMRESEARCHFINDINGSDTO pimresearchfindingsdto) {
        PIMRESEARCHFINDINGS domain = pimresearchfindingsMapping.toDomain(pimresearchfindingsdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimresearchfindingsid(pimresearchfindings_id);
		pimresearchfindingsService.update(domain);
        PIMRESEARCHFINDINGSDTO dto = pimresearchfindingsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsService.getPimresearchfindingsByEntities(this.pimresearchfindingsMapping.toDomain(#pimresearchfindingsdtos)),'ehr-PIMRESEARCHFINDINGS-Update')")
    @ApiOperation(value = "根据人员信息批量更新科研成果", tags = {"科研成果" },  notes = "根据人员信息批量更新科研成果")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimresearchfindings/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMRESEARCHFINDINGSDTO> pimresearchfindingsdtos) {
        List<PIMRESEARCHFINDINGS> domainlist=pimresearchfindingsMapping.toDomain(pimresearchfindingsdtos);
        for(PIMRESEARCHFINDINGS domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimresearchfindingsService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsService.get(#pimresearchfindings_id),'ehr-PIMRESEARCHFINDINGS-Remove')")
    @ApiOperation(value = "根据人员信息删除科研成果", tags = {"科研成果" },  notes = "根据人员信息删除科研成果")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimresearchfindings/{pimresearchfindings_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimresearchfindings_id") String pimresearchfindings_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimresearchfindingsService.remove(pimresearchfindings_id));
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsService.getPimresearchfindingsByIds(#ids),'ehr-PIMRESEARCHFINDINGS-Remove')")
    @ApiOperation(value = "根据人员信息批量删除科研成果", tags = {"科研成果" },  notes = "根据人员信息批量删除科研成果")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimresearchfindings/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimresearchfindingsService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimresearchfindingsMapping.toDomain(returnObject.body),'ehr-PIMRESEARCHFINDINGS-Get')")
    @ApiOperation(value = "根据人员信息获取科研成果", tags = {"科研成果" },  notes = "根据人员信息获取科研成果")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimresearchfindings/{pimresearchfindings_id}")
    public ResponseEntity<PIMRESEARCHFINDINGSDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimresearchfindings_id") String pimresearchfindings_id) {
        PIMRESEARCHFINDINGS domain = pimresearchfindingsService.get(pimresearchfindings_id);
        PIMRESEARCHFINDINGSDTO dto = pimresearchfindingsMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据人员信息获取科研成果草稿", tags = {"科研成果" },  notes = "根据人员信息获取科研成果草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimresearchfindings/getdraft")
    public ResponseEntity<PIMRESEARCHFINDINGSDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PIMRESEARCHFINDINGS domain = new PIMRESEARCHFINDINGS();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimresearchfindingsMapping.toDto(pimresearchfindingsService.getDraft(domain)));
    }

    @ApiOperation(value = "根据人员信息检查科研成果", tags = {"科研成果" },  notes = "根据人员信息检查科研成果")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimresearchfindings/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMRESEARCHFINDINGSDTO pimresearchfindingsdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimresearchfindingsService.checkKey(pimresearchfindingsMapping.toDomain(pimresearchfindingsdto)));
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsMapping.toDomain(#pimresearchfindingsdto),'ehr-PIMRESEARCHFINDINGS-Save')")
    @ApiOperation(value = "根据人员信息保存科研成果", tags = {"科研成果" },  notes = "根据人员信息保存科研成果")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimresearchfindings/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMRESEARCHFINDINGSDTO pimresearchfindingsdto) {
        PIMRESEARCHFINDINGS domain = pimresearchfindingsMapping.toDomain(pimresearchfindingsdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimresearchfindingsService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsMapping.toDomain(#pimresearchfindingsdtos),'ehr-PIMRESEARCHFINDINGS-Save')")
    @ApiOperation(value = "根据人员信息批量保存科研成果", tags = {"科研成果" },  notes = "根据人员信息批量保存科研成果")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimresearchfindings/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMRESEARCHFINDINGSDTO> pimresearchfindingsdtos) {
        List<PIMRESEARCHFINDINGS> domainlist=pimresearchfindingsMapping.toDomain(pimresearchfindingsdtos);
        for(PIMRESEARCHFINDINGS domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimresearchfindingsService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsMapping.toDomain(#pimresearchfindingsdto),'ehr-PIMRESEARCHFINDINGS-Create')")
    @ApiOperation(value = "根据人员信息建立科研成果", tags = {"科研成果" },  notes = "根据人员信息建立科研成果")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimresearchfindings")
    @Transactional
    public ResponseEntity<PIMRESEARCHFINDINGSDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMRESEARCHFINDINGSDTO pimresearchfindingsdto) {
        PIMRESEARCHFINDINGS domain = pimresearchfindingsMapping.toDomain(pimresearchfindingsdto);
        domain.setPimpersonid(pimperson_id);
		pimresearchfindingsService.create(domain);
        PIMRESEARCHFINDINGSDTO dto = pimresearchfindingsMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimresearchfindingsMapping.toDomain(#pimresearchfindingsdtos),'ehr-PIMRESEARCHFINDINGS-Create')")
    @ApiOperation(value = "根据人员信息批量建立科研成果", tags = {"科研成果" },  notes = "根据人员信息批量建立科研成果")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimresearchfindings/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMRESEARCHFINDINGSDTO> pimresearchfindingsdtos) {
        List<PIMRESEARCHFINDINGS> domainlist=pimresearchfindingsMapping.toDomain(pimresearchfindingsdtos);
        for(PIMRESEARCHFINDINGS domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimresearchfindingsService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMRESEARCHFINDINGS-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"科研成果" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimresearchfindings/fetchdefault")
	public ResponseEntity<List<PIMRESEARCHFINDINGSDTO>> fetchPIMRESEARCHFINDINGSDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMRESEARCHFINDINGSSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMRESEARCHFINDINGS> domains = pimresearchfindingsService.searchDefault(context) ;
        List<PIMRESEARCHFINDINGSDTO> list = pimresearchfindingsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMRESEARCHFINDINGS-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"科研成果" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimresearchfindings/searchdefault")
	public ResponseEntity<Page<PIMRESEARCHFINDINGSDTO>> searchPIMRESEARCHFINDINGSDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMRESEARCHFINDINGSSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMRESEARCHFINDINGS> domains = pimresearchfindingsService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimresearchfindingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMRESEARCHFINDINGS-JLSSGLY-all')")
	@ApiOperation(value = "根据人员信息获取记录所属（管理员）", tags = {"科研成果" } ,notes = "根据人员信息获取记录所属（管理员）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimresearchfindings/fetchjlssgly")
	public ResponseEntity<List<PIMRESEARCHFINDINGSDTO>> fetchPIMRESEARCHFINDINGSJLSSGLYByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMRESEARCHFINDINGSSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMRESEARCHFINDINGS> domains = pimresearchfindingsService.searchJLSSGLY(context) ;
        List<PIMRESEARCHFINDINGSDTO> list = pimresearchfindingsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMRESEARCHFINDINGS-JLSSGLY-all')")
	@ApiOperation(value = "根据人员信息查询记录所属（管理员）", tags = {"科研成果" } ,notes = "根据人员信息查询记录所属（管理员）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimresearchfindings/searchjlssgly")
	public ResponseEntity<Page<PIMRESEARCHFINDINGSDTO>> searchPIMRESEARCHFINDINGSJLSSGLYByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMRESEARCHFINDINGSSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMRESEARCHFINDINGS> domains = pimresearchfindingsService.searchJLSSGLY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimresearchfindingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMRESEARCHFINDINGS-JLSSGR-all')")
	@ApiOperation(value = "根据人员信息获取记录所属（个人）", tags = {"科研成果" } ,notes = "根据人员信息获取记录所属（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimresearchfindings/fetchjlssgr")
	public ResponseEntity<List<PIMRESEARCHFINDINGSDTO>> fetchPIMRESEARCHFINDINGSJLSSGRByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMRESEARCHFINDINGSSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMRESEARCHFINDINGS> domains = pimresearchfindingsService.searchJLSSGR(context) ;
        List<PIMRESEARCHFINDINGSDTO> list = pimresearchfindingsMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMRESEARCHFINDINGS-JLSSGR-all')")
	@ApiOperation(value = "根据人员信息查询记录所属（个人）", tags = {"科研成果" } ,notes = "根据人员信息查询记录所属（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimresearchfindings/searchjlssgr")
	public ResponseEntity<Page<PIMRESEARCHFINDINGSDTO>> searchPIMRESEARCHFINDINGSJLSSGRByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMRESEARCHFINDINGSSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMRESEARCHFINDINGS> domains = pimresearchfindingsService.searchJLSSGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimresearchfindingsMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

