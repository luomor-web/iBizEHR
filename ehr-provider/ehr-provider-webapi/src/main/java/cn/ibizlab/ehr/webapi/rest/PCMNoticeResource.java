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
import cn.ibizlab.ehr.core.pcm.domain.PCMNotice;
import cn.ibizlab.ehr.core.pcm.service.IPCMNoticeService;
import cn.ibizlab.ehr.core.pcm.filter.PCMNoticeSearchContext;

@Slf4j
@Api(tags = {"PCMNotice" })
@RestController("WebApi-pcmnotice")
@RequestMapping("")
public class PCMNoticeResource {

    @Autowired
    public IPCMNoticeService pcmnoticeService;

    @Autowired
    @Lazy
    public PCMNoticeMapping pcmnoticeMapping;

    @PreAuthorize("hasPermission(this.pcmnoticeMapping.toDomain(#pcmnoticedto),'ehr-PCMNotice-Create')")
    @ApiOperation(value = "Create", tags = {"PCMNotice" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmnotices")
    @Transactional
    public ResponseEntity<PCMNoticeDTO> create(@RequestBody PCMNoticeDTO pcmnoticedto) {
        PCMNotice domain = pcmnoticeMapping.toDomain(pcmnoticedto);
		pcmnoticeService.create(domain);
        PCMNoticeDTO dto = pcmnoticeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmnoticeMapping.toDomain(#pcmnoticedtos),'ehr-PCMNotice-Create')")
    @ApiOperation(value = "createBatch", tags = {"PCMNotice" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmnotices/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMNoticeDTO> pcmnoticedtos) {
        pcmnoticeService.createBatch(pcmnoticeMapping.toDomain(pcmnoticedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmnoticeService.get(#pcmnotice_id),'ehr-PCMNotice-Update')")
    @ApiOperation(value = "Update", tags = {"PCMNotice" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmnotices/{pcmnotice_id}")
    @Transactional
    public ResponseEntity<PCMNoticeDTO> update(@PathVariable("pcmnotice_id") String pcmnotice_id, @RequestBody PCMNoticeDTO pcmnoticedto) {
		PCMNotice domain  = pcmnoticeMapping.toDomain(pcmnoticedto);
        domain .setPcmnoticeid(pcmnotice_id);
		pcmnoticeService.update(domain );
		PCMNoticeDTO dto = pcmnoticeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmnoticeService.getPcmnoticeByEntities(this.pcmnoticeMapping.toDomain(#pcmnoticedtos)),'ehr-PCMNotice-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMNotice" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmnotices/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMNoticeDTO> pcmnoticedtos) {
        pcmnoticeService.updateBatch(pcmnoticeMapping.toDomain(pcmnoticedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmnoticeMapping.toDomain(#pcmnoticedto),'ehr-PCMNotice-Save')")
    @ApiOperation(value = "Save", tags = {"PCMNotice" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmnotices/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMNoticeDTO pcmnoticedto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmnoticeService.save(pcmnoticeMapping.toDomain(pcmnoticedto)));
    }

    @PreAuthorize("hasPermission(this.pcmnoticeMapping.toDomain(#pcmnoticedtos),'ehr-PCMNotice-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PCMNotice" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmnotices/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMNoticeDTO> pcmnoticedtos) {
        pcmnoticeService.saveBatch(pcmnoticeMapping.toDomain(pcmnoticedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmnoticeMapping.toDomain(returnObject.body),'ehr-PCMNotice-Get')")
    @ApiOperation(value = "Get", tags = {"PCMNotice" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmnotices/{pcmnotice_id}")
    public ResponseEntity<PCMNoticeDTO> get(@PathVariable("pcmnotice_id") String pcmnotice_id) {
        PCMNotice domain = pcmnoticeService.get(pcmnotice_id);
        PCMNoticeDTO dto = pcmnoticeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "GetDraft", tags = {"PCMNotice" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmnotices/getdraft")
    public ResponseEntity<PCMNoticeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmnoticeMapping.toDto(pcmnoticeService.getDraft(new PCMNotice())));
    }

    @ApiOperation(value = "CheckKey", tags = {"PCMNotice" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmnotices/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMNoticeDTO pcmnoticedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmnoticeService.checkKey(pcmnoticeMapping.toDomain(pcmnoticedto)));
    }

    @PreAuthorize("hasPermission(this.pcmnoticeService.get(#pcmnotice_id),'ehr-PCMNotice-Remove')")
    @ApiOperation(value = "Remove", tags = {"PCMNotice" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmnotices/{pcmnotice_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmnotice_id") String pcmnotice_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmnoticeService.remove(pcmnotice_id));
    }

    @PreAuthorize("hasPermission(this.pcmnoticeService.getPcmnoticeByIds(#ids),'ehr-PCMNotice-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMNotice" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmnotices/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmnoticeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMNotice-NOTICE_DAGLYDQ-all')")
	@ApiOperation(value = "fetch档案管理员的提醒", tags = {"PCMNotice" } ,notes = "fetch档案管理员的提醒")
    @RequestMapping(method= RequestMethod.GET , value="/pcmnotices/fetchnotice_daglydq")
	public ResponseEntity<List<PCMNoticeDTO>> fetchNOTICE_DAGLYDQ(PCMNoticeSearchContext context) {
        Page<PCMNotice> domains = pcmnoticeService.searchNOTICE_DAGLYDQ(context) ;
        List<PCMNoticeDTO> list = pcmnoticeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMNotice-NOTICE_DAGLYDQ-all')")
	@ApiOperation(value = "search档案管理员的提醒", tags = {"PCMNotice" } ,notes = "search档案管理员的提醒")
    @RequestMapping(method= RequestMethod.POST , value="/pcmnotices/searchnotice_daglydq")
	public ResponseEntity<Page<PCMNoticeDTO>> searchNOTICE_DAGLYDQ(@RequestBody PCMNoticeSearchContext context) {
        Page<PCMNotice> domains = pcmnoticeService.searchNOTICE_DAGLYDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmnoticeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMNotice-NOTICE_XCZYDQ-all')")
	@ApiOperation(value = "fetch薪酬专员的提醒", tags = {"PCMNotice" } ,notes = "fetch薪酬专员的提醒")
    @RequestMapping(method= RequestMethod.GET , value="/pcmnotices/fetchnotice_xczydq")
	public ResponseEntity<List<PCMNoticeDTO>> fetchNOTICE_XCZYDQ(PCMNoticeSearchContext context) {
        Page<PCMNotice> domains = pcmnoticeService.searchNOTICE_XCZYDQ(context) ;
        List<PCMNoticeDTO> list = pcmnoticeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMNotice-NOTICE_XCZYDQ-all')")
	@ApiOperation(value = "search薪酬专员的提醒", tags = {"PCMNotice" } ,notes = "search薪酬专员的提醒")
    @RequestMapping(method= RequestMethod.POST , value="/pcmnotices/searchnotice_xczydq")
	public ResponseEntity<Page<PCMNoticeDTO>> searchNOTICE_XCZYDQ(@RequestBody PCMNoticeSearchContext context) {
        Page<PCMNotice> domains = pcmnoticeService.searchNOTICE_XCZYDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmnoticeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMNotice-NOTICE_KQZYDQ-all')")
	@ApiOperation(value = "fetch考勤专员的提醒", tags = {"PCMNotice" } ,notes = "fetch考勤专员的提醒")
    @RequestMapping(method= RequestMethod.GET , value="/pcmnotices/fetchnotice_kqzydq")
	public ResponseEntity<List<PCMNoticeDTO>> fetchNOTICE_KQZYDQ(PCMNoticeSearchContext context) {
        Page<PCMNotice> domains = pcmnoticeService.searchNOTICE_KQZYDQ(context) ;
        List<PCMNoticeDTO> list = pcmnoticeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMNotice-NOTICE_KQZYDQ-all')")
	@ApiOperation(value = "search考勤专员的提醒", tags = {"PCMNotice" } ,notes = "search考勤专员的提醒")
    @RequestMapping(method= RequestMethod.POST , value="/pcmnotices/searchnotice_kqzydq")
	public ResponseEntity<Page<PCMNoticeDTO>> searchNOTICE_KQZYDQ(@RequestBody PCMNoticeSearchContext context) {
        Page<PCMNotice> domains = pcmnoticeService.searchNOTICE_KQZYDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmnoticeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMNotice-NOTICE_RSZYDQ-all')")
	@ApiOperation(value = "fetch人事专员的提醒", tags = {"PCMNotice" } ,notes = "fetch人事专员的提醒")
    @RequestMapping(method= RequestMethod.GET , value="/pcmnotices/fetchnotice_rszydq")
	public ResponseEntity<List<PCMNoticeDTO>> fetchNOTICE_RSZYDQ(PCMNoticeSearchContext context) {
        Page<PCMNotice> domains = pcmnoticeService.searchNOTICE_RSZYDQ(context) ;
        List<PCMNoticeDTO> list = pcmnoticeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMNotice-NOTICE_RSZYDQ-all')")
	@ApiOperation(value = "search人事专员的提醒", tags = {"PCMNotice" } ,notes = "search人事专员的提醒")
    @RequestMapping(method= RequestMethod.POST , value="/pcmnotices/searchnotice_rszydq")
	public ResponseEntity<Page<PCMNoticeDTO>> searchNOTICE_RSZYDQ(@RequestBody PCMNoticeSearchContext context) {
        Page<PCMNotice> domains = pcmnoticeService.searchNOTICE_RSZYDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmnoticeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMNotice-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMNotice" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmnotices/fetchdefault")
	public ResponseEntity<List<PCMNoticeDTO>> fetchDefault(PCMNoticeSearchContext context) {
        Page<PCMNotice> domains = pcmnoticeService.searchDefault(context) ;
        List<PCMNoticeDTO> list = pcmnoticeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMNotice-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMNotice" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmnotices/searchdefault")
	public ResponseEntity<Page<PCMNoticeDTO>> searchDefault(@RequestBody PCMNoticeSearchContext context) {
        Page<PCMNotice> domains = pcmnoticeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmnoticeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMNotice-NOTICE_SBFLZYDQ-all')")
	@ApiOperation(value = "fetch社保福利专员的提醒", tags = {"PCMNotice" } ,notes = "fetch社保福利专员的提醒")
    @RequestMapping(method= RequestMethod.GET , value="/pcmnotices/fetchnotice_sbflzydq")
	public ResponseEntity<List<PCMNoticeDTO>> fetchNOTICE_SBFLZYDQ(PCMNoticeSearchContext context) {
        Page<PCMNotice> domains = pcmnoticeService.searchNOTICE_SBFLZYDQ(context) ;
        List<PCMNoticeDTO> list = pcmnoticeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMNotice-NOTICE_SBFLZYDQ-all')")
	@ApiOperation(value = "search社保福利专员的提醒", tags = {"PCMNotice" } ,notes = "search社保福利专员的提醒")
    @RequestMapping(method= RequestMethod.POST , value="/pcmnotices/searchnotice_sbflzydq")
	public ResponseEntity<Page<PCMNoticeDTO>> searchNOTICE_SBFLZYDQ(@RequestBody PCMNoticeSearchContext context) {
        Page<PCMNotice> domains = pcmnoticeService.searchNOTICE_SBFLZYDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmnoticeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

