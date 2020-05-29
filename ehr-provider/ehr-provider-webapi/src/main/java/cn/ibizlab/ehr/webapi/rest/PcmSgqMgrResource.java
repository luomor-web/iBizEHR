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
import cn.ibizlab.ehr.core.pcm.domain.PcmSgqMgr;
import cn.ibizlab.ehr.core.pcm.service.IPcmSgqMgrService;
import cn.ibizlab.ehr.core.pcm.filter.PcmSgqMgrSearchContext;

@Slf4j
@Api(tags = {"试岗期管理" })
@RestController("WebApi-pcmsgqmgr")
@RequestMapping("")
public class PcmSgqMgrResource {

    @Autowired
    public IPcmSgqMgrService pcmsgqmgrService;

    @Autowired
    @Lazy
    public PcmSgqMgrMapping pcmsgqmgrMapping;

    @PreAuthorize("hasPermission(this.pcmsgqmgrService.get(#pcmsgqmgr_id),'ehr-PcmSgqMgr-Remove')")
    @ApiOperation(value = "删除试岗期管理", tags = {"试岗期管理" },  notes = "删除试岗期管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmsgqmgrs/{pcmsgqmgr_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmsgqmgr_id") String pcmsgqmgr_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmsgqmgrService.remove(pcmsgqmgr_id));
    }

    @PreAuthorize("hasPermission(this.pcmsgqmgrService.getPcmsgqmgrByIds(#ids),'ehr-PcmSgqMgr-Remove')")
    @ApiOperation(value = "批量删除试岗期管理", tags = {"试岗期管理" },  notes = "批量删除试岗期管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmsgqmgrs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmsgqmgrService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmSgqMgr-SGTG-all')")
    @ApiOperation(value = "试岗通过", tags = {"试岗期管理" },  notes = "试岗通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmsgqmgrs/{pcmsgqmgr_id}/sgtg")
    @Transactional
    public ResponseEntity<PcmSgqMgrDTO> sGTG(@PathVariable("pcmsgqmgr_id") String pcmsgqmgr_id, @RequestBody PcmSgqMgrDTO pcmsgqmgrdto) {
        PcmSgqMgr pcmsgqmgr = pcmsgqmgrMapping.toDomain(pcmsgqmgrdto);
        pcmsgqmgr.setPcmsgqmgrid(pcmsgqmgr_id);
        pcmsgqmgr = pcmsgqmgrService.sGTG(pcmsgqmgr);
        pcmsgqmgrdto = pcmsgqmgrMapping.toDto(pcmsgqmgr);
        return ResponseEntity.status(HttpStatus.OK).body(pcmsgqmgrdto);
    }

    @PostAuthorize("hasPermission(this.pcmsgqmgrMapping.toDomain(returnObject.body),'ehr-PcmSgqMgr-Get')")
    @ApiOperation(value = "获取试岗期管理", tags = {"试岗期管理" },  notes = "获取试岗期管理")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmsgqmgrs/{pcmsgqmgr_id}")
    public ResponseEntity<PcmSgqMgrDTO> get(@PathVariable("pcmsgqmgr_id") String pcmsgqmgr_id) {
        PcmSgqMgr domain = pcmsgqmgrService.get(pcmsgqmgr_id);
        PcmSgqMgrDTO dto = pcmsgqmgrMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmSgqMgr-SGBTG-all')")
    @ApiOperation(value = "试岗不通过", tags = {"试岗期管理" },  notes = "试岗不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmsgqmgrs/{pcmsgqmgr_id}/sgbtg")
    @Transactional
    public ResponseEntity<PcmSgqMgrDTO> sGBTG(@PathVariable("pcmsgqmgr_id") String pcmsgqmgr_id, @RequestBody PcmSgqMgrDTO pcmsgqmgrdto) {
        PcmSgqMgr pcmsgqmgr = pcmsgqmgrMapping.toDomain(pcmsgqmgrdto);
        pcmsgqmgr.setPcmsgqmgrid(pcmsgqmgr_id);
        pcmsgqmgr = pcmsgqmgrService.sGBTG(pcmsgqmgr);
        pcmsgqmgrdto = pcmsgqmgrMapping.toDto(pcmsgqmgr);
        return ResponseEntity.status(HttpStatus.OK).body(pcmsgqmgrdto);
    }

    @ApiOperation(value = "检查试岗期管理", tags = {"试岗期管理" },  notes = "检查试岗期管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmsgqmgrs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmSgqMgrDTO pcmsgqmgrdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmsgqmgrService.checkKey(pcmsgqmgrMapping.toDomain(pcmsgqmgrdto)));
    }

    @PreAuthorize("hasPermission(this.pcmsgqmgrService.get(#pcmsgqmgr_id),'ehr-PcmSgqMgr-Update')")
    @ApiOperation(value = "更新试岗期管理", tags = {"试岗期管理" },  notes = "更新试岗期管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmsgqmgrs/{pcmsgqmgr_id}")
    @Transactional
    public ResponseEntity<PcmSgqMgrDTO> update(@PathVariable("pcmsgqmgr_id") String pcmsgqmgr_id, @RequestBody PcmSgqMgrDTO pcmsgqmgrdto) {
		PcmSgqMgr domain  = pcmsgqmgrMapping.toDomain(pcmsgqmgrdto);
        domain .setPcmsgqmgrid(pcmsgqmgr_id);
		pcmsgqmgrService.update(domain );
		PcmSgqMgrDTO dto = pcmsgqmgrMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmsgqmgrService.getPcmsgqmgrByEntities(this.pcmsgqmgrMapping.toDomain(#pcmsgqmgrdtos)),'ehr-PcmSgqMgr-Update')")
    @ApiOperation(value = "批量更新试岗期管理", tags = {"试岗期管理" },  notes = "批量更新试岗期管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmsgqmgrs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmSgqMgrDTO> pcmsgqmgrdtos) {
        pcmsgqmgrService.updateBatch(pcmsgqmgrMapping.toDomain(pcmsgqmgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmsgqmgrMapping.toDomain(#pcmsgqmgrdto),'ehr-PcmSgqMgr-Create')")
    @ApiOperation(value = "新建试岗期管理", tags = {"试岗期管理" },  notes = "新建试岗期管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmsgqmgrs")
    @Transactional
    public ResponseEntity<PcmSgqMgrDTO> create(@RequestBody PcmSgqMgrDTO pcmsgqmgrdto) {
        PcmSgqMgr domain = pcmsgqmgrMapping.toDomain(pcmsgqmgrdto);
		pcmsgqmgrService.create(domain);
        PcmSgqMgrDTO dto = pcmsgqmgrMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmsgqmgrMapping.toDomain(#pcmsgqmgrdtos),'ehr-PcmSgqMgr-Create')")
    @ApiOperation(value = "批量新建试岗期管理", tags = {"试岗期管理" },  notes = "批量新建试岗期管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmsgqmgrs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmSgqMgrDTO> pcmsgqmgrdtos) {
        pcmsgqmgrService.createBatch(pcmsgqmgrMapping.toDomain(pcmsgqmgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmsgqmgrMapping.toDomain(#pcmsgqmgrdto),'ehr-PcmSgqMgr-Save')")
    @ApiOperation(value = "保存试岗期管理", tags = {"试岗期管理" },  notes = "保存试岗期管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmsgqmgrs/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmSgqMgrDTO pcmsgqmgrdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmsgqmgrService.save(pcmsgqmgrMapping.toDomain(pcmsgqmgrdto)));
    }

    @PreAuthorize("hasPermission(this.pcmsgqmgrMapping.toDomain(#pcmsgqmgrdtos),'ehr-PcmSgqMgr-Save')")
    @ApiOperation(value = "批量保存试岗期管理", tags = {"试岗期管理" },  notes = "批量保存试岗期管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmsgqmgrs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmSgqMgrDTO> pcmsgqmgrdtos) {
        pcmsgqmgrService.saveBatch(pcmsgqmgrMapping.toDomain(pcmsgqmgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取试岗期管理草稿", tags = {"试岗期管理" },  notes = "获取试岗期管理草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmsgqmgrs/getdraft")
    public ResponseEntity<PcmSgqMgrDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmsgqmgrMapping.toDto(pcmsgqmgrService.getDraft(new PcmSgqMgr())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmSgqMgr-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"试岗期管理" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmsgqmgrs/fetchdefault")
	public ResponseEntity<List<PcmSgqMgrDTO>> fetchDefault(PcmSgqMgrSearchContext context) {
        Page<PcmSgqMgr> domains = pcmsgqmgrService.searchDefault(context) ;
        List<PcmSgqMgrDTO> list = pcmsgqmgrMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmSgqMgr-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"试岗期管理" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmsgqmgrs/searchdefault")
	public ResponseEntity<Page<PcmSgqMgrDTO>> searchDefault(@RequestBody PcmSgqMgrSearchContext context) {
        Page<PcmSgqMgr> domains = pcmsgqmgrService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmsgqmgrMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

