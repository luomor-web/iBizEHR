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
import cn.ibizlab.ehr.core.pcm.domain.PCMZSGL;
import cn.ibizlab.ehr.core.pcm.service.IPCMZSGLService;
import cn.ibizlab.ehr.core.pcm.filter.PCMZSGLSearchContext;




@Slf4j
@Api(tags = {"PCMZSGL" })
@RestController("WebApi-pcmzsgl")
@RequestMapping("")
public class PCMZSGLResource {

    @Autowired
    private IPCMZSGLService pcmzsglService;

    @Autowired
    @Lazy
    private PCMZSGLMapping pcmzsglMapping;




    @PreAuthorize("hasPermission(#pcmzsgl_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"PCMZSGL" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmzsgls/{pcmzsgl_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmzsgl_id") String pcmzsgl_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmzsglService.remove(pcmzsgl_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMZSGL" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmzsgls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmzsglService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmzsgl_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMZSGL" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmzsgls/{pcmzsgl_id}")
    public ResponseEntity<PCMZSGLDTO> get(@PathVariable("pcmzsgl_id") String pcmzsgl_id) {
        PCMZSGL domain = pcmzsglService.get(pcmzsgl_id);
        PCMZSGLDTO dto = pcmzsglMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "GetDraft", tags = {"PCMZSGL" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmzsgls/getdraft")
    public ResponseEntity<PCMZSGLDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmzsglMapping.toDto(pcmzsglService.getDraft(new PCMZSGL())));
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMZSGL" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzsgls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMZSGLDTO pcmzsgldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmzsglService.checkKey(pcmzsglMapping.toDomain(pcmzsgldto)));
    }




    @PreAuthorize("hasPermission(#pcmzsgl_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMZSGL" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmzsgls/{pcmzsgl_id}")
    @Transactional
    public ResponseEntity<PCMZSGLDTO> update(@PathVariable("pcmzsgl_id") String pcmzsgl_id, @RequestBody PCMZSGLDTO pcmzsgldto) {
		PCMZSGL domain = pcmzsglMapping.toDomain(pcmzsgldto);
        domain.setPcmzsglid(pcmzsgl_id);
		pcmzsglService.update(domain);
		PCMZSGLDTO dto = pcmzsglMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmzsgl_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMZSGL" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmzsgls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMZSGLDTO> pcmzsgldtos) {
        pcmzsglService.updateBatch(pcmzsglMapping.toDomain(pcmzsgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "Save", tags = {"PCMZSGL" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzsgls/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMZSGLDTO pcmzsgldto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmzsglService.save(pcmzsglMapping.toDomain(pcmzsgldto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMZSGL" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzsgls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMZSGLDTO> pcmzsgldtos) {
        pcmzsglService.saveBatch(pcmzsglMapping.toDomain(pcmzsgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMZSGL" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzsgls")
    @Transactional
    public ResponseEntity<PCMZSGLDTO> create(@RequestBody PCMZSGLDTO pcmzsgldto) {
        PCMZSGL domain = pcmzsglMapping.toDomain(pcmzsgldto);
		pcmzsglService.create(domain);
        PCMZSGLDTO dto = pcmzsglMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMZSGL" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmzsgls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMZSGLDTO> pcmzsgldtos) {
        pcmzsglService.createBatch(pcmzsglMapping.toDomain(pcmzsgldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMZSGL-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMZSGL" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmzsgls/fetchdefault")
	public ResponseEntity<List<PCMZSGLDTO>> fetchDefault(PCMZSGLSearchContext context) {
        Page<PCMZSGL> domains = pcmzsglService.searchDefault(context) ;
        List<PCMZSGLDTO> list = pcmzsglMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMZSGL-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMZSGL" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmzsgls/searchdefault")
	public ResponseEntity<Page<PCMZSGLDTO>> searchDefault(@RequestBody PCMZSGLSearchContext context) {
        Page<PCMZSGL> domains = pcmzsglService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmzsglMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMZSGL getEntity(){
        return new PCMZSGL();
    }

}
