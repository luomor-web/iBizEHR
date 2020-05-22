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
import cn.ibizlab.ehr.core.pcm.domain.PCMDDSQDMX;
import cn.ibizlab.ehr.core.pcm.service.IPCMDDSQDMXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMDDSQDMXSearchContext;




@Slf4j
@Api(tags = {"PCMDDSQDMX" })
@RestController("WebApi-pcmddsqdmx")
@RequestMapping("")
public class PCMDDSQDMXResource {

    @Autowired
    private IPCMDDSQDMXService pcmddsqdmxService;

    @Autowired
    @Lazy
    public PCMDDSQDMXMapping pcmddsqdmxMapping;

    public PCMDDSQDMXDTO permissionDTO=new PCMDDSQDMXDTO();

    @PreAuthorize("hasPermission(#pcmddsqdmx_id,'Update',{'Sql',this.pcmddsqdmxMapping,#pcmddsqdmxdto})")
    @ApiOperation(value = "Update", tags = {"PCMDDSQDMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmddsqdmxes/{pcmddsqdmx_id}")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> update(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
		PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        domain.setPcmddsqdmxid(pcmddsqdmx_id);
		pcmddsqdmxService.update(domain);
		PCMDDSQDMXDTO dto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Update',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMDDSQDMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMDDSQDMXDTO> pcmddsqdmxdtos) {
        pcmddsqdmxService.updateBatch(pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDUpdate-all')")
    @ApiOperation(value = "调动更正", tags = {"PCMDDSQDMX" },  notes = "调动更正")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmddsqdmxes/{pcmddsqdmx_id}/ddupdate")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> dDUpdate(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX pcmddsqdmx = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        pcmddsqdmx = pcmddsqdmxService.dDUpdate(pcmddsqdmx);
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(pcmddsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-SQBTG-all')")
    @ApiOperation(value = "申请不通过", tags = {"PCMDDSQDMX" },  notes = "申请不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/{pcmddsqdmx_id}/sqbtg")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> sQBTG(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX pcmddsqdmx = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        pcmddsqdmx = pcmddsqdmxService.sQBTG(pcmddsqdmx);
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(pcmddsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDCZ-all')")
    @ApiOperation(value = "借调操作", tags = {"PCMDDSQDMX" },  notes = "借调操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/{pcmddsqdmx_id}/jdcz")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> jDCZ(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX pcmddsqdmx = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        pcmddsqdmx = pcmddsqdmxService.jDCZ(pcmddsqdmx);
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(pcmddsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMDDSQDMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmddsqdmxes/getdraft")
    public ResponseEntity<PCMDDSQDMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxMapping.toDto(pcmddsqdmxService.getDraft(new PCMDDSQDMX())));
    }

    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmddsqdmxMapping,#pcmddsqdmxdto})")
    @ApiOperation(value = "Create", tags = {"PCMDDSQDMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> create(@RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX domain = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
		pcmddsqdmxService.create(domain);
        PCMDDSQDMXDTO dto = pcmddsqdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('Create',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "createBatch", tags = {"PCMDDSQDMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMDDSQDMXDTO> pcmddsqdmxdtos) {
        pcmddsqdmxService.createBatch(pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDCreate-all')")
    @ApiOperation(value = "调动更新", tags = {"PCMDDSQDMX" },  notes = "调动更新")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/{pcmddsqdmx_id}/ddcreate")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> dDCreate(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX pcmddsqdmx = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        pcmddsqdmx = pcmddsqdmxService.dDCreate(pcmddsqdmx);
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(pcmddsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasPermission(#pcmddsqdmx_id,'Get',{'Sql',this.pcmddsqdmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMDDSQDMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmddsqdmxes/{pcmddsqdmx_id}")
    public ResponseEntity<PCMDDSQDMXDTO> get(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id) {
        PCMDDSQDMX domain = pcmddsqdmxService.get(pcmddsqdmx_id);
        PCMDDSQDMXDTO dto = pcmddsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmddsqdmx_id,'Remove',{'Sql',this.pcmddsqdmxMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMDDSQDMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmddsqdmxes/{pcmddsqdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.remove(pcmddsqdmx_id));
    }

    @PreAuthorize("hasPermission('Remove',{'Sql',this.humanMapping,this.permissionDTO,#ids})")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMDDSQDMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmddsqdmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmddsqdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-ZZSQ-all')")
    @ApiOperation(value = "自助申请", tags = {"PCMDDSQDMX" },  notes = "自助申请")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/{pcmddsqdmx_id}/zzsq")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> zZSQ(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX pcmddsqdmx = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        pcmddsqdmx = pcmddsqdmxService.zZSQ(pcmddsqdmx);
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(pcmddsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMDDSQDMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.checkKey(pcmddsqdmxMapping.toDomain(pcmddsqdmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDCZ-all')")
    @ApiOperation(value = "调动操作", tags = {"PCMDDSQDMX" },  notes = "调动操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/{pcmddsqdmx_id}/ddcz")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> dDCZ(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX pcmddsqdmx = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        pcmddsqdmx = pcmddsqdmxService.dDCZ(pcmddsqdmx);
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(pcmddsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-SQTG-all')")
    @ApiOperation(value = "申请通过", tags = {"PCMDDSQDMX" },  notes = "申请通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/{pcmddsqdmx_id}/sqtg")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> sQTG(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX pcmddsqdmx = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        pcmddsqdmx = pcmddsqdmxService.sQTG(pcmddsqdmx);
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(pcmddsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-Save-all')")
    @ApiOperation(value = "Save", tags = {"PCMDDSQDMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxService.save(pcmddsqdmxMapping.toDomain(pcmddsqdmxdto)));
    }

    @PreAuthorize("hasPermission('Save',{'Sql',this.humanMapping,#humandtos})")
    @ApiOperation(value = "SaveBatch", tags = {"PCMDDSQDMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMDDSQDMXDTO> pcmddsqdmxdtos) {
        pcmddsqdmxService.saveBatch(pcmddsqdmxMapping.toDomain(pcmddsqdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZCZ-all')")
    @ApiOperation(value = "兼职操作", tags = {"PCMDDSQDMX" },  notes = "兼职操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqdmxes/{pcmddsqdmx_id}/jzcz")
    @Transactional
    public ResponseEntity<PCMDDSQDMXDTO> jZCZ(@PathVariable("pcmddsqdmx_id") String pcmddsqdmx_id, @RequestBody PCMDDSQDMXDTO pcmddsqdmxdto) {
        PCMDDSQDMX pcmddsqdmx = pcmddsqdmxMapping.toDomain(pcmddsqdmxdto);
        pcmddsqdmx = pcmddsqdmxService.jZCZ(pcmddsqdmx);
        pcmddsqdmxdto = pcmddsqdmxMapping.toDto(pcmddsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZSQMX-all')")
	@ApiOperation(value = "fetch兼职申请明细（未审核完成）", tags = {"PCMDDSQDMX" } ,notes = "fetch兼职申请明细（未审核完成）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchjzsqmx")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchJZSQMX(PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJZSQMX(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZSQMX-all')")
	@ApiOperation(value = "search兼职申请明细（未审核完成）", tags = {"PCMDDSQDMX" } ,notes = "search兼职申请明细（未审核完成）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchjzsqmx")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchJZSQMX(@RequestBody PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDSQGR-all')")
	@ApiOperation(value = "fetch借调申请（个人）", tags = {"PCMDDSQDMX" } ,notes = "fetch借调申请（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchjdsqgr")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchJDSQGR(PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJDSQGR(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDSQGR-all')")
	@ApiOperation(value = "search借调申请（个人）", tags = {"PCMDDSQDMX" } ,notes = "search借调申请（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchjdsqgr")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchJDSQGR(@RequestBody PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJDSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMDDSQDMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchdefault")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchDefault(PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDefault(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMDDSQDMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchdefault")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchDefault(@RequestBody PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDSQMX-all')")
	@ApiOperation(value = "fetch借调申请明细（未审核完成）", tags = {"PCMDDSQDMX" } ,notes = "fetch借调申请明细（未审核完成）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchjdsqmx")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchJDSQMX(PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJDSQMX(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JDSQMX-all')")
	@ApiOperation(value = "search借调申请明细（未审核完成）", tags = {"PCMDDSQDMX" } ,notes = "search借调申请明细（未审核完成）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchjdsqmx")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchJDSQMX(@RequestBody PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJDSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDJL-all')")
	@ApiOperation(value = "fetch调动记录", tags = {"PCMDDSQDMX" } ,notes = "fetch调动记录")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchddjl")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchDDJL(PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDJL(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDJL-all')")
	@ApiOperation(value = "search调动记录", tags = {"PCMDDSQDMX" } ,notes = "search调动记录")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchddjl")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchDDJL(@RequestBody PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-GBDDJL-all')")
	@ApiOperation(value = "fetch调动记录", tags = {"PCMDDSQDMX" } ,notes = "fetch调动记录")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchgbddjl")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchGBDDJL(PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchGBDDJL(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-GBDDJL-all')")
	@ApiOperation(value = "search调动记录", tags = {"PCMDDSQDMX" } ,notes = "search调动记录")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchgbddjl")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchGBDDJL(@RequestBody PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchGBDDJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDSQGR-all')")
	@ApiOperation(value = "fetch调动申请（个人）", tags = {"PCMDDSQDMX" } ,notes = "fetch调动申请（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchddsqgr")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchDDSQGR(PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDSQGR(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDSQGR-all')")
	@ApiOperation(value = "search调动申请（个人）", tags = {"PCMDDSQDMX" } ,notes = "search调动申请（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchddsqgr")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchDDSQGR(@RequestBody PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDMX-all')")
	@ApiOperation(value = "fetch调动明细", tags = {"PCMDDSQDMX" } ,notes = "fetch调动明细")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchddmx")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchDDMX(PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDMX(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-DDMX-all')")
	@ApiOperation(value = "search调动明细", tags = {"PCMDDSQDMX" } ,notes = "search调动明细")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchddmx")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchDDMX(@RequestBody PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchDDMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZSQGR-all')")
	@ApiOperation(value = "fetch兼职申请（个人）", tags = {"PCMDDSQDMX" } ,notes = "fetch兼职申请（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqdmxes/fetchjzsqgr")
	public ResponseEntity<List<PCMDDSQDMXDTO>> fetchJZSQGR(PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJZSQGR(context) ;
        List<PCMDDSQDMXDTO> list = pcmddsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMDDSQDMX-JZSQGR-all')")
	@ApiOperation(value = "search兼职申请（个人）", tags = {"PCMDDSQDMX" } ,notes = "search兼职申请（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqdmxes/searchjzsqgr")
	public ResponseEntity<Page<PCMDDSQDMXDTO>> searchJZSQGR(@RequestBody PCMDDSQDMXSearchContext context) {
        Page<PCMDDSQDMX> domains = pcmddsqdmxService.searchJZSQGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}
