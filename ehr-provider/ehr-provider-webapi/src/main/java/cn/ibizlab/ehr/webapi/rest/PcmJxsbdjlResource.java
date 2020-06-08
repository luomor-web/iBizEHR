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
import cn.ibizlab.ehr.core.pcm.domain.PcmJxsbdjl;
import cn.ibizlab.ehr.core.pcm.service.IPcmJxsbdjlService;
import cn.ibizlab.ehr.core.pcm.filter.PcmJxsbdjlSearchContext;

@Slf4j
@Api(tags = {"见习生变动记录" })
@RestController("WebApi-pcmjxsbdjl")
@RequestMapping("")
public class PcmJxsbdjlResource {

    @Autowired
    public IPcmJxsbdjlService pcmjxsbdjlService;

    @Autowired
    @Lazy
    public PcmJxsbdjlMapping pcmjxsbdjlMapping;

    @ApiOperation(value = "检查见习生变动记录", tags = {"见习生变动记录" },  notes = "检查见习生变动记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsbdjls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmJxsbdjlDTO pcmjxsbdjldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmjxsbdjlService.checkKey(pcmjxsbdjlMapping.toDomain(pcmjxsbdjldto)));
    }

    @PostAuthorize("hasPermission(this.pcmjxsbdjlMapping.toDomain(returnObject.body),'ehr-PcmJxsbdjl-Get')")
    @ApiOperation(value = "获取见习生变动记录", tags = {"见习生变动记录" },  notes = "获取见习生变动记录")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxsbdjls/{pcmjxsbdjl_id}")
    public ResponseEntity<PcmJxsbdjlDTO> get(@PathVariable("pcmjxsbdjl_id") String pcmjxsbdjl_id) {
        PcmJxsbdjl domain = pcmjxsbdjlService.get(pcmjxsbdjl_id);
        PcmJxsbdjlDTO dto = pcmjxsbdjlMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmjxsbdjlService.get(#pcmjxsbdjl_id),'ehr-PcmJxsbdjl-Update')")
    @ApiOperation(value = "更新见习生变动记录", tags = {"见习生变动记录" },  notes = "更新见习生变动记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxsbdjls/{pcmjxsbdjl_id}")
    @Transactional
    public ResponseEntity<PcmJxsbdjlDTO> update(@PathVariable("pcmjxsbdjl_id") String pcmjxsbdjl_id, @RequestBody PcmJxsbdjlDTO pcmjxsbdjldto) {
		PcmJxsbdjl domain  = pcmjxsbdjlMapping.toDomain(pcmjxsbdjldto);
        domain .setPcmjxsbdjlid(pcmjxsbdjl_id);
		pcmjxsbdjlService.update(domain );
		PcmJxsbdjlDTO dto = pcmjxsbdjlMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmjxsbdjlService.getPcmjxsbdjlByEntities(this.pcmjxsbdjlMapping.toDomain(#pcmjxsbdjldtos)),'ehr-PcmJxsbdjl-Update')")
    @ApiOperation(value = "批量更新见习生变动记录", tags = {"见习生变动记录" },  notes = "批量更新见习生变动记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmjxsbdjls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmJxsbdjlDTO> pcmjxsbdjldtos) {
        pcmjxsbdjlService.updateBatch(pcmjxsbdjlMapping.toDomain(pcmjxsbdjldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmjxsbdjlService.get(#pcmjxsbdjl_id),'ehr-PcmJxsbdjl-Remove')")
    @ApiOperation(value = "删除见习生变动记录", tags = {"见习生变动记录" },  notes = "删除见习生变动记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxsbdjls/{pcmjxsbdjl_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmjxsbdjl_id") String pcmjxsbdjl_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmjxsbdjlService.remove(pcmjxsbdjl_id));
    }

    @PreAuthorize("hasPermission(this.pcmjxsbdjlService.getPcmjxsbdjlByIds(#ids),'ehr-PcmJxsbdjl-Remove')")
    @ApiOperation(value = "批量删除见习生变动记录", tags = {"见习生变动记录" },  notes = "批量删除见习生变动记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmjxsbdjls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmjxsbdjlService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmjxsbdjlMapping.toDomain(#pcmjxsbdjldto),'ehr-PcmJxsbdjl-Save')")
    @ApiOperation(value = "保存见习生变动记录", tags = {"见习生变动记录" },  notes = "保存见习生变动记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsbdjls/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmJxsbdjlDTO pcmjxsbdjldto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsbdjlService.save(pcmjxsbdjlMapping.toDomain(pcmjxsbdjldto)));
    }

    @PreAuthorize("hasPermission(this.pcmjxsbdjlMapping.toDomain(#pcmjxsbdjldtos),'ehr-PcmJxsbdjl-Save')")
    @ApiOperation(value = "批量保存见习生变动记录", tags = {"见习生变动记录" },  notes = "批量保存见习生变动记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsbdjls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmJxsbdjlDTO> pcmjxsbdjldtos) {
        pcmjxsbdjlService.saveBatch(pcmjxsbdjlMapping.toDomain(pcmjxsbdjldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmjxsbdjlMapping.toDomain(#pcmjxsbdjldto),'ehr-PcmJxsbdjl-Create')")
    @ApiOperation(value = "新建见习生变动记录", tags = {"见习生变动记录" },  notes = "新建见习生变动记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsbdjls")
    @Transactional
    public ResponseEntity<PcmJxsbdjlDTO> create(@RequestBody PcmJxsbdjlDTO pcmjxsbdjldto) {
        PcmJxsbdjl domain = pcmjxsbdjlMapping.toDomain(pcmjxsbdjldto);
		pcmjxsbdjlService.create(domain);
        PcmJxsbdjlDTO dto = pcmjxsbdjlMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmjxsbdjlMapping.toDomain(#pcmjxsbdjldtos),'ehr-PcmJxsbdjl-Create')")
    @ApiOperation(value = "批量新建见习生变动记录", tags = {"见习生变动记录" },  notes = "批量新建见习生变动记录")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmjxsbdjls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmJxsbdjlDTO> pcmjxsbdjldtos) {
        pcmjxsbdjlService.createBatch(pcmjxsbdjlMapping.toDomain(pcmjxsbdjldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取见习生变动记录草稿", tags = {"见习生变动记录" },  notes = "获取见习生变动记录草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmjxsbdjls/getdraft")
    public ResponseEntity<PcmJxsbdjlDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmjxsbdjlMapping.toDto(pcmjxsbdjlService.getDraft(new PcmJxsbdjl())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsbdjl-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"见习生变动记录" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmjxsbdjls/fetchdefault")
	public ResponseEntity<List<PcmJxsbdjlDTO>> fetchDefault(PcmJxsbdjlSearchContext context) {
        Page<PcmJxsbdjl> domains = pcmjxsbdjlService.searchDefault(context) ;
        List<PcmJxsbdjlDTO> list = pcmjxsbdjlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsbdjl-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"见习生变动记录" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsbdjls/searchdefault")
	public ResponseEntity<Page<PcmJxsbdjlDTO>> searchDefault(@RequestBody PcmJxsbdjlSearchContext context) {
        Page<PcmJxsbdjl> domains = pcmjxsbdjlService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsbdjlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsbdjl-ZIZHU-all')")
	@ApiOperation(value = "获取自助(见习记录)", tags = {"见习生变动记录" } ,notes = "获取自助(见习记录)")
    @RequestMapping(method= RequestMethod.GET , value="/pcmjxsbdjls/fetchzizhu")
	public ResponseEntity<List<PcmJxsbdjlDTO>> fetchZIZHU(PcmJxsbdjlSearchContext context) {
        Page<PcmJxsbdjl> domains = pcmjxsbdjlService.searchZIZHU(context) ;
        List<PcmJxsbdjlDTO> list = pcmjxsbdjlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsbdjl-ZIZHU-all')")
	@ApiOperation(value = "查询自助(见习记录)", tags = {"见习生变动记录" } ,notes = "查询自助(见习记录)")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsbdjls/searchzizhu")
	public ResponseEntity<Page<PcmJxsbdjlDTO>> searchZIZHU(@RequestBody PcmJxsbdjlSearchContext context) {
        Page<PcmJxsbdjl> domains = pcmjxsbdjlService.searchZIZHU(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsbdjlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsbdjl-JLSS-all')")
	@ApiOperation(value = "获取记录所属和人员ID不符的", tags = {"见习生变动记录" } ,notes = "获取记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.GET , value="/pcmjxsbdjls/fetchjlss")
	public ResponseEntity<List<PcmJxsbdjlDTO>> fetchJLSS(PcmJxsbdjlSearchContext context) {
        Page<PcmJxsbdjl> domains = pcmjxsbdjlService.searchJLSS(context) ;
        List<PcmJxsbdjlDTO> list = pcmjxsbdjlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmJxsbdjl-JLSS-all')")
	@ApiOperation(value = "查询记录所属和人员ID不符的", tags = {"见习生变动记录" } ,notes = "查询记录所属和人员ID不符的")
    @RequestMapping(method= RequestMethod.POST , value="/pcmjxsbdjls/searchjlss")
	public ResponseEntity<Page<PcmJxsbdjlDTO>> searchJLSS(@RequestBody PcmJxsbdjlSearchContext context) {
        Page<PcmJxsbdjl> domains = pcmjxsbdjlService.searchJLSS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmjxsbdjlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

