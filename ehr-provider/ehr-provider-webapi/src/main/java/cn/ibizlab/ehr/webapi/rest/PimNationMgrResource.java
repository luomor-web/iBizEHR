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
import cn.ibizlab.ehr.core.pim.domain.PimNationMgr;
import cn.ibizlab.ehr.core.pim.service.IPimNationMgrService;
import cn.ibizlab.ehr.core.pim.filter.PimNationMgrSearchContext;

@Slf4j
@Api(tags = {"民族管理" })
@RestController("WebApi-pimnationmgr")
@RequestMapping("")
public class PimNationMgrResource {

    @Autowired
    public IPimNationMgrService pimnationmgrService;

    @Autowired
    @Lazy
    public PimNationMgrMapping pimnationmgrMapping;

    @PreAuthorize("hasPermission(this.pimnationmgrMapping.toDomain(#pimnationmgrdto),'ehr-PimNationMgr-Save')")
    @ApiOperation(value = "保存民族管理", tags = {"民族管理" },  notes = "保存民族管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimnationmgrs/save")
    public ResponseEntity<Boolean> save(@RequestBody PimNationMgrDTO pimnationmgrdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimnationmgrService.save(pimnationmgrMapping.toDomain(pimnationmgrdto)));
    }

    @PreAuthorize("hasPermission(this.pimnationmgrMapping.toDomain(#pimnationmgrdtos),'ehr-PimNationMgr-Save')")
    @ApiOperation(value = "批量保存民族管理", tags = {"民族管理" },  notes = "批量保存民族管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimnationmgrs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimNationMgrDTO> pimnationmgrdtos) {
        pimnationmgrService.saveBatch(pimnationmgrMapping.toDomain(pimnationmgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimnationmgrService.get(#pimnationmgr_id),'ehr-PimNationMgr-Remove')")
    @ApiOperation(value = "删除民族管理", tags = {"民族管理" },  notes = "删除民族管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimnationmgrs/{pimnationmgr_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimnationmgr_id") String pimnationmgr_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimnationmgrService.remove(pimnationmgr_id));
    }

    @PreAuthorize("hasPermission(this.pimnationmgrService.getPimnationmgrByIds(#ids),'ehr-PimNationMgr-Remove')")
    @ApiOperation(value = "批量删除民族管理", tags = {"民族管理" },  notes = "批量删除民族管理")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimnationmgrs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimnationmgrService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取民族管理草稿", tags = {"民族管理" },  notes = "获取民族管理草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimnationmgrs/getdraft")
    public ResponseEntity<PimNationMgrDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimnationmgrMapping.toDto(pimnationmgrService.getDraft(new PimNationMgr())));
    }

    @ApiOperation(value = "检查民族管理", tags = {"民族管理" },  notes = "检查民族管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimnationmgrs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimNationMgrDTO pimnationmgrdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimnationmgrService.checkKey(pimnationmgrMapping.toDomain(pimnationmgrdto)));
    }

    @PreAuthorize("hasPermission(this.pimnationmgrMapping.toDomain(#pimnationmgrdto),'ehr-PimNationMgr-Create')")
    @ApiOperation(value = "新建民族管理", tags = {"民族管理" },  notes = "新建民族管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimnationmgrs")
    @Transactional
    public ResponseEntity<PimNationMgrDTO> create(@RequestBody PimNationMgrDTO pimnationmgrdto) {
        PimNationMgr domain = pimnationmgrMapping.toDomain(pimnationmgrdto);
		pimnationmgrService.create(domain);
        PimNationMgrDTO dto = pimnationmgrMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimnationmgrMapping.toDomain(#pimnationmgrdtos),'ehr-PimNationMgr-Create')")
    @ApiOperation(value = "批量新建民族管理", tags = {"民族管理" },  notes = "批量新建民族管理")
	@RequestMapping(method = RequestMethod.POST, value = "/pimnationmgrs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimNationMgrDTO> pimnationmgrdtos) {
        pimnationmgrService.createBatch(pimnationmgrMapping.toDomain(pimnationmgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pimnationmgrMapping.toDomain(returnObject.body),'ehr-PimNationMgr-Get')")
    @ApiOperation(value = "获取民族管理", tags = {"民族管理" },  notes = "获取民族管理")
	@RequestMapping(method = RequestMethod.GET, value = "/pimnationmgrs/{pimnationmgr_id}")
    public ResponseEntity<PimNationMgrDTO> get(@PathVariable("pimnationmgr_id") String pimnationmgr_id) {
        PimNationMgr domain = pimnationmgrService.get(pimnationmgr_id);
        PimNationMgrDTO dto = pimnationmgrMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimnationmgrService.get(#pimnationmgr_id),'ehr-PimNationMgr-Update')")
    @ApiOperation(value = "更新民族管理", tags = {"民族管理" },  notes = "更新民族管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimnationmgrs/{pimnationmgr_id}")
    @Transactional
    public ResponseEntity<PimNationMgrDTO> update(@PathVariable("pimnationmgr_id") String pimnationmgr_id, @RequestBody PimNationMgrDTO pimnationmgrdto) {
		PimNationMgr domain  = pimnationmgrMapping.toDomain(pimnationmgrdto);
        domain .setNationmgrid(pimnationmgr_id);
		pimnationmgrService.update(domain );
		PimNationMgrDTO dto = pimnationmgrMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimnationmgrService.getPimnationmgrByEntities(this.pimnationmgrMapping.toDomain(#pimnationmgrdtos)),'ehr-PimNationMgr-Update')")
    @ApiOperation(value = "批量更新民族管理", tags = {"民族管理" },  notes = "批量更新民族管理")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimnationmgrs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimNationMgrDTO> pimnationmgrdtos) {
        pimnationmgrService.updateBatch(pimnationmgrMapping.toDomain(pimnationmgrdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimNationMgr-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"民族管理" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimnationmgrs/fetchdefault")
	public ResponseEntity<List<PimNationMgrDTO>> fetchDefault(PimNationMgrSearchContext context) {
        Page<PimNationMgr> domains = pimnationmgrService.searchDefault(context) ;
        List<PimNationMgrDTO> list = pimnationmgrMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimNationMgr-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"民族管理" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimnationmgrs/searchdefault")
	public ResponseEntity<Page<PimNationMgrDTO>> searchDefault(@RequestBody PimNationMgrSearchContext context) {
        Page<PimNationMgr> domains = pimnationmgrService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimnationmgrMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

