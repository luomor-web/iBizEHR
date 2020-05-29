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
import cn.ibizlab.ehr.core.pcm.domain.PcmProfileNumBeprefix;
import cn.ibizlab.ehr.core.pcm.service.IPcmProfileNumBeprefixService;
import cn.ibizlab.ehr.core.pcm.filter.PcmProfileNumBeprefixSearchContext;

@Slf4j
@Api(tags = {"应聘者编号前缀" })
@RestController("WebApi-pcmprofilenumbeprefix")
@RequestMapping("")
public class PcmProfileNumBeprefixResource {

    @Autowired
    public IPcmProfileNumBeprefixService pcmprofilenumbeprefixService;

    @Autowired
    @Lazy
    public PcmProfileNumBeprefixMapping pcmprofilenumbeprefixMapping;

    @PostAuthorize("hasPermission(this.pcmprofilenumbeprefixMapping.toDomain(returnObject.body),'ehr-PcmProfileNumBeprefix-Get')")
    @ApiOperation(value = "获取应聘者编号前缀", tags = {"应聘者编号前缀" },  notes = "获取应聘者编号前缀")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofilenumbeprefixes/{pcmprofilenumbeprefix_id}")
    public ResponseEntity<PcmProfileNumBeprefixDTO> get(@PathVariable("pcmprofilenumbeprefix_id") String pcmprofilenumbeprefix_id) {
        PcmProfileNumBeprefix domain = pcmprofilenumbeprefixService.get(pcmprofilenumbeprefix_id);
        PcmProfileNumBeprefixDTO dto = pcmprofilenumbeprefixMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofilenumbeprefixMapping.toDomain(#pcmprofilenumbeprefixdto),'ehr-PcmProfileNumBeprefix-Save')")
    @ApiOperation(value = "保存应聘者编号前缀", tags = {"应聘者编号前缀" },  notes = "保存应聘者编号前缀")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilenumbeprefixes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmProfileNumBeprefixDTO pcmprofilenumbeprefixdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofilenumbeprefixService.save(pcmprofilenumbeprefixMapping.toDomain(pcmprofilenumbeprefixdto)));
    }

