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
import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILEINITNUMBER;
import cn.ibizlab.ehr.core.pcm.service.IPCMPROFILEINITNUMBERService;
import cn.ibizlab.ehr.core.pcm.filter.PCMPROFILEINITNUMBERSearchContext;




@Slf4j
@Api(tags = {"PCMPROFILEINITNUMBER" })
@RestController("WebApi-pcmprofileinitnumber")
@RequestMapping("")
public class PCMPROFILEINITNUMBERResource {

    @Autowired
    private IPCMPROFILEINITNUMBERService pcmprofileinitnumberService;

    @Autowired
    @Lazy
    private PCMPROFILEINITNUMBERMapping pcmprofileinitnumberMapping;




    @PreAuthorize("hasPermission(#pcmprofileinitnumber_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"PCMPROFILEINITNUMBER" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofileinitnumbers/{pcmprofileinitnumber_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmprofileinitnumber_id") String pcmprofileinitnumber_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmprofileinitnumberService.remove(pcmprofileinitnumber_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMPROFILEINITNUMBER" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofileinitnumbers/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmprofileinitnumberService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PCMPROFILEINITNUMBER" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileinitnumbers/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMPROFILEINITNUMBERDTO pcmprofileinitnumberdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileinitnumberService.save(pcmprofileinitnumberMapping.toDomain(pcmprofileinitnumberdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMPROFILEINITNUMBER" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileinitnumbers/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMPROFILEINITNUMBERDTO> pcmprofileinitnumberdtos) {
        pcmprofileinitnumberService.saveBatch(pcmprofileinitnumberMapping.toDomain(pcmprofileinitnumberdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmprofileinitnumber_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMPROFILEINITNUMBER" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofileinitnumbers/{pcmprofileinitnumber_id}")
    @Transactional
    public ResponseEntity<PCMPROFILEINITNUMBERDTO> update(@PathVariable("pcmprofileinitnumber_id") String pcmprofileinitnumber_id, @RequestBody PCMPROFILEINITNUMBERDTO pcmprofileinitnumberdto) {
		PCMPROFILEINITNUMBER domain = pcmprofileinitnumberMapping.toDomain(pcmprofileinitnumberdto);
        domain.setPcmprofileinitnumberid(pcmprofileinitnumber_id);
		pcmprofileinitnumberService.update(domain);
		PCMPROFILEINITNUMBERDTO dto = pcmprofileinitnumberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmprofileinitnumber_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMPROFILEINITNUMBER" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofileinitnumbers/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMPROFILEINITNUMBERDTO> pcmprofileinitnumberdtos) {
        pcmprofileinitnumberService.updateBatch(pcmprofileinitnumberMapping.toDomain(pcmprofileinitnumberdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMPROFILEINITNUMBER" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileinitnumbers")
    @Transactional
    public ResponseEntity<PCMPROFILEINITNUMBERDTO> create(@RequestBody PCMPROFILEINITNUMBERDTO pcmprofileinitnumberdto) {
        PCMPROFILEINITNUMBER domain = pcmprofileinitnumberMapping.toDomain(pcmprofileinitnumberdto);
		pcmprofileinitnumberService.create(domain);
        PCMPROFILEINITNUMBERDTO dto = pcmprofileinitnumberMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMPROFILEINITNUMBER" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileinitnumbers/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMPROFILEINITNUMBERDTO> pcmprofileinitnumberdtos) {
        pcmprofileinitnumberService.createBatch(pcmprofileinitnumberMapping.toDomain(pcmprofileinitnumberdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmprofileinitnumber_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMPROFILEINITNUMBER" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofileinitnumbers/{pcmprofileinitnumber_id}")
    public ResponseEntity<PCMPROFILEINITNUMBERDTO> get(@PathVariable("pcmprofileinitnumber_id") String pcmprofileinitnumber_id) {
        PCMPROFILEINITNUMBER domain = pcmprofileinitnumberService.get(pcmprofileinitnumber_id);
        PCMPROFILEINITNUMBERDTO dto = pcmprofileinitnumberMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "GetDraft", tags = {"PCMPROFILEINITNUMBER" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofileinitnumbers/getdraft")
    public ResponseEntity<PCMPROFILEINITNUMBERDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofileinitnumberMapping.toDto(pcmprofileinitnumberService.getDraft(new PCMPROFILEINITNUMBER())));
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMPROFILEINITNUMBER" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofileinitnumbers/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMPROFILEINITNUMBERDTO pcmprofileinitnumberdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmprofileinitnumberService.checkKey(pcmprofileinitnumberMapping.toDomain(pcmprofileinitnumberdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILEINITNUMBER-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMPROFILEINITNUMBER" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofileinitnumbers/fetchdefault")
	public ResponseEntity<List<PCMPROFILEINITNUMBERDTO>> fetchDefault(PCMPROFILEINITNUMBERSearchContext context) {
        Page<PCMPROFILEINITNUMBER> domains = pcmprofileinitnumberService.searchDefault(context) ;
        List<PCMPROFILEINITNUMBERDTO> list = pcmprofileinitnumberMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILEINITNUMBER-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMPROFILEINITNUMBER" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofileinitnumbers/searchdefault")
	public ResponseEntity<Page<PCMPROFILEINITNUMBERDTO>> searchDefault(@RequestBody PCMPROFILEINITNUMBERSearchContext context) {
        Page<PCMPROFILEINITNUMBER> domains = pcmprofileinitnumberService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofileinitnumberMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMPROFILEINITNUMBER getEntity(){
        return new PCMPROFILEINITNUMBER();
    }

}
