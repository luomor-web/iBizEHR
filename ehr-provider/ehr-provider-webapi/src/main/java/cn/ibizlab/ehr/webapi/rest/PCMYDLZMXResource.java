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
import cn.ibizlab.ehr.core.pcm.domain.PCMYDLZMX;
import cn.ibizlab.ehr.core.pcm.service.IPCMYDLZMXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDLZMXSearchContext;




@Slf4j
@Api(tags = {"PCMYDLZMX" })
@RestController("WebApi-pcmydlzmx")
@RequestMapping("")
public class PCMYDLZMXResource {

    @Autowired
    private IPCMYDLZMXService pcmydlzmxService;

    @Autowired
    @Lazy
    public PCMYDLZMXMapping pcmydlzmxMapping;

    public PCMYDLZMXDTO permissionDTO=new PCMYDLZMXDTO();

    @PreAuthorize("hasPermission(#pcmydlzmx_id,'Update',{'Sql',this.pcmydlzmxMapping,#pcmydlzmxdto})")
    @ApiOperation(value = "Update", tags = {"PCMYDLZMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydlzmxes/{pcmydlzmx_id}")
    @Transactional
    public ResponseEntity<PCMYDLZMXDTO> update(@PathVariable("pcmydlzmx_id") String pcmydlzmx_id, @RequestBody PCMYDLZMXDTO pcmydlzmxdto) {
		PCMYDLZMX domain = pcmydlzmxMapping.toDomain(pcmydlzmxdto);
        domain.setPcmydlzmxid(pcmydlzmx_id);
		pcmydlzmxService.update(domain);
		PCMYDLZMXDTO dto = pcmydlzmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMYDLZMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydlzmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMYDLZMXDTO> pcmydlzmxdtos) {
        pcmydlzmxService.updateBatch(pcmydlzmxMapping.toDomain(pcmydlzmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDLZMX-FillPersonInfo-all')")
    @ApiOperation(value = "填充人员信息", tags = {"PCMYDLZMX" },  notes = "填充人员信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydlzmxes/{pcmydlzmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PCMYDLZMXDTO> fillPersonInfo(@PathVariable("pcmydlzmx_id") String pcmydlzmx_id, @RequestBody PCMYDLZMXDTO pcmydlzmxdto) {
        PCMYDLZMX pcmydlzmx = pcmydlzmxMapping.toDomain(pcmydlzmxdto);
        pcmydlzmx = pcmydlzmxService.fillPersonInfo(pcmydlzmx);
        pcmydlzmxdto = pcmydlzmxMapping.toDto(pcmydlzmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydlzmxdto);
    }

    @PreAuthorize("hasPermission(#pcmydlzmx_id,'Get',{'Sql',this.pcmydlzmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMYDLZMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydlzmxes/{pcmydlzmx_id}")
    public ResponseEntity<PCMYDLZMXDTO> get(@PathVariable("pcmydlzmx_id") String pcmydlzmx_id) {
        PCMYDLZMX domain = pcmydlzmxService.get(pcmydlzmx_id);
        PCMYDLZMXDTO dto = pcmydlzmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmydlzmxMapping,#pcmydlzmxdto})")
    @ApiOperation(value = "Create", tags = {"PCMYDLZMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydlzmxes")
    @Transactional
    public ResponseEntity<PCMYDLZMXDTO> create(@RequestBody PCMYDLZMXDTO pcmydlzmxdto) {
        PCMYDLZMX domain = pcmydlzmxMapping.toDomain(pcmydlzmxdto);
		pcmydlzmxService.create(domain);
        PCMYDLZMXDTO dto = pcmydlzmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PCMYDLZMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydlzmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMYDLZMXDTO> pcmydlzmxdtos) {
        pcmydlzmxService.createBatch(pcmydlzmxMapping.toDomain(pcmydlzmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDLZMX-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMYDLZMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydlzmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMYDLZMXDTO pcmydlzmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydlzmxService.checkKey(pcmydlzmxMapping.toDomain(pcmydlzmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDLZMX-FinishLZ-all')")
    @ApiOperation(value = "完成离职操作", tags = {"PCMYDLZMX" },  notes = "完成离职操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydlzmxes/{pcmydlzmx_id}/finishlz")
    @Transactional
    public ResponseEntity<PCMYDLZMXDTO> finishLZ(@PathVariable("pcmydlzmx_id") String pcmydlzmx_id, @RequestBody PCMYDLZMXDTO pcmydlzmxdto) {
        PCMYDLZMX pcmydlzmx = pcmydlzmxMapping.toDomain(pcmydlzmxdto);
        pcmydlzmx = pcmydlzmxService.finishLZ(pcmydlzmx);
        pcmydlzmxdto = pcmydlzmxMapping.toDto(pcmydlzmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydlzmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDLZMX-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMYDLZMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydlzmxes/getdraft")
    public ResponseEntity<PCMYDLZMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydlzmxMapping.toDto(pcmydlzmxService.getDraft(new PCMYDLZMX())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDLZMX-Save-all')")
    @ApiOperation(value = "Save", tags = {"PCMYDLZMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydlzmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMYDLZMXDTO pcmydlzmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydlzmxService.save(pcmydlzmxMapping.toDomain(pcmydlzmxdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PCMYDLZMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydlzmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMYDLZMXDTO> pcmydlzmxdtos) {
        pcmydlzmxService.saveBatch(pcmydlzmxMapping.toDomain(pcmydlzmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(#pcmydlzmx_id,'Remove',{'Sql',this.pcmydlzmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMYDLZMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydlzmxes/{pcmydlzmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmydlzmx_id") String pcmydlzmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmydlzmxService.remove(pcmydlzmx_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMYDLZMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydlzmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmydlzmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDLZMX-GLDQ-all')")
	@ApiOperation(value = "fetch管理查询", tags = {"PCMYDLZMX" } ,notes = "fetch管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydlzmxes/fetchgldq")
	public ResponseEntity<List<PCMYDLZMXDTO>> fetchGLDQ(PCMYDLZMXSearchContext context) {
        Page<PCMYDLZMX> domains = pcmydlzmxService.searchGLDQ(context) ;
        List<PCMYDLZMXDTO> list = pcmydlzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDLZMX-GLDQ-all')")
	@ApiOperation(value = "search管理查询", tags = {"PCMYDLZMX" } ,notes = "search管理查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydlzmxes/searchgldq")
	public ResponseEntity<Page<PCMYDLZMXDTO>> searchGLDQ(@RequestBody PCMYDLZMXSearchContext context) {
        Page<PCMYDLZMX> domains = pcmydlzmxService.searchGLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydlzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDLZMX-JLDQ-all')")
	@ApiOperation(value = "fetch记录查询", tags = {"PCMYDLZMX" } ,notes = "fetch记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydlzmxes/fetchjldq")
	public ResponseEntity<List<PCMYDLZMXDTO>> fetchJLDQ(PCMYDLZMXSearchContext context) {
        Page<PCMYDLZMX> domains = pcmydlzmxService.searchJLDQ(context) ;
        List<PCMYDLZMXDTO> list = pcmydlzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDLZMX-JLDQ-all')")
	@ApiOperation(value = "search记录查询", tags = {"PCMYDLZMX" } ,notes = "search记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydlzmxes/searchjldq")
	public ResponseEntity<Page<PCMYDLZMXDTO>> searchJLDQ(@RequestBody PCMYDLZMXSearchContext context) {
        Page<PCMYDLZMX> domains = pcmydlzmxService.searchJLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydlzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDLZMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMYDLZMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydlzmxes/fetchdefault")
	public ResponseEntity<List<PCMYDLZMXDTO>> fetchDefault(PCMYDLZMXSearchContext context) {
        Page<PCMYDLZMX> domains = pcmydlzmxService.searchDefault(context) ;
        List<PCMYDLZMXDTO> list = pcmydlzmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDLZMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMYDLZMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmydlzmxes/searchdefault")
	public ResponseEntity<Page<PCMYDLZMXDTO>> searchDefault(@RequestBody PCMYDLZMXSearchContext context) {
        Page<PCMYDLZMX> domains = pcmydlzmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydlzmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
