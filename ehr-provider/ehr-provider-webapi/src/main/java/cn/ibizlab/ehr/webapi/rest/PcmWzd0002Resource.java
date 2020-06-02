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
import cn.ibizlab.ehr.core.trm.domain.PcmWzd0002;
import cn.ibizlab.ehr.core.trm.service.IPcmWzd0002Service;
import cn.ibizlab.ehr.core.trm.filter.PcmWzd0002SearchContext;

@Slf4j
@Api(tags = {"干部退出（优秀年轻干部梯队）" })
@RestController("WebApi-pcmwzd0002")
@RequestMapping("")
public class PcmWzd0002Resource {

    @Autowired
    public IPcmWzd0002Service pcmwzd0002Service;

    @Autowired
    @Lazy
    public PcmWzd0002Mapping pcmwzd0002Mapping;

    @PreAuthorize("hasPermission(this.pcmwzd0002Service.get(#pcmwzd0002_id),'ehr-PcmWzd0002-Remove')")
    @ApiOperation(value = "删除干部退出（优秀年轻干部梯队）", tags = {"干部退出（优秀年轻干部梯队）" },  notes = "删除干部退出（优秀年轻干部梯队）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmwzd0002s/{pcmwzd0002_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmwzd0002_id") String pcmwzd0002_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmwzd0002Service.remove(pcmwzd0002_id));
    }

    @PreAuthorize("hasPermission(this.pcmwzd0002Service.getPcmwzd0002ByIds(#ids),'ehr-PcmWzd0002-Remove')")
    @ApiOperation(value = "批量删除干部退出（优秀年轻干部梯队）", tags = {"干部退出（优秀年轻干部梯队）" },  notes = "批量删除干部退出（优秀年轻干部梯队）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmwzd0002s/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmwzd0002Service.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmwzd0002Mapping.toDomain(#pcmwzd0002dto),'ehr-PcmWzd0002-Save')")
    @ApiOperation(value = "保存干部退出（优秀年轻干部梯队）", tags = {"干部退出（优秀年轻干部梯队）" },  notes = "保存干部退出（优秀年轻干部梯队）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmwzd0002s/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmWzd0002DTO pcmwzd0002dto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmwzd0002Service.save(pcmwzd0002Mapping.toDomain(pcmwzd0002dto)));
    }

    @PreAuthorize("hasPermission(this.pcmwzd0002Mapping.toDomain(#pcmwzd0002dtos),'ehr-PcmWzd0002-Save')")
    @ApiOperation(value = "批量保存干部退出（优秀年轻干部梯队）", tags = {"干部退出（优秀年轻干部梯队）" },  notes = "批量保存干部退出（优秀年轻干部梯队）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmwzd0002s/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmWzd0002DTO> pcmwzd0002dtos) {
        pcmwzd0002Service.saveBatch(pcmwzd0002Mapping.toDomain(pcmwzd0002dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取干部退出（优秀年轻干部梯队）草稿", tags = {"干部退出（优秀年轻干部梯队）" },  notes = "获取干部退出（优秀年轻干部梯队）草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmwzd0002s/getdraft")
    public ResponseEntity<PcmWzd0002DTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmwzd0002Mapping.toDto(pcmwzd0002Service.getDraft(new PcmWzd0002())));
    }

    @ApiOperation(value = "检查干部退出（优秀年轻干部梯队）", tags = {"干部退出（优秀年轻干部梯队）" },  notes = "检查干部退出（优秀年轻干部梯队）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmwzd0002s/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmWzd0002DTO pcmwzd0002dto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmwzd0002Service.checkKey(pcmwzd0002Mapping.toDomain(pcmwzd0002dto)));
    }

    @PostAuthorize("hasPermission(this.pcmwzd0002Mapping.toDomain(returnObject.body),'ehr-PcmWzd0002-Get')")
    @ApiOperation(value = "获取干部退出（优秀年轻干部梯队）", tags = {"干部退出（优秀年轻干部梯队）" },  notes = "获取干部退出（优秀年轻干部梯队）")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmwzd0002s/{pcmwzd0002_id}")
    public ResponseEntity<PcmWzd0002DTO> get(@PathVariable("pcmwzd0002_id") String pcmwzd0002_id) {
        PcmWzd0002 domain = pcmwzd0002Service.get(pcmwzd0002_id);
        PcmWzd0002DTO dto = pcmwzd0002Mapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmwzd0002Mapping.toDomain(#pcmwzd0002dto),'ehr-PcmWzd0002-Create')")
    @ApiOperation(value = "新建干部退出（优秀年轻干部梯队）", tags = {"干部退出（优秀年轻干部梯队）" },  notes = "新建干部退出（优秀年轻干部梯队）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmwzd0002s")
    @Transactional
    public ResponseEntity<PcmWzd0002DTO> create(@RequestBody PcmWzd0002DTO pcmwzd0002dto) {
        PcmWzd0002 domain = pcmwzd0002Mapping.toDomain(pcmwzd0002dto);
		pcmwzd0002Service.create(domain);
        PcmWzd0002DTO dto = pcmwzd0002Mapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmwzd0002Mapping.toDomain(#pcmwzd0002dtos),'ehr-PcmWzd0002-Create')")
    @ApiOperation(value = "批量新建干部退出（优秀年轻干部梯队）", tags = {"干部退出（优秀年轻干部梯队）" },  notes = "批量新建干部退出（优秀年轻干部梯队）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmwzd0002s/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmWzd0002DTO> pcmwzd0002dtos) {
        pcmwzd0002Service.createBatch(pcmwzd0002Mapping.toDomain(pcmwzd0002dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmwzd0002Service.get(#pcmwzd0002_id),'ehr-PcmWzd0002-Update')")
    @ApiOperation(value = "更新干部退出（优秀年轻干部梯队）", tags = {"干部退出（优秀年轻干部梯队）" },  notes = "更新干部退出（优秀年轻干部梯队）")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmwzd0002s/{pcmwzd0002_id}")
    @Transactional
    public ResponseEntity<PcmWzd0002DTO> update(@PathVariable("pcmwzd0002_id") String pcmwzd0002_id, @RequestBody PcmWzd0002DTO pcmwzd0002dto) {
		PcmWzd0002 domain  = pcmwzd0002Mapping.toDomain(pcmwzd0002dto);
        domain .setWzd0002id(pcmwzd0002_id);
		pcmwzd0002Service.update(domain );
		PcmWzd0002DTO dto = pcmwzd0002Mapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmwzd0002Service.getPcmwzd0002ByEntities(this.pcmwzd0002Mapping.toDomain(#pcmwzd0002dtos)),'ehr-PcmWzd0002-Update')")
    @ApiOperation(value = "批量更新干部退出（优秀年轻干部梯队）", tags = {"干部退出（优秀年轻干部梯队）" },  notes = "批量更新干部退出（优秀年轻干部梯队）")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmwzd0002s/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmWzd0002DTO> pcmwzd0002dtos) {
        pcmwzd0002Service.updateBatch(pcmwzd0002Mapping.toDomain(pcmwzd0002dtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmWzd0002-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"干部退出（优秀年轻干部梯队）" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmwzd0002s/fetchdefault")
	public ResponseEntity<List<PcmWzd0002DTO>> fetchDefault(PcmWzd0002SearchContext context) {
        Page<PcmWzd0002> domains = pcmwzd0002Service.searchDefault(context) ;
        List<PcmWzd0002DTO> list = pcmwzd0002Mapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmWzd0002-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"干部退出（优秀年轻干部梯队）" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmwzd0002s/searchdefault")
	public ResponseEntity<Page<PcmWzd0002DTO>> searchDefault(@RequestBody PcmWzd0002SearchContext context) {
        Page<PcmWzd0002> domains = pcmwzd0002Service.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmwzd0002Mapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

