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
import cn.ibizlab.ehr.core.pcm.domain.PCMSCHOOLOFFICE;
import cn.ibizlab.ehr.core.pcm.service.IPCMSCHOOLOFFICEService;
import cn.ibizlab.ehr.core.pcm.filter.PCMSCHOOLOFFICESearchContext;

@Slf4j
@Api(tags = {"PCMSCHOOLOFFICE" })
@RestController("WebApi-pcmschooloffice")
@RequestMapping("")
public class PCMSCHOOLOFFICEResource {

    @Autowired
    private IPCMSCHOOLOFFICEService pcmschoolofficeService;

    @Autowired
    @Lazy
    public PCMSCHOOLOFFICEMapping pcmschoolofficeMapping;

    public PCMSCHOOLOFFICEDTO permissionDTO=new PCMSCHOOLOFFICEDTO();

    @PreAuthorize("hasPermission(#pcmschooloffice_id,'Get',{'Sql',this.pcmschoolofficeMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMSCHOOLOFFICE" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmschooloffices/{pcmschooloffice_id}")
    public ResponseEntity<PCMSCHOOLOFFICEDTO> get(@PathVariable("pcmschooloffice_id") String pcmschooloffice_id) {
        PCMSCHOOLOFFICE domain = pcmschoolofficeService.get(pcmschooloffice_id);
        PCMSCHOOLOFFICEDTO dto = pcmschoolofficeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmschooloffice_id,'Remove',{'Sql',this.pcmschoolofficeMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMSCHOOLOFFICE" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmschooloffices/{pcmschooloffice_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmschooloffice_id") String pcmschooloffice_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmschoolofficeService.remove(pcmschooloffice_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMSCHOOLOFFICE" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmschooloffices/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmschoolofficeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMSCHOOLOFFICE-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMSCHOOLOFFICE" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmschooloffices/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMSCHOOLOFFICEDTO pcmschoolofficedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmschoolofficeService.checkKey(pcmschoolofficeMapping.toDomain(pcmschoolofficedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMSCHOOLOFFICE-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMSCHOOLOFFICE" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmschooloffices/getdraft")
    public ResponseEntity<PCMSCHOOLOFFICEDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmschoolofficeMapping.toDto(pcmschoolofficeService.getDraft(new PCMSCHOOLOFFICE())));
    }

    @PreAuthorize("hasPermission(#pcmschooloffice_id,'Update',{'Sql',this.pcmschoolofficeMapping,#pcmschoolofficedto})")
    @ApiOperation(value = "Update", tags = {"PCMSCHOOLOFFICE" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmschooloffices/{pcmschooloffice_id}")
    @Transactional
    public ResponseEntity<PCMSCHOOLOFFICEDTO> update(@PathVariable("pcmschooloffice_id") String pcmschooloffice_id, @RequestBody PCMSCHOOLOFFICEDTO pcmschoolofficedto) {
		PCMSCHOOLOFFICE domain = pcmschoolofficeMapping.toDomain(pcmschoolofficedto);
        domain.setPcmschoolofficeid(pcmschooloffice_id);
		pcmschoolofficeService.update(domain);
		PCMSCHOOLOFFICEDTO dto = pcmschoolofficeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMSCHOOLOFFICE" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmschooloffices/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMSCHOOLOFFICEDTO> pcmschoolofficedtos) {
        pcmschoolofficeService.updateBatch(pcmschoolofficeMapping.toDomain(pcmschoolofficedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pcmschoolofficeMapping,#pcmschoolofficedto})")
    @ApiOperation(value = "Save", tags = {"PCMSCHOOLOFFICE" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmschooloffices/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMSCHOOLOFFICEDTO pcmschoolofficedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmschoolofficeService.save(pcmschoolofficeMapping.toDomain(pcmschoolofficedto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PCMSCHOOLOFFICE" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmschooloffices/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMSCHOOLOFFICEDTO> pcmschoolofficedtos) {
        pcmschoolofficeService.saveBatch(pcmschoolofficeMapping.toDomain(pcmschoolofficedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmschoolofficeMapping,#pcmschoolofficedto})")
    @ApiOperation(value = "Create", tags = {"PCMSCHOOLOFFICE" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmschooloffices")
    @Transactional
    public ResponseEntity<PCMSCHOOLOFFICEDTO> create(@RequestBody PCMSCHOOLOFFICEDTO pcmschoolofficedto) {
        PCMSCHOOLOFFICE domain = pcmschoolofficeMapping.toDomain(pcmschoolofficedto);
		pcmschoolofficeService.create(domain);
        PCMSCHOOLOFFICEDTO dto = pcmschoolofficeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PCMSCHOOLOFFICE" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmschooloffices/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMSCHOOLOFFICEDTO> pcmschoolofficedtos) {
        pcmschoolofficeService.createBatch(pcmschoolofficeMapping.toDomain(pcmschoolofficedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMSCHOOLOFFICE-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMSCHOOLOFFICE" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmschooloffices/fetchdefault")
	public ResponseEntity<List<PCMSCHOOLOFFICEDTO>> fetchDefault(PCMSCHOOLOFFICESearchContext context) {
        Page<PCMSCHOOLOFFICE> domains = pcmschoolofficeService.searchDefault(context) ;
        List<PCMSCHOOLOFFICEDTO> list = pcmschoolofficeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMSCHOOLOFFICE-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMSCHOOLOFFICE" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmschooloffices/searchdefault")
	public ResponseEntity<Page<PCMSCHOOLOFFICEDTO>> searchDefault(@RequestBody PCMSCHOOLOFFICESearchContext context) {
        Page<PCMSCHOOLOFFICE> domains = pcmschoolofficeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmschoolofficeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(#pcmschooloffice_id,'Get',{'Sql',this.pcmschoolofficeMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByPCMPROFILE", tags = {"PCMSCHOOLOFFICE" },  notes = "GetByPCMPROFILE")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/{pcmschooloffice_id}")
    public ResponseEntity<PCMSCHOOLOFFICEDTO> getByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmschooloffice_id") String pcmschooloffice_id) {
        PCMSCHOOLOFFICE domain = pcmschoolofficeService.get(pcmschooloffice_id);
        PCMSCHOOLOFFICEDTO dto = pcmschoolofficeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmschooloffice_id,'Remove',{'Sql',this.pcmschoolofficeMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByPCMPROFILE", tags = {"PCMSCHOOLOFFICE" },  notes = "RemoveByPCMPROFILE")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/{pcmschooloffice_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmschooloffice_id") String pcmschooloffice_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmschoolofficeService.remove(pcmschooloffice_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatchByPCMPROFILE", tags = {"PCMSCHOOLOFFICE" },  notes = "RemoveBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/batch")
    public ResponseEntity<Boolean> removeBatchByPCMPROFILE(@RequestBody List<String> ids) {
        pcmschoolofficeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMSCHOOLOFFICE-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByPCMPROFILE", tags = {"PCMSCHOOLOFFICE" },  notes = "CheckKeyByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/checkkey")
    public ResponseEntity<Boolean> checkKeyByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMSCHOOLOFFICEDTO pcmschoolofficedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmschoolofficeService.checkKey(pcmschoolofficeMapping.toDomain(pcmschoolofficedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMSCHOOLOFFICE-GetDraft-all')")
    @ApiOperation(value = "GetDraftByPCMPROFILE", tags = {"PCMSCHOOLOFFICE" },  notes = "GetDraftByPCMPROFILE")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/getdraft")
    public ResponseEntity<PCMSCHOOLOFFICEDTO> getDraftByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id) {
        PCMSCHOOLOFFICE domain = new PCMSCHOOLOFFICE();
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmschoolofficeMapping.toDto(pcmschoolofficeService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(#pcmschooloffice_id,'Update',{'Sql',this.pcmschoolofficeMapping,#pcmschoolofficedto})")
    @ApiOperation(value = "UpdateByPCMPROFILE", tags = {"PCMSCHOOLOFFICE" },  notes = "UpdateByPCMPROFILE")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/{pcmschooloffice_id}")
    @Transactional
    public ResponseEntity<PCMSCHOOLOFFICEDTO> updateByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmschooloffice_id") String pcmschooloffice_id, @RequestBody PCMSCHOOLOFFICEDTO pcmschoolofficedto) {
        PCMSCHOOLOFFICE domain = pcmschoolofficeMapping.toDomain(pcmschoolofficedto);
        domain.setPcmprofileid(pcmprofile_id);
        domain.setPcmschoolofficeid(pcmschooloffice_id);
		pcmschoolofficeService.update(domain);
        PCMSCHOOLOFFICEDTO dto = pcmschoolofficeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatchByPCMPROFILE", tags = {"PCMSCHOOLOFFICE" },  notes = "UpdateBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/batch")
    public ResponseEntity<Boolean> updateBatchByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMSCHOOLOFFICEDTO> pcmschoolofficedtos) {
        List<PCMSCHOOLOFFICE> domainlist=pcmschoolofficeMapping.toDomain(pcmschoolofficedtos);
        for(PCMSCHOOLOFFICE domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmschoolofficeService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pcmschoolofficeMapping,#pcmschoolofficedto})")
    @ApiOperation(value = "SaveByPCMPROFILE", tags = {"PCMSCHOOLOFFICE" },  notes = "SaveByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/save")
    public ResponseEntity<Boolean> saveByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMSCHOOLOFFICEDTO pcmschoolofficedto) {
        PCMSCHOOLOFFICE domain = pcmschoolofficeMapping.toDomain(pcmschoolofficedto);
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmschoolofficeService.save(domain));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatchByPCMPROFILE", tags = {"PCMSCHOOLOFFICE" },  notes = "SaveBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/savebatch")
    public ResponseEntity<Boolean> saveBatchByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMSCHOOLOFFICEDTO> pcmschoolofficedtos) {
        List<PCMSCHOOLOFFICE> domainlist=pcmschoolofficeMapping.toDomain(pcmschoolofficedtos);
        for(PCMSCHOOLOFFICE domain:domainlist){
             domain.setPcmprofileid(pcmprofile_id);
        }
        pcmschoolofficeService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmschoolofficeMapping,#pcmschoolofficedto})")
    @ApiOperation(value = "CreateByPCMPROFILE", tags = {"PCMSCHOOLOFFICE" },  notes = "CreateByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices")
    @Transactional
    public ResponseEntity<PCMSCHOOLOFFICEDTO> createByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMSCHOOLOFFICEDTO pcmschoolofficedto) {
        PCMSCHOOLOFFICE domain = pcmschoolofficeMapping.toDomain(pcmschoolofficedto);
        domain.setPcmprofileid(pcmprofile_id);
		pcmschoolofficeService.create(domain);
        PCMSCHOOLOFFICEDTO dto = pcmschoolofficeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatchByPCMPROFILE", tags = {"PCMSCHOOLOFFICE" },  notes = "createBatchByPCMPROFILE")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmschooloffices/batch")
    public ResponseEntity<Boolean> createBatchByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PCMSCHOOLOFFICEDTO> pcmschoolofficedtos) {
        List<PCMSCHOOLOFFICE> domainlist=pcmschoolofficeMapping.toDomain(pcmschoolofficedtos);
        for(PCMSCHOOLOFFICE domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmschoolofficeService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMSCHOOLOFFICE-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPCMPROFILE", tags = {"PCMSCHOOLOFFICE" } ,notes = "fetchDEFAULTByPCMPROFILE")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmschooloffices/fetchdefault")
	public ResponseEntity<List<PCMSCHOOLOFFICEDTO>> fetchPCMSCHOOLOFFICEDefaultByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id,PCMSCHOOLOFFICESearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PCMSCHOOLOFFICE> domains = pcmschoolofficeService.searchDefault(context) ;
        List<PCMSCHOOLOFFICEDTO> list = pcmschoolofficeMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMSCHOOLOFFICE-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPCMPROFILE", tags = {"PCMSCHOOLOFFICE" } ,notes = "searchDEFAULTByPCMPROFILE")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/{pcmprofile_id}/pcmschooloffices/searchdefault")
	public ResponseEntity<Page<PCMSCHOOLOFFICEDTO>> searchPCMSCHOOLOFFICEDefaultByPCMPROFILE(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PCMSCHOOLOFFICESearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PCMSCHOOLOFFICE> domains = pcmschoolofficeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmschoolofficeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
