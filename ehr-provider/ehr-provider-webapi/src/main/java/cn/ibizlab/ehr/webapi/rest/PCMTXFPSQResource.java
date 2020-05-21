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
import cn.ibizlab.ehr.core.pcm.domain.PCMTXFPSQ;
import cn.ibizlab.ehr.core.pcm.service.IPCMTXFPSQService;
import cn.ibizlab.ehr.core.pcm.filter.PCMTXFPSQSearchContext;




@Slf4j
@Api(tags = {"PCMTXFPSQ" })
@RestController("WebApi-pcmtxfpsq")
@RequestMapping("")
public class PCMTXFPSQResource {

    @Autowired
    private IPCMTXFPSQService pcmtxfpsqService;

    @Autowired
    @Lazy
    public PCMTXFPSQMapping pcmtxfpsqMapping;

    public PCMTXFPSQDTO permissionDTO=new PCMTXFPSQDTO();




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMTXFPSQ-FillPersonInfo-all')")
    @ApiOperation(value = "填充用户信息", tags = {"PCMTXFPSQ" },  notes = "填充用户信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxfpsqs/{pcmtxfpsq_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PCMTXFPSQDTO> fillPersonInfo(@PathVariable("pcmtxfpsq_id") String pcmtxfpsq_id, @RequestBody PCMTXFPSQDTO pcmtxfpsqdto) {
        PCMTXFPSQ pcmtxfpsq = pcmtxfpsqMapping.toDomain(pcmtxfpsqdto);
        pcmtxfpsq = pcmtxfpsqService.fillPersonInfo(pcmtxfpsq);
        pcmtxfpsqdto = pcmtxfpsqMapping.toDto(pcmtxfpsq);
        return ResponseEntity.status(HttpStatus.OK).body(pcmtxfpsqdto);
    }




