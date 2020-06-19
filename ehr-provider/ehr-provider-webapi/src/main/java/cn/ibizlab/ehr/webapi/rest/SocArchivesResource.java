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
import cn.ibizlab.ehr.core.soc.domain.SocArchives;
import cn.ibizlab.ehr.core.soc.service.ISocArchivesService;
import cn.ibizlab.ehr.core.soc.filter.SocArchivesSearchContext;

@Slf4j
@Api(tags = {"社保档案" })
@RestController("WebApi-socarchives")
@RequestMapping("")
public class SocArchivesResource {

    @Autowired
    public ISocArchivesService socarchivesService;

    @Autowired
    @Lazy
    public SocArchivesMapping socarchivesMapping;

    @PreAuthorize("hasPermission(this.socarchivesService.get(#socarchives_id),'ehr-SocArchives-Remove')")
    @ApiOperation(value = "删除社保档案", tags = {"社保档案" },  notes = "删除社保档案")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socarchives/{socarchives_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("socarchives_id") String socarchives_id) {
         return ResponseEntity.status(HttpStatus.OK).body(socarchivesService.remove(socarchives_id));
    }

    @PreAuthorize("hasPermission(this.socarchivesService.getSocarchivesByIds(#ids),'ehr-SocArchives-Remove')")
    @ApiOperation(value = "批量删除社保档案", tags = {"社保档案" },  notes = "批量删除社保档案")
	@RequestMapping(method = RequestMethod.DELETE, value = "/socarchives/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        socarchivesService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取社保档案草稿", tags = {"社保档案" },  notes = "获取社保档案草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/socarchives/getdraft")
    public ResponseEntity<SocArchivesDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(socarchivesMapping.toDto(socarchivesService.getDraft(new SocArchives())));
    }

    @PreAuthorize("hasPermission(this.socarchivesService.get(#socarchives_id),'ehr-SocArchives-Update')")
    @ApiOperation(value = "更新社保档案", tags = {"社保档案" },  notes = "更新社保档案")
	@RequestMapping(method = RequestMethod.PUT, value = "/socarchives/{socarchives_id}")
    @Transactional
    public ResponseEntity<SocArchivesDTO> update(@PathVariable("socarchives_id") String socarchives_id, @RequestBody SocArchivesDTO socarchivesdto) {
		SocArchives domain  = socarchivesMapping.toDomain(socarchivesdto);
        domain .setSocarchivesid(socarchives_id);
		socarchivesService.update(domain );
		SocArchivesDTO dto = socarchivesMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socarchivesService.getSocarchivesByEntities(this.socarchivesMapping.toDomain(#socarchivesdtos)),'ehr-SocArchives-Update')")
    @ApiOperation(value = "批量更新社保档案", tags = {"社保档案" },  notes = "批量更新社保档案")
	@RequestMapping(method = RequestMethod.PUT, value = "/socarchives/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SocArchivesDTO> socarchivesdtos) {
        socarchivesService.updateBatch(socarchivesMapping.toDomain(socarchivesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.socarchivesMapping.toDomain(returnObject.body),'ehr-SocArchives-Get')")
    @ApiOperation(value = "获取社保档案", tags = {"社保档案" },  notes = "获取社保档案")
	@RequestMapping(method = RequestMethod.GET, value = "/socarchives/{socarchives_id}")
    public ResponseEntity<SocArchivesDTO> get(@PathVariable("socarchives_id") String socarchives_id) {
        SocArchives domain = socarchivesService.get(socarchives_id);
        SocArchivesDTO dto = socarchivesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocArchives-StopArchives-all')")
    @ApiOperation(value = "终止社保", tags = {"社保档案" },  notes = "终止社保")
	@RequestMapping(method = RequestMethod.POST, value = "/socarchives/{socarchives_id}/stoparchives")
    @Transactional
    public ResponseEntity<SocArchivesDTO> stopArchives(@PathVariable("socarchives_id") String socarchives_id, @RequestBody SocArchivesDTO socarchivesdto) {
        SocArchives socarchives = socarchivesMapping.toDomain(socarchivesdto);
        socarchives.setSocarchivesid(socarchives_id);
        socarchives = socarchivesService.stopArchives(socarchives);
        socarchivesdto = socarchivesMapping.toDto(socarchives);
        return ResponseEntity.status(HttpStatus.OK).body(socarchivesdto);
    }

    @PreAuthorize("hasPermission(this.socarchivesMapping.toDomain(#socarchivesdto),'ehr-SocArchives-Save')")
    @ApiOperation(value = "保存社保档案", tags = {"社保档案" },  notes = "保存社保档案")
	@RequestMapping(method = RequestMethod.POST, value = "/socarchives/save")
    public ResponseEntity<Boolean> save(@RequestBody SocArchivesDTO socarchivesdto) {
        return ResponseEntity.status(HttpStatus.OK).body(socarchivesService.save(socarchivesMapping.toDomain(socarchivesdto)));
    }

    @PreAuthorize("hasPermission(this.socarchivesMapping.toDomain(#socarchivesdtos),'ehr-SocArchives-Save')")
    @ApiOperation(value = "批量保存社保档案", tags = {"社保档案" },  notes = "批量保存社保档案")
	@RequestMapping(method = RequestMethod.POST, value = "/socarchives/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SocArchivesDTO> socarchivesdtos) {
        socarchivesService.saveBatch(socarchivesMapping.toDomain(socarchivesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.socarchivesMapping.toDomain(#socarchivesdto),'ehr-SocArchives-Create')")
    @ApiOperation(value = "新建社保档案", tags = {"社保档案" },  notes = "新建社保档案")
	@RequestMapping(method = RequestMethod.POST, value = "/socarchives")
    @Transactional
    public ResponseEntity<SocArchivesDTO> create(@RequestBody SocArchivesDTO socarchivesdto) {
        SocArchives domain = socarchivesMapping.toDomain(socarchivesdto);
		socarchivesService.create(domain);
        SocArchivesDTO dto = socarchivesMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socarchivesMapping.toDomain(#socarchivesdtos),'ehr-SocArchives-Create')")
    @ApiOperation(value = "批量新建社保档案", tags = {"社保档案" },  notes = "批量新建社保档案")
	@RequestMapping(method = RequestMethod.POST, value = "/socarchives/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SocArchivesDTO> socarchivesdtos) {
        socarchivesService.createBatch(socarchivesMapping.toDomain(socarchivesdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查社保档案", tags = {"社保档案" },  notes = "检查社保档案")
	@RequestMapping(method = RequestMethod.POST, value = "/socarchives/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SocArchivesDTO socarchivesdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(socarchivesService.checkKey(socarchivesMapping.toDomain(socarchivesdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocArchives-OrgArchives-all')")
	@ApiOperation(value = "获取ORGARCHIVES", tags = {"社保档案" } ,notes = "获取ORGARCHIVES")
    @RequestMapping(method= RequestMethod.GET , value="/socarchives/fetchorgarchives")
	public ResponseEntity<List<SocArchivesDTO>> fetchOrgArchives(SocArchivesSearchContext context) {
        Page<SocArchives> domains = socarchivesService.searchOrgArchives(context) ;
        List<SocArchivesDTO> list = socarchivesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocArchives-OrgArchives-all')")
	@ApiOperation(value = "查询ORGARCHIVES", tags = {"社保档案" } ,notes = "查询ORGARCHIVES")
    @RequestMapping(method= RequestMethod.POST , value="/socarchives/searchorgarchives")
	public ResponseEntity<Page<SocArchivesDTO>> searchOrgArchives(@RequestBody SocArchivesSearchContext context) {
        Page<SocArchives> domains = socarchivesService.searchOrgArchives(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(socarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocArchives-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"社保档案" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/socarchives/fetchdefault")
	public ResponseEntity<List<SocArchivesDTO>> fetchDefault(SocArchivesSearchContext context) {
        Page<SocArchives> domains = socarchivesService.searchDefault(context) ;
        List<SocArchivesDTO> list = socarchivesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocArchives-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"社保档案" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/socarchives/searchdefault")
	public ResponseEntity<Page<SocArchivesDTO>> searchDefault(@RequestBody SocArchivesSearchContext context) {
        Page<SocArchives> domains = socarchivesService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(socarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocArchives-StopArchives-all')")
	@ApiOperation(value = "获取非员工待终止档案", tags = {"社保档案" } ,notes = "获取非员工待终止档案")
    @RequestMapping(method= RequestMethod.GET , value="/socarchives/fetchstoparchives")
	public ResponseEntity<List<SocArchivesDTO>> fetchStopArchives(SocArchivesSearchContext context) {
        Page<SocArchives> domains = socarchivesService.searchStopArchives(context) ;
        List<SocArchivesDTO> list = socarchivesMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocArchives-StopArchives-all')")
	@ApiOperation(value = "查询非员工待终止档案", tags = {"社保档案" } ,notes = "查询非员工待终止档案")
    @RequestMapping(method= RequestMethod.POST , value="/socarchives/searchstoparchives")
	public ResponseEntity<Page<SocArchivesDTO>> searchStopArchives(@RequestBody SocArchivesSearchContext context) {
        Page<SocArchives> domains = socarchivesService.searchStopArchives(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(socarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.socarchivesService.get(#socarchives_id),'ehr-SocArchives-Remove')")
    @ApiOperation(value = "根据人员信息删除社保档案", tags = {"社保档案" },  notes = "根据人员信息删除社保档案")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/socarchives/{socarchives_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("socarchives_id") String socarchives_id) {
		return ResponseEntity.status(HttpStatus.OK).body(socarchivesService.remove(socarchives_id));
    }

    @PreAuthorize("hasPermission(this.socarchivesService.getSocarchivesByIds(#ids),'ehr-SocArchives-Remove')")
    @ApiOperation(value = "根据人员信息批量删除社保档案", tags = {"社保档案" },  notes = "根据人员信息批量删除社保档案")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/socarchives/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        socarchivesService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息获取社保档案草稿", tags = {"社保档案" },  notes = "根据人员信息获取社保档案草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/socarchives/getdraft")
    public ResponseEntity<SocArchivesDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        SocArchives domain = new SocArchives();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(socarchivesMapping.toDto(socarchivesService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.socarchivesService.get(#socarchives_id),'ehr-SocArchives-Update')")
    @ApiOperation(value = "根据人员信息更新社保档案", tags = {"社保档案" },  notes = "根据人员信息更新社保档案")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/socarchives/{socarchives_id}")
    @Transactional
    public ResponseEntity<SocArchivesDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("socarchives_id") String socarchives_id, @RequestBody SocArchivesDTO socarchivesdto) {
        SocArchives domain = socarchivesMapping.toDomain(socarchivesdto);
        domain.setPimpersonid(pimperson_id);
        domain.setSocarchivesid(socarchives_id);
		socarchivesService.update(domain);
        SocArchivesDTO dto = socarchivesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socarchivesService.getSocarchivesByEntities(this.socarchivesMapping.toDomain(#socarchivesdtos)),'ehr-SocArchives-Update')")
    @ApiOperation(value = "根据人员信息批量更新社保档案", tags = {"社保档案" },  notes = "根据人员信息批量更新社保档案")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/socarchives/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<SocArchivesDTO> socarchivesdtos) {
        List<SocArchives> domainlist=socarchivesMapping.toDomain(socarchivesdtos);
        for(SocArchives domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        socarchivesService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.socarchivesMapping.toDomain(returnObject.body),'ehr-SocArchives-Get')")
    @ApiOperation(value = "根据人员信息获取社保档案", tags = {"社保档案" },  notes = "根据人员信息获取社保档案")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/socarchives/{socarchives_id}")
    public ResponseEntity<SocArchivesDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("socarchives_id") String socarchives_id) {
        SocArchives domain = socarchivesService.get(socarchives_id);
        SocArchivesDTO dto = socarchivesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocArchives-StopArchives-all')")
    @ApiOperation(value = "根据人员信息社保档案", tags = {"社保档案" },  notes = "根据人员信息社保档案")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/socarchives/{socarchives_id}/stoparchives")
    @Transactional
    public ResponseEntity<SocArchivesDTO> stopArchivesByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("socarchives_id") String socarchives_id, @RequestBody SocArchivesDTO socarchivesdto) {
        SocArchives domain = socarchivesMapping.toDomain(socarchivesdto);
        domain.setPimpersonid(pimperson_id);
        domain = socarchivesService.stopArchives(domain) ;
        socarchivesdto = socarchivesMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(socarchivesdto);
    }

    @PreAuthorize("hasPermission(this.socarchivesMapping.toDomain(#socarchivesdto),'ehr-SocArchives-Save')")
    @ApiOperation(value = "根据人员信息保存社保档案", tags = {"社保档案" },  notes = "根据人员信息保存社保档案")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/socarchives/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody SocArchivesDTO socarchivesdto) {
        SocArchives domain = socarchivesMapping.toDomain(socarchivesdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(socarchivesService.save(domain));
    }

    @PreAuthorize("hasPermission(this.socarchivesMapping.toDomain(#socarchivesdtos),'ehr-SocArchives-Save')")
    @ApiOperation(value = "根据人员信息批量保存社保档案", tags = {"社保档案" },  notes = "根据人员信息批量保存社保档案")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/socarchives/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<SocArchivesDTO> socarchivesdtos) {
        List<SocArchives> domainlist=socarchivesMapping.toDomain(socarchivesdtos);
        for(SocArchives domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        socarchivesService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.socarchivesMapping.toDomain(#socarchivesdto),'ehr-SocArchives-Create')")
    @ApiOperation(value = "根据人员信息建立社保档案", tags = {"社保档案" },  notes = "根据人员信息建立社保档案")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/socarchives")
    @Transactional
    public ResponseEntity<SocArchivesDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody SocArchivesDTO socarchivesdto) {
        SocArchives domain = socarchivesMapping.toDomain(socarchivesdto);
        domain.setPimpersonid(pimperson_id);
		socarchivesService.create(domain);
        SocArchivesDTO dto = socarchivesMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.socarchivesMapping.toDomain(#socarchivesdtos),'ehr-SocArchives-Create')")
    @ApiOperation(value = "根据人员信息批量建立社保档案", tags = {"社保档案" },  notes = "根据人员信息批量建立社保档案")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/socarchives/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<SocArchivesDTO> socarchivesdtos) {
        List<SocArchives> domainlist=socarchivesMapping.toDomain(socarchivesdtos);
        for(SocArchives domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        socarchivesService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息检查社保档案", tags = {"社保档案" },  notes = "根据人员信息检查社保档案")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/socarchives/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody SocArchivesDTO socarchivesdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(socarchivesService.checkKey(socarchivesMapping.toDomain(socarchivesdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocArchives-OrgArchives-all')")
	@ApiOperation(value = "根据人员信息获取ORGARCHIVES", tags = {"社保档案" } ,notes = "根据人员信息获取ORGARCHIVES")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/socarchives/fetchorgarchives")
	public ResponseEntity<List<SocArchivesDTO>> fetchSocArchivesOrgArchivesByPimPerson(@PathVariable("pimperson_id") String pimperson_id,SocArchivesSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<SocArchives> domains = socarchivesService.searchOrgArchives(context) ;
        List<SocArchivesDTO> list = socarchivesMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocArchives-OrgArchives-all')")
	@ApiOperation(value = "根据人员信息查询ORGARCHIVES", tags = {"社保档案" } ,notes = "根据人员信息查询ORGARCHIVES")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/socarchives/searchorgarchives")
	public ResponseEntity<Page<SocArchivesDTO>> searchSocArchivesOrgArchivesByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody SocArchivesSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<SocArchives> domains = socarchivesService.searchOrgArchives(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(socarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocArchives-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"社保档案" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/socarchives/fetchdefault")
	public ResponseEntity<List<SocArchivesDTO>> fetchSocArchivesDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,SocArchivesSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<SocArchives> domains = socarchivesService.searchDefault(context) ;
        List<SocArchivesDTO> list = socarchivesMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocArchives-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"社保档案" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/socarchives/searchdefault")
	public ResponseEntity<Page<SocArchivesDTO>> searchSocArchivesDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody SocArchivesSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<SocArchives> domains = socarchivesService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(socarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocArchives-StopArchives-all')")
	@ApiOperation(value = "根据人员信息获取非员工待终止档案", tags = {"社保档案" } ,notes = "根据人员信息获取非员工待终止档案")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/socarchives/fetchstoparchives")
	public ResponseEntity<List<SocArchivesDTO>> fetchSocArchivesStopArchivesByPimPerson(@PathVariable("pimperson_id") String pimperson_id,SocArchivesSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<SocArchives> domains = socarchivesService.searchStopArchives(context) ;
        List<SocArchivesDTO> list = socarchivesMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SocArchives-StopArchives-all')")
	@ApiOperation(value = "根据人员信息查询非员工待终止档案", tags = {"社保档案" } ,notes = "根据人员信息查询非员工待终止档案")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/socarchives/searchstoparchives")
	public ResponseEntity<Page<SocArchivesDTO>> searchSocArchivesStopArchivesByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody SocArchivesSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<SocArchives> domains = socarchivesService.searchStopArchives(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(socarchivesMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

