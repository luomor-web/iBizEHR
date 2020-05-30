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
import cn.ibizlab.ehr.core.pcm.domain.PcmTxfpsq;
import cn.ibizlab.ehr.core.pcm.service.IPcmTxfpsqService;
import cn.ibizlab.ehr.core.pcm.filter.PcmTxfpsqSearchContext;

@Slf4j
@Api(tags = {"退休返聘申请" })
@RestController("WebApi-pcmtxfpsq")
@RequestMapping("")
public class PcmTxfpsqResource {

    @Autowired
    public IPcmTxfpsqService pcmtxfpsqService;

    @Autowired
    @Lazy
    public PcmTxfpsqMapping pcmtxfpsqMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTxfpsq-FillPersonInfo-all')")
    @ApiOperation(value = "填充用户信息", tags = {"退休返聘申请" },  notes = "填充用户信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxfpsqs/{pcmtxfpsq_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PcmTxfpsqDTO> fillPersonInfo(@PathVariable("pcmtxfpsq_id") String pcmtxfpsq_id, @RequestBody PcmTxfpsqDTO pcmtxfpsqdto) {
        PcmTxfpsq pcmtxfpsq = pcmtxfpsqMapping.toDomain(pcmtxfpsqdto);
        pcmtxfpsq.setPcmtxfpsqid(pcmtxfpsq_id);
        pcmtxfpsq = pcmtxfpsqService.fillPersonInfo(pcmtxfpsq);
        pcmtxfpsqdto = pcmtxfpsqMapping.toDto(pcmtxfpsq);
        return ResponseEntity.status(HttpStatus.OK).body(pcmtxfpsqdto);
    }

