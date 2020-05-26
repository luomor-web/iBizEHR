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
import cn.ibizlab.ehr.core.pcm.domain.PCMJXSYGZZSQMX;
import cn.ibizlab.ehr.core.pcm.service.IPCMJXSYGZZSQMXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMJXSYGZZSQMXSearchContext;

@Slf4j
@Api(tags = {"PCMJXSYGZZSQMX" })
@RestController("WebApi-pcmjxsygzzsqmx")
@RequestMapping("")
public class PCMJXSYGZZSQMXResource {

    @Autowired
    private IPCMJXSYGZZSQMXService pcmjxsygzzsqmxService;

    @Autowired
    @Lazy
    public PCMJXSYGZZSQMXMapping pcmjxsygzzsqmxMapping;

    public PCMJXSYGZZSQMXDTO permissionDTO=new PCMJXSYGZZSQMXDTO();

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmjxsygzzsqmxMapping,#pcmjxsygzzsqmxdto})")
    @ApiOperation(value = "Create", tags = {"PCMJXSYGZZSQMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzsqmxes")
    @Transactional
    public ResponseEntity<PCMJXSYGZZSQMXDTO> create(@RequestBody PCMJXSYGZZSQMXDTO pcmjxsygzzsqmxdto) {
        PCMJXSYGZZSQMX domain = pcmjxsygzzsqmxMapping.toDomain(pcmjxsygzzsqmxdto);
		pcmjxsygzzsqmxService.create(domain);
        PCMJXSYGZZSQMXDTO dto = pcmjxsygzzsqmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.pcmjxsygzzsqmxMapping,#pcmjxsygzzsqmxdtos})")
    @ApiOperation(value = "createBatch", tags = {"PCMJXSYGZZSQMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzsqmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMJXSYGZZSQMXDTO> pcmjxsygzzsqmxdtos) {
        pcmjxsygzzsqmxService.createBatch(pcmjxsygzzsqmxMapping.toDomain(pcmjxsygzzsqmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('','Save',{'Sql',this.pcmjxsygzzsqmxMapping,#pcmjxsygzzsqmxdto})")
    @ApiOperation(value = "Save", tags = {"PCMJXSYGZZSQMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzsqmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMJXSYGZZSQMXDTO pcmjxsygzzsqmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzsqmxService.save(pcmjxsygzzsqmxMapping.toDomain(pcmjxsygzzsqmxdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.pcmjxsygzzsqmxMapping,#pcmjxsygzzsqmxdtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PCMJXSYGZZSQMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzsqmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMJXSYGZZSQMXDTO> pcmjxsygzzsqmxdtos) {
        pcmjxsygzzsqmxService.saveBatch(pcmjxsygzzsqmxMapping.toDomain(pcmjxsygzzsqmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSYGZZSQMX-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMJXSYGZZSQMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxsygzzsqmxes/getdraft")
    public ResponseEntity<PCMJXSYGZZSQMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzsqmxMapping.toDto(pcmjxsygzzsqmxService.getDraft(new PCMJXSYGZZSQMX())));
    }

    @PreAuthorize("hasPermission(#pcmjxsygzzsqmx_id,'Update',{'Sql',this.pcmjxsygzzsqmxMapping,#pcmjxsygzzsqmxdto})")
    @ApiOperation(value = "Update", tags = {"PCMJXSYGZZSQMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxsygzzsqmxes/{pcmjxsygzzsqmx_id}")
    @Transactional
    public ResponseEntity<PCMJXSYGZZSQMXDTO> update(@PathVariable("pcmjxsygzzsqmx_id") String pcmjxsygzzsqmx_id, @RequestBody PCMJXSYGZZSQMXDTO pcmjxsygzzsqmxdto) {
		PCMJXSYGZZSQMX domain  = pcmjxsygzzsqmxMapping.toDomain(pcmjxsygzzsqmxdto);
        domain .setPcmjxsygzzsqmxid(pcmjxsygzzsqmx_id);
		pcmjxsygzzsqmxService.update(domain );
		PCMJXSYGZZSQMXDTO dto = pcmjxsygzzsqmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.pcmjxsygzzsqmxMapping,#pcmjxsygzzsqmxdtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMJXSYGZZSQMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxsygzzsqmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMJXSYGZZSQMXDTO> pcmjxsygzzsqmxdtos) {
        pcmjxsygzzsqmxService.updateBatch(pcmjxsygzzsqmxMapping.toDomain(pcmjxsygzzsqmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmjxsygzzsqmx_id,'Get',{'Sql',this.pcmjxsygzzsqmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMJXSYGZZSQMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxsygzzsqmxes/{pcmjxsygzzsqmx_id}")
    public ResponseEntity<PCMJXSYGZZSQMXDTO> get(@PathVariable("pcmjxsygzzsqmx_id") String pcmjxsygzzsqmx_id) {
        PCMJXSYGZZSQMX domain = pcmjxsygzzsqmxService.get(pcmjxsygzzsqmx_id);
        PCMJXSYGZZSQMXDTO dto = pcmjxsygzzsqmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSYGZZSQMX-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMJXSYGZZSQMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzsqmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMJXSYGZZSQMXDTO pcmjxsygzzsqmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzsqmxService.checkKey(pcmjxsygzzsqmxMapping.toDomain(pcmjxsygzzsqmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSYGZZSQMX-ZZAction-all')")
    @ApiOperation(value = "转正操作", tags = {"PCMJXSYGZZSQMX" },  notes = "转正操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsygzzsqmxes/{pcmjxsygzzsqmx_id}/zzaction")
    @Transactional
    public ResponseEntity<PCMJXSYGZZSQMXDTO> zZAction(@PathVariable("pcmjxsygzzsqmx_id") String pcmjxsygzzsqmx_id, @RequestBody PCMJXSYGZZSQMXDTO pcmjxsygzzsqmxdto) {
        PCMJXSYGZZSQMX pcmjxsygzzsqmx = pcmjxsygzzsqmxMapping.toDomain(pcmjxsygzzsqmxdto);
        pcmjxsygzzsqmx.setPcmjxsygzzsqmxid(pcmjxsygzzsqmx_id);
        pcmjxsygzzsqmx = pcmjxsygzzsqmxService.zZAction(pcmjxsygzzsqmx);
        pcmjxsygzzsqmxdto = pcmjxsygzzsqmxMapping.toDto(pcmjxsygzzsqmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzsqmxdto);
    }

    @PreAuthorize("hasPermission(#pcmjxsygzzsqmx_id,'Remove',{'Sql',this.pcmjxsygzzsqmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMJXSYGZZSQMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxsygzzsqmxes/{pcmjxsygzzsqmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmjxsygzzsqmx_id") String pcmjxsygzzsqmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmjxsygzzsqmxService.remove(pcmjxsygzzsqmx_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.pcmjxsygzzsqmxMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMJXSYGZZSQMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxsygzzsqmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmjxsygzzsqmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSYGZZSQMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMJXSYGZZSQMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmjxsygzzsqmxes/fetchdefault")
	public ResponseEntity<List<PCMJXSYGZZSQMXDTO>> fetchDefault(PCMJXSYGZZSQMXSearchContext context) {
        Page<PCMJXSYGZZSQMX> domains = pcmjxsygzzsqmxService.searchDefault(context) ;
        List<PCMJXSYGZZSQMXDTO> list = pcmjxsygzzsqmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSYGZZSQMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMJXSYGZZSQMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsygzzsqmxes/searchdefault")
	public ResponseEntity<Page<PCMJXSYGZZSQMXDTO>> searchDefault(@RequestBody PCMJXSYGZZSQMXSearchContext context) {
        Page<PCMJXSYGZZSQMX> domains = pcmjxsygzzsqmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsygzzsqmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSYGZZSQMX-DSHSQ-all')")
	@ApiOperation(value = "fetch待审核申请", tags = {"PCMJXSYGZZSQMX" } ,notes = "fetch待审核申请")
    @RequestMapping(method= RequestMethod.GET , value="/pcmjxsygzzsqmxes/fetchdshsq")
	public ResponseEntity<List<PCMJXSYGZZSQMXDTO>> fetchDSHSQ(PCMJXSYGZZSQMXSearchContext context) {
        Page<PCMJXSYGZZSQMX> domains = pcmjxsygzzsqmxService.searchDSHSQ(context) ;
        List<PCMJXSYGZZSQMXDTO> list = pcmjxsygzzsqmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMJXSYGZZSQMX-DSHSQ-all')")
	@ApiOperation(value = "search待审核申请", tags = {"PCMJXSYGZZSQMX" } ,notes = "search待审核申请")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsygzzsqmxes/searchdshsq")
	public ResponseEntity<Page<PCMJXSYGZZSQMXDTO>> searchDSHSQ(@RequestBody PCMJXSYGZZSQMXSearchContext context) {
        Page<PCMJXSYGZZSQMX> domains = pcmjxsygzzsqmxService.searchDSHSQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsygzzsqmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
