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
import cn.ibizlab.ehr.core.pcm.domain.PcmBdsqdmx;
import cn.ibizlab.ehr.core.pcm.service.IPcmBdsqdmxService;
import cn.ibizlab.ehr.core.pcm.filter.PcmBdsqdmxSearchContext;

@Slf4j
@Api(tags = {"PcmBdsqdmx" })
@RestController("WebApi-pcmbdsqdmx")
@RequestMapping("")
public class PcmBdsqdmxResource {

    @Autowired
    public IPcmBdsqdmxService pcmbdsqdmxService;

    @Autowired
    @Lazy
    public PcmBdsqdmxMapping pcmbdsqdmxMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-ZJJSDMB-all')")
    @ApiOperation(value = "职级晋升代码表", tags = {"PcmBdsqdmx" },  notes = "职级晋升代码表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/zjjsdmb")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> zJJSDMB(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.zJJSDMB(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-CQBXCZ-all')")
    @ApiOperation(value = "长期病休操作", tags = {"PcmBdsqdmx" },  notes = "长期病休操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/cqbxcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> cQBXCZ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.cQBXCZ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SXJSDMB-all')")
    @ApiOperation(value = "", tags = {"PcmBdsqdmx" },  notes = "")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxjsdmb")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sXJSDMB(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.sXJSDMB(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-PDZJ-all')")
    @ApiOperation(value = "判断职级", tags = {"PcmBdsqdmx" },  notes = "判断职级")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/pdzj")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> pDZJ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.pDZJ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SXJSDMB2-all')")
    @ApiOperation(value = "刷新代码表", tags = {"PcmBdsqdmx" },  notes = "刷新代码表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxjsdmb2")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sXJSDMB2(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.sXJSDMB2(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdto),'ehr-PcmBdsqdmx-Create')")
    @ApiOperation(value = "Create", tags = {"PcmBdsqdmx" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> create(@RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
		pcmbdsqdmxService.create(domain);
        PcmBdsqdmxDTO dto = pcmbdsqdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdtos),'ehr-PcmBdsqdmx-Create')")
    @ApiOperation(value = "createBatch", tags = {"PcmBdsqdmx" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PcmBdsqdmxDTO> pcmbdsqdmxdtos) {
        pcmbdsqdmxService.createBatch(pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-ZZSQ-all')")
    @ApiOperation(value = "自助申请", tags = {"PcmBdsqdmx" },  notes = "自助申请")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/zzsq")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> zZSQ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.zZSQ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SXDMB-all')")
    @ApiOperation(value = "职级降职代码表", tags = {"PcmBdsqdmx" },  notes = "职级降职代码表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxdmb")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sXDMB(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.sXDMB(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-DGCZ-all')")
    @ApiOperation(value = "待岗操作", tags = {"PcmBdsqdmx" },  notes = "待岗操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/dgcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> dGCZ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.dGCZ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SetPersonInfo-all')")
    @ApiOperation(value = "设置人员相关信息", tags = {"PcmBdsqdmx" },  notes = "设置人员相关信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/setpersoninfo")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> setPersonInfo(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.setPersonInfo(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-GZCZ-all')")
    @ApiOperation(value = "挂职操作", tags = {"PcmBdsqdmx" },  notes = "挂职操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/gzcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> gZCZ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.gZCZ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-JPCZ-all')")
    @ApiOperation(value = "解聘操作", tags = {"PcmBdsqdmx" },  notes = "解聘操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/jpcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> jPCZ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.jPCZ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdto),'ehr-PcmBdsqdmx-Save')")
    @ApiOperation(value = "Save", tags = {"PcmBdsqdmx" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.save(pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdtos),'ehr-PcmBdsqdmx-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PcmBdsqdmx" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PcmBdsqdmxDTO> pcmbdsqdmxdtos) {
        pcmbdsqdmxService.saveBatch(pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-LZCZ-all')")
    @ApiOperation(value = "离职操作", tags = {"PcmBdsqdmx" },  notes = "离职操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/lzcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> lZCZ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.lZCZ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-NTCZ-all')")
    @ApiOperation(value = "内退操作", tags = {"PcmBdsqdmx" },  notes = "内退操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/ntcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> nTCZ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.nTCZ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.get(#pcmbdsqdmx_id),'ehr-PcmBdsqdmx-Update')")
    @ApiOperation(value = "Update", tags = {"PcmBdsqdmx" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> update(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
		PcmBdsqdmx domain  = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain .setPcmbdsqdmxid(pcmbdsqdmx_id);
		pcmbdsqdmxService.update(domain );
		PcmBdsqdmxDTO dto = pcmbdsqdmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.getPcmbdsqdmxByEntities(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdtos)),'ehr-PcmBdsqdmx-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PcmBdsqdmx" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PcmBdsqdmxDTO> pcmbdsqdmxdtos) {
        pcmbdsqdmxService.updateBatch(pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(returnObject.body),'ehr-PcmBdsqdmx-Get')")
    @ApiOperation(value = "Get", tags = {"PcmBdsqdmx" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    public ResponseEntity<PcmBdsqdmxDTO> get(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id) {
        PcmBdsqdmx domain = pcmbdsqdmxService.get(pcmbdsqdmx_id);
        PcmBdsqdmxDTO dto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.get(#pcmbdsqdmx_id),'ehr-PcmBdsqdmx-Remove')")
    @ApiOperation(value = "Remove", tags = {"PcmBdsqdmx" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.remove(pcmbdsqdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.getPcmbdsqdmxByIds(#ids),'ehr-PcmBdsqdmx-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PcmBdsqdmx" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmbdsqdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PcmBdsqdmx" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmbdsqdmxes/getdraft")
    public ResponseEntity<PcmBdsqdmxDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxMapping.toDto(pcmbdsqdmxService.getDraft(new PcmBdsqdmx())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SHBTG-all')")
    @ApiOperation(value = "审核不通过", tags = {"PcmBdsqdmx" },  notes = "审核不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/shbtg")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sHBTG(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.sHBTG(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-ZJBDCZ-all')")
    @ApiOperation(value = "职级变动操作", tags = {"PcmBdsqdmx" },  notes = "职级变动操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/zjbdcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> zJBDCZ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.zJBDCZ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @ApiOperation(value = "CheckKey", tags = {"PcmBdsqdmx" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.checkKey(pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-TXCZ-all')")
    @ApiOperation(value = "退休操作", tags = {"PcmBdsqdmx" },  notes = "退休操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/txcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> tXCZ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.tXCZ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-JZJJSDMB-all')")
    @ApiOperation(value = "局职级晋升代码表", tags = {"PcmBdsqdmx" },  notes = "局职级晋升代码表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/jzjjsdmb")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> jZJJSDMB(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.jZJJSDMB(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SHTG-all')")
    @ApiOperation(value = "审核通过", tags = {"PcmBdsqdmx" },  notes = "审核通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/shtg")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sHTG(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.sHTG(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-JPSQMX-all')")
	@ApiOperation(value = "fetch解聘申请（未审核）", tags = {"PcmBdsqdmx" } ,notes = "fetch解聘申请（未审核）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/fetchjpsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchJPSQMX(PcmBdsqdmxSearchContext context) {
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchJPSQMX(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-JPSQMX-all')")
	@ApiOperation(value = "search解聘申请（未审核）", tags = {"PcmBdsqdmx" } ,notes = "search解聘申请（未审核）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqdmxes/searchjpsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchJPSQMX(@RequestBody PcmBdsqdmxSearchContext context) {
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchJPSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-NTSQMX-all')")
	@ApiOperation(value = "fetch内退申请明细（未审核）", tags = {"PcmBdsqdmx" } ,notes = "fetch内退申请明细（未审核）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/fetchntsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchNTSQMX(PcmBdsqdmxSearchContext context) {
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchNTSQMX(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-NTSQMX-all')")
	@ApiOperation(value = "search内退申请明细（未审核）", tags = {"PcmBdsqdmx" } ,notes = "search内退申请明细（未审核）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqdmxes/searchntsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchNTSQMX(@RequestBody PcmBdsqdmxSearchContext context) {
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchNTSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-NTSQMXGR-all')")
	@ApiOperation(value = "fetch内退申请明细（个人）", tags = {"PcmBdsqdmx" } ,notes = "fetch内退申请明细（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/fetchntsqmxgr")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchNTSQMXGR(PcmBdsqdmxSearchContext context) {
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchNTSQMXGR(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-NTSQMXGR-all')")
	@ApiOperation(value = "search内退申请明细（个人）", tags = {"PcmBdsqdmx" } ,notes = "search内退申请明细（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqdmxes/searchntsqmxgr")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchNTSQMXGR(@RequestBody PcmBdsqdmxSearchContext context) {
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchNTSQMXGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-TXSQMX-all')")
	@ApiOperation(value = "fetch退休申请明细（未审核）", tags = {"PcmBdsqdmx" } ,notes = "fetch退休申请明细（未审核）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/fetchtxsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchTXSQMX(PcmBdsqdmxSearchContext context) {
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchTXSQMX(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-TXSQMX-all')")
	@ApiOperation(value = "search退休申请明细（未审核）", tags = {"PcmBdsqdmx" } ,notes = "search退休申请明细（未审核）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqdmxes/searchtxsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchTXSQMX(@RequestBody PcmBdsqdmxSearchContext context) {
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchTXSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-GZSQMX-all')")
	@ApiOperation(value = "fetch挂职申请明细（未审核）", tags = {"PcmBdsqdmx" } ,notes = "fetch挂职申请明细（未审核）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/fetchgzsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchGZSQMX(PcmBdsqdmxSearchContext context) {
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchGZSQMX(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-GZSQMX-all')")
	@ApiOperation(value = "search挂职申请明细（未审核）", tags = {"PcmBdsqdmx" } ,notes = "search挂职申请明细（未审核）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqdmxes/searchgzsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchGZSQMX(@RequestBody PcmBdsqdmxSearchContext context) {
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchGZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-ZJBDSQMX-all')")
	@ApiOperation(value = "fetch职级变动申请明细", tags = {"PcmBdsqdmx" } ,notes = "fetch职级变动申请明细")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/fetchzjbdsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchZJBDSQMX(PcmBdsqdmxSearchContext context) {
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchZJBDSQMX(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-ZJBDSQMX-all')")
	@ApiOperation(value = "search职级变动申请明细", tags = {"PcmBdsqdmx" } ,notes = "search职级变动申请明细")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqdmxes/searchzjbdsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchZJBDSQMX(@RequestBody PcmBdsqdmxSearchContext context) {
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchZJBDSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-DGSQMX-all')")
	@ApiOperation(value = "fetch待岗申请明细", tags = {"PcmBdsqdmx" } ,notes = "fetch待岗申请明细")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/fetchdgsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchDGSQMX(PcmBdsqdmxSearchContext context) {
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchDGSQMX(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-DGSQMX-all')")
	@ApiOperation(value = "search待岗申请明细", tags = {"PcmBdsqdmx" } ,notes = "search待岗申请明细")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqdmxes/searchdgsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchDGSQMX(@RequestBody PcmBdsqdmxSearchContext context) {
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchDGSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-CQBXSQMXDS-all')")
	@ApiOperation(value = "fetch长期病休申请明细", tags = {"PcmBdsqdmx" } ,notes = "fetch长期病休申请明细")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/fetchcqbxsqmxds")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchCQBXSQMXDS(PcmBdsqdmxSearchContext context) {
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchCQBXSQMXDS(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-CQBXSQMXDS-all')")
	@ApiOperation(value = "search长期病休申请明细", tags = {"PcmBdsqdmx" } ,notes = "search长期病休申请明细")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqdmxes/searchcqbxsqmxds")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchCQBXSQMXDS(@RequestBody PcmBdsqdmxSearchContext context) {
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchCQBXSQMXDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-LZSQMX-all')")
	@ApiOperation(value = "fetch离职申请明细", tags = {"PcmBdsqdmx" } ,notes = "fetch离职申请明细")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/fetchlzsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchLZSQMX(PcmBdsqdmxSearchContext context) {
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchLZSQMX(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-LZSQMX-all')")
	@ApiOperation(value = "search离职申请明细", tags = {"PcmBdsqdmx" } ,notes = "search离职申请明细")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqdmxes/searchlzsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchLZSQMX(@RequestBody PcmBdsqdmxSearchContext context) {
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchLZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-LZSQMXGR-all')")
	@ApiOperation(value = "fetch离职申请明细（个人）", tags = {"PcmBdsqdmx" } ,notes = "fetch离职申请明细（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/fetchlzsqmxgr")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchLZSQMXGR(PcmBdsqdmxSearchContext context) {
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchLZSQMXGR(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-LZSQMXGR-all')")
	@ApiOperation(value = "search离职申请明细（个人）", tags = {"PcmBdsqdmx" } ,notes = "search离职申请明细（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqdmxes/searchlzsqmxgr")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchLZSQMXGR(@RequestBody PcmBdsqdmxSearchContext context) {
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchLZSQMXGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PcmBdsqdmx" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/fetchdefault")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchDefault(PcmBdsqdmxSearchContext context) {
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchDefault(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PcmBdsqdmx" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqdmxes/searchdefault")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchDefault(@RequestBody PcmBdsqdmxSearchContext context) {
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-ZJJSDMB-all')")
    @ApiOperation(value = "职级晋升代码表ByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "职级晋升代码表ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/zjjsdmb")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> zJJSDMBByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.zJJSDMB(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-CQBXCZ-all')")
    @ApiOperation(value = "长期病休操作ByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "长期病休操作ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/cqbxcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> cQBXCZByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.cQBXCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SXJSDMB-all')")
    @ApiOperation(value = "ByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxjsdmb")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sXJSDMBByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.sXJSDMB(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-PDZJ-all')")
    @ApiOperation(value = "判断职级ByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "判断职级ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/pdzj")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> pDZJByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.pDZJ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SXJSDMB2-all')")
    @ApiOperation(value = "刷新代码表ByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "刷新代码表ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxjsdmb2")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sXJSDMB2ByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.sXJSDMB2(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdto),'ehr-PcmBdsqdmx-Create')")
    @ApiOperation(value = "CreateByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "CreateByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> createByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
		pcmbdsqdmxService.create(domain);
        PcmBdsqdmxDTO dto = pcmbdsqdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdtos),'ehr-PcmBdsqdmx-Create')")
    @ApiOperation(value = "createBatchByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "createBatchByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> createBatchByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody List<PcmBdsqdmxDTO> pcmbdsqdmxdtos) {
        List<PcmBdsqdmx> domainlist=pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos);
        for(PcmBdsqdmx domain:domainlist){
            domain.setPcmbdsqdid(pcmbdsqd_id);
        }
        pcmbdsqdmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-ZZSQ-all')")
    @ApiOperation(value = "自助申请ByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "自助申请ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/zzsq")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> zZSQByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.zZSQ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SXDMB-all')")
    @ApiOperation(value = "职级降职代码表ByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "职级降职代码表ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxdmb")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sXDMBByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.sXDMB(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-DGCZ-all')")
    @ApiOperation(value = "待岗操作ByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "待岗操作ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/dgcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> dGCZByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.dGCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SetPersonInfo-all')")
    @ApiOperation(value = "设置人员相关信息ByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "设置人员相关信息ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/setpersoninfo")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> setPersonInfoByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.setPersonInfo(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-GZCZ-all')")
    @ApiOperation(value = "挂职操作ByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "挂职操作ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/gzcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> gZCZByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.gZCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-JPCZ-all')")
    @ApiOperation(value = "解聘操作ByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "解聘操作ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/jpcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> jPCZByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.jPCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdto),'ehr-PcmBdsqdmx-Save')")
    @ApiOperation(value = "SaveByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "SaveByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/save")
    public ResponseEntity<Boolean> saveByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdtos),'ehr-PcmBdsqdmx-Save')")
    @ApiOperation(value = "SaveBatchByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "SaveBatchByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody List<PcmBdsqdmxDTO> pcmbdsqdmxdtos) {
        List<PcmBdsqdmx> domainlist=pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos);
        for(PcmBdsqdmx domain:domainlist){
             domain.setPcmbdsqdid(pcmbdsqd_id);
        }
        pcmbdsqdmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-LZCZ-all')")
    @ApiOperation(value = "离职操作ByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "离职操作ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/lzcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> lZCZByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.lZCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-NTCZ-all')")
    @ApiOperation(value = "内退操作ByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "内退操作ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/ntcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> nTCZByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.nTCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.get(#pcmbdsqdmx_id),'ehr-PcmBdsqdmx-Update')")
    @ApiOperation(value = "UpdateByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "UpdateByPCMBDSQD")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> updateByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain.setPcmbdsqdmxid(pcmbdsqdmx_id);
		pcmbdsqdmxService.update(domain);
        PcmBdsqdmxDTO dto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.getPcmbdsqdmxByEntities(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdtos)),'ehr-PcmBdsqdmx-Update')")
    @ApiOperation(value = "UpdateBatchByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "UpdateBatchByPCMBDSQD")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody List<PcmBdsqdmxDTO> pcmbdsqdmxdtos) {
        List<PcmBdsqdmx> domainlist=pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos);
        for(PcmBdsqdmx domain:domainlist){
            domain.setPcmbdsqdid(pcmbdsqd_id);
        }
        pcmbdsqdmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(returnObject.body),'ehr-PcmBdsqdmx-Get')")
    @ApiOperation(value = "GetByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "GetByPCMBDSQD")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    public ResponseEntity<PcmBdsqdmxDTO> getByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id) {
        PcmBdsqdmx domain = pcmbdsqdmxService.get(pcmbdsqdmx_id);
        PcmBdsqdmxDTO dto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.get(#pcmbdsqdmx_id),'ehr-PcmBdsqdmx-Remove')")
    @ApiOperation(value = "RemoveByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "RemoveByPCMBDSQD")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.remove(pcmbdsqdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.getPcmbdsqdmxByIds(#ids),'ehr-PcmBdsqdmx-Remove')")
    @ApiOperation(value = "RemoveBatchByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "RemoveBatchByPCMBDSQD")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPCMBDSQD(@RequestBody List<String> ids) {
        pcmbdsqdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "GetDraftByPCMBDSQD")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/getdraft")
    public ResponseEntity<PcmBdsqdmxDTO> getDraftByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id) {
        PcmBdsqdmx domain = new PcmBdsqdmx();
        domain.setPcmbdsqdid(pcmbdsqd_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxMapping.toDto(pcmbdsqdmxService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SHBTG-all')")
    @ApiOperation(value = "审核不通过ByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "审核不通过ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/shbtg")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sHBTGByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.sHBTG(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-ZJBDCZ-all')")
    @ApiOperation(value = "职级变动操作ByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "职级变动操作ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/zjbdcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> zJBDCZByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.zJBDCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @ApiOperation(value = "CheckKeyByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "CheckKeyByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.checkKey(pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-TXCZ-all')")
    @ApiOperation(value = "退休操作ByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "退休操作ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/txcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> tXCZByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.tXCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-JZJJSDMB-all')")
    @ApiOperation(value = "局职级晋升代码表ByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "局职级晋升代码表ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/jzjjsdmb")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> jZJJSDMBByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.jZJJSDMB(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SHTG-all')")
    @ApiOperation(value = "审核通过ByPCMBDSQD", tags = {"PcmBdsqdmx" },  notes = "审核通过ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/shtg")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sHTGByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.sHTG(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-JPSQMX-all')")
	@ApiOperation(value = "fetch解聘申请（未审核）ByPCMBDSQD", tags = {"PcmBdsqdmx" } ,notes = "fetch解聘申请（未审核）ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchjpsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxJPSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchJPSQMX(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-JPSQMX-all')")
	@ApiOperation(value = "search解聘申请（未审核）ByPCMBDSQD", tags = {"PcmBdsqdmx" } ,notes = "search解聘申请（未审核）ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchjpsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxJPSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchJPSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-NTSQMX-all')")
	@ApiOperation(value = "fetch内退申请明细（未审核）ByPCMBDSQD", tags = {"PcmBdsqdmx" } ,notes = "fetch内退申请明细（未审核）ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchntsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxNTSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchNTSQMX(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-NTSQMX-all')")
	@ApiOperation(value = "search内退申请明细（未审核）ByPCMBDSQD", tags = {"PcmBdsqdmx" } ,notes = "search内退申请明细（未审核）ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchntsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxNTSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchNTSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-NTSQMXGR-all')")
	@ApiOperation(value = "fetch内退申请明细（个人）ByPCMBDSQD", tags = {"PcmBdsqdmx" } ,notes = "fetch内退申请明细（个人）ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchntsqmxgr")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxNTSQMXGRByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchNTSQMXGR(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-NTSQMXGR-all')")
	@ApiOperation(value = "search内退申请明细（个人）ByPCMBDSQD", tags = {"PcmBdsqdmx" } ,notes = "search内退申请明细（个人）ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchntsqmxgr")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxNTSQMXGRByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchNTSQMXGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-TXSQMX-all')")
	@ApiOperation(value = "fetch退休申请明细（未审核）ByPCMBDSQD", tags = {"PcmBdsqdmx" } ,notes = "fetch退休申请明细（未审核）ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchtxsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxTXSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchTXSQMX(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-TXSQMX-all')")
	@ApiOperation(value = "search退休申请明细（未审核）ByPCMBDSQD", tags = {"PcmBdsqdmx" } ,notes = "search退休申请明细（未审核）ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchtxsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxTXSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchTXSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-GZSQMX-all')")
	@ApiOperation(value = "fetch挂职申请明细（未审核）ByPCMBDSQD", tags = {"PcmBdsqdmx" } ,notes = "fetch挂职申请明细（未审核）ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchgzsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxGZSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchGZSQMX(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-GZSQMX-all')")
	@ApiOperation(value = "search挂职申请明细（未审核）ByPCMBDSQD", tags = {"PcmBdsqdmx" } ,notes = "search挂职申请明细（未审核）ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchgzsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxGZSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchGZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-ZJBDSQMX-all')")
	@ApiOperation(value = "fetch职级变动申请明细ByPCMBDSQD", tags = {"PcmBdsqdmx" } ,notes = "fetch职级变动申请明细ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchzjbdsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxZJBDSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchZJBDSQMX(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-ZJBDSQMX-all')")
	@ApiOperation(value = "search职级变动申请明细ByPCMBDSQD", tags = {"PcmBdsqdmx" } ,notes = "search职级变动申请明细ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchzjbdsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxZJBDSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchZJBDSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-DGSQMX-all')")
	@ApiOperation(value = "fetch待岗申请明细ByPCMBDSQD", tags = {"PcmBdsqdmx" } ,notes = "fetch待岗申请明细ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchdgsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxDGSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchDGSQMX(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-DGSQMX-all')")
	@ApiOperation(value = "search待岗申请明细ByPCMBDSQD", tags = {"PcmBdsqdmx" } ,notes = "search待岗申请明细ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchdgsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxDGSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchDGSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-CQBXSQMXDS-all')")
	@ApiOperation(value = "fetch长期病休申请明细ByPCMBDSQD", tags = {"PcmBdsqdmx" } ,notes = "fetch长期病休申请明细ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchcqbxsqmxds")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxCQBXSQMXDSByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchCQBXSQMXDS(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-CQBXSQMXDS-all')")
	@ApiOperation(value = "search长期病休申请明细ByPCMBDSQD", tags = {"PcmBdsqdmx" } ,notes = "search长期病休申请明细ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchcqbxsqmxds")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxCQBXSQMXDSByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchCQBXSQMXDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-LZSQMX-all')")
	@ApiOperation(value = "fetch离职申请明细ByPCMBDSQD", tags = {"PcmBdsqdmx" } ,notes = "fetch离职申请明细ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchlzsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxLZSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchLZSQMX(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-LZSQMX-all')")
	@ApiOperation(value = "search离职申请明细ByPCMBDSQD", tags = {"PcmBdsqdmx" } ,notes = "search离职申请明细ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchlzsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxLZSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchLZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-LZSQMXGR-all')")
	@ApiOperation(value = "fetch离职申请明细（个人）ByPCMBDSQD", tags = {"PcmBdsqdmx" } ,notes = "fetch离职申请明细（个人）ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchlzsqmxgr")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxLZSQMXGRByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchLZSQMXGR(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-LZSQMXGR-all')")
	@ApiOperation(value = "search离职申请明细（个人）ByPCMBDSQD", tags = {"PcmBdsqdmx" } ,notes = "search离职申请明细（个人）ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchlzsqmxgr")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxLZSQMXGRByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchLZSQMXGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPCMBDSQD", tags = {"PcmBdsqdmx" } ,notes = "fetchDEFAULTByPCMBDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchdefault")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxDefaultByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchDefault(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPCMBDSQD", tags = {"PcmBdsqdmx" } ,notes = "searchDEFAULTByPCMBDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchdefault")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxDefaultByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-ZJJSDMB-all')")
    @ApiOperation(value = "职级晋升代码表ByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "职级晋升代码表ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/zjjsdmb")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> zJJSDMBByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.zJJSDMB(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-CQBXCZ-all')")
    @ApiOperation(value = "长期病休操作ByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "长期病休操作ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/cqbxcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> cQBXCZByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.cQBXCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SXJSDMB-all')")
    @ApiOperation(value = "ByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxjsdmb")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sXJSDMBByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.sXJSDMB(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-PDZJ-all')")
    @ApiOperation(value = "判断职级ByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "判断职级ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/pdzj")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> pDZJByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.pDZJ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SXJSDMB2-all')")
    @ApiOperation(value = "刷新代码表ByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "刷新代码表ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxjsdmb2")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sXJSDMB2ByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.sXJSDMB2(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdto),'ehr-PcmBdsqdmx-Create')")
    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
		pcmbdsqdmxService.create(domain);
        PcmBdsqdmxDTO dto = pcmbdsqdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdtos),'ehr-PcmBdsqdmx-Create')")
    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PcmBdsqdmxDTO> pcmbdsqdmxdtos) {
        List<PcmBdsqdmx> domainlist=pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos);
        for(PcmBdsqdmx domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pcmbdsqdmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-ZZSQ-all')")
    @ApiOperation(value = "自助申请ByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "自助申请ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/zzsq")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> zZSQByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.zZSQ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SXDMB-all')")
    @ApiOperation(value = "职级降职代码表ByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "职级降职代码表ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxdmb")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sXDMBByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.sXDMB(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-DGCZ-all')")
    @ApiOperation(value = "待岗操作ByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "待岗操作ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/dgcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> dGCZByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.dGCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SetPersonInfo-all')")
    @ApiOperation(value = "设置人员相关信息ByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "设置人员相关信息ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/setpersoninfo")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> setPersonInfoByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.setPersonInfo(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-GZCZ-all')")
    @ApiOperation(value = "挂职操作ByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "挂职操作ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/gzcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> gZCZByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.gZCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-JPCZ-all')")
    @ApiOperation(value = "解聘操作ByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "解聘操作ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/jpcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> jPCZByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.jPCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdto),'ehr-PcmBdsqdmx-Save')")
    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdtos),'ehr-PcmBdsqdmx-Save')")
    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PcmBdsqdmxDTO> pcmbdsqdmxdtos) {
        List<PcmBdsqdmx> domainlist=pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos);
        for(PcmBdsqdmx domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pcmbdsqdmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-LZCZ-all')")
    @ApiOperation(value = "离职操作ByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "离职操作ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/lzcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> lZCZByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.lZCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-NTCZ-all')")
    @ApiOperation(value = "内退操作ByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "内退操作ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/ntcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> nTCZByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.nTCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.get(#pcmbdsqdmx_id),'ehr-PcmBdsqdmx-Update')")
    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPcmbdsqdmxid(pcmbdsqdmx_id);
		pcmbdsqdmxService.update(domain);
        PcmBdsqdmxDTO dto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.getPcmbdsqdmxByEntities(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdtos)),'ehr-PcmBdsqdmx-Update')")
    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PcmBdsqdmxDTO> pcmbdsqdmxdtos) {
        List<PcmBdsqdmx> domainlist=pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos);
        for(PcmBdsqdmx domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pcmbdsqdmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(returnObject.body),'ehr-PcmBdsqdmx-Get')")
    @ApiOperation(value = "GetByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    public ResponseEntity<PcmBdsqdmxDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id) {
        PcmBdsqdmx domain = pcmbdsqdmxService.get(pcmbdsqdmx_id);
        PcmBdsqdmxDTO dto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.get(#pcmbdsqdmx_id),'ehr-PcmBdsqdmx-Remove')")
    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.remove(pcmbdsqdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.getPcmbdsqdmxByIds(#ids),'ehr-PcmBdsqdmx-Remove')")
    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        pcmbdsqdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/getdraft")
    public ResponseEntity<PcmBdsqdmxDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PcmBdsqdmx domain = new PcmBdsqdmx();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxMapping.toDto(pcmbdsqdmxService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SHBTG-all')")
    @ApiOperation(value = "审核不通过ByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "审核不通过ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/shbtg")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sHBTGByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.sHBTG(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-ZJBDCZ-all')")
    @ApiOperation(value = "职级变动操作ByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "职级变动操作ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/zjbdcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> zJBDCZByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.zJBDCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.checkKey(pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-TXCZ-all')")
    @ApiOperation(value = "退休操作ByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "退休操作ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/txcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> tXCZByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.tXCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-JZJJSDMB-all')")
    @ApiOperation(value = "局职级晋升代码表ByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "局职级晋升代码表ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/jzjjsdmb")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> jZJJSDMBByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.jZJJSDMB(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SHTG-all')")
    @ApiOperation(value = "审核通过ByPIMPERSON", tags = {"PcmBdsqdmx" },  notes = "审核通过ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/shtg")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sHTGByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.sHTG(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-JPSQMX-all')")
	@ApiOperation(value = "fetch解聘申请（未审核）ByPIMPERSON", tags = {"PcmBdsqdmx" } ,notes = "fetch解聘申请（未审核）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchjpsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxJPSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchJPSQMX(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-JPSQMX-all')")
	@ApiOperation(value = "search解聘申请（未审核）ByPIMPERSON", tags = {"PcmBdsqdmx" } ,notes = "search解聘申请（未审核）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchjpsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxJPSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchJPSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-NTSQMX-all')")
	@ApiOperation(value = "fetch内退申请明细（未审核）ByPIMPERSON", tags = {"PcmBdsqdmx" } ,notes = "fetch内退申请明细（未审核）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchntsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxNTSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchNTSQMX(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-NTSQMX-all')")
	@ApiOperation(value = "search内退申请明细（未审核）ByPIMPERSON", tags = {"PcmBdsqdmx" } ,notes = "search内退申请明细（未审核）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchntsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxNTSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchNTSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-NTSQMXGR-all')")
	@ApiOperation(value = "fetch内退申请明细（个人）ByPIMPERSON", tags = {"PcmBdsqdmx" } ,notes = "fetch内退申请明细（个人）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchntsqmxgr")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxNTSQMXGRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchNTSQMXGR(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-NTSQMXGR-all')")
	@ApiOperation(value = "search内退申请明细（个人）ByPIMPERSON", tags = {"PcmBdsqdmx" } ,notes = "search内退申请明细（个人）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchntsqmxgr")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxNTSQMXGRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchNTSQMXGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-TXSQMX-all')")
	@ApiOperation(value = "fetch退休申请明细（未审核）ByPIMPERSON", tags = {"PcmBdsqdmx" } ,notes = "fetch退休申请明细（未审核）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchtxsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxTXSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchTXSQMX(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-TXSQMX-all')")
	@ApiOperation(value = "search退休申请明细（未审核）ByPIMPERSON", tags = {"PcmBdsqdmx" } ,notes = "search退休申请明细（未审核）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchtxsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxTXSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchTXSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-GZSQMX-all')")
	@ApiOperation(value = "fetch挂职申请明细（未审核）ByPIMPERSON", tags = {"PcmBdsqdmx" } ,notes = "fetch挂职申请明细（未审核）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchgzsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxGZSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchGZSQMX(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-GZSQMX-all')")
	@ApiOperation(value = "search挂职申请明细（未审核）ByPIMPERSON", tags = {"PcmBdsqdmx" } ,notes = "search挂职申请明细（未审核）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchgzsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxGZSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchGZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-ZJBDSQMX-all')")
	@ApiOperation(value = "fetch职级变动申请明细ByPIMPERSON", tags = {"PcmBdsqdmx" } ,notes = "fetch职级变动申请明细ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchzjbdsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxZJBDSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchZJBDSQMX(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-ZJBDSQMX-all')")
	@ApiOperation(value = "search职级变动申请明细ByPIMPERSON", tags = {"PcmBdsqdmx" } ,notes = "search职级变动申请明细ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchzjbdsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxZJBDSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchZJBDSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-DGSQMX-all')")
	@ApiOperation(value = "fetch待岗申请明细ByPIMPERSON", tags = {"PcmBdsqdmx" } ,notes = "fetch待岗申请明细ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchdgsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxDGSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchDGSQMX(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-DGSQMX-all')")
	@ApiOperation(value = "search待岗申请明细ByPIMPERSON", tags = {"PcmBdsqdmx" } ,notes = "search待岗申请明细ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchdgsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxDGSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchDGSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-CQBXSQMXDS-all')")
	@ApiOperation(value = "fetch长期病休申请明细ByPIMPERSON", tags = {"PcmBdsqdmx" } ,notes = "fetch长期病休申请明细ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchcqbxsqmxds")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxCQBXSQMXDSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchCQBXSQMXDS(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-CQBXSQMXDS-all')")
	@ApiOperation(value = "search长期病休申请明细ByPIMPERSON", tags = {"PcmBdsqdmx" } ,notes = "search长期病休申请明细ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchcqbxsqmxds")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxCQBXSQMXDSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchCQBXSQMXDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-LZSQMX-all')")
	@ApiOperation(value = "fetch离职申请明细ByPIMPERSON", tags = {"PcmBdsqdmx" } ,notes = "fetch离职申请明细ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchlzsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxLZSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchLZSQMX(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-LZSQMX-all')")
	@ApiOperation(value = "search离职申请明细ByPIMPERSON", tags = {"PcmBdsqdmx" } ,notes = "search离职申请明细ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchlzsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxLZSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchLZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-LZSQMXGR-all')")
	@ApiOperation(value = "fetch离职申请明细（个人）ByPIMPERSON", tags = {"PcmBdsqdmx" } ,notes = "fetch离职申请明细（个人）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchlzsqmxgr")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxLZSQMXGRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchLZSQMXGR(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-LZSQMXGR-all')")
	@ApiOperation(value = "search离职申请明细（个人）ByPIMPERSON", tags = {"PcmBdsqdmx" } ,notes = "search离职申请明细（个人）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchlzsqmxgr")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxLZSQMXGRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchLZSQMXGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PcmBdsqdmx" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchdefault")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchDefault(context) ;
        List<PcmBdsqdmxDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PcmBdsqdmx" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchdefault")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

