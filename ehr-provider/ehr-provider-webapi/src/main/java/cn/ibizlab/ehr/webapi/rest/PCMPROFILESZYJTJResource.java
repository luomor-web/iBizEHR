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
import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILESZYJTJ;
import cn.ibizlab.ehr.core.pcm.service.IPCMPROFILESZYJTJService;
import cn.ibizlab.ehr.core.pcm.filter.PCMPROFILESZYJTJSearchContext;




@Slf4j
@Api(tags = {"PCMPROFILESZYJTJ" })
@RestController("WebApi-pcmprofileszyjtj")
@RequestMapping("")
public class PCMPROFILESZYJTJResource {

    @Autowired
    private IPCMPROFILESZYJTJService pcmprofileszyjtjService;

    @Autowired
    @Lazy
    public PCMPROFILESZYJTJMapping pcmprofileszyjtjMapping;

    public PCMPROFILESZYJTJDTO permissionDTO=new PCMPROFILESZYJTJDTO();




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILESZYJTJ-Save-all')")
    @ApiOperation(value = "Save", tags = {"PCMPROFILESZYJTJ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileszyjtjs/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMPROFILESZYJTJDTO pcmprofileszyjtjdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileszyjtjService.save(pcmprofileszyjtjMapping.toDomain(pcmprofileszyjtjdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMPROFILESZYJTJ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileszyjtjs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMPROFILESZYJTJDTO> pcmprofileszyjtjdtos) {
        pcmprofileszyjtjService.saveBatch(pcmprofileszyjtjMapping.toDomain(pcmprofileszyjtjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmprofileszyjtjMapping,#pcmprofileszyjtjdto})")
    @ApiOperation(value = "Create", tags = {"PCMPROFILESZYJTJ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileszyjtjs")
    @Transactional
    public ResponseEntity<PCMPROFILESZYJTJDTO> create(@RequestBody PCMPROFILESZYJTJDTO pcmprofileszyjtjdto) {
        PCMPROFILESZYJTJ domain = pcmprofileszyjtjMapping.toDomain(pcmprofileszyjtjdto);
		pcmprofileszyjtjService.create(domain);
        PCMPROFILESZYJTJDTO dto = pcmprofileszyjtjMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"PCMPROFILESZYJTJ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileszyjtjs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMPROFILESZYJTJDTO> pcmprofileszyjtjdtos) {
        pcmprofileszyjtjService.createBatch(pcmprofileszyjtjMapping.toDomain(pcmprofileszyjtjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILESZYJTJ-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMPROFILESZYJTJ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofileszyjtjs/getdraft")
    public ResponseEntity<PCMPROFILESZYJTJDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileszyjtjMapping.toDto(pcmprofileszyjtjService.getDraft(new PCMPROFILESZYJTJ())));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILESZYJTJ-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMPROFILESZYJTJ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileszyjtjs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMPROFILESZYJTJDTO pcmprofileszyjtjdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmprofileszyjtjService.checkKey(pcmprofileszyjtjMapping.toDomain(pcmprofileszyjtjdto)));
    }




    @PreAuthorize("hasPermission(#pcmprofileszyjtj_id,'Remove',{'Sql',this.pcmprofileszyjtjMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMPROFILESZYJTJ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofileszyjtjs/{pcmprofileszyjtj_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmprofileszyjtj_id") String pcmprofileszyjtj_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmprofileszyjtjService.remove(pcmprofileszyjtj_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMPROFILESZYJTJ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofileszyjtjs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmprofileszyjtjService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmprofileszyjtj_id,'Get',{'Sql',this.pcmprofileszyjtjMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMPROFILESZYJTJ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofileszyjtjs/{pcmprofileszyjtj_id}")
    public ResponseEntity<PCMPROFILESZYJTJDTO> get(@PathVariable("pcmprofileszyjtj_id") String pcmprofileszyjtj_id) {
        PCMPROFILESZYJTJ domain = pcmprofileszyjtjService.get(pcmprofileszyjtj_id);
        PCMPROFILESZYJTJDTO dto = pcmprofileszyjtjMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission(#pcmprofileszyjtj_id,'Update',{'Sql',this.pcmprofileszyjtjMapping,#pcmprofileszyjtjdto})")
    @ApiOperation(value = "Update", tags = {"PCMPROFILESZYJTJ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofileszyjtjs/{pcmprofileszyjtj_id}")
    @Transactional
    public ResponseEntity<PCMPROFILESZYJTJDTO> update(@PathVariable("pcmprofileszyjtj_id") String pcmprofileszyjtj_id, @RequestBody PCMPROFILESZYJTJDTO pcmprofileszyjtjdto) {
		PCMPROFILESZYJTJ domain = pcmprofileszyjtjMapping.toDomain(pcmprofileszyjtjdto);
        domain.setPcmprofileszyjtjid(pcmprofileszyjtj_id);
		pcmprofileszyjtjService.update(domain);
		PCMPROFILESZYJTJDTO dto = pcmprofileszyjtjMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"PCMPROFILESZYJTJ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofileszyjtjs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMPROFILESZYJTJDTO> pcmprofileszyjtjdtos) {
        pcmprofileszyjtjService.updateBatch(pcmprofileszyjtjMapping.toDomain(pcmprofileszyjtjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILESZYJTJ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMPROFILESZYJTJ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofileszyjtjs/fetchdefault")
	public ResponseEntity<List<PCMPROFILESZYJTJDTO>> fetchDefault(PCMPROFILESZYJTJSearchContext context) {
        Page<PCMPROFILESZYJTJ> domains = pcmprofileszyjtjService.searchDefault(context) ;
        List<PCMPROFILESZYJTJDTO> list = pcmprofileszyjtjMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILESZYJTJ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMPROFILESZYJTJ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofileszyjtjs/searchdefault")
	public ResponseEntity<Page<PCMPROFILESZYJTJDTO>> searchDefault(@RequestBody PCMPROFILESZYJTJSearchContext context) {
        Page<PCMPROFILESZYJTJ> domains = pcmprofileszyjtjService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileszyjtjMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILESZYJTJ-YGLX-all')")
	@ApiOperation(value = "fetch通过申报类型过滤", tags = {"PCMPROFILESZYJTJ" } ,notes = "fetch通过申报类型过滤")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofileszyjtjs/fetchyglx")
	public ResponseEntity<List<PCMPROFILESZYJTJDTO>> fetchYGLX(PCMPROFILESZYJTJSearchContext context) {
        Page<PCMPROFILESZYJTJ> domains = pcmprofileszyjtjService.searchYGLX(context) ;
        List<PCMPROFILESZYJTJDTO> list = pcmprofileszyjtjMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILESZYJTJ-YGLX-all')")
	@ApiOperation(value = "search通过申报类型过滤", tags = {"PCMPROFILESZYJTJ" } ,notes = "search通过申报类型过滤")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofileszyjtjs/searchyglx")
	public ResponseEntity<Page<PCMPROFILESZYJTJDTO>> searchYGLX(@RequestBody PCMPROFILESZYJTJSearchContext context) {
        Page<PCMPROFILESZYJTJ> domains = pcmprofileszyjtjService.searchYGLX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileszyjtjMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


