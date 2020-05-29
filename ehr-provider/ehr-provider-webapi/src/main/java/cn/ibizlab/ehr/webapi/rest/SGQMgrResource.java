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
import cn.ibizlab.ehr.core.pcm.domain.SGQMgr;
import cn.ibizlab.ehr.core.pcm.service.ISGQMgrService;
import cn.ibizlab.ehr.core.pcm.filter.SGQMgrSearchContext;

@Slf4j
@Api(tags = {"试岗期管理（停用）" })
@RestController("WebApi-sgqmgr")
@RequestMapping("")
public class SGQMgrResource {

    @Autowired
    public ISGQMgrService sgqmgrService;

    @Autowired
    @Lazy
    public SGQMgrMapping sgqmgrMapping;

    @PostAuthorize("hasPermission(this.sgqmgrMapping.toDomain(returnObject.body),'ehr-SGQMgr-Get')")
    @ApiOperation(value = "获取试岗期管理（停用）", tags = {"试岗期管理（停用）" },  notes = "获取试岗期管理（停用）")
	@RequestMapping(method = RequestMethod.GET, value = "/sgqmgrs/{sgqmgr_id}")
    public ResponseEntity<SGQMgrDTO> get(@PathVariable("sgqmgr_id") String sgqmgr_id) {
        SGQMgr domain = sgqmgrService.get(sgqmgr_id);
        SGQMgrDTO dto = sgqmgrMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取试岗期管理（停用）草稿", tags = {"试岗期管理（停用）" },  notes = "获取试岗期管理（停用）草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/sgqmgrs/getdraft")
    public ResponseEntity<SGQMgrDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(sgqmgrMapping.toDto(sgqmgrService.getDraft(new SGQMgr())));
    }

    @PreAuthorize("hasPermission(this.sgqmgrMapping.toDomain(#sgqmgrdto),'ehr-SGQMgr-Create')")
    @ApiOperation(value = "新建试岗期管理（停用）", tags = {"试岗期管理（停用）" },  notes = "新建试岗期管理（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/sgqmgrs")
    @Transactional
    public ResponseEntity<SGQMgrDTO> create(@RequestBody SGQMgrDTO sgqmgrdto) {
        SGQMgr domain = sgqmgrMapping.toDomain(sgqmgrdto);
		sgqmgrService.create(domain);
        SGQMgrDTO dto = sgqmgrMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sgqmgrMapping.toDomain(#sgqmgrdtos),'ehr-SGQMgr-Create')")
    @ApiOperation(value = "批量新建试岗期管理（停用）", tags = {"试岗期管理（停用）" },  notes = "批量新建试岗期管理（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/sgqmgrs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<SGQMgrDTO> sgqmgrdtos) {
        sgqmgrService.createBatch(sgqmgrMapping.toDomain(sgqmgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.sgqmgrService.get(#sgqmgr_id),'ehr-SGQMgr-Update')")
    @ApiOperation(value = "更新试岗期管理（停用）", tags = {"试岗期管理（停用）" },  notes = "更新试岗期管理（停用）")
	@RequestMapping(method = RequestMethod.PUT, value = "/sgqmgrs/{sgqmgr_id}")
    @Transactional
    public ResponseEntity<SGQMgrDTO> update(@PathVariable("sgqmgr_id") String sgqmgr_id, @RequestBody SGQMgrDTO sgqmgrdto) {
		SGQMgr domain  = sgqmgrMapping.toDomain(sgqmgrdto);
        domain .setSgqmgrid(sgqmgr_id);
		sgqmgrService.update(domain );
		SGQMgrDTO dto = sgqmgrMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.sgqmgrService.getSgqmgrByEntities(this.sgqmgrMapping.toDomain(#sgqmgrdtos)),'ehr-SGQMgr-Update')")
    @ApiOperation(value = "批量更新试岗期管理（停用）", tags = {"试岗期管理（停用）" },  notes = "批量更新试岗期管理（停用）")
	@RequestMapping(method = RequestMethod.PUT, value = "/sgqmgrs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<SGQMgrDTO> sgqmgrdtos) {
        sgqmgrService.updateBatch(sgqmgrMapping.toDomain(sgqmgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.sgqmgrService.get(#sgqmgr_id),'ehr-SGQMgr-Remove')")
    @ApiOperation(value = "删除试岗期管理（停用）", tags = {"试岗期管理（停用）" },  notes = "删除试岗期管理（停用）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sgqmgrs/{sgqmgr_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("sgqmgr_id") String sgqmgr_id) {
         return ResponseEntity.status(HttpStatus.OK).body(sgqmgrService.remove(sgqmgr_id));
    }

    @PreAuthorize("hasPermission(this.sgqmgrService.getSgqmgrByIds(#ids),'ehr-SGQMgr-Remove')")
    @ApiOperation(value = "批量删除试岗期管理（停用）", tags = {"试岗期管理（停用）" },  notes = "批量删除试岗期管理（停用）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/sgqmgrs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        sgqmgrService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查试岗期管理（停用）", tags = {"试岗期管理（停用）" },  notes = "检查试岗期管理（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/sgqmgrs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody SGQMgrDTO sgqmgrdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(sgqmgrService.checkKey(sgqmgrMapping.toDomain(sgqmgrdto)));
    }

    @PreAuthorize("hasPermission(this.sgqmgrMapping.toDomain(#sgqmgrdto),'ehr-SGQMgr-Save')")
    @ApiOperation(value = "保存试岗期管理（停用）", tags = {"试岗期管理（停用）" },  notes = "保存试岗期管理（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/sgqmgrs/save")
    public ResponseEntity<Boolean> save(@RequestBody SGQMgrDTO sgqmgrdto) {
        return ResponseEntity.status(HttpStatus.OK).body(sgqmgrService.save(sgqmgrMapping.toDomain(sgqmgrdto)));
    }

    @PreAuthorize("hasPermission(this.sgqmgrMapping.toDomain(#sgqmgrdtos),'ehr-SGQMgr-Save')")
    @ApiOperation(value = "批量保存试岗期管理（停用）", tags = {"试岗期管理（停用）" },  notes = "批量保存试岗期管理（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/sgqmgrs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<SGQMgrDTO> sgqmgrdtos) {
        sgqmgrService.saveBatch(sgqmgrMapping.toDomain(sgqmgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SGQMgr-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"试岗期管理（停用）" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/sgqmgrs/fetchdefault")
	public ResponseEntity<List<SGQMgrDTO>> fetchDefault(SGQMgrSearchContext context) {
        Page<SGQMgr> domains = sgqmgrService.searchDefault(context) ;
        List<SGQMgrDTO> list = sgqmgrMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-SGQMgr-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"试岗期管理（停用）" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/sgqmgrs/searchdefault")
	public ResponseEntity<Page<SGQMgrDTO>> searchDefault(@RequestBody SGQMgrSearchContext context) {
        Page<SGQMgr> domains = sgqmgrService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(sgqmgrMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

