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
import cn.ibizlab.ehr.core.pcm.domain.PCMYDJDMX;
import cn.ibizlab.ehr.core.pcm.service.IPCMYDJDMXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMYDJDMXSearchContext;




@Slf4j
@Api(tags = {"PCMYDJDMX" })
@RestController("WebApi-pcmydjdmx")
@RequestMapping("")
public class PCMYDJDMXResource {

    @Autowired
    private IPCMYDJDMXService pcmydjdmxService;

    @Autowired
    @Lazy
    private PCMYDJDMXMapping pcmydjdmxMapping;




    @PreAuthorize("hasPermission(#pcmydjdmx_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMYDJDMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydjdmxes/{pcmydjdmx_id}")
    public ResponseEntity<PCMYDJDMXDTO> get(@PathVariable("pcmydjdmx_id") String pcmydjdmx_id) {
        PCMYDJDMX domain = pcmydjdmxService.get(pcmydjdmx_id);
        PCMYDJDMXDTO dto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "填充员工信息", tags = {"PCMYDJDMX" },  notes = "填充员工信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjdmxes/{pcmydjdmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PCMYDJDMXDTO> fillPersonInfo(@PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PCMYDJDMXDTO pcmydjdmxdto) {
        PCMYDJDMX pcmydjdmx = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        pcmydjdmx = pcmydjdmxService.fillPersonInfo(pcmydjdmx);
        pcmydjdmxdto = pcmydjdmxMapping.toDto(pcmydjdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxdto);
    }




    @ApiOperation(value = "GetDraft", tags = {"PCMYDJDMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmydjdmxes/getdraft")
    public ResponseEntity<PCMYDJDMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxMapping.toDto(pcmydjdmxService.getDraft(new PCMYDJDMX())));
    }




    @PreAuthorize("hasPermission(#pcmydjdmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMYDJDMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydjdmxes/{pcmydjdmx_id}")
    @Transactional
    public ResponseEntity<PCMYDJDMXDTO> update(@PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PCMYDJDMXDTO pcmydjdmxdto) {
		PCMYDJDMX domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        domain.setPcmydjdmxid(pcmydjdmx_id);
		pcmydjdmxService.update(domain);
		PCMYDJDMXDTO dto = pcmydjdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmydjdmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMYDJDMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMYDJDMXDTO> pcmydjdmxdtos) {
        pcmydjdmxService.updateBatch(pcmydjdmxMapping.toDomain(pcmydjdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('Remove',{#pcmydjdmx_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PCMYDJDMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydjdmxes/{pcmydjdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmydjdmx_id") String pcmydjdmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.remove(pcmydjdmx_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMYDJDMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmydjdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "人员回归", tags = {"PCMYDJDMX" },  notes = "人员回归")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjdmxes/{pcmydjdmx_id}/ryhg")
    @Transactional
    public ResponseEntity<PCMYDJDMXDTO> rYHG(@PathVariable("pcmydjdmx_id") String pcmydjdmx_id, @RequestBody PCMYDJDMXDTO pcmydjdmxdto) {
        PCMYDJDMX pcmydjdmx = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
        pcmydjdmx = pcmydjdmxService.rYHG(pcmydjdmx);
        pcmydjdmxdto = pcmydjdmxMapping.toDto(pcmydjdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxdto);
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMYDJDMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjdmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMYDJDMXDTO pcmydjdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.checkKey(pcmydjdmxMapping.toDomain(pcmydjdmxdto)));
    }




    @ApiOperation(value = "Save", tags = {"PCMYDJDMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjdmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMYDJDMXDTO pcmydjdmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmydjdmxService.save(pcmydjdmxMapping.toDomain(pcmydjdmxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMYDJDMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMYDJDMXDTO> pcmydjdmxdtos) {
        pcmydjdmxService.saveBatch(pcmydjdmxMapping.toDomain(pcmydjdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMYDJDMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjdmxes")
    @Transactional
    public ResponseEntity<PCMYDJDMXDTO> create(@RequestBody PCMYDJDMXDTO pcmydjdmxdto) {
        PCMYDJDMX domain = pcmydjdmxMapping.toDomain(pcmydjdmxdto);
		pcmydjdmxService.create(domain);
        PCMYDJDMXDTO dto = pcmydjdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMYDJDMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmydjdmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMYDJDMXDTO> pcmydjdmxdtos) {
        pcmydjdmxService.createBatch(pcmydjdmxMapping.toDomain(pcmydjdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission('Get',{#context,'JDGLDQ',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch借调管理查询", tags = {"PCMYDJDMX" } ,notes = "fetch借调管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjdmxes/fetchjdgldq")
	public ResponseEntity<List<PCMYDJDMXDTO>> fetchJDGLDQ(PCMYDJDMXSearchContext context) {
        Page<PCMYDJDMX> domains = pcmydjdmxService.searchJDGLDQ(context) ;
        List<PCMYDJDMXDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'JDGLDQ',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search借调管理查询", tags = {"PCMYDJDMX" } ,notes = "search借调管理查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjdmxes/searchjdgldq")
	public ResponseEntity<Page<PCMYDJDMXDTO>> searchJDGLDQ(PCMYDJDMXSearchContext context) {
        Page<PCMYDJDMX> domains = pcmydjdmxService.searchJDGLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'JDLSJLDQ',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetch借调历史记录查询", tags = {"PCMYDJDMX" } ,notes = "fetch借调历史记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjdmxes/fetchjdlsjldq")
	public ResponseEntity<List<PCMYDJDMXDTO>> fetchJDLSJLDQ(PCMYDJDMXSearchContext context) {
        Page<PCMYDJDMX> domains = pcmydjdmxService.searchJDLSJLDQ(context) ;
        List<PCMYDJDMXDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'JDLSJLDQ',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search借调历史记录查询", tags = {"PCMYDJDMX" } ,notes = "search借调历史记录查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjdmxes/searchjdlsjldq")
	public ResponseEntity<Page<PCMYDJDMXDTO>> searchJDLSJLDQ(PCMYDJDMXSearchContext context) {
        Page<PCMYDJDMX> domains = pcmydjdmxService.searchJDLSJLDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMYDJDMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjdmxes/fetchdefault")
	public ResponseEntity<List<PCMYDJDMXDTO>> fetchDefault(PCMYDJDMXSearchContext context) {
        Page<PCMYDJDMX> domains = pcmydjdmxService.searchDefault(context) ;
        List<PCMYDJDMXDTO> list = pcmydjdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMYDJDMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmydjdmxes/searchdefault")
	public ResponseEntity<Page<PCMYDJDMXDTO>> searchDefault(PCMYDJDMXSearchContext context) {
        Page<PCMYDJDMX> domains = pcmydjdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmydjdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMYDJDMX getEntity(){
        return new PCMYDJDMX();
    }

}