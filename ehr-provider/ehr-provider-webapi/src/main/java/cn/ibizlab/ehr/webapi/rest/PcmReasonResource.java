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
import cn.ibizlab.ehr.core.pcm.domain.PcmReason;
import cn.ibizlab.ehr.core.pcm.service.IPcmReasonService;
import cn.ibizlab.ehr.core.pcm.filter.PcmReasonSearchContext;

@Slf4j
@Api(tags = {"配置原因代码表" })
@RestController("WebApi-pcmreason")
@RequestMapping("")
public class PcmReasonResource {

    @Autowired
    public IPcmReasonService pcmreasonService;

    @Autowired
    @Lazy
    public PcmReasonMapping pcmreasonMapping;

    @ApiOperation(value = "获取配置原因代码表草稿", tags = {"配置原因代码表" },  notes = "获取配置原因代码表草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmreasons/getdraft")
    public ResponseEntity<PcmReasonDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmreasonMapping.toDto(pcmreasonService.getDraft(new PcmReason())));
    }

    @PreAuthorize("hasPermission(this.pcmreasonService.get(#pcmreason_id),'ehr-PcmReason-Remove')")
    @ApiOperation(value = "删除配置原因代码表", tags = {"配置原因代码表" },  notes = "删除配置原因代码表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmreasons/{pcmreason_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmreason_id") String pcmreason_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmreasonService.remove(pcmreason_id));
    }

    @PreAuthorize("hasPermission(this.pcmreasonService.getPcmreasonByIds(#ids),'ehr-PcmReason-Remove')")
    @ApiOperation(value = "批量删除配置原因代码表", tags = {"配置原因代码表" },  notes = "批量删除配置原因代码表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmreasons/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmreasonService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmreasonService.get(#pcmreason_id),'ehr-PcmReason-Update')")
    @ApiOperation(value = "更新配置原因代码表", tags = {"配置原因代码表" },  notes = "更新配置原因代码表")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmreasons/{pcmreason_id}")
    @Transactional
    public ResponseEntity<PcmReasonDTO> update(@PathVariable("pcmreason_id") String pcmreason_id, @RequestBody PcmReasonDTO pcmreasondto) {
		PcmReason domain  = pcmreasonMapping.toDomain(pcmreasondto);
        domain .setPcmreasonid(pcmreason_id);
		pcmreasonService.update(domain );
		PcmReasonDTO dto = pcmreasonMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmreasonService.getPcmreasonByEntities(this.pcmreasonMapping.toDomain(#pcmreasondtos)),'ehr-PcmReason-Update')")
    @ApiOperation(value = "批量更新配置原因代码表", tags = {"配置原因代码表" },  notes = "批量更新配置原因代码表")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmreasons/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmReasonDTO> pcmreasondtos) {
        pcmreasonService.updateBatch(pcmreasonMapping.toDomain(pcmreasondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmreasonMapping.toDomain(returnObject.body),'ehr-PcmReason-Get')")
    @ApiOperation(value = "获取配置原因代码表", tags = {"配置原因代码表" },  notes = "获取配置原因代码表")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmreasons/{pcmreason_id}")
    public ResponseEntity<PcmReasonDTO> get(@PathVariable("pcmreason_id") String pcmreason_id) {
        PcmReason domain = pcmreasonService.get(pcmreason_id);
        PcmReasonDTO dto = pcmreasonMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmreasonMapping.toDomain(#pcmreasondto),'ehr-PcmReason-Create')")
    @ApiOperation(value = "新建配置原因代码表", tags = {"配置原因代码表" },  notes = "新建配置原因代码表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmreasons")
    @Transactional
    public ResponseEntity<PcmReasonDTO> create(@RequestBody PcmReasonDTO pcmreasondto) {
        PcmReason domain = pcmreasonMapping.toDomain(pcmreasondto);
		pcmreasonService.create(domain);
        PcmReasonDTO dto = pcmreasonMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmreasonMapping.toDomain(#pcmreasondtos),'ehr-PcmReason-Create')")
    @ApiOperation(value = "批量新建配置原因代码表", tags = {"配置原因代码表" },  notes = "批量新建配置原因代码表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmreasons/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmReasonDTO> pcmreasondtos) {
        pcmreasonService.createBatch(pcmreasonMapping.toDomain(pcmreasondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查配置原因代码表", tags = {"配置原因代码表" },  notes = "检查配置原因代码表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmreasons/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmReasonDTO pcmreasondto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmreasonService.checkKey(pcmreasonMapping.toDomain(pcmreasondto)));
    }

    @PreAuthorize("hasPermission(this.pcmreasonMapping.toDomain(#pcmreasondto),'ehr-PcmReason-Save')")
    @ApiOperation(value = "保存配置原因代码表", tags = {"配置原因代码表" },  notes = "保存配置原因代码表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmreasons/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmReasonDTO pcmreasondto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmreasonService.save(pcmreasonMapping.toDomain(pcmreasondto)));
    }

    @PreAuthorize("hasPermission(this.pcmreasonMapping.toDomain(#pcmreasondtos),'ehr-PcmReason-Save')")
    @ApiOperation(value = "批量保存配置原因代码表", tags = {"配置原因代码表" },  notes = "批量保存配置原因代码表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmreasons/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmReasonDTO> pcmreasondtos) {
        pcmreasonService.saveBatch(pcmreasonMapping.toDomain(pcmreasondtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmReason-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"配置原因代码表" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmreasons/fetchdefault")
	public ResponseEntity<List<PcmReasonDTO>> fetchDefault(PcmReasonSearchContext context) {
        Page<PcmReason> domains = pcmreasonService.searchDefault(context) ;
        List<PcmReasonDTO> list = pcmreasonMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmReason-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"配置原因代码表" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmreasons/searchdefault")
	public ResponseEntity<Page<PcmReasonDTO>> searchDefault(@RequestBody PcmReasonSearchContext context) {
        Page<PcmReason> domains = pcmreasonService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmreasonMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