    @PreAuthorize("hasPermission(this.pcmtxfpsqService.get(#pcmtxfpsq_id),'ehr-PcmTxfpsq-Update')")
    @ApiOperation(value = "更新退休返聘申请", tags = {"退休返聘申请" },  notes = "更新退休返聘申请")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmtxfpsqs/{pcmtxfpsq_id}")
    @Transactional
    public ResponseEntity<PcmTxfpsqDTO> update(@PathVariable("pcmtxfpsq_id") String pcmtxfpsq_id, @RequestBody PcmTxfpsqDTO pcmtxfpsqdto) {
		PcmTxfpsq domain  = pcmtxfpsqMapping.toDomain(pcmtxfpsqdto);
        domain .setPcmtxfpsqid(pcmtxfpsq_id);
		pcmtxfpsqService.update(domain );
		PcmTxfpsqDTO dto = pcmtxfpsqMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmtxfpsqService.getPcmtxfpsqByEntities(this.pcmtxfpsqMapping.toDomain(#pcmtxfpsqdtos)),'ehr-PcmTxfpsq-Update')")
    @ApiOperation(value = "批量更新退休返聘申请", tags = {"退休返聘申请" },  notes = "批量更新退休返聘申请")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmtxfpsqs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmTxfpsqDTO> pcmtxfpsqdtos) {
        pcmtxfpsqService.updateBatch(pcmtxfpsqMapping.toDomain(pcmtxfpsqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTxfpsq-FPCZ-all')")
    @ApiOperation(value = "返聘操作", tags = {"退休返聘申请" },  notes = "返聘操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxfpsqs/{pcmtxfpsq_id}/fpcz")
    @Transactional
    public ResponseEntity<PcmTxfpsqDTO> fPCZ(@PathVariable("pcmtxfpsq_id") String pcmtxfpsq_id, @RequestBody PcmTxfpsqDTO pcmtxfpsqdto) {
        PcmTxfpsq pcmtxfpsq = pcmtxfpsqMapping.toDomain(pcmtxfpsqdto);
        pcmtxfpsq.setPcmtxfpsqid(pcmtxfpsq_id);
        pcmtxfpsq = pcmtxfpsqService.fPCZ(pcmtxfpsq);
        pcmtxfpsqdto = pcmtxfpsqMapping.toDto(pcmtxfpsq);
        return ResponseEntity.status(HttpStatus.OK).body(pcmtxfpsqdto);
    }

    @PostAuthorize("hasPermission(this.pcmtxfpsqMapping.toDomain(returnObject.body),'ehr-PcmTxfpsq-Get')")
    @ApiOperation(value = "获取退休返聘申请", tags = {"退休返聘申请" },  notes = "获取退休返聘申请")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmtxfpsqs/{pcmtxfpsq_id}")
    public ResponseEntity<PcmTxfpsqDTO> get(@PathVariable("pcmtxfpsq_id") String pcmtxfpsq_id) {
        PcmTxfpsq domain = pcmtxfpsqService.get(pcmtxfpsq_id);
        PcmTxfpsqDTO dto = pcmtxfpsqMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTxfpsq-FinishFP-all')")
    @ApiOperation(value = "完成返聘", tags = {"退休返聘申请" },  notes = "完成返聘")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxfpsqs/{pcmtxfpsq_id}/finishfp")
    @Transactional
    public ResponseEntity<PcmTxfpsqDTO> finishFP(@PathVariable("pcmtxfpsq_id") String pcmtxfpsq_id, @RequestBody PcmTxfpsqDTO pcmtxfpsqdto) {
        PcmTxfpsq pcmtxfpsq = pcmtxfpsqMapping.toDomain(pcmtxfpsqdto);
        pcmtxfpsq.setPcmtxfpsqid(pcmtxfpsq_id);
        pcmtxfpsq = pcmtxfpsqService.finishFP(pcmtxfpsq);
        pcmtxfpsqdto = pcmtxfpsqMapping.toDto(pcmtxfpsq);
        return ResponseEntity.status(HttpStatus.OK).body(pcmtxfpsqdto);
    }

    @ApiOperation(value = "获取退休返聘申请草稿", tags = {"退休返聘申请" },  notes = "获取退休返聘申请草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmtxfpsqs/getdraft")
    public ResponseEntity<PcmTxfpsqDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmtxfpsqMapping.toDto(pcmtxfpsqService.getDraft(new PcmTxfpsq())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTxfpsq-SHTG-all')")
    @ApiOperation(value = "审核通过", tags = {"退休返聘申请" },  notes = "审核通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxfpsqs/{pcmtxfpsq_id}/shtg")
    @Transactional
    public ResponseEntity<PcmTxfpsqDTO> sHTG(@PathVariable("pcmtxfpsq_id") String pcmtxfpsq_id, @RequestBody PcmTxfpsqDTO pcmtxfpsqdto) {
        PcmTxfpsq pcmtxfpsq = pcmtxfpsqMapping.toDomain(pcmtxfpsqdto);
        pcmtxfpsq.setPcmtxfpsqid(pcmtxfpsq_id);
        pcmtxfpsq = pcmtxfpsqService.sHTG(pcmtxfpsq);
        pcmtxfpsqdto = pcmtxfpsqMapping.toDto(pcmtxfpsq);
        return ResponseEntity.status(HttpStatus.OK).body(pcmtxfpsqdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTxfpsq-SHBTG-all')")
    @ApiOperation(value = "审核不通过", tags = {"退休返聘申请" },  notes = "审核不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxfpsqs/{pcmtxfpsq_id}/shbtg")
    @Transactional
    public ResponseEntity<PcmTxfpsqDTO> sHBTG(@PathVariable("pcmtxfpsq_id") String pcmtxfpsq_id, @RequestBody PcmTxfpsqDTO pcmtxfpsqdto) {
        PcmTxfpsq pcmtxfpsq = pcmtxfpsqMapping.toDomain(pcmtxfpsqdto);
        pcmtxfpsq.setPcmtxfpsqid(pcmtxfpsq_id);
        pcmtxfpsq = pcmtxfpsqService.sHBTG(pcmtxfpsq);
        pcmtxfpsqdto = pcmtxfpsqMapping.toDto(pcmtxfpsq);
        return ResponseEntity.status(HttpStatus.OK).body(pcmtxfpsqdto);
    }

    @ApiOperation(value = "检查退休返聘申请", tags = {"退休返聘申请" },  notes = "检查退休返聘申请")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxfpsqs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmTxfpsqDTO pcmtxfpsqdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmtxfpsqService.checkKey(pcmtxfpsqMapping.toDomain(pcmtxfpsqdto)));
    }

    @PreAuthorize("hasPermission(this.pcmtxfpsqMapping.toDomain(#pcmtxfpsqdto),'ehr-PcmTxfpsq-Save')")
    @ApiOperation(value = "保存退休返聘申请", tags = {"退休返聘申请" },  notes = "保存退休返聘申请")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxfpsqs/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmTxfpsqDTO pcmtxfpsqdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmtxfpsqService.save(pcmtxfpsqMapping.toDomain(pcmtxfpsqdto)));
    }

    @PreAuthorize("hasPermission(this.pcmtxfpsqMapping.toDomain(#pcmtxfpsqdtos),'ehr-PcmTxfpsq-Save')")
    @ApiOperation(value = "批量保存退休返聘申请", tags = {"退休返聘申请" },  notes = "批量保存退休返聘申请")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxfpsqs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmTxfpsqDTO> pcmtxfpsqdtos) {
        pcmtxfpsqService.saveBatch(pcmtxfpsqMapping.toDomain(pcmtxfpsqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmtxfpsqMapping.toDomain(#pcmtxfpsqdto),'ehr-PcmTxfpsq-Create')")
    @ApiOperation(value = "新建退休返聘申请", tags = {"退休返聘申请" },  notes = "新建退休返聘申请")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxfpsqs")
    @Transactional
    public ResponseEntity<PcmTxfpsqDTO> create(@RequestBody PcmTxfpsqDTO pcmtxfpsqdto) {
        PcmTxfpsq domain = pcmtxfpsqMapping.toDomain(pcmtxfpsqdto);
		pcmtxfpsqService.create(domain);
        PcmTxfpsqDTO dto = pcmtxfpsqMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmtxfpsqMapping.toDomain(#pcmtxfpsqdtos),'ehr-PcmTxfpsq-Create')")
    @ApiOperation(value = "批量新建退休返聘申请", tags = {"退休返聘申请" },  notes = "批量新建退休返聘申请")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxfpsqs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmTxfpsqDTO> pcmtxfpsqdtos) {
        pcmtxfpsqService.createBatch(pcmtxfpsqMapping.toDomain(pcmtxfpsqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmtxfpsqService.get(#pcmtxfpsq_id),'ehr-PcmTxfpsq-Remove')")
    @ApiOperation(value = "删除退休返聘申请", tags = {"退休返聘申请" },  notes = "删除退休返聘申请")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmtxfpsqs/{pcmtxfpsq_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmtxfpsq_id") String pcmtxfpsq_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmtxfpsqService.remove(pcmtxfpsq_id));
    }

    @PreAuthorize("hasPermission(this.pcmtxfpsqService.getPcmtxfpsqByIds(#ids),'ehr-PcmTxfpsq-Remove')")
    @ApiOperation(value = "批量删除退休返聘申请", tags = {"退休返聘申请" },  notes = "批量删除退休返聘申请")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmtxfpsqs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmtxfpsqService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTxfpsq-FPJL-all')")
	@ApiOperation(value = "获取返聘记录", tags = {"退休返聘申请" } ,notes = "获取返聘记录")
    @RequestMapping(method= RequestMethod.GET , value="/pcmtxfpsqs/fetchfpjl")
	public ResponseEntity<List<PcmTxfpsqDTO>> fetchFPJL(PcmTxfpsqSearchContext context) {
        Page<PcmTxfpsq> domains = pcmtxfpsqService.searchFPJL(context) ;
        List<PcmTxfpsqDTO> list = pcmtxfpsqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTxfpsq-FPJL-all')")
	@ApiOperation(value = "查询返聘记录", tags = {"退休返聘申请" } ,notes = "查询返聘记录")
    @RequestMapping(method= RequestMethod.POST , value="/pcmtxfpsqs/searchfpjl")
	public ResponseEntity<Page<PcmTxfpsqDTO>> searchFPJL(@RequestBody PcmTxfpsqSearchContext context) {
        Page<PcmTxfpsq> domains = pcmtxfpsqService.searchFPJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmtxfpsqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTxfpsq-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"退休返聘申请" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmtxfpsqs/fetchdefault")
	public ResponseEntity<List<PcmTxfpsqDTO>> fetchDefault(PcmTxfpsqSearchContext context) {
        Page<PcmTxfpsq> domains = pcmtxfpsqService.searchDefault(context) ;
        List<PcmTxfpsqDTO> list = pcmtxfpsqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTxfpsq-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"退休返聘申请" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmtxfpsqs/searchdefault")
	public ResponseEntity<Page<PcmTxfpsqDTO>> searchDefault(@RequestBody PcmTxfpsqSearchContext context) {
        Page<PcmTxfpsq> domains = pcmtxfpsqService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmtxfpsqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTxfpsq-YXSQDS-all')")
	@ApiOperation(value = "获取未审核申请", tags = {"退休返聘申请" } ,notes = "获取未审核申请")
    @RequestMapping(method= RequestMethod.GET , value="/pcmtxfpsqs/fetchyxsqds")
	public ResponseEntity<List<PcmTxfpsqDTO>> fetchYXSQDS(PcmTxfpsqSearchContext context) {
        Page<PcmTxfpsq> domains = pcmtxfpsqService.searchYXSQDS(context) ;
        List<PcmTxfpsqDTO> list = pcmtxfpsqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTxfpsq-YXSQDS-all')")
	@ApiOperation(value = "查询未审核申请", tags = {"退休返聘申请" } ,notes = "查询未审核申请")
    @RequestMapping(method= RequestMethod.POST , value="/pcmtxfpsqs/searchyxsqds")
	public ResponseEntity<Page<PcmTxfpsqDTO>> searchYXSQDS(@RequestBody PcmTxfpsqSearchContext context) {
        Page<PcmTxfpsq> domains = pcmtxfpsqService.searchYXSQDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmtxfpsqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTxfpsq-FPGL-all')")
	@ApiOperation(value = "获取返聘管理", tags = {"退休返聘申请" } ,notes = "获取返聘管理")
    @RequestMapping(method= RequestMethod.GET , value="/pcmtxfpsqs/fetchfpgl")
	public ResponseEntity<List<PcmTxfpsqDTO>> fetchFPGL(PcmTxfpsqSearchContext context) {
        Page<PcmTxfpsq> domains = pcmtxfpsqService.searchFPGL(context) ;
        List<PcmTxfpsqDTO> list = pcmtxfpsqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTxfpsq-FPGL-all')")
	@ApiOperation(value = "查询返聘管理", tags = {"退休返聘申请" } ,notes = "查询返聘管理")
    @RequestMapping(method= RequestMethod.POST , value="/pcmtxfpsqs/searchfpgl")
	public ResponseEntity<Page<PcmTxfpsqDTO>> searchFPGL(@RequestBody PcmTxfpsqSearchContext context) {
        Page<PcmTxfpsq> domains = pcmtxfpsqService.searchFPGL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmtxfpsqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

