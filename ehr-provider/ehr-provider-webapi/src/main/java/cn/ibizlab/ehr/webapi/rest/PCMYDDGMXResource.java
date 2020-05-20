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
import cn.ibizlab.ehr.core.pcm.domain.PCMYDDGMX;
import cn.ibizlab.ehr.core.pcm.service.IPCMYDDGMXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDDGMXSearchContext;




@Slf4j
@Api(tags = {"PCMYDDGMX" })
@RestController("WebApi-pcmyddgmx")
@RequestMapping("")
public class PCMYDDGMXResource {

    @Autowired
    private IPCMYDDGMXService pcmyddgmxService;

    @Autowired
    @Lazy
    private PCMYDDGMXMapping pcmyddgmxMapping;




    @PreAuthorize("hasPermission(#pcmyddgmx_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"PCMYDDGMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmyddgmxes/{pcmyddgmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmyddgmx_id") String pcmyddgmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmyddgmxService.remove(pcmyddgmx_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMYDDGMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmyddgmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmyddgmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMYDDGMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmyddgmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMYDDGMXDTO pcmyddgmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmyddgmxService.checkKey(pcmyddgmxMapping.toDomain(pcmyddgmxdto)));
    }




    @PreAuthorize("hasPermission(#pcmyddgmx_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMYDDGMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmyddgmxes/{pcmyddgmx_id}")
    public ResponseEntity<PCMYDDGMXDTO> get(@PathVariable("pcmyddgmx_id") String pcmyddgmx_id) {
        PCMYDDGMX domain = pcmyddgmxService.get(pcmyddgmx_id);
        PCMYDDGMXDTO dto = pcmyddgmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "Save", tags = {"PCMYDDGMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmyddgmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMYDDGMXDTO pcmyddgmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmyddgmxService.save(pcmyddgmxMapping.toDomain(pcmyddgmxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMYDDGMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmyddgmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMYDDGMXDTO> pcmyddgmxdtos) {
        pcmyddgmxService.saveBatch(pcmyddgmxMapping.toDomain(pcmyddgmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMYDDGMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmyddgmxes")
    @Transactional
    public ResponseEntity<PCMYDDGMXDTO> create(@RequestBody PCMYDDGMXDTO pcmyddgmxdto) {
        PCMYDDGMX domain = pcmyddgmxMapping.toDomain(pcmyddgmxdto);
		pcmyddgmxService.create(domain);
        PCMYDDGMXDTO dto = pcmyddgmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMYDDGMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmyddgmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMYDDGMXDTO> pcmyddgmxdtos) {
        pcmyddgmxService.createBatch(pcmyddgmxMapping.toDomain(pcmyddgmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "填充人员信息", tags = {"PCMYDDGMX" },  notes = "填充人员信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmyddgmxes/{pcmyddgmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PCMYDDGMXDTO> fillPersonInfo(@PathVariable("pcmyddgmx_id") String pcmyddgmx_id, @RequestBody PCMYDDGMXDTO pcmyddgmxdto) {
        PCMYDDGMX pcmyddgmx = pcmyddgmxMapping.toDomain(pcmyddgmxdto);
        pcmyddgmx = pcmyddgmxService.fillPersonInfo(pcmyddgmx);
        pcmyddgmxdto = pcmyddgmxMapping.toDto(pcmyddgmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmyddgmxdto);
    }




    @ApiOperation(value = "GetDraft", tags = {"PCMYDDGMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmyddgmxes/getdraft")
    public ResponseEntity<PCMYDDGMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmyddgmxMapping.toDto(pcmyddgmxService.getDraft(new PCMYDDGMX())));
    }




    @ApiOperation(value = "取消待岗", tags = {"PCMYDDGMX" },  notes = "取消待岗")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmyddgmxes/{pcmyddgmx_id}/qxdg")
    @Transactional
    public ResponseEntity<PCMYDDGMXDTO> qXDG(@PathVariable("pcmyddgmx_id") String pcmyddgmx_id, @RequestBody PCMYDDGMXDTO pcmyddgmxdto) {
        PCMYDDGMX pcmyddgmx = pcmyddgmxMapping.toDomain(pcmyddgmxdto);
        pcmyddgmx = pcmyddgmxService.qXDG(pcmyddgmx);
        pcmyddgmxdto = pcmyddgmxMapping.toDto(pcmyddgmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmyddgmxdto);
    }




    @PreAuthorize("hasPermission(#pcmyddgmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMYDDGMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmyddgmxes/{pcmyddgmx_id}")
    @Transactional
    public ResponseEntity<PCMYDDGMXDTO> update(@PathVariable("pcmyddgmx_id") String pcmyddgmx_id, @RequestBody PCMYDDGMXDTO pcmyddgmxdto) {
		PCMYDDGMX domain = pcmyddgmxMapping.toDomain(pcmyddgmxdto);
        domain.setPcmyddgmxid(pcmyddgmx_id);
		pcmyddgmxService.update(domain);
		PCMYDDGMXDTO dto = pcmyddgmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmyddgmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMYDDGMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmyddgmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMYDDGMXDTO> pcmyddgmxdtos) {
        pcmyddgmxService.updateBatch(pcmyddgmxMapping.toDomain(pcmyddgmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDDGMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMYDDGMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmyddgmxes/fetchdefault")
	public ResponseEntity<List<PCMYDDGMXDTO>> fetchDefault(PCMYDDGMXSearchContext context) {
        Page<PCMYDDGMX> domains = pcmyddgmxService.searchDefault(context) ;
        List<PCMYDDGMXDTO> list = pcmyddgmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDDGMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMYDDGMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmyddgmxes/searchdefault")
	public ResponseEntity<Page<PCMYDDGMXDTO>> searchDefault(@RequestBody PCMYDDGMXSearchContext context) {
        Page<PCMYDDGMX> domains = pcmyddgmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmyddgmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDDGMX-JLDS-all')")
	@ApiOperation(value = "fetch记录查询", tags = {"PCMYDDGMX" } ,notes = "fetch记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmyddgmxes/fetchjlds")
	public ResponseEntity<List<PCMYDDGMXDTO>> fetchJLDS(PCMYDDGMXSearchContext context) {
        Page<PCMYDDGMX> domains = pcmyddgmxService.searchJLDS(context) ;
        List<PCMYDDGMXDTO> list = pcmyddgmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDDGMX-JLDS-all')")
	@ApiOperation(value = "search记录查询", tags = {"PCMYDDGMX" } ,notes = "search记录查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmyddgmxes/searchjlds")
	public ResponseEntity<Page<PCMYDDGMXDTO>> searchJLDS(@RequestBody PCMYDDGMXSearchContext context) {
        Page<PCMYDDGMX> domains = pcmyddgmxService.searchJLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmyddgmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDDGMX-GLDS-all')")
	@ApiOperation(value = "fetch管理查询", tags = {"PCMYDDGMX" } ,notes = "fetch管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmyddgmxes/fetchglds")
	public ResponseEntity<List<PCMYDDGMXDTO>> fetchGLDS(PCMYDDGMXSearchContext context) {
        Page<PCMYDDGMX> domains = pcmyddgmxService.searchGLDS(context) ;
        List<PCMYDDGMXDTO> list = pcmyddgmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMYDDGMX-GLDS-all')")
	@ApiOperation(value = "search管理查询", tags = {"PCMYDDGMX" } ,notes = "search管理查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmyddgmxes/searchglds")
	public ResponseEntity<Page<PCMYDDGMXDTO>> searchGLDS(@RequestBody PCMYDDGMXSearchContext context) {
        Page<PCMYDDGMX> domains = pcmyddgmxService.searchGLDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmyddgmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMYDDGMX getEntity(){
        return new PCMYDDGMX();
    }

}
