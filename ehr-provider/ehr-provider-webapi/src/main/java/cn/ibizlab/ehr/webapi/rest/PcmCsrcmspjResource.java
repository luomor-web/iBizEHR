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
import cn.ibizlab.ehr.core.pcm.domain.PcmCsrcmspj;
import cn.ibizlab.ehr.core.pcm.service.IPcmCsrcmspjService;
import cn.ibizlab.ehr.core.pcm.filter.PcmCsrcmspjSearchContext;

@Slf4j
@Api(tags = {"成熟人才面试评价" })
@RestController("WebApi-pcmcsrcmspj")
@RequestMapping("")
public class PcmCsrcmspjResource {

    @Autowired
    public IPcmCsrcmspjService pcmcsrcmspjService;

    @Autowired
    @Lazy
    public PcmCsrcmspjMapping pcmcsrcmspjMapping;

    @PreAuthorize("hasPermission(this.pcmcsrcmspjMapping.toDomain(#pcmcsrcmspjdto),'ehr-PcmCsrcmspj-Create')")
    @ApiOperation(value = "新建成熟人才面试评价", tags = {"成熟人才面试评价" },  notes = "新建成熟人才面试评价")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmcsrcmspjs")
    @Transactional
    public ResponseEntity<PcmCsrcmspjDTO> create(@RequestBody PcmCsrcmspjDTO pcmcsrcmspjdto) {
        PcmCsrcmspj domain = pcmcsrcmspjMapping.toDomain(pcmcsrcmspjdto);
		pcmcsrcmspjService.create(domain);
        PcmCsrcmspjDTO dto = pcmcsrcmspjMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmcsrcmspjMapping.toDomain(#pcmcsrcmspjdtos),'ehr-PcmCsrcmspj-Create')")
    @ApiOperation(value = "批量新建成熟人才面试评价", tags = {"成熟人才面试评价" },  notes = "批量新建成熟人才面试评价")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmcsrcmspjs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmCsrcmspjDTO> pcmcsrcmspjdtos) {
        pcmcsrcmspjService.createBatch(pcmcsrcmspjMapping.toDomain(pcmcsrcmspjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取成熟人才面试评价草稿", tags = {"成熟人才面试评价" },  notes = "获取成熟人才面试评价草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmcsrcmspjs/getdraft")
    public ResponseEntity<PcmCsrcmspjDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmcsrcmspjMapping.toDto(pcmcsrcmspjService.getDraft(new PcmCsrcmspj())));
    }

    @PreAuthorize("hasPermission(this.pcmcsrcmspjService.get(#pcmcsrcmspj_id),'ehr-PcmCsrcmspj-Remove')")
    @ApiOperation(value = "删除成熟人才面试评价", tags = {"成熟人才面试评价" },  notes = "删除成熟人才面试评价")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmcsrcmspjs/{pcmcsrcmspj_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmcsrcmspj_id") String pcmcsrcmspj_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmcsrcmspjService.remove(pcmcsrcmspj_id));
    }

    @PreAuthorize("hasPermission(this.pcmcsrcmspjService.getPcmcsrcmspjByIds(#ids),'ehr-PcmCsrcmspj-Remove')")
    @ApiOperation(value = "批量删除成熟人才面试评价", tags = {"成熟人才面试评价" },  notes = "批量删除成熟人才面试评价")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmcsrcmspjs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmcsrcmspjService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmcsrcmspjService.get(#pcmcsrcmspj_id),'ehr-PcmCsrcmspj-Update')")
    @ApiOperation(value = "更新成熟人才面试评价", tags = {"成熟人才面试评价" },  notes = "更新成熟人才面试评价")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmcsrcmspjs/{pcmcsrcmspj_id}")
    @Transactional
    public ResponseEntity<PcmCsrcmspjDTO> update(@PathVariable("pcmcsrcmspj_id") String pcmcsrcmspj_id, @RequestBody PcmCsrcmspjDTO pcmcsrcmspjdto) {
		PcmCsrcmspj domain  = pcmcsrcmspjMapping.toDomain(pcmcsrcmspjdto);
        domain .setPcmcsrcmspjid(pcmcsrcmspj_id);
		pcmcsrcmspjService.update(domain );
		PcmCsrcmspjDTO dto = pcmcsrcmspjMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmcsrcmspjService.getPcmcsrcmspjByEntities(this.pcmcsrcmspjMapping.toDomain(#pcmcsrcmspjdtos)),'ehr-PcmCsrcmspj-Update')")
    @ApiOperation(value = "批量更新成熟人才面试评价", tags = {"成熟人才面试评价" },  notes = "批量更新成熟人才面试评价")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmcsrcmspjs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmCsrcmspjDTO> pcmcsrcmspjdtos) {
        pcmcsrcmspjService.updateBatch(pcmcsrcmspjMapping.toDomain(pcmcsrcmspjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmcsrcmspjMapping.toDomain(#pcmcsrcmspjdto),'ehr-PcmCsrcmspj-Save')")
    @ApiOperation(value = "保存成熟人才面试评价", tags = {"成熟人才面试评价" },  notes = "保存成熟人才面试评价")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmcsrcmspjs/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmCsrcmspjDTO pcmcsrcmspjdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmcsrcmspjService.save(pcmcsrcmspjMapping.toDomain(pcmcsrcmspjdto)));
    }

    @PreAuthorize("hasPermission(this.pcmcsrcmspjMapping.toDomain(#pcmcsrcmspjdtos),'ehr-PcmCsrcmspj-Save')")
    @ApiOperation(value = "批量保存成熟人才面试评价", tags = {"成熟人才面试评价" },  notes = "批量保存成熟人才面试评价")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmcsrcmspjs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmCsrcmspjDTO> pcmcsrcmspjdtos) {
        pcmcsrcmspjService.saveBatch(pcmcsrcmspjMapping.toDomain(pcmcsrcmspjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查成熟人才面试评价", tags = {"成熟人才面试评价" },  notes = "检查成熟人才面试评价")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmcsrcmspjs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmCsrcmspjDTO pcmcsrcmspjdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmcsrcmspjService.checkKey(pcmcsrcmspjMapping.toDomain(pcmcsrcmspjdto)));
    }

    @PostAuthorize("hasPermission(this.pcmcsrcmspjMapping.toDomain(returnObject.body),'ehr-PcmCsrcmspj-Get')")
    @ApiOperation(value = "获取成熟人才面试评价", tags = {"成熟人才面试评价" },  notes = "获取成熟人才面试评价")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmcsrcmspjs/{pcmcsrcmspj_id}")
    public ResponseEntity<PcmCsrcmspjDTO> get(@PathVariable("pcmcsrcmspj_id") String pcmcsrcmspj_id) {
        PcmCsrcmspj domain = pcmcsrcmspjService.get(pcmcsrcmspj_id);
        PcmCsrcmspjDTO dto = pcmcsrcmspjMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmCsrcmspj-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"成熟人才面试评价" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmcsrcmspjs/fetchdefault")
	public ResponseEntity<List<PcmCsrcmspjDTO>> fetchDefault(PcmCsrcmspjSearchContext context) {
        Page<PcmCsrcmspj> domains = pcmcsrcmspjService.searchDefault(context) ;
        List<PcmCsrcmspjDTO> list = pcmcsrcmspjMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmCsrcmspj-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"成熟人才面试评价" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmcsrcmspjs/searchdefault")
	public ResponseEntity<Page<PcmCsrcmspjDTO>> searchDefault(@RequestBody PcmCsrcmspjSearchContext context) {
        Page<PcmCsrcmspj> domains = pcmcsrcmspjService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmcsrcmspjMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

