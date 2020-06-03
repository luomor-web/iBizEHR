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
import cn.ibizlab.ehr.core.pcm.domain.PcmRcxl;
import cn.ibizlab.ehr.core.pcm.service.IPcmRcxlService;
import cn.ibizlab.ehr.core.pcm.filter.PcmRcxlSearchContext;

@Slf4j
@Api(tags = {"人才序列" })
@RestController("WebApi-pcmrcxl")
@RequestMapping("")
public class PcmRcxlResource {

    @Autowired
    public IPcmRcxlService pcmrcxlService;

    @Autowired
    @Lazy
    public PcmRcxlMapping pcmrcxlMapping;

    @PreAuthorize("hasPermission(this.pcmrcxlMapping.toDomain(#pcmrcxldto),'ehr-PcmRcxl-Create')")
    @ApiOperation(value = "新建人才序列", tags = {"人才序列" },  notes = "新建人才序列")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrcxls")
    @Transactional
    public ResponseEntity<PcmRcxlDTO> create(@RequestBody PcmRcxlDTO pcmrcxldto) {
        PcmRcxl domain = pcmrcxlMapping.toDomain(pcmrcxldto);
		pcmrcxlService.create(domain);
        PcmRcxlDTO dto = pcmrcxlMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmrcxlMapping.toDomain(#pcmrcxldtos),'ehr-PcmRcxl-Create')")
    @ApiOperation(value = "批量新建人才序列", tags = {"人才序列" },  notes = "批量新建人才序列")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrcxls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmRcxlDTO> pcmrcxldtos) {
        pcmrcxlService.createBatch(pcmrcxlMapping.toDomain(pcmrcxldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取人才序列草稿", tags = {"人才序列" },  notes = "获取人才序列草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmrcxls/getdraft")
    public ResponseEntity<PcmRcxlDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmrcxlMapping.toDto(pcmrcxlService.getDraft(new PcmRcxl())));
    }

    @PostAuthorize("hasPermission(this.pcmrcxlMapping.toDomain(returnObject.body),'ehr-PcmRcxl-Get')")
    @ApiOperation(value = "获取人才序列", tags = {"人才序列" },  notes = "获取人才序列")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmrcxls/{pcmrcxl_id}")
    public ResponseEntity<PcmRcxlDTO> get(@PathVariable("pcmrcxl_id") String pcmrcxl_id) {
        PcmRcxl domain = pcmrcxlService.get(pcmrcxl_id);
        PcmRcxlDTO dto = pcmrcxlMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmrcxlService.get(#pcmrcxl_id),'ehr-PcmRcxl-Remove')")
    @ApiOperation(value = "删除人才序列", tags = {"人才序列" },  notes = "删除人才序列")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmrcxls/{pcmrcxl_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmrcxl_id") String pcmrcxl_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmrcxlService.remove(pcmrcxl_id));
    }

    @PreAuthorize("hasPermission(this.pcmrcxlService.getPcmrcxlByIds(#ids),'ehr-PcmRcxl-Remove')")
    @ApiOperation(value = "批量删除人才序列", tags = {"人才序列" },  notes = "批量删除人才序列")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmrcxls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmrcxlService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmrcxlService.get(#pcmrcxl_id),'ehr-PcmRcxl-Update')")
    @ApiOperation(value = "更新人才序列", tags = {"人才序列" },  notes = "更新人才序列")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmrcxls/{pcmrcxl_id}")
    @Transactional
    public ResponseEntity<PcmRcxlDTO> update(@PathVariable("pcmrcxl_id") String pcmrcxl_id, @RequestBody PcmRcxlDTO pcmrcxldto) {
		PcmRcxl domain  = pcmrcxlMapping.toDomain(pcmrcxldto);
        domain .setPcmrcxlid(pcmrcxl_id);
		pcmrcxlService.update(domain );
		PcmRcxlDTO dto = pcmrcxlMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmrcxlService.getPcmrcxlByEntities(this.pcmrcxlMapping.toDomain(#pcmrcxldtos)),'ehr-PcmRcxl-Update')")
    @ApiOperation(value = "批量更新人才序列", tags = {"人才序列" },  notes = "批量更新人才序列")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmrcxls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmRcxlDTO> pcmrcxldtos) {
        pcmrcxlService.updateBatch(pcmrcxlMapping.toDomain(pcmrcxldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查人才序列", tags = {"人才序列" },  notes = "检查人才序列")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrcxls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmRcxlDTO pcmrcxldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmrcxlService.checkKey(pcmrcxlMapping.toDomain(pcmrcxldto)));
    }

    @PreAuthorize("hasPermission(this.pcmrcxlMapping.toDomain(#pcmrcxldto),'ehr-PcmRcxl-Save')")
    @ApiOperation(value = "保存人才序列", tags = {"人才序列" },  notes = "保存人才序列")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrcxls/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmRcxlDTO pcmrcxldto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmrcxlService.save(pcmrcxlMapping.toDomain(pcmrcxldto)));
    }

    @PreAuthorize("hasPermission(this.pcmrcxlMapping.toDomain(#pcmrcxldtos),'ehr-PcmRcxl-Save')")
    @ApiOperation(value = "批量保存人才序列", tags = {"人才序列" },  notes = "批量保存人才序列")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmrcxls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmRcxlDTO> pcmrcxldtos) {
        pcmrcxlService.saveBatch(pcmrcxlMapping.toDomain(pcmrcxldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmRcxl-Current-all')")
	@ApiOperation(value = "获取查询当前人才序列下的序列", tags = {"人才序列" } ,notes = "获取查询当前人才序列下的序列")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrcxls/fetchcurrent")
	public ResponseEntity<List<PcmRcxlDTO>> fetchCurrent(PcmRcxlSearchContext context) {
        Page<PcmRcxl> domains = pcmrcxlService.searchCurrent(context) ;
        List<PcmRcxlDTO> list = pcmrcxlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmRcxl-Current-all')")
	@ApiOperation(value = "查询查询当前人才序列下的序列", tags = {"人才序列" } ,notes = "查询查询当前人才序列下的序列")
    @RequestMapping(method= RequestMethod.POST , value="/pcmrcxls/searchcurrent")
	public ResponseEntity<Page<PcmRcxlDTO>> searchCurrent(@RequestBody PcmRcxlSearchContext context) {
        Page<PcmRcxl> domains = pcmrcxlService.searchCurrent(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmrcxlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmRcxl-RCXLPPXLLX-all')")
	@ApiOperation(value = "获取人才序列匹配人才序列类型", tags = {"人才序列" } ,notes = "获取人才序列匹配人才序列类型")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrcxls/fetchrcxlppxllx")
	public ResponseEntity<List<PcmRcxlDTO>> fetchRCXLPPXLLX(PcmRcxlSearchContext context) {
        Page<PcmRcxl> domains = pcmrcxlService.searchRCXLPPXLLX(context) ;
        List<PcmRcxlDTO> list = pcmrcxlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmRcxl-RCXLPPXLLX-all')")
	@ApiOperation(value = "查询人才序列匹配人才序列类型", tags = {"人才序列" } ,notes = "查询人才序列匹配人才序列类型")
    @RequestMapping(method= RequestMethod.POST , value="/pcmrcxls/searchrcxlppxllx")
	public ResponseEntity<Page<PcmRcxlDTO>> searchRCXLPPXLLX(@RequestBody PcmRcxlSearchContext context) {
        Page<PcmRcxl> domains = pcmrcxlService.searchRCXLPPXLLX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmrcxlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmRcxl-ZiDQ-all')")
	@ApiOperation(value = "获取子查询", tags = {"人才序列" } ,notes = "获取子查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrcxls/fetchzidq")
	public ResponseEntity<List<PcmRcxlDTO>> fetchZiDQ(PcmRcxlSearchContext context) {
        Page<PcmRcxl> domains = pcmrcxlService.searchZiDQ(context) ;
        List<PcmRcxlDTO> list = pcmrcxlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmRcxl-ZiDQ-all')")
	@ApiOperation(value = "查询子查询", tags = {"人才序列" } ,notes = "查询子查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmrcxls/searchzidq")
	public ResponseEntity<Page<PcmRcxlDTO>> searchZiDQ(@RequestBody PcmRcxlSearchContext context) {
        Page<PcmRcxl> domains = pcmrcxlService.searchZiDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmrcxlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmRcxl-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"人才序列" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrcxls/fetchdefault")
	public ResponseEntity<List<PcmRcxlDTO>> fetchDefault(PcmRcxlSearchContext context) {
        Page<PcmRcxl> domains = pcmrcxlService.searchDefault(context) ;
        List<PcmRcxlDTO> list = pcmrcxlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmRcxl-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"人才序列" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmrcxls/searchdefault")
	public ResponseEntity<Page<PcmRcxlDTO>> searchDefault(@RequestBody PcmRcxlSearchContext context) {
        Page<PcmRcxl> domains = pcmrcxlService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmrcxlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmRcxl-GenDQ-all')")
	@ApiOperation(value = "获取根查询", tags = {"人才序列" } ,notes = "获取根查询")
    @RequestMapping(method= RequestMethod.GET , value="/pcmrcxls/fetchgendq")
	public ResponseEntity<List<PcmRcxlDTO>> fetchGenDQ(PcmRcxlSearchContext context) {
        Page<PcmRcxl> domains = pcmrcxlService.searchGenDQ(context) ;
        List<PcmRcxlDTO> list = pcmrcxlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmRcxl-GenDQ-all')")
	@ApiOperation(value = "查询根查询", tags = {"人才序列" } ,notes = "查询根查询")
    @RequestMapping(method= RequestMethod.POST , value="/pcmrcxls/searchgendq")
	public ResponseEntity<Page<PcmRcxlDTO>> searchGenDQ(@RequestBody PcmRcxlSearchContext context) {
        Page<PcmRcxl> domains = pcmrcxlService.searchGenDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmrcxlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

