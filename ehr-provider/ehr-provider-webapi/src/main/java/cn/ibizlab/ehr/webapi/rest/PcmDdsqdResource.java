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
import cn.ibizlab.ehr.core.pcm.domain.PcmDdsqd;
import cn.ibizlab.ehr.core.pcm.service.IPcmDdsqdService;
import cn.ibizlab.ehr.core.pcm.filter.PcmDdsqdSearchContext;

@Slf4j
@Api(tags = {"调动申请单" })
@RestController("WebApi-pcmddsqd")
@RequestMapping("")
public class PcmDdsqdResource {

    @Autowired
    public IPcmDdsqdService pcmddsqdService;

    @Autowired
    @Lazy
    public PcmDdsqdMapping pcmddsqdMapping;

    @PreAuthorize("hasPermission(this.pcmddsqdMapping.toDomain(#pcmddsqddto),'ehr-PcmDdsqd-Create')")
    @ApiOperation(value = "新建调动申请单", tags = {"调动申请单" },  notes = "新建调动申请单")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds")
    @Transactional
    public ResponseEntity<PcmDdsqdDTO> create(@RequestBody PcmDdsqdDTO pcmddsqddto) {
        PcmDdsqd domain = pcmddsqdMapping.toDomain(pcmddsqddto);
		pcmddsqdService.create(domain);
        PcmDdsqdDTO dto = pcmddsqdMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdMapping.toDomain(#pcmddsqddtos),'ehr-PcmDdsqd-Create')")
    @ApiOperation(value = "批量新建调动申请单", tags = {"调动申请单" },  notes = "批量新建调动申请单")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmDdsqdDTO> pcmddsqddtos) {
        pcmddsqdService.createBatch(pcmddsqdMapping.toDomain(pcmddsqddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqd-PDD-all')")
    @ApiOperation(value = "批调动", tags = {"调动申请单" },  notes = "批调动")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/{pcmddsqd_id}/pdd")
    @Transactional
    public ResponseEntity<PcmDdsqdDTO> pDD(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PcmDdsqdDTO pcmddsqddto) {
        PcmDdsqd pcmddsqd = pcmddsqdMapping.toDomain(pcmddsqddto);
        pcmddsqd.setPcmddsqdid(pcmddsqd_id);
        pcmddsqd = pcmddsqdService.pDD(pcmddsqd);
        pcmddsqddto = pcmddsqdMapping.toDto(pcmddsqd);
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqddto);
    }

    @PostAuthorize("hasPermission(this.pcmddsqdMapping.toDomain(returnObject.body),'ehr-PcmDdsqd-Get')")
    @ApiOperation(value = "获取调动申请单", tags = {"调动申请单" },  notes = "获取调动申请单")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmddsqds/{pcmddsqd_id}")
    public ResponseEntity<PcmDdsqdDTO> get(@PathVariable("pcmddsqd_id") String pcmddsqd_id) {
        PcmDdsqd domain = pcmddsqdService.get(pcmddsqd_id);
        PcmDdsqdDTO dto = pcmddsqdMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdService.get(#pcmddsqd_id),'ehr-PcmDdsqd-Update')")
    @ApiOperation(value = "更新调动申请单", tags = {"调动申请单" },  notes = "更新调动申请单")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmddsqds/{pcmddsqd_id}")
    @Transactional
    public ResponseEntity<PcmDdsqdDTO> update(@PathVariable("pcmddsqd_id") String pcmddsqd_id, @RequestBody PcmDdsqdDTO pcmddsqddto) {
		PcmDdsqd domain  = pcmddsqdMapping.toDomain(pcmddsqddto);
        domain .setPcmddsqdid(pcmddsqd_id);
		pcmddsqdService.update(domain );
		PcmDdsqdDTO dto = pcmddsqdMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdService.getPcmddsqdByEntities(this.pcmddsqdMapping.toDomain(#pcmddsqddtos)),'ehr-PcmDdsqd-Update')")
    @ApiOperation(value = "批量更新调动申请单", tags = {"调动申请单" },  notes = "批量更新调动申请单")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmddsqds/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmDdsqdDTO> pcmddsqddtos) {
        pcmddsqdService.updateBatch(pcmddsqdMapping.toDomain(pcmddsqddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查调动申请单", tags = {"调动申请单" },  notes = "检查调动申请单")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmDdsqdDTO pcmddsqddto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmddsqdService.checkKey(pcmddsqdMapping.toDomain(pcmddsqddto)));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdMapping.toDomain(#pcmddsqddto),'ehr-PcmDdsqd-Save')")
    @ApiOperation(value = "保存调动申请单", tags = {"调动申请单" },  notes = "保存调动申请单")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmDdsqdDTO pcmddsqddto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdService.save(pcmddsqdMapping.toDomain(pcmddsqddto)));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdMapping.toDomain(#pcmddsqddtos),'ehr-PcmDdsqd-Save')")
    @ApiOperation(value = "批量保存调动申请单", tags = {"调动申请单" },  notes = "批量保存调动申请单")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmddsqds/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmDdsqdDTO> pcmddsqddtos) {
        pcmddsqdService.saveBatch(pcmddsqdMapping.toDomain(pcmddsqddtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmddsqdService.get(#pcmddsqd_id),'ehr-PcmDdsqd-Remove')")
    @ApiOperation(value = "删除调动申请单", tags = {"调动申请单" },  notes = "删除调动申请单")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmddsqds/{pcmddsqd_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmddsqd_id") String pcmddsqd_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdService.remove(pcmddsqd_id));
    }

    @PreAuthorize("hasPermission(this.pcmddsqdService.getPcmddsqdByIds(#ids),'ehr-PcmDdsqd-Remove')")
    @ApiOperation(value = "批量删除调动申请单", tags = {"调动申请单" },  notes = "批量删除调动申请单")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmddsqds/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmddsqdService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取调动申请单草稿", tags = {"调动申请单" },  notes = "获取调动申请单草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmddsqds/getdraft")
    public ResponseEntity<PcmDdsqdDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmddsqdMapping.toDto(pcmddsqdService.getDraft(new PcmDdsqd())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqd-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"调动申请单" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmddsqds/fetchdefault")
	public ResponseEntity<List<PcmDdsqdDTO>> fetchDefault(PcmDdsqdSearchContext context) {
        Page<PcmDdsqd> domains = pcmddsqdService.searchDefault(context) ;
        List<PcmDdsqdDTO> list = pcmddsqdMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmDdsqd-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"调动申请单" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmddsqds/searchdefault")
	public ResponseEntity<Page<PcmDdsqdDTO>> searchDefault(@RequestBody PcmDdsqdSearchContext context) {
        Page<PcmDdsqd> domains = pcmddsqdService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmddsqdMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

