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
import cn.ibizlab.ehr.core.pcm.domain.PcmPracticeExperience;
import cn.ibizlab.ehr.core.pcm.service.IPcmPracticeExperienceService;
import cn.ibizlab.ehr.core.pcm.filter.PcmPracticeExperienceSearchContext;

@Slf4j
@Api(tags = {"实习经验" })
@RestController("WebApi-pcmpracticeexperience")
@RequestMapping("")
public class PcmPracticeExperienceResource {

    @Autowired
    public IPcmPracticeExperienceService pcmpracticeexperienceService;

    @Autowired
    @Lazy
    public PcmPracticeExperienceMapping pcmpracticeexperienceMapping;

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceService.get(#pcmpracticeexperience_id),'ehr-PcmPracticeExperience-Remove')")
    @ApiOperation(value = "删除实习经验", tags = {"实习经验" },  notes = "删除实习经验")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmpracticeexperiences/{pcmpracticeexperience_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmpracticeexperience_id") String pcmpracticeexperience_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmpracticeexperienceService.remove(pcmpracticeexperience_id));
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceService.getPcmpracticeexperienceByIds(#ids),'ehr-PcmPracticeExperience-Remove')")
    @ApiOperation(value = "批量删除实习经验", tags = {"实习经验" },  notes = "批量删除实习经验")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmpracticeexperiences/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmpracticeexperienceService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceMapping.toDomain(#pcmpracticeexperiencedto),'ehr-PcmPracticeExperience-Create')")
    @ApiOperation(value = "新建实习经验", tags = {"实习经验" },  notes = "新建实习经验")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmpracticeexperiences")
    @Transactional
    public ResponseEntity<PcmPracticeExperienceDTO> create(@RequestBody PcmPracticeExperienceDTO pcmpracticeexperiencedto) {
        PcmPracticeExperience domain = pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedto);
		pcmpracticeexperienceService.create(domain);
        PcmPracticeExperienceDTO dto = pcmpracticeexperienceMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceMapping.toDomain(#pcmpracticeexperiencedtos),'ehr-PcmPracticeExperience-Create')")
    @ApiOperation(value = "批量新建实习经验", tags = {"实习经验" },  notes = "批量新建实习经验")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmpracticeexperiences/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmPracticeExperienceDTO> pcmpracticeexperiencedtos) {
        pcmpracticeexperienceService.createBatch(pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceService.get(#pcmpracticeexperience_id),'ehr-PcmPracticeExperience-Update')")
    @ApiOperation(value = "更新实习经验", tags = {"实习经验" },  notes = "更新实习经验")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmpracticeexperiences/{pcmpracticeexperience_id}")
    @Transactional
    public ResponseEntity<PcmPracticeExperienceDTO> update(@PathVariable("pcmpracticeexperience_id") String pcmpracticeexperience_id, @RequestBody PcmPracticeExperienceDTO pcmpracticeexperiencedto) {
		PcmPracticeExperience domain  = pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedto);
        domain .setPcmpracticeexperienceid(pcmpracticeexperience_id);
		pcmpracticeexperienceService.update(domain );
		PcmPracticeExperienceDTO dto = pcmpracticeexperienceMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceService.getPcmpracticeexperienceByEntities(this.pcmpracticeexperienceMapping.toDomain(#pcmpracticeexperiencedtos)),'ehr-PcmPracticeExperience-Update')")
    @ApiOperation(value = "批量更新实习经验", tags = {"实习经验" },  notes = "批量更新实习经验")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmpracticeexperiences/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmPracticeExperienceDTO> pcmpracticeexperiencedtos) {
        pcmpracticeexperienceService.updateBatch(pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取实习经验草稿", tags = {"实习经验" },  notes = "获取实习经验草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmpracticeexperiences/getdraft")
    public ResponseEntity<PcmPracticeExperienceDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmpracticeexperienceMapping.toDto(pcmpracticeexperienceService.getDraft(new PcmPracticeExperience())));
    }

    @PostAuthorize("hasPermission(this.pcmpracticeexperienceMapping.toDomain(returnObject.body),'ehr-PcmPracticeExperience-Get')")
    @ApiOperation(value = "获取实习经验", tags = {"实习经验" },  notes = "获取实习经验")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmpracticeexperiences/{pcmpracticeexperience_id}")
    public ResponseEntity<PcmPracticeExperienceDTO> get(@PathVariable("pcmpracticeexperience_id") String pcmpracticeexperience_id) {
        PcmPracticeExperience domain = pcmpracticeexperienceService.get(pcmpracticeexperience_id);
        PcmPracticeExperienceDTO dto = pcmpracticeexperienceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查实习经验", tags = {"实习经验" },  notes = "检查实习经验")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmpracticeexperiences/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmPracticeExperienceDTO pcmpracticeexperiencedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmpracticeexperienceService.checkKey(pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedto)));
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceMapping.toDomain(#pcmpracticeexperiencedto),'ehr-PcmPracticeExperience-Save')")
    @ApiOperation(value = "保存实习经验", tags = {"实习经验" },  notes = "保存实习经验")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmpracticeexperiences/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmPracticeExperienceDTO pcmpracticeexperiencedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmpracticeexperienceService.save(pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedto)));
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceMapping.toDomain(#pcmpracticeexperiencedtos),'ehr-PcmPracticeExperience-Save')")
    @ApiOperation(value = "批量保存实习经验", tags = {"实习经验" },  notes = "批量保存实习经验")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmpracticeexperiences/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmPracticeExperienceDTO> pcmpracticeexperiencedtos) {
        pcmpracticeexperienceService.saveBatch(pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmPracticeExperience-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"实习经验" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmpracticeexperiences/fetchdefault")
	public ResponseEntity<List<PcmPracticeExperienceDTO>> fetchDefault(PcmPracticeExperienceSearchContext context) {
        Page<PcmPracticeExperience> domains = pcmpracticeexperienceService.searchDefault(context) ;
        List<PcmPracticeExperienceDTO> list = pcmpracticeexperienceMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmPracticeExperience-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"实习经验" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmpracticeexperiences/searchdefault")
	public ResponseEntity<Page<PcmPracticeExperienceDTO>> searchDefault(@RequestBody PcmPracticeExperienceSearchContext context) {
        Page<PcmPracticeExperience> domains = pcmpracticeexperienceService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmpracticeexperienceMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pcmpracticeexperienceService.get(#pcmpracticeexperience_id),'ehr-PcmPracticeExperience-Remove')")
    @ApiOperation(value = "根据应聘者基本信息删除实习经验", tags = {"实习经验" },  notes = "根据应聘者基本信息删除实习经验")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/{pcmpracticeexperience_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmpracticeexperience_id") String pcmpracticeexperience_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmpracticeexperienceService.remove(pcmpracticeexperience_id));
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceService.getPcmpracticeexperienceByIds(#ids),'ehr-PcmPracticeExperience-Remove')")
    @ApiOperation(value = "根据应聘者基本信息批量删除实习经验", tags = {"实习经验" },  notes = "根据应聘者基本信息批量删除实习经验")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/batch")
    public ResponseEntity<Boolean> removeBatchByPcmProfile(@RequestBody List<String> ids) {
        pcmpracticeexperienceService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceMapping.toDomain(#pcmpracticeexperiencedto),'ehr-PcmPracticeExperience-Create')")
    @ApiOperation(value = "根据应聘者基本信息建立实习经验", tags = {"实习经验" },  notes = "根据应聘者基本信息建立实习经验")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences")
    @Transactional
    public ResponseEntity<PcmPracticeExperienceDTO> createByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmPracticeExperienceDTO pcmpracticeexperiencedto) {
        PcmPracticeExperience domain = pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedto);
        domain.setPcmprofileid(pcmprofile_id);
		pcmpracticeexperienceService.create(domain);
        PcmPracticeExperienceDTO dto = pcmpracticeexperienceMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceMapping.toDomain(#pcmpracticeexperiencedtos),'ehr-PcmPracticeExperience-Create')")
    @ApiOperation(value = "根据应聘者基本信息批量建立实习经验", tags = {"实习经验" },  notes = "根据应聘者基本信息批量建立实习经验")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/batch")
    public ResponseEntity<Boolean> createBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmPracticeExperienceDTO> pcmpracticeexperiencedtos) {
        List<PcmPracticeExperience> domainlist=pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedtos);
        for(PcmPracticeExperience domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmpracticeexperienceService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceService.get(#pcmpracticeexperience_id),'ehr-PcmPracticeExperience-Update')")
    @ApiOperation(value = "根据应聘者基本信息更新实习经验", tags = {"实习经验" },  notes = "根据应聘者基本信息更新实习经验")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/{pcmpracticeexperience_id}")
    @Transactional
    public ResponseEntity<PcmPracticeExperienceDTO> updateByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmpracticeexperience_id") String pcmpracticeexperience_id, @RequestBody PcmPracticeExperienceDTO pcmpracticeexperiencedto) {
        PcmPracticeExperience domain = pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedto);
        domain.setPcmprofileid(pcmprofile_id);
        domain.setPcmpracticeexperienceid(pcmpracticeexperience_id);
		pcmpracticeexperienceService.update(domain);
        PcmPracticeExperienceDTO dto = pcmpracticeexperienceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceService.getPcmpracticeexperienceByEntities(this.pcmpracticeexperienceMapping.toDomain(#pcmpracticeexperiencedtos)),'ehr-PcmPracticeExperience-Update')")
    @ApiOperation(value = "根据应聘者基本信息批量更新实习经验", tags = {"实习经验" },  notes = "根据应聘者基本信息批量更新实习经验")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/batch")
    public ResponseEntity<Boolean> updateBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmPracticeExperienceDTO> pcmpracticeexperiencedtos) {
        List<PcmPracticeExperience> domainlist=pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedtos);
        for(PcmPracticeExperience domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmpracticeexperienceService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据应聘者基本信息获取实习经验草稿", tags = {"实习经验" },  notes = "根据应聘者基本信息获取实习经验草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/getdraft")
    public ResponseEntity<PcmPracticeExperienceDTO> getDraftByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id) {
        PcmPracticeExperience domain = new PcmPracticeExperience();
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmpracticeexperienceMapping.toDto(pcmpracticeexperienceService.getDraft(domain)));
    }

    @PostAuthorize("hasPermission(this.pcmpracticeexperienceMapping.toDomain(returnObject.body),'ehr-PcmPracticeExperience-Get')")
    @ApiOperation(value = "根据应聘者基本信息获取实习经验", tags = {"实习经验" },  notes = "根据应聘者基本信息获取实习经验")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/{pcmpracticeexperience_id}")
    public ResponseEntity<PcmPracticeExperienceDTO> getByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmpracticeexperience_id") String pcmpracticeexperience_id) {
        PcmPracticeExperience domain = pcmpracticeexperienceService.get(pcmpracticeexperience_id);
        PcmPracticeExperienceDTO dto = pcmpracticeexperienceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据应聘者基本信息检查实习经验", tags = {"实习经验" },  notes = "根据应聘者基本信息检查实习经验")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/checkkey")
    public ResponseEntity<Boolean> checkKeyByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmPracticeExperienceDTO pcmpracticeexperiencedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmpracticeexperienceService.checkKey(pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedto)));
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceMapping.toDomain(#pcmpracticeexperiencedto),'ehr-PcmPracticeExperience-Save')")
    @ApiOperation(value = "根据应聘者基本信息保存实习经验", tags = {"实习经验" },  notes = "根据应聘者基本信息保存实习经验")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/save")
    public ResponseEntity<Boolean> saveByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmPracticeExperienceDTO pcmpracticeexperiencedto) {
        PcmPracticeExperience domain = pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedto);
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmpracticeexperienceService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceMapping.toDomain(#pcmpracticeexperiencedtos),'ehr-PcmPracticeExperience-Save')")
    @ApiOperation(value = "根据应聘者基本信息批量保存实习经验", tags = {"实习经验" },  notes = "根据应聘者基本信息批量保存实习经验")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/savebatch")
    public ResponseEntity<Boolean> saveBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmPracticeExperienceDTO> pcmpracticeexperiencedtos) {
        List<PcmPracticeExperience> domainlist=pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedtos);
        for(PcmPracticeExperience domain:domainlist){
             domain.setPcmprofileid(pcmprofile_id);
        }
        pcmpracticeexperienceService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmPracticeExperience-Default-all')")
	@ApiOperation(value = "根据应聘者基本信息获取DEFAULT", tags = {"实习经验" } ,notes = "根据应聘者基本信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/fetchdefault")
	public ResponseEntity<List<PcmPracticeExperienceDTO>> fetchPcmPracticeExperienceDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id,PcmPracticeExperienceSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PcmPracticeExperience> domains = pcmpracticeexperienceService.searchDefault(context) ;
        List<PcmPracticeExperienceDTO> list = pcmpracticeexperienceMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmPracticeExperience-Default-all')")
	@ApiOperation(value = "根据应聘者基本信息查询DEFAULT", tags = {"实习经验" } ,notes = "根据应聘者基本信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/searchdefault")
	public ResponseEntity<Page<PcmPracticeExperienceDTO>> searchPcmPracticeExperienceDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmPracticeExperienceSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PcmPracticeExperience> domains = pcmpracticeexperienceService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmpracticeexperienceMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

