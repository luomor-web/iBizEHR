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
import org.springframework.security.access.prepost.PostAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import cn.ibizlab.ehr.webapi.dto.*;
import cn.ibizlab.ehr.webapi.mapping.*;
import cn.ibizlab.ehr.core.pcm.domain.PcmNotice;
import cn.ibizlab.ehr.core.pcm.service.IPcmNoticeService;
import cn.ibizlab.ehr.core.pcm.filter.PcmNoticeSearchContext;

@Slf4j
@Api(tags = {"提醒消息" })
@RestController("WebApi-pcmnotice")
@RequestMapping("")
public class PcmNoticeResource {

    @Autowired
    public IPcmNoticeService pcmnoticeService;

    @Autowired
    @Lazy
    public PcmNoticeMapping pcmnoticeMapping;

    @PreAuthorize("hasPermission(this.pcmnoticeMapping.toDomain(#pcmnoticedto),'ehr-PcmNotice-Create')")
    @ApiOperation(value = "新建提醒消息", tags = {"提醒消息" },  notes = "新建提醒消息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmnotices")
    @Transactional
    public ResponseEntity<PcmNoticeDTO> create(@RequestBody PcmNoticeDTO pcmnoticedto) {
        PcmNotice domain = pcmnoticeMapping.toDomain(pcmnoticedto);
		pcmnoticeService.create(domain);
        PcmNoticeDTO dto = pcmnoticeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmnoticeMapping.toDomain(#pcmnoticedtos),'ehr-PcmNotice-Create')")
    @ApiOperation(value = "批量新建提醒消息", tags = {"提醒消息" },  notes = "批量新建提醒消息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmnotices/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmNoticeDTO> pcmnoticedtos) {
        pcmnoticeService.createBatch(pcmnoticeMapping.toDomain(pcmnoticedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmnoticeService.get(#pcmnotice_id),'ehr-PcmNotice-Update')")
    @ApiOperation(value = "更新提醒消息", tags = {"提醒消息" },  notes = "更新提醒消息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmnotices/{pcmnotice_id}")
    @Transactional
    public ResponseEntity<PcmNoticeDTO> update(@PathVariable("pcmnotice_id") String pcmnotice_id, @RequestBody PcmNoticeDTO pcmnoticedto) {
		PcmNotice domain  = pcmnoticeMapping.toDomain(pcmnoticedto);
        domain .setPcmnoticeid(pcmnotice_id);
		pcmnoticeService.update(domain );
		PcmNoticeDTO dto = pcmnoticeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmnoticeService.getPcmnoticeByEntities(this.pcmnoticeMapping.toDomain(#pcmnoticedtos)),'ehr-PcmNotice-Update')")
    @ApiOperation(value = "批量更新提醒消息", tags = {"提醒消息" },  notes = "批量更新提醒消息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmnotices/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmNoticeDTO> pcmnoticedtos) {
        pcmnoticeService.updateBatch(pcmnoticeMapping.toDomain(pcmnoticedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmnoticeMapping.toDomain(#pcmnoticedto),'ehr-PcmNotice-Save')")
    @ApiOperation(value = "保存提醒消息", tags = {"提醒消息" },  notes = "保存提醒消息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmnotices/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmNoticeDTO pcmnoticedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmnoticeService.save(pcmnoticeMapping.toDomain(pcmnoticedto)));
    }

    @PreAuthorize("hasPermission(this.pcmnoticeMapping.toDomain(#pcmnoticedtos),'ehr-PcmNotice-Save')")
    @ApiOperation(value = "批量保存提醒消息", tags = {"提醒消息" },  notes = "批量保存提醒消息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmnotices/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmNoticeDTO> pcmnoticedtos) {
        pcmnoticeService.saveBatch(pcmnoticeMapping.toDomain(pcmnoticedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmnoticeMapping.toDomain(returnObject.body),'ehr-PcmNotice-Get')")
    @ApiOperation(value = "获取提醒消息", tags = {"提醒消息" },  notes = "获取提醒消息")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmnotices/{pcmnotice_id}")
    public ResponseEntity<PcmNoticeDTO> get(@PathVariable("pcmnotice_id") String pcmnotice_id) {
        PcmNotice domain = pcmnoticeService.get(pcmnotice_id);
        PcmNoticeDTO dto = pcmnoticeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取提醒消息草稿", tags = {"提醒消息" },  notes = "获取提醒消息草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmnotices/getdraft")
    public ResponseEntity<PcmNoticeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmnoticeMapping.toDto(pcmnoticeService.getDraft(new PcmNotice())));
    }

    @ApiOperation(value = "检查提醒消息", tags = {"提醒消息" },  notes = "检查提醒消息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmnotices/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmNoticeDTO pcmnoticedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmnoticeService.checkKey(pcmnoticeMapping.toDomain(pcmnoticedto)));
    }

    @PreAuthorize("hasPermission(this.pcmnoticeService.get(#pcmnotice_id),'ehr-PcmNotice-Remove')")
    @ApiOperation(value = "删除提醒消息", tags = {"提醒消息" },  notes = "删除提醒消息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmnotices/{pcmnotice_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmnotice_id") String pcmnotice_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmnoticeService.remove(pcmnotice_id));
    }

    @PreAuthorize("hasPermission(this.pcmnoticeService.getPcmnoticeByIds(#ids),'ehr-PcmNotice-Remove')")
    @ApiOperation(value = "批量删除提醒消息", tags = {"提醒消息" },  notes = "批量删除提醒消息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmnotices/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmnoticeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmNotice-NOTICE_DAGLYDQ-all')")
	@ApiOperation(value = "获取档案管理员的提醒", tags = {"提醒消息" } ,notes = "获取档案管理员的提醒")
    @RequestMapping(method= RequestMethod.GET , value="/pcmnotices/fetchnotice_daglydq")
	public ResponseEntity<List<PcmNoticeDTO>> fetchNOTICE_DAGLYDQ(PcmNoticeSearchContext context) {
        Page<PcmNotice> domains = pcmnoticeService.searchNOTICE_DAGLYDQ(context) ;
        List<PcmNoticeDTO> list = pcmnoticeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmNotice-NOTICE_DAGLYDQ-all')")
	@ApiOperation(value = "查询档案管理员的提醒", tags = {"提醒消息" } ,notes = "查询档案管理员的提醒")
    @RequestMapping(method= RequestMethod.POST , value="/pcmnotices/searchnotice_daglydq")
	public ResponseEntity<Page<PcmNoticeDTO>> searchNOTICE_DAGLYDQ(@RequestBody PcmNoticeSearchContext context) {
        Page<PcmNotice> domains = pcmnoticeService.searchNOTICE_DAGLYDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmnoticeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmNotice-NOTICE_XCZYDQ-all')")
	@ApiOperation(value = "获取薪酬专员的提醒", tags = {"提醒消息" } ,notes = "获取薪酬专员的提醒")
    @RequestMapping(method= RequestMethod.GET , value="/pcmnotices/fetchnotice_xczydq")
	public ResponseEntity<List<PcmNoticeDTO>> fetchNOTICE_XCZYDQ(PcmNoticeSearchContext context) {
        Page<PcmNotice> domains = pcmnoticeService.searchNOTICE_XCZYDQ(context) ;
        List<PcmNoticeDTO> list = pcmnoticeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmNotice-NOTICE_XCZYDQ-all')")
	@ApiOperation(value = "查询薪酬专员的提醒", tags = {"提醒消息" } ,notes = "查询薪酬专员的提醒")
    @RequestMapping(method= RequestMethod.POST , value="/pcmnotices/searchnotice_xczydq")
	public ResponseEntity<Page<PcmNoticeDTO>> searchNOTICE_XCZYDQ(@RequestBody PcmNoticeSearchContext context) {
        Page<PcmNotice> domains = pcmnoticeService.searchNOTICE_XCZYDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmnoticeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmNotice-NOTICE_KQZYDQ-all')")
	@ApiOperation(value = "获取考勤专员的提醒", tags = {"提醒消息" } ,notes = "获取考勤专员的提醒")
    @RequestMapping(method= RequestMethod.GET , value="/pcmnotices/fetchnotice_kqzydq")
	public ResponseEntity<List<PcmNoticeDTO>> fetchNOTICE_KQZYDQ(PcmNoticeSearchContext context) {
        Page<PcmNotice> domains = pcmnoticeService.searchNOTICE_KQZYDQ(context) ;
        List<PcmNoticeDTO> list = pcmnoticeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmNotice-NOTICE_KQZYDQ-all')")
	@ApiOperation(value = "查询考勤专员的提醒", tags = {"提醒消息" } ,notes = "查询考勤专员的提醒")
    @RequestMapping(method= RequestMethod.POST , value="/pcmnotices/searchnotice_kqzydq")
	public ResponseEntity<Page<PcmNoticeDTO>> searchNOTICE_KQZYDQ(@RequestBody PcmNoticeSearchContext context) {
        Page<PcmNotice> domains = pcmnoticeService.searchNOTICE_KQZYDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmnoticeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmNotice-NOTICE_RSZYDQ-all')")
	@ApiOperation(value = "获取人事专员的提醒", tags = {"提醒消息" } ,notes = "获取人事专员的提醒")
    @RequestMapping(method= RequestMethod.GET , value="/pcmnotices/fetchnotice_rszydq")
	public ResponseEntity<List<PcmNoticeDTO>> fetchNOTICE_RSZYDQ(PcmNoticeSearchContext context) {
        Page<PcmNotice> domains = pcmnoticeService.searchNOTICE_RSZYDQ(context) ;
        List<PcmNoticeDTO> list = pcmnoticeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmNotice-NOTICE_RSZYDQ-all')")
	@ApiOperation(value = "查询人事专员的提醒", tags = {"提醒消息" } ,notes = "查询人事专员的提醒")
    @RequestMapping(method= RequestMethod.POST , value="/pcmnotices/searchnotice_rszydq")
	public ResponseEntity<Page<PcmNoticeDTO>> searchNOTICE_RSZYDQ(@RequestBody PcmNoticeSearchContext context) {
        Page<PcmNotice> domains = pcmnoticeService.searchNOTICE_RSZYDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmnoticeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmNotice-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"提醒消息" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmnotices/fetchdefault")
	public ResponseEntity<List<PcmNoticeDTO>> fetchDefault(PcmNoticeSearchContext context) {
        Page<PcmNotice> domains = pcmnoticeService.searchDefault(context) ;
        List<PcmNoticeDTO> list = pcmnoticeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmNotice-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"提醒消息" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmnotices/searchdefault")
	public ResponseEntity<Page<PcmNoticeDTO>> searchDefault(@RequestBody PcmNoticeSearchContext context) {
        Page<PcmNotice> domains = pcmnoticeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmnoticeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmNotice-NOTICE_SBFLZYDQ-all')")
	@ApiOperation(value = "获取社保福利专员的提醒", tags = {"提醒消息" } ,notes = "获取社保福利专员的提醒")
    @RequestMapping(method= RequestMethod.GET , value="/pcmnotices/fetchnotice_sbflzydq")
	public ResponseEntity<List<PcmNoticeDTO>> fetchNOTICE_SBFLZYDQ(PcmNoticeSearchContext context) {
        Page<PcmNotice> domains = pcmnoticeService.searchNOTICE_SBFLZYDQ(context) ;
        List<PcmNoticeDTO> list = pcmnoticeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmNotice-NOTICE_SBFLZYDQ-all')")
	@ApiOperation(value = "查询社保福利专员的提醒", tags = {"提醒消息" } ,notes = "查询社保福利专员的提醒")
    @RequestMapping(method= RequestMethod.POST , value="/pcmnotices/searchnotice_sbflzydq")
	public ResponseEntity<Page<PcmNoticeDTO>> searchNOTICE_SBFLZYDQ(@RequestBody PcmNoticeSearchContext context) {
        Page<PcmNotice> domains = pcmnoticeService.searchNOTICE_SBFLZYDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmnoticeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

