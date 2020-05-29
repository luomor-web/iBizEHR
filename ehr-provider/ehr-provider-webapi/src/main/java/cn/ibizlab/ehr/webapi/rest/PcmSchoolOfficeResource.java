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
import cn.ibizlab.ehr.core.pcm.domain.PcmSchoolOffice;
import cn.ibizlab.ehr.core.pcm.service.IPcmSchoolOfficeService;
import cn.ibizlab.ehr.core.pcm.filter.PcmSchoolOfficeSearchContext;

@Slf4j
@Api(tags = {"PcmSchoolOffice" })
@RestController("WebApi-pcmschooloffice")
@RequestMapping("")
public class PcmSchoolOfficeResource {

    @Autowired
    public IPcmSchoolOfficeService pcmschoolofficeService;

    @Autowired
    @Lazy
    public PcmSchoolOfficeMapping pcmschoolofficeMapping;

    @PostAuthorize("hasPermission(this.pcmschoolofficeMapping.toDomain(returnObject.body),'ehr-PcmSchoolOffice-Get')")
    @ApiOperation(value = "Get", tags = {"PcmSchoolOffice" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmschooloffices/{pcmschooloffice_id}")
    public ResponseEntity<PcmSchoolOfficeDTO> get(@PathVariable("pcmschooloffice_id") String pcmschooloffice_id) {
        PcmSchoolOffice domain = pcmschoolofficeService.get(pcmschooloffice_id);
        PcmSchoolOfficeDTO dto = pcmschoolofficeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeService.get(#pcmschooloffice_id),'ehr-PcmSchoolOffice-Remove')")
    @ApiOperation(value = "Remove", tags = {"PcmSchoolOffice" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmschooloffices/{pcmschooloffice_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmschooloffice_id") String pcmschooloffice_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmschoolofficeService.remove(pcmschooloffice_id));
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeService.getPcmschoolofficeByIds(#ids),'ehr-PcmSchoolOffice-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PcmSchoolOffice" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmschooloffices/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmschoolofficeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PcmSchoolOffice" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmschooloffices/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmSchoolOfficeDTO pcmschoolofficedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmschoolofficeService.checkKey(pcmschoolofficeMapping.toDomain(pcmschoolofficedto)));
    }

    @ApiOperation(value = "GetDraft", tags = {"PcmSchoolOffice" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmschooloffices/getdraft")
    public ResponseEntity<PcmSchoolOfficeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmschoolofficeMapping.toDto(pcmschoolofficeService.getDraft(new PcmSchoolOffice())));
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeService.get(#pcmschooloffice_id),'ehr-PcmSchoolOffice-Update')")
    @ApiOperation(value = "Update", tags = {"PcmSchoolOffice" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmschooloffices/{pcmschooloffice_id}")
    @Transactional
    public ResponseEntity<PcmSchoolOfficeDTO> update(@PathVariable("pcmschooloffice_id") String pcmschooloffice_id, @RequestBody PcmSchoolOfficeDTO pcmschoolofficedto) {
		PcmSchoolOffice domain  = pcmschoolofficeMapping.toDomain(pcmschoolofficedto);
        domain .setPcmschoolofficeid(pcmschooloffice_id);
		pcmschoolofficeService.update(domain );
		PcmSchoolOfficeDTO dto = pcmschoolofficeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeService.getPcmschoolofficeByEntities(this.pcmschoolofficeMapping.toDomain(#pcmschoolofficedtos)),'ehr-PcmSchoolOffice-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PcmSchoolOffice" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmschooloffices/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmSchoolOfficeDTO> pcmschoolofficedtos) {
        pcmschoolofficeService.updateBatch(pcmschoolofficeMapping.toDomain(pcmschoolofficedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeMapping.toDomain(#pcmschoolofficedto),'ehr-PcmSchoolOffice-Save')")
    @ApiOperation(value = "Save", tags = {"PcmSchoolOffice" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmschooloffices/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmSchoolOfficeDTO pcmschoolofficedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmschoolofficeService.save(pcmschoolofficeMapping.toDomain(pcmschoolofficedto)));
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeMapping.toDomain(#pcmschoolofficedtos),'ehr-PcmSchoolOffice-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PcmSchoolOffice" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmschooloffices/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmSchoolOfficeDTO> pcmschoolofficedtos) {
        pcmschoolofficeService.saveBatch(pcmschoolofficeMapping.toDomain(pcmschoolofficedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeMapping.toDomain(#pcmschoolofficedto),'ehr-PcmSchoolOffice-Create')")
    @ApiOperation(value = "Create", tags = {"PcmSchoolOffice" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmschooloffices")
    @Transactional
    public ResponseEntity<PcmSchoolOfficeDTO> create(@RequestBody PcmSchoolOfficeDTO pcmschoolofficedto) {
        PcmSchoolOffice domain = pcmschoolofficeMapping.toDomain(pcmschoolofficedto);
		pcmschoolofficeService.create(domain);
        PcmSchoolOfficeDTO dto = pcmschoolofficeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeMapping.toDomain(#pcmschoolofficedtos),'ehr-PcmSchoolOffice-Create')")
    @ApiOperation(value = "createBatch", tags = {"PcmSchoolOffice" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmschooloffices/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmSchoolOfficeDTO> pcmschoolofficedtos) {
        pcmschoolofficeService.createBatch(pcmschoolofficeMapping.toDomain(pcmschoolofficedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmSchoolOffice-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PcmSchoolOffice" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmschooloffices/fetchdefault")
	public ResponseEntity<List<PcmSchoolOfficeDTO>> fetchDefault(PcmSchoolOfficeSearchContext context) {
        Page<PcmSchoolOffice> domains = pcmschoolofficeService.searchDefault(context) ;
        List<PcmSchoolOfficeDTO> list = pcmschoolofficeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmSchoolOffice-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PcmSchoolOffice" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmschooloffices/searchdefault")
	public ResponseEntity<Page<PcmSchoolOfficeDTO>> searchDefault(@RequestBody PcmSchoolOfficeSearchContext context) {
        Page<PcmSchoolOffice> domains = pcmschoolofficeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmschoolofficeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PostAuthorize("hasPermission(this.pcmschoolofficeMapping.toDomain(returnObject.body),'ehr-PcmSchoolOffice-Get')")
    @ApiOperation(value = "GetByPcmProfile", tags = {"PcmSchoolOffice" },  notes = "GetByPcmProfile")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/{pcmschooloffice_id}")
    public ResponseEntity<PcmSchoolOfficeDTO> getByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmschooloffice_id") String pcmschooloffice_id) {
        PcmSchoolOffice domain = pcmschoolofficeService.get(pcmschooloffice_id);
        PcmSchoolOfficeDTO dto = pcmschoolofficeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeService.get(#pcmschooloffice_id),'ehr-PcmSchoolOffice-Remove')")
    @ApiOperation(value = "RemoveByPcmProfile", tags = {"PcmSchoolOffice" },  notes = "RemoveByPcmProfile")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/{pcmschooloffice_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmschooloffice_id") String pcmschooloffice_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmschoolofficeService.remove(pcmschooloffice_id));
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeService.getPcmschoolofficeByIds(#ids),'ehr-PcmSchoolOffice-Remove')")
    @ApiOperation(value = "RemoveBatchByPcmProfile", tags = {"PcmSchoolOffice" },  notes = "RemoveBatchByPcmProfile")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/batch")
    public ResponseEntity<Boolean> removeBatchByPcmProfile(@RequestBody List<String> ids) {
        pcmschoolofficeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByPcmProfile", tags = {"PcmSchoolOffice" },  notes = "CheckKeyByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/checkkey")
    public ResponseEntity<Boolean> checkKeyByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmSchoolOfficeDTO pcmschoolofficedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmschoolofficeService.checkKey(pcmschoolofficeMapping.toDomain(pcmschoolofficedto)));
    }

    @ApiOperation(value = "GetDraftByPcmProfile", tags = {"PcmSchoolOffice" },  notes = "GetDraftByPcmProfile")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/getdraft")
    public ResponseEntity<PcmSchoolOfficeDTO> getDraftByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id) {
        PcmSchoolOffice domain = new PcmSchoolOffice();
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmschoolofficeMapping.toDto(pcmschoolofficeService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeService.get(#pcmschooloffice_id),'ehr-PcmSchoolOffice-Update')")
    @ApiOperation(value = "UpdateByPcmProfile", tags = {"PcmSchoolOffice" },  notes = "UpdateByPcmProfile")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/{pcmschooloffice_id}")
    @Transactional
    public ResponseEntity<PcmSchoolOfficeDTO> updateByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmschooloffice_id") String pcmschooloffice_id, @RequestBody PcmSchoolOfficeDTO pcmschoolofficedto) {
        PcmSchoolOffice domain = pcmschoolofficeMapping.toDomain(pcmschoolofficedto);
        domain.setPcmprofileid(pcmprofile_id);
        domain.setPcmschoolofficeid(pcmschooloffice_id);
		pcmschoolofficeService.update(domain);
        PcmSchoolOfficeDTO dto = pcmschoolofficeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeService.getPcmschoolofficeByEntities(this.pcmschoolofficeMapping.toDomain(#pcmschoolofficedtos)),'ehr-PcmSchoolOffice-Update')")
    @ApiOperation(value = "UpdateBatchByPcmProfile", tags = {"PcmSchoolOffice" },  notes = "UpdateBatchByPcmProfile")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/batch")
    public ResponseEntity<Boolean> updateBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmSchoolOfficeDTO> pcmschoolofficedtos) {
        List<PcmSchoolOffice> domainlist=pcmschoolofficeMapping.toDomain(pcmschoolofficedtos);
        for(PcmSchoolOffice domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmschoolofficeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeMapping.toDomain(#pcmschoolofficedto),'ehr-PcmSchoolOffice-Save')")
    @ApiOperation(value = "SaveByPcmProfile", tags = {"PcmSchoolOffice" },  notes = "SaveByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/save")
    public ResponseEntity<Boolean> saveByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmSchoolOfficeDTO pcmschoolofficedto) {
        PcmSchoolOffice domain = pcmschoolofficeMapping.toDomain(pcmschoolofficedto);
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmschoolofficeService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeMapping.toDomain(#pcmschoolofficedtos),'ehr-PcmSchoolOffice-Save')")
    @ApiOperation(value = "SaveBatchByPcmProfile", tags = {"PcmSchoolOffice" },  notes = "SaveBatchByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/savebatch")
    public ResponseEntity<Boolean> saveBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmSchoolOfficeDTO> pcmschoolofficedtos) {
        List<PcmSchoolOffice> domainlist=pcmschoolofficeMapping.toDomain(pcmschoolofficedtos);
        for(PcmSchoolOffice domain:domainlist){
             domain.setPcmprofileid(pcmprofile_id);
        }
        pcmschoolofficeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeMapping.toDomain(#pcmschoolofficedto),'ehr-PcmSchoolOffice-Create')")
    @ApiOperation(value = "CreateByPcmProfile", tags = {"PcmSchoolOffice" },  notes = "CreateByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices")
    @Transactional
    public ResponseEntity<PcmSchoolOfficeDTO> createByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmSchoolOfficeDTO pcmschoolofficedto) {
        PcmSchoolOffice domain = pcmschoolofficeMapping.toDomain(pcmschoolofficedto);
        domain.setPcmprofileid(pcmprofile_id);
		pcmschoolofficeService.create(domain);
        PcmSchoolOfficeDTO dto = pcmschoolofficeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmschoolofficeMapping.toDomain(#pcmschoolofficedtos),'ehr-PcmSchoolOffice-Create')")
    @ApiOperation(value = "createBatchByPcmProfile", tags = {"PcmSchoolOffice" },  notes = "createBatchByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/batch")
    public ResponseEntity<Boolean> createBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmSchoolOfficeDTO> pcmschoolofficedtos) {
        List<PcmSchoolOffice> domainlist=pcmschoolofficeMapping.toDomain(pcmschoolofficedtos);
        for(PcmSchoolOffice domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmschoolofficeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmSchoolOffice-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPcmProfile", tags = {"PcmSchoolOffice" } ,notes = "fetchDEFAULTByPcmProfile")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmschooloffices/fetchdefault")
	public ResponseEntity<List<PcmSchoolOfficeDTO>> fetchPcmSchoolOfficeDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id,PcmSchoolOfficeSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PcmSchoolOffice> domains = pcmschoolofficeService.searchDefault(context) ;
        List<PcmSchoolOfficeDTO> list = pcmschoolofficeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmSchoolOffice-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPcmProfile", tags = {"PcmSchoolOffice" } ,notes = "searchDEFAULTByPcmProfile")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/{pcmprofile_id}/pcmschooloffices/searchdefault")
	public ResponseEntity<Page<PcmSchoolOfficeDTO>> searchPcmSchoolOfficeDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmSchoolOfficeSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PcmSchoolOffice> domains = pcmschoolofficeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmschoolofficeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

