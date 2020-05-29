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
import cn.ibizlab.ehr.core.pcm.domain.PCMPRACTICEEXPERIENCE;
import cn.ibizlab.ehr.core.pcm.service.IPCMPRACTICEEXPERIENCEService;
import cn.ibizlab.ehr.core.pcm.filter.PCMPRACTICEEXPERIENCESearchContext;

@Slf4j
@Api(tags = {"实习经验" })
@RestController("WebApi-pcmpracticeexperience")
@RequestMapping("")
public class PCMPRACTICEEXPERIENCEResource {

    @Autowired
    public IPCMPRACTICEEXPERIENCEService pcmpracticeexperienceService;

    @Autowired
    @Lazy
    public PCMPRACTICEEXPERIENCEMapping pcmpracticeexperienceMapping;

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceService.get(#pcmpracticeexperience_id),'ehr-PCMPRACTICEEXPERIENCE-Remove')")
    @ApiOperation(value = "删除实习经验", tags = {"实习经验" },  notes = "删除实习经验")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmpracticeexperiences/{pcmpracticeexperience_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmpracticeexperience_id") String pcmpracticeexperience_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmpracticeexperienceService.remove(pcmpracticeexperience_id));
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceService.getPcmpracticeexperienceByIds(#ids),'ehr-PCMPRACTICEEXPERIENCE-Remove')")
    @ApiOperation(value = "批量删除实习经验", tags = {"实习经验" },  notes = "批量删除实习经验")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmpracticeexperiences/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmpracticeexperienceService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceMapping.toDomain(#pcmpracticeexperiencedto),'ehr-PCMPRACTICEEXPERIENCE-Create')")
    @ApiOperation(value = "新建实习经验", tags = {"实习经验" },  notes = "新建实习经验")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmpracticeexperiences")
    @Transactional
    public ResponseEntity<PCMPRACTICEEXPERIENCEDTO> create(@RequestBody PCMPRACTICEEXPERIENCEDTO pcmpracticeexperiencedto) {
        PCMPRACTICEEXPERIENCE domain = pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedto);
		pcmpracticeexperienceService.create(domain);
        PCMPRACTICEEXPERIENCEDTO dto = pcmpracticeexperienceMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceMapping.toDomain(#pcmpracticeexperiencedtos),'ehr-PCMPRACTICEEXPERIENCE-Create')")
    @ApiOperation(value = "批量新建实习经验", tags = {"实习经验" },  notes = "批量新建实习经验")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmpracticeexperiences/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMPRACTICEEXPERIENCEDTO> pcmpracticeexperiencedtos) {
        pcmpracticeexperienceService.createBatch(pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceService.get(#pcmpracticeexperience_id),'ehr-PCMPRACTICEEXPERIENCE-Update')")
    @ApiOperation(value = "更新实习经验", tags = {"实习经验" },  notes = "更新实习经验")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmpracticeexperiences/{pcmpracticeexperience_id}")
    @Transactional
    public ResponseEntity<PCMPRACTICEEXPERIENCEDTO> update(@PathVariable("pcmpracticeexperience_id") String pcmpracticeexperience_id, @RequestBody PCMPRACTICEEXPERIENCEDTO pcmpracticeexperiencedto) {
		PCMPRACTICEEXPERIENCE domain  = pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedto);
        domain .setPcmpracticeexperienceid(pcmpracticeexperience_id);
		pcmpracticeexperienceService.update(domain );
		PCMPRACTICEEXPERIENCEDTO dto = pcmpracticeexperienceMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceService.getPcmpracticeexperienceByEntities(this.pcmpracticeexperienceMapping.toDomain(#pcmpracticeexperiencedtos)),'ehr-PCMPRACTICEEXPERIENCE-Update')")
    @ApiOperation(value = "批量更新实习经验", tags = {"实习经验" },  notes = "批量更新实习经验")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmpracticeexperiences/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMPRACTICEEXPERIENCEDTO> pcmpracticeexperiencedtos) {
        pcmpracticeexperienceService.updateBatch(pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取实习经验草稿", tags = {"实习经验" },  notes = "获取实习经验草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmpracticeexperiences/getdraft")
    public ResponseEntity<PCMPRACTICEEXPERIENCEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmpracticeexperienceMapping.toDto(pcmpracticeexperienceService.getDraft(new PCMPRACTICEEXPERIENCE())));
    }

    @PostAuthorize("hasPermission(this.pcmpracticeexperienceMapping.toDomain(returnObject.body),'ehr-PCMPRACTICEEXPERIENCE-Get')")
    @ApiOperation(value = "获取实习经验", tags = {"实习经验" },  notes = "获取实习经验")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmpracticeexperiences/{pcmpracticeexperience_id}")
    public ResponseEntity<PCMPRACTICEEXPERIENCEDTO> get(@PathVariable("pcmpracticeexperience_id") String pcmpracticeexperience_id) {
        PCMPRACTICEEXPERIENCE domain = pcmpracticeexperienceService.get(pcmpracticeexperience_id);
        PCMPRACTICEEXPERIENCEDTO dto = pcmpracticeexperienceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "检查实习经验", tags = {"实习经验" },  notes = "检查实习经验")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmpracticeexperiences/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMPRACTICEEXPERIENCEDTO pcmpracticeexperiencedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmpracticeexperienceService.checkKey(pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedto)));
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceMapping.toDomain(#pcmpracticeexperiencedto),'ehr-PCMPRACTICEEXPERIENCE-Save')")
    @ApiOperation(value = "保存实习经验", tags = {"实习经验" },  notes = "保存实习经验")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmpracticeexperiences/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMPRACTICEEXPERIENCEDTO pcmpracticeexperiencedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmpracticeexperienceService.save(pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedto)));
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceMapping.toDomain(#pcmpracticeexperiencedtos),'ehr-PCMPRACTICEEXPERIENCE-Save')")
    @ApiOperation(value = "批量保存实习经验", tags = {"实习经验" },  notes = "批量保存实习经验")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmpracticeexperiences/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMPRACTICEEXPERIENCEDTO> pcmpracticeexperiencedtos) {
        pcmpracticeexperienceService.saveBatch(pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPRACTICEEXPERIENCE-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"实习经验" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmpracticeexperiences/fetchdefault")
	public ResponseEntity<List<PCMPRACTICEEXPERIENCEDTO>> fetchDefault(PCMPRACTICEEXPERIENCESearchContext context) {
        Page<PCMPRACTICEEXPERIENCE> domains = pcmpracticeexperienceService.searchDefault(context) ;
        List<PCMPRACTICEEXPERIENCEDTO> list = pcmpracticeexperienceMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPRACTICEEXPERIENCE-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"实习经验" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmpracticeexperiences/searchdefault")
	public ResponseEntity<Page<PCMPRACTICEEXPERIENCEDTO>> searchDefault(@RequestBody PCMPRACTICEEXPERIENCESearchContext context) {
        Page<PCMPRACTICEEXPERIENCE> domains = pcmpracticeexperienceService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmpracticeexperienceMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pcmpracticeexperienceService.get(#pcmpracticeexperience_id),'ehr-PCMPRACTICEEXPERIENCE-Remove')")
    @ApiOperation(value = "根据应聘者基本信息删除实习经验", tags = {"实习经验" },  notes = "根据应聘者基本信息删除实习经验")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/{pcmpracticeexperience_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmpracticeexperience_id") String pcmpracticeexperience_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmpracticeexperienceService.remove(pcmpracticeexperience_id));
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceService.getPcmpracticeexperienceByIds(#ids),'ehr-PCMPRACTICEEXPERIENCE-Remove')")
    @ApiOperation(value = "根据应聘者基本信息批量删除实习经验", tags = {"实习经验" },  notes = "根据应聘者基本信息批量删除实习经验")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/batch")
    public ResponseEntity<Boolean> removeBatchByPcmProfile(@RequestBody List<String> ids) {
        pcmpracticeexperienceService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceMapping.toDomain(#pcmpracticeexperiencedto),'ehr-PCMPRACTICEEXPERIENCE-Create')")
    @ApiOperation(value = "根据应聘者基本信息建立实习经验", tags = {"实习经验" },  notes = "根据应聘者基本信息建立实习经验")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences")
    @Transactional
    public ResponseEntity<PCMPRACTICEEXPERIENCEDTO> createByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPRACTICEEXPERIENCEDTO pcmpracticeexperiencedto) {
        PCMPRACTICEEXPERIENCE domain = pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedto);
        domain.setPcmprofileid(pcmprofile_id);
		pcmpracticeexperienceService.create(domain);
        PCMPRACTICEEXPERIENCEDTO dto = pcmpracticeexperienceMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceMapping.toDomain(#pcmpracticeexperiencedtos),'ehr-PCMPRACTICEEXPERIENCE-Create')")
    @ApiOperation(value = "根据应聘者基本信息批量建立实习经验", tags = {"实习经验" },  notes = "根据应聘者基本信息批量建立实习经验")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/batch")
    public ResponseEntity<Boolean> createBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMPRACTICEEXPERIENCEDTO> pcmpracticeexperiencedtos) {
        List<PCMPRACTICEEXPERIENCE> domainlist=pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedtos);
        for(PCMPRACTICEEXPERIENCE domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmpracticeexperienceService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceService.get(#pcmpracticeexperience_id),'ehr-PCMPRACTICEEXPERIENCE-Update')")
    @ApiOperation(value = "根据应聘者基本信息更新实习经验", tags = {"实习经验" },  notes = "根据应聘者基本信息更新实习经验")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/{pcmpracticeexperience_id}")
    @Transactional
    public ResponseEntity<PCMPRACTICEEXPERIENCEDTO> updateByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmpracticeexperience_id") String pcmpracticeexperience_id, @RequestBody PCMPRACTICEEXPERIENCEDTO pcmpracticeexperiencedto) {
        PCMPRACTICEEXPERIENCE domain = pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedto);
        domain.setPcmprofileid(pcmprofile_id);
        domain.setPcmpracticeexperienceid(pcmpracticeexperience_id);
		pcmpracticeexperienceService.update(domain);
        PCMPRACTICEEXPERIENCEDTO dto = pcmpracticeexperienceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceService.getPcmpracticeexperienceByEntities(this.pcmpracticeexperienceMapping.toDomain(#pcmpracticeexperiencedtos)),'ehr-PCMPRACTICEEXPERIENCE-Update')")
    @ApiOperation(value = "根据应聘者基本信息批量更新实习经验", tags = {"实习经验" },  notes = "根据应聘者基本信息批量更新实习经验")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/batch")
    public ResponseEntity<Boolean> updateBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMPRACTICEEXPERIENCEDTO> pcmpracticeexperiencedtos) {
        List<PCMPRACTICEEXPERIENCE> domainlist=pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedtos);
        for(PCMPRACTICEEXPERIENCE domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmpracticeexperienceService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据应聘者基本信息获取实习经验草稿", tags = {"实习经验" },  notes = "根据应聘者基本信息获取实习经验草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/getdraft")
    public ResponseEntity<PCMPRACTICEEXPERIENCEDTO> getDraftByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id) {
        PCMPRACTICEEXPERIENCE domain = new PCMPRACTICEEXPERIENCE();
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmpracticeexperienceMapping.toDto(pcmpracticeexperienceService.getDraft(domain)));
    }

    @PostAuthorize("hasPermission(this.pcmpracticeexperienceMapping.toDomain(returnObject.body),'ehr-PCMPRACTICEEXPERIENCE-Get')")
    @ApiOperation(value = "根据应聘者基本信息获取实习经验", tags = {"实习经验" },  notes = "根据应聘者基本信息获取实习经验")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/{pcmpracticeexperience_id}")
    public ResponseEntity<PCMPRACTICEEXPERIENCEDTO> getByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmpracticeexperience_id") String pcmpracticeexperience_id) {
        PCMPRACTICEEXPERIENCE domain = pcmpracticeexperienceService.get(pcmpracticeexperience_id);
        PCMPRACTICEEXPERIENCEDTO dto = pcmpracticeexperienceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "根据应聘者基本信息检查实习经验", tags = {"实习经验" },  notes = "根据应聘者基本信息检查实习经验")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/checkkey")
    public ResponseEntity<Boolean> checkKeyByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPRACTICEEXPERIENCEDTO pcmpracticeexperiencedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmpracticeexperienceService.checkKey(pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedto)));
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceMapping.toDomain(#pcmpracticeexperiencedto),'ehr-PCMPRACTICEEXPERIENCE-Save')")
    @ApiOperation(value = "根据应聘者基本信息保存实习经验", tags = {"实习经验" },  notes = "根据应聘者基本信息保存实习经验")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/save")
    public ResponseEntity<Boolean> saveByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPRACTICEEXPERIENCEDTO pcmpracticeexperiencedto) {
        PCMPRACTICEEXPERIENCE domain = pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedto);
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmpracticeexperienceService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmpracticeexperienceMapping.toDomain(#pcmpracticeexperiencedtos),'ehr-PCMPRACTICEEXPERIENCE-Save')")
    @ApiOperation(value = "根据应聘者基本信息批量保存实习经验", tags = {"实习经验" },  notes = "根据应聘者基本信息批量保存实习经验")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/savebatch")
    public ResponseEntity<Boolean> saveBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMPRACTICEEXPERIENCEDTO> pcmpracticeexperiencedtos) {
        List<PCMPRACTICEEXPERIENCE> domainlist=pcmpracticeexperienceMapping.toDomain(pcmpracticeexperiencedtos);
        for(PCMPRACTICEEXPERIENCE domain:domainlist){
             domain.setPcmprofileid(pcmprofile_id);
        }
        pcmpracticeexperienceService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPRACTICEEXPERIENCE-Default-all')")
	@ApiOperation(value = "根据应聘者基本信息获取DEFAULT", tags = {"实习经验" } ,notes = "根据应聘者基本信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/fetchdefault")
	public ResponseEntity<List<PCMPRACTICEEXPERIENCEDTO>> fetchPCMPRACTICEEXPERIENCEDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id,PCMPRACTICEEXPERIENCESearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PCMPRACTICEEXPERIENCE> domains = pcmpracticeexperienceService.searchDefault(context) ;
        List<PCMPRACTICEEXPERIENCEDTO> list = pcmpracticeexperienceMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPRACTICEEXPERIENCE-Default-all')")
	@ApiOperation(value = "根据应聘者基本信息查询DEFAULT", tags = {"实习经验" } ,notes = "根据应聘者基本信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/{pcmprofile_id}/pcmpracticeexperiences/searchdefault")
	public ResponseEntity<Page<PCMPRACTICEEXPERIENCEDTO>> searchPCMPRACTICEEXPERIENCEDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMPRACTICEEXPERIENCESearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PCMPRACTICEEXPERIENCE> domains = pcmpracticeexperienceService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmpracticeexperienceMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

