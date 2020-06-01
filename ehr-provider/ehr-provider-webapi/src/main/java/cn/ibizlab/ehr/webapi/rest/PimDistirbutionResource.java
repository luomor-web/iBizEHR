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
import cn.ibizlab.ehr.core.pim.domain.PimDistirbution;
import cn.ibizlab.ehr.core.pim.service.IPimDistirbutionService;
import cn.ibizlab.ehr.core.pim.filter.PimDistirbutionSearchContext;

@Slf4j
@Api(tags = {"分配信息" })
@RestController("WebApi-pimdistirbution")
@RequestMapping("")
public class PimDistirbutionResource {

    @Autowired
    public IPimDistirbutionService pimdistirbutionService;

    @Autowired
    @Lazy
    public PimDistirbutionMapping pimdistirbutionMapping;

    @PreAuthorize("hasPermission(this.pimdistirbutionService.get(#pimdistirbution_id),'ehr-PimDistirbution-Remove')")
    @ApiOperation(value = "删除分配信息", tags = {"分配信息" },  notes = "删除分配信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimdistirbutions/{pimdistirbution_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimdistirbution_id") String pimdistirbution_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimdistirbutionService.remove(pimdistirbution_id));
    }

    @PreAuthorize("hasPermission(this.pimdistirbutionService.getPimdistirbutionByIds(#ids),'ehr-PimDistirbution-Remove')")
    @ApiOperation(value = "批量删除分配信息", tags = {"分配信息" },  notes = "批量删除分配信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimdistirbutions/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimdistirbutionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查分配信息", tags = {"分配信息" },  notes = "检查分配信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimDistirbutionDTO pimdistirbutiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimdistirbutionService.checkKey(pimdistirbutionMapping.toDomain(pimdistirbutiondto)));
    }

    @PreAuthorize("hasPermission(this.pimdistirbutionService.get(#pimdistirbution_id),'ehr-PimDistirbution-Update')")
    @ApiOperation(value = "更新分配信息", tags = {"分配信息" },  notes = "更新分配信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimdistirbutions/{pimdistirbution_id}")
    @Transactional
    public ResponseEntity<PimDistirbutionDTO> update(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PimDistirbutionDTO pimdistirbutiondto) {
		PimDistirbution domain  = pimdistirbutionMapping.toDomain(pimdistirbutiondto);
        domain .setPimdistirbutionid(pimdistirbution_id);
		pimdistirbutionService.update(domain );
		PimDistirbutionDTO dto = pimdistirbutionMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimdistirbutionService.getPimdistirbutionByEntities(this.pimdistirbutionMapping.toDomain(#pimdistirbutiondtos)),'ehr-PimDistirbution-Update')")
    @ApiOperation(value = "批量更新分配信息", tags = {"分配信息" },  notes = "批量更新分配信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimdistirbutions/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimDistirbutionDTO> pimdistirbutiondtos) {
        pimdistirbutionService.updateBatch(pimdistirbutionMapping.toDomain(pimdistirbutiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取分配信息草稿", tags = {"分配信息" },  notes = "获取分配信息草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimdistirbutions/getdraft")
    public ResponseEntity<PimDistirbutionDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimdistirbutionMapping.toDto(pimdistirbutionService.getDraft(new PimDistirbution())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-DDCZC-all')")
    @ApiOperation(value = "调动出操作", tags = {"分配信息" },  notes = "调动出操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/{pimdistirbution_id}/ddczc")
    @Transactional
    public ResponseEntity<PimDistirbutionDTO> dDCZC(@PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PimDistirbutionDTO pimdistirbutiondto) {
        PimDistirbution pimdistirbution = pimdistirbutionMapping.toDomain(pimdistirbutiondto);
        pimdistirbution.setPimdistirbutionid(pimdistirbution_id);
        pimdistirbution = pimdistirbutionService.dDCZC(pimdistirbution);
        pimdistirbutiondto = pimdistirbutionMapping.toDto(pimdistirbution);
        return ResponseEntity.status(HttpStatus.OK).body(pimdistirbutiondto);
    }

    @PreAuthorize("hasPermission(this.pimdistirbutionMapping.toDomain(#pimdistirbutiondto),'ehr-PimDistirbution-Save')")
    @ApiOperation(value = "保存分配信息", tags = {"分配信息" },  notes = "保存分配信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/save")
    public ResponseEntity<Boolean> save(@RequestBody PimDistirbutionDTO pimdistirbutiondto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimdistirbutionService.save(pimdistirbutionMapping.toDomain(pimdistirbutiondto)));
    }

    @PreAuthorize("hasPermission(this.pimdistirbutionMapping.toDomain(#pimdistirbutiondtos),'ehr-PimDistirbution-Save')")
    @ApiOperation(value = "批量保存分配信息", tags = {"分配信息" },  notes = "批量保存分配信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimDistirbutionDTO> pimdistirbutiondtos) {
        pimdistirbutionService.saveBatch(pimdistirbutionMapping.toDomain(pimdistirbutiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimdistirbutionMapping.toDomain(#pimdistirbutiondto),'ehr-PimDistirbution-Create')")
    @ApiOperation(value = "新建分配信息", tags = {"分配信息" },  notes = "新建分配信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions")
    @Transactional
    public ResponseEntity<PimDistirbutionDTO> create(@RequestBody PimDistirbutionDTO pimdistirbutiondto) {
        PimDistirbution domain = pimdistirbutionMapping.toDomain(pimdistirbutiondto);
		pimdistirbutionService.create(domain);
        PimDistirbutionDTO dto = pimdistirbutionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimdistirbutionMapping.toDomain(#pimdistirbutiondtos),'ehr-PimDistirbution-Create')")
    @ApiOperation(value = "批量新建分配信息", tags = {"分配信息" },  notes = "批量新建分配信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimdistirbutions/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimDistirbutionDTO> pimdistirbutiondtos) {
        pimdistirbutionService.createBatch(pimdistirbutionMapping.toDomain(pimdistirbutiondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimdistirbutionMapping.toDomain(returnObject.body),'ehr-PimDistirbution-Get')")
    @ApiOperation(value = "获取分配信息", tags = {"分配信息" },  notes = "获取分配信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pimdistirbutions/{pimdistirbution_id}")
    public ResponseEntity<PimDistirbutionDTO> get(@PathVariable("pimdistirbution_id") String pimdistirbution_id) {
        PimDistirbution domain = pimdistirbutionService.get(pimdistirbution_id);
        PimDistirbutionDTO dto = pimdistirbutionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-GBYXZFP-all')")
	@ApiOperation(value = "获取干部可调动的分配", tags = {"分配信息" } ,notes = "获取干部可调动的分配")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchgbyxzfp")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchGBYXZFP(PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchGBYXZFP(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-GBYXZFP-all')")
	@ApiOperation(value = "查询干部可调动的分配", tags = {"分配信息" } ,notes = "查询干部可调动的分配")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchgbyxzfp")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchGBYXZFP(@RequestBody PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchGBYXZFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-LGTX-all')")
	@ApiOperation(value = "获取轮岗查询", tags = {"分配信息" } ,notes = "获取轮岗查询")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchlgtx")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchLGTX(PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchLGTX(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-LGTX-all')")
	@ApiOperation(value = "查询轮岗查询", tags = {"分配信息" } ,notes = "查询轮岗查询")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchlgtx")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchLGTX(@RequestBody PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchLGTX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-ISOUTRECORD-all')")
	@ApiOperation(value = "获取外单位履历为1的（支持增删改查）", tags = {"分配信息" } ,notes = "获取外单位履历为1的（支持增删改查）")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchisoutrecord")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchISOUTRECORD(PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchISOUTRECORD(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-ISOUTRECORD-all')")
	@ApiOperation(value = "查询外单位履历为1的（支持增删改查）", tags = {"分配信息" } ,notes = "查询外单位履历为1的（支持增删改查）")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchisoutrecord")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchISOUTRECORD(@RequestBody PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchISOUTRECORD(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-YDCFP-all')")
	@ApiOperation(value = "获取已调出分配", tags = {"分配信息" } ,notes = "获取已调出分配")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchydcfp")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchYDCFP(PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchYDCFP(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-YDCFP-all')")
	@ApiOperation(value = "查询已调出分配", tags = {"分配信息" } ,notes = "查询已调出分配")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchydcfp")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchYDCFP(@RequestBody PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchYDCFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-YXFP-all')")
	@ApiOperation(value = "获取可调动的分配(有效分配)", tags = {"分配信息" } ,notes = "获取可调动的分配(有效分配)")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchyxfp")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchYXFP(PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchYXFP(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-YXFP-all')")
	@ApiOperation(value = "查询可调动的分配(有效分配)", tags = {"分配信息" } ,notes = "查询可调动的分配(有效分配)")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchyxfp")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchYXFP(@RequestBody PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchYXFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-ZPCJFP-all')")
	@ApiOperation(value = "获取招聘创建分配", tags = {"分配信息" } ,notes = "获取招聘创建分配")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchzpcjfp")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchZPCJFP(PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchZPCJFP(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-ZPCJFP-all')")
	@ApiOperation(value = "查询招聘创建分配", tags = {"分配信息" } ,notes = "查询招聘创建分配")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchzpcjfp")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchZPCJFP(@RequestBody PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchZPCJFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-YDWQX-all')")
	@ApiOperation(value = "获取原单位权限", tags = {"分配信息" } ,notes = "获取原单位权限")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchydwqx")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchYDWQX(PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchYDWQX(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-YDWQX-all')")
	@ApiOperation(value = "查询原单位权限", tags = {"分配信息" } ,notes = "查询原单位权限")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchydwqx")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchYDWQX(@RequestBody PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchYDWQX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-DQYXFP-all')")
	@ApiOperation(value = "获取当前有效用户分配", tags = {"分配信息" } ,notes = "获取当前有效用户分配")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchdqyxfp")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchDQYXFP(PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchDQYXFP(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-DQYXFP-all')")
	@ApiOperation(value = "查询当前有效用户分配", tags = {"分配信息" } ,notes = "查询当前有效用户分配")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchdqyxfp")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchDQYXFP(@RequestBody PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchDQYXFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-JDRYHMC-all')")
	@ApiOperation(value = "获取借调人员花名册", tags = {"分配信息" } ,notes = "获取借调人员花名册")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchjdryhmc")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchJDRYHMC(PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchJDRYHMC(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-JDRYHMC-all')")
	@ApiOperation(value = "查询借调人员花名册", tags = {"分配信息" } ,notes = "查询借调人员花名册")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchjdryhmc")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchJDRYHMC(@RequestBody PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchJDRYHMC(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-JDDQ-all')")
	@ApiOperation(value = "获取借调人员", tags = {"分配信息" } ,notes = "获取借调人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchjddq")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchJDDQ(PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchJDDQ(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-JDDQ-all')")
	@ApiOperation(value = "查询借调人员", tags = {"分配信息" } ,notes = "查询借调人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchjddq")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchJDDQ(@RequestBody PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchJDDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-EXPEREENCE-all')")
	@ApiOperation(value = "获取是否主要经历（工作履历）", tags = {"分配信息" } ,notes = "获取是否主要经历（工作履历）")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchexpereence")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchEXPEREENCE(PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchEXPEREENCE(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-EXPEREENCE-all')")
	@ApiOperation(value = "查询是否主要经历（工作履历）", tags = {"分配信息" } ,notes = "查询是否主要经历（工作履历）")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchexpereence")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchEXPEREENCE(@RequestBody PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchEXPEREENCE(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-JLSS-all')")
	@ApiOperation(value = "获取记录所属和人员ID不符的", tags = {"分配信息" } ,notes = "获取记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchjlss")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchJLSS(PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchJLSS(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-JLSS-all')")
	@ApiOperation(value = "查询记录所属和人员ID不符的", tags = {"分配信息" } ,notes = "查询记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchjlss")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchJLSS(@RequestBody PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-ZIZHU-all')")
	@ApiOperation(value = "获取自助(分配信息)", tags = {"分配信息" } ,notes = "获取自助(分配信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchzizhu")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchZIZHU(PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchZIZHU(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-ZIZHU-all')")
	@ApiOperation(value = "查询自助(分配信息)", tags = {"分配信息" } ,notes = "查询自助(分配信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchzizhu")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchZIZHU(@RequestBody PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"分配信息" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchdefault")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchDefault(PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchDefault(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"分配信息" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchdefault")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchDefault(@RequestBody PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-DQFP-all')")
	@ApiOperation(value = "获取当前分配", tags = {"分配信息" } ,notes = "获取当前分配")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchdqfp")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchDQFP(PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchDQFP(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-DQFP-all')")
	@ApiOperation(value = "查询当前分配", tags = {"分配信息" } ,notes = "查询当前分配")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchdqfp")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchDQFP(@RequestBody PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchDQFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-MobDefault-all')")
	@ApiOperation(value = "获取移动端默认查询", tags = {"分配信息" } ,notes = "获取移动端默认查询")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchmobdefault")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchMobDefault(PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchMobDefault(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-MobDefault-all')")
	@ApiOperation(value = "查询移动端默认查询", tags = {"分配信息" } ,notes = "查询移动端默认查询")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchmobdefault")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchMobDefault(@RequestBody PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchMobDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-KDDYXZFP-all')")
	@ApiOperation(value = "获取可调动的有效主分配", tags = {"分配信息" } ,notes = "获取可调动的有效主分配")
    @RequestMapping(method= RequestMethod.GET , value="/pimdistirbutions/fetchkddyxzfp")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchKDDYXZFP(PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchKDDYXZFP(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-KDDYXZFP-all')")
	@ApiOperation(value = "查询可调动的有效主分配", tags = {"分配信息" } ,notes = "查询可调动的有效主分配")
    @RequestMapping(method= RequestMethod.POST , value="/pimdistirbutions/searchkddyxzfp")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchKDDYXZFP(@RequestBody PimDistirbutionSearchContext context) {
        Page<PimDistirbution> domains = pimdistirbutionService.searchKDDYXZFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasPermission(this.pimdistirbutionService.get(#pimdistirbution_id),'ehr-PimDistirbution-Remove')")
    @ApiOperation(value = "根据人员信息删除分配信息", tags = {"分配信息" },  notes = "根据人员信息删除分配信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimdistirbutionService.remove(pimdistirbution_id));
    }

    @PreAuthorize("hasPermission(this.pimdistirbutionService.getPimdistirbutionByIds(#ids),'ehr-PimDistirbution-Remove')")
    @ApiOperation(value = "根据人员信息批量删除分配信息", tags = {"分配信息" },  notes = "根据人员信息批量删除分配信息")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimdistirbutions/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimdistirbutionService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息检查分配信息", tags = {"分配信息" },  notes = "根据人员信息检查分配信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimDistirbutionDTO pimdistirbutiondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimdistirbutionService.checkKey(pimdistirbutionMapping.toDomain(pimdistirbutiondto)));
    }

    @PreAuthorize("hasPermission(this.pimdistirbutionService.get(#pimdistirbution_id),'ehr-PimDistirbution-Update')")
    @ApiOperation(value = "根据人员信息更新分配信息", tags = {"分配信息" },  notes = "根据人员信息更新分配信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}")
    @Transactional
    public ResponseEntity<PimDistirbutionDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PimDistirbutionDTO pimdistirbutiondto) {
        PimDistirbution domain = pimdistirbutionMapping.toDomain(pimdistirbutiondto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimdistirbutionid(pimdistirbution_id);
		pimdistirbutionService.update(domain);
        PimDistirbutionDTO dto = pimdistirbutionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimdistirbutionService.getPimdistirbutionByEntities(this.pimdistirbutionMapping.toDomain(#pimdistirbutiondtos)),'ehr-PimDistirbution-Update')")
    @ApiOperation(value = "根据人员信息批量更新分配信息", tags = {"分配信息" },  notes = "根据人员信息批量更新分配信息")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimdistirbutions/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimDistirbutionDTO> pimdistirbutiondtos) {
        List<PimDistirbution> domainlist=pimdistirbutionMapping.toDomain(pimdistirbutiondtos);
        for(PimDistirbution domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimdistirbutionService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "根据人员信息获取分配信息草稿", tags = {"分配信息" },  notes = "根据人员信息获取分配信息草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimdistirbutions/getdraft")
    public ResponseEntity<PimDistirbutionDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PimDistirbution domain = new PimDistirbution();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimdistirbutionMapping.toDto(pimdistirbutionService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-DDCZC-all')")
    @ApiOperation(value = "根据人员信息分配信息", tags = {"分配信息" },  notes = "根据人员信息分配信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}/ddczc")
    @Transactional
    public ResponseEntity<PimDistirbutionDTO> dDCZCByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id, @RequestBody PimDistirbutionDTO pimdistirbutiondto) {
        PimDistirbution domain = pimdistirbutionMapping.toDomain(pimdistirbutiondto);
        domain.setPimpersonid(pimperson_id);
        domain = pimdistirbutionService.dDCZC(domain) ;
        pimdistirbutiondto = pimdistirbutionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimdistirbutiondto);
    }

    @PreAuthorize("hasPermission(this.pimdistirbutionMapping.toDomain(#pimdistirbutiondto),'ehr-PimDistirbution-Save')")
    @ApiOperation(value = "根据人员信息保存分配信息", tags = {"分配信息" },  notes = "根据人员信息保存分配信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimDistirbutionDTO pimdistirbutiondto) {
        PimDistirbution domain = pimdistirbutionMapping.toDomain(pimdistirbutiondto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimdistirbutionService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimdistirbutionMapping.toDomain(#pimdistirbutiondtos),'ehr-PimDistirbution-Save')")
    @ApiOperation(value = "根据人员信息批量保存分配信息", tags = {"分配信息" },  notes = "根据人员信息批量保存分配信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimDistirbutionDTO> pimdistirbutiondtos) {
        List<PimDistirbution> domainlist=pimdistirbutionMapping.toDomain(pimdistirbutiondtos);
        for(PimDistirbution domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimdistirbutionService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimdistirbutionMapping.toDomain(#pimdistirbutiondto),'ehr-PimDistirbution-Create')")
    @ApiOperation(value = "根据人员信息建立分配信息", tags = {"分配信息" },  notes = "根据人员信息建立分配信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions")
    @Transactional
    public ResponseEntity<PimDistirbutionDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimDistirbutionDTO pimdistirbutiondto) {
        PimDistirbution domain = pimdistirbutionMapping.toDomain(pimdistirbutiondto);
        domain.setPimpersonid(pimperson_id);
		pimdistirbutionService.create(domain);
        PimDistirbutionDTO dto = pimdistirbutionMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimdistirbutionMapping.toDomain(#pimdistirbutiondtos),'ehr-PimDistirbution-Create')")
    @ApiOperation(value = "根据人员信息批量建立分配信息", tags = {"分配信息" },  notes = "根据人员信息批量建立分配信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimdistirbutions/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimDistirbutionDTO> pimdistirbutiondtos) {
        List<PimDistirbution> domainlist=pimdistirbutionMapping.toDomain(pimdistirbutiondtos);
        for(PimDistirbution domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimdistirbutionService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimdistirbutionMapping.toDomain(returnObject.body),'ehr-PimDistirbution-Get')")
    @ApiOperation(value = "根据人员信息获取分配信息", tags = {"分配信息" },  notes = "根据人员信息获取分配信息")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimdistirbutions/{pimdistirbution_id}")
    public ResponseEntity<PimDistirbutionDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimdistirbution_id") String pimdistirbution_id) {
        PimDistirbution domain = pimdistirbutionService.get(pimdistirbution_id);
        PimDistirbutionDTO dto = pimdistirbutionMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-GBYXZFP-all')")
	@ApiOperation(value = "根据人员信息获取干部可调动的分配", tags = {"分配信息" } ,notes = "根据人员信息获取干部可调动的分配")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchgbyxzfp")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchPimDistirbutionGBYXZFPByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchGBYXZFP(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-GBYXZFP-all')")
	@ApiOperation(value = "根据人员信息查询干部可调动的分配", tags = {"分配信息" } ,notes = "根据人员信息查询干部可调动的分配")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchgbyxzfp")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchPimDistirbutionGBYXZFPByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchGBYXZFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-LGTX-all')")
	@ApiOperation(value = "根据人员信息获取轮岗查询", tags = {"分配信息" } ,notes = "根据人员信息获取轮岗查询")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchlgtx")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchPimDistirbutionLGTXByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchLGTX(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-LGTX-all')")
	@ApiOperation(value = "根据人员信息查询轮岗查询", tags = {"分配信息" } ,notes = "根据人员信息查询轮岗查询")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchlgtx")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchPimDistirbutionLGTXByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchLGTX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-ISOUTRECORD-all')")
	@ApiOperation(value = "根据人员信息获取外单位履历为1的（支持增删改查）", tags = {"分配信息" } ,notes = "根据人员信息获取外单位履历为1的（支持增删改查）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchisoutrecord")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchPimDistirbutionISOUTRECORDByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchISOUTRECORD(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-ISOUTRECORD-all')")
	@ApiOperation(value = "根据人员信息查询外单位履历为1的（支持增删改查）", tags = {"分配信息" } ,notes = "根据人员信息查询外单位履历为1的（支持增删改查）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchisoutrecord")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchPimDistirbutionISOUTRECORDByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchISOUTRECORD(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-YDCFP-all')")
	@ApiOperation(value = "根据人员信息获取已调出分配", tags = {"分配信息" } ,notes = "根据人员信息获取已调出分配")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchydcfp")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchPimDistirbutionYDCFPByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchYDCFP(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-YDCFP-all')")
	@ApiOperation(value = "根据人员信息查询已调出分配", tags = {"分配信息" } ,notes = "根据人员信息查询已调出分配")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchydcfp")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchPimDistirbutionYDCFPByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchYDCFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-YXFP-all')")
	@ApiOperation(value = "根据人员信息获取可调动的分配(有效分配)", tags = {"分配信息" } ,notes = "根据人员信息获取可调动的分配(有效分配)")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchyxfp")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchPimDistirbutionYXFPByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchYXFP(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-YXFP-all')")
	@ApiOperation(value = "根据人员信息查询可调动的分配(有效分配)", tags = {"分配信息" } ,notes = "根据人员信息查询可调动的分配(有效分配)")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchyxfp")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchPimDistirbutionYXFPByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchYXFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-ZPCJFP-all')")
	@ApiOperation(value = "根据人员信息获取招聘创建分配", tags = {"分配信息" } ,notes = "根据人员信息获取招聘创建分配")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchzpcjfp")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchPimDistirbutionZPCJFPByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchZPCJFP(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-ZPCJFP-all')")
	@ApiOperation(value = "根据人员信息查询招聘创建分配", tags = {"分配信息" } ,notes = "根据人员信息查询招聘创建分配")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchzpcjfp")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchPimDistirbutionZPCJFPByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchZPCJFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-YDWQX-all')")
	@ApiOperation(value = "根据人员信息获取原单位权限", tags = {"分配信息" } ,notes = "根据人员信息获取原单位权限")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchydwqx")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchPimDistirbutionYDWQXByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchYDWQX(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-YDWQX-all')")
	@ApiOperation(value = "根据人员信息查询原单位权限", tags = {"分配信息" } ,notes = "根据人员信息查询原单位权限")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchydwqx")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchPimDistirbutionYDWQXByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchYDWQX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-DQYXFP-all')")
	@ApiOperation(value = "根据人员信息获取当前有效用户分配", tags = {"分配信息" } ,notes = "根据人员信息获取当前有效用户分配")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchdqyxfp")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchPimDistirbutionDQYXFPByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchDQYXFP(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-DQYXFP-all')")
	@ApiOperation(value = "根据人员信息查询当前有效用户分配", tags = {"分配信息" } ,notes = "根据人员信息查询当前有效用户分配")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchdqyxfp")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchPimDistirbutionDQYXFPByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchDQYXFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-JDRYHMC-all')")
	@ApiOperation(value = "根据人员信息获取借调人员花名册", tags = {"分配信息" } ,notes = "根据人员信息获取借调人员花名册")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchjdryhmc")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchPimDistirbutionJDRYHMCByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchJDRYHMC(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-JDRYHMC-all')")
	@ApiOperation(value = "根据人员信息查询借调人员花名册", tags = {"分配信息" } ,notes = "根据人员信息查询借调人员花名册")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchjdryhmc")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchPimDistirbutionJDRYHMCByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchJDRYHMC(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-JDDQ-all')")
	@ApiOperation(value = "根据人员信息获取借调人员", tags = {"分配信息" } ,notes = "根据人员信息获取借调人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchjddq")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchPimDistirbutionJDDQByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchJDDQ(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-JDDQ-all')")
	@ApiOperation(value = "根据人员信息查询借调人员", tags = {"分配信息" } ,notes = "根据人员信息查询借调人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchjddq")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchPimDistirbutionJDDQByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchJDDQ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-EXPEREENCE-all')")
	@ApiOperation(value = "根据人员信息获取是否主要经历（工作履历）", tags = {"分配信息" } ,notes = "根据人员信息获取是否主要经历（工作履历）")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchexpereence")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchPimDistirbutionEXPEREENCEByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchEXPEREENCE(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-EXPEREENCE-all')")
	@ApiOperation(value = "根据人员信息查询是否主要经历（工作履历）", tags = {"分配信息" } ,notes = "根据人员信息查询是否主要经历（工作履历）")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchexpereence")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchPimDistirbutionEXPEREENCEByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchEXPEREENCE(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-JLSS-all')")
	@ApiOperation(value = "根据人员信息获取记录所属和人员ID不符的", tags = {"分配信息" } ,notes = "根据人员信息获取记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchjlss")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchPimDistirbutionJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchJLSS(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-JLSS-all')")
	@ApiOperation(value = "根据人员信息查询记录所属和人员ID不符的", tags = {"分配信息" } ,notes = "根据人员信息查询记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchjlss")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchPimDistirbutionJLSSByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-ZIZHU-all')")
	@ApiOperation(value = "根据人员信息获取自助(分配信息)", tags = {"分配信息" } ,notes = "根据人员信息获取自助(分配信息)")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchzizhu")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchPimDistirbutionZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchZIZHU(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-ZIZHU-all')")
	@ApiOperation(value = "根据人员信息查询自助(分配信息)", tags = {"分配信息" } ,notes = "根据人员信息查询自助(分配信息)")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchzizhu")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchPimDistirbutionZIZHUByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"分配信息" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchdefault")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchPimDistirbutionDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchDefault(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"分配信息" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchdefault")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchPimDistirbutionDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-DQFP-all')")
	@ApiOperation(value = "根据人员信息获取当前分配", tags = {"分配信息" } ,notes = "根据人员信息获取当前分配")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchdqfp")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchPimDistirbutionDQFPByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchDQFP(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-DQFP-all')")
	@ApiOperation(value = "根据人员信息查询当前分配", tags = {"分配信息" } ,notes = "根据人员信息查询当前分配")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchdqfp")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchPimDistirbutionDQFPByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchDQFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-MobDefault-all')")
	@ApiOperation(value = "根据人员信息获取移动端默认查询", tags = {"分配信息" } ,notes = "根据人员信息获取移动端默认查询")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchmobdefault")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchPimDistirbutionMobDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchMobDefault(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-MobDefault-all')")
	@ApiOperation(value = "根据人员信息查询移动端默认查询", tags = {"分配信息" } ,notes = "根据人员信息查询移动端默认查询")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchmobdefault")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchPimDistirbutionMobDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchMobDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-KDDYXZFP-all')")
	@ApiOperation(value = "根据人员信息获取可调动的有效主分配", tags = {"分配信息" } ,notes = "根据人员信息获取可调动的有效主分配")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimdistirbutions/fetchkddyxzfp")
	public ResponseEntity<List<PimDistirbutionDTO>> fetchPimDistirbutionKDDYXZFPByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchKDDYXZFP(context) ;
        List<PimDistirbutionDTO> list = pimdistirbutionMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimDistirbution-KDDYXZFP-all')")
	@ApiOperation(value = "根据人员信息查询可调动的有效主分配", tags = {"分配信息" } ,notes = "根据人员信息查询可调动的有效主分配")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimdistirbutions/searchkddyxzfp")
	public ResponseEntity<Page<PimDistirbutionDTO>> searchPimDistirbutionKDDYXZFPByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimDistirbutionSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimDistirbution> domains = pimdistirbutionService.searchKDDYXZFP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimdistirbutionMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

