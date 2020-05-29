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
import cn.ibizlab.ehr.core.pcm.domain.PcmTdzwxx;
import cn.ibizlab.ehr.core.pcm.service.IPcmTdzwxxService;
import cn.ibizlab.ehr.core.pcm.filter.PcmTdzwxxSearchContext;

@Slf4j
@Api(tags = {"PcmTdzwxx" })
@RestController("WebApi-pcmtdzwxx")
@RequestMapping("")
public class PcmTdzwxxResource {

    @Autowired
    public IPcmTdzwxxService pcmtdzwxxService;

    @Autowired
    @Lazy
    public PcmTdzwxxMapping pcmtdzwxxMapping;

    @PreAuthorize("hasPermission(this.pcmtdzwxxMapping.toDomain(#pcmtdzwxxdto),'ehr-PcmTdzwxx-Create')")
    @ApiOperation(value = "Create", tags = {"PcmTdzwxx" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtdzwxxes")
    @Transactional
    public ResponseEntity<PcmTdzwxxDTO> create(@RequestBody PcmTdzwxxDTO pcmtdzwxxdto) {
        PcmTdzwxx domain = pcmtdzwxxMapping.toDomain(pcmtdzwxxdto);
		pcmtdzwxxService.create(domain);
        PcmTdzwxxDTO dto = pcmtdzwxxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxMapping.toDomain(#pcmtdzwxxdtos),'ehr-PcmTdzwxx-Create')")
    @ApiOperation(value = "createBatch", tags = {"PcmTdzwxx" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtdzwxxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmTdzwxxDTO> pcmtdzwxxdtos) {
        pcmtdzwxxService.createBatch(pcmtdzwxxMapping.toDomain(pcmtdzwxxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PcmTdzwxx" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmtdzwxxes/getdraft")
    public ResponseEntity<PcmTdzwxxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmtdzwxxMapping.toDto(pcmtdzwxxService.getDraft(new PcmTdzwxx())));
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxService.get(#pcmtdzwxx_id),'ehr-PcmTdzwxx-Remove')")
    @ApiOperation(value = "Remove", tags = {"PcmTdzwxx" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmtdzwxxes/{pcmtdzwxx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmtdzwxx_id") String pcmtdzwxx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmtdzwxxService.remove(pcmtdzwxx_id));
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxService.getPcmtdzwxxByIds(#ids),'ehr-PcmTdzwxx-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PcmTdzwxx" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmtdzwxxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmtdzwxxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxMapping.toDomain(#pcmtdzwxxdto),'ehr-PcmTdzwxx-Save')")
    @ApiOperation(value = "Save", tags = {"PcmTdzwxx" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtdzwxxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmTdzwxxDTO pcmtdzwxxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmtdzwxxService.save(pcmtdzwxxMapping.toDomain(pcmtdzwxxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxMapping.toDomain(#pcmtdzwxxdtos),'ehr-PcmTdzwxx-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PcmTdzwxx" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtdzwxxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmTdzwxxDTO> pcmtdzwxxdtos) {
        pcmtdzwxxService.saveBatch(pcmtdzwxxMapping.toDomain(pcmtdzwxxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxService.get(#pcmtdzwxx_id),'ehr-PcmTdzwxx-Update')")
    @ApiOperation(value = "Update", tags = {"PcmTdzwxx" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmtdzwxxes/{pcmtdzwxx_id}")
    @Transactional
    public ResponseEntity<PcmTdzwxxDTO> update(@PathVariable("pcmtdzwxx_id") String pcmtdzwxx_id, @RequestBody PcmTdzwxxDTO pcmtdzwxxdto) {
		PcmTdzwxx domain  = pcmtdzwxxMapping.toDomain(pcmtdzwxxdto);
        domain .setTdzwxxid(pcmtdzwxx_id);
		pcmtdzwxxService.update(domain );
		PcmTdzwxxDTO dto = pcmtdzwxxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxService.getPcmtdzwxxByEntities(this.pcmtdzwxxMapping.toDomain(#pcmtdzwxxdtos)),'ehr-PcmTdzwxx-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PcmTdzwxx" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmtdzwxxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmTdzwxxDTO> pcmtdzwxxdtos) {
        pcmtdzwxxService.updateBatch(pcmtdzwxxMapping.toDomain(pcmtdzwxxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PcmTdzwxx" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtdzwxxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmTdzwxxDTO pcmtdzwxxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmtdzwxxService.checkKey(pcmtdzwxxMapping.toDomain(pcmtdzwxxdto)));
    }

    @PostAuthorize("hasPermission(this.pcmtdzwxxMapping.toDomain(returnObject.body),'ehr-PcmTdzwxx-Get')")
    @ApiOperation(value = "Get", tags = {"PcmTdzwxx" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmtdzwxxes/{pcmtdzwxx_id}")
    public ResponseEntity<PcmTdzwxxDTO> get(@PathVariable("pcmtdzwxx_id") String pcmtdzwxx_id) {
        PcmTdzwxx domain = pcmtdzwxxService.get(pcmtdzwxx_id);
        PcmTdzwxxDTO dto = pcmtdzwxxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTdzwxx-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PcmTdzwxx" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmtdzwxxes/fetchdefault")
	public ResponseEntity<List<PcmTdzwxxDTO>> fetchDefault(PcmTdzwxxSearchContext context) {
        Page<PcmTdzwxx> domains = pcmtdzwxxService.searchDefault(context) ;
        List<PcmTdzwxxDTO> list = pcmtdzwxxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTdzwxx-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PcmTdzwxx" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmtdzwxxes/searchdefault")
	public ResponseEntity<Page<PcmTdzwxxDTO>> searchDefault(@RequestBody PcmTdzwxxSearchContext context) {
        Page<PcmTdzwxx> domains = pcmtdzwxxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmtdzwxxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pcmtdzwxxMapping.toDomain(#pcmtdzwxxdto),'ehr-PcmTdzwxx-Create')")
    @ApiOperation(value = "CreateByPcmProfile", tags = {"PcmTdzwxx" },  notes = "CreateByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes")
    @Transactional
    public ResponseEntity<PcmTdzwxxDTO> createByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmTdzwxxDTO pcmtdzwxxdto) {
        PcmTdzwxx domain = pcmtdzwxxMapping.toDomain(pcmtdzwxxdto);
        domain.setPcmprofileid(pcmprofile_id);
		pcmtdzwxxService.create(domain);
        PcmTdzwxxDTO dto = pcmtdzwxxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxMapping.toDomain(#pcmtdzwxxdtos),'ehr-PcmTdzwxx-Create')")
    @ApiOperation(value = "createBatchByPcmProfile", tags = {"PcmTdzwxx" },  notes = "createBatchByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes/batch")
    public ResponseEntity<Boolean> createBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmTdzwxxDTO> pcmtdzwxxdtos) {
        List<PcmTdzwxx> domainlist=pcmtdzwxxMapping.toDomain(pcmtdzwxxdtos);
        for(PcmTdzwxx domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmtdzwxxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPcmProfile", tags = {"PcmTdzwxx" },  notes = "GetDraftByPcmProfile")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes/getdraft")
    public ResponseEntity<PcmTdzwxxDTO> getDraftByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id) {
        PcmTdzwxx domain = new PcmTdzwxx();
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmtdzwxxMapping.toDto(pcmtdzwxxService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxService.get(#pcmtdzwxx_id),'ehr-PcmTdzwxx-Remove')")
    @ApiOperation(value = "RemoveByPcmProfile", tags = {"PcmTdzwxx" },  notes = "RemoveByPcmProfile")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes/{pcmtdzwxx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmtdzwxx_id") String pcmtdzwxx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmtdzwxxService.remove(pcmtdzwxx_id));
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxService.getPcmtdzwxxByIds(#ids),'ehr-PcmTdzwxx-Remove')")
    @ApiOperation(value = "RemoveBatchByPcmProfile", tags = {"PcmTdzwxx" },  notes = "RemoveBatchByPcmProfile")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes/batch")
    public ResponseEntity<Boolean> removeBatchByPcmProfile(@RequestBody List<String> ids) {
        pcmtdzwxxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxMapping.toDomain(#pcmtdzwxxdto),'ehr-PcmTdzwxx-Save')")
    @ApiOperation(value = "SaveByPcmProfile", tags = {"PcmTdzwxx" },  notes = "SaveByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes/save")
    public ResponseEntity<Boolean> saveByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmTdzwxxDTO pcmtdzwxxdto) {
        PcmTdzwxx domain = pcmtdzwxxMapping.toDomain(pcmtdzwxxdto);
        domain.setPcmprofileid(pcmprofile_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmtdzwxxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxMapping.toDomain(#pcmtdzwxxdtos),'ehr-PcmTdzwxx-Save')")
    @ApiOperation(value = "SaveBatchByPcmProfile", tags = {"PcmTdzwxx" },  notes = "SaveBatchByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmTdzwxxDTO> pcmtdzwxxdtos) {
        List<PcmTdzwxx> domainlist=pcmtdzwxxMapping.toDomain(pcmtdzwxxdtos);
        for(PcmTdzwxx domain:domainlist){
             domain.setPcmprofileid(pcmprofile_id);
        }
        pcmtdzwxxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxService.get(#pcmtdzwxx_id),'ehr-PcmTdzwxx-Update')")
    @ApiOperation(value = "UpdateByPcmProfile", tags = {"PcmTdzwxx" },  notes = "UpdateByPcmProfile")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes/{pcmtdzwxx_id}")
    @Transactional
    public ResponseEntity<PcmTdzwxxDTO> updateByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmtdzwxx_id") String pcmtdzwxx_id, @RequestBody PcmTdzwxxDTO pcmtdzwxxdto) {
        PcmTdzwxx domain = pcmtdzwxxMapping.toDomain(pcmtdzwxxdto);
        domain.setPcmprofileid(pcmprofile_id);
        domain.setTdzwxxid(pcmtdzwxx_id);
		pcmtdzwxxService.update(domain);
        PcmTdzwxxDTO dto = pcmtdzwxxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmtdzwxxService.getPcmtdzwxxByEntities(this.pcmtdzwxxMapping.toDomain(#pcmtdzwxxdtos)),'ehr-PcmTdzwxx-Update')")
    @ApiOperation(value = "UpdateBatchByPcmProfile", tags = {"PcmTdzwxx" },  notes = "UpdateBatchByPcmProfile")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes/batch")
    public ResponseEntity<Boolean> updateBatchByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody List<PcmTdzwxxDTO> pcmtdzwxxdtos) {
        List<PcmTdzwxx> domainlist=pcmtdzwxxMapping.toDomain(pcmtdzwxxdtos);
        for(PcmTdzwxx domain:domainlist){
            domain.setPcmprofileid(pcmprofile_id);
        }
        pcmtdzwxxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByPcmProfile", tags = {"PcmTdzwxx" },  notes = "CheckKeyByPcmProfile")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmTdzwxxDTO pcmtdzwxxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmtdzwxxService.checkKey(pcmtdzwxxMapping.toDomain(pcmtdzwxxdto)));
    }

    @PostAuthorize("hasPermission(this.pcmtdzwxxMapping.toDomain(returnObject.body),'ehr-PcmTdzwxx-Get')")
    @ApiOperation(value = "GetByPcmProfile", tags = {"PcmTdzwxx" },  notes = "GetByPcmProfile")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes/{pcmtdzwxx_id}")
    public ResponseEntity<PcmTdzwxxDTO> getByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @PathVariable("pcmtdzwxx_id") String pcmtdzwxx_id) {
        PcmTdzwxx domain = pcmtdzwxxService.get(pcmtdzwxx_id);
        PcmTdzwxxDTO dto = pcmtdzwxxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTdzwxx-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPcmProfile", tags = {"PcmTdzwxx" } ,notes = "fetchDEFAULTByPcmProfile")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes/fetchdefault")
	public ResponseEntity<List<PcmTdzwxxDTO>> fetchPcmTdzwxxDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id,PcmTdzwxxSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PcmTdzwxx> domains = pcmtdzwxxService.searchDefault(context) ;
        List<PcmTdzwxxDTO> list = pcmtdzwxxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTdzwxx-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPcmProfile", tags = {"PcmTdzwxx" } ,notes = "searchDEFAULTByPcmProfile")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofiles/{pcmprofile_id}/pcmtdzwxxes/searchdefault")
	public ResponseEntity<Page<PcmTdzwxxDTO>> searchPcmTdzwxxDefaultByPcmProfile(@PathVariable("pcmprofile_id") String pcmprofile_id, @RequestBody PcmTdzwxxSearchContext context) {
        context.setN_pcmprofileid_eq(pcmprofile_id);
        Page<PcmTdzwxx> domains = pcmtdzwxxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmtdzwxxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

