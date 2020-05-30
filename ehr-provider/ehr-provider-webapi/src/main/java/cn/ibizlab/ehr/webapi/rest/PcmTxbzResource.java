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
import cn.ibizlab.ehr.core.pcm.domain.PcmTxbz;
import cn.ibizlab.ehr.core.pcm.service.IPcmTxbzService;
import cn.ibizlab.ehr.core.pcm.filter.PcmTxbzSearchContext;

@Slf4j
@Api(tags = {"退休标准管理" })
@RestController("WebApi-pcmtxbz")
@RequestMapping("")
public class PcmTxbzResource {

    @Autowired
    public IPcmTxbzService pcmtxbzService;

    @Autowired
    @Lazy
    public PcmTxbzMapping pcmtxbzMapping;

    @ApiOperation(value = "检查退休标准管理", tags = {"退休标准管理" },  notes = "检查退休标准管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxbzs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmTxbzDTO pcmtxbzdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmtxbzService.checkKey(pcmtxbzMapping.toDomain(pcmtxbzdto)));
    }

    @PostAuthorize("hasPermission(this.pcmtxbzMapping.toDomain(returnObject.body),'ehr-PcmTxbz-Get')")
    @ApiOperation(value = "获取退休标准管理", tags = {"退休标准管理" },  notes = "获取退休标准管理")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmtxbzs/{pcmtxbz_id}")
    public ResponseEntity<PcmTxbzDTO> get(@PathVariable("pcmtxbz_id") String pcmtxbz_id) {
        PcmTxbz domain = pcmtxbzService.get(pcmtxbz_id);
        PcmTxbzDTO dto = pcmtxbzMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取退休标准管理草稿", tags = {"退休标准管理" },  notes = "获取退休标准管理草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmtxbzs/getdraft")
    public ResponseEntity<PcmTxbzDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmtxbzMapping.toDto(pcmtxbzService.getDraft(new PcmTxbz())));
    }

    @PreAuthorize("hasPermission(this.pcmtxbzService.get(#pcmtxbz_id),'ehr-PcmTxbz-Update')")
    @ApiOperation(value = "更新退休标准管理", tags = {"退休标准管理" },  notes = "更新退休标准管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmtxbzs/{pcmtxbz_id}")
    @Transactional
    public ResponseEntity<PcmTxbzDTO> update(@PathVariable("pcmtxbz_id") String pcmtxbz_id, @RequestBody PcmTxbzDTO pcmtxbzdto) {
		PcmTxbz domain  = pcmtxbzMapping.toDomain(pcmtxbzdto);
        domain .setPcmtxbzid(pcmtxbz_id);
		pcmtxbzService.update(domain );
		PcmTxbzDTO dto = pcmtxbzMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmtxbzService.getPcmtxbzByEntities(this.pcmtxbzMapping.toDomain(#pcmtxbzdtos)),'ehr-PcmTxbz-Update')")
    @ApiOperation(value = "批量更新退休标准管理", tags = {"退休标准管理" },  notes = "批量更新退休标准管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmtxbzs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmTxbzDTO> pcmtxbzdtos) {
        pcmtxbzService.updateBatch(pcmtxbzMapping.toDomain(pcmtxbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmtxbzMapping.toDomain(#pcmtxbzdto),'ehr-PcmTxbz-Create')")
    @ApiOperation(value = "新建退休标准管理", tags = {"退休标准管理" },  notes = "新建退休标准管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxbzs")
    @Transactional
    public ResponseEntity<PcmTxbzDTO> create(@RequestBody PcmTxbzDTO pcmtxbzdto) {
        PcmTxbz domain = pcmtxbzMapping.toDomain(pcmtxbzdto);
		pcmtxbzService.create(domain);
        PcmTxbzDTO dto = pcmtxbzMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmtxbzMapping.toDomain(#pcmtxbzdtos),'ehr-PcmTxbz-Create')")
    @ApiOperation(value = "批量新建退休标准管理", tags = {"退休标准管理" },  notes = "批量新建退休标准管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxbzs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmTxbzDTO> pcmtxbzdtos) {
        pcmtxbzService.createBatch(pcmtxbzMapping.toDomain(pcmtxbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmtxbzMapping.toDomain(#pcmtxbzdto),'ehr-PcmTxbz-Save')")
    @ApiOperation(value = "保存退休标准管理", tags = {"退休标准管理" },  notes = "保存退休标准管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxbzs/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmTxbzDTO pcmtxbzdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmtxbzService.save(pcmtxbzMapping.toDomain(pcmtxbzdto)));
    }

    @PreAuthorize("hasPermission(this.pcmtxbzMapping.toDomain(#pcmtxbzdtos),'ehr-PcmTxbz-Save')")
    @ApiOperation(value = "批量保存退休标准管理", tags = {"退休标准管理" },  notes = "批量保存退休标准管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmtxbzs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmTxbzDTO> pcmtxbzdtos) {
        pcmtxbzService.saveBatch(pcmtxbzMapping.toDomain(pcmtxbzdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmtxbzService.get(#pcmtxbz_id),'ehr-PcmTxbz-Remove')")
    @ApiOperation(value = "删除退休标准管理", tags = {"退休标准管理" },  notes = "删除退休标准管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmtxbzs/{pcmtxbz_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmtxbz_id") String pcmtxbz_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmtxbzService.remove(pcmtxbz_id));
    }

    @PreAuthorize("hasPermission(this.pcmtxbzService.getPcmtxbzByIds(#ids),'ehr-PcmTxbz-Remove')")
    @ApiOperation(value = "批量删除退休标准管理", tags = {"退休标准管理" },  notes = "批量删除退休标准管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmtxbzs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmtxbzService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTxbz-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"退休标准管理" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmtxbzs/fetchdefault")
	public ResponseEntity<List<PcmTxbzDTO>> fetchDefault(PcmTxbzSearchContext context) {
        Page<PcmTxbz> domains = pcmtxbzService.searchDefault(context) ;
        List<PcmTxbzDTO> list = pcmtxbzMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmTxbz-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"退休标准管理" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmtxbzs/searchdefault")
	public ResponseEntity<Page<PcmTxbzDTO>> searchDefault(@RequestBody PcmTxbzSearchContext context) {
        Page<PcmTxbz> domains = pcmtxbzService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmtxbzMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

