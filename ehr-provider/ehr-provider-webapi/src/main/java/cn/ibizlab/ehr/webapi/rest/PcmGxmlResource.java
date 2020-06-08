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
import cn.ibizlab.ehr.core.pcm.domain.PcmGxml;
import cn.ibizlab.ehr.core.pcm.service.IPcmGxmlService;
import cn.ibizlab.ehr.core.pcm.filter.PcmGxmlSearchContext;

@Slf4j
@Api(tags = {"高校名录" })
@RestController("WebApi-pcmgxml")
@RequestMapping("")
public class PcmGxmlResource {

    @Autowired
    public IPcmGxmlService pcmgxmlService;

    @Autowired
    @Lazy
    public PcmGxmlMapping pcmgxmlMapping;

    @PreAuthorize("hasPermission(this.pcmgxmlService.get(#pcmgxml_id),'ehr-PcmGxml-Update')")
    @ApiOperation(value = "更新高校名录", tags = {"高校名录" },  notes = "更新高校名录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmgxmls/{pcmgxml_id}")
    @Transactional
    public ResponseEntity<PcmGxmlDTO> update(@PathVariable("pcmgxml_id") String pcmgxml_id, @RequestBody PcmGxmlDTO pcmgxmldto) {
		PcmGxml domain  = pcmgxmlMapping.toDomain(pcmgxmldto);
        domain .setPcmgxmlid(pcmgxml_id);
		pcmgxmlService.update(domain );
		PcmGxmlDTO dto = pcmgxmlMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmgxmlService.getPcmgxmlByEntities(this.pcmgxmlMapping.toDomain(#pcmgxmldtos)),'ehr-PcmGxml-Update')")
    @ApiOperation(value = "批量更新高校名录", tags = {"高校名录" },  notes = "批量更新高校名录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmgxmls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmGxmlDTO> pcmgxmldtos) {
        pcmgxmlService.updateBatch(pcmgxmlMapping.toDomain(pcmgxmldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmgxmlMapping.toDomain(#pcmgxmldto),'ehr-PcmGxml-Save')")
    @ApiOperation(value = "保存高校名录", tags = {"高校名录" },  notes = "保存高校名录")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmGxmlDTO pcmgxmldto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmgxmlService.save(pcmgxmlMapping.toDomain(pcmgxmldto)));
    }

    @PreAuthorize("hasPermission(this.pcmgxmlMapping.toDomain(#pcmgxmldtos),'ehr-PcmGxml-Save')")
    @ApiOperation(value = "批量保存高校名录", tags = {"高校名录" },  notes = "批量保存高校名录")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmGxmlDTO> pcmgxmldtos) {
        pcmgxmlService.saveBatch(pcmgxmlMapping.toDomain(pcmgxmldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取高校名录草稿", tags = {"高校名录" },  notes = "获取高校名录草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmgxmls/getdraft")
    public ResponseEntity<PcmGxmlDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmgxmlMapping.toDto(pcmgxmlService.getDraft(new PcmGxml())));
    }

    @ApiOperation(value = "检查高校名录", tags = {"高校名录" },  notes = "检查高校名录")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmGxmlDTO pcmgxmldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmgxmlService.checkKey(pcmgxmlMapping.toDomain(pcmgxmldto)));
    }

    @PostAuthorize("hasPermission(this.pcmgxmlMapping.toDomain(returnObject.body),'ehr-PcmGxml-Get')")
    @ApiOperation(value = "获取高校名录", tags = {"高校名录" },  notes = "获取高校名录")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmgxmls/{pcmgxml_id}")
    public ResponseEntity<PcmGxmlDTO> get(@PathVariable("pcmgxml_id") String pcmgxml_id) {
        PcmGxml domain = pcmgxmlService.get(pcmgxml_id);
        PcmGxmlDTO dto = pcmgxmlMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmgxmlMapping.toDomain(#pcmgxmldto),'ehr-PcmGxml-Create')")
    @ApiOperation(value = "新建高校名录", tags = {"高校名录" },  notes = "新建高校名录")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls")
    @Transactional
    public ResponseEntity<PcmGxmlDTO> create(@RequestBody PcmGxmlDTO pcmgxmldto) {
        PcmGxml domain = pcmgxmlMapping.toDomain(pcmgxmldto);
		pcmgxmlService.create(domain);
        PcmGxmlDTO dto = pcmgxmlMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmgxmlMapping.toDomain(#pcmgxmldtos),'ehr-PcmGxml-Create')")
    @ApiOperation(value = "批量新建高校名录", tags = {"高校名录" },  notes = "批量新建高校名录")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmgxmls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmGxmlDTO> pcmgxmldtos) {
        pcmgxmlService.createBatch(pcmgxmlMapping.toDomain(pcmgxmldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmgxmlService.get(#pcmgxml_id),'ehr-PcmGxml-Remove')")
    @ApiOperation(value = "删除高校名录", tags = {"高校名录" },  notes = "删除高校名录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmgxmls/{pcmgxml_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmgxml_id") String pcmgxml_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmgxmlService.remove(pcmgxml_id));
    }

    @PreAuthorize("hasPermission(this.pcmgxmlService.getPcmgxmlByIds(#ids),'ehr-PcmGxml-Remove')")
    @ApiOperation(value = "批量删除高校名录", tags = {"高校名录" },  notes = "批量删除高校名录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmgxmls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmgxmlService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmGxml-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"高校名录" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmgxmls/fetchdefault")
	public ResponseEntity<List<PcmGxmlDTO>> fetchDefault(PcmGxmlSearchContext context) {
        Page<PcmGxml> domains = pcmgxmlService.searchDefault(context) ;
        List<PcmGxmlDTO> list = pcmgxmlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmGxml-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"高校名录" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmgxmls/searchdefault")
	public ResponseEntity<Page<PcmGxmlDTO>> searchDefault(@RequestBody PcmGxmlSearchContext context) {
        Page<PcmGxml> domains = pcmgxmlService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmgxmlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmGxml-CurND-all')")
	@ApiOperation(value = "获取当前年度高校名录", tags = {"高校名录" } ,notes = "获取当前年度高校名录")
    @RequestMapping(method= RequestMethod.GET , value="/pcmgxmls/fetchcurnd")
	public ResponseEntity<List<PcmGxmlDTO>> fetchCurND(PcmGxmlSearchContext context) {
        Page<PcmGxml> domains = pcmgxmlService.searchCurND(context) ;
        List<PcmGxmlDTO> list = pcmgxmlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmGxml-CurND-all')")
	@ApiOperation(value = "查询当前年度高校名录", tags = {"高校名录" } ,notes = "查询当前年度高校名录")
    @RequestMapping(method= RequestMethod.POST , value="/pcmgxmls/searchcurnd")
	public ResponseEntity<Page<PcmGxmlDTO>> searchCurND(@RequestBody PcmGxmlSearchContext context) {
        Page<PcmGxml> domains = pcmgxmlService.searchCurND(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmgxmlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

