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
import cn.ibizlab.ehr.core.pcm.domain.PcmXygzzsq;
import cn.ibizlab.ehr.core.pcm.service.IPcmXygzzsqService;
import cn.ibizlab.ehr.core.pcm.filter.PcmXygzzsqSearchContext;

@Slf4j
@Api(tags = {"试用期员工转正申请" })
@RestController("WebApi-pcmxygzzsq")
@RequestMapping("")
public class PcmXygzzsqResource {

    @Autowired
    public IPcmXygzzsqService pcmxygzzsqService;

    @Autowired
    @Lazy
    public PcmXygzzsqMapping pcmxygzzsqMapping;

    @PreAuthorize("hasPermission(this.pcmxygzzsqMapping.toDomain(#pcmxygzzsqdto),'ehr-PcmXygzzsq-Create')")
    @ApiOperation(value = "新建试用期员工转正申请", tags = {"试用期员工转正申请" },  notes = "新建试用期员工转正申请")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqs")
    @Transactional
    public ResponseEntity<PcmXygzzsqDTO> create(@RequestBody PcmXygzzsqDTO pcmxygzzsqdto) {
        PcmXygzzsq domain = pcmxygzzsqMapping.toDomain(pcmxygzzsqdto);
		pcmxygzzsqService.create(domain);
        PcmXygzzsqDTO dto = pcmxygzzsqMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzsqMapping.toDomain(#pcmxygzzsqdtos),'ehr-PcmXygzzsq-Create')")
    @ApiOperation(value = "批量新建试用期员工转正申请", tags = {"试用期员工转正申请" },  notes = "批量新建试用期员工转正申请")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmXygzzsqDTO> pcmxygzzsqdtos) {
        pcmxygzzsqService.createBatch(pcmxygzzsqMapping.toDomain(pcmxygzzsqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmxygzzsqMapping.toDomain(returnObject.body),'ehr-PcmXygzzsq-Get')")
    @ApiOperation(value = "获取试用期员工转正申请", tags = {"试用期员工转正申请" },  notes = "获取试用期员工转正申请")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxygzzsqs/{pcmxygzzsq_id}")
    public ResponseEntity<PcmXygzzsqDTO> get(@PathVariable("pcmxygzzsq_id") String pcmxygzzsq_id) {
        PcmXygzzsq domain = pcmxygzzsqService.get(pcmxygzzsq_id);
        PcmXygzzsqDTO dto = pcmxygzzsqMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzsqMapping.toDomain(#pcmxygzzsqdto),'ehr-PcmXygzzsq-Save')")
    @ApiOperation(value = "保存试用期员工转正申请", tags = {"试用期员工转正申请" },  notes = "保存试用期员工转正申请")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqs/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmXygzzsqDTO pcmxygzzsqdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqService.save(pcmxygzzsqMapping.toDomain(pcmxygzzsqdto)));
    }

    @PreAuthorize("hasPermission(this.pcmxygzzsqMapping.toDomain(#pcmxygzzsqdtos),'ehr-PcmXygzzsq-Save')")
    @ApiOperation(value = "批量保存试用期员工转正申请", tags = {"试用期员工转正申请" },  notes = "批量保存试用期员工转正申请")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmXygzzsqDTO> pcmxygzzsqdtos) {
        pcmxygzzsqService.saveBatch(pcmxygzzsqMapping.toDomain(pcmxygzzsqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzsqService.get(#pcmxygzzsq_id),'ehr-PcmXygzzsq-Remove')")
    @ApiOperation(value = "删除试用期员工转正申请", tags = {"试用期员工转正申请" },  notes = "删除试用期员工转正申请")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxygzzsqs/{pcmxygzzsq_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmxygzzsq_id") String pcmxygzzsq_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqService.remove(pcmxygzzsq_id));
    }

    @PreAuthorize("hasPermission(this.pcmxygzzsqService.getPcmxygzzsqByIds(#ids),'ehr-PcmXygzzsq-Remove')")
    @ApiOperation(value = "批量删除试用期员工转正申请", tags = {"试用期员工转正申请" },  notes = "批量删除试用期员工转正申请")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmxygzzsqs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmxygzzsqService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查试用期员工转正申请", tags = {"试用期员工转正申请" },  notes = "检查试用期员工转正申请")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmxygzzsqs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmXygzzsqDTO pcmxygzzsqdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqService.checkKey(pcmxygzzsqMapping.toDomain(pcmxygzzsqdto)));
    }

    @ApiOperation(value = "获取试用期员工转正申请草稿", tags = {"试用期员工转正申请" },  notes = "获取试用期员工转正申请草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmxygzzsqs/getdraft")
    public ResponseEntity<PcmXygzzsqDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmxygzzsqMapping.toDto(pcmxygzzsqService.getDraft(new PcmXygzzsq())));
    }

    @PreAuthorize("hasPermission(this.pcmxygzzsqService.get(#pcmxygzzsq_id),'ehr-PcmXygzzsq-Update')")
    @ApiOperation(value = "更新试用期员工转正申请", tags = {"试用期员工转正申请" },  notes = "更新试用期员工转正申请")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxygzzsqs/{pcmxygzzsq_id}")
    @Transactional
    public ResponseEntity<PcmXygzzsqDTO> update(@PathVariable("pcmxygzzsq_id") String pcmxygzzsq_id, @RequestBody PcmXygzzsqDTO pcmxygzzsqdto) {
		PcmXygzzsq domain  = pcmxygzzsqMapping.toDomain(pcmxygzzsqdto);
        domain .setPcmxygzzsqid(pcmxygzzsq_id);
		pcmxygzzsqService.update(domain );
		PcmXygzzsqDTO dto = pcmxygzzsqMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmxygzzsqService.getPcmxygzzsqByEntities(this.pcmxygzzsqMapping.toDomain(#pcmxygzzsqdtos)),'ehr-PcmXygzzsq-Update')")
    @ApiOperation(value = "批量更新试用期员工转正申请", tags = {"试用期员工转正申请" },  notes = "批量更新试用期员工转正申请")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmxygzzsqs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmXygzzsqDTO> pcmxygzzsqdtos) {
        pcmxygzzsqService.updateBatch(pcmxygzzsqMapping.toDomain(pcmxygzzsqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzsq-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"试用期员工转正申请" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmxygzzsqs/fetchdefault")
	public ResponseEntity<List<PcmXygzzsqDTO>> fetchDefault(PcmXygzzsqSearchContext context) {
        Page<PcmXygzzsq> domains = pcmxygzzsqService.searchDefault(context) ;
        List<PcmXygzzsqDTO> list = pcmxygzzsqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmXygzzsq-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"试用期员工转正申请" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmxygzzsqs/searchdefault")
	public ResponseEntity<Page<PcmXygzzsqDTO>> searchDefault(@RequestBody PcmXygzzsqSearchContext context) {
        Page<PcmXygzzsq> domains = pcmxygzzsqService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmxygzzsqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

