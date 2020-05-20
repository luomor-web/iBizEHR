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
import cn.ibizlab.ehr.core.pcm.domain.PCMXYGZZJGWH;
import cn.ibizlab.ehr.core.pcm.service.IPCMXYGZZJGWHService;
import cn.ibizlab.ehr.core.pcm.filter.PCMXYGZZJGWHSearchContext;




@Slf4j
@Api(tags = {"PCMXYGZZJGWH" })
@RestController("WebApi-pcmxygzzjgwh")
@RequestMapping("")
public class PCMXYGZZJGWHResource {

    @Autowired
    private IPCMXYGZZJGWHService pcmxygzzjgwhService;

    @Autowired
    @Lazy
    private PCMXYGZZJGWHMapping pcmxygzzjgwhMapping;




    @ApiOperation(value = "GetDraft", tags = {"PCMXYGZZJGWH" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxygzzjgwhs/getdraft")
    public ResponseEntity<PCMXYGZZJGWHDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzjgwhMapping.toDto(pcmxygzzjgwhService.getDraft(new PCMXYGZZJGWH())));
    }




    @ApiOperation(value = "Save", tags = {"PCMXYGZZJGWH" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjgwhs/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMXYGZZJGWHDTO pcmxygzzjgwhdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzjgwhService.save(pcmxygzzjgwhMapping.toDomain(pcmxygzzjgwhdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMXYGZZJGWH" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjgwhs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMXYGZZJGWHDTO> pcmxygzzjgwhdtos) {
        pcmxygzzjgwhService.saveBatch(pcmxygzzjgwhMapping.toDomain(pcmxygzzjgwhdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmxygzzjgwh_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMXYGZZJGWH" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxygzzjgwhs/{pcmxygzzjgwh_id}")
    @Transactional
    public ResponseEntity<PCMXYGZZJGWHDTO> update(@PathVariable("pcmxygzzjgwh_id") String pcmxygzzjgwh_id, @RequestBody PCMXYGZZJGWHDTO pcmxygzzjgwhdto) {
		PCMXYGZZJGWH domain = pcmxygzzjgwhMapping.toDomain(pcmxygzzjgwhdto);
        domain.setPcmxygzzjgwhid(pcmxygzzjgwh_id);
		pcmxygzzjgwhService.update(domain);
		PCMXYGZZJGWHDTO dto = pcmxygzzjgwhMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmxygzzjgwh_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMXYGZZJGWH" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxygzzjgwhs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMXYGZZJGWHDTO> pcmxygzzjgwhdtos) {
        pcmxygzzjgwhService.updateBatch(pcmxygzzjgwhMapping.toDomain(pcmxygzzjgwhdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMXYGZZJGWH" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjgwhs")
    @Transactional
    public ResponseEntity<PCMXYGZZJGWHDTO> create(@RequestBody PCMXYGZZJGWHDTO pcmxygzzjgwhdto) {
        PCMXYGZZJGWH domain = pcmxygzzjgwhMapping.toDomain(pcmxygzzjgwhdto);
		pcmxygzzjgwhService.create(domain);
        PCMXYGZZJGWHDTO dto = pcmxygzzjgwhMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMXYGZZJGWH" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjgwhs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMXYGZZJGWHDTO> pcmxygzzjgwhdtos) {
        pcmxygzzjgwhService.createBatch(pcmxygzzjgwhMapping.toDomain(pcmxygzzjgwhdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMXYGZZJGWH" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzjgwhs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMXYGZZJGWHDTO pcmxygzzjgwhdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmxygzzjgwhService.checkKey(pcmxygzzjgwhMapping.toDomain(pcmxygzzjgwhdto)));
    }




    @PreAuthorize("hasPermission(#pcmxygzzjgwh_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"PCMXYGZZJGWH" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxygzzjgwhs/{pcmxygzzjgwh_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmxygzzjgwh_id") String pcmxygzzjgwh_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzjgwhService.remove(pcmxygzzjgwh_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMXYGZZJGWH" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxygzzjgwhs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmxygzzjgwhService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmxygzzjgwh_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMXYGZZJGWH" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxygzzjgwhs/{pcmxygzzjgwh_id}")
    public ResponseEntity<PCMXYGZZJGWHDTO> get(@PathVariable("pcmxygzzjgwh_id") String pcmxygzzjgwh_id) {
        PCMXYGZZJGWH domain = pcmxygzzjgwhService.get(pcmxygzzjgwh_id);
        PCMXYGZZJGWHDTO dto = pcmxygzzjgwhMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXYGZZJGWH-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMXYGZZJGWH" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxygzzjgwhs/fetchdefault")
	public ResponseEntity<List<PCMXYGZZJGWHDTO>> fetchDefault(PCMXYGZZJGWHSearchContext context) {
        Page<PCMXYGZZJGWH> domains = pcmxygzzjgwhService.searchDefault(context) ;
        List<PCMXYGZZJGWHDTO> list = pcmxygzzjgwhMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXYGZZJGWH-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMXYGZZJGWH" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmxygzzjgwhs/searchdefault")
	public ResponseEntity<Page<PCMXYGZZJGWHDTO>> searchDefault(@RequestBody PCMXYGZZJGWHSearchContext context) {
        Page<PCMXYGZZJGWH> domains = pcmxygzzjgwhService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmxygzzjgwhMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMXYGZZJGWH getEntity(){
        return new PCMXYGZZJGWH();
    }

}
