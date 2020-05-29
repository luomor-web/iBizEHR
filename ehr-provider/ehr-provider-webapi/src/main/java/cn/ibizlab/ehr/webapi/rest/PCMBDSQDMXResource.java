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
import cn.ibizlab.ehr.core.pcm.domain.PCMBDSQDMX;
import cn.ibizlab.ehr.core.pcm.service.IPCMBDSQDMXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMBDSQDMXSearchContext;

@Slf4j
@Api(tags = {"PCMBDSQDMX" })
@RestController("WebApi-pcmbdsqdmx")
@RequestMapping("")
public class PCMBDSQDMXResource {

    @Autowired
    public IPCMBDSQDMXService pcmbdsqdmxService;

    @Autowired
    @Lazy
    public PCMBDSQDMXMapping pcmbdsqdmxMapping;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-ZJJSDMB-all')")
    @ApiOperation(value = "职级晋升代码表", tags = {"PCMBDSQDMX" },  notes = "职级晋升代码表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/zjjsdmb")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> zJJSDMB(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.zJJSDMB(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-CQBXCZ-all')")
    @ApiOperation(value = "长期病休操作", tags = {"PCMBDSQDMX" },  notes = "长期病休操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/cqbxcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> cQBXCZ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.cQBXCZ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-SXJSDMB-all')")
    @ApiOperation(value = "", tags = {"PCMBDSQDMX" },  notes = "")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxjsdmb")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> sXJSDMB(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.sXJSDMB(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-PDZJ-all')")
    @ApiOperation(value = "判断职级", tags = {"PCMBDSQDMX" },  notes = "判断职级")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/pdzj")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> pDZJ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.pDZJ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-SXJSDMB2-all')")
    @ApiOperation(value = "刷新代码表", tags = {"PCMBDSQDMX" },  notes = "刷新代码表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxjsdmb2")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> sXJSDMB2(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.sXJSDMB2(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdto),'ehr-PCMBDSQDMX-Create')")
    @ApiOperation(value = "Create", tags = {"PCMBDSQDMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> create(@RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
		pcmbdsqdmxService.create(domain);
        PCMBDSQDMXDTO dto = pcmbdsqdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdtos),'ehr-PCMBDSQDMX-Create')")
    @ApiOperation(value = "createBatch", tags = {"PCMBDSQDMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMBDSQDMXDTO> pcmbdsqdmxdtos) {
        pcmbdsqdmxService.createBatch(pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-ZZSQ-all')")
    @ApiOperation(value = "自助申请", tags = {"PCMBDSQDMX" },  notes = "自助申请")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/zzsq")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> zZSQ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.zZSQ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-SXDMB-all')")
    @ApiOperation(value = "职级降职代码表", tags = {"PCMBDSQDMX" },  notes = "职级降职代码表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxdmb")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> sXDMB(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.sXDMB(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-DGCZ-all')")
    @ApiOperation(value = "待岗操作", tags = {"PCMBDSQDMX" },  notes = "待岗操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/dgcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> dGCZ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.dGCZ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-SetPersonInfo-all')")
    @ApiOperation(value = "设置人员相关信息", tags = {"PCMBDSQDMX" },  notes = "设置人员相关信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/setpersoninfo")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> setPersonInfo(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.setPersonInfo(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-GZCZ-all')")
    @ApiOperation(value = "挂职操作", tags = {"PCMBDSQDMX" },  notes = "挂职操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/gzcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> gZCZ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.gZCZ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-JPCZ-all')")
    @ApiOperation(value = "解聘操作", tags = {"PCMBDSQDMX" },  notes = "解聘操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/jpcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> jPCZ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.jPCZ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdto),'ehr-PCMBDSQDMX-Save')")
    @ApiOperation(value = "Save", tags = {"PCMBDSQDMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.save(pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto)));
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdtos),'ehr-PCMBDSQDMX-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"PCMBDSQDMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMBDSQDMXDTO> pcmbdsqdmxdtos) {
        pcmbdsqdmxService.saveBatch(pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-LZCZ-all')")
    @ApiOperation(value = "离职操作", tags = {"PCMBDSQDMX" },  notes = "离职操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/lzcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> lZCZ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.lZCZ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-NTCZ-all')")
    @ApiOperation(value = "内退操作", tags = {"PCMBDSQDMX" },  notes = "内退操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/ntcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> nTCZ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.nTCZ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.get(#pcmbdsqdmx_id),'ehr-PCMBDSQDMX-Update')")
    @ApiOperation(value = "Update", tags = {"PCMBDSQDMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> update(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
		PCMBDSQDMX domain  = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain .setPcmbdsqdmxid(pcmbdsqdmx_id);
		pcmbdsqdmxService.update(domain );
		PCMBDSQDMXDTO dto = pcmbdsqdmxMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.getPcmbdsqdmxByEntities(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdtos)),'ehr-PCMBDSQDMX-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMBDSQDMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMBDSQDMXDTO> pcmbdsqdmxdtos) {
        pcmbdsqdmxService.updateBatch(pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(returnObject.body),'ehr-PCMBDSQDMX-Get')")
    @ApiOperation(value = "Get", tags = {"PCMBDSQDMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    public ResponseEntity<PCMBDSQDMXDTO> get(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id) {
        PCMBDSQDMX domain = pcmbdsqdmxService.get(pcmbdsqdmx_id);
        PCMBDSQDMXDTO dto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.get(#pcmbdsqdmx_id),'ehr-PCMBDSQDMX-Remove')")
    @ApiOperation(value = "Remove", tags = {"PCMBDSQDMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.remove(pcmbdsqdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.getPcmbdsqdmxByIds(#ids),'ehr-PCMBDSQDMX-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"PCMBDSQDMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmbdsqdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraft", tags = {"PCMBDSQDMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmbdsqdmxes/getdraft")
    public ResponseEntity<PCMBDSQDMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxMapping.toDto(pcmbdsqdmxService.getDraft(new PCMBDSQDMX())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-SHBTG-all')")
    @ApiOperation(value = "审核不通过", tags = {"PCMBDSQDMX" },  notes = "审核不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/shbtg")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> sHBTG(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.sHBTG(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-ZJBDCZ-all')")
    @ApiOperation(value = "职级变动操作", tags = {"PCMBDSQDMX" },  notes = "职级变动操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/zjbdcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> zJBDCZ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.zJBDCZ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @ApiOperation(value = "CheckKey", tags = {"PCMBDSQDMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.checkKey(pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-TXCZ-all')")
    @ApiOperation(value = "退休操作", tags = {"PCMBDSQDMX" },  notes = "退休操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/txcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> tXCZ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.tXCZ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-JZJJSDMB-all')")
    @ApiOperation(value = "局职级晋升代码表", tags = {"PCMBDSQDMX" },  notes = "局职级晋升代码表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/jzjjsdmb")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> jZJJSDMB(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.jZJJSDMB(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-SHTG-all')")
    @ApiOperation(value = "审核通过", tags = {"PCMBDSQDMX" },  notes = "审核通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/shtg")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> sHTG(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx.setPcmbdsqdmxid(pcmbdsqdmx_id);
        pcmbdsqdmx = pcmbdsqdmxService.sHTG(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-JPSQMX-all')")
	@ApiOperation(value = "fetch解聘申请（未审核）", tags = {"PCMBDSQDMX" } ,notes = "fetch解聘申请（未审核）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/fetchjpsqmx")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchJPSQMX(PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchJPSQMX(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-JPSQMX-all')")
	@ApiOperation(value = "search解聘申请（未审核）", tags = {"PCMBDSQDMX" } ,notes = "search解聘申请（未审核）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqdmxes/searchjpsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchJPSQMX(@RequestBody PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchJPSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-NTSQMX-all')")
	@ApiOperation(value = "fetch内退申请明细（未审核）", tags = {"PCMBDSQDMX" } ,notes = "fetch内退申请明细（未审核）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/fetchntsqmx")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchNTSQMX(PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchNTSQMX(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-NTSQMX-all')")
	@ApiOperation(value = "search内退申请明细（未审核）", tags = {"PCMBDSQDMX" } ,notes = "search内退申请明细（未审核）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqdmxes/searchntsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchNTSQMX(@RequestBody PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchNTSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-NTSQMXGR-all')")
	@ApiOperation(value = "fetch内退申请明细（个人）", tags = {"PCMBDSQDMX" } ,notes = "fetch内退申请明细（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/fetchntsqmxgr")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchNTSQMXGR(PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchNTSQMXGR(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-NTSQMXGR-all')")
	@ApiOperation(value = "search内退申请明细（个人）", tags = {"PCMBDSQDMX" } ,notes = "search内退申请明细（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqdmxes/searchntsqmxgr")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchNTSQMXGR(@RequestBody PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchNTSQMXGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-TXSQMX-all')")
	@ApiOperation(value = "fetch退休申请明细（未审核）", tags = {"PCMBDSQDMX" } ,notes = "fetch退休申请明细（未审核）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/fetchtxsqmx")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchTXSQMX(PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchTXSQMX(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-TXSQMX-all')")
	@ApiOperation(value = "search退休申请明细（未审核）", tags = {"PCMBDSQDMX" } ,notes = "search退休申请明细（未审核）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqdmxes/searchtxsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchTXSQMX(@RequestBody PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchTXSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-GZSQMX-all')")
	@ApiOperation(value = "fetch挂职申请明细（未审核）", tags = {"PCMBDSQDMX" } ,notes = "fetch挂职申请明细（未审核）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/fetchgzsqmx")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchGZSQMX(PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchGZSQMX(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-GZSQMX-all')")
	@ApiOperation(value = "search挂职申请明细（未审核）", tags = {"PCMBDSQDMX" } ,notes = "search挂职申请明细（未审核）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqdmxes/searchgzsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchGZSQMX(@RequestBody PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchGZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-ZJBDSQMX-all')")
	@ApiOperation(value = "fetch职级变动申请明细", tags = {"PCMBDSQDMX" } ,notes = "fetch职级变动申请明细")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/fetchzjbdsqmx")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchZJBDSQMX(PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchZJBDSQMX(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-ZJBDSQMX-all')")
	@ApiOperation(value = "search职级变动申请明细", tags = {"PCMBDSQDMX" } ,notes = "search职级变动申请明细")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqdmxes/searchzjbdsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchZJBDSQMX(@RequestBody PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchZJBDSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-DGSQMX-all')")
	@ApiOperation(value = "fetch待岗申请明细", tags = {"PCMBDSQDMX" } ,notes = "fetch待岗申请明细")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/fetchdgsqmx")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchDGSQMX(PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchDGSQMX(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-DGSQMX-all')")
	@ApiOperation(value = "search待岗申请明细", tags = {"PCMBDSQDMX" } ,notes = "search待岗申请明细")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqdmxes/searchdgsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchDGSQMX(@RequestBody PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchDGSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-CQBXSQMXDS-all')")
	@ApiOperation(value = "fetch长期病休申请明细", tags = {"PCMBDSQDMX" } ,notes = "fetch长期病休申请明细")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/fetchcqbxsqmxds")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchCQBXSQMXDS(PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchCQBXSQMXDS(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-CQBXSQMXDS-all')")
	@ApiOperation(value = "search长期病休申请明细", tags = {"PCMBDSQDMX" } ,notes = "search长期病休申请明细")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqdmxes/searchcqbxsqmxds")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchCQBXSQMXDS(@RequestBody PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchCQBXSQMXDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-LZSQMX-all')")
	@ApiOperation(value = "fetch离职申请明细", tags = {"PCMBDSQDMX" } ,notes = "fetch离职申请明细")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/fetchlzsqmx")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchLZSQMX(PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchLZSQMX(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-LZSQMX-all')")
	@ApiOperation(value = "search离职申请明细", tags = {"PCMBDSQDMX" } ,notes = "search离职申请明细")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqdmxes/searchlzsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchLZSQMX(@RequestBody PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchLZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-LZSQMXGR-all')")
	@ApiOperation(value = "fetch离职申请明细（个人）", tags = {"PCMBDSQDMX" } ,notes = "fetch离职申请明细（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/fetchlzsqmxgr")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchLZSQMXGR(PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchLZSQMXGR(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-LZSQMXGR-all')")
	@ApiOperation(value = "search离职申请明细（个人）", tags = {"PCMBDSQDMX" } ,notes = "search离职申请明细（个人）")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqdmxes/searchlzsqmxgr")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchLZSQMXGR(@RequestBody PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchLZSQMXGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"PCMBDSQDMX" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/fetchdefault")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchDefault(PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchDefault(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMBDSQDMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqdmxes/searchdefault")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchDefault(@RequestBody PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-ZJJSDMB-all')")
    @ApiOperation(value = "职级晋升代码表ByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "职级晋升代码表ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/zjjsdmb")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> zJJSDMBByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.zJJSDMB(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-CQBXCZ-all')")
    @ApiOperation(value = "长期病休操作ByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "长期病休操作ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/cqbxcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> cQBXCZByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.cQBXCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-SXJSDMB-all')")
    @ApiOperation(value = "ByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxjsdmb")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> sXJSDMBByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.sXJSDMB(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-PDZJ-all')")
    @ApiOperation(value = "判断职级ByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "判断职级ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/pdzj")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> pDZJByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.pDZJ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-SXJSDMB2-all')")
    @ApiOperation(value = "刷新代码表ByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "刷新代码表ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxjsdmb2")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> sXJSDMB2ByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.sXJSDMB2(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdto),'ehr-PCMBDSQDMX-Create')")
    @ApiOperation(value = "CreateByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "CreateByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> createByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
		pcmbdsqdmxService.create(domain);
        PCMBDSQDMXDTO dto = pcmbdsqdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdtos),'ehr-PCMBDSQDMX-Create')")
    @ApiOperation(value = "createBatchByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "createBatchByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> createBatchByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody List<PCMBDSQDMXDTO> pcmbdsqdmxdtos) {
        List<PCMBDSQDMX> domainlist=pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos);
        for(PCMBDSQDMX domain:domainlist){
            domain.setPcmbdsqdid(pcmbdsqd_id);
        }
        pcmbdsqdmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-ZZSQ-all')")
    @ApiOperation(value = "自助申请ByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "自助申请ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/zzsq")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> zZSQByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.zZSQ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-SXDMB-all')")
    @ApiOperation(value = "职级降职代码表ByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "职级降职代码表ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxdmb")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> sXDMBByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.sXDMB(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-DGCZ-all')")
    @ApiOperation(value = "待岗操作ByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "待岗操作ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/dgcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> dGCZByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.dGCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-SetPersonInfo-all')")
    @ApiOperation(value = "设置人员相关信息ByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "设置人员相关信息ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/setpersoninfo")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> setPersonInfoByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.setPersonInfo(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-GZCZ-all')")
    @ApiOperation(value = "挂职操作ByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "挂职操作ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/gzcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> gZCZByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.gZCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-JPCZ-all')")
    @ApiOperation(value = "解聘操作ByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "解聘操作ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/jpcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> jPCZByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.jPCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdto),'ehr-PCMBDSQDMX-Save')")
    @ApiOperation(value = "SaveByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "SaveByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/save")
    public ResponseEntity<Boolean> saveByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdtos),'ehr-PCMBDSQDMX-Save')")
    @ApiOperation(value = "SaveBatchByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "SaveBatchByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody List<PCMBDSQDMXDTO> pcmbdsqdmxdtos) {
        List<PCMBDSQDMX> domainlist=pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos);
        for(PCMBDSQDMX domain:domainlist){
             domain.setPcmbdsqdid(pcmbdsqd_id);
        }
        pcmbdsqdmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-LZCZ-all')")
    @ApiOperation(value = "离职操作ByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "离职操作ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/lzcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> lZCZByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.lZCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-NTCZ-all')")
    @ApiOperation(value = "内退操作ByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "内退操作ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/ntcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> nTCZByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.nTCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.get(#pcmbdsqdmx_id),'ehr-PCMBDSQDMX-Update')")
    @ApiOperation(value = "UpdateByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "UpdateByPCMBDSQD")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> updateByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain.setPcmbdsqdmxid(pcmbdsqdmx_id);
		pcmbdsqdmxService.update(domain);
        PCMBDSQDMXDTO dto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.getPcmbdsqdmxByEntities(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdtos)),'ehr-PCMBDSQDMX-Update')")
    @ApiOperation(value = "UpdateBatchByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "UpdateBatchByPCMBDSQD")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody List<PCMBDSQDMXDTO> pcmbdsqdmxdtos) {
        List<PCMBDSQDMX> domainlist=pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos);
        for(PCMBDSQDMX domain:domainlist){
            domain.setPcmbdsqdid(pcmbdsqd_id);
        }
        pcmbdsqdmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(returnObject.body),'ehr-PCMBDSQDMX-Get')")
    @ApiOperation(value = "GetByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "GetByPCMBDSQD")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    public ResponseEntity<PCMBDSQDMXDTO> getByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id) {
        PCMBDSQDMX domain = pcmbdsqdmxService.get(pcmbdsqdmx_id);
        PCMBDSQDMXDTO dto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.get(#pcmbdsqdmx_id),'ehr-PCMBDSQDMX-Remove')")
    @ApiOperation(value = "RemoveByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "RemoveByPCMBDSQD")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.remove(pcmbdsqdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.getPcmbdsqdmxByIds(#ids),'ehr-PCMBDSQDMX-Remove')")
    @ApiOperation(value = "RemoveBatchByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "RemoveBatchByPCMBDSQD")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPCMBDSQD(@RequestBody List<String> ids) {
        pcmbdsqdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "GetDraftByPCMBDSQD")
    @RequestMapping(method = RequestMethod.GET, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/getdraft")
    public ResponseEntity<PCMBDSQDMXDTO> getDraftByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id) {
        PCMBDSQDMX domain = new PCMBDSQDMX();
        domain.setPcmbdsqdid(pcmbdsqd_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxMapping.toDto(pcmbdsqdmxService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-SHBTG-all')")
    @ApiOperation(value = "审核不通过ByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "审核不通过ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/shbtg")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> sHBTGByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.sHBTG(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-ZJBDCZ-all')")
    @ApiOperation(value = "职级变动操作ByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "职级变动操作ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/zjbdcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> zJBDCZByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.zJBDCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @ApiOperation(value = "CheckKeyByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "CheckKeyByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.checkKey(pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-TXCZ-all')")
    @ApiOperation(value = "退休操作ByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "退休操作ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/txcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> tXCZByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.tXCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-JZJJSDMB-all')")
    @ApiOperation(value = "局职级晋升代码表ByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "局职级晋升代码表ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/jzjjsdmb")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> jZJJSDMBByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.jZJJSDMB(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-SHTG-all')")
    @ApiOperation(value = "审核通过ByPCMBDSQD", tags = {"PCMBDSQDMX" },  notes = "审核通过ByPCMBDSQD")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/shtg")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> sHTGByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdid(pcmbdsqd_id);
        domain = pcmbdsqdmxService.sHTG(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-JPSQMX-all')")
	@ApiOperation(value = "fetch解聘申请（未审核）ByPCMBDSQD", tags = {"PCMBDSQDMX" } ,notes = "fetch解聘申请（未审核）ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchjpsqmx")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchPCMBDSQDMXJPSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PCMBDSQDMXSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchJPSQMX(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-JPSQMX-all')")
	@ApiOperation(value = "search解聘申请（未审核）ByPCMBDSQD", tags = {"PCMBDSQDMX" } ,notes = "search解聘申请（未审核）ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchjpsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchPCMBDSQDMXJPSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PCMBDSQDMXSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchJPSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-NTSQMX-all')")
	@ApiOperation(value = "fetch内退申请明细（未审核）ByPCMBDSQD", tags = {"PCMBDSQDMX" } ,notes = "fetch内退申请明细（未审核）ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchntsqmx")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchPCMBDSQDMXNTSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PCMBDSQDMXSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchNTSQMX(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-NTSQMX-all')")
	@ApiOperation(value = "search内退申请明细（未审核）ByPCMBDSQD", tags = {"PCMBDSQDMX" } ,notes = "search内退申请明细（未审核）ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchntsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchPCMBDSQDMXNTSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PCMBDSQDMXSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchNTSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-NTSQMXGR-all')")
	@ApiOperation(value = "fetch内退申请明细（个人）ByPCMBDSQD", tags = {"PCMBDSQDMX" } ,notes = "fetch内退申请明细（个人）ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchntsqmxgr")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchPCMBDSQDMXNTSQMXGRByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PCMBDSQDMXSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchNTSQMXGR(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-NTSQMXGR-all')")
	@ApiOperation(value = "search内退申请明细（个人）ByPCMBDSQD", tags = {"PCMBDSQDMX" } ,notes = "search内退申请明细（个人）ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchntsqmxgr")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchPCMBDSQDMXNTSQMXGRByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PCMBDSQDMXSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchNTSQMXGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-TXSQMX-all')")
	@ApiOperation(value = "fetch退休申请明细（未审核）ByPCMBDSQD", tags = {"PCMBDSQDMX" } ,notes = "fetch退休申请明细（未审核）ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchtxsqmx")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchPCMBDSQDMXTXSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PCMBDSQDMXSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchTXSQMX(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-TXSQMX-all')")
	@ApiOperation(value = "search退休申请明细（未审核）ByPCMBDSQD", tags = {"PCMBDSQDMX" } ,notes = "search退休申请明细（未审核）ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchtxsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchPCMBDSQDMXTXSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PCMBDSQDMXSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchTXSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-GZSQMX-all')")
	@ApiOperation(value = "fetch挂职申请明细（未审核）ByPCMBDSQD", tags = {"PCMBDSQDMX" } ,notes = "fetch挂职申请明细（未审核）ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchgzsqmx")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchPCMBDSQDMXGZSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PCMBDSQDMXSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchGZSQMX(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-GZSQMX-all')")
	@ApiOperation(value = "search挂职申请明细（未审核）ByPCMBDSQD", tags = {"PCMBDSQDMX" } ,notes = "search挂职申请明细（未审核）ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchgzsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchPCMBDSQDMXGZSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PCMBDSQDMXSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchGZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-ZJBDSQMX-all')")
	@ApiOperation(value = "fetch职级变动申请明细ByPCMBDSQD", tags = {"PCMBDSQDMX" } ,notes = "fetch职级变动申请明细ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchzjbdsqmx")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchPCMBDSQDMXZJBDSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PCMBDSQDMXSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchZJBDSQMX(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-ZJBDSQMX-all')")
	@ApiOperation(value = "search职级变动申请明细ByPCMBDSQD", tags = {"PCMBDSQDMX" } ,notes = "search职级变动申请明细ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchzjbdsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchPCMBDSQDMXZJBDSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PCMBDSQDMXSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchZJBDSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-DGSQMX-all')")
	@ApiOperation(value = "fetch待岗申请明细ByPCMBDSQD", tags = {"PCMBDSQDMX" } ,notes = "fetch待岗申请明细ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchdgsqmx")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchPCMBDSQDMXDGSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PCMBDSQDMXSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchDGSQMX(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-DGSQMX-all')")
	@ApiOperation(value = "search待岗申请明细ByPCMBDSQD", tags = {"PCMBDSQDMX" } ,notes = "search待岗申请明细ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchdgsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchPCMBDSQDMXDGSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PCMBDSQDMXSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchDGSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-CQBXSQMXDS-all')")
	@ApiOperation(value = "fetch长期病休申请明细ByPCMBDSQD", tags = {"PCMBDSQDMX" } ,notes = "fetch长期病休申请明细ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchcqbxsqmxds")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchPCMBDSQDMXCQBXSQMXDSByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PCMBDSQDMXSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchCQBXSQMXDS(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-CQBXSQMXDS-all')")
	@ApiOperation(value = "search长期病休申请明细ByPCMBDSQD", tags = {"PCMBDSQDMX" } ,notes = "search长期病休申请明细ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchcqbxsqmxds")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchPCMBDSQDMXCQBXSQMXDSByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PCMBDSQDMXSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchCQBXSQMXDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-LZSQMX-all')")
	@ApiOperation(value = "fetch离职申请明细ByPCMBDSQD", tags = {"PCMBDSQDMX" } ,notes = "fetch离职申请明细ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchlzsqmx")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchPCMBDSQDMXLZSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PCMBDSQDMXSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchLZSQMX(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-LZSQMX-all')")
	@ApiOperation(value = "search离职申请明细ByPCMBDSQD", tags = {"PCMBDSQDMX" } ,notes = "search离职申请明细ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchlzsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchPCMBDSQDMXLZSQMXByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PCMBDSQDMXSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchLZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-LZSQMXGR-all')")
	@ApiOperation(value = "fetch离职申请明细（个人）ByPCMBDSQD", tags = {"PCMBDSQDMX" } ,notes = "fetch离职申请明细（个人）ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchlzsqmxgr")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchPCMBDSQDMXLZSQMXGRByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PCMBDSQDMXSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchLZSQMXGR(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-LZSQMXGR-all')")
	@ApiOperation(value = "search离职申请明细（个人）ByPCMBDSQD", tags = {"PCMBDSQDMX" } ,notes = "search离职申请明细（个人）ByPCMBDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchlzsqmxgr")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchPCMBDSQDMXLZSQMXGRByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PCMBDSQDMXSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchLZSQMXGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPCMBDSQD", tags = {"PCMBDSQDMX" } ,notes = "fetchDEFAULTByPCMBDSQD")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/fetchdefault")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchPCMBDSQDMXDefaultByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id,PCMBDSQDMXSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchDefault(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPCMBDSQD", tags = {"PCMBDSQDMX" } ,notes = "searchDEFAULTByPCMBDSQD")
    @RequestMapping(method= RequestMethod.POST , value="/pcmbdsqds/{pcmbdsqd_id}/pcmbdsqdmxes/searchdefault")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchPCMBDSQDMXDefaultByPCMBDSQD(@PathVariable("pcmbdsqd_id") String pcmbdsqd_id, @RequestBody PCMBDSQDMXSearchContext context) {
        context.setN_pcmbdsqdid_eq(pcmbdsqd_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-ZJJSDMB-all')")
    @ApiOperation(value = "职级晋升代码表ByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "职级晋升代码表ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/zjjsdmb")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> zJJSDMBByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.zJJSDMB(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-CQBXCZ-all')")
    @ApiOperation(value = "长期病休操作ByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "长期病休操作ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/cqbxcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> cQBXCZByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.cQBXCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-SXJSDMB-all')")
    @ApiOperation(value = "ByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxjsdmb")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> sXJSDMBByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.sXJSDMB(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-PDZJ-all')")
    @ApiOperation(value = "判断职级ByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "判断职级ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/pdzj")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> pDZJByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.pDZJ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-SXJSDMB2-all')")
    @ApiOperation(value = "刷新代码表ByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "刷新代码表ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxjsdmb2")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> sXJSDMB2ByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.sXJSDMB2(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdto),'ehr-PCMBDSQDMX-Create')")
    @ApiOperation(value = "CreateByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "CreateByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> createByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
		pcmbdsqdmxService.create(domain);
        PCMBDSQDMXDTO dto = pcmbdsqdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdtos),'ehr-PCMBDSQDMX-Create')")
    @ApiOperation(value = "createBatchByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "createBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> createBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PCMBDSQDMXDTO> pcmbdsqdmxdtos) {
        List<PCMBDSQDMX> domainlist=pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos);
        for(PCMBDSQDMX domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pcmbdsqdmxService.createBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-ZZSQ-all')")
    @ApiOperation(value = "自助申请ByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "自助申请ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/zzsq")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> zZSQByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.zZSQ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-SXDMB-all')")
    @ApiOperation(value = "职级降职代码表ByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "职级降职代码表ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxdmb")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> sXDMBByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.sXDMB(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-DGCZ-all')")
    @ApiOperation(value = "待岗操作ByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "待岗操作ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/dgcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> dGCZByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.dGCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-SetPersonInfo-all')")
    @ApiOperation(value = "设置人员相关信息ByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "设置人员相关信息ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/setpersoninfo")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> setPersonInfoByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.setPersonInfo(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-GZCZ-all')")
    @ApiOperation(value = "挂职操作ByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "挂职操作ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/gzcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> gZCZByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.gZCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-JPCZ-all')")
    @ApiOperation(value = "解聘操作ByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "解聘操作ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/jpcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> jPCZByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.jPCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdto),'ehr-PCMBDSQDMX-Save')")
    @ApiOperation(value = "SaveByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "SaveByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/save")
    public ResponseEntity<Boolean> saveByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.save(domain));
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdtos),'ehr-PCMBDSQDMX-Save')")
    @ApiOperation(value = "SaveBatchByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "SaveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PCMBDSQDMXDTO> pcmbdsqdmxdtos) {
        List<PCMBDSQDMX> domainlist=pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos);
        for(PCMBDSQDMX domain:domainlist){
             domain.setPimpersonid(pimperson_id);
        }
        pcmbdsqdmxService.saveBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-LZCZ-all')")
    @ApiOperation(value = "离职操作ByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "离职操作ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/lzcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> lZCZByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.lZCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-NTCZ-all')")
    @ApiOperation(value = "内退操作ByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "内退操作ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/ntcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> nTCZByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.nTCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.get(#pcmbdsqdmx_id),'ehr-PCMBDSQDMX-Update')")
    @ApiOperation(value = "UpdateByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "UpdateByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> updateByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain.setPcmbdsqdmxid(pcmbdsqdmx_id);
		pcmbdsqdmxService.update(domain);
        PCMBDSQDMXDTO dto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.getPcmbdsqdmxByEntities(this.pcmbdsqdmxMapping.toDomain(#pcmbdsqdmxdtos)),'ehr-PCMBDSQDMX-Update')")
    @ApiOperation(value = "UpdateBatchByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "UpdateBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> updateBatchByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody List<PCMBDSQDMXDTO> pcmbdsqdmxdtos) {
        List<PCMBDSQDMX> domainlist=pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos);
        for(PCMBDSQDMX domain:domainlist){
            domain.setPimpersonid(pimperson_id);
        }
        pcmbdsqdmxService.updateBatch(domainlist);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.pcmbdsqdmxMapping.toDomain(returnObject.body),'ehr-PCMBDSQDMX-Get')")
    @ApiOperation(value = "GetByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "GetByPIMPERSON")
	@RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    public ResponseEntity<PCMBDSQDMXDTO> getByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id) {
        PCMBDSQDMX domain = pcmbdsqdmxService.get(pcmbdsqdmx_id);
        PCMBDSQDMXDTO dto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.get(#pcmbdsqdmx_id),'ehr-PCMBDSQDMX-Remove')")
    @ApiOperation(value = "RemoveByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "RemoveByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> removeByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id) {
		return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.remove(pcmbdsqdmx_id));
    }

    @PreAuthorize("hasPermission(this.pcmbdsqdmxService.getPcmbdsqdmxByIds(#ids),'ehr-PCMBDSQDMX-Remove')")
    @ApiOperation(value = "RemoveBatchByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "RemoveBatchByPIMPERSON")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> removeBatchByPIMPERSON(@RequestBody List<String> ids) {
        pcmbdsqdmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "GetDraftByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "GetDraftByPIMPERSON")
    @RequestMapping(method = RequestMethod.GET, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/getdraft")
    public ResponseEntity<PCMBDSQDMXDTO> getDraftByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id) {
        PCMBDSQDMX domain = new PCMBDSQDMX();
        domain.setPimpersonid(pimperson_id);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxMapping.toDto(pcmbdsqdmxService.getDraft(domain)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-SHBTG-all')")
    @ApiOperation(value = "审核不通过ByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "审核不通过ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/shbtg")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> sHBTGByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.sHBTG(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-ZJBDCZ-all')")
    @ApiOperation(value = "职级变动操作ByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "职级变动操作ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/zjbdcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> zJBDCZByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.zJBDCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @ApiOperation(value = "CheckKeyByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "CheckKeyByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/checkkey")
    public ResponseEntity<Boolean> checkKeyByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.checkKey(pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-TXCZ-all')")
    @ApiOperation(value = "退休操作ByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "退休操作ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/txcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> tXCZByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.tXCZ(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-JZJJSDMB-all')")
    @ApiOperation(value = "局职级晋升代码表ByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "局职级晋升代码表ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/jzjjsdmb")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> jZJJSDMBByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.jZJJSDMB(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-SHTG-all')")
    @ApiOperation(value = "审核通过ByPIMPERSON", tags = {"PCMBDSQDMX" },  notes = "审核通过ByPIMPERSON")
	@RequestMapping(method = RequestMethod.POST, value = "/pimpeople/{pimperson_id}/pcmbdsqdmxes/{pcmbdsqdmx_id}/shtg")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> sHTGByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPimpersonid(pimperson_id);
        domain = pcmbdsqdmxService.sHTG(domain) ;
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-JPSQMX-all')")
	@ApiOperation(value = "fetch解聘申请（未审核）ByPIMPERSON", tags = {"PCMBDSQDMX" } ,notes = "fetch解聘申请（未审核）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchjpsqmx")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchPCMBDSQDMXJPSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PCMBDSQDMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchJPSQMX(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-JPSQMX-all')")
	@ApiOperation(value = "search解聘申请（未审核）ByPIMPERSON", tags = {"PCMBDSQDMX" } ,notes = "search解聘申请（未审核）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchjpsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchPCMBDSQDMXJPSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PCMBDSQDMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchJPSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-NTSQMX-all')")
	@ApiOperation(value = "fetch内退申请明细（未审核）ByPIMPERSON", tags = {"PCMBDSQDMX" } ,notes = "fetch内退申请明细（未审核）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchntsqmx")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchPCMBDSQDMXNTSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PCMBDSQDMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchNTSQMX(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-NTSQMX-all')")
	@ApiOperation(value = "search内退申请明细（未审核）ByPIMPERSON", tags = {"PCMBDSQDMX" } ,notes = "search内退申请明细（未审核）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchntsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchPCMBDSQDMXNTSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PCMBDSQDMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchNTSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-NTSQMXGR-all')")
	@ApiOperation(value = "fetch内退申请明细（个人）ByPIMPERSON", tags = {"PCMBDSQDMX" } ,notes = "fetch内退申请明细（个人）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchntsqmxgr")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchPCMBDSQDMXNTSQMXGRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PCMBDSQDMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchNTSQMXGR(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-NTSQMXGR-all')")
	@ApiOperation(value = "search内退申请明细（个人）ByPIMPERSON", tags = {"PCMBDSQDMX" } ,notes = "search内退申请明细（个人）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchntsqmxgr")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchPCMBDSQDMXNTSQMXGRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PCMBDSQDMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchNTSQMXGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-TXSQMX-all')")
	@ApiOperation(value = "fetch退休申请明细（未审核）ByPIMPERSON", tags = {"PCMBDSQDMX" } ,notes = "fetch退休申请明细（未审核）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchtxsqmx")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchPCMBDSQDMXTXSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PCMBDSQDMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchTXSQMX(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-TXSQMX-all')")
	@ApiOperation(value = "search退休申请明细（未审核）ByPIMPERSON", tags = {"PCMBDSQDMX" } ,notes = "search退休申请明细（未审核）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchtxsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchPCMBDSQDMXTXSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PCMBDSQDMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchTXSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-GZSQMX-all')")
	@ApiOperation(value = "fetch挂职申请明细（未审核）ByPIMPERSON", tags = {"PCMBDSQDMX" } ,notes = "fetch挂职申请明细（未审核）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchgzsqmx")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchPCMBDSQDMXGZSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PCMBDSQDMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchGZSQMX(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-GZSQMX-all')")
	@ApiOperation(value = "search挂职申请明细（未审核）ByPIMPERSON", tags = {"PCMBDSQDMX" } ,notes = "search挂职申请明细（未审核）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchgzsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchPCMBDSQDMXGZSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PCMBDSQDMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchGZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-ZJBDSQMX-all')")
	@ApiOperation(value = "fetch职级变动申请明细ByPIMPERSON", tags = {"PCMBDSQDMX" } ,notes = "fetch职级变动申请明细ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchzjbdsqmx")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchPCMBDSQDMXZJBDSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PCMBDSQDMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchZJBDSQMX(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-ZJBDSQMX-all')")
	@ApiOperation(value = "search职级变动申请明细ByPIMPERSON", tags = {"PCMBDSQDMX" } ,notes = "search职级变动申请明细ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchzjbdsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchPCMBDSQDMXZJBDSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PCMBDSQDMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchZJBDSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-DGSQMX-all')")
	@ApiOperation(value = "fetch待岗申请明细ByPIMPERSON", tags = {"PCMBDSQDMX" } ,notes = "fetch待岗申请明细ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchdgsqmx")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchPCMBDSQDMXDGSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PCMBDSQDMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchDGSQMX(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-DGSQMX-all')")
	@ApiOperation(value = "search待岗申请明细ByPIMPERSON", tags = {"PCMBDSQDMX" } ,notes = "search待岗申请明细ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchdgsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchPCMBDSQDMXDGSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PCMBDSQDMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchDGSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-CQBXSQMXDS-all')")
	@ApiOperation(value = "fetch长期病休申请明细ByPIMPERSON", tags = {"PCMBDSQDMX" } ,notes = "fetch长期病休申请明细ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchcqbxsqmxds")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchPCMBDSQDMXCQBXSQMXDSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PCMBDSQDMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchCQBXSQMXDS(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-CQBXSQMXDS-all')")
	@ApiOperation(value = "search长期病休申请明细ByPIMPERSON", tags = {"PCMBDSQDMX" } ,notes = "search长期病休申请明细ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchcqbxsqmxds")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchPCMBDSQDMXCQBXSQMXDSByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PCMBDSQDMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchCQBXSQMXDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-LZSQMX-all')")
	@ApiOperation(value = "fetch离职申请明细ByPIMPERSON", tags = {"PCMBDSQDMX" } ,notes = "fetch离职申请明细ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchlzsqmx")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchPCMBDSQDMXLZSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PCMBDSQDMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchLZSQMX(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-LZSQMX-all')")
	@ApiOperation(value = "search离职申请明细ByPIMPERSON", tags = {"PCMBDSQDMX" } ,notes = "search离职申请明细ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchlzsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchPCMBDSQDMXLZSQMXByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PCMBDSQDMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchLZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-LZSQMXGR-all')")
	@ApiOperation(value = "fetch离职申请明细（个人）ByPIMPERSON", tags = {"PCMBDSQDMX" } ,notes = "fetch离职申请明细（个人）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchlzsqmxgr")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchPCMBDSQDMXLZSQMXGRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PCMBDSQDMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchLZSQMXGR(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-LZSQMXGR-all')")
	@ApiOperation(value = "search离职申请明细（个人）ByPIMPERSON", tags = {"PCMBDSQDMX" } ,notes = "search离职申请明细（个人）ByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchlzsqmxgr")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchPCMBDSQDMXLZSQMXGRByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PCMBDSQDMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchLZSQMXGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-Default-all')")
	@ApiOperation(value = "fetchDEFAULTByPIMPERSON", tags = {"PCMBDSQDMX" } ,notes = "fetchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.GET , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/fetchdefault")
	public ResponseEntity<List<PCMBDSQDMXDTO>> fetchPCMBDSQDMXDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id,PCMBDSQDMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchDefault(context) ;
        List<PCMBDSQDMXDTO> list = pcmbdsqdmxMapping.toDto(domains.getContent());
	    return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMBDSQDMX-Default-all')")
	@ApiOperation(value = "searchDEFAULTByPIMPERSON", tags = {"PCMBDSQDMX" } ,notes = "searchDEFAULTByPIMPERSON")
    @RequestMapping(method= RequestMethod.POST , value="/pimpeople/{pimperson_id}/pcmbdsqdmxes/searchdefault")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchPCMBDSQDMXDefaultByPIMPERSON(@PathVariable("pimperson_id") String pimperson_id, @RequestBody PCMBDSQDMXSearchContext context) {
        context.setN_pimpersonid_eq(pimperson_id);
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

