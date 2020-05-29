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
import cn.ibizlab.ehr.core.pcm.domain.PcmGbhmc;
import cn.ibizlab.ehr.core.pcm.service.IPcmGbhmcService;
import cn.ibizlab.ehr.core.pcm.filter.PcmGbhmcSearchContext;

@Slf4j
@Api(tags = {"干部花名册" })
@RestController("WebApi-pcmgbhmc")
@RequestMapping("")
public class PcmGbhmcResource {

    @Autowired
    public IPcmGbhmcService pcmgbhmcService;

    @Autowired
    @Lazy
    public PcmGbhmcMapping pcmgbhmcMapping;

    @PreAuthorize("hasPermission(this.pcmgbhmcService.get(#pcmgbhmc_id),'ehr-PcmGbhmc-Remove')")
    @ApiOperation(value = "删除干部花名册", tags = {"干部花名册" },  notes = "删除干部花名册")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmgbhmcs/{pcmgbhmc_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmgbhmc_id") String pcmgbhmc_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmgbhmcService.remove(pcmgbhmc_id));
    }

    @PreAuthorize("hasPermission(this.pcmgbhmcService.getPcmgbhmcByIds(#ids),'ehr-PcmGbhmc-Remove')")
    @ApiOperation(value = "批量删除干部花名册", tags = {"干部花名册" },  notes = "批量删除干部花名册")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmgbhmcs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmgbhmcService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmgbhmcMapping.toDomain(returnObject.body),'ehr-PcmGbhmc-Get')")
    @ApiOperation(value = "获取干部花名册", tags = {"干部花名册" },  notes = "获取干部花名册")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmgbhmcs/{pcmgbhmc_id}")
    public ResponseEntity<PcmGbhmcDTO> get(@PathVariable("pcmgbhmc_id") String pcmgbhmc_id) {
        PcmGbhmc domain = pcmgbhmcService.get(pcmgbhmc_id);
        PcmGbhmcDTO dto = pcmgbhmcMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmGbhmc-ToggleLeader-all')")
    @ApiOperation(value = "设置/取消为领导班子", tags = {"干部花名册" },  notes = "设置/取消为领导班子")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgbhmcs/{pcmgbhmc_id}/toggleleader")
    @Transactional
    public ResponseEntity<PcmGbhmcDTO> toggleLeader(@PathVariable("pcmgbhmc_id") String pcmgbhmc_id, @RequestBody PcmGbhmcDTO pcmgbhmcdto) {
        PcmGbhmc pcmgbhmc = pcmgbhmcMapping.toDomain(pcmgbhmcdto);
        pcmgbhmc.setPimpersonid(pcmgbhmc_id);
        pcmgbhmc = pcmgbhmcService.toggleLeader(pcmgbhmc);
        pcmgbhmcdto = pcmgbhmcMapping.toDto(pcmgbhmc);
        return ResponseEntity.status(HttpStatus.OK).body(pcmgbhmcdto);
    }

    @ApiOperation(value = "获取干部花名册草稿", tags = {"干部花名册" },  notes = "获取干部花名册草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmgbhmcs/getdraft")
    public ResponseEntity<PcmGbhmcDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmgbhmcMapping.toDto(pcmgbhmcService.getDraft(new PcmGbhmc())));
    }

    @PreAuthorize("hasPermission(this.pcmgbhmcMapping.toDomain(#pcmgbhmcdto),'ehr-PcmGbhmc-Create')")
    @ApiOperation(value = "新建干部花名册", tags = {"干部花名册" },  notes = "新建干部花名册")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgbhmcs")
    @Transactional
    public ResponseEntity<PcmGbhmcDTO> create(@RequestBody PcmGbhmcDTO pcmgbhmcdto) {
        PcmGbhmc domain = pcmgbhmcMapping.toDomain(pcmgbhmcdto);
		pcmgbhmcService.create(domain);
        PcmGbhmcDTO dto = pcmgbhmcMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmgbhmcMapping.toDomain(#pcmgbhmcdtos),'ehr-PcmGbhmc-Create')")
    @ApiOperation(value = "批量新建干部花名册", tags = {"干部花名册" },  notes = "批量新建干部花名册")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgbhmcs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmGbhmcDTO> pcmgbhmcdtos) {
        pcmgbhmcService.createBatch(pcmgbhmcMapping.toDomain(pcmgbhmcdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmgbhmcService.get(#pcmgbhmc_id),'ehr-PcmGbhmc-Update')")
    @ApiOperation(value = "更新干部花名册", tags = {"干部花名册" },  notes = "更新干部花名册")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmgbhmcs/{pcmgbhmc_id}")
    @Transactional
    public ResponseEntity<PcmGbhmcDTO> update(@PathVariable("pcmgbhmc_id") String pcmgbhmc_id, @RequestBody PcmGbhmcDTO pcmgbhmcdto) {
		PcmGbhmc domain  = pcmgbhmcMapping.toDomain(pcmgbhmcdto);
        domain .setPimpersonid(pcmgbhmc_id);
		pcmgbhmcService.update(domain );
		PcmGbhmcDTO dto = pcmgbhmcMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmgbhmcService.getPcmgbhmcByEntities(this.pcmgbhmcMapping.toDomain(#pcmgbhmcdtos)),'ehr-PcmGbhmc-Update')")
    @ApiOperation(value = "批量更新干部花名册", tags = {"干部花名册" },  notes = "批量更新干部花名册")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmgbhmcs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmGbhmcDTO> pcmgbhmcdtos) {
        pcmgbhmcService.updateBatch(pcmgbhmcMapping.toDomain(pcmgbhmcdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmgbhmcMapping.toDomain(#pcmgbhmcdto),'ehr-PcmGbhmc-Save')")
    @ApiOperation(value = "保存干部花名册", tags = {"干部花名册" },  notes = "保存干部花名册")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgbhmcs/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmGbhmcDTO pcmgbhmcdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmgbhmcService.save(pcmgbhmcMapping.toDomain(pcmgbhmcdto)));
    }

    @PreAuthorize("hasPermission(this.pcmgbhmcMapping.toDomain(#pcmgbhmcdtos),'ehr-PcmGbhmc-Save')")
    @ApiOperation(value = "批量保存干部花名册", tags = {"干部花名册" },  notes = "批量保存干部花名册")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgbhmcs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmGbhmcDTO> pcmgbhmcdtos) {
        pcmgbhmcService.saveBatch(pcmgbhmcMapping.toDomain(pcmgbhmcdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmGbhmc-SGTG-all')")
    @ApiOperation(value = "试岗通过", tags = {"干部花名册" },  notes = "试岗通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgbhmcs/{pcmgbhmc_id}/sgtg")
    @Transactional
    public ResponseEntity<PcmGbhmcDTO> sGTG(@PathVariable("pcmgbhmc_id") String pcmgbhmc_id, @RequestBody PcmGbhmcDTO pcmgbhmcdto) {
        PcmGbhmc pcmgbhmc = pcmgbhmcMapping.toDomain(pcmgbhmcdto);
        pcmgbhmc.setPimpersonid(pcmgbhmc_id);
        pcmgbhmc = pcmgbhmcService.sGTG(pcmgbhmc);
        pcmgbhmcdto = pcmgbhmcMapping.toDto(pcmgbhmc);
        return ResponseEntity.status(HttpStatus.OK).body(pcmgbhmcdto);
    }

    @ApiOperation(value = "检查干部花名册", tags = {"干部花名册" },  notes = "检查干部花名册")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgbhmcs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmGbhmcDTO pcmgbhmcdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmgbhmcService.checkKey(pcmgbhmcMapping.toDomain(pcmgbhmcdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmGbhmc-SGBTG-all')")
    @ApiOperation(value = "试岗不通过", tags = {"干部花名册" },  notes = "试岗不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgbhmcs/{pcmgbhmc_id}/sgbtg")
    @Transactional
    public ResponseEntity<PcmGbhmcDTO> sGBTG(@PathVariable("pcmgbhmc_id") String pcmgbhmc_id, @RequestBody PcmGbhmcDTO pcmgbhmcdto) {
        PcmGbhmc pcmgbhmc = pcmgbhmcMapping.toDomain(pcmgbhmcdto);
        pcmgbhmc.setPimpersonid(pcmgbhmc_id);
        pcmgbhmc = pcmgbhmcService.sGBTG(pcmgbhmc);
        pcmgbhmcdto = pcmgbhmcMapping.toDto(pcmgbhmc);
        return ResponseEntity.status(HttpStatus.OK).body(pcmgbhmcdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmGbhmc-GBHMCNewTree-all')")
	@ApiOperation(value = "获取树视图的干部花名册（新）", tags = {"干部花名册" } ,notes = "获取树视图的干部花名册（新）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmgbhmcs/fetchgbhmcnewtree")
	public ResponseEntity<List<PcmGbhmcDTO>> fetchGBHMCNewTree(PcmGbhmcSearchContext context) {
        Page<PcmGbhmc> domains = pcmgbhmcService.searchGBHMCNewTree(context) ;
        List<PcmGbhmcDTO> list = pcmgbhmcMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmGbhmc-GBHMCNewTree-all')")
	@ApiOperation(value = "查询树视图的干部花名册（新）", tags = {"干部花名册" } ,notes = "查询树视图的干部花名册（新）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmgbhmcs/searchgbhmcnewtree")
	public ResponseEntity<Page<PcmGbhmcDTO>> searchGBHMCNewTree(@RequestBody PcmGbhmcSearchContext context) {
        Page<PcmGbhmc> domains = pcmgbhmcService.searchGBHMCNewTree(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmgbhmcMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmGbhmc-GBHMCTree-all')")
	@ApiOperation(value = "获取树视图的干部花名册", tags = {"干部花名册" } ,notes = "获取树视图的干部花名册")
    @RequestMapping(method= RequestMethod.GET , value="/pcmgbhmcs/fetchgbhmctree")
	public ResponseEntity<List<PcmGbhmcDTO>> fetchGBHMCTree(PcmGbhmcSearchContext context) {
        Page<PcmGbhmc> domains = pcmgbhmcService.searchGBHMCTree(context) ;
        List<PcmGbhmcDTO> list = pcmgbhmcMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmGbhmc-GBHMCTree-all')")
	@ApiOperation(value = "查询树视图的干部花名册", tags = {"干部花名册" } ,notes = "查询树视图的干部花名册")
    @RequestMapping(method= RequestMethod.POST , value="/pcmgbhmcs/searchgbhmctree")
	public ResponseEntity<Page<PcmGbhmcDTO>> searchGBHMCTree(@RequestBody PcmGbhmcSearchContext context) {
        Page<PcmGbhmc> domains = pcmgbhmcService.searchGBHMCTree(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmgbhmcMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmGbhmc-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"干部花名册" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmgbhmcs/fetchdefault")
	public ResponseEntity<List<PcmGbhmcDTO>> fetchDefault(PcmGbhmcSearchContext context) {
        Page<PcmGbhmc> domains = pcmgbhmcService.searchDefault(context) ;
        List<PcmGbhmcDTO> list = pcmgbhmcMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmGbhmc-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"干部花名册" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmgbhmcs/searchdefault")
	public ResponseEntity<Page<PcmGbhmcDTO>> searchDefault(@RequestBody PcmGbhmcSearchContext context) {
        Page<PcmGbhmc> domains = pcmgbhmcService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmgbhmcMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmGbhmc-ZJPD-all')")
	@ApiOperation(value = "获取ZJPD", tags = {"干部花名册" } ,notes = "获取ZJPD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmgbhmcs/fetchzjpd")
	public ResponseEntity<List<PcmGbhmcDTO>> fetchZJPD(PcmGbhmcSearchContext context) {
        Page<PcmGbhmc> domains = pcmgbhmcService.searchZJPD(context) ;
        List<PcmGbhmcDTO> list = pcmgbhmcMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmGbhmc-ZJPD-all')")
	@ApiOperation(value = "查询ZJPD", tags = {"干部花名册" } ,notes = "查询ZJPD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmgbhmcs/searchzjpd")
	public ResponseEntity<Page<PcmGbhmcDTO>> searchZJPD(@RequestBody PcmGbhmcSearchContext context) {
        Page<PcmGbhmc> domains = pcmgbhmcService.searchZJPD(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmgbhmcMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

