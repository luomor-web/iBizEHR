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
import cn.ibizlab.ehr.core.pcm.domain.PcmPcmSgqMgr;
import cn.ibizlab.ehr.core.pcm.service.IPcmPcmSgqMgrService;
import cn.ibizlab.ehr.core.pcm.filter.PcmPcmSgqMgrSearchContext;

@Slf4j
@Api(tags = {"试岗期管理（停用）" })
@RestController("WebApi-pcmpcmsgqmgr")
@RequestMapping("")
public class PcmPcmSgqMgrResource {

    @Autowired
    public IPcmPcmSgqMgrService pcmpcmsgqmgrService;

    @Autowired
    @Lazy
    public PcmPcmSgqMgrMapping pcmpcmsgqmgrMapping;

    @PostAuthorize("hasPermission(this.pcmpcmsgqmgrMapping.toDomain(returnObject.body),'ehr-PcmPcmSgqMgr-Get')")
    @ApiOperation(value = "获取试岗期管理（停用）", tags = {"试岗期管理（停用）" },  notes = "获取试岗期管理（停用）")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmpcmsgqmgrs/{pcmpcmsgqmgr_id}")
    public ResponseEntity<PcmPcmSgqMgrDTO> get(@PathVariable("pcmpcmsgqmgr_id") String pcmpcmsgqmgr_id) {
        PcmPcmSgqMgr domain = pcmpcmsgqmgrService.get(pcmpcmsgqmgr_id);
        PcmPcmSgqMgrDTO dto = pcmpcmsgqmgrMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取试岗期管理（停用）草稿", tags = {"试岗期管理（停用）" },  notes = "获取试岗期管理（停用）草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmpcmsgqmgrs/getdraft")
    public ResponseEntity<PcmPcmSgqMgrDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmpcmsgqmgrMapping.toDto(pcmpcmsgqmgrService.getDraft(new PcmPcmSgqMgr())));
    }

    @PreAuthorize("hasPermission(this.pcmpcmsgqmgrMapping.toDomain(#pcmpcmsgqmgrdto),'ehr-PcmPcmSgqMgr-Create')")
    @ApiOperation(value = "新建试岗期管理（停用）", tags = {"试岗期管理（停用）" },  notes = "新建试岗期管理（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmpcmsgqmgrs")
    @Transactional
    public ResponseEntity<PcmPcmSgqMgrDTO> create(@RequestBody PcmPcmSgqMgrDTO pcmpcmsgqmgrdto) {
        PcmPcmSgqMgr domain = pcmpcmsgqmgrMapping.toDomain(pcmpcmsgqmgrdto);
		pcmpcmsgqmgrService.create(domain);
        PcmPcmSgqMgrDTO dto = pcmpcmsgqmgrMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmpcmsgqmgrMapping.toDomain(#pcmpcmsgqmgrdtos),'ehr-PcmPcmSgqMgr-Create')")
    @ApiOperation(value = "批量新建试岗期管理（停用）", tags = {"试岗期管理（停用）" },  notes = "批量新建试岗期管理（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmpcmsgqmgrs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmPcmSgqMgrDTO> pcmpcmsgqmgrdtos) {
        pcmpcmsgqmgrService.createBatch(pcmpcmsgqmgrMapping.toDomain(pcmpcmsgqmgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmpcmsgqmgrService.get(#pcmpcmsgqmgr_id),'ehr-PcmPcmSgqMgr-Update')")
    @ApiOperation(value = "更新试岗期管理（停用）", tags = {"试岗期管理（停用）" },  notes = "更新试岗期管理（停用）")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmpcmsgqmgrs/{pcmpcmsgqmgr_id}")
    @Transactional
    public ResponseEntity<PcmPcmSgqMgrDTO> update(@PathVariable("pcmpcmsgqmgr_id") String pcmpcmsgqmgr_id, @RequestBody PcmPcmSgqMgrDTO pcmpcmsgqmgrdto) {
		PcmPcmSgqMgr domain  = pcmpcmsgqmgrMapping.toDomain(pcmpcmsgqmgrdto);
        domain .setSgqmgrid(pcmpcmsgqmgr_id);
		pcmpcmsgqmgrService.update(domain );
		PcmPcmSgqMgrDTO dto = pcmpcmsgqmgrMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmpcmsgqmgrService.getPcmpcmsgqmgrByEntities(this.pcmpcmsgqmgrMapping.toDomain(#pcmpcmsgqmgrdtos)),'ehr-PcmPcmSgqMgr-Update')")
    @ApiOperation(value = "批量更新试岗期管理（停用）", tags = {"试岗期管理（停用）" },  notes = "批量更新试岗期管理（停用）")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmpcmsgqmgrs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmPcmSgqMgrDTO> pcmpcmsgqmgrdtos) {
        pcmpcmsgqmgrService.updateBatch(pcmpcmsgqmgrMapping.toDomain(pcmpcmsgqmgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmpcmsgqmgrService.get(#pcmpcmsgqmgr_id),'ehr-PcmPcmSgqMgr-Remove')")
    @ApiOperation(value = "删除试岗期管理（停用）", tags = {"试岗期管理（停用）" },  notes = "删除试岗期管理（停用）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmpcmsgqmgrs/{pcmpcmsgqmgr_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmpcmsgqmgr_id") String pcmpcmsgqmgr_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmpcmsgqmgrService.remove(pcmpcmsgqmgr_id));
    }

    @PreAuthorize("hasPermission(this.pcmpcmsgqmgrService.getPcmpcmsgqmgrByIds(#ids),'ehr-PcmPcmSgqMgr-Remove')")
    @ApiOperation(value = "批量删除试岗期管理（停用）", tags = {"试岗期管理（停用）" },  notes = "批量删除试岗期管理（停用）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmpcmsgqmgrs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmpcmsgqmgrService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查试岗期管理（停用）", tags = {"试岗期管理（停用）" },  notes = "检查试岗期管理（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmpcmsgqmgrs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmPcmSgqMgrDTO pcmpcmsgqmgrdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmpcmsgqmgrService.checkKey(pcmpcmsgqmgrMapping.toDomain(pcmpcmsgqmgrdto)));
    }

    @PreAuthorize("hasPermission(this.pcmpcmsgqmgrMapping.toDomain(#pcmpcmsgqmgrdto),'ehr-PcmPcmSgqMgr-Save')")
    @ApiOperation(value = "保存试岗期管理（停用）", tags = {"试岗期管理（停用）" },  notes = "保存试岗期管理（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmpcmsgqmgrs/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmPcmSgqMgrDTO pcmpcmsgqmgrdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmpcmsgqmgrService.save(pcmpcmsgqmgrMapping.toDomain(pcmpcmsgqmgrdto)));
    }

    @PreAuthorize("hasPermission(this.pcmpcmsgqmgrMapping.toDomain(#pcmpcmsgqmgrdtos),'ehr-PcmPcmSgqMgr-Save')")
    @ApiOperation(value = "批量保存试岗期管理（停用）", tags = {"试岗期管理（停用）" },  notes = "批量保存试岗期管理（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmpcmsgqmgrs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmPcmSgqMgrDTO> pcmpcmsgqmgrdtos) {
        pcmpcmsgqmgrService.saveBatch(pcmpcmsgqmgrMapping.toDomain(pcmpcmsgqmgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmPcmSgqMgr-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"试岗期管理（停用）" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmpcmsgqmgrs/fetchdefault")
	public ResponseEntity<List<PcmPcmSgqMgrDTO>> fetchDefault(PcmPcmSgqMgrSearchContext context) {
        Page<PcmPcmSgqMgr> domains = pcmpcmsgqmgrService.searchDefault(context) ;
        List<PcmPcmSgqMgrDTO> list = pcmpcmsgqmgrMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmPcmSgqMgr-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"试岗期管理（停用）" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmpcmsgqmgrs/searchdefault")
	public ResponseEntity<Page<PcmPcmSgqMgrDTO>> searchDefault(@RequestBody PcmPcmSgqMgrSearchContext context) {
        Page<PcmPcmSgqMgr> domains = pcmpcmsgqmgrService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmpcmsgqmgrMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

