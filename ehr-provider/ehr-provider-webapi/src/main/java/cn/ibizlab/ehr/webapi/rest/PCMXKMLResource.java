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
import cn.ibizlab.ehr.core.pcm.domain.PCMXKML;
import cn.ibizlab.ehr.core.pcm.service.IPCMXKMLService;
import cn.ibizlab.ehr.core.pcm.filter.PCMXKMLSearchContext;

@Slf4j
@Api(tags = {"学科目录" })
@RestController("WebApi-pcmxkml")
@RequestMapping("")
public class PCMXKMLResource {

    @Autowired
    public IPCMXKMLService pcmxkmlService;

    @Autowired
    @Lazy
    public PCMXKMLMapping pcmxkmlMapping;

    @PreAuthorize("hasPermission(this.pcmxkmlService.get(#pcmxkml_id),'ehr-PCMXKML-Update')")
    @ApiOperation(value = "更新学科目录", tags = {"学科目录" },  notes = "更新学科目录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxkmls/{pcmxkml_id}")
    @Transactional
    public ResponseEntity<PCMXKMLDTO> update(@PathVariable("pcmxkml_id") String pcmxkml_id, @RequestBody PCMXKMLDTO pcmxkmldto) {
		PCMXKML domain  = pcmxkmlMapping.toDomain(pcmxkmldto);
        domain .setPcmxkmlid(pcmxkml_id);
		pcmxkmlService.update(domain );
		PCMXKMLDTO dto = pcmxkmlMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmxkmlService.getPcmxkmlByEntities(this.pcmxkmlMapping.toDomain(#pcmxkmldtos)),'ehr-PCMXKML-Update')")
    @ApiOperation(value = "批量更新学科目录", tags = {"学科目录" },  notes = "批量更新学科目录")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxkmls/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMXKMLDTO> pcmxkmldtos) {
        pcmxkmlService.updateBatch(pcmxkmlMapping.toDomain(pcmxkmldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmxkmlService.get(#pcmxkml_id),'ehr-PCMXKML-Remove')")
    @ApiOperation(value = "删除学科目录", tags = {"学科目录" },  notes = "删除学科目录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxkmls/{pcmxkml_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmxkml_id") String pcmxkml_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmxkmlService.remove(pcmxkml_id));
    }

    @PreAuthorize("hasPermission(this.pcmxkmlService.getPcmxkmlByIds(#ids),'ehr-PCMXKML-Remove')")
    @ApiOperation(value = "批量删除学科目录", tags = {"学科目录" },  notes = "批量删除学科目录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxkmls/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmxkmlService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmxkmlMapping.toDomain(returnObject.body),'ehr-PCMXKML-Get')")
    @ApiOperation(value = "获取学科目录", tags = {"学科目录" },  notes = "获取学科目录")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxkmls/{pcmxkml_id}")
    public ResponseEntity<PCMXKMLDTO> get(@PathVariable("pcmxkml_id") String pcmxkml_id) {
        PCMXKML domain = pcmxkmlService.get(pcmxkml_id);
        PCMXKMLDTO dto = pcmxkmlMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmxkmlMapping.toDomain(#pcmxkmldto),'ehr-PCMXKML-Create')")
    @ApiOperation(value = "新建学科目录", tags = {"学科目录" },  notes = "新建学科目录")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls")
    @Transactional
    public ResponseEntity<PCMXKMLDTO> create(@RequestBody PCMXKMLDTO pcmxkmldto) {
        PCMXKML domain = pcmxkmlMapping.toDomain(pcmxkmldto);
		pcmxkmlService.create(domain);
        PCMXKMLDTO dto = pcmxkmlMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmxkmlMapping.toDomain(#pcmxkmldtos),'ehr-PCMXKML-Create')")
    @ApiOperation(value = "批量新建学科目录", tags = {"学科目录" },  notes = "批量新建学科目录")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMXKMLDTO> pcmxkmldtos) {
        pcmxkmlService.createBatch(pcmxkmlMapping.toDomain(pcmxkmldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmxkmlMapping.toDomain(#pcmxkmldto),'ehr-PCMXKML-Save')")
    @ApiOperation(value = "保存学科目录", tags = {"学科目录" },  notes = "保存学科目录")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMXKMLDTO pcmxkmldto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxkmlService.save(pcmxkmlMapping.toDomain(pcmxkmldto)));
    }

    @PreAuthorize("hasPermission(this.pcmxkmlMapping.toDomain(#pcmxkmldtos),'ehr-PCMXKML-Save')")
    @ApiOperation(value = "批量保存学科目录", tags = {"学科目录" },  notes = "批量保存学科目录")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMXKMLDTO> pcmxkmldtos) {
        pcmxkmlService.saveBatch(pcmxkmlMapping.toDomain(pcmxkmldtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查学科目录", tags = {"学科目录" },  notes = "检查学科目录")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxkmls/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMXKMLDTO pcmxkmldto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmxkmlService.checkKey(pcmxkmlMapping.toDomain(pcmxkmldto)));
    }

    @ApiOperation(value = "获取学科目录草稿", tags = {"学科目录" },  notes = "获取学科目录草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxkmls/getdraft")
    public ResponseEntity<PCMXKMLDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxkmlMapping.toDto(pcmxkmlService.getDraft(new PCMXKML())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXKML-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"学科目录" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxkmls/fetchdefault")
	public ResponseEntity<List<PCMXKMLDTO>> fetchDefault(PCMXKMLSearchContext context) {
        Page<PCMXKML> domains = pcmxkmlService.searchDefault(context) ;
        List<PCMXKMLDTO> list = pcmxkmlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXKML-Default-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"学科目录" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/pcmxkmls/searchdefault")
	public ResponseEntity<Page<PCMXKMLDTO>> searchDefault(@RequestBody PCMXKMLSearchContext context) {
        Page<PCMXKML> domains = pcmxkmlService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmxkmlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXKML-CurND-all')")
	@ApiOperation(value = "获取当前年度", tags = {"学科目录" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxkmls/fetchcurnd")
	public ResponseEntity<List<PCMXKMLDTO>> fetchCurND(PCMXKMLSearchContext context) {
        Page<PCMXKML> domains = pcmxkmlService.searchCurND(context) ;
        List<PCMXKMLDTO> list = pcmxkmlMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMXKML-CurND-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"学科目录" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/pcmxkmls/searchcurnd")
	public ResponseEntity<Page<PCMXKMLDTO>> searchCurND(@RequestBody PCMXKMLSearchContext context) {
        Page<PCMXKML> domains = pcmxkmlService.searchCurND(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmxkmlMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

