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
import cn.ibizlab.ehr.core.pcm.domain.PCMGXXKTEMP;
import cn.ibizlab.ehr.core.pcm.service.IPCMGXXKTEMPService;
import cn.ibizlab.ehr.core.pcm.filter.PCMGXXKTEMPSearchContext;

@Slf4j
@Api(tags = {"PCMGXXKTEMP" })
@RestController("WebApi-pcmgxxktemp")
@RequestMapping("")
public class PCMGXXKTEMPResource {

    @Autowired
    private IPCMGXXKTEMPService pcmgxxktempService;

    @Autowired
    @Lazy
    public PCMGXXKTEMPMapping pcmgxxktempMapping;

    public PCMGXXKTEMPDTO permissionDTO=new PCMGXXKTEMPDTO();

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGXXKTEMP-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMGXXKTEMP" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmgxxktemps/getdraft")
    public ResponseEntity<PCMGXXKTEMPDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempMapping.toDto(pcmgxxktempService.getDraft(new PCMGXXKTEMP())));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmgxxktempMapping,#pcmgxxktempdto})")
    @ApiOperation(value = "Create", tags = {"PCMGXXKTEMP" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxxktemps")
    @Transactional
    public ResponseEntity<PCMGXXKTEMPDTO> create(@RequestBody PCMGXXKTEMPDTO pcmgxxktempdto) {
        PCMGXXKTEMP domain = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
		pcmgxxktempService.create(domain);
        PCMGXXKTEMPDTO dto = pcmgxxktempMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.pcmgxxktempMapping,#pcmgxxktempdtos})")
    @ApiOperation(value = "createBatch", tags = {"PCMGXXKTEMP" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMGXXKTEMPDTO> pcmgxxktempdtos) {
        pcmgxxktempService.createBatch(pcmgxxktempMapping.toDomain(pcmgxxktempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmgxxktemp_id,'Remove',{'Sql',this.pcmgxxktempMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMGXXKTEMP" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmgxxktemps/{pcmgxxktemp_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.remove(pcmgxxktemp_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.pcmgxxktempMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMGXXKTEMP" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmgxxktempService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGXXKTEMP-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMGXXKTEMP" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxxktemps/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMGXXKTEMPDTO pcmgxxktempdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.checkKey(pcmgxxktempMapping.toDomain(pcmgxxktempdto)));
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pcmgxxktempMapping,#pcmgxxktempdto})")
    @ApiOperation(value = "Save", tags = {"PCMGXXKTEMP" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxxktemps/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMGXXKTEMPDTO pcmgxxktempdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.save(pcmgxxktempMapping.toDomain(pcmgxxktempdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.pcmgxxktempMapping,#pcmgxxktempdtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PCMGXXKTEMP" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxxktemps/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMGXXKTEMPDTO> pcmgxxktempdtos) {
        pcmgxxktempService.saveBatch(pcmgxxktempMapping.toDomain(pcmgxxktempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmgxxktemp_id,'Get',{'Sql',this.pcmgxxktempMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMGXXKTEMP" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmgxxktemps/{pcmgxxktemp_id}")
    public ResponseEntity<PCMGXXKTEMPDTO> get(@PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id) {
        PCMGXXKTEMP domain = pcmgxxktempService.get(pcmgxxktemp_id);
        PCMGXXKTEMPDTO dto = pcmgxxktempMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmgxxktemp_id,'Update',{'Sql',this.pcmgxxktempMapping,#pcmgxxktempdto})")
    @ApiOperation(value = "Update", tags = {"PCMGXXKTEMP" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmgxxktemps/{pcmgxxktemp_id}")
    @Transactional
    public ResponseEntity<PCMGXXKTEMPDTO> update(@PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id, @RequestBody PCMGXXKTEMPDTO pcmgxxktempdto) {
		PCMGXXKTEMP domain  = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
        domain .setPcmgxxktempid(pcmgxxktemp_id);
		pcmgxxktempService.update(domain );
		PCMGXXKTEMPDTO dto = pcmgxxktempMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.pcmgxxktempMapping,#pcmgxxktempdtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMGXXKTEMP" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMGXXKTEMPDTO> pcmgxxktempdtos) {
        pcmgxxktempService.updateBatch(pcmgxxktempMapping.toDomain(pcmgxxktempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGXXKTEMP-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMGXXKTEMP" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmgxxktemps/fetchdefault")
	public ResponseEntity<List<PCMGXXKTEMPDTO>> fetchDefault(PCMGXXKTEMPSearchContext context) {
        Page<PCMGXXKTEMP> domains = pcmgxxktempService.searchDefault(context) ;
        List<PCMGXXKTEMPDTO> list = pcmgxxktempMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGXXKTEMP-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMGXXKTEMP" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmgxxktemps/searchdefault")
	public ResponseEntity<Page<PCMGXXKTEMPDTO>> searchDefault(@RequestBody PCMGXXKTEMPSearchContext context) {
        Page<PCMGXXKTEMP> domains = pcmgxxktempService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmgxxktempMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGXXKTEMP-GetDraft-all')")
    @ApiOperation(value = "GetDraftByPCMGXML", tags = {"PCMGXXKTEMP" },  notes = "GetDraftByPCMGXML")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/getdraft")
    public ResponseEntity<PCMGXXKTEMPDTO> getDraftByPCMGXML(@PathVariable("pcmgxml_id") String pcmgxml_id) {
        PCMGXXKTEMP domain = new PCMGXXKTEMP();
        domain.setPcmgxmlid(pcmgxml_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempMapping.toDto(pcmgxxktempService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmgxxktempMapping,#pcmgxxktempdto})")
    @ApiOperation(value = "CreateByPCMGXML", tags = {"PCMGXXKTEMP" },  notes = "CreateByPCMGXML")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps")
    @Transactional
    public ResponseEntity<PCMGXXKTEMPDTO> createByPCMGXML(@PathVariable("pcmgxml_id") String pcmgxml_id, @RequestBody PCMGXXKTEMPDTO pcmgxxktempdto) {
        PCMGXXKTEMP domain = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
        domain.setPcmgxmlid(pcmgxml_id);
		pcmgxxktempService.create(domain);
        PCMGXXKTEMPDTO dto = pcmgxxktempMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.pcmgxxktempMapping,#pcmgxxktempdtos})")
    @ApiOperation(value = "createBatchByPCMGXML", tags = {"PCMGXXKTEMP" },  notes = "createBatchByPCMGXML")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> createBatchByPCMGXML(@PathVariable("pcmgxml_id") String pcmgxml_id, @RequestBody List<PCMGXXKTEMPDTO> pcmgxxktempdtos) {
        List<PCMGXXKTEMP> domainlist=pcmgxxktempMapping.toDomain(pcmgxxktempdtos);
        for(PCMGXXKTEMP domain:domainlist){
            domain.setPcmgxmlid(pcmgxml_id);
        }
        pcmgxxktempService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmgxxktemp_id,'Remove',{'Sql',this.pcmgxxktempMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByPCMGXML", tags = {"PCMGXXKTEMP" },  notes = "RemoveByPCMGXML")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/{pcmgxxktemp_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPCMGXML(@PathVariable("pcmgxml_id") String pcmgxml_id, @PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.remove(pcmgxxktemp_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.pcmgxxktempMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatchByPCMGXML", tags = {"PCMGXXKTEMP" },  notes = "RemoveBatchByPCMGXML")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> removeBatchByPCMGXML(@RequestBody List<String> ids) {
        pcmgxxktempService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGXXKTEMP-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByPCMGXML", tags = {"PCMGXXKTEMP" },  notes = "CheckKeyByPCMGXML")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/checkkey")
    public ResponseEntity<Boolean> checkKeyByPCMGXML(@PathVariable("pcmgxml_id") String pcmgxml_id, @RequestBody PCMGXXKTEMPDTO pcmgxxktempdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.checkKey(pcmgxxktempMapping.toDomain(pcmgxxktempdto)));
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pcmgxxktempMapping,#pcmgxxktempdto})")
    @ApiOperation(value = "SaveByPCMGXML", tags = {"PCMGXXKTEMP" },  notes = "SaveByPCMGXML")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/save")
    public ResponseEntity<Boolean> saveByPCMGXML(@PathVariable("pcmgxml_id") String pcmgxml_id, @RequestBody PCMGXXKTEMPDTO pcmgxxktempdto) {
        PCMGXXKTEMP domain = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
        domain.setPcmgxmlid(pcmgxml_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.save(domain));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.pcmgxxktempMapping,#pcmgxxktempdtos})")
    @ApiOperation(value = "SaveBatchByPCMGXML", tags = {"PCMGXXKTEMP" },  notes = "SaveBatchByPCMGXML")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/savebatch")
    public ResponseEntity<Boolean> saveBatchByPCMGXML(@PathVariable("pcmgxml_id") String pcmgxml_id, @RequestBody List<PCMGXXKTEMPDTO> pcmgxxktempdtos) {
        List<PCMGXXKTEMP> domainlist=pcmgxxktempMapping.toDomain(pcmgxxktempdtos);
        for(PCMGXXKTEMP domain:domainlist){
             domain.setPcmgxmlid(pcmgxml_id);
        }
        pcmgxxktempService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmgxxktemp_id,'Get',{'Sql',this.pcmgxxktempMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByPCMGXML", tags = {"PCMGXXKTEMP" },  notes = "GetByPCMGXML")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/{pcmgxxktemp_id}")
    public ResponseEntity<PCMGXXKTEMPDTO> getByPCMGXML(@PathVariable("pcmgxml_id") String pcmgxml_id, @PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id) {
        PCMGXXKTEMP domain = pcmgxxktempService.get(pcmgxxktemp_id);
        PCMGXXKTEMPDTO dto = pcmgxxktempMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmgxxktemp_id,'Update',{'Sql',this.pcmgxxktempMapping,#pcmgxxktempdto})")
    @ApiOperation(value = "UpdateByPCMGXML", tags = {"PCMGXXKTEMP" },  notes = "UpdateByPCMGXML")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/{pcmgxxktemp_id}")
    @Transactional
    public ResponseEntity<PCMGXXKTEMPDTO> updateByPCMGXML(@PathVariable("pcmgxml_id") String pcmgxml_id, @PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id, @RequestBody PCMGXXKTEMPDTO pcmgxxktempdto) {
        PCMGXXKTEMP domain = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
        domain.setPcmgxmlid(pcmgxml_id);
        domain.setPcmgxxktempid(pcmgxxktemp_id);
		pcmgxxktempService.update(domain);
        PCMGXXKTEMPDTO dto = pcmgxxktempMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.pcmgxxktempMapping,#pcmgxxktempdtos})")
    @ApiOperation(value = "UpdateBatchByPCMGXML", tags = {"PCMGXXKTEMP" },  notes = "UpdateBatchByPCMGXML")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> updateBatchByPCMGXML(@PathVariable("pcmgxml_id") String pcmgxml_id, @RequestBody List<PCMGXXKTEMPDTO> pcmgxxktempdtos) {
        List<PCMGXXKTEMP> domainlist=pcmgxxktempMapping.toDomain(pcmgxxktempdtos);
        for(PCMGXXKTEMP domain:domainlist){
            domain.setPcmgxmlid(pcmgxml_id);
        }
        pcmgxxktempService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGXXKTEMP-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPCMGXML", tags = {"PCMGXXKTEMP" } ,notes = "fetchDEFAULTByPCMGXML")
    @RequestMapping(method= RequestMethod.GET , value="/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/fetchdefault")
	public ResponseEntity<List<PCMGXXKTEMPDTO>> fetchPCMGXXKTEMPDefaultByPCMGXML(@PathVariable("pcmgxml_id") String pcmgxml_id,PCMGXXKTEMPSearchContext context) {
        context.setN_pcmgxmlid_eq(pcmgxml_id);
        Page<PCMGXXKTEMP> domains = pcmgxxktempService.searchDefault(context) ;
        List<PCMGXXKTEMPDTO> list = pcmgxxktempMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGXXKTEMP-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPCMGXML", tags = {"PCMGXXKTEMP" } ,notes = "searchDEFAULTByPCMGXML")
    @RequestMapping(method= RequestMethod.POST , value="/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/searchdefault")
	public ResponseEntity<Page<PCMGXXKTEMPDTO>> searchPCMGXXKTEMPDefaultByPCMGXML(@PathVariable("pcmgxml_id") String pcmgxml_id, @RequestBody PCMGXXKTEMPSearchContext context) {
        context.setN_pcmgxmlid_eq(pcmgxml_id);
        Page<PCMGXXKTEMP> domains = pcmgxxktempService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmgxxktempMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGXXKTEMP-GetDraft-all')")
    @ApiOperation(value = "GetDraftByPCMXKML", tags = {"PCMGXXKTEMP" },  notes = "GetDraftByPCMXKML")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/getdraft")
    public ResponseEntity<PCMGXXKTEMPDTO> getDraftByPCMXKML(@PathVariable("pcmxkml_id") String pcmxkml_id) {
        PCMGXXKTEMP domain = new PCMGXXKTEMP();
        domain.setPcmxkmlid(pcmxkml_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempMapping.toDto(pcmgxxktempService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmgxxktempMapping,#pcmgxxktempdto})")
    @ApiOperation(value = "CreateByPCMXKML", tags = {"PCMGXXKTEMP" },  notes = "CreateByPCMXKML")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps")
    @Transactional
    public ResponseEntity<PCMGXXKTEMPDTO> createByPCMXKML(@PathVariable("pcmxkml_id") String pcmxkml_id, @RequestBody PCMGXXKTEMPDTO pcmgxxktempdto) {
        PCMGXXKTEMP domain = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
        domain.setPcmxkmlid(pcmxkml_id);
		pcmgxxktempService.create(domain);
        PCMGXXKTEMPDTO dto = pcmgxxktempMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.pcmgxxktempMapping,#pcmgxxktempdtos})")
    @ApiOperation(value = "createBatchByPCMXKML", tags = {"PCMGXXKTEMP" },  notes = "createBatchByPCMXKML")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> createBatchByPCMXKML(@PathVariable("pcmxkml_id") String pcmxkml_id, @RequestBody List<PCMGXXKTEMPDTO> pcmgxxktempdtos) {
        List<PCMGXXKTEMP> domainlist=pcmgxxktempMapping.toDomain(pcmgxxktempdtos);
        for(PCMGXXKTEMP domain:domainlist){
            domain.setPcmxkmlid(pcmxkml_id);
        }
        pcmgxxktempService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmgxxktemp_id,'Remove',{'Sql',this.pcmgxxktempMapping,this.permissionDTO})")
    @ApiOperation(value = "RemoveByPCMXKML", tags = {"PCMGXXKTEMP" },  notes = "RemoveByPCMXKML")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/{pcmgxxktemp_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPCMXKML(@PathVariable("pcmxkml_id") String pcmxkml_id, @PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.remove(pcmgxxktemp_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.pcmgxxktempMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatchByPCMXKML", tags = {"PCMGXXKTEMP" },  notes = "RemoveBatchByPCMXKML")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> removeBatchByPCMXKML(@RequestBody List<String> ids) {
        pcmgxxktempService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGXXKTEMP-CheckKey-all')")
    @ApiOperation(value = "CheckKeyByPCMXKML", tags = {"PCMGXXKTEMP" },  notes = "CheckKeyByPCMXKML")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/checkkey")
    public ResponseEntity<Boolean> checkKeyByPCMXKML(@PathVariable("pcmxkml_id") String pcmxkml_id, @RequestBody PCMGXXKTEMPDTO pcmgxxktempdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.checkKey(pcmgxxktempMapping.toDomain(pcmgxxktempdto)));
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pcmgxxktempMapping,#pcmgxxktempdto})")
    @ApiOperation(value = "SaveByPCMXKML", tags = {"PCMGXXKTEMP" },  notes = "SaveByPCMXKML")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/save")
    public ResponseEntity<Boolean> saveByPCMXKML(@PathVariable("pcmxkml_id") String pcmxkml_id, @RequestBody PCMGXXKTEMPDTO pcmgxxktempdto) {
        PCMGXXKTEMP domain = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
        domain.setPcmxkmlid(pcmxkml_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.save(domain));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.pcmgxxktempMapping,#pcmgxxktempdtos})")
    @ApiOperation(value = "SaveBatchByPCMXKML", tags = {"PCMGXXKTEMP" },  notes = "SaveBatchByPCMXKML")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/savebatch")
    public ResponseEntity<Boolean> saveBatchByPCMXKML(@PathVariable("pcmxkml_id") String pcmxkml_id, @RequestBody List<PCMGXXKTEMPDTO> pcmgxxktempdtos) {
        List<PCMGXXKTEMP> domainlist=pcmgxxktempMapping.toDomain(pcmgxxktempdtos);
        for(PCMGXXKTEMP domain:domainlist){
             domain.setPcmxkmlid(pcmxkml_id);
        }
        pcmgxxktempService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmgxxktemp_id,'Get',{'Sql',this.pcmgxxktempMapping,this.permissionDTO})")
    @ApiOperation(value = "GetByPCMXKML", tags = {"PCMGXXKTEMP" },  notes = "GetByPCMXKML")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/{pcmgxxktemp_id}")
    public ResponseEntity<PCMGXXKTEMPDTO> getByPCMXKML(@PathVariable("pcmxkml_id") String pcmxkml_id, @PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id) {
        PCMGXXKTEMP domain = pcmgxxktempService.get(pcmgxxktemp_id);
        PCMGXXKTEMPDTO dto = pcmgxxktempMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmgxxktemp_id,'Update',{'Sql',this.pcmgxxktempMapping,#pcmgxxktempdto})")
    @ApiOperation(value = "UpdateByPCMXKML", tags = {"PCMGXXKTEMP" },  notes = "UpdateByPCMXKML")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/{pcmgxxktemp_id}")
    @Transactional
    public ResponseEntity<PCMGXXKTEMPDTO> updateByPCMXKML(@PathVariable("pcmxkml_id") String pcmxkml_id, @PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id, @RequestBody PCMGXXKTEMPDTO pcmgxxktempdto) {
        PCMGXXKTEMP domain = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
        domain.setPcmxkmlid(pcmxkml_id);
        domain.setPcmgxxktempid(pcmgxxktemp_id);
		pcmgxxktempService.update(domain);
        PCMGXXKTEMPDTO dto = pcmgxxktempMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.pcmgxxktempMapping,#pcmgxxktempdtos})")
    @ApiOperation(value = "UpdateBatchByPCMXKML", tags = {"PCMGXXKTEMP" },  notes = "UpdateBatchByPCMXKML")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> updateBatchByPCMXKML(@PathVariable("pcmxkml_id") String pcmxkml_id, @RequestBody List<PCMGXXKTEMPDTO> pcmgxxktempdtos) {
        List<PCMGXXKTEMP> domainlist=pcmgxxktempMapping.toDomain(pcmgxxktempdtos);
        for(PCMGXXKTEMP domain:domainlist){
            domain.setPcmxkmlid(pcmxkml_id);
        }
        pcmgxxktempService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGXXKTEMP-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPCMXKML", tags = {"PCMGXXKTEMP" } ,notes = "fetchDEFAULTByPCMXKML")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/fetchdefault")
	public ResponseEntity<List<PCMGXXKTEMPDTO>> fetchPCMGXXKTEMPDefaultByPCMXKML(@PathVariable("pcmxkml_id") String pcmxkml_id,PCMGXXKTEMPSearchContext context) {
        context.setN_pcmxkmlid_eq(pcmxkml_id);
        Page<PCMGXXKTEMP> domains = pcmgxxktempService.searchDefault(context) ;
        List<PCMGXXKTEMPDTO> list = pcmgxxktempMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGXXKTEMP-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPCMXKML", tags = {"PCMGXXKTEMP" } ,notes = "searchDEFAULTByPCMXKML")
    @RequestMapping(method= RequestMethod.POST , value="/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/searchdefault")
	public ResponseEntity<Page<PCMGXXKTEMPDTO>> searchPCMGXXKTEMPDefaultByPCMXKML(@PathVariable("pcmxkml_id") String pcmxkml_id, @RequestBody PCMGXXKTEMPSearchContext context) {
        context.setN_pcmxkmlid_eq(pcmxkml_id);
        Page<PCMGXXKTEMP> domains = pcmgxxktempService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmgxxktempMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
