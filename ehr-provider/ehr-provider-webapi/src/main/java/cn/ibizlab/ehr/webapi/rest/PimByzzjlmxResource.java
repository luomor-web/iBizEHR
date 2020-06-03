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
import cn.ibizlab.ehr.core.pim.domain.PimByzzjlmx;
import cn.ibizlab.ehr.core.pim.service.IPimByzzjlmxService;
import cn.ibizlab.ehr.core.pim.filter.PimByzzjlmxSearchContext;

@Slf4j
@Api(tags = {"B/Y类员工转正记录引用明细" })
@RestController("WebApi-pimbyzzjlmx")
@RequestMapping("")
public class PimByzzjlmxResource {

    @Autowired
    public IPimByzzjlmxService pimbyzzjlmxService;

    @Autowired
    @Lazy
    public PimByzzjlmxMapping pimbyzzjlmxMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-SHTG-all')")
    @ApiOperation(value = "局总部初审通过", tags = {"B/Y类员工转正记录引用明细" },  notes = "局总部初审通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/shtg")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> sHTG(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.sHTG(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PostAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(returnObject.body),'ehr-PimByzzjlmx-Get')")
    @ApiOperation(value = "获取B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "获取B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}")
    public ResponseEntity<PimByzzjlmxDTO> get(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id) {
        PimByzzjlmx domain = pimbyzzjlmxService.get(pimbyzzjlmx_id);
        PimByzzjlmxDTO dto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-ReturnYPZ-all')")
    @ApiOperation(value = "失效", tags = {"B/Y类员工转正记录引用明细" },  notes = "失效")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/returnypz")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> returnYPZ(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.returnYPZ(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-JSPTG-all')")
    @ApiOperation(value = "局总部审批通过", tags = {"B/Y类员工转正记录引用明细" },  notes = "局总部审批通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/jsptg")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> jSPTG(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.jSPTG(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-FillPersonInfo-all')")
    @ApiOperation(value = "填充人员信息", tags = {"B/Y类员工转正记录引用明细" },  notes = "填充人员信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> fillPersonInfo(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.fillPersonInfo(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @ApiOperation(value = "获取B/Y类员工转正记录引用明细草稿", tags = {"B/Y类员工转正记录引用明细" },  notes = "获取B/Y类员工转正记录引用明细草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pimbyzzjlmxes/getdraft")
    public ResponseEntity<PimByzzjlmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxMapping.toDto(pimbyzzjlmxService.getDraft(new PimByzzjlmx())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-JSHTG-all')")
    @ApiOperation(value = "局总部审核通过", tags = {"B/Y类员工转正记录引用明细" },  notes = "局总部审核通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/jshtg")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> jSHTG(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.jSHTG(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-JSHBTG-all')")
    @ApiOperation(value = "局总部审核不通过", tags = {"B/Y类员工转正记录引用明细" },  notes = "局总部审核不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/jshbtg")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> jSHBTG(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.jSHBTG(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-Ensure-all')")
    @ApiOperation(value = "确认", tags = {"B/Y类员工转正记录引用明细" },  notes = "确认")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/ensure")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> ensure(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.ensure(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-SHBTG-all')")
    @ApiOperation(value = "局总部初审不通过", tags = {"B/Y类员工转正记录引用明细" },  notes = "局总部初审不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/shbtg")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> sHBTG(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.sHBTG(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxService.get(#pimbyzzjlmx_id),'ehr-PimByzzjlmx-Remove')")
    @ApiOperation(value = "删除B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "删除B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxService.remove(pimbyzzjlmx_id));
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxService.getPimbyzzjlmxByIds(#ids),'ehr-PimByzzjlmx-Remove')")
    @ApiOperation(value = "批量删除B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "批量删除B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimbyzzjlmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimbyzzjlmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-GSDSZSP-all')")
    @ApiOperation(value = "公司董事长审批同意", tags = {"B/Y类员工转正记录引用明细" },  notes = "公司董事长审批同意")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/gsdszsp")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> gSDSZSP(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.gSDSZSP(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-ZZCZ-all')")
    @ApiOperation(value = "转正操作", tags = {"B/Y类员工转正记录引用明细" },  notes = "转正操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/zzcz")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> zZCZ(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.zZCZ(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DSB-all')")
    @ApiOperation(value = "待上报", tags = {"B/Y类员工转正记录引用明细" },  notes = "待上报")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/dsb")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> dSB(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.dSB(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxService.get(#pimbyzzjlmx_id),'ehr-PimByzzjlmx-Update')")
    @ApiOperation(value = "更新B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "更新B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> update(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
		PimByzzjlmx domain  = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain .setPimbyzzjlmxid(pimbyzzjlmx_id);
		pimbyzzjlmxService.update(domain );
		PimByzzjlmxDTO dto = pimbyzzjlmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxService.getPimbyzzjlmxByEntities(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdtos)),'ehr-PimByzzjlmx-Update')")
    @ApiOperation(value = "批量更新B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "批量更新B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbyzzjlmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PimByzzjlmxDTO> pimbyzzjlmxdtos) {
        pimbyzzjlmxService.updateBatch(pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdto),'ehr-PimByzzjlmx-Create')")
    @ApiOperation(value = "新建B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "新建B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> create(@RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
		pimbyzzjlmxService.create(domain);
        PimByzzjlmxDTO dto = pimbyzzjlmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdtos),'ehr-PimByzzjlmx-Create')")
    @ApiOperation(value = "批量新建B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "批量新建B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PimByzzjlmxDTO> pimbyzzjlmxdtos) {
        pimbyzzjlmxService.createBatch(pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-JZBSHQR-all')")
    @ApiOperation(value = "确认", tags = {"B/Y类员工转正记录引用明细" },  notes = "确认")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/jzbshqr")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> jZBSHQR(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.jZBSHQR(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-GSDSZSPBTG-all')")
    @ApiOperation(value = "公司董事长审批拒绝", tags = {"B/Y类员工转正记录引用明细" },  notes = "公司董事长审批拒绝")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/gsdszspbtg")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> gSDSZSPBTG(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.gSDSZSPBTG(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-GSCSBTG-all')")
    @ApiOperation(value = "公司初审拒绝", tags = {"B/Y类员工转正记录引用明细" },  notes = "公司初审拒绝")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/gscsbtg")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> gSCSBTG(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.gSCSBTG(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-JSPBTG-all')")
    @ApiOperation(value = "局总部审批不通过", tags = {"B/Y类员工转正记录引用明细" },  notes = "局总部审批不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/jspbtg")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> jSPBTG(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.jSPBTG(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdto),'ehr-PimByzzjlmx-Save')")
    @ApiOperation(value = "保存B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "保存B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxService.save(pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto)));
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdtos),'ehr-PimByzzjlmx-Save')")
    @ApiOperation(value = "批量保存B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "批量保存B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PimByzzjlmxDTO> pimbyzzjlmxdtos) {
        pimbyzzjlmxService.saveBatch(pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-GSCS-all')")
    @ApiOperation(value = "公司初审同意", tags = {"B/Y类员工转正记录引用明细" },  notes = "公司初审同意")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/gscs")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> gSCS(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.gSCS(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @ApiOperation(value = "检查B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "检查B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxService.checkKey(pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-UpdatePeopleNum-all')")
    @ApiOperation(value = "刷新人数", tags = {"B/Y类员工转正记录引用明细" },  notes = "刷新人数")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/updatepeoplenum")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> updatePeopleNum(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.updatePeopleNum(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-JZBSPQR-all')")
    @ApiOperation(value = "确认", tags = {"B/Y类员工转正记录引用明细" },  notes = "确认")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/jzbspqr")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> jZBSPQR(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx.setPimbyzzjlmxid(pimbyzzjlmx_id);
        pimbyzzjlmx = pimbyzzjlmxService.jZBSPQR(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-ZZWSHDS-all')")
	@ApiOperation(value = "获取转正未审核", tags = {"B/Y类员工转正记录引用明细" } ,notes = "获取转正未审核")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyzzjlmxes/fetchzzwshds")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchZZWSHDS(PimByzzjlmxSearchContext context) {
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchZZWSHDS(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-ZZWSHDS-all')")
	@ApiOperation(value = "查询转正未审核", tags = {"B/Y类员工转正记录引用明细" } ,notes = "查询转正未审核")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchzzwshds")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchZZWSHDS(@RequestBody PimByzzjlmxSearchContext context) {
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchZZWSHDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-UnApproved-all')")
	@ApiOperation(value = "获取待公司初审", tags = {"B/Y类员工转正记录引用明细" } ,notes = "获取待公司初审")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyzzjlmxes/fetchunapproved")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchUnApproved(PimByzzjlmxSearchContext context) {
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchUnApproved(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-UnApproved-all')")
	@ApiOperation(value = "查询待公司初审", tags = {"B/Y类员工转正记录引用明细" } ,notes = "查询待公司初审")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchunapproved")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchUnApproved(@RequestBody PimByzzjlmxSearchContext context) {
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchUnApproved(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DDJZBSH-all')")
	@ApiOperation(value = "获取待局总部审核", tags = {"B/Y类员工转正记录引用明细" } ,notes = "获取待局总部审核")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyzzjlmxes/fetchddjzbsh")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchDDJZBSH(PimByzzjlmxSearchContext context) {
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDDJZBSH(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DDJZBSH-all')")
	@ApiOperation(value = "查询待局总部审核", tags = {"B/Y类员工转正记录引用明细" } ,notes = "查询待局总部审核")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchddjzbsh")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchDDJZBSH(@RequestBody PimByzzjlmxSearchContext context) {
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDDJZBSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-BYLZZJL-all')")
	@ApiOperation(value = "获取B/Y类员工转正记录", tags = {"B/Y类员工转正记录引用明细" } ,notes = "获取B/Y类员工转正记录")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyzzjlmxes/fetchbylzzjl")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchBYLZZJL(PimByzzjlmxSearchContext context) {
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchBYLZZJL(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-BYLZZJL-all')")
	@ApiOperation(value = "查询B/Y类员工转正记录", tags = {"B/Y类员工转正记录引用明细" } ,notes = "查询B/Y类员工转正记录")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchbylzzjl")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchBYLZZJL(@RequestBody PimByzzjlmxSearchContext context) {
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchBYLZZJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DGSDSZSH-all')")
	@ApiOperation(value = "获取待公司董事长审批", tags = {"B/Y类员工转正记录引用明细" } ,notes = "获取待公司董事长审批")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyzzjlmxes/fetchdgsdszsh")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchDGSDSZSH(PimByzzjlmxSearchContext context) {
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDGSDSZSH(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DGSDSZSH-all')")
	@ApiOperation(value = "查询待公司董事长审批", tags = {"B/Y类员工转正记录引用明细" } ,notes = "查询待公司董事长审批")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchdgsdszsh")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchDGSDSZSH(@RequestBody PimByzzjlmxSearchContext context) {
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDGSDSZSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-HTRY-all')")
	@ApiOperation(value = "获取回退人员", tags = {"B/Y类员工转正记录引用明细" } ,notes = "获取回退人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyzzjlmxes/fetchhtry")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchHTRY(PimByzzjlmxSearchContext context) {
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchHTRY(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-HTRY-all')")
	@ApiOperation(value = "查询回退人员", tags = {"B/Y类员工转正记录引用明细" } ,notes = "查询回退人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchhtry")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchHTRY(@RequestBody PimByzzjlmxSearchContext context) {
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchHTRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DJZBSP-all')")
	@ApiOperation(value = "获取待局总部审批", tags = {"B/Y类员工转正记录引用明细" } ,notes = "获取待局总部审批")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyzzjlmxes/fetchdjzbsp")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchDJZBSP(PimByzzjlmxSearchContext context) {
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDJZBSP(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DJZBSP-all')")
	@ApiOperation(value = "查询待局总部审批", tags = {"B/Y类员工转正记录引用明细" } ,notes = "查询待局总部审批")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchdjzbsp")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchDJZBSP(@RequestBody PimByzzjlmxSearchContext context) {
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDJZBSP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DSB-all')")
	@ApiOperation(value = "获取待上报", tags = {"B/Y类员工转正记录引用明细" } ,notes = "获取待上报")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyzzjlmxes/fetchdsb")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchDSB(PimByzzjlmxSearchContext context) {
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDSB(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DSB-all')")
	@ApiOperation(value = "查询待上报", tags = {"B/Y类员工转正记录引用明细" } ,notes = "查询待上报")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchdsb")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchDSB(@RequestBody PimByzzjlmxSearchContext context) {
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDSB(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-FinishYGBH-all')")
	@ApiOperation(value = "获取已变更员工编号名单", tags = {"B/Y类员工转正记录引用明细" } ,notes = "获取已变更员工编号名单")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyzzjlmxes/fetchfinishygbh")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchFinishYGBH(PimByzzjlmxSearchContext context) {
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchFinishYGBH(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-FinishYGBH-all')")
	@ApiOperation(value = "查询已变更员工编号名单", tags = {"B/Y类员工转正记录引用明细" } ,notes = "查询已变更员工编号名单")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchfinishygbh")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchFinishYGBH(@RequestBody PimByzzjlmxSearchContext context) {
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchFinishYGBH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DJZBSH-all')")
	@ApiOperation(value = "获取待局总部初审", tags = {"B/Y类员工转正记录引用明细" } ,notes = "获取待局总部初审")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyzzjlmxes/fetchdjzbsh")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchDJZBSH(PimByzzjlmxSearchContext context) {
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDJZBSH(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DJZBSH-all')")
	@ApiOperation(value = "查询待局总部初审", tags = {"B/Y类员工转正记录引用明细" } ,notes = "查询待局总部初审")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchdjzbsh")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchDJZBSH(@RequestBody PimByzzjlmxSearchContext context) {
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDJZBSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"B/Y类员工转正记录引用明细" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyzzjlmxes/fetchdefault")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchDefault(PimByzzjlmxSearchContext context) {
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDefault(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"B/Y类员工转正记录引用明细" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchdefault")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchDefault(@RequestBody PimByzzjlmxSearchContext context) {
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-SHTG-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/shtg")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> sHTGByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.sHTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PostAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(returnObject.body),'ehr-PimByzzjlmx-Get')")
    @ApiOperation(value = "根据B/Y类员工转正申请获取B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请获取B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}")
    public ResponseEntity<PimByzzjlmxDTO> getByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id) {
        PimByzzjlmx domain = pimbyzzjlmxService.get(pimbyzzjlmx_id);
        PimByzzjlmxDTO dto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-ReturnYPZ-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/returnypz")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> returnYPZByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.returnYPZ(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-JSPTG-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/jsptg")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> jSPTGByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.jSPTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-FillPersonInfo-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> fillPersonInfoByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.fillPersonInfo(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @ApiOperation(value = "根据B/Y类员工转正申请获取B/Y类员工转正记录引用明细草稿", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请获取B/Y类员工转正记录引用明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/getdraft")
    public ResponseEntity<PimByzzjlmxDTO> getDraftByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id) {
        PimByzzjlmx domain = new PimByzzjlmx();
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxMapping.toDto(pimbyzzjlmxService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-JSHTG-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/jshtg")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> jSHTGByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.jSHTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-JSHBTG-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/jshbtg")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> jSHBTGByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.jSHBTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-Ensure-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/ensure")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> ensureByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.ensure(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-SHBTG-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/shbtg")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> sHBTGByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.sHBTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxService.get(#pimbyzzjlmx_id),'ehr-PimByzzjlmx-Remove')")
    @ApiOperation(value = "根据B/Y类员工转正申请删除B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请删除B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxService.remove(pimbyzzjlmx_id));
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxService.getPimbyzzjlmxByIds(#ids),'ehr-PimByzzjlmx-Remove')")
    @ApiOperation(value = "根据B/Y类员工转正申请批量删除B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请批量删除B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPimByygzzsq(@RequestBody List<String> ids) {
        pimbyzzjlmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-GSDSZSP-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/gsdszsp")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> gSDSZSPByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.gSDSZSP(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-ZZCZ-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/zzcz")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> zZCZByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.zZCZ(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DSB-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/dsb")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> dSBByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.dSB(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxService.get(#pimbyzzjlmx_id),'ehr-PimByzzjlmx-Update')")
    @ApiOperation(value = "根据B/Y类员工转正申请更新B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请更新B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> updateByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain.setPimbyzzjlmxid(pimbyzzjlmx_id);
		pimbyzzjlmxService.update(domain);
        PimByzzjlmxDTO dto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxService.getPimbyzzjlmxByEntities(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdtos)),'ehr-PimByzzjlmx-Update')")
    @ApiOperation(value = "根据B/Y类员工转正申请批量更新B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请批量更新B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody List<PimByzzjlmxDTO> pimbyzzjlmxdtos) {
        List<PimByzzjlmx> domainlist=pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdtos);
        for(PimByzzjlmx domain:domainlist){
            domain.setPimbyygzzsqid(pimbyygzzsq_id);
        }
        pimbyzzjlmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdto),'ehr-PimByzzjlmx-Create')")
    @ApiOperation(value = "根据B/Y类员工转正申请建立B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请建立B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> createByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
		pimbyzzjlmxService.create(domain);
        PimByzzjlmxDTO dto = pimbyzzjlmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdtos),'ehr-PimByzzjlmx-Create')")
    @ApiOperation(value = "根据B/Y类员工转正申请批量建立B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请批量建立B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/batch")
    public ResponseEntity<Boolean> createBatchByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody List<PimByzzjlmxDTO> pimbyzzjlmxdtos) {
        List<PimByzzjlmx> domainlist=pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdtos);
        for(PimByzzjlmx domain:domainlist){
            domain.setPimbyygzzsqid(pimbyygzzsq_id);
        }
        pimbyzzjlmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-JZBSHQR-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/jzbshqr")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> jZBSHQRByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.jZBSHQR(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-GSDSZSPBTG-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/gsdszspbtg")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> gSDSZSPBTGByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.gSDSZSPBTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-GSCSBTG-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/gscsbtg")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> gSCSBTGByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.gSCSBTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-JSPBTG-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/jspbtg")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> jSPBTGByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.jSPBTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdto),'ehr-PimByzzjlmx-Save')")
    @ApiOperation(value = "根据B/Y类员工转正申请保存B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请保存B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/save")
    public ResponseEntity<Boolean> saveByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdtos),'ehr-PimByzzjlmx-Save')")
    @ApiOperation(value = "根据B/Y类员工转正申请批量保存B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请批量保存B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody List<PimByzzjlmxDTO> pimbyzzjlmxdtos) {
        List<PimByzzjlmx> domainlist=pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdtos);
        for(PimByzzjlmx domain:domainlist){
             domain.setPimbyygzzsqid(pimbyygzzsq_id);
        }
        pimbyzzjlmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-GSCS-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/gscs")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> gSCSByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.gSCS(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @ApiOperation(value = "根据B/Y类员工转正申请检查B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请检查B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxService.checkKey(pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-UpdatePeopleNum-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/updatepeoplenum")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> updatePeopleNumByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.updatePeopleNum(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-JZBSPQR-all')")
    @ApiOperation(value = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据B/Y类员工转正申请B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/jzbspqr")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> jZBSPQRByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyygzzsqid(pimbyygzzsq_id);
        domain = pimbyzzjlmxService.jZBSPQR(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-ZZWSHDS-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请获取转正未审核", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请获取转正未审核")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/fetchzzwshds")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchPimByzzjlmxZZWSHDSByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id,PimByzzjlmxSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchZZWSHDS(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-ZZWSHDS-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请查询转正未审核", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请查询转正未审核")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/searchzzwshds")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchPimByzzjlmxZZWSHDSByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PimByzzjlmxSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchZZWSHDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-UnApproved-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请获取待公司初审", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请获取待公司初审")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/fetchunapproved")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchPimByzzjlmxUnApprovedByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id,PimByzzjlmxSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchUnApproved(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-UnApproved-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请查询待公司初审", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请查询待公司初审")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/searchunapproved")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchPimByzzjlmxUnApprovedByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PimByzzjlmxSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchUnApproved(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DDJZBSH-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请获取待局总部审核", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请获取待局总部审核")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/fetchddjzbsh")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchPimByzzjlmxDDJZBSHByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id,PimByzzjlmxSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDDJZBSH(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DDJZBSH-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请查询待局总部审核", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请查询待局总部审核")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/searchddjzbsh")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchPimByzzjlmxDDJZBSHByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PimByzzjlmxSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDDJZBSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-BYLZZJL-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请获取B/Y类员工转正记录", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请获取B/Y类员工转正记录")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/fetchbylzzjl")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchPimByzzjlmxBYLZZJLByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id,PimByzzjlmxSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchBYLZZJL(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-BYLZZJL-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请查询B/Y类员工转正记录", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请查询B/Y类员工转正记录")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/searchbylzzjl")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchPimByzzjlmxBYLZZJLByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PimByzzjlmxSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchBYLZZJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DGSDSZSH-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请获取待公司董事长审批", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请获取待公司董事长审批")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/fetchdgsdszsh")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchPimByzzjlmxDGSDSZSHByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id,PimByzzjlmxSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDGSDSZSH(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DGSDSZSH-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请查询待公司董事长审批", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请查询待公司董事长审批")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/searchdgsdszsh")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchPimByzzjlmxDGSDSZSHByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PimByzzjlmxSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDGSDSZSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-HTRY-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请获取回退人员", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请获取回退人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/fetchhtry")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchPimByzzjlmxHTRYByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id,PimByzzjlmxSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchHTRY(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-HTRY-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请查询回退人员", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请查询回退人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/searchhtry")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchPimByzzjlmxHTRYByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PimByzzjlmxSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchHTRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DJZBSP-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请获取待局总部审批", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请获取待局总部审批")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/fetchdjzbsp")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchPimByzzjlmxDJZBSPByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id,PimByzzjlmxSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDJZBSP(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DJZBSP-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请查询待局总部审批", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请查询待局总部审批")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/searchdjzbsp")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchPimByzzjlmxDJZBSPByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PimByzzjlmxSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDJZBSP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DSB-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请获取待上报", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请获取待上报")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/fetchdsb")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchPimByzzjlmxDSBByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id,PimByzzjlmxSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDSB(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DSB-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请查询待上报", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请查询待上报")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/searchdsb")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchPimByzzjlmxDSBByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PimByzzjlmxSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDSB(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-FinishYGBH-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请获取已变更员工编号名单", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请获取已变更员工编号名单")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/fetchfinishygbh")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchPimByzzjlmxFinishYGBHByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id,PimByzzjlmxSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchFinishYGBH(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-FinishYGBH-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请查询已变更员工编号名单", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请查询已变更员工编号名单")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/searchfinishygbh")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchPimByzzjlmxFinishYGBHByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PimByzzjlmxSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchFinishYGBH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DJZBSH-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请获取待局总部初审", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请获取待局总部初审")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/fetchdjzbsh")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchPimByzzjlmxDJZBSHByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id,PimByzzjlmxSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDJZBSH(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DJZBSH-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请查询待局总部初审", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请查询待局总部初审")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/searchdjzbsh")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchPimByzzjlmxDJZBSHByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PimByzzjlmxSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDJZBSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-Default-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请获取DEFAULT", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/fetchdefault")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchPimByzzjlmxDefaultByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id,PimByzzjlmxSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDefault(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-Default-all')")
	@ApiOperation(value = "根据B/Y类员工转正申请查询DEFAULT", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据B/Y类员工转正申请查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyygzzsqs/{pimbyygzzsq_id}/pimbyzzjlmxes/searchdefault")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchPimByzzjlmxDefaultByPimByygzzsq(@PathVariable("pimbyygzzsq_id") String pimbyygzzsq_id, @RequestBody PimByzzjlmxSearchContext context) {
        context.setN_pimbyygzzsqid_eq(pimbyygzzsq_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-SHTG-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/shtg")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> sHTGByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.sHTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PostAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(returnObject.body),'ehr-PimByzzjlmx-Get')")
    @ApiOperation(value = "根据人员信息获取B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息获取B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}")
    public ResponseEntity<PimByzzjlmxDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id) {
        PimByzzjlmx domain = pimbyzzjlmxService.get(pimbyzzjlmx_id);
        PimByzzjlmxDTO dto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-ReturnYPZ-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/returnypz")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> returnYPZByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.returnYPZ(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-JSPTG-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/jsptg")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> jSPTGByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.jSPTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-FillPersonInfo-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> fillPersonInfoByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.fillPersonInfo(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @ApiOperation(value = "根据人员信息获取B/Y类员工转正记录引用明细草稿", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息获取B/Y类员工转正记录引用明细草稿")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/getdraft")
    public ResponseEntity<PimByzzjlmxDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PimByzzjlmx domain = new PimByzzjlmx();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxMapping.toDto(pimbyzzjlmxService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-JSHTG-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/jshtg")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> jSHTGByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.jSHTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-JSHBTG-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/jshbtg")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> jSHBTGByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.jSHBTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-Ensure-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/ensure")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> ensureByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.ensure(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-SHBTG-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/shbtg")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> sHBTGByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.sHBTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxService.get(#pimbyzzjlmx_id),'ehr-PimByzzjlmx-Remove')")
    @ApiOperation(value = "根据人员信息删除B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息删除B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxService.remove(pimbyzzjlmx_id));
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxService.getPimbyzzjlmxByIds(#ids),'ehr-PimByzzjlmx-Remove')")
    @ApiOperation(value = "根据人员信息批量删除B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息批量删除B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pimbyzzjlmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-GSDSZSP-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/gsdszsp")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> gSDSZSPByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.gSDSZSP(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-ZZCZ-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/zzcz")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> zZCZByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.zZCZ(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DSB-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/dsb")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> dSBByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.dSB(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxService.get(#pimbyzzjlmx_id),'ehr-PimByzzjlmx-Update')")
    @ApiOperation(value = "根据人员信息更新B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息更新B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPimbyzzjlmxid(pimbyzzjlmx_id);
		pimbyzzjlmxService.update(domain);
        PimByzzjlmxDTO dto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxService.getPimbyzzjlmxByEntities(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdtos)),'ehr-PimByzzjlmx-Update')")
    @ApiOperation(value = "根据人员信息批量更新B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息批量更新B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimByzzjlmxDTO> pimbyzzjlmxdtos) {
        List<PimByzzjlmx> domainlist=pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdtos);
        for(PimByzzjlmx domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimbyzzjlmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdto),'ehr-PimByzzjlmx-Create')")
    @ApiOperation(value = "根据人员信息建立B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息建立B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
		pimbyzzjlmxService.create(domain);
        PimByzzjlmxDTO dto = pimbyzzjlmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdtos),'ehr-PimByzzjlmx-Create')")
    @ApiOperation(value = "根据人员信息批量建立B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息批量建立B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimByzzjlmxDTO> pimbyzzjlmxdtos) {
        List<PimByzzjlmx> domainlist=pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdtos);
        for(PimByzzjlmx domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pimbyzzjlmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-JZBSHQR-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/jzbshqr")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> jZBSHQRByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.jZBSHQR(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-GSDSZSPBTG-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/gsdszspbtg")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> gSDSZSPBTGByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.gSDSZSPBTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-GSCSBTG-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/gscsbtg")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> gSCSBTGByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.gSCSBTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-JSPBTG-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/jspbtg")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> jSPBTGByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.jSPBTG(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdto),'ehr-PimByzzjlmx-Save')")
    @ApiOperation(value = "根据人员信息保存B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息保存B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pimbyzzjlmxMapping.toDomain(#pimbyzzjlmxdtos),'ehr-PimByzzjlmx-Save')")
    @ApiOperation(value = "根据人员信息批量保存B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息批量保存B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PimByzzjlmxDTO> pimbyzzjlmxdtos) {
        List<PimByzzjlmx> domainlist=pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdtos);
        for(PimByzzjlmx domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pimbyzzjlmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-GSCS-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/gscs")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> gSCSByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.gSCS(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @ApiOperation(value = "根据人员信息检查B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息检查B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxService.checkKey(pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-UpdatePeopleNum-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/updatepeoplenum")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> updatePeopleNumByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.updatePeopleNum(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-JZBSPQR-all')")
    @ApiOperation(value = "根据人员信息B/Y类员工转正记录引用明细", tags = {"B/Y类员工转正记录引用明细" },  notes = "根据人员信息B/Y类员工转正记录引用明细")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pimbyzzjlmxes/{pimbyzzjlmx_id}/jzbspqr")
    @Transactional
    public ResponseEntity<PimByzzjlmxDTO> jZBSPQRByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PimByzzjlmxDTO pimbyzzjlmxdto) {
        PimByzzjlmx domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pimbyzzjlmxService.jZBSPQR(domain) ;
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-ZZWSHDS-all')")
	@ApiOperation(value = "根据人员信息获取转正未审核", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息获取转正未审核")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/fetchzzwshds")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchPimByzzjlmxZZWSHDSByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimByzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchZZWSHDS(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-ZZWSHDS-all')")
	@ApiOperation(value = "根据人员信息查询转正未审核", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息查询转正未审核")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/searchzzwshds")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchPimByzzjlmxZZWSHDSByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimByzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchZZWSHDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-UnApproved-all')")
	@ApiOperation(value = "根据人员信息获取待公司初审", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息获取待公司初审")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/fetchunapproved")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchPimByzzjlmxUnApprovedByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimByzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchUnApproved(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-UnApproved-all')")
	@ApiOperation(value = "根据人员信息查询待公司初审", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息查询待公司初审")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/searchunapproved")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchPimByzzjlmxUnApprovedByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimByzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchUnApproved(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DDJZBSH-all')")
	@ApiOperation(value = "根据人员信息获取待局总部审核", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息获取待局总部审核")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/fetchddjzbsh")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchPimByzzjlmxDDJZBSHByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimByzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDDJZBSH(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DDJZBSH-all')")
	@ApiOperation(value = "根据人员信息查询待局总部审核", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息查询待局总部审核")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/searchddjzbsh")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchPimByzzjlmxDDJZBSHByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimByzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDDJZBSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-BYLZZJL-all')")
	@ApiOperation(value = "根据人员信息获取B/Y类员工转正记录", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息获取B/Y类员工转正记录")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/fetchbylzzjl")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchPimByzzjlmxBYLZZJLByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimByzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchBYLZZJL(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-BYLZZJL-all')")
	@ApiOperation(value = "根据人员信息查询B/Y类员工转正记录", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息查询B/Y类员工转正记录")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/searchbylzzjl")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchPimByzzjlmxBYLZZJLByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimByzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchBYLZZJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DGSDSZSH-all')")
	@ApiOperation(value = "根据人员信息获取待公司董事长审批", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息获取待公司董事长审批")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/fetchdgsdszsh")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchPimByzzjlmxDGSDSZSHByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimByzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDGSDSZSH(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DGSDSZSH-all')")
	@ApiOperation(value = "根据人员信息查询待公司董事长审批", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息查询待公司董事长审批")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/searchdgsdszsh")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchPimByzzjlmxDGSDSZSHByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimByzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDGSDSZSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-HTRY-all')")
	@ApiOperation(value = "根据人员信息获取回退人员", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息获取回退人员")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/fetchhtry")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchPimByzzjlmxHTRYByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimByzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchHTRY(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-HTRY-all')")
	@ApiOperation(value = "根据人员信息查询回退人员", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息查询回退人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/searchhtry")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchPimByzzjlmxHTRYByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimByzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchHTRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DJZBSP-all')")
	@ApiOperation(value = "根据人员信息获取待局总部审批", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息获取待局总部审批")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/fetchdjzbsp")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchPimByzzjlmxDJZBSPByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimByzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDJZBSP(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DJZBSP-all')")
	@ApiOperation(value = "根据人员信息查询待局总部审批", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息查询待局总部审批")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/searchdjzbsp")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchPimByzzjlmxDJZBSPByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimByzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDJZBSP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DSB-all')")
	@ApiOperation(value = "根据人员信息获取待上报", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息获取待上报")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/fetchdsb")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchPimByzzjlmxDSBByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimByzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDSB(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DSB-all')")
	@ApiOperation(value = "根据人员信息查询待上报", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息查询待上报")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/searchdsb")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchPimByzzjlmxDSBByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimByzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDSB(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-FinishYGBH-all')")
	@ApiOperation(value = "根据人员信息获取已变更员工编号名单", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息获取已变更员工编号名单")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/fetchfinishygbh")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchPimByzzjlmxFinishYGBHByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimByzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchFinishYGBH(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-FinishYGBH-all')")
	@ApiOperation(value = "根据人员信息查询已变更员工编号名单", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息查询已变更员工编号名单")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/searchfinishygbh")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchPimByzzjlmxFinishYGBHByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimByzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchFinishYGBH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DJZBSH-all')")
	@ApiOperation(value = "根据人员信息获取待局总部初审", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息获取待局总部初审")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/fetchdjzbsh")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchPimByzzjlmxDJZBSHByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimByzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDJZBSH(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-DJZBSH-all')")
	@ApiOperation(value = "根据人员信息查询待局总部初审", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息查询待局总部初审")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/searchdjzbsh")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchPimByzzjlmxDJZBSHByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimByzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDJZBSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-Default-all')")
	@ApiOperation(value = "根据人员信息获取DEFAULT", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/fetchdefault")
	public ResponseEntity<List<PimByzzjlmxDTO>> fetchPimByzzjlmxDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PimByzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDefault(context) ;
        List<PimByzzjlmxDTO> list = pimbyzzjlmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PimByzzjlmx-Default-all')")
	@ApiOperation(value = "根据人员信息查询DEFAULT", tags = {"B/Y类员工转正记录引用明细" } ,notes = "根据人员信息查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pimbyzzjlmxes/searchdefault")
	public ResponseEntity<Page<PimByzzjlmxDTO>> searchPimByzzjlmxDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PimByzzjlmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PimByzzjlmx> domains = pimbyzzjlmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

