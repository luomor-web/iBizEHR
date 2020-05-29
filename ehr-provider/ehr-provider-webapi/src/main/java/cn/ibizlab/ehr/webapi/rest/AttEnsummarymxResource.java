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
import cn.ibizlab.ehr.core.att.domain.AttEnsummarymx;
import cn.ibizlab.ehr.core.att.service.IAttEnsummarymxService;
import cn.ibizlab.ehr.core.att.filter.AttEnsummarymxSearchContext;

@Slf4j
@Api(tags = {"考勤汇总明细（停用）" })
@RestController("WebApi-attensummarymx")
@RequestMapping("")
public class AttEnsummarymxResource {

    @Autowired
    public IAttEnsummarymxService attensummarymxService;

    @Autowired
    @Lazy
    public AttEnsummarymxMapping attensummarymxMapping;

    @PreAuthorize("hasPermission(this.attensummarymxMapping.toDomain(#attensummarymxdto),'ehr-AttEnsummarymx-Create')")
    @ApiOperation(value = "新建考勤汇总明细（停用）", tags = {"考勤汇总明细（停用）" },  notes = "新建考勤汇总明细（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/attensummarymxes")
    @Transactional
    public ResponseEntity<AttEnsummarymxDTO> create(@RequestBody AttEnsummarymxDTO attensummarymxdto) {
        AttEnsummarymx domain = attensummarymxMapping.toDomain(attensummarymxdto);
		attensummarymxService.create(domain);
        AttEnsummarymxDTO dto = attensummarymxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attensummarymxMapping.toDomain(#attensummarymxdtos),'ehr-AttEnsummarymx-Create')")
    @ApiOperation(value = "批量新建考勤汇总明细（停用）", tags = {"考勤汇总明细（停用）" },  notes = "批量新建考勤汇总明细（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/attensummarymxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<AttEnsummarymxDTO> attensummarymxdtos) {
        attensummarymxService.createBatch(attensummarymxMapping.toDomain(attensummarymxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查考勤汇总明细（停用）", tags = {"考勤汇总明细（停用）" },  notes = "检查考勤汇总明细（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/attensummarymxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody AttEnsummarymxDTO attensummarymxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(attensummarymxService.checkKey(attensummarymxMapping.toDomain(attensummarymxdto)));
    }

    @PostAuthorize("hasPermission(this.attensummarymxMapping.toDomain(returnObject.body),'ehr-AttEnsummarymx-Get')")
    @ApiOperation(value = "获取考勤汇总明细（停用）", tags = {"考勤汇总明细（停用）" },  notes = "获取考勤汇总明细（停用）")
	@RequestMapping(method = RequestMethod.GET, value = "/attensummarymxes/{attensummarymx_id}")
    public ResponseEntity<AttEnsummarymxDTO> get(@PathVariable("attensummarymx_id") String attensummarymx_id) {
        AttEnsummarymx domain = attensummarymxService.get(attensummarymx_id);
        AttEnsummarymxDTO dto = attensummarymxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取考勤汇总明细（停用）草稿", tags = {"考勤汇总明细（停用）" },  notes = "获取考勤汇总明细（停用）草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/attensummarymxes/getdraft")
    public ResponseEntity<AttEnsummarymxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(attensummarymxMapping.toDto(attensummarymxService.getDraft(new AttEnsummarymx())));
    }

    @PreAuthorize("hasPermission(this.attensummarymxService.get(#attensummarymx_id),'ehr-AttEnsummarymx-Remove')")
    @ApiOperation(value = "删除考勤汇总明细（停用）", tags = {"考勤汇总明细（停用）" },  notes = "删除考勤汇总明细（停用）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attensummarymxes/{attensummarymx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("attensummarymx_id") String attensummarymx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(attensummarymxService.remove(attensummarymx_id));
    }

    @PreAuthorize("hasPermission(this.attensummarymxService.getAttensummarymxByIds(#ids),'ehr-AttEnsummarymx-Remove')")
    @ApiOperation(value = "批量删除考勤汇总明细（停用）", tags = {"考勤汇总明细（停用）" },  notes = "批量删除考勤汇总明细（停用）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/attensummarymxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        attensummarymxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attensummarymxMapping.toDomain(#attensummarymxdto),'ehr-AttEnsummarymx-Save')")
    @ApiOperation(value = "保存考勤汇总明细（停用）", tags = {"考勤汇总明细（停用）" },  notes = "保存考勤汇总明细（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/attensummarymxes/save")
    public ResponseEntity<Boolean> save(@RequestBody AttEnsummarymxDTO attensummarymxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(attensummarymxService.save(attensummarymxMapping.toDomain(attensummarymxdto)));
    }

    @PreAuthorize("hasPermission(this.attensummarymxMapping.toDomain(#attensummarymxdtos),'ehr-AttEnsummarymx-Save')")
    @ApiOperation(value = "批量保存考勤汇总明细（停用）", tags = {"考勤汇总明细（停用）" },  notes = "批量保存考勤汇总明细（停用）")
	@RequestMapping(method = RequestMethod.POST, value = "/attensummarymxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<AttEnsummarymxDTO> attensummarymxdtos) {
        attensummarymxService.saveBatch(attensummarymxMapping.toDomain(attensummarymxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.attensummarymxService.get(#attensummarymx_id),'ehr-AttEnsummarymx-Update')")
    @ApiOperation(value = "更新考勤汇总明细（停用）", tags = {"考勤汇总明细（停用）" },  notes = "更新考勤汇总明细（停用）")
	@RequestMapping(method = RequestMethod.PUT, value = "/attensummarymxes/{attensummarymx_id}")
    @Transactional
    public ResponseEntity<AttEnsummarymxDTO> update(@PathVariable("attensummarymx_id") String attensummarymx_id, @RequestBody AttEnsummarymxDTO attensummarymxdto) {
		AttEnsummarymx domain  = attensummarymxMapping.toDomain(attensummarymxdto);
        domain .setAttendancesummarymxid(attensummarymx_id);
		attensummarymxService.update(domain );
		AttEnsummarymxDTO dto = attensummarymxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.attensummarymxService.getAttensummarymxByEntities(this.attensummarymxMapping.toDomain(#attensummarymxdtos)),'ehr-AttEnsummarymx-Update')")
    @ApiOperation(value = "批量更新考勤汇总明细（停用）", tags = {"考勤汇总明细（停用）" },  notes = "批量更新考勤汇总明细（停用）")
	@RequestMapping(method = RequestMethod.PUT, value = "/attensummarymxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<AttEnsummarymxDTO> attensummarymxdtos) {
        attensummarymxService.updateBatch(attensummarymxMapping.toDomain(attensummarymxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEnsummarymx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"考勤汇总明细（停用）" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/attensummarymxes/fetchdefault")
	public ResponseEntity<List<AttEnsummarymxDTO>> fetchDefault(AttEnsummarymxSearchContext context) {
        Page<AttEnsummarymx> domains = attensummarymxService.searchDefault(context) ;
        List<AttEnsummarymxDTO> list = attensummarymxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-AttEnsummarymx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"考勤汇总明细（停用）" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/attensummarymxes/searchdefault")
	public ResponseEntity<Page<AttEnsummarymxDTO>> searchDefault(@RequestBody AttEnsummarymxSearchContext context) {
        Page<AttEnsummarymx> domains = attensummarymxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(attensummarymxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

