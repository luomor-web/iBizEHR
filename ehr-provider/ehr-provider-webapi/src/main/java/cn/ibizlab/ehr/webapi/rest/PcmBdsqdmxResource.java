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
    @ApiOperation(value = "职级晋升代码表ByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "职级晋升代码表ByPcmBdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/zjjsdmb")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> zJJSDMBByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.zJJSDMB(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-CQBXCZ-all')")
    @ApiOperation(value = "长期病休操作ByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "长期病休操作ByPcmBdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/cqbxcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> cQBXCZByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.cQBXCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SXJSDMB-all')")
    @ApiOperation(value = "ByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "ByPcmBdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxjsdmb")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sXJSDMBByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.sXJSDMB(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-PDZJ-all')")
    @ApiOperation(value = "判断职级ByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "判断职级ByPcmBdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/pdzj")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> pDZJByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.pDZJ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SXJSDMB2-all')")
    @ApiOperation(value = "刷新代码表ByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "刷新代码表ByPcmBdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxjsdmb2")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sXJSDMB2ByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.sXJSDMB2(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdto),'ehr-PcmBdsqdmx-Create')")
    @ApiOperation(value = "CreateByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "CreateByPcmBdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> createByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
		pcmbdsqdmxService.create(domain);
        PcmBdsqdmxDTO dto = pcmbdsqdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdtos),'ehr-PcmBdsqdmx-Create')")
    @ApiOperation(value = "createBatchByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "createBatchByPcmBdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> createBatchByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody List<PcmBdsqdmxDTO> pcmbdsqdmxdtos) {
        List<PcmBdsqdmx> domainlist=pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos);
        for(PcmBdsqdmx domain:domainlist){
            domain.setPcmbdsqdid(pcmbdsqd_id);
        }
        pcmbdsqdmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-ZZSQ-all')")
    @ApiOperation(value = "自助申请ByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "自助申请ByPcmBdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/zzsq")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> zZSQByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.zZSQ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SXDMB-all')")
    @ApiOperation(value = "职级降职代码表ByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "职级降职代码表ByPcmBdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxdmb")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sXDMBByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.sXDMB(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-DGCZ-all')")
    @ApiOperation(value = "待岗操作ByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "待岗操作ByPcmBdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/dgcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> dGCZByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.dGCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SetPersonInfo-all')")
    @ApiOperation(value = "设置人员相关信息ByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "设置人员相关信息ByPcmBdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/setpersoninfo")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> setPersonInfoByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.setPersonInfo(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-GZCZ-all')")
    @ApiOperation(value = "挂职操作ByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "挂职操作ByPcmBdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/gzcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> gZCZByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.gZCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-JPCZ-all')")
    @ApiOperation(value = "解聘操作ByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "解聘操作ByPcmBdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/jpcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> jPCZByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.jPCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdto),'ehr-PcmBdsqdmx-Save')")
    @ApiOperation(value = "SaveByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "SaveByPcmBdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/save")
    public ResponseEntity<Boolean> saveByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdtos),'ehr-PcmBdsqdmx-Save')")
    @ApiOperation(value = "SaveBatchByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "SaveBatchByPcmBdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody List<PcmBdsqdmxDTO> pcmbdsqdmxdtos) {
        List<PcmBdsqdmx> domainlist=pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos);
        for(PcmBdsqdmx domain:domainlist){
             domain.setPcmbdsqdid(pcmbdsqd_id);
        }
        pcmbdsqdmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-LZCZ-all')")
    @ApiOperation(value = "离职操作ByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "离职操作ByPcmBdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/lzcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> lZCZByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.lZCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-NTCZ-all')")
    @ApiOperation(value = "内退操作ByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "内退操作ByPcmBdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/ntcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> nTCZByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.nTCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.get(#pcmbdsqdmx_id),'ehr-PcmBdsqdmx-Update')")
    @ApiOperation(value = "UpdateByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "UpdateByPcmBdsqd")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> updateByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain.setPcmbdsqdmxid(pcmbdsqdmx_id);
		pcmbdsqdmxService.update(domain);
        PcmBdsqdmxDTO dto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.getPcmbdsqdmxByEntities(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdtos)),'ehr-PcmBdsqdmx-Update')")
    @ApiOperation(value = "UpdateBatchByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "UpdateBatchByPcmBdsqd")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody List<PcmBdsqdmxDTO> pcmbdsqdmxdtos) {
        List<PcmBdsqdmx> domainlist=pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos);
        for(PcmBdsqdmx domain:domainlist){
            domain.setPcmbdsqdid(pcmbdsqd_id);
        }
        pcmbdsqdmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(returnObject.body),'ehr-PcmBdsqdmx-Get')")
    @ApiOperation(value = "GetByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "GetByPcmBdsqd")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    public ResponseEntity<PcmBdsqdmxDTO> getByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id) {
        PcmBdsqdmx domain = pcmbdsqdmxService.get(pcmbdsqdmx_id);
        PcmBdsqdmxDTO dto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.get(#pcmbdsqdmx_id),'ehr-PcmBdsqdmx-Remove')")
    @ApiOperation(value = "RemoveByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "RemoveByPcmBdsqd")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.remove(pcmbdsqdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.getPcmbdsqdmxByIds(#ids),'ehr-PcmBdsqdmx-Remove')")
    @ApiOperation(value = "RemoveBatchByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "RemoveBatchByPcmBdsqd")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPcmBdsqd(@RequestBody List<String> ids) {
        pcmbdsqdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "GetDraftByPcmBdsqd")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/getdraft")
    public ResponseEntity<PcmBdsqdmxDTO> getDraftByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id) {
        PcmBdsqdmx domain = new PcmBdsqdmx();
        domain.setPcmbdsqdid(pcmbdsqd_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxMapping.toDto(pcmbdsqdmxService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SHBTG-all')")
    @ApiOperation(value = "审核不通过ByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "审核不通过ByPcmBdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/shbtg")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sHBTGByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.sHBTG(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-ZJBDCZ-all')")
    @ApiOperation(value = "职级变动操作ByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "职级变动操作ByPcmBdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/zjbdcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> zJBDCZByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.zJBDCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @ApiOperation(value = "CheckKeyByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "CheckKeyByPcmBdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.checkKey(pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-TXCZ-all')")
    @ApiOperation(value = "退休操作ByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "退休操作ByPcmBdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/txcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> tXCZByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.tXCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-JZJJSDMB-all')")
    @ApiOperation(value = "局职级晋升代码表ByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "局职级晋升代码表ByPcmBdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/jzjjsdmb")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> jZJJSDMBByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.jZJJSDMB(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SHTG-all')")
    @ApiOperation(value = "审核通过ByPcmBdsqd", tags = {"PcmBdsqdmx" },  notes = "审核通过ByPcmBdsqd")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/shtg")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sHTGByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.sHTG(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-JPSQMX-all')")
	@ApiOperation(value = "fetch解聘申请（未审核）ByPcmBdsqd", tags = {"PcmBdsqdmx" } ,notes = "fetch解聘申请（未审核）ByPcmBdsqd")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchjpsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxJPSQMXByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PcmBdsqdmxSearchContext context) {
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
	@ApiOperation(value = "search解聘申请（未审核）ByPcmBdsqd", tags = {"PcmBdsqdmx" } ,notes = "search解聘申请（未审核）ByPcmBdsqd")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchjpsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxJPSQMXByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchJPSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-NTSQMX-all')")
	@ApiOperation(value = "fetch内退申请明细（未审核）ByPcmBdsqd", tags = {"PcmBdsqdmx" } ,notes = "fetch内退申请明细（未审核）ByPcmBdsqd")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchntsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxNTSQMXByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PcmBdsqdmxSearchContext context) {
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
	@ApiOperation(value = "search内退申请明细（未审核）ByPcmBdsqd", tags = {"PcmBdsqdmx" } ,notes = "search内退申请明细（未审核）ByPcmBdsqd")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchntsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxNTSQMXByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchNTSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-NTSQMXGR-all')")
	@ApiOperation(value = "fetch内退申请明细（个人）ByPcmBdsqd", tags = {"PcmBdsqdmx" } ,notes = "fetch内退申请明细（个人）ByPcmBdsqd")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchntsqmxgr")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxNTSQMXGRByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PcmBdsqdmxSearchContext context) {
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
	@ApiOperation(value = "search内退申请明细（个人）ByPcmBdsqd", tags = {"PcmBdsqdmx" } ,notes = "search内退申请明细（个人）ByPcmBdsqd")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchntsqmxgr")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxNTSQMXGRByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchNTSQMXGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-TXSQMX-all')")
	@ApiOperation(value = "fetch退休申请明细（未审核）ByPcmBdsqd", tags = {"PcmBdsqdmx" } ,notes = "fetch退休申请明细（未审核）ByPcmBdsqd")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchtxsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxTXSQMXByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PcmBdsqdmxSearchContext context) {
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
	@ApiOperation(value = "search退休申请明细（未审核）ByPcmBdsqd", tags = {"PcmBdsqdmx" } ,notes = "search退休申请明细（未审核）ByPcmBdsqd")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchtxsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxTXSQMXByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchTXSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-GZSQMX-all')")
	@ApiOperation(value = "fetch挂职申请明细（未审核）ByPcmBdsqd", tags = {"PcmBdsqdmx" } ,notes = "fetch挂职申请明细（未审核）ByPcmBdsqd")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchgzsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxGZSQMXByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PcmBdsqdmxSearchContext context) {
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
	@ApiOperation(value = "search挂职申请明细（未审核）ByPcmBdsqd", tags = {"PcmBdsqdmx" } ,notes = "search挂职申请明细（未审核）ByPcmBdsqd")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchgzsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxGZSQMXByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchGZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-ZJBDSQMX-all')")
	@ApiOperation(value = "fetch职级变动申请明细ByPcmBdsqd", tags = {"PcmBdsqdmx" } ,notes = "fetch职级变动申请明细ByPcmBdsqd")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchzjbdsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxZJBDSQMXByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PcmBdsqdmxSearchContext context) {
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
	@ApiOperation(value = "search职级变动申请明细ByPcmBdsqd", tags = {"PcmBdsqdmx" } ,notes = "search职级变动申请明细ByPcmBdsqd")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchzjbdsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxZJBDSQMXByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchZJBDSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-DGSQMX-all')")
	@ApiOperation(value = "fetch待岗申请明细ByPcmBdsqd", tags = {"PcmBdsqdmx" } ,notes = "fetch待岗申请明细ByPcmBdsqd")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchdgsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxDGSQMXByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PcmBdsqdmxSearchContext context) {
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
	@ApiOperation(value = "search待岗申请明细ByPcmBdsqd", tags = {"PcmBdsqdmx" } ,notes = "search待岗申请明细ByPcmBdsqd")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchdgsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxDGSQMXByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchDGSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-CQBXSQMXDS-all')")
	@ApiOperation(value = "fetch长期病休申请明细ByPcmBdsqd", tags = {"PcmBdsqdmx" } ,notes = "fetch长期病休申请明细ByPcmBdsqd")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchcqbxsqmxds")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxCQBXSQMXDSByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PcmBdsqdmxSearchContext context) {
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
	@ApiOperation(value = "search长期病休申请明细ByPcmBdsqd", tags = {"PcmBdsqdmx" } ,notes = "search长期病休申请明细ByPcmBdsqd")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchcqbxsqmxds")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxCQBXSQMXDSByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchCQBXSQMXDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-LZSQMX-all')")
	@ApiOperation(value = "fetch离职申请明细ByPcmBdsqd", tags = {"PcmBdsqdmx" } ,notes = "fetch离职申请明细ByPcmBdsqd")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchlzsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxLZSQMXByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PcmBdsqdmxSearchContext context) {
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
	@ApiOperation(value = "search离职申请明细ByPcmBdsqd", tags = {"PcmBdsqdmx" } ,notes = "search离职申请明细ByPcmBdsqd")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchlzsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxLZSQMXByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchLZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-LZSQMXGR-all')")
	@ApiOperation(value = "fetch离职申请明细（个人）ByPcmBdsqd", tags = {"PcmBdsqdmx" } ,notes = "fetch离职申请明细（个人）ByPcmBdsqd")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchlzsqmxgr")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxLZSQMXGRByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PcmBdsqdmxSearchContext context) {
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
	@ApiOperation(value = "search离职申请明细（个人）ByPcmBdsqd", tags = {"PcmBdsqdmx" } ,notes = "search离职申请明细（个人）ByPcmBdsqd")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchlzsqmxgr")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxLZSQMXGRByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchLZSQMXGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPcmBdsqd", tags = {"PcmBdsqdmx" } ,notes = "fetchDEFAULTByPcmBdsqd")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchdefault")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxDefaultByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PcmBdsqdmxSearchContext context) {
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
	@ApiOperation(value = "searchDEFAULTByPcmBdsqd", tags = {"PcmBdsqdmx" } ,notes = "searchDEFAULTByPcmBdsqd")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchdefault")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxDefaultByPcmBdsqd(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-ZJJSDMB-all')")
    @ApiOperation(value = "职级晋升代码表ByPimPerson", tags = {"PcmBdsqdmx" },  notes = "职级晋升代码表ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/zjjsdmb")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> zJJSDMBByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.zJJSDMB(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-CQBXCZ-all')")
    @ApiOperation(value = "长期病休操作ByPimPerson", tags = {"PcmBdsqdmx" },  notes = "长期病休操作ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/cqbxcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> cQBXCZByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.cQBXCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SXJSDMB-all')")
    @ApiOperation(value = "ByPimPerson", tags = {"PcmBdsqdmx" },  notes = "ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxjsdmb")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sXJSDMBByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.sXJSDMB(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-PDZJ-all')")
    @ApiOperation(value = "判断职级ByPimPerson", tags = {"PcmBdsqdmx" },  notes = "判断职级ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/pdzj")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> pDZJByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.pDZJ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SXJSDMB2-all')")
    @ApiOperation(value = "刷新代码表ByPimPerson", tags = {"PcmBdsqdmx" },  notes = "刷新代码表ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxjsdmb2")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sXJSDMB2ByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.sXJSDMB2(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdto),'ehr-PcmBdsqdmx-Create')")
    @ApiOperation(value = "CreateByPimPerson", tags = {"PcmBdsqdmx" },  notes = "CreateByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> createByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
		pcmbdsqdmxService.create(domain);
        PcmBdsqdmxDTO dto = pcmbdsqdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdtos),'ehr-PcmBdsqdmx-Create')")
    @ApiOperation(value = "createBatchByPimPerson", tags = {"PcmBdsqdmx" },  notes = "createBatchByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> createBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PcmBdsqdmxDTO> pcmbdsqdmxdtos) {
        List<PcmBdsqdmx> domainlist=pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos);
        for(PcmBdsqdmx domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pcmbdsqdmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-ZZSQ-all')")
    @ApiOperation(value = "自助申请ByPimPerson", tags = {"PcmBdsqdmx" },  notes = "自助申请ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/zzsq")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> zZSQByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.zZSQ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SXDMB-all')")
    @ApiOperation(value = "职级降职代码表ByPimPerson", tags = {"PcmBdsqdmx" },  notes = "职级降职代码表ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxdmb")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sXDMBByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.sXDMB(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-DGCZ-all')")
    @ApiOperation(value = "待岗操作ByPimPerson", tags = {"PcmBdsqdmx" },  notes = "待岗操作ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/dgcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> dGCZByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.dGCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SetPersonInfo-all')")
    @ApiOperation(value = "设置人员相关信息ByPimPerson", tags = {"PcmBdsqdmx" },  notes = "设置人员相关信息ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/setpersoninfo")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> setPersonInfoByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.setPersonInfo(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-GZCZ-all')")
    @ApiOperation(value = "挂职操作ByPimPerson", tags = {"PcmBdsqdmx" },  notes = "挂职操作ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/gzcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> gZCZByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.gZCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-JPCZ-all')")
    @ApiOperation(value = "解聘操作ByPimPerson", tags = {"PcmBdsqdmx" },  notes = "解聘操作ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/jpcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> jPCZByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.jPCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdto),'ehr-PcmBdsqdmx-Save')")
    @ApiOperation(value = "SaveByPimPerson", tags = {"PcmBdsqdmx" },  notes = "SaveByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/save")
    public ResponseEntity<Boolean> saveByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdtos),'ehr-PcmBdsqdmx-Save')")
    @ApiOperation(value = "SaveBatchByPimPerson", tags = {"PcmBdsqdmx" },  notes = "SaveBatchByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PcmBdsqdmxDTO> pcmbdsqdmxdtos) {
        List<PcmBdsqdmx> domainlist=pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos);
        for(PcmBdsqdmx domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pcmbdsqdmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-LZCZ-all')")
    @ApiOperation(value = "离职操作ByPimPerson", tags = {"PcmBdsqdmx" },  notes = "离职操作ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/lzcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> lZCZByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.lZCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-NTCZ-all')")
    @ApiOperation(value = "内退操作ByPimPerson", tags = {"PcmBdsqdmx" },  notes = "内退操作ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/ntcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> nTCZByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.nTCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.get(#pcmbdsqdmx_id),'ehr-PcmBdsqdmx-Update')")
    @ApiOperation(value = "UpdateByPimPerson", tags = {"PcmBdsqdmx" },  notes = "UpdateByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> updateByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPcmbdsqdmxid(pcmbdsqdmx_id);
		pcmbdsqdmxService.update(domain);
        PcmBdsqdmxDTO dto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.getPcmbdsqdmxByEntities(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdtos)),'ehr-PcmBdsqdmx-Update')")
    @ApiOperation(value = "UpdateBatchByPimPerson", tags = {"PcmBdsqdmx" },  notes = "UpdateBatchByPimPerson")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PcmBdsqdmxDTO> pcmbdsqdmxdtos) {
        List<PcmBdsqdmx> domainlist=pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos);
        for(PcmBdsqdmx domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pcmbdsqdmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(returnObject.body),'ehr-PcmBdsqdmx-Get')")
    @ApiOperation(value = "GetByPimPerson", tags = {"PcmBdsqdmx" },  notes = "GetByPimPerson")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    public ResponseEntity<PcmBdsqdmxDTO> getByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id) {
        PcmBdsqdmx domain = pcmbdsqdmxService.get(pcmbdsqdmx_id);
        PcmBdsqdmxDTO dto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.get(#pcmbdsqdmx_id),'ehr-PcmBdsqdmx-Remove')")
    @ApiOperation(value = "RemoveByPimPerson", tags = {"PcmBdsqdmx" },  notes = "RemoveByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.remove(pcmbdsqdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.getPcmbdsqdmxByIds(#ids),'ehr-PcmBdsqdmx-Remove')")
    @ApiOperation(value = "RemoveBatchByPimPerson", tags = {"PcmBdsqdmx" },  notes = "RemoveBatchByPimPerson")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPimPerson(@RequestBody List<String> ids) {
        pcmbdsqdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPimPerson", tags = {"PcmBdsqdmx" },  notes = "GetDraftByPimPerson")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/getdraft")
    public ResponseEntity<PcmBdsqdmxDTO> getDraftByPimPerson(@PathVariable("pimperson_id") String pimperson_id) {
        PcmBdsqdmx domain = new PcmBdsqdmx();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxMapping.toDto(pcmbdsqdmxService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SHBTG-all')")
    @ApiOperation(value = "审核不通过ByPimPerson", tags = {"PcmBdsqdmx" },  notes = "审核不通过ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/shbtg")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sHBTGByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.sHBTG(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-ZJBDCZ-all')")
    @ApiOperation(value = "职级变动操作ByPimPerson", tags = {"PcmBdsqdmx" },  notes = "职级变动操作ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/zjbdcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> zJBDCZByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.zJBDCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @ApiOperation(value = "CheckKeyByPimPerson", tags = {"PcmBdsqdmx" },  notes = "CheckKeyByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.checkKey(pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-TXCZ-all')")
    @ApiOperation(value = "退休操作ByPimPerson", tags = {"PcmBdsqdmx" },  notes = "退休操作ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/txcz")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> tXCZByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.tXCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-JZJJSDMB-all')")
    @ApiOperation(value = "局职级晋升代码表ByPimPerson", tags = {"PcmBdsqdmx" },  notes = "局职级晋升代码表ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/jzjjsdmb")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> jZJJSDMBByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.jZJJSDMB(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-SHTG-all')")
    @ApiOperation(value = "审核通过ByPimPerson", tags = {"PcmBdsqdmx" },  notes = "审核通过ByPimPerson")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/shtg")
    @Transactional
    public ResponseEntity<PcmBdsqdmxDTO> sHTGByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PcmBdsqdmxDTO pcmbdsqdmxdto) {
        PcmBdsqdmx domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.sHTG(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-JPSQMX-all')")
	@ApiOperation(value = "fetch解聘申请（未审核）ByPimPerson", tags = {"PcmBdsqdmx" } ,notes = "fetch解聘申请（未审核）ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchjpsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxJPSQMXByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PcmBdsqdmxSearchContext context) {
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
	@ApiOperation(value = "search解聘申请（未审核）ByPimPerson", tags = {"PcmBdsqdmx" } ,notes = "search解聘申请（未审核）ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchjpsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxJPSQMXByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchJPSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-NTSQMX-all')")
	@ApiOperation(value = "fetch内退申请明细（未审核）ByPimPerson", tags = {"PcmBdsqdmx" } ,notes = "fetch内退申请明细（未审核）ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchntsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxNTSQMXByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PcmBdsqdmxSearchContext context) {
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
	@ApiOperation(value = "search内退申请明细（未审核）ByPimPerson", tags = {"PcmBdsqdmx" } ,notes = "search内退申请明细（未审核）ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchntsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxNTSQMXByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchNTSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-NTSQMXGR-all')")
	@ApiOperation(value = "fetch内退申请明细（个人）ByPimPerson", tags = {"PcmBdsqdmx" } ,notes = "fetch内退申请明细（个人）ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchntsqmxgr")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxNTSQMXGRByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PcmBdsqdmxSearchContext context) {
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
	@ApiOperation(value = "search内退申请明细（个人）ByPimPerson", tags = {"PcmBdsqdmx" } ,notes = "search内退申请明细（个人）ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchntsqmxgr")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxNTSQMXGRByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchNTSQMXGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-TXSQMX-all')")
	@ApiOperation(value = "fetch退休申请明细（未审核）ByPimPerson", tags = {"PcmBdsqdmx" } ,notes = "fetch退休申请明细（未审核）ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchtxsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxTXSQMXByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PcmBdsqdmxSearchContext context) {
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
	@ApiOperation(value = "search退休申请明细（未审核）ByPimPerson", tags = {"PcmBdsqdmx" } ,notes = "search退休申请明细（未审核）ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchtxsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxTXSQMXByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchTXSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-GZSQMX-all')")
	@ApiOperation(value = "fetch挂职申请明细（未审核）ByPimPerson", tags = {"PcmBdsqdmx" } ,notes = "fetch挂职申请明细（未审核）ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchgzsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxGZSQMXByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PcmBdsqdmxSearchContext context) {
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
	@ApiOperation(value = "search挂职申请明细（未审核）ByPimPerson", tags = {"PcmBdsqdmx" } ,notes = "search挂职申请明细（未审核）ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchgzsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxGZSQMXByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchGZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-ZJBDSQMX-all')")
	@ApiOperation(value = "fetch职级变动申请明细ByPimPerson", tags = {"PcmBdsqdmx" } ,notes = "fetch职级变动申请明细ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchzjbdsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxZJBDSQMXByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PcmBdsqdmxSearchContext context) {
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
	@ApiOperation(value = "search职级变动申请明细ByPimPerson", tags = {"PcmBdsqdmx" } ,notes = "search职级变动申请明细ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchzjbdsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxZJBDSQMXByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchZJBDSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-DGSQMX-all')")
	@ApiOperation(value = "fetch待岗申请明细ByPimPerson", tags = {"PcmBdsqdmx" } ,notes = "fetch待岗申请明细ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchdgsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxDGSQMXByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PcmBdsqdmxSearchContext context) {
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
	@ApiOperation(value = "search待岗申请明细ByPimPerson", tags = {"PcmBdsqdmx" } ,notes = "search待岗申请明细ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchdgsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxDGSQMXByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchDGSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-CQBXSQMXDS-all')")
	@ApiOperation(value = "fetch长期病休申请明细ByPimPerson", tags = {"PcmBdsqdmx" } ,notes = "fetch长期病休申请明细ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchcqbxsqmxds")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxCQBXSQMXDSByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PcmBdsqdmxSearchContext context) {
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
	@ApiOperation(value = "search长期病休申请明细ByPimPerson", tags = {"PcmBdsqdmx" } ,notes = "search长期病休申请明细ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchcqbxsqmxds")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxCQBXSQMXDSByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchCQBXSQMXDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-LZSQMX-all')")
	@ApiOperation(value = "fetch离职申请明细ByPimPerson", tags = {"PcmBdsqdmx" } ,notes = "fetch离职申请明细ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchlzsqmx")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxLZSQMXByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PcmBdsqdmxSearchContext context) {
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
	@ApiOperation(value = "search离职申请明细ByPimPerson", tags = {"PcmBdsqdmx" } ,notes = "search离职申请明细ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchlzsqmx")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxLZSQMXByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchLZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-LZSQMXGR-all')")
	@ApiOperation(value = "fetch离职申请明细（个人）ByPimPerson", tags = {"PcmBdsqdmx" } ,notes = "fetch离职申请明细（个人）ByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchlzsqmxgr")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxLZSQMXGRByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PcmBdsqdmxSearchContext context) {
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
	@ApiOperation(value = "search离职申请明细（个人）ByPimPerson", tags = {"PcmBdsqdmx" } ,notes = "search离职申请明细（个人）ByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchlzsqmxgr")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxLZSQMXGRByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchLZSQMXGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PcmBdsqdmx-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPimPerson", tags = {"PcmBdsqdmx" } ,notes = "fetchDEFAULTByPimPerson")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchdefault")
	public ResponseEntity<List<PcmBdsqdmxDTO>> fetchPcmBdsqdmxDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id,PcmBdsqdmxSearchContext context) {
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
	@ApiOperation(value = "searchDEFAULTByPimPerson", tags = {"PcmBdsqdmx" } ,notes = "searchDEFAULTByPimPerson")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchdefault")
	public ResponseEntity<Page<PcmBdsqdmxDTO>> searchPcmBdsqdmxDefaultByPimPerson(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PcmBdsqdmxSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PcmBdsqdmx> domains = pcmbdsqdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

