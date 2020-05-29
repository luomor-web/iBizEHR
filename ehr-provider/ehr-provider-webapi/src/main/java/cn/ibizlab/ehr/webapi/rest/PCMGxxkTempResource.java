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
import cn.ibizlab.ehr.core.pcm.domain.PCMGxxkTemp;
import cn.ibizlab.ehr.core.pcm.service.IPCMGxxkTempService;
import cn.ibizlab.ehr.core.pcm.filter.PCMGxxkTempSearchContext;

@Slf4j
@Api(tags = {"PCMGxxkTemp" })
@RestController("WebApi-pcmgxxktemp")
@RequestMapping("")
public class PCMGxxkTempResource {

    @Autowired
    public IPCMGxxkTempService pcmgxxktempService;

    @Autowired
    @Lazy
    public PCMGxxkTempMapping pcmgxxktempMapping;

    @ApiOperation(value = "GetDraft", tags = {"PCMGxxkTemp" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmgxxktemps/getdraft")
    public ResponseEntity<PCMGxxkTempDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempMapping.toDto(pcmgxxktempService.getDraft(new PCMGxxkTemp())));
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdto),'ehr-PCMGxxkTemp-Create')")
    @ApiOperation(value = "Create", tags = {"PCMGxxkTemp" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxxktemps")
    @Transactional
    public ResponseEntity<PCMGxxkTempDTO> create(@RequestBody PCMGxxkTempDTO pcmgxxktempdto) {
        PCMGxxkTemp domain = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
		pcmgxxktempService.create(domain);
        PCMGxxkTempDTO dto = pcmgxxktempMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdtos),'ehr-PCMGxxkTemp-Create')")
    @ApiOperation(value = "createBatch", tags = {"PCMGxxkTemp" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMGxxkTempDTO> pcmgxxktempdtos) {
        pcmgxxktempService.createBatch(pcmgxxktempMapping.toDomain(pcmgxxktempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempService.get(#pcmgxxktemp_id),'ehr-PCMGxxkTemp-Remove')")
    @ApiOperation(value = "Remove", tags = {"PCMGxxkTemp" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmgxxktemps/{pcmgxxktemp_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.remove(pcmgxxktemp_id));
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempService.getPcmgxxktempByIds(#ids),'ehr-PCMGxxkTemp-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMGxxkTemp" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmgxxktempService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKey", tags = {"PCMGxxkTemp" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxxktemps/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMGxxkTempDTO pcmgxxktempdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.checkKey(pcmgxxktempMapping.toDomain(pcmgxxktempdto)));
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdto),'ehr-PCMGxxkTemp-Save')")
    @ApiOperation(value = "Save", tags = {"PCMGxxkTemp" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxxktemps/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMGxxkTempDTO pcmgxxktempdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.save(pcmgxxktempMapping.toDomain(pcmgxxktempdto)));
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdtos),'ehr-PCMGxxkTemp-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PCMGxxkTemp" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxxktemps/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMGxxkTempDTO> pcmgxxktempdtos) {
        pcmgxxktempService.saveBatch(pcmgxxktempMapping.toDomain(pcmgxxktempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(returnObject.body),'ehr-PCMGxxkTemp-Get')")
    @ApiOperation(value = "Get", tags = {"PCMGxxkTemp" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmgxxktemps/{pcmgxxktemp_id}")
    public ResponseEntity<PCMGxxkTempDTO> get(@PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id) {
        PCMGxxkTemp domain = pcmgxxktempService.get(pcmgxxktemp_id);
        PCMGxxkTempDTO dto = pcmgxxktempMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempService.get(#pcmgxxktemp_id),'ehr-PCMGxxkTemp-Update')")
    @ApiOperation(value = "Update", tags = {"PCMGxxkTemp" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmgxxktemps/{pcmgxxktemp_id}")
    @Transactional
    public ResponseEntity<PCMGxxkTempDTO> update(@PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id, @RequestBody PCMGxxkTempDTO pcmgxxktempdto) {
		PCMGxxkTemp domain  = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
        domain .setPcmgxxktempid(pcmgxxktemp_id);
		pcmgxxktempService.update(domain );
		PCMGxxkTempDTO dto = pcmgxxktempMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempService.getPcmgxxktempByEntities(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdtos)),'ehr-PCMGxxkTemp-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMGxxkTemp" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMGxxkTempDTO> pcmgxxktempdtos) {
        pcmgxxktempService.updateBatch(pcmgxxktempMapping.toDomain(pcmgxxktempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGxxkTemp-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMGxxkTemp" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmgxxktemps/fetchdefault")
	public ResponseEntity<List<PCMGxxkTempDTO>> fetchDefault(PCMGxxkTempSearchContext context) {
        Page<PCMGxxkTemp> domains = pcmgxxktempService.searchDefault(context) ;
        List<PCMGxxkTempDTO> list = pcmgxxktempMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGxxkTemp-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMGxxkTemp" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmgxxktemps/searchdefault")
	public ResponseEntity<Page<PCMGxxkTempDTO>> searchDefault(@RequestBody PCMGxxkTempSearchContext context) {
        Page<PCMGxxkTemp> domains = pcmgxxktempService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmgxxktempMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "GetDraftByPcmGxml", tags = {"PCMGxxkTemp" },  notes = "GetDraftByPcmGxml")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/getdraft")
    public ResponseEntity<PCMGxxkTempDTO> getDraftByPcmGxml(@PathVariable("pcmgxml_id") String pcmgxml_id) {
        PCMGxxkTemp domain = new PCMGxxkTemp();
        domain.setPcmgxmlid(pcmgxml_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempMapping.toDto(pcmgxxktempService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdto),'ehr-PCMGxxkTemp-Create')")
    @ApiOperation(value = "CreateByPcmGxml", tags = {"PCMGxxkTemp" },  notes = "CreateByPcmGxml")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps")
    @Transactional
    public ResponseEntity<PCMGxxkTempDTO> createByPcmGxml(@PathVariable("pcmgxml_id") String pcmgxml_id, @RequestBody PCMGxxkTempDTO pcmgxxktempdto) {
        PCMGxxkTemp domain = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
        domain.setPcmgxmlid(pcmgxml_id);
		pcmgxxktempService.create(domain);
        PCMGxxkTempDTO dto = pcmgxxktempMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdtos),'ehr-PCMGxxkTemp-Create')")
    @ApiOperation(value = "createBatchByPcmGxml", tags = {"PCMGxxkTemp" },  notes = "createBatchByPcmGxml")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> createBatchByPcmGxml(@PathVariable("pcmgxml_id") String pcmgxml_id, @RequestBody List<PCMGxxkTempDTO> pcmgxxktempdtos) {
        List<PCMGxxkTemp> domainlist=pcmgxxktempMapping.toDomain(pcmgxxktempdtos);
        for(PCMGxxkTemp domain:domainlist){
            domain.setPcmgxmlid(pcmgxml_id);
        }
        pcmgxxktempService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempService.get(#pcmgxxktemp_id),'ehr-PCMGxxkTemp-Remove')")
    @ApiOperation(value = "RemoveByPcmGxml", tags = {"PCMGxxkTemp" },  notes = "RemoveByPcmGxml")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/{pcmgxxktemp_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPcmGxml(@PathVariable("pcmgxml_id") String pcmgxml_id, @PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.remove(pcmgxxktemp_id));
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempService.getPcmgxxktempByIds(#ids),'ehr-PCMGxxkTemp-Remove')")
    @ApiOperation(value = "RemoveBatchByPcmGxml", tags = {"PCMGxxkTemp" },  notes = "RemoveBatchByPcmGxml")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> removeBatchByPcmGxml(@RequestBody List<String> ids) {
        pcmgxxktempService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByPcmGxml", tags = {"PCMGxxkTemp" },  notes = "CheckKeyByPcmGxml")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/checkkey")
    public ResponseEntity<Boolean> checkKeyByPcmGxml(@PathVariable("pcmgxml_id") String pcmgxml_id, @RequestBody PCMGxxkTempDTO pcmgxxktempdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.checkKey(pcmgxxktempMapping.toDomain(pcmgxxktempdto)));
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdto),'ehr-PCMGxxkTemp-Save')")
    @ApiOperation(value = "SaveByPcmGxml", tags = {"PCMGxxkTemp" },  notes = "SaveByPcmGxml")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/save")
    public ResponseEntity<Boolean> saveByPcmGxml(@PathVariable("pcmgxml_id") String pcmgxml_id, @RequestBody PCMGxxkTempDTO pcmgxxktempdto) {
        PCMGxxkTemp domain = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
        domain.setPcmgxmlid(pcmgxml_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdtos),'ehr-PCMGxxkTemp-Save')")
    @ApiOperation(value = "SaveBatchByPcmGxml", tags = {"PCMGxxkTemp" },  notes = "SaveBatchByPcmGxml")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/savebatch")
    public ResponseEntity<Boolean> saveBatchByPcmGxml(@PathVariable("pcmgxml_id") String pcmgxml_id, @RequestBody List<PCMGxxkTempDTO> pcmgxxktempdtos) {
        List<PCMGxxkTemp> domainlist=pcmgxxktempMapping.toDomain(pcmgxxktempdtos);
        for(PCMGxxkTemp domain:domainlist){
             domain.setPcmgxmlid(pcmgxml_id);
        }
        pcmgxxktempService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(returnObject.body),'ehr-PCMGxxkTemp-Get')")
    @ApiOperation(value = "GetByPcmGxml", tags = {"PCMGxxkTemp" },  notes = "GetByPcmGxml")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/{pcmgxxktemp_id}")
    public ResponseEntity<PCMGxxkTempDTO> getByPcmGxml(@PathVariable("pcmgxml_id") String pcmgxml_id, @PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id) {
        PCMGxxkTemp domain = pcmgxxktempService.get(pcmgxxktemp_id);
        PCMGxxkTempDTO dto = pcmgxxktempMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempService.get(#pcmgxxktemp_id),'ehr-PCMGxxkTemp-Update')")
    @ApiOperation(value = "UpdateByPcmGxml", tags = {"PCMGxxkTemp" },  notes = "UpdateByPcmGxml")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/{pcmgxxktemp_id}")
    @Transactional
    public ResponseEntity<PCMGxxkTempDTO> updateByPcmGxml(@PathVariable("pcmgxml_id") String pcmgxml_id, @PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id, @RequestBody PCMGxxkTempDTO pcmgxxktempdto) {
        PCMGxxkTemp domain = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
        domain.setPcmgxmlid(pcmgxml_id);
        domain.setPcmgxxktempid(pcmgxxktemp_id);
		pcmgxxktempService.update(domain);
        PCMGxxkTempDTO dto = pcmgxxktempMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempService.getPcmgxxktempByEntities(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdtos)),'ehr-PCMGxxkTemp-Update')")
    @ApiOperation(value = "UpdateBatchByPcmGxml", tags = {"PCMGxxkTemp" },  notes = "UpdateBatchByPcmGxml")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> updateBatchByPcmGxml(@PathVariable("pcmgxml_id") String pcmgxml_id, @RequestBody List<PCMGxxkTempDTO> pcmgxxktempdtos) {
        List<PCMGxxkTemp> domainlist=pcmgxxktempMapping.toDomain(pcmgxxktempdtos);
        for(PCMGxxkTemp domain:domainlist){
            domain.setPcmgxmlid(pcmgxml_id);
        }
        pcmgxxktempService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGxxkTemp-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPcmGxml", tags = {"PCMGxxkTemp" } ,notes = "fetchDEFAULTByPcmGxml")
    @RequestMapping(method= RequestMethod.GET , value="/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/fetchdefault")
	public ResponseEntity<List<PCMGxxkTempDTO>> fetchPCMGxxkTempDefaultByPcmGxml(@PathVariable("pcmgxml_id") String pcmgxml_id,PCMGxxkTempSearchContext context) {
        context.setN_pcmgxmlid_eq(pcmgxml_id);
        Page<PCMGxxkTemp> domains = pcmgxxktempService.searchDefault(context) ;
        List<PCMGxxkTempDTO> list = pcmgxxktempMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGxxkTemp-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPcmGxml", tags = {"PCMGxxkTemp" } ,notes = "searchDEFAULTByPcmGxml")
    @RequestMapping(method= RequestMethod.POST , value="/pcmgxmls/{pcmgxml_id}/pcmgxxktemps/searchdefault")
	public ResponseEntity<Page<PCMGxxkTempDTO>> searchPCMGxxkTempDefaultByPcmGxml(@PathVariable("pcmgxml_id") String pcmgxml_id, @RequestBody PCMGxxkTempSearchContext context) {
        context.setN_pcmgxmlid_eq(pcmgxml_id);
        Page<PCMGxxkTemp> domains = pcmgxxktempService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmgxxktempMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @ApiOperation(value = "GetDraftByPCMXKML", tags = {"PCMGxxkTemp" },  notes = "GetDraftByPCMXKML")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/getdraft")
    public ResponseEntity<PCMGxxkTempDTO> getDraftByPCMXKML(@PathVariable("pcmxkml_id") String pcmxkml_id) {
        PCMGxxkTemp domain = new PCMGxxkTemp();
        domain.setPcmxkmlid(pcmxkml_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempMapping.toDto(pcmgxxktempService.getDraft(domain)));
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdto),'ehr-PCMGxxkTemp-Create')")
    @ApiOperation(value = "CreateByPCMXKML", tags = {"PCMGxxkTemp" },  notes = "CreateByPCMXKML")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps")
    @Transactional
    public ResponseEntity<PCMGxxkTempDTO> createByPCMXKML(@PathVariable("pcmxkml_id") String pcmxkml_id, @RequestBody PCMGxxkTempDTO pcmgxxktempdto) {
        PCMGxxkTemp domain = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
        domain.setPcmxkmlid(pcmxkml_id);
		pcmgxxktempService.create(domain);
        PCMGxxkTempDTO dto = pcmgxxktempMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdtos),'ehr-PCMGxxkTemp-Create')")
    @ApiOperation(value = "createBatchByPCMXKML", tags = {"PCMGxxkTemp" },  notes = "createBatchByPCMXKML")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> createBatchByPCMXKML(@PathVariable("pcmxkml_id") String pcmxkml_id, @RequestBody List<PCMGxxkTempDTO> pcmgxxktempdtos) {
        List<PCMGxxkTemp> domainlist=pcmgxxktempMapping.toDomain(pcmgxxktempdtos);
        for(PCMGxxkTemp domain:domainlist){
            domain.setPcmxkmlid(pcmxkml_id);
        }
        pcmgxxktempService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempService.get(#pcmgxxktemp_id),'ehr-PCMGxxkTemp-Remove')")
    @ApiOperation(value = "RemoveByPCMXKML", tags = {"PCMGxxkTemp" },  notes = "RemoveByPCMXKML")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/{pcmgxxktemp_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPCMXKML(@PathVariable("pcmxkml_id") String pcmxkml_id, @PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.remove(pcmgxxktemp_id));
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempService.getPcmgxxktempByIds(#ids),'ehr-PCMGxxkTemp-Remove')")
    @ApiOperation(value = "RemoveBatchByPCMXKML", tags = {"PCMGxxkTemp" },  notes = "RemoveBatchByPCMXKML")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> removeBatchByPCMXKML(@RequestBody List<String> ids) {
        pcmgxxktempService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "CheckKeyByPCMXKML", tags = {"PCMGxxkTemp" },  notes = "CheckKeyByPCMXKML")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/checkkey")
    public ResponseEntity<Boolean> checkKeyByPCMXKML(@PathVariable("pcmxkml_id") String pcmxkml_id, @RequestBody PCMGxxkTempDTO pcmgxxktempdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.checkKey(pcmgxxktempMapping.toDomain(pcmgxxktempdto)));
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdto),'ehr-PCMGxxkTemp-Save')")
    @ApiOperation(value = "SaveByPCMXKML", tags = {"PCMGxxkTemp" },  notes = "SaveByPCMXKML")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/save")
    public ResponseEntity<Boolean> saveByPCMXKML(@PathVariable("pcmxkml_id") String pcmxkml_id, @RequestBody PCMGxxkTempDTO pcmgxxktempdto) {
        PCMGxxkTemp domain = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
        domain.setPcmxkmlid(pcmxkml_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmgxxktempService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdtos),'ehr-PCMGxxkTemp-Save')")
    @ApiOperation(value = "SaveBatchByPCMXKML", tags = {"PCMGxxkTemp" },  notes = "SaveBatchByPCMXKML")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/savebatch")
    public ResponseEntity<Boolean> saveBatchByPCMXKML(@PathVariable("pcmxkml_id") String pcmxkml_id, @RequestBody List<PCMGxxkTempDTO> pcmgxxktempdtos) {
        List<PCMGxxkTemp> domainlist=pcmgxxktempMapping.toDomain(pcmgxxktempdtos);
        for(PCMGxxkTemp domain:domainlist){
             domain.setPcmxkmlid(pcmxkml_id);
        }
        pcmgxxktempService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmgxxktempMapping.toDomain(returnObject.body),'ehr-PCMGxxkTemp-Get')")
    @ApiOperation(value = "GetByPCMXKML", tags = {"PCMGxxkTemp" },  notes = "GetByPCMXKML")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/{pcmgxxktemp_id}")
    public ResponseEntity<PCMGxxkTempDTO> getByPCMXKML(@PathVariable("pcmxkml_id") String pcmxkml_id, @PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id) {
        PCMGxxkTemp domain = pcmgxxktempService.get(pcmgxxktemp_id);
        PCMGxxkTempDTO dto = pcmgxxktempMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempService.get(#pcmgxxktemp_id),'ehr-PCMGxxkTemp-Update')")
    @ApiOperation(value = "UpdateByPCMXKML", tags = {"PCMGxxkTemp" },  notes = "UpdateByPCMXKML")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/{pcmgxxktemp_id}")
    @Transactional
    public ResponseEntity<PCMGxxkTempDTO> updateByPCMXKML(@PathVariable("pcmxkml_id") String pcmxkml_id, @PathVariable("pcmgxxktemp_id") String pcmgxxktemp_id, @RequestBody PCMGxxkTempDTO pcmgxxktempdto) {
        PCMGxxkTemp domain = pcmgxxktempMapping.toDomain(pcmgxxktempdto);
        domain.setPcmxkmlid(pcmxkml_id);
        domain.setPcmgxxktempid(pcmgxxktemp_id);
		pcmgxxktempService.update(domain);
        PCMGxxkTempDTO dto = pcmgxxktempMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmgxxktempService.getPcmgxxktempByEntities(this.pcmgxxktempMapping.toDomain(#pcmgxxktempdtos)),'ehr-PCMGxxkTemp-Update')")
    @ApiOperation(value = "UpdateBatchByPCMXKML", tags = {"PCMGxxkTemp" },  notes = "UpdateBatchByPCMXKML")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/batch")
    public ResponseEntity<Boolean> updateBatchByPCMXKML(@PathVariable("pcmxkml_id") String pcmxkml_id, @RequestBody List<PCMGxxkTempDTO> pcmgxxktempdtos) {
        List<PCMGxxkTemp> domainlist=pcmgxxktempMapping.toDomain(pcmgxxktempdtos);
        for(PCMGxxkTemp domain:domainlist){
            domain.setPcmxkmlid(pcmxkml_id);
        }
        pcmgxxktempService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGxxkTemp-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPCMXKML", tags = {"PCMGxxkTemp" } ,notes = "fetchDEFAULTByPCMXKML")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/fetchdefault")
	public ResponseEntity<List<PCMGxxkTempDTO>> fetchPCMGxxkTempDefaultByPCMXKML(@PathVariable("pcmxkml_id") String pcmxkml_id,PCMGxxkTempSearchContext context) {
        context.setN_pcmxkmlid_eq(pcmxkml_id);
        Page<PCMGxxkTemp> domains = pcmgxxktempService.searchDefault(context) ;
        List<PCMGxxkTempDTO> list = pcmgxxktempMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMGxxkTemp-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPCMXKML", tags = {"PCMGxxkTemp" } ,notes = "searchDEFAULTByPCMXKML")
    @RequestMapping(method= RequestMethod.POST , value="/pcmxkmls/{pcmxkml_id}/pcmgxxktemps/searchdefault")
	public ResponseEntity<Page<PCMGxxkTempDTO>> searchPCMGxxkTempDefaultByPCMXKML(@PathVariable("pcmxkml_id") String pcmxkml_id, @RequestBody PCMGxxkTempSearchContext context) {
        context.setN_pcmxkmlid_eq(pcmxkml_id);
        Page<PCMGxxkTemp> domains = pcmgxxktempService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmgxxktempMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

