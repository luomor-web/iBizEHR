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
import cn.ibizlab.ehr.core.pcm.domain.PcmMonth;
import cn.ibizlab.ehr.core.pcm.service.IPcmMonthService;
import cn.ibizlab.ehr.core.pcm.filter.PcmMonthSearchContext;

@Slf4j
@Api(tags = {"月份参考表" })
@RestController("WebApi-pcmmonth")
@RequestMapping("")
public class PcmMonthResource {

    @Autowired
    public IPcmMonthService pcmmonthService;

    @Autowired
    @Lazy
    public PcmMonthMapping pcmmonthMapping;

    @PreAuthorize("hasPermission(this.pcmmonthService.get(#pcmmonth_id),'ehr-PcmMonth-Update')")
    @ApiOperation(value = "更新月份参考表", tags = {"月份参考表" },  notes = "更新月份参考表")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmmonths/{pcmmonth_id}")
    @Transactional
    public ResponseEntity<PcmMonthDTO> update(@PathVariable("pcmmonth_id") String pcmmonth_id, @RequestBody PcmMonthDTO pcmmonthdto) {
		PcmMonth domain  = pcmmonthMapping.toDomain(pcmmonthdto);
        domain .setPcmmonthid(pcmmonth_id);
		pcmmonthService.update(domain );
		PcmMonthDTO dto = pcmmonthMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmmonthService.getPcmmonthByEntities(this.pcmmonthMapping.toDomain(#pcmmonthdtos)),'ehr-PcmMonth-Update')")
    @ApiOperation(value = "批量更新月份参考表", tags = {"月份参考表" },  notes = "批量更新月份参考表")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmmonths/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmMonthDTO> pcmmonthdtos) {
        pcmmonthService.updateBatch(pcmmonthMapping.toDomain(pcmmonthdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmmonthService.get(#pcmmonth_id),'ehr-PcmMonth-Remove')")
    @ApiOperation(value = "删除月份参考表", tags = {"月份参考表" },  notes = "删除月份参考表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmmonths/{pcmmonth_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmmonth_id") String pcmmonth_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmmonthService.remove(pcmmonth_id));
    }

    @PreAuthorize("hasPermission(this.pcmmonthService.getPcmmonthByIds(#ids),'ehr-PcmMonth-Remove')")
    @ApiOperation(value = "批量删除月份参考表", tags = {"月份参考表" },  notes = "批量删除月份参考表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmmonths/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmmonthService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmmonthMapping.toDomain(#pcmmonthdto),'ehr-PcmMonth-Save')")
    @ApiOperation(value = "保存月份参考表", tags = {"月份参考表" },  notes = "保存月份参考表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmmonths/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmMonthDTO pcmmonthdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmmonthService.save(pcmmonthMapping.toDomain(pcmmonthdto)));
    }

    @PreAuthorize("hasPermission(this.pcmmonthMapping.toDomain(#pcmmonthdtos),'ehr-PcmMonth-Save')")
    @ApiOperation(value = "批量保存月份参考表", tags = {"月份参考表" },  notes = "批量保存月份参考表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmmonths/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmMonthDTO> pcmmonthdtos) {
        pcmmonthService.saveBatch(pcmmonthMapping.toDomain(pcmmonthdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmmonthMapping.toDomain(#pcmmonthdto),'ehr-PcmMonth-Create')")
    @ApiOperation(value = "新建月份参考表", tags = {"月份参考表" },  notes = "新建月份参考表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmmonths")
    @Transactional
    public ResponseEntity<PcmMonthDTO> create(@RequestBody PcmMonthDTO pcmmonthdto) {
        PcmMonth domain = pcmmonthMapping.toDomain(pcmmonthdto);
		pcmmonthService.create(domain);
        PcmMonthDTO dto = pcmmonthMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmmonthMapping.toDomain(#pcmmonthdtos),'ehr-PcmMonth-Create')")
    @ApiOperation(value = "批量新建月份参考表", tags = {"月份参考表" },  notes = "批量新建月份参考表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmmonths/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmMonthDTO> pcmmonthdtos) {
        pcmmonthService.createBatch(pcmmonthMapping.toDomain(pcmmonthdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查月份参考表", tags = {"月份参考表" },  notes = "检查月份参考表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmmonths/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmMonthDTO pcmmonthdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmmonthService.checkKey(pcmmonthMapping.toDomain(pcmmonthdto)));
    }

    @PostAuthorize("hasPermission(this.pcmmonthMapping.toDomain(returnObject.body),'ehr-PcmMonth-Get')")
    @ApiOperation(value = "获取月份参考表", tags = {"月份参考表" },  notes = "获取月份参考表")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmmonths/{pcmmonth_id}")
    public ResponseEntity<PcmMonthDTO> get(@PathVariable("pcmmonth_id") String pcmmonth_id) {
        PcmMonth domain = pcmmonthService.get(pcmmonth_id);
        PcmMonthDTO dto = pcmmonthMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取月份参考表草稿", tags = {"月份参考表" },  notes = "获取月份参考表草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmmonths/getdraft")
    public ResponseEntity<PcmMonthDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmmonthMapping.toDto(pcmmonthService.getDraft(new PcmMonth())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmMonth-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"月份参考表" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmmonths/fetchdefault")
	public ResponseEntity<List<PcmMonthDTO>> fetchDefault(PcmMonthSearchContext context) {
        Page<PcmMonth> domains = pcmmonthService.searchDefault(context) ;
        List<PcmMonthDTO> list = pcmmonthMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmMonth-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"月份参考表" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmmonths/searchdefault")
	public ResponseEntity<Page<PcmMonthDTO>> searchDefault(@RequestBody PcmMonthSearchContext context) {
        Page<PcmMonth> domains = pcmmonthService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmmonthMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

