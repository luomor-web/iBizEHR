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
import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILEYJTJTEMP;
import cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEYJTJTEMPService;
import cn.ibizlab.ehr.core.pcm.filter.PCMPROFILEYJTJTEMPSearchContext;




@Slf4j
@Api(tags = {"PCMPROFILEYJTJTEMP" })
@RestController("WebApi-pcmprofileyjtjtemp")
@RequestMapping("")
public class PCMPROFILEYJTJTEMPResource {

    @Autowired
    private IPCMPROFILEYJTJTEMPService pcmprofileyjtjtempService;

    @Autowired
    @Lazy
    public PCMPROFILEYJTJTEMPMapping pcmprofileyjtjtempMapping;

    public PCMPROFILEYJTJTEMPDTO permissionDTO=new PCMPROFILEYJTJTEMPDTO();




    @PreAuthorize("hasPermission(#pcmprofileyjtjtemp_id,'Update',{'Sql',this.pcmprofileyjtjtempMapping,#pcmprofileyjtjtempdto})")
    @ApiOperation(value = "Update", tags = {"PCMPROFILEYJTJTEMP" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofileyjtjtemps/{pcmprofileyjtjtemp_id}")
    @Transactional
    public ResponseEntity<PCMPROFILEYJTJTEMPDTO> update(@PathVariable("pcmprofileyjtjtemp_id") String pcmprofileyjtjtemp_id, @RequestBody PCMPROFILEYJTJTEMPDTO pcmprofileyjtjtempdto) {
		PCMPROFILEYJTJTEMP domain = pcmprofileyjtjtempMapping.toDomain(pcmprofileyjtjtempdto);
        domain.setPcmprofileyjtjtempid(pcmprofileyjtjtemp_id);
		pcmprofileyjtjtempService.update(domain);
		PCMPROFILEYJTJTEMPDTO dto = pcmprofileyjtjtempMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"PCMPROFILEYJTJTEMP" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofileyjtjtemps/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMPROFILEYJTJTEMPDTO> pcmprofileyjtjtempdtos) {
        pcmprofileyjtjtempService.updateBatch(pcmprofileyjtjtempMapping.toDomain(pcmprofileyjtjtempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILEYJTJTEMP-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMPROFILEYJTJTEMP" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofileyjtjtemps/getdraft")
    public ResponseEntity<PCMPROFILEYJTJTEMPDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileyjtjtempMapping.toDto(pcmprofileyjtjtempService.getDraft(new PCMPROFILEYJTJTEMP())));
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmprofileyjtjtempMapping,#pcmprofileyjtjtempdto})")
    @ApiOperation(value = "Create", tags = {"PCMPROFILEYJTJTEMP" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileyjtjtemps")
    @Transactional
    public ResponseEntity<PCMPROFILEYJTJTEMPDTO> create(@RequestBody PCMPROFILEYJTJTEMPDTO pcmprofileyjtjtempdto) {
        PCMPROFILEYJTJTEMP domain = pcmprofileyjtjtempMapping.toDomain(pcmprofileyjtjtempdto);
		pcmprofileyjtjtempService.create(domain);
        PCMPROFILEYJTJTEMPDTO dto = pcmprofileyjtjtempMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"PCMPROFILEYJTJTEMP" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileyjtjtemps/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMPROFILEYJTJTEMPDTO> pcmprofileyjtjtempdtos) {
        pcmprofileyjtjtempService.createBatch(pcmprofileyjtjtempMapping.toDomain(pcmprofileyjtjtempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILEYJTJTEMP-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMPROFILEYJTJTEMP" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileyjtjtemps/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMPROFILEYJTJTEMPDTO pcmprofileyjtjtempdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmprofileyjtjtempService.checkKey(pcmprofileyjtjtempMapping.toDomain(pcmprofileyjtjtempdto)));
    }




    @PreAuthorize("hasPermission(#pcmprofileyjtjtemp_id,'Remove',{'Sql',this.pcmprofileyjtjtempMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMPROFILEYJTJTEMP" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofileyjtjtemps/{pcmprofileyjtjtemp_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmprofileyjtjtemp_id") String pcmprofileyjtjtemp_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmprofileyjtjtempService.remove(pcmprofileyjtjtemp_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMPROFILEYJTJTEMP" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofileyjtjtemps/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmprofileyjtjtempService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILEYJTJTEMP-Save-all')")
    @ApiOperation(value = "Save", tags = {"PCMPROFILEYJTJTEMP" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileyjtjtemps/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMPROFILEYJTJTEMPDTO pcmprofileyjtjtempdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileyjtjtempService.save(pcmprofileyjtjtempMapping.toDomain(pcmprofileyjtjtempdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMPROFILEYJTJTEMP" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileyjtjtemps/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMPROFILEYJTJTEMPDTO> pcmprofileyjtjtempdtos) {
        pcmprofileyjtjtempService.saveBatch(pcmprofileyjtjtempMapping.toDomain(pcmprofileyjtjtempdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmprofileyjtjtemp_id,'Get',{'Sql',this.pcmprofileyjtjtempMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMPROFILEYJTJTEMP" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofileyjtjtemps/{pcmprofileyjtjtemp_id}")
    public ResponseEntity<PCMPROFILEYJTJTEMPDTO> get(@PathVariable("pcmprofileyjtjtemp_id") String pcmprofileyjtjtemp_id) {
        PCMPROFILEYJTJTEMP domain = pcmprofileyjtjtempService.get(pcmprofileyjtjtemp_id);
        PCMPROFILEYJTJTEMPDTO dto = pcmprofileyjtjtempMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILEYJTJTEMP-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMPROFILEYJTJTEMP" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofileyjtjtemps/fetchdefault")
	public ResponseEntity<List<PCMPROFILEYJTJTEMPDTO>> fetchDefault(PCMPROFILEYJTJTEMPSearchContext context) {
        Page<PCMPROFILEYJTJTEMP> domains = pcmprofileyjtjtempService.searchDefault(context) ;
        List<PCMPROFILEYJTJTEMPDTO> list = pcmprofileyjtjtempMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILEYJTJTEMP-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMPROFILEYJTJTEMP" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofileyjtjtemps/searchdefault")
	public ResponseEntity<Page<PCMPROFILEYJTJTEMPDTO>> searchDefault(@RequestBody PCMPROFILEYJTJTEMPSearchContext context) {
        Page<PCMPROFILEYJTJTEMP> domains = pcmprofileyjtjtempService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileyjtjtempMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


