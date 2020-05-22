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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import cn.ibizlab.ehr.webapi.dto.*;
import cn.ibizlab.ehr.webapi.mapping.*;
import cn.ibizlab.ehr.core.pcm.domain.PCMEducationExperience;
import cn.ibizlab.ehr.core.pcm.service.IPCMEducationExperienceService;
import cn.ibizlab.ehr.core.pcm.filter.PCMEducationExperienceSearchContext;




@Slf4j
@Api(tags = {"PCMEducationExperience" })
@RestController("WebApi-pcmeducationexperience")
@RequestMapping("")
public class PCMEducationExperienceResource {

    @Autowired
    private IPCMEducationExperienceService pcmeducationexperienceService;

    @Autowired
    @Lazy
    public PCMEducationExperienceMapping pcmeducationexperienceMapping;

    public PCMEducationExperienceDTO permissionDTO=new PCMEducationExperienceDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMEducationExperience-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMEducationExperience" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmeducationexperiences/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMEducationExperienceDTO pcmeducationexperiencedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperienceService.checkKey(pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto)));
    }

    @PreAuthorize("hasPermission(#pcmeducationexperience_id,'Get',{'Sql',this.pcmeducationexperienceMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMEducationExperience" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmeducationexperiences/{pcmeducationexperience_id}")
    public ResponseEntity<PCMEducationExperienceDTO> get(@PathVariable("pcmeducationexperience_id") String pcmeducationexperience_id) {
        PCMEducationExperience domain = pcmeducationexperienceService.get(pcmeducationexperience_id);
        PCMEducationExperienceDTO dto = pcmeducationexperienceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMEducationExperience-CheckHighestEdu-all')")
    @ApiOperation(value = "检查第一学历、最高学历", tags = {"PCMEducationExperience" },  notes = "检查第一学历、最高学历")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmeducationexperiences/{pcmeducationexperience_id}/checkhighestedu")
    @Transactional
    public ResponseEntity<PCMEducationExperienceDTO> checkHighestEdu(@PathVariable("pcmeducationexperience_id") String pcmeducationexperience_id, @RequestBody PCMEducationExperienceDTO pcmeducationexperiencedto) {
        PCMEducationExperience pcmeducationexperience = pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto);
        pcmeducationexperience = pcmeducationexperienceService.checkHighestEdu(pcmeducationexperience);
        pcmeducationexperiencedto = pcmeducationexperienceMapping.toDto(pcmeducationexperience);
        return ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperiencedto);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmeducationexperienceMapping,#pcmeducationexperiencedto})")
    @ApiOperation(value = "Create", tags = {"PCMEducationExperience" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmeducationexperiences")
    @Transactional
    public ResponseEntity<PCMEducationExperienceDTO> create(@RequestBody PCMEducationExperienceDTO pcmeducationexperiencedto) {
        PCMEducationExperience domain = pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto);
		pcmeducationexperienceService.create(domain);
        PCMEducationExperienceDTO dto = pcmeducationexperienceMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PCMEducationExperience" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmeducationexperiences/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMEducationExperienceDTO> pcmeducationexperiencedtos) {
        pcmeducationexperienceService.createBatch(pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMEducationExperience-CheckRepeatXL-all')")
    @ApiOperation(value = "检查学历是否重复", tags = {"PCMEducationExperience" },  notes = "检查学历是否重复")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmeducationexperiences/{pcmeducationexperience_id}/checkrepeatxl")
    @Transactional
    public ResponseEntity<PCMEducationExperienceDTO> checkRepeatXL(@PathVariable("pcmeducationexperience_id") String pcmeducationexperience_id, @RequestBody PCMEducationExperienceDTO pcmeducationexperiencedto) {
        PCMEducationExperience pcmeducationexperience = pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto);
        pcmeducationexperience = pcmeducationexperienceService.checkRepeatXL(pcmeducationexperience);
        pcmeducationexperiencedto = pcmeducationexperienceMapping.toDto(pcmeducationexperience);
        return ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperiencedto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMEducationExperience-Save-all')")
    @ApiOperation(value = "Save", tags = {"PCMEducationExperience" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmeducationexperiences/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMEducationExperienceDTO pcmeducationexperiencedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperienceService.save(pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PCMEducationExperience" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmeducationexperiences/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMEducationExperienceDTO> pcmeducationexperiencedtos) {
        pcmeducationexperienceService.saveBatch(pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMEducationExperience-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMEducationExperience" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmeducationexperiences/getdraft")
    public ResponseEntity<PCMEducationExperienceDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperienceMapping.toDto(pcmeducationexperienceService.getDraft(new PCMEducationExperience())));
    }

    @PreAuthorize("hasPermission(#pcmeducationexperience_id,'Remove',{'Sql',this.pcmeducationexperienceMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMEducationExperience" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmeducationexperiences/{pcmeducationexperience_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmeducationexperience_id") String pcmeducationexperience_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperienceService.remove(pcmeducationexperience_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMEducationExperience" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmeducationexperiences/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmeducationexperienceService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmeducationexperience_id,'Update',{'Sql',this.pcmeducationexperienceMapping,#pcmeducationexperiencedto})")
    @ApiOperation(value = "Update", tags = {"PCMEducationExperience" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmeducationexperiences/{pcmeducationexperience_id}")
    @Transactional
    public ResponseEntity<PCMEducationExperienceDTO> update(@PathVariable("pcmeducationexperience_id") String pcmeducationexperience_id, @RequestBody PCMEducationExperienceDTO pcmeducationexperiencedto) {
		PCMEducationExperience domain = pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto);
        domain.setPcmeducationexperienceid(pcmeducationexperience_id);
		pcmeducationexperienceService.update(domain);
		PCMEducationExperienceDTO dto = pcmeducationexperienceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMEducationExperience" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmeducationexperiences/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMEducationExperienceDTO> pcmeducationexperiencedtos) {
        pcmeducationexperienceService.updateBatch(pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMEducationExperience-CheckTime-all')")
    @ApiOperation(value = "校验入学、毕业时间", tags = {"PCMEducationExperience" },  notes = "校验入学、毕业时间")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmeducationexperiences/{pcmeducationexperience_id}/checktime")
    @Transactional
    public ResponseEntity<PCMEducationExperienceDTO> checkTime(@PathVariable("pcmeducationexperience_id") String pcmeducationexperience_id, @RequestBody PCMEducationExperienceDTO pcmeducationexperiencedto) {
        PCMEducationExperience pcmeducationexperience = pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto);
        pcmeducationexperience = pcmeducationexperienceService.checkTime(pcmeducationexperience);
        pcmeducationexperiencedto = pcmeducationexperienceMapping.toDto(pcmeducationexperience);
        return ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperiencedto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMEducationExperience-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMEducationExperience" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmeducationexperiences/fetchdefault")
	public ResponseEntity<List<PCMEducationExperienceDTO>> fetchDefault(PCMEducationExperienceSearchContext context) {
        Page<PCMEducationExperience> domains = pcmeducationexperienceService.searchDefault(context) ;
        List<PCMEducationExperienceDTO> list = pcmeducationexperienceMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMEducationExperience-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMEducationExperience" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmeducationexperiences/searchdefault")
	public ResponseEntity<Page<PCMEducationExperienceDTO>> searchDefault(@RequestBody PCMEducationExperienceSearchContext context) {
        Page<PCMEducationExperience> domains = pcmeducationexperienceService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmeducationexperienceMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMEducationExperience-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByPCMPROFILE", tags = {"PCMEducationExperience" },  notes = "CheckKeyByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/checkkey")
    public ResponseEntity<Boolean> checkKeyByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMEducationExperienceDTO pcmeducationexperiencedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperienceService.checkKey(pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto)));
    }

    //@PreAuthorize("hasPermission(#pcmeducationexperience_id,'Get',{'Sql',this.pcmeducationexperienceMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByPCMPROFILE", tags = {"PCMEducationExperience" },  notes = "GetByPCMPROFILE")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/{pcmeducationexperience_id}")
    public ResponseEntity<PCMEducationExperienceDTO> getByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmeducationexperience_id") String pcmeducationexperience_id) {
        PCMEducationExperience domain = pcmeducationexperienceService.get(pcmeducationexperience_id);
        PCMEducationExperienceDTO dto = pcmeducationexperienceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMEducationExperience-CheckHighestEdu-all')")
    @ApiOperation(value = "检查第一学历、最高学历ByPCMPROFILE", tags = {"PCMEducationExperience" },  notes = "检查第一学历、最高学历ByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/{pcmeducationexperiencepcmeducationexperienceid}/checkhighestedu")
    @Transactional
    public ResponseEntity<PCMEducationExperienceDTO> checkHighestEduByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmeducationexperience_id") String pcmeducationexperience_id, @RequestBody PCMEducationExperienceDTO pcmeducationexperiencedto) {
        PCMEducationExperience domain = pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto);
        domain.setPcmprofileid(pcmprofile_id);
        domain = pcmeducationexperienceService.checkHighestEdu(domain) ;
        pcmeducationexperiencedto = pcmeducationexperienceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperiencedto);
    }

    //@PreAuthorize("hasPermission('','Create',{'Sql',this.pcmeducationexperienceMapping,#pcmeducationexperiencedto})")
    @ApiOperation(value = "CreateByPCMPROFILE", tags = {"PCMEducationExperience" },  notes = "CreateByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences")
    @Transactional
    public ResponseEntity<PCMEducationExperienceDTO> createByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMEducationExperienceDTO pcmeducationexperiencedto) {
        PCMEducationExperience domain = pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto);
        domain.setPcmprofileid(pcmprofile_id);
		pcmeducationexperienceService.create(domain);
        PCMEducationExperienceDTO dto = pcmeducationexperienceMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatchByPCMPROFILE", tags = {"PCMEducationExperience" },  notes = "createBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/batch")
    public ResponseEntity<Boolean> createBatchByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMEducationExperienceDTO> pcmeducationexperiencedtos) {
        List<PCMEducationExperience> domainlist=pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedtos);
        for(PCMEducationExperience domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmeducationexperienceService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMEducationExperience-CheckRepeatXL-all')")
    @ApiOperation(value = "检查学历是否重复ByPCMPROFILE", tags = {"PCMEducationExperience" },  notes = "检查学历是否重复ByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/{pcmeducationexperiencepcmeducationexperienceid}/checkrepeatxl")
    @Transactional
    public ResponseEntity<PCMEducationExperienceDTO> checkRepeatXLByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmeducationexperience_id") String pcmeducationexperience_id, @RequestBody PCMEducationExperienceDTO pcmeducationexperiencedto) {
        PCMEducationExperience domain = pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto);
        domain.setPcmprofileid(pcmprofile_id);
        domain = pcmeducationexperienceService.checkRepeatXL(domain) ;
        pcmeducationexperiencedto = pcmeducationexperienceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperiencedto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMEducationExperience-Save-all')")
    @ApiOperation(value = "SaveByPCMPROFILE", tags = {"PCMEducationExperience" },  notes = "SaveByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/save")
    public ResponseEntity<Boolean> saveByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMEducationExperienceDTO pcmeducationexperiencedto) {
        PCMEducationExperience domain = pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto);
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperienceService.save(domain));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatchByPCMPROFILE", tags = {"PCMEducationExperience" },  notes = "SaveBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/savebatch")
    public ResponseEntity<Boolean> saveBatchByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMEducationExperienceDTO> pcmeducationexperiencedtos) {
        List<PCMEducationExperience> domainlist=pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedtos);
        for(PCMEducationExperience domain:domainlist){
             domain.setPcmprofileid(pcmprofile_id);
        }
        pcmeducationexperienceService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMEducationExperience-GetDraft-all')")
    @ApiOperation(value = "GetDraftByPCMPROFILE", tags = {"PCMEducationExperience" },  notes = "GetDraftByPCMPROFILE")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/getdraft")
    public ResponseEntity<PCMEducationExperienceDTO> getDraftByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id) {
        PCMEducationExperience domain = new PCMEducationExperience();
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperienceMapping.toDto(pcmeducationexperienceService.getDraft(domain)));
    }

    //@PreAuthorize("hasPermission(#pcmeducationexperience_id,'Remove',{'Sql',this.pcmeducationexperienceMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByPCMPROFILE", tags = {"PCMEducationExperience" },  notes = "RemoveByPCMPROFILE")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/{pcmeducationexperience_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmeducationexperience_id") String pcmeducationexperience_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperienceService.remove(pcmeducationexperience_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatchByPCMPROFILE", tags = {"PCMEducationExperience" },  notes = "RemoveBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/batch")
    public ResponseEntity<Boolean> removeBatchByPCMPROFILE(@RequestBody List<String> ids) {
        pcmeducationexperienceService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasPermission(#pcmeducationexperience_id,'Update',{'Sql',this.pcmeducationexperienceMapping,#pcmeducationexperiencedto})")
    @ApiOperation(value = "UpdateByPCMPROFILE", tags = {"PCMEducationExperience" },  notes = "UpdateByPCMPROFILE")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/{pcmeducationexperience_id}")
    @Transactional
    public ResponseEntity<PCMEducationExperienceDTO> updateByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmeducationexperience_id") String pcmeducationexperience_id, @RequestBody PCMEducationExperienceDTO pcmeducationexperiencedto) {
        PCMEducationExperience domain = pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto);
        domain.setPcmprofileid(pcmprofile_id);
        domain.setPcmeducationexperienceid(pcmeducationexperience_id);
		pcmeducationexperienceService.update(domain);
        PCMEducationExperienceDTO dto = pcmeducationexperienceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatchByPCMPROFILE", tags = {"PCMEducationExperience" },  notes = "UpdateBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/batch")
    public ResponseEntity<Boolean> updateBatchByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMEducationExperienceDTO> pcmeducationexperiencedtos) {
        List<PCMEducationExperience> domainlist=pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedtos);
        for(PCMEducationExperience domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmeducationexperienceService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMEducationExperience-CheckTime-all')")
    @ApiOperation(value = "校验入学、毕业时间ByPCMPROFILE", tags = {"PCMEducationExperience" },  notes = "校验入学、毕业时间ByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/{pcmeducationexperiencepcmeducationexperienceid}/checktime")
    @Transactional
    public ResponseEntity<PCMEducationExperienceDTO> checkTimeByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmeducationexperience_id") String pcmeducationexperience_id, @RequestBody PCMEducationExperienceDTO pcmeducationexperiencedto) {
        PCMEducationExperience domain = pcmeducationexperienceMapping.toDomain(pcmeducationexperiencedto);
        domain.setPcmprofileid(pcmprofile_id);
        domain = pcmeducationexperienceService.checkTime(domain) ;
        pcmeducationexperiencedto = pcmeducationexperienceMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmeducationexperiencedto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMEducationExperience-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPCMPROFILE", tags = {"PCMEducationExperience" } ,notes = "fetchDEFAULTByPCMPROFILE")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/fetchdefault")
	public ResponseEntity<List<PCMEducationExperienceDTO>> fetchPCMEducationExperienceDefaultByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id,PCMEducationExperienceSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PCMEducationExperience> domains = pcmeducationexperienceService.searchDefault(context) ;
        List<PCMEducationExperienceDTO> list = pcmeducationexperienceMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMEducationExperience-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPCMPROFILE", tags = {"PCMEducationExperience" } ,notes = "searchDEFAULTByPCMPROFILE")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/{pcmprofile_id}/pcmeducationexperiences/searchdefault")
	public ResponseEntity<Page<PCMEducationExperienceDTO>> searchPCMEducationExperienceDefaultByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMEducationExperienceSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PCMEducationExperience> domains = pcmeducationexperienceService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmeducationexperienceMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
