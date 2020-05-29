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
import cn.ibizlab.ehr.core.pcm.domain.PcmEducationExperience;
import cn.ibizlab.ehr.core.pcm.service.IPcmEducationExperienceService;
import cn.ibizlab.ehr.core.pcm.filter.PcmEducationExperienceSearchContext;

@Slf4j
@Api(tags = {"PcmEducationExperience" })
@RestController("WebApi-pcmeducationexperience")
@RequestMapping("")
public class PcmEducationExperienceResource {

    @Autowired
    public IPcmEducationExperienceService pcmeducationexperienceService;

    @Autowired
    @Lazy
    public PcmEducationExperienceMapping pcmeducationexperienceMapping;

    @ApiOperation(value = "CheckKey", tags = {"PcmEducationExperience" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmeducationexperiences/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmEducationExperienceDTO pcmeducationexperiencedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperienceService.checkKey(pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto)));
    }

    @PostAuthorize("hasPermission(this.pcmeducationexperienceMapping.toDomain(returnObject.body),'ehr-PcmEducationExperience-Get')")
    @ApiOperation(value = "Get", tags = {"PcmEducationExperience" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmeducationexperiences/{pcmeducationexperience_id}")
    public ResponseEntity<PcmEducationExperienceDTO> get(@PathVariable("pcmeducationexperience_id") String pcmeducationexperience_id) {
        PcmEducationExperience domain = pcmeducationexperienceService.get(pcmeducationexperience_id);
        PcmEducationExperienceDTO dto = pcmeducationexperienceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmEducationExperience-CheckHighestEdu-all')")
    @ApiOperation(value = "检查第一学历、最高学历", tags = {"PcmEducationExperience" },  notes = "检查第一学历、最高学历")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmeducationexperiences/{pcmeducationexperience_id}/checkhighestedu")
    @Transactional
    public ResponseEntity<PcmEducationExperienceDTO> checkHighestEdu(@PathVariable("pcmeducationexperience_id") String pcmeducationexperience_id, @RequestBody PcmEducationExperienceDTO pcmeducationexperiencedto) {
        PcmEducationExperience pcmeducationexperience = pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto);
        pcmeducationexperience.setPcmeducationexperienceid(pcmeducationexperience_id);
        pcmeducationexperience = pcmeducationexperienceService.checkHighestEdu(pcmeducationexperience);
        pcmeducationexperiencedto = pcmeducationexperienceMapping.toDto(pcmeducationexperience);
        return ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperiencedto);
    }

    @PreAuthorize("hasPermission(this.pcmeducationexperienceMapping.toDomain(#pcmeducationexperiencedto),'ehr-PcmEducationExperience-Create')")
    @ApiOperation(value = "Create", tags = {"PcmEducationExperience" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmeducationexperiences")
    @Transactional
    public ResponseEntity<PcmEducationExperienceDTO> create(@RequestBody PcmEducationExperienceDTO pcmeducationexperiencedto) {
        PcmEducationExperience domain = pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto);
		pcmeducationexperienceService.create(domain);
        PcmEducationExperienceDTO dto = pcmeducationexperienceMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmeducationexperienceMapping.toDomain(#pcmeducationexperiencedtos),'ehr-PcmEducationExperience-Create')")
    @ApiOperation(value = "createBatch", tags = {"PcmEducationExperience" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmeducationexperiences/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmEducationExperienceDTO> pcmeducationexperiencedtos) {
        pcmeducationexperienceService.createBatch(pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmEducationExperience-CheckRepeatXL-all')")
    @ApiOperation(value = "检查学历是否重复", tags = {"PcmEducationExperience" },  notes = "检查学历是否重复")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmeducationexperiences/{pcmeducationexperience_id}/checkrepeatxl")
    @Transactional
    public ResponseEntity<PcmEducationExperienceDTO> checkRepeatXL(@PathVariable("pcmeducationexperience_id") String pcmeducationexperience_id, @RequestBody PcmEducationExperienceDTO pcmeducationexperiencedto) {
        PcmEducationExperience pcmeducationexperience = pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto);
        pcmeducationexperience.setPcmeducationexperienceid(pcmeducationexperience_id);
        pcmeducationexperience = pcmeducationexperienceService.checkRepeatXL(pcmeducationexperience);
        pcmeducationexperiencedto = pcmeducationexperienceMapping.toDto(pcmeducationexperience);
        return ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperiencedto);
    }

    @PreAuthorize("hasPermission(this.pcmeducationexperienceMapping.toDomain(#pcmeducationexperiencedto),'ehr-PcmEducationExperience-Save')")
    @ApiOperation(value = "Save", tags = {"PcmEducationExperience" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmeducationexperiences/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmEducationExperienceDTO pcmeducationexperiencedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperienceService.save(pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto)));
    }

    @PreAuthorize("hasPermission(this.pcmeducationexperienceMapping.toDomain(#pcmeducationexperiencedtos),'ehr-PcmEducationExperience-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PcmEducationExperience" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmeducationexperiences/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmEducationExperienceDTO> pcmeducationexperiencedtos) {
        pcmeducationexperienceService.saveBatch(pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PcmEducationExperience" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmeducationexperiences/getdraft")
    public ResponseEntity<PcmEducationExperienceDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperienceMapping.toDto(pcmeducationexperienceService.getDraft(new PcmEducationExperience())));
    }

    @PreAuthorize("hasPermission(this.pcmeducationexperienceService.get(#pcmeducationexperience_id),'ehr-PcmEducationExperience-Remove')")
    @ApiOperation(value = "Remove", tags = {"PcmEducationExperience" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmeducationexperiences/{pcmeducationexperience_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmeducationexperience_id") String pcmeducationexperience_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperienceService.remove(pcmeducationexperience_id));
    }

    @PreAuthorize("hasPermission(this.pcmeducationexperienceService.getPcmeducationexperienceByIds(#ids),'ehr-PcmEducationExperience-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PcmEducationExperience" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmeducationexperiences/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmeducationexperienceService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmeducationexperienceService.get(#pcmeducationexperience_id),'ehr-PcmEducationExperience-Update')")
    @ApiOperation(value = "Update", tags = {"PcmEducationExperience" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmeducationexperiences/{pcmeducationexperience_id}")
    @Transactional
    public ResponseEntity<PcmEducationExperienceDTO> update(@PathVariable("pcmeducationexperience_id") String pcmeducationexperience_id, @RequestBody PcmEducationExperienceDTO pcmeducationexperiencedto) {
		PcmEducationExperience domain  = pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto);
        domain .setPcmeducationexperienceid(pcmeducationexperience_id);
		pcmeducationexperienceService.update(domain );
		PcmEducationExperienceDTO dto = pcmeducationexperienceMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmeducationexperienceService.getPcmeducationexperienceByEntities(this.pcmeducationexperienceMapping.toDomain(#pcmeducationexperiencedtos)),'ehr-PcmEducationExperience-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PcmEducationExperience" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmeducationexperiences/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmEducationExperienceDTO> pcmeducationexperiencedtos) {
        pcmeducationexperienceService.updateBatch(pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmEducationExperience-CheckTime-all')")
    @ApiOperation(value = "校验入学、毕业时间", tags = {"PcmEducationExperience" },  notes = "校验入学、毕业时间")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmeducationexperiences/{pcmeducationexperience_id}/checktime")
    @Transactional
    public ResponseEntity<PcmEducationExperienceDTO> checkTime(@PathVariable("pcmeducationexperience_id") String pcmeducationexperience_id, @RequestBody PcmEducationExperienceDTO pcmeducationexperiencedto) {
        PcmEducationExperience pcmeducationexperience = pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto);
        pcmeducationexperience.setPcmeducationexperienceid(pcmeducationexperience_id);
        pcmeducationexperience = pcmeducationexperienceService.checkTime(pcmeducationexperience);
        pcmeducationexperiencedto = pcmeducationexperienceMapping.toDto(pcmeducationexperience);
        return ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperiencedto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmEducationExperience-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PcmEducationExperience" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmeducationexperiences/fetchdefault")
	public ResponseEntity<List<PcmEducationExperienceDTO>> fetchDefault(PcmEducationExperienceSearchContext context) {
        Page<PcmEducationExperience> domains = pcmeducationexperienceService.searchDefault(context) ;
        List<PcmEducationExperienceDTO> list = pcmeducationexperienceMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmEducationExperience-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PcmEducationExperience" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmeducationexperiences/searchdefault")
	public ResponseEntity<Page<PcmEducationExperienceDTO>> searchDefault(@RequestBody PcmEducationExperienceSearchContext context) {
        Page<PcmEducationExperience> domains = pcmeducationexperienceService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmeducationexperienceMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "CheckKeyByPcmProfile", tags = {"PcmEducationExperience" },  notes = "CheckKeyByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/checkkey")
    public ResponseEntity<Boolean> checkKeyByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmEducationExperienceDTO pcmeducationexperiencedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperienceService.checkKey(pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto)));
    }

    @PostAuthorize("hasPermission(this.pcmeducationexperienceMapping.toDomain(returnObject.body),'ehr-PcmEducationExperience-Get')")
    @ApiOperation(value = "GetByPcmProfile", tags = {"PcmEducationExperience" },  notes = "GetByPcmProfile")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/{pcmeducationexperience_id}")
    public ResponseEntity<PcmEducationExperienceDTO> getByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmeducationexperience_id") String pcmeducationexperience_id) {
        PcmEducationExperience domain = pcmeducationexperienceService.get(pcmeducationexperience_id);
        PcmEducationExperienceDTO dto = pcmeducationexperienceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmEducationExperience-CheckHighestEdu-all')")
    @ApiOperation(value = "检查第一学历、最高学历ByPcmProfile", tags = {"PcmEducationExperience" },  notes = "检查第一学历、最高学历ByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/{pcmeducationexperience_id}/checkhighestedu")
    @Transactional
    public ResponseEntity<PcmEducationExperienceDTO> checkHighestEduByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmeducationexperience_id") String pcmeducationexperience_id, @RequestBody PcmEducationExperienceDTO pcmeducationexperiencedto) {
        PcmEducationExperience domain = pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto);
        domain.setPcmprofileid(pcmprofile_id);
        domain = pcmeducationexperienceService.checkHighestEdu(domain) ;
        pcmeducationexperiencedto = pcmeducationexperienceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperiencedto);
    }

    @PreAuthorize("hasPermission(this.pcmeducationexperienceMapping.toDomain(#pcmeducationexperiencedto),'ehr-PcmEducationExperience-Create')")
    @ApiOperation(value = "CreateByPcmProfile", tags = {"PcmEducationExperience" },  notes = "CreateByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences")
    @Transactional
    public ResponseEntity<PcmEducationExperienceDTO> createByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmEducationExperienceDTO pcmeducationexperiencedto) {
        PcmEducationExperience domain = pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto);
        domain.setPcmprofileid(pcmprofile_id);
		pcmeducationexperienceService.create(domain);
        PcmEducationExperienceDTO dto = pcmeducationexperienceMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmeducationexperienceMapping.toDomain(#pcmeducationexperiencedtos),'ehr-PcmEducationExperience-Create')")
    @ApiOperation(value = "createBatchByPcmProfile", tags = {"PcmEducationExperience" },  notes = "createBatchByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/batch")
    public ResponseEntity<Boolean> createBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmEducationExperienceDTO> pcmeducationexperiencedtos) {
        List<PcmEducationExperience> domainlist=pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedtos);
        for(PcmEducationExperience domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmeducationexperienceService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmEducationExperience-CheckRepeatXL-all')")
    @ApiOperation(value = "检查学历是否重复ByPcmProfile", tags = {"PcmEducationExperience" },  notes = "检查学历是否重复ByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/{pcmeducationexperience_id}/checkrepeatxl")
    @Transactional
    public ResponseEntity<PcmEducationExperienceDTO> checkRepeatXLByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmeducationexperience_id") String pcmeducationexperience_id, @RequestBody PcmEducationExperienceDTO pcmeducationexperiencedto) {
        PcmEducationExperience domain = pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto);
        domain.setPcmprofileid(pcmprofile_id);
        domain = pcmeducationexperienceService.checkRepeatXL(domain) ;
        pcmeducationexperiencedto = pcmeducationexperienceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperiencedto);
    }

    @PreAuthorize("hasPermission(this.pcmeducationexperienceMapping.toDomain(#pcmeducationexperiencedto),'ehr-PcmEducationExperience-Save')")
    @ApiOperation(value = "SaveByPcmProfile", tags = {"PcmEducationExperience" },  notes = "SaveByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/save")
    public ResponseEntity<Boolean> saveByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmEducationExperienceDTO pcmeducationexperiencedto) {
        PcmEducationExperience domain = pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto);
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperienceService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmeducationexperienceMapping.toDomain(#pcmeducationexperiencedtos),'ehr-PcmEducationExperience-Save')")
    @ApiOperation(value = "SaveBatchByPcmProfile", tags = {"PcmEducationExperience" },  notes = "SaveBatchByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/savebatch")
    public ResponseEntity<Boolean> saveBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmEducationExperienceDTO> pcmeducationexperiencedtos) {
        List<PcmEducationExperience> domainlist=pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedtos);
        for(PcmEducationExperience domain:domainlist){
             domain.setPcmprofileid(pcmprofile_id);
        }
        pcmeducationexperienceService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPcmProfile", tags = {"PcmEducationExperience" },  notes = "GetDraftByPcmProfile")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/getdraft")
    public ResponseEntity<PcmEducationExperienceDTO> getDraftByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id) {
        PcmEducationExperience domain = new PcmEducationExperience();
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperienceMapping.toDto(pcmeducationexperienceService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmeducationexperienceService.get(#pcmeducationexperience_id),'ehr-PcmEducationExperience-Remove')")
    @ApiOperation(value = "RemoveByPcmProfile", tags = {"PcmEducationExperience" },  notes = "RemoveByPcmProfile")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/{pcmeducationexperience_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmeducationexperience_id") String pcmeducationexperience_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperienceService.remove(pcmeducationexperience_id));
    }

    @PreAuthorize("hasPermission(this.pcmeducationexperienceService.getPcmeducationexperienceByIds(#ids),'ehr-PcmEducationExperience-Remove')")
    @ApiOperation(value = "RemoveBatchByPcmProfile", tags = {"PcmEducationExperience" },  notes = "RemoveBatchByPcmProfile")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/batch")
    public ResponseEntity<Boolean> removeBatchByPcmProfile(@RequestBody List<String> ids) {
        pcmeducationexperienceService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmeducationexperienceService.get(#pcmeducationexperience_id),'ehr-PcmEducationExperience-Update')")
    @ApiOperation(value = "UpdateByPcmProfile", tags = {"PcmEducationExperience" },  notes = "UpdateByPcmProfile")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/{pcmeducationexperience_id}")
    @Transactional
    public ResponseEntity<PcmEducationExperienceDTO> updateByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmeducationexperience_id") String pcmeducationexperience_id, @RequestBody PcmEducationExperienceDTO pcmeducationexperiencedto) {
        PcmEducationExperience domain = pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto);
        domain.setPcmprofileid(pcmprofile_id);
        domain.setPcmeducationexperienceid(pcmeducationexperience_id);
		pcmeducationexperienceService.update(domain);
        PcmEducationExperienceDTO dto = pcmeducationexperienceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmeducationexperienceService.getPcmeducationexperienceByEntities(this.pcmeducationexperienceMapping.toDomain(#pcmeducationexperiencedtos)),'ehr-PcmEducationExperience-Update')")
    @ApiOperation(value = "UpdateBatchByPcmProfile", tags = {"PcmEducationExperience" },  notes = "UpdateBatchByPcmProfile")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/batch")
    public ResponseEntity<Boolean> updateBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmEducationExperienceDTO> pcmeducationexperiencedtos) {
        List<PcmEducationExperience> domainlist=pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedtos);
        for(PcmEducationExperience domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmeducationexperienceService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmEducationExperience-CheckTime-all')")
    @ApiOperation(value = "校验入学、毕业时间ByPcmProfile", tags = {"PcmEducationExperience" },  notes = "校验入学、毕业时间ByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/{pcmeducationexperience_id}/checktime")
    @Transactional
    public ResponseEntity<PcmEducationExperienceDTO> checkTimeByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmeducationexperience_id") String pcmeducationexperience_id, @RequestBody PcmEducationExperienceDTO pcmeducationexperiencedto) {
        PcmEducationExperience domain = pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto);
        domain.setPcmprofileid(pcmprofile_id);
        domain = pcmeducationexperienceService.checkTime(domain) ;
        pcmeducationexperiencedto = pcmeducationexperienceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperiencedto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmEducationExperience-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPcmProfile", tags = {"PcmEducationExperience" } ,notes = "fetchDEFAULTByPcmProfile")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/fetchdefault")
	public ResponseEntity<List<PcmEducationExperienceDTO>> fetchPcmEducationExperienceDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id,PcmEducationExperienceSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PcmEducationExperience> domains = pcmeducationexperienceService.searchDefault(context) ;
        List<PcmEducationExperienceDTO> list = pcmeducationexperienceMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmEducationExperience-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPcmProfile", tags = {"PcmEducationExperience" } ,notes = "searchDEFAULTByPcmProfile")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/searchdefault")
	public ResponseEntity<Page<PcmEducationExperienceDTO>> searchPcmEducationExperienceDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmEducationExperienceSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PcmEducationExperience> domains = pcmeducationexperienceService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmeducationexperienceMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