    @PreAuthorize("hasPermission(this.pcmprofilenumbeprefixMapping.toDomain(#pcmprofilenumbeprefixdtos),'ehr-PcmProfileNumBeprefix-Save')")
    @ApiOperation(value = "批量保存应聘者编号前缀", tags = {"应聘者编号前缀" },  notes = "批量保存应聘者编号前缀")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilenumbeprefixes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmProfileNumBeprefixDTO> pcmprofilenumbeprefixdtos) {
        pcmprofilenumbeprefixService.saveBatch(pcmprofilenumbeprefixMapping.toDomain(pcmprofilenumbeprefixdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmprofilenumbeprefixService.get(#pcmprofilenumbeprefix_id),'ehr-PcmProfileNumBeprefix-Update')")
    @ApiOperation(value = "更新应聘者编号前缀", tags = {"应聘者编号前缀" },  notes = "更新应聘者编号前缀")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofilenumbeprefixes/{pcmprofilenumbeprefix_id}")
    @Transactional
    public ResponseEntity<PcmProfileNumBeprefixDTO> update(@PathVariable("pcmprofilenumbeprefix_id") String pcmprofilenumbeprefix_id, @RequestBody PcmProfileNumBeprefixDTO pcmprofilenumbeprefixdto) {
		PcmProfileNumBeprefix domain  = pcmprofilenumbeprefixMapping.toDomain(pcmprofilenumbeprefixdto);
        domain .setPcmprofilenumbeprefixid(pcmprofilenumbeprefix_id);
		pcmprofilenumbeprefixService.update(domain );
		PcmProfileNumBeprefixDTO dto = pcmprofilenumbeprefixMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofilenumbeprefixService.getPcmprofilenumbeprefixByEntities(this.pcmprofilenumbeprefixMapping.toDomain(#pcmprofilenumbeprefixdtos)),'ehr-PcmProfileNumBeprefix-Update')")
    @ApiOperation(value = "批量更新应聘者编号前缀", tags = {"应聘者编号前缀" },  notes = "批量更新应聘者编号前缀")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofilenumbeprefixes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmProfileNumBeprefixDTO> pcmprofilenumbeprefixdtos) {
        pcmprofilenumbeprefixService.updateBatch(pcmprofilenumbeprefixMapping.toDomain(pcmprofilenumbeprefixdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmprofilenumbeprefixMapping.toDomain(#pcmprofilenumbeprefixdto),'ehr-PcmProfileNumBeprefix-Create')")
    @ApiOperation(value = "新建应聘者编号前缀", tags = {"应聘者编号前缀" },  notes = "新建应聘者编号前缀")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilenumbeprefixes")
    @Transactional
    public ResponseEntity<PcmProfileNumBeprefixDTO> create(@RequestBody PcmProfileNumBeprefixDTO pcmprofilenumbeprefixdto) {
        PcmProfileNumBeprefix domain = pcmprofilenumbeprefixMapping.toDomain(pcmprofilenumbeprefixdto);
		pcmprofilenumbeprefixService.create(domain);
        PcmProfileNumBeprefixDTO dto = pcmprofilenumbeprefixMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofilenumbeprefixMapping.toDomain(#pcmprofilenumbeprefixdtos),'ehr-PcmProfileNumBeprefix-Create')")
    @ApiOperation(value = "批量新建应聘者编号前缀", tags = {"应聘者编号前缀" },  notes = "批量新建应聘者编号前缀")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilenumbeprefixes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmProfileNumBeprefixDTO> pcmprofilenumbeprefixdtos) {
        pcmprofilenumbeprefixService.createBatch(pcmprofilenumbeprefixMapping.toDomain(pcmprofilenumbeprefixdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查应聘者编号前缀", tags = {"应聘者编号前缀" },  notes = "检查应聘者编号前缀")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilenumbeprefixes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmProfileNumBeprefixDTO pcmprofilenumbeprefixdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmprofilenumbeprefixService.checkKey(pcmprofilenumbeprefixMapping.toDomain(pcmprofilenumbeprefixdto)));
    }

    @PreAuthorize("hasPermission(this.pcmprofilenumbeprefixService.get(#pcmprofilenumbeprefix_id),'ehr-PcmProfileNumBeprefix-Remove')")
    @ApiOperation(value = "删除应聘者编号前缀", tags = {"应聘者编号前缀" },  notes = "删除应聘者编号前缀")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofilenumbeprefixes/{pcmprofilenumbeprefix_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmprofilenumbeprefix_id") String pcmprofilenumbeprefix_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmprofilenumbeprefixService.remove(pcmprofilenumbeprefix_id));
    }

    @PreAuthorize("hasPermission(this.pcmprofilenumbeprefixService.getPcmprofilenumbeprefixByIds(#ids),'ehr-PcmProfileNumBeprefix-Remove')")
    @ApiOperation(value = "批量删除应聘者编号前缀", tags = {"应聘者编号前缀" },  notes = "批量删除应聘者编号前缀")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofilenumbeprefixes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmprofilenumbeprefixService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取应聘者编号前缀草稿", tags = {"应聘者编号前缀" },  notes = "获取应聘者编号前缀草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofilenumbeprefixes/getdraft")
    public ResponseEntity<PcmProfileNumBeprefixDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofilenumbeprefixMapping.toDto(pcmprofilenumbeprefixService.getDraft(new PcmProfileNumBeprefix())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfileNumBeprefix-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"应聘者编号前缀" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofilenumbeprefixes/fetchdefault")
	public ResponseEntity<List<PcmProfileNumBeprefixDTO>> fetchDefault(PcmProfileNumBeprefixSearchContext context) {
        Page<PcmProfileNumBeprefix> domains = pcmprofilenumbeprefixService.searchDefault(context) ;
        List<PcmProfileNumBeprefixDTO> list = pcmprofilenumbeprefixMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmProfileNumBeprefix-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"应聘者编号前缀" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofilenumbeprefixes/searchdefault")
	public ResponseEntity<Page<PcmProfileNumBeprefixDTO>> searchDefault(@RequestBody PcmProfileNumBeprefixSearchContext context) {
        Page<PcmProfileNumBeprefix> domains = pcmprofilenumbeprefixService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofilenumbeprefixMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