    @PreAuthorize("hasPermission(#pcmtxfpsq_id,'Update',{'Sql',this.pcmtxfpsqMapping,#pcmtxfpsqdto})")
    @ApiOperation(value = "Update", tags = {"PCMTXFPSQ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmtxfpsqs/{pcmtxfpsq_id}")
    @Transactional
    public ResponseEntity<PCMTXFPSQDTO> update(@PathVariable("pcmtxfpsq_id") String pcmtxfpsq_id, @RequestBody PCMTXFPSQDTO pcmtxfpsqdto) {
		PCMTXFPSQ domain = pcmtxfpsqMapping.toDomain(pcmtxfpsqdto);
        domain.setPcmtxfpsqid(pcmtxfpsq_id);
		pcmtxfpsqService.update(domain);
		PCMTXFPSQDTO dto = pcmtxfpsqMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "UpdateBatch", tags = {"PCMTXFPSQ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmtxfpsqs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMTXFPSQDTO> pcmtxfpsqdtos) {
        pcmtxfpsqService.updateBatch(pcmtxfpsqMapping.toDomain(pcmtxfpsqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMTXFPSQ-FPCZ-all')")
    @ApiOperation(value = "返聘操作", tags = {"PCMTXFPSQ" },  notes = "返聘操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxfpsqs/{pcmtxfpsq_id}/fpcz")
    @Transactional
    public ResponseEntity<PCMTXFPSQDTO> fPCZ(@PathVariable("pcmtxfpsq_id") String pcmtxfpsq_id, @RequestBody PCMTXFPSQDTO pcmtxfpsqdto) {
        PCMTXFPSQ pcmtxfpsq = pcmtxfpsqMapping.toDomain(pcmtxfpsqdto);
        pcmtxfpsq = pcmtxfpsqService.fPCZ(pcmtxfpsq);
        pcmtxfpsqdto = pcmtxfpsqMapping.toDto(pcmtxfpsq);
        return ResponseEntity.status(HttpStatus.OK).body(pcmtxfpsqdto);
    }




    @PreAuthorize("hasPermission(#pcmtxfpsq_id,'Get',{'Sql',this.pcmtxfpsqMapping,this.permissionDTO})")
    @ApiOperation(value = "Get", tags = {"PCMTXFPSQ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmtxfpsqs/{pcmtxfpsq_id}")
    public ResponseEntity<PCMTXFPSQDTO> get(@PathVariable("pcmtxfpsq_id") String pcmtxfpsq_id) {
        PCMTXFPSQ domain = pcmtxfpsqService.get(pcmtxfpsq_id);
        PCMTXFPSQDTO dto = pcmtxfpsqMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMTXFPSQ-FinishFP-all')")
    @ApiOperation(value = "完成返聘", tags = {"PCMTXFPSQ" },  notes = "完成返聘")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxfpsqs/{pcmtxfpsq_id}/finishfp")
    @Transactional
    public ResponseEntity<PCMTXFPSQDTO> finishFP(@PathVariable("pcmtxfpsq_id") String pcmtxfpsq_id, @RequestBody PCMTXFPSQDTO pcmtxfpsqdto) {
        PCMTXFPSQ pcmtxfpsq = pcmtxfpsqMapping.toDomain(pcmtxfpsqdto);
        pcmtxfpsq = pcmtxfpsqService.finishFP(pcmtxfpsq);
        pcmtxfpsqdto = pcmtxfpsqMapping.toDto(pcmtxfpsq);
        return ResponseEntity.status(HttpStatus.OK).body(pcmtxfpsqdto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMTXFPSQ-GetDraft-all')")
    @ApiOperation(value = "GetDraft", tags = {"PCMTXFPSQ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmtxfpsqs/getdraft")
    public ResponseEntity<PCMTXFPSQDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmtxfpsqMapping.toDto(pcmtxfpsqService.getDraft(new PCMTXFPSQ())));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMTXFPSQ-SHTG-all')")
    @ApiOperation(value = "审核通过", tags = {"PCMTXFPSQ" },  notes = "审核通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxfpsqs/{pcmtxfpsq_id}/shtg")
    @Transactional
    public ResponseEntity<PCMTXFPSQDTO> sHTG(@PathVariable("pcmtxfpsq_id") String pcmtxfpsq_id, @RequestBody PCMTXFPSQDTO pcmtxfpsqdto) {
        PCMTXFPSQ pcmtxfpsq = pcmtxfpsqMapping.toDomain(pcmtxfpsqdto);
        pcmtxfpsq = pcmtxfpsqService.sHTG(pcmtxfpsq);
        pcmtxfpsqdto = pcmtxfpsqMapping.toDto(pcmtxfpsq);
        return ResponseEntity.status(HttpStatus.OK).body(pcmtxfpsqdto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMTXFPSQ-SHBTG-all')")
    @ApiOperation(value = "审核不通过", tags = {"PCMTXFPSQ" },  notes = "审核不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxfpsqs/{pcmtxfpsq_id}/shbtg")
    @Transactional
    public ResponseEntity<PCMTXFPSQDTO> sHBTG(@PathVariable("pcmtxfpsq_id") String pcmtxfpsq_id, @RequestBody PCMTXFPSQDTO pcmtxfpsqdto) {
        PCMTXFPSQ pcmtxfpsq = pcmtxfpsqMapping.toDomain(pcmtxfpsqdto);
        pcmtxfpsq = pcmtxfpsqService.sHBTG(pcmtxfpsq);
        pcmtxfpsqdto = pcmtxfpsqMapping.toDto(pcmtxfpsq);
        return ResponseEntity.status(HttpStatus.OK).body(pcmtxfpsqdto);
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMTXFPSQ-CheckKey-all')")
    @ApiOperation(value = "CheckKey", tags = {"PCMTXFPSQ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxfpsqs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMTXFPSQDTO pcmtxfpsqdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmtxfpsqService.checkKey(pcmtxfpsqMapping.toDomain(pcmtxfpsqdto)));
    }




    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMTXFPSQ-Save-all')")
    @ApiOperation(value = "Save", tags = {"PCMTXFPSQ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxfpsqs/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMTXFPSQDTO pcmtxfpsqdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmtxfpsqService.save(pcmtxfpsqMapping.toDomain(pcmtxfpsqdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMTXFPSQ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxfpsqs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMTXFPSQDTO> pcmtxfpsqdtos) {
        pcmtxfpsqService.saveBatch(pcmtxfpsqMapping.toDomain(pcmtxfpsqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{'Sql',this.pcmtxfpsqMapping,#pcmtxfpsqdto})")
    @ApiOperation(value = "Create", tags = {"PCMTXFPSQ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxfpsqs")
    @Transactional
    public ResponseEntity<PCMTXFPSQDTO> create(@RequestBody PCMTXFPSQDTO pcmtxfpsqdto) {
        PCMTXFPSQ domain = pcmtxfpsqMapping.toDomain(pcmtxfpsqdto);
		pcmtxfpsqService.create(domain);
        PCMTXFPSQDTO dto = pcmtxfpsqMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "createBatch", tags = {"PCMTXFPSQ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxfpsqs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMTXFPSQDTO> pcmtxfpsqdtos) {
        pcmtxfpsqService.createBatch(pcmtxfpsqMapping.toDomain(pcmtxfpsqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmtxfpsq_id,'Remove',{'Sql',this.pcmtxfpsqMapping,this.permissionDTO})")
    @ApiOperation(value = "Remove", tags = {"PCMTXFPSQ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmtxfpsqs/{pcmtxfpsq_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmtxfpsq_id") String pcmtxfpsq_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmtxfpsqService.remove(pcmtxfpsq_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PCMTXFPSQ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmtxfpsqs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmtxfpsqService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMTXFPSQ-FPJL-all')")
	@ApiOperation(value = "fetch返聘记录", tags = {"PCMTXFPSQ" } ,notes = "fetch返聘记录")
    @RequestMapping(method= RequestMethod.GET , value="/pcmtxfpsqs/fetchfpjl")
	public ResponseEntity<List<PCMTXFPSQDTO>> fetchFPJL(PCMTXFPSQSearchContext context) {
        Page<PCMTXFPSQ> domains = pcmtxfpsqService.searchFPJL(context) ;
        List<PCMTXFPSQDTO> list = pcmtxfpsqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMTXFPSQ-FPJL-all')")
	@ApiOperation(value = "search返聘记录", tags = {"PCMTXFPSQ" } ,notes = "search返聘记录")
    @RequestMapping(method= RequestMethod.POST , value="/pcmtxfpsqs/searchfpjl")
	public ResponseEntity<Page<PCMTXFPSQDTO>> searchFPJL(@RequestBody PCMTXFPSQSearchContext context) {
        Page<PCMTXFPSQ> domains = pcmtxfpsqService.searchFPJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmtxfpsqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMTXFPSQ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMTXFPSQ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmtxfpsqs/fetchdefault")
	public ResponseEntity<List<PCMTXFPSQDTO>> fetchDefault(PCMTXFPSQSearchContext context) {
        Page<PCMTXFPSQ> domains = pcmtxfpsqService.searchDefault(context) ;
        List<PCMTXFPSQDTO> list = pcmtxfpsqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMTXFPSQ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMTXFPSQ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmtxfpsqs/searchdefault")
	public ResponseEntity<Page<PCMTXFPSQDTO>> searchDefault(@RequestBody PCMTXFPSQSearchContext context) {
        Page<PCMTXFPSQ> domains = pcmtxfpsqService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmtxfpsqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMTXFPSQ-YXSQDS-all')")
	@ApiOperation(value = "fetch未审核申请", tags = {"PCMTXFPSQ" } ,notes = "fetch未审核申请")
    @RequestMapping(method= RequestMethod.GET , value="/pcmtxfpsqs/fetchyxsqds")
	public ResponseEntity<List<PCMTXFPSQDTO>> fetchYXSQDS(PCMTXFPSQSearchContext context) {
        Page<PCMTXFPSQ> domains = pcmtxfpsqService.searchYXSQDS(context) ;
        List<PCMTXFPSQDTO> list = pcmtxfpsqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMTXFPSQ-YXSQDS-all')")
	@ApiOperation(value = "search未审核申请", tags = {"PCMTXFPSQ" } ,notes = "search未审核申请")
    @RequestMapping(method= RequestMethod.POST , value="/pcmtxfpsqs/searchyxsqds")
	public ResponseEntity<Page<PCMTXFPSQDTO>> searchYXSQDS(@RequestBody PCMTXFPSQSearchContext context) {
        Page<PCMTXFPSQ> domains = pcmtxfpsqService.searchYXSQDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmtxfpsqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMTXFPSQ-FPGL-all')")
	@ApiOperation(value = "fetch返聘管理", tags = {"PCMTXFPSQ" } ,notes = "fetch返聘管理")
    @RequestMapping(method= RequestMethod.GET , value="/pcmtxfpsqs/fetchfpgl")
	public ResponseEntity<List<PCMTXFPSQDTO>> fetchFPGL(PCMTXFPSQSearchContext context) {
        Page<PCMTXFPSQ> domains = pcmtxfpsqService.searchFPGL(context) ;
        List<PCMTXFPSQDTO> list = pcmtxfpsqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    //@PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMTXFPSQ-FPGL-all')")
	@ApiOperation(value = "search返聘管理", tags = {"PCMTXFPSQ" } ,notes = "search返聘管理")
    @RequestMapping(method= RequestMethod.POST , value="/pcmtxfpsqs/searchfpgl")
	public ResponseEntity<Page<PCMTXFPSQDTO>> searchFPGL(@RequestBody PCMTXFPSQSearchContext context) {
        Page<PCMTXFPSQ> domains = pcmtxfpsqService.searchFPGL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmtxfpsqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


}


