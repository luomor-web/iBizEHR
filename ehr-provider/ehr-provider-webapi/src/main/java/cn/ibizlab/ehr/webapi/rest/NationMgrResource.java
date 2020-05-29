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
import cn.ibizlab.ehr.core.pim.domain.NationMgr;
import cn.ibizlab.ehr.core.pim.service.INationMgrService;
import cn.ibizlab.ehr.core.pim.filter.NationMgrSearchContext;

@Slf4j
@Api(tags = {"民族管理" })
@RestController("WebApi-nationmgr")
@RequestMapping("")
public class NationMgrResource {

    @Autowired
    public INationMgrService nationmgrService;

    @Autowired
    @Lazy
    public NationMgrMapping nationmgrMapping;

    @PreAuthorize("hasPermission(this.nationmgrMapping.toDomain(#nationmgrdto),'ehr-NationMgr-Save')")
    @ApiOperation(value = "保存民族管理", tags = {"民族管理" },  notes = "保存民族管理")
	@RequestMapping(method = RequestMethod.POST, value = "/nationmgrs/save")
    public ResponseEntity<Boolean> save(@RequestBody NationMgrDTO nationmgrdto) {
        return ResponseEntity.status(HttpStatus.OK).body(nationmgrService.save(nationmgrMapping.toDomain(nationmgrdto)));
    }

    @PreAuthorize("hasPermission(this.nationmgrMapping.toDomain(#nationmgrdtos),'ehr-NationMgr-Save')")
    @ApiOperation(value = "批量保存民族管理", tags = {"民族管理" },  notes = "批量保存民族管理")
	@RequestMapping(method = RequestMethod.POST, value = "/nationmgrs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<NationMgrDTO> nationmgrdtos) {
        nationmgrService.saveBatch(nationmgrMapping.toDomain(nationmgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.nationmgrService.get(#nationmgr_id),'ehr-NationMgr-Remove')")
    @ApiOperation(value = "删除民族管理", tags = {"民族管理" },  notes = "删除民族管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/nationmgrs/{nationmgr_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("nationmgr_id") String nationmgr_id) {
         return ResponseEntity.status(HttpStatus.OK).body(nationmgrService.remove(nationmgr_id));
    }

    @PreAuthorize("hasPermission(this.nationmgrService.getNationmgrByIds(#ids),'ehr-NationMgr-Remove')")
    @ApiOperation(value = "批量删除民族管理", tags = {"民族管理" },  notes = "批量删除民族管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/nationmgrs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        nationmgrService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取民族管理草稿", tags = {"民族管理" },  notes = "获取民族管理草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/nationmgrs/getdraft")
    public ResponseEntity<NationMgrDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(nationmgrMapping.toDto(nationmgrService.getDraft(new NationMgr())));
    }

    @ApiOperation(value = "检查民族管理", tags = {"民族管理" },  notes = "检查民族管理")
	@RequestMapping(method = RequestMethod.POST, value = "/nationmgrs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody NationMgrDTO nationmgrdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(nationmgrService.checkKey(nationmgrMapping.toDomain(nationmgrdto)));
    }

    @PreAuthorize("hasPermission(this.nationmgrMapping.toDomain(#nationmgrdto),'ehr-NationMgr-Create')")
    @ApiOperation(value = "新建民族管理", tags = {"民族管理" },  notes = "新建民族管理")
	@RequestMapping(method = RequestMethod.POST, value = "/nationmgrs")
    @Transactional
    public ResponseEntity<NationMgrDTO> create(@RequestBody NationMgrDTO nationmgrdto) {
        NationMgr domain = nationmgrMapping.toDomain(nationmgrdto);
		nationmgrService.create(domain);
        NationMgrDTO dto = nationmgrMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.nationmgrMapping.toDomain(#nationmgrdtos),'ehr-NationMgr-Create')")
    @ApiOperation(value = "批量新建民族管理", tags = {"民族管理" },  notes = "批量新建民族管理")
	@RequestMapping(method = RequestMethod.POST, value = "/nationmgrs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<NationMgrDTO> nationmgrdtos) {
        nationmgrService.createBatch(nationmgrMapping.toDomain(nationmgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.nationmgrMapping.toDomain(returnObject.body),'ehr-NationMgr-Get')")
    @ApiOperation(value = "获取民族管理", tags = {"民族管理" },  notes = "获取民族管理")
	@RequestMapping(method = RequestMethod.GET, value = "/nationmgrs/{nationmgr_id}")
    public ResponseEntity<NationMgrDTO> get(@PathVariable("nationmgr_id") String nationmgr_id) {
        NationMgr domain = nationmgrService.get(nationmgr_id);
        NationMgrDTO dto = nationmgrMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.nationmgrService.get(#nationmgr_id),'ehr-NationMgr-Update')")
    @ApiOperation(value = "更新民族管理", tags = {"民族管理" },  notes = "更新民族管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/nationmgrs/{nationmgr_id}")
    @Transactional
    public ResponseEntity<NationMgrDTO> update(@PathVariable("nationmgr_id") String nationmgr_id, @RequestBody NationMgrDTO nationmgrdto) {
		NationMgr domain  = nationmgrMapping.toDomain(nationmgrdto);
        domain .setNationmgrid(nationmgr_id);
		nationmgrService.update(domain );
		NationMgrDTO dto = nationmgrMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.nationmgrService.getNationmgrByEntities(this.nationmgrMapping.toDomain(#nationmgrdtos)),'ehr-NationMgr-Update')")
    @ApiOperation(value = "批量更新民族管理", tags = {"民族管理" },  notes = "批量更新民族管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/nationmgrs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<NationMgrDTO> nationmgrdtos) {
        nationmgrService.updateBatch(nationmgrMapping.toDomain(nationmgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-NationMgr-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"民族管理" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/nationmgrs/fetchdefault")
	public ResponseEntity<List<NationMgrDTO>> fetchDefault(NationMgrSearchContext context) {
        Page<NationMgr> domains = nationmgrService.searchDefault(context) ;
        List<NationMgrDTO> list = nationmgrMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-NationMgr-Default-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"民族管理" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/nationmgrs/searchdefault")
	public ResponseEntity<Page<NationMgrDTO>> searchDefault(@RequestBody NationMgrSearchContext context) {
        Page<NationMgr> domains = nationmgrService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(nationmgrMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

