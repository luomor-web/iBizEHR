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
import cn.ibizlab.ehr.core.pim.domain.PIMBYZZJLMX;
import cn.ibizlab.ehr.core.pim.service.IPIMBYZZJLMXService;
import cn.ibizlab.ehr.core.pim.filter.PIMBYZZJLMXSearchContext;

@Slf4j
@Api(tags = {"B/Y类员工转正记录引用明细" })
@RestController("WebApi-pimbyzzjlmx")
@RequestMapping("")
public class PIMBYZZJLMXResource {

    @Autowired
    public IPIMBYZZJLMXService pimbyzzjlmxService;

    @Autowired
    @Lazy
    public PIMBYZZJLMXMapping pimbyzzjlmxMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-SHTG-all')")
    @ApiOperation(value = "局总部初审通过", tags = {"B/Y类员工转正记录引用明细" },  notes = "局总部初审通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/shtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> sHTG(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.sHTG(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PostAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(returnObject.body),'ehr-PIMBYZZJLMX-Get')")
    @ApiOperation(value = "获取B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "获取B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}")
    public ResponseEntity<PIMBYZZJLMXDTO> get(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id) {
        PIMBYZZJLMX domain = pimbyzzjlmxService.get(pimbyzzjlmx_id);
        PIMBYZZJLMXDTO dto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-ReturnYPZ-all')")
    @ApiOperation(value = "失效", tags = {"B/Y类员工转正记录引用明细" },  notes = "失效")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/returnypz")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> returnYPZ(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.returnYPZ(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-JSPTG-all')")
    @ApiOperation(value = "局总部审批通过", tags = {"B/Y类员工转正记录引用明细" },  notes = "局总部审批通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/jsptg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> jSPTG(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.jSPTG(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-FillPersonInfo-all')")
    @ApiOperation(value = "填充人员信息", tags = {"B/Y类员工转正记录引用明细" },  notes = "填充人员信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> fillPersonInfo(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.fillPersonInfo(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @ApiOperation(value = "获取B/Y类员工转正记录引用明细草稿", tags = {"B/Y类员工转正记录引用明细" },  notes = "获取B/Y类员工转正记录引用明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimbyzzjlmxes/getdraft")
    public ResponseEntity<PIMBYZZJLMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxMapping.toDto(pimbyzzjlmxService.getDraft(new PIMBYZZJLMX())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-JSHTG-all')")
    @ApiOperation(value = "局总部审核通过", tags = {"B/Y类员工转正记录引用明细" },  notes = "局总部审核通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/jshtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> jSHTG(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.jSHTG(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-JSHBTG-all')")
    @ApiOperation(value = "局总部审核不通过", tags = {"B/Y类员工转正记录引用明细" },  notes = "局总部审核不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/jshbtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> jSHBTG(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.jSHBTG(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-Ensure-all')")
    @ApiOperation(value = "确认", tags = {"B/Y类员工转正记录引用明细" },  notes = "确认")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/ensure")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> ensure(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.ensure(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-SHBTG-all')")
    @ApiOperation(value = "局总部初审不通过", tags = {"B/Y类员工转正记录引用明细" },  notes = "局总部初审不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/shbtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> sHBTG(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.sHBTG(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxService.get(#pimbyzzjlmx_id),'ehr-PIMBYZZJLMX-Remove')")
    @ApiOperation(value = "删除B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "删除B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxService.remove(pimbyzzjlmx_id));
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxService.getPimbyzzjlmxByIds(#ids),'ehr-PIMBYZZJLMX-Remove')")
    @ApiOperation(value = "批量删除B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "批量删除B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimbyzzjlmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimbyzzjlmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-GSDSZSP-all')")
    @ApiOperation(value = "公司董事长审批同意", tags = {"B/Y类员工转正记录引用明细" },  notes = "公司董事长审批同意")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/gsdszsp")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> gSDSZSP(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.gSDSZSP(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-ZZCZ-all')")
    @ApiOperation(value = "转正操作", tags = {"B/Y类员工转正记录引用明细" },  notes = "转正操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/zzcz")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> zZCZ(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.zZCZ(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DSB-all')")
    @ApiOperation(value = "待上报", tags = {"B/Y类员工转正记录引用明细" },  notes = "待上报")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/dsb")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> dSB(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.dSB(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxService.get(#pimbyzzjlmx_id),'ehr-PIMBYZZJLMX-Update')")
    @ApiOperation(value = "更新B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "更新B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> update(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
		PIMBYZZJLMX domain  = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain .setPimbyzzjlmxid(pimbyzzjlmx_id);
		pimbyzzjlmxService.update(domain );
		PIMBYZZJLMXDTO dto = pimbyzzjlmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxService.getPimbyzzjlmxByEntities(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdtos)),'ehr-PIMBYZZJLMX-Update')")
    @ApiOperation(value = "批量更新B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "批量更新B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbyzzjlmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMBYZZJLMXDTO> pimbyzzjlmxdtos) {
        pimbyzzjlmxService.updateBatch(pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdto),'ehr-PIMBYZZJLMX-Create')")
    @ApiOperation(value = "新建B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "新建B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> create(@RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
		pimbyzzjlmxService.create(domain);
        PIMBYZZJLMXDTO dto = pimbyzzjlmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdtos),'ehr-PIMBYZZJLMX-Create')")
    @ApiOperation(value = "批量新建B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "批量新建B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMBYZZJLMXDTO> pimbyzzjlmxdtos) {
        pimbyzzjlmxService.createBatch(pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-JZBSHQR-all')")
    @ApiOperation(value = "确认", tags = {"B/Y类员工转正记录引用明细" },  notes = "确认")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/jzbshqr")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> jZBSHQR(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.jZBSHQR(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-GSDSZSPBTG-all')")
    @ApiOperation(value = "公司董事长审批拒绝", tags = {"B/Y类员工转正记录引用明细" },  notes = "公司董事长审批拒绝")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/gsdszspbtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> gSDSZSPBTG(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.gSDSZSPBTG(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-GSCSBTG-all')")
    @ApiOperation(value = "公司初审拒绝", tags = {"B/Y类员工转正记录引用明细" },  notes = "公司初审拒绝")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/gscsbtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> gSCSBTG(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.gSCSBTG(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-JSPBTG-all')")
    @ApiOperation(value = "局总部审批不通过", tags = {"B/Y类员工转正记录引用明细" },  notes = "局总部审批不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/jspbtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> jSPBTG(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.jSPBTG(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdto),'ehr-PIMBYZZJLMX-Save')")
    @ApiOperation(value = "保存B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "保存B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxService.save(pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto)));
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdtos),'ehr-PIMBYZZJLMX-Save')")
    @ApiOperation(value = "批量保存B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "批量保存B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMBYZZJLMXDTO> pimbyzzjlmxdtos) {
        pimbyzzjlmxService.saveBatch(pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-GSCS-all')")
    @ApiOperation(value = "公司初审同意", tags = {"B/Y类员工转正记录引用明细" },  notes = "公司初审同意")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/gscs")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> gSCS(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.gSCS(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @ApiOperation(value = "检查B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "检查B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxService.checkKey(pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-UpdatePeopleNum-all')")
    @ApiOperation(value = "刷新人数", tags = {"B/Y类员工转正记录引用明细" },  notes = "刷新人数")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/updatepeoplenum")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> updatePeopleNum(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.updatePeopleNum(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-JZBSPQR-all')")
    @ApiOperation(value = "确认", tags = {"B/Y类员工转正记录引用明细" },  notes = "确认")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/jzbspqr")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> jZBSPQR(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.jZBSPQR(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-ZZWSHDS-all')")
	@ApiOperation(value = "获取转正未审核", tags = {"B/Y类员工转正记录引用明细" } ,notes = "获取转正未审核")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyzzjlmxes/fetchzzwshds")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchZZWSHDS(PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchZZWSHDS(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-ZZWSHDS-all')")
	@ApiOperation(value = "查询转正未审核", tags = {"B/Y类员工转正记录引用明细" } ,notes = "查询转正未审核")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchzzwshds")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchZZWSHDS(@RequestBody PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchZZWSHDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-UnApproved-all')")
	@ApiOperation(value = "获取待公司初审", tags = {"B/Y类员工转正记录引用明细" } ,notes = "获取待公司初审")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyzzjlmxes/fetchunapproved")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchUnApproved(PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchUnApproved(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-UnApproved-all')")
	@ApiOperation(value = "查询待公司初审", tags = {"B/Y类员工转正记录引用明细" } ,notes = "查询待公司初审")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchunapproved")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchUnApproved(@RequestBody PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchUnApproved(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DDJZBSH-all')")
	@ApiOperation(value = "获取待局总部审核", tags = {"B/Y类员工转正记录引用明细" } ,notes = "获取待局总部审核")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyzzjlmxes/fetchddjzbsh")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchDDJZBSH(PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDDJZBSH(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DDJZBSH-all')")
	@ApiOperation(value = "查询待局总部审核", tags = {"B/Y类员工转正记录引用明细" } ,notes = "查询待局总部审核")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchddjzbsh")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchDDJZBSH(@RequestBody PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDDJZBSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-BYLZZJL-all')")
	@ApiOperation(value = "获取B/Y类员工转正记录", tags = {"B/Y类员工转正记录引用明细" } ,notes = "获取B/Y类员工转正记录")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyzzjlmxes/fetchbylzzjl")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchBYLZZJL(PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchBYLZZJL(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-BYLZZJL-all')")
	@ApiOperation(value = "查询B/Y类员工转正记录", tags = {"B/Y类员工转正记录引用明细" } ,notes = "查询B/Y类员工转正记录")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchbylzzjl")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchBYLZZJL(@RequestBody PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchBYLZZJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DGSDSZSH-all')")
	@ApiOperation(value = "获取待公司董事长审批", tags = {"B/Y类员工转正记录引用明细" } ,notes = "获取待公司董事长审批")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyzzjlmxes/fetchdgsdszsh")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchDGSDSZSH(PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDGSDSZSH(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DGSDSZSH-all')")
	@ApiOperation(value = "查询待公司董事长审批", tags = {"B/Y类员工转正记录引用明细" } ,notes = "查询待公司董事长审批")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchdgsdszsh")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchDGSDSZSH(@RequestBody PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDGSDSZSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-HTRY-all')")
	@ApiOperation(value = "获取回退人员", tags = {"B/Y类员工转正记录引用明细" } ,notes = "获取回退人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyzzjlmxes/fetchhtry")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchHTRY(PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchHTRY(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-HTRY-all')")
	@ApiOperation(value = "查询回退人员", tags = {"B/Y类员工转正记录引用明细" } ,notes = "查询回退人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchhtry")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchHTRY(@RequestBody PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchHTRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DJZBSP-all')")
	@ApiOperation(value = "获取待局总部审批", tags = {"B/Y类员工转正记录引用明细" } ,notes = "获取待局总部审批")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyzzjlmxes/fetchdjzbsp")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchDJZBSP(PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDJZBSP(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DJZBSP-all')")
	@ApiOperation(value = "查询待局总部审批", tags = {"B/Y类员工转正记录引用明细" } ,notes = "查询待局总部审批")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchdjzbsp")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchDJZBSP(@RequestBody PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDJZBSP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DSB-all')")
	@ApiOperation(value = "获取待上报", tags = {"B/Y类员工转正记录引用明细" } ,notes = "获取待上报")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyzzjlmxes/fetchdsb")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchDSB(PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDSB(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DSB-all')")
	@ApiOperation(value = "查询待上报", tags = {"B/Y类员工转正记录引用明细" } ,notes = "查询待上报")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchdsb")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchDSB(@RequestBody PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDSB(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-FinishYGBH-all')")
	@ApiOperation(value = "获取已变更员工编号名单", tags = {"B/Y类员工转正记录引用明细" } ,notes = "获取已变更员工编号名单")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyzzjlmxes/fetchfinishygbh")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchFinishYGBH(PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchFinishYGBH(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-FinishYGBH-all')")
	@ApiOperation(value = "查询已变更员工编号名单", tags = {"B/Y类员工转正记录引用明细" } ,notes = "查询已变更员工编号名单")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchfinishygbh")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchFinishYGBH(@RequestBody PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchFinishYGBH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DJZBSH-all')")
	@ApiOperation(value = "获取待局总部初审", tags = {"B/Y类员工转正记录引用明细" } ,notes = "获取待局总部初审")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyzzjlmxes/fetchdjzbsh")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchDJZBSH(PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDJZBSH(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DJZBSH-all')")
	@ApiOperation(value = "查询待局总部初审", tags = {"B/Y类员工转正记录引用明细" } ,notes = "查询待局总部初审")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchdjzbsh")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchDJZBSH(@RequestBody PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDJZBSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"B/Y类员工转正记录引用明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyzzjlmxes/fetchdefault")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchDefault(PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDefault(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"B/Y类员工转正记录引用明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchdefault")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchDefault(@RequestBody PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-SHTG-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/shtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> sHTGByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.sHTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PostAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(returnObject.body),'ehr-PIMBYZZJLMX-Get')")
    @ApiOperation(value = "根据B/Y类员工转正申请获取B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请获取B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}")
    public ResponseEntity<PIMBYZZJLMXDTO> getByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id) {
        PIMBYZZJLMX domain = pimbyzzjlmxService.get(pimbyzzjlmx_id);
        PIMBYZZJLMXDTO dto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-ReturnYPZ-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/returnypz")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> returnYPZByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.returnYPZ(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-JSPTG-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/jsptg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> jSPTGByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.jSPTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-FillPersonInfo-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> fillPersonInfoByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.fillPersonInfo(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @ApiOperation(value = "根据B/Y类员工转正申请获取B/Y类员工转正记录引用明细草稿", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请获取B/Y类员工转正记录引用明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/getdraft")
    public ResponseEntity<PIMBYZZJLMXDTO> getDraftByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id) {
        PIMBYZZJLMX domain = new PIMBYZZJLMX();
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxMapping.toDto(pimbyzzjlmxService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-JSHTG-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/jshtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> jSHTGByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.jSHTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-JSHBTG-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/jshbtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> jSHBTGByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.jSHBTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-Ensure-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/ensure")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> ensureByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.ensure(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-SHBTG-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/shbtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> sHBTGByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.sHBTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxService.get(#pimbyzzjlmx_id),'ehr-PIMBYZZJLMX-Remove')")
    @ApiOperation(value = "根据B/Y类员工转正申请删除B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请删除B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxService.remove(pimbyzzjlmx_id));
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxService.getPimbyzzjlmxByIds(#ids),'ehr-PIMBYZZJLMX-Remove')")
    @ApiOperation(value = "根据B/Y类员工转正申请批量删除B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请批量删除B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPimByygzzsq(@RequestBody List<String> ids) {
        pimbyzzjlmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-GSDSZSP-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/gsdszsp")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> gSDSZSPByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.gSDSZSP(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-ZZCZ-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/zzcz")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> zZCZByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.zZCZ(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DSB-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/dsb")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> dSBByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.dSB(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxService.get(#pimbyzzjlmx_id),'ehr-PIMBYZZJLMX-Update')")
    @ApiOperation(value = "根据B/Y类员工转正申请更新B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请更新B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> updateByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain.setPimbyzzjlmxid(pimbyzzjlmx_id);
		pimbyzzjlmxService.update(domain);
        PIMBYZZJLMXDTO dto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxService.getPimbyzzjlmxByEntities(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdtos)),'ehr-PIMBYZZJLMX-Update')")
    @ApiOperation(value = "根据B/Y类员工转正申请批量更新B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请批量更新B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody List<PIMBYZZJLMXDTO> pimbyzzjlmxdtos) {
        List<PIMBYZZJLMX> domainlist=pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdtos);
        for(PIMBYZZJLMX domain:domainlist){
            domain.setPimbyygzzsqid(pimbyygzzsq_id);
        }
        pimbyzzjlmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdto),'ehr-PIMBYZZJLMX-Create')")
    @ApiOperation(value = "根据B/Y类员工转正申请建立B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请建立B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> createByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
		pimbyzzjlmxService.create(domain);
        PIMBYZZJLMXDTO dto = pimbyzzjlmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdtos),'ehr-PIMBYZZJLMX-Create')")
    @ApiOperation(value = "根据B/Y类员工转正申请批量建立B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请批量建立B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/batch")
    public ResponseEntity<Boolean> createBatchByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody List<PIMBYZZJLMXDTO> pimbyzzjlmxdtos) {
        List<PIMBYZZJLMX> domainlist=pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdtos);
        for(PIMBYZZJLMX domain:domainlist){
            domain.setPimbyygzzsqid(pimbyygzzsq_id);
        }
        pimbyzzjlmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-JZBSHQR-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/jzbshqr")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> jZBSHQRByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.jZBSHQR(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-GSDSZSPBTG-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/gsdszspbtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> gSDSZSPBTGByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.gSDSZSPBTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-GSCSBTG-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/gscsbtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> gSCSBTGByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.gSCSBTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-JSPBTG-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/jspbtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> jSPBTGByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.jSPBTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdto),'ehr-PIMBYZZJLMX-Save')")
    @ApiOperation(value = "根据B/Y类员工转正申请保存B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请保存B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/save")
    public ResponseEntity<Boolean> saveByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdtos),'ehr-PIMBYZZJLMX-Save')")
    @ApiOperation(value = "根据B/Y类员工转正申请批量保存B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请批量保存B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody List<PIMBYZZJLMXDTO> pimbyzzjlmxdtos) {
        List<PIMBYZZJLMX> domainlist=pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdtos);
        for(PIMBYZZJLMX domain:domainlist){
             domain.setPimbyygzzsqid(pimbyygzzsq_id);
        }
        pimbyzzjlmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-GSCS-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/gscs")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> gSCSByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.gSCS(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @ApiOperation(value = "根据B/Y类员工转正申请检查B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请检查B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxService.checkKey(pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-UpdatePeopleNum-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/updatepeoplenum")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> updatePeopleNumByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.updatePeopleNum(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-JZBSPQR-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/jzbspqr")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> jZBSPQRByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.jZBSPQR(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-ZZWSHDS-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请获取转正未审核", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请获取转正未审核")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/fetchzzwshds")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchPIMBYZZJLMXZZWSHDSByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id,PIMBYZZJLMXSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchZZWSHDS(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-ZZWSHDS-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请查询转正未审核", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请查询转正未审核")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/searchzzwshds")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchPIMBYZZJLMXZZWSHDSByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PIMBYZZJLMXSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchZZWSHDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-UnApproved-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请获取待公司初审", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请获取待公司初审")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/fetchunapproved")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchPIMBYZZJLMXUnApprovedByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id,PIMBYZZJLMXSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchUnApproved(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-UnApproved-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请查询待公司初审", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请查询待公司初审")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/searchunapproved")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchPIMBYZZJLMXUnApprovedByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PIMBYZZJLMXSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchUnApproved(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DDJZBSH-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请获取待局总部审核", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请获取待局总部审核")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/fetchddjzbsh")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchPIMBYZZJLMXDDJZBSHByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id,PIMBYZZJLMXSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDDJZBSH(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DDJZBSH-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请查询待局总部审核", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请查询待局总部审核")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/searchddjzbsh")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchPIMBYZZJLMXDDJZBSHByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PIMBYZZJLMXSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDDJZBSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-BYLZZJL-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请获取B/Y类员工转正记录", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请获取B/Y类员工转正记录")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/fetchbylzzjl")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchPIMBYZZJLMXBYLZZJLByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id,PIMBYZZJLMXSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchBYLZZJL(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-BYLZZJL-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请查询B/Y类员工转正记录", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请查询B/Y类员工转正记录")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/searchbylzzjl")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchPIMBYZZJLMXBYLZZJLByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PIMBYZZJLMXSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchBYLZZJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DGSDSZSH-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请获取待公司董事长审批", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请获取待公司董事长审批")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/fetchdgsdszsh")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchPIMBYZZJLMXDGSDSZSHByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id,PIMBYZZJLMXSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDGSDSZSH(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DGSDSZSH-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请查询待公司董事长审批", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请查询待公司董事长审批")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/searchdgsdszsh")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchPIMBYZZJLMXDGSDSZSHByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PIMBYZZJLMXSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDGSDSZSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-HTRY-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请获取回退人员", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请获取回退人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/fetchhtry")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchPIMBYZZJLMXHTRYByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id,PIMBYZZJLMXSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchHTRY(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-HTRY-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请查询回退人员", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请查询回退人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/searchhtry")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchPIMBYZZJLMXHTRYByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PIMBYZZJLMXSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchHTRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DJZBSP-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请获取待局总部审批", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请获取待局总部审批")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/fetchdjzbsp")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchPIMBYZZJLMXDJZBSPByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id,PIMBYZZJLMXSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDJZBSP(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DJZBSP-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请查询待局总部审批", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请查询待局总部审批")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/searchdjzbsp")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchPIMBYZZJLMXDJZBSPByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PIMBYZZJLMXSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDJZBSP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DSB-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请获取待上报", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请获取待上报")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/fetchdsb")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchPIMBYZZJLMXDSBByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id,PIMBYZZJLMXSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDSB(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DSB-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请查询待上报", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请查询待上报")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/searchdsb")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchPIMBYZZJLMXDSBByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PIMBYZZJLMXSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDSB(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-FinishYGBH-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请获取已变更员工编号名单", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请获取已变更员工编号名单")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/fetchfinishygbh")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchPIMBYZZJLMXFinishYGBHByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id,PIMBYZZJLMXSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchFinishYGBH(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-FinishYGBH-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请查询已变更员工编号名单", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请查询已变更员工编号名单")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/searchfinishygbh")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchPIMBYZZJLMXFinishYGBHByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PIMBYZZJLMXSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchFinishYGBH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DJZBSH-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请获取待局总部初审", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请获取待局总部初审")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/fetchdjzbsh")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchPIMBYZZJLMXDJZBSHByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id,PIMBYZZJLMXSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDJZBSH(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DJZBSH-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请查询待局总部初审", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请查询待局总部初审")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/searchdjzbsh")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchPIMBYZZJLMXDJZBSHByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PIMBYZZJLMXSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDJZBSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-Default-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请获取DEFAULT", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/fetchdefault")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchPIMBYZZJLMXDefaultByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id,PIMBYZZJLMXSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDefault(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-Default-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请查询DEFAULT", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/searchdefault")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchPIMBYZZJLMXDefaultByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PIMBYZZJLMXSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-SHTG-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/shtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> sHTGByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.sHTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PostAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(returnObject.body),'ehr-PIMBYZZJLMX-Get')")
    @ApiOperation(value = "根据人员信息获取B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息获取B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}")
    public ResponseEntity<PIMBYZZJLMXDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id) {
        PIMBYZZJLMX domain = pimbyzzjlmxService.get(pimbyzzjlmx_id);
        PIMBYZZJLMXDTO dto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-ReturnYPZ-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/returnypz")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> returnYPZByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.returnYPZ(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-JSPTG-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/jsptg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> jSPTGByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.jSPTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-FillPersonInfo-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> fillPersonInfoByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.fillPersonInfo(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @ApiOperation(value = "根据人员信息获取B/Y类员工转正记录引用明细草稿", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息获取B/Y类员工转正记录引用明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/getdraft")
    public ResponseEntity<PIMBYZZJLMXDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PIMBYZZJLMX domain = new PIMBYZZJLMX();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxMapping.toDto(pimbyzzjlmxService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-JSHTG-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/jshtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> jSHTGByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.jSHTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-JSHBTG-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/jshbtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> jSHBTGByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.jSHBTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-Ensure-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/ensure")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> ensureByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.ensure(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-SHBTG-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/shbtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> sHBTGByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.sHBTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxService.get(#pimbyzzjlmx_id),'ehr-PIMBYZZJLMX-Remove')")
    @ApiOperation(value = "根据人员信息删除B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息删除B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxService.remove(pimbyzzjlmx_id));
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxService.getPimbyzzjlmxByIds(#ids),'ehr-PIMBYZZJLMX-Remove')")
    @ApiOperation(value = "根据人员信息批量删除B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息批量删除B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimbyzzjlmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-GSDSZSP-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/gsdszsp")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> gSDSZSPByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.gSDSZSP(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-ZZCZ-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/zzcz")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> zZCZByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.zZCZ(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DSB-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/dsb")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> dSBByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.dSB(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxService.get(#pimbyzzjlmx_id),'ehr-PIMBYZZJLMX-Update')")
    @ApiOperation(value = "根据人员信息更新B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息更新B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimbyzzjlmxid(pimbyzzjlmx_id);
		pimbyzzjlmxService.update(domain);
        PIMBYZZJLMXDTO dto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxService.getPimbyzzjlmxByEntities(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdtos)),'ehr-PIMBYZZJLMX-Update')")
    @ApiOperation(value = "根据人员信息批量更新B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息批量更新B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMBYZZJLMXDTO> pimbyzzjlmxdtos) {
        List<PIMBYZZJLMX> domainlist=pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdtos);
        for(PIMBYZZJLMX domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimbyzzjlmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdto),'ehr-PIMBYZZJLMX-Create')")
    @ApiOperation(value = "根据人员信息建立B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息建立B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
		pimbyzzjlmxService.create(domain);
        PIMBYZZJLMXDTO dto = pimbyzzjlmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdtos),'ehr-PIMBYZZJLMX-Create')")
    @ApiOperation(value = "根据人员信息批量建立B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息批量建立B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMBYZZJLMXDTO> pimbyzzjlmxdtos) {
        List<PIMBYZZJLMX> domainlist=pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdtos);
        for(PIMBYZZJLMX domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimbyzzjlmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-JZBSHQR-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/jzbshqr")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> jZBSHQRByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.jZBSHQR(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-GSDSZSPBTG-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/gsdszspbtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> gSDSZSPBTGByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.gSDSZSPBTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-GSCSBTG-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/gscsbtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> gSCSBTGByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.gSCSBTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-JSPBTG-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/jspbtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> jSPBTGByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.jSPBTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdto),'ehr-PIMBYZZJLMX-Save')")
    @ApiOperation(value = "根据人员信息保存B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息保存B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdtos),'ehr-PIMBYZZJLMX-Save')")
    @ApiOperation(value = "根据人员信息批量保存B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息批量保存B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PIMBYZZJLMXDTO> pimbyzzjlmxdtos) {
        List<PIMBYZZJLMX> domainlist=pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdtos);
        for(PIMBYZZJLMX domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimbyzzjlmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-GSCS-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/gscs")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> gSCSByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.gSCS(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @ApiOperation(value = "根据人员信息检查B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息检查B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxService.checkKey(pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-UpdatePeopleNum-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/updatepeoplenum")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> updatePeopleNumByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.updatePeopleNum(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-JZBSPQR-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/jzbspqr")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> jZBSPQRByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.jZBSPQR(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-ZZWSHDS-all')")
	@ApiOperation(value = "根据人员信息获取转正未审核", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息获取转正未审核")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/fetchzzwshds")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchPIMBYZZJLMXZZWSHDSByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMBYZZJLMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchZZWSHDS(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-ZZWSHDS-all')")
	@ApiOperation(value = "根据人员信息查询转正未审核", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息查询转正未审核")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/searchzzwshds")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchPIMBYZZJLMXZZWSHDSByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMBYZZJLMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchZZWSHDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-UnApproved-all')")
	@ApiOperation(value = "根据人员信息获取待公司初审", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息获取待公司初审")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/fetchunapproved")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchPIMBYZZJLMXUnApprovedByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMBYZZJLMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchUnApproved(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-UnApproved-all')")
	@ApiOperation(value = "根据人员信息查询待公司初审", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息查询待公司初审")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/searchunapproved")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchPIMBYZZJLMXUnApprovedByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMBYZZJLMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchUnApproved(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DDJZBSH-all')")
	@ApiOperation(value = "根据人员信息获取待局总部审核", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息获取待局总部审核")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/fetchddjzbsh")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchPIMBYZZJLMXDDJZBSHByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMBYZZJLMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDDJZBSH(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DDJZBSH-all')")
	@ApiOperation(value = "根据人员信息查询待局总部审核", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息查询待局总部审核")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/searchddjzbsh")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchPIMBYZZJLMXDDJZBSHByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMBYZZJLMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDDJZBSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-BYLZZJL-all')")
	@ApiOperation(value = "根据人员信息获取B/Y类员工转正记录", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息获取B/Y类员工转正记录")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/fetchbylzzjl")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchPIMBYZZJLMXBYLZZJLByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMBYZZJLMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchBYLZZJL(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-BYLZZJL-all')")
	@ApiOperation(value = "根据人员信息查询B/Y类员工转正记录", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息查询B/Y类员工转正记录")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/searchbylzzjl")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchPIMBYZZJLMXBYLZZJLByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMBYZZJLMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchBYLZZJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DGSDSZSH-all')")
	@ApiOperation(value = "根据人员信息获取待公司董事长审批", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息获取待公司董事长审批")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/fetchdgsdszsh")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchPIMBYZZJLMXDGSDSZSHByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMBYZZJLMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDGSDSZSH(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DGSDSZSH-all')")
	@ApiOperation(value = "根据人员信息查询待公司董事长审批", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息查询待公司董事长审批")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/searchdgsdszsh")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchPIMBYZZJLMXDGSDSZSHByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMBYZZJLMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDGSDSZSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-HTRY-all')")
	@ApiOperation(value = "根据人员信息获取回退人员", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息获取回退人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/fetchhtry")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchPIMBYZZJLMXHTRYByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMBYZZJLMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchHTRY(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-HTRY-all')")
	@ApiOperation(value = "根据人员信息查询回退人员", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息查询回退人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/searchhtry")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchPIMBYZZJLMXHTRYByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMBYZZJLMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchHTRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DJZBSP-all')")
	@ApiOperation(value = "根据人员信息获取待局总部审批", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息获取待局总部审批")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/fetchdjzbsp")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchPIMBYZZJLMXDJZBSPByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMBYZZJLMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDJZBSP(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DJZBSP-all')")
	@ApiOperation(value = "根据人员信息查询待局总部审批", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息查询待局总部审批")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/searchdjzbsp")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchPIMBYZZJLMXDJZBSPByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMBYZZJLMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDJZBSP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DSB-all')")
	@ApiOperation(value = "根据人员信息获取待上报", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息获取待上报")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/fetchdsb")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchPIMBYZZJLMXDSBByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMBYZZJLMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDSB(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DSB-all')")
	@ApiOperation(value = "根据人员信息查询待上报", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息查询待上报")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/searchdsb")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchPIMBYZZJLMXDSBByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMBYZZJLMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDSB(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-FinishYGBH-all')")
	@ApiOperation(value = "根据人员信息获取已变更员工编号名单", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息获取已变更员工编号名单")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/fetchfinishygbh")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchPIMBYZZJLMXFinishYGBHByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMBYZZJLMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchFinishYGBH(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-FinishYGBH-all')")
	@ApiOperation(value = "根据人员信息查询已变更员工编号名单", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息查询已变更员工编号名单")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/searchfinishygbh")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchPIMBYZZJLMXFinishYGBHByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMBYZZJLMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchFinishYGBH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DJZBSH-all')")
	@ApiOperation(value = "根据人员信息获取待局总部初审", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息获取待局总部初审")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/fetchdjzbsh")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchPIMBYZZJLMXDJZBSHByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMBYZZJLMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDJZBSH(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-DJZBSH-all')")
	@ApiOperation(value = "根据人员信息查询待局总部初审", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息查询待局总部初审")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/searchdjzbsh")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchPIMBYZZJLMXDJZBSHByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMBYZZJLMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDJZBSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/fetchdefault")
	public ResponseEntity<List<PIMBYZZJLMXDTO>> fetchPIMBYZZJLMXDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PIMBYZZJLMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDefault(context) ;
        List<PIMBYZZJLMXDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PIMBYZZJLMX-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/searchdefault")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchPIMBYZZJLMXDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PIMBYZZJLMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

