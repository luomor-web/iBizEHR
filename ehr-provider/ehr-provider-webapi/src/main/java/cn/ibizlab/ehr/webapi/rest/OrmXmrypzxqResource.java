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
import cn.ibizlab.ehr.core.orm.domain.OrmXmrypzxq;
import cn.ibizlab.ehr.core.orm.service.IOrmXmrypzxqService;
import cn.ibizlab.ehr.core.orm.filter.OrmXmrypzxqSearchContext;

@Slf4j
@Api(tags = {"OrmXmrypzxq" })
@RestController("WebApi-ormxmrypzxq")
@RequestMapping("")
public class OrmXmrypzxqResource {

    @Autowired
    public IOrmXmrypzxqService ormxmrypzxqService;

    @Autowired
    @Lazy
    public OrmXmrypzxqMapping ormxmrypzxqMapping;

    @ApiOperation(value = "GetDraft", tags = {"OrmXmrypzxq" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmrypzxqs/getdraft")
    public ResponseEntity<OrmXmrypzxqDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqMapping.toDto(ormxmrypzxqService.getDraft(new OrmXmrypzxq())));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-SynTJ-all')")
    @ApiOperation(value = "提交（拟用人员变更）", tags = {"OrmXmrypzxq" },  notes = "提交（拟用人员变更）")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/syntj")
    @Transactional
    public ResponseEntity<OrmXmrypzxqDTO> synTJ(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody OrmXmrypzxqDTO ormxmrypzxqdto) {
        OrmXmrypzxq ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq.setOrmxmrypzxqid(ormxmrypzxq_id);
        ormxmrypzxq = ormxmrypzxqService.synTJ(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-MODSPTG-all')")
    @ApiOperation(value = "审批通过（拟用人员变更）", tags = {"OrmXmrypzxq" },  notes = "审批通过（拟用人员变更）")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/modsptg")
    @Transactional
    public ResponseEntity<OrmXmrypzxqDTO> mODSPTG(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody OrmXmrypzxqDTO ormxmrypzxqdto) {
        OrmXmrypzxq ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq.setOrmxmrypzxqid(ormxmrypzxq_id);
        ormxmrypzxq = ormxmrypzxqService.mODSPTG(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }

    @ApiOperation(value = "CheckKey", tags = {"OrmXmrypzxq" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody OrmXmrypzxqDTO ormxmrypzxqdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqService.checkKey(ormxmrypzxqMapping.toDomain(ormxmrypzxqdto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-SFBH-all')")
    @ApiOperation(value = "驳回（释放）", tags = {"OrmXmrypzxq" },  notes = "驳回（释放）")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/sfbh")
    @Transactional
    public ResponseEntity<OrmXmrypzxqDTO> sFBH(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody OrmXmrypzxqDTO ormxmrypzxqdto) {
        OrmXmrypzxq ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq.setOrmxmrypzxqid(ormxmrypzxq_id);
        ormxmrypzxq = ormxmrypzxqService.sFBH(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-Ensure-all')")
    @ApiOperation(value = "确认", tags = {"OrmXmrypzxq" },  notes = "确认")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/ensure")
    @Transactional
    public ResponseEntity<OrmXmrypzxqDTO> ensure(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody OrmXmrypzxqDTO ormxmrypzxqdto) {
        OrmXmrypzxq ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq.setOrmxmrypzxqid(ormxmrypzxq_id);
        ormxmrypzxq = ormxmrypzxqService.ensure(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }

    @PostAuthorize("hasPermission(this.ormxmrypzxqMapping.toDomain(returnObject.body),'ehr-OrmXmrypzxq-Get')")
    @ApiOperation(value = "Get", tags = {"OrmXmrypzxq" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmrypzxqs/{ormxmrypzxq_id}")
    public ResponseEntity<OrmXmrypzxqDTO> get(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id) {
        OrmXmrypzxq domain = ormxmrypzxqService.get(ormxmrypzxq_id);
        OrmXmrypzxqDTO dto = ormxmrypzxqMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-SynDeployInfo-all')")
    @ApiOperation(value = "提交", tags = {"OrmXmrypzxq" },  notes = "提交")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/syndeployinfo")
    @Transactional
    public ResponseEntity<OrmXmrypzxqDTO> synDeployInfo(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody OrmXmrypzxqDTO ormxmrypzxqdto) {
        OrmXmrypzxq ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq.setOrmxmrypzxqid(ormxmrypzxq_id);
        ormxmrypzxq = ormxmrypzxqService.synDeployInfo(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-MODBH-all')")
    @ApiOperation(value = "驳回（拟用人员变更）", tags = {"OrmXmrypzxq" },  notes = "驳回（拟用人员变更）")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/modbh")
    @Transactional
    public ResponseEntity<OrmXmrypzxqDTO> mODBH(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody OrmXmrypzxqDTO ormxmrypzxqdto) {
        OrmXmrypzxq ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq.setOrmxmrypzxqid(ormxmrypzxq_id);
        ormxmrypzxq = ormxmrypzxqService.mODBH(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-SFQR-all')")
    @ApiOperation(value = "确认（释放）", tags = {"OrmXmrypzxq" },  notes = "确认（释放）")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/sfqr")
    @Transactional
    public ResponseEntity<OrmXmrypzxqDTO> sFQR(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody OrmXmrypzxqDTO ormxmrypzxqdto) {
        OrmXmrypzxq ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq.setOrmxmrypzxqid(ormxmrypzxq_id);
        ormxmrypzxq = ormxmrypzxqService.sFQR(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-SynPersonInfo-all')")
    @ApiOperation(value = "计算人员信息", tags = {"OrmXmrypzxq" },  notes = "计算人员信息")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/synpersoninfo")
    @Transactional
    public ResponseEntity<OrmXmrypzxqDTO> synPersonInfo(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody OrmXmrypzxqDTO ormxmrypzxqdto) {
        OrmXmrypzxq ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq.setOrmxmrypzxqid(ormxmrypzxq_id);
        ormxmrypzxq = ormxmrypzxqService.synPersonInfo(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }

    @PreAuthorize("hasPermission(this.ormxmrypzxqService.get(#ormxmrypzxq_id),'ehr-OrmXmrypzxq-Remove')")
    @ApiOperation(value = "Remove", tags = {"OrmXmrypzxq" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmrypzxqs/{ormxmrypzxq_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqService.remove(ormxmrypzxq_id));
    }

    @PreAuthorize("hasPermission(this.ormxmrypzxqService.getOrmxmrypzxqByIds(#ids),'ehr-OrmXmrypzxq-Remove')")
    @ApiOperation(value = "RemoveBatch", tags = {"OrmXmrypzxq" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmrypzxqs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormxmrypzxqService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-SynRelease-all')")
    @ApiOperation(value = "提交", tags = {"OrmXmrypzxq" },  notes = "提交")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/synrelease")
    @Transactional
    public ResponseEntity<OrmXmrypzxqDTO> synRelease(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody OrmXmrypzxqDTO ormxmrypzxqdto) {
        OrmXmrypzxq ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq.setOrmxmrypzxqid(ormxmrypzxq_id);
        ormxmrypzxq = ormxmrypzxqService.synRelease(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-SHTG-all')")
    @ApiOperation(value = "审核通过", tags = {"OrmXmrypzxq" },  notes = "审核通过")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/shtg")
    @Transactional
    public ResponseEntity<OrmXmrypzxqDTO> sHTG(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody OrmXmrypzxqDTO ormxmrypzxqdto) {
        OrmXmrypzxq ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq.setOrmxmrypzxqid(ormxmrypzxq_id);
        ormxmrypzxq = ormxmrypzxqService.sHTG(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-TPSPTG-all')")
    @ApiOperation(value = "审批通过（调配）", tags = {"OrmXmrypzxq" },  notes = "审批通过（调配）")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/tpsptg")
    @Transactional
    public ResponseEntity<OrmXmrypzxqDTO> tPSPTG(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody OrmXmrypzxqDTO ormxmrypzxqdto) {
        OrmXmrypzxq ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq.setOrmxmrypzxqid(ormxmrypzxq_id);
        ormxmrypzxq = ormxmrypzxqService.tPSPTG(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-BH-all')")
    @ApiOperation(value = "驳回", tags = {"OrmXmrypzxq" },  notes = "驳回")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/bh")
    @Transactional
    public ResponseEntity<OrmXmrypzxqDTO> bH(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody OrmXmrypzxqDTO ormxmrypzxqdto) {
        OrmXmrypzxq ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq.setOrmxmrypzxqid(ormxmrypzxq_id);
        ormxmrypzxq = ormxmrypzxqService.bH(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }

    @PreAuthorize("hasPermission(this.ormxmrypzxqMapping.toDomain(#ormxmrypzxqdto),'ehr-OrmXmrypzxq-Save')")
    @ApiOperation(value = "Save", tags = {"OrmXmrypzxq" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/save")
    public ResponseEntity<Boolean> save(@RequestBody OrmXmrypzxqDTO ormxmrypzxqdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqService.save(ormxmrypzxqMapping.toDomain(ormxmrypzxqdto)));
    }

    @PreAuthorize("hasPermission(this.ormxmrypzxqMapping.toDomain(#ormxmrypzxqdtos),'ehr-OrmXmrypzxq-Save')")
    @ApiOperation(value = "SaveBatch", tags = {"OrmXmrypzxq" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<OrmXmrypzxqDTO> ormxmrypzxqdtos) {
        ormxmrypzxqService.saveBatch(ormxmrypzxqMapping.toDomain(ormxmrypzxqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-SFSPTG-all')")
    @ApiOperation(value = "审批通过（释放）", tags = {"OrmXmrypzxq" },  notes = "审批通过（释放）")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/sfsptg")
    @Transactional
    public ResponseEntity<OrmXmrypzxqDTO> sFSPTG(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody OrmXmrypzxqDTO ormxmrypzxqdto) {
        OrmXmrypzxq ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq.setOrmxmrypzxqid(ormxmrypzxq_id);
        ormxmrypzxq = ormxmrypzxqService.sFSPTG(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-TPBH-all')")
    @ApiOperation(value = "驳回（调配）", tags = {"OrmXmrypzxq" },  notes = "驳回（调配）")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/tpbh")
    @Transactional
    public ResponseEntity<OrmXmrypzxqDTO> tPBH(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody OrmXmrypzxqDTO ormxmrypzxqdto) {
        OrmXmrypzxq ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq.setOrmxmrypzxqid(ormxmrypzxq_id);
        ormxmrypzxq = ormxmrypzxqService.tPBH(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-TPQR-all')")
    @ApiOperation(value = "确认（调配）", tags = {"OrmXmrypzxq" },  notes = "确认（调配）")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/tpqr")
    @Transactional
    public ResponseEntity<OrmXmrypzxqDTO> tPQR(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody OrmXmrypzxqDTO ormxmrypzxqdto) {
        OrmXmrypzxq ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq.setOrmxmrypzxqid(ormxmrypzxq_id);
        ormxmrypzxq = ormxmrypzxqService.tPQR(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }

    @PreAuthorize("hasPermission(this.ormxmrypzxqMapping.toDomain(#ormxmrypzxqdto),'ehr-OrmXmrypzxq-Create')")
    @ApiOperation(value = "Create", tags = {"OrmXmrypzxq" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs")
    @Transactional
    public ResponseEntity<OrmXmrypzxqDTO> create(@RequestBody OrmXmrypzxqDTO ormxmrypzxqdto) {
        OrmXmrypzxq domain = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
		ormxmrypzxqService.create(domain);
        OrmXmrypzxqDTO dto = ormxmrypzxqMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmrypzxqMapping.toDomain(#ormxmrypzxqdtos),'ehr-OrmXmrypzxq-Create')")
    @ApiOperation(value = "createBatch", tags = {"OrmXmrypzxq" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<OrmXmrypzxqDTO> ormxmrypzxqdtos) {
        ormxmrypzxqService.createBatch(ormxmrypzxqMapping.toDomain(ormxmrypzxqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.ormxmrypzxqService.get(#ormxmrypzxq_id),'ehr-OrmXmrypzxq-Update')")
    @ApiOperation(value = "Update", tags = {"OrmXmrypzxq" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmrypzxqs/{ormxmrypzxq_id}")
    @Transactional
    public ResponseEntity<OrmXmrypzxqDTO> update(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody OrmXmrypzxqDTO ormxmrypzxqdto) {
		OrmXmrypzxq domain  = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        domain .setOrmxmrypzxqid(ormxmrypzxq_id);
		ormxmrypzxqService.update(domain );
		OrmXmrypzxqDTO dto = ormxmrypzxqMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.ormxmrypzxqService.getOrmxmrypzxqByEntities(this.ormxmrypzxqMapping.toDomain(#ormxmrypzxqdtos)),'ehr-OrmXmrypzxq-Update')")
    @ApiOperation(value = "UpdateBatch", tags = {"OrmXmrypzxq" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmrypzxqs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<OrmXmrypzxqDTO> ormxmrypzxqdtos) {
        ormxmrypzxqService.updateBatch(ormxmrypzxqMapping.toDomain(ormxmrypzxqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-RSSH-all')")
	@ApiOperation(value = "fetch人事审核", tags = {"OrmXmrypzxq" } ,notes = "fetch人事审核")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmrypzxqs/fetchrssh")
	public ResponseEntity<List<OrmXmrypzxqDTO>> fetchRSSH(OrmXmrypzxqSearchContext context) {
        Page<OrmXmrypzxq> domains = ormxmrypzxqService.searchRSSH(context) ;
        List<OrmXmrypzxqDTO> list = ormxmrypzxqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-RSSH-all')")
	@ApiOperation(value = "search人事审核", tags = {"OrmXmrypzxq" } ,notes = "search人事审核")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmrypzxqs/searchrssh")
	public ResponseEntity<Page<OrmXmrypzxqDTO>> searchRSSH(@RequestBody OrmXmrypzxqSearchContext context) {
        Page<OrmXmrypzxq> domains = ormxmrypzxqService.searchRSSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmrypzxqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-CURFQTP-all')")
	@ApiOperation(value = "fetch判定调配", tags = {"OrmXmrypzxq" } ,notes = "fetch判定调配")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmrypzxqs/fetchcurfqtp")
	public ResponseEntity<List<OrmXmrypzxqDTO>> fetchCURFQTP(OrmXmrypzxqSearchContext context) {
        Page<OrmXmrypzxq> domains = ormxmrypzxqService.searchCURFQTP(context) ;
        List<OrmXmrypzxqDTO> list = ormxmrypzxqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-CURFQTP-all')")
	@ApiOperation(value = "search判定调配", tags = {"OrmXmrypzxq" } ,notes = "search判定调配")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmrypzxqs/searchcurfqtp")
	public ResponseEntity<Page<OrmXmrypzxqDTO>> searchCURFQTP(@RequestBody OrmXmrypzxqSearchContext context) {
        Page<OrmXmrypzxq> domains = ormxmrypzxqService.searchCURFQTP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmrypzxqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-CXSJ-all')")
	@ApiOperation(value = "fetch查询调配数据", tags = {"OrmXmrypzxq" } ,notes = "fetch查询调配数据")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmrypzxqs/fetchcxsj")
	public ResponseEntity<List<OrmXmrypzxqDTO>> fetchCXSJ(OrmXmrypzxqSearchContext context) {
        Page<OrmXmrypzxq> domains = ormxmrypzxqService.searchCXSJ(context) ;
        List<OrmXmrypzxqDTO> list = ormxmrypzxqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-CXSJ-all')")
	@ApiOperation(value = "search查询调配数据", tags = {"OrmXmrypzxq" } ,notes = "search查询调配数据")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmrypzxqs/searchcxsj")
	public ResponseEntity<Page<OrmXmrypzxqDTO>> searchCXSJ(@RequestBody OrmXmrypzxqSearchContext context) {
        Page<OrmXmrypzxq> domains = ormxmrypzxqService.searchCXSJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmrypzxqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-KZXMQX-all')")
	@ApiOperation(value = "fetch控制项目人员需求（修改、删除）权限", tags = {"OrmXmrypzxq" } ,notes = "fetch控制项目人员需求（修改、删除）权限")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmrypzxqs/fetchkzxmqx")
	public ResponseEntity<List<OrmXmrypzxqDTO>> fetchKZXMQX(OrmXmrypzxqSearchContext context) {
        Page<OrmXmrypzxq> domains = ormxmrypzxqService.searchKZXMQX(context) ;
        List<OrmXmrypzxqDTO> list = ormxmrypzxqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-KZXMQX-all')")
	@ApiOperation(value = "search控制项目人员需求（修改、删除）权限", tags = {"OrmXmrypzxq" } ,notes = "search控制项目人员需求（修改、删除）权限")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmrypzxqs/searchkzxmqx")
	public ResponseEntity<Page<OrmXmrypzxqDTO>> searchKZXMQX(@RequestBody OrmXmrypzxqSearchContext context) {
        Page<OrmXmrypzxq> domains = ormxmrypzxqService.searchKZXMQX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmrypzxqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-SFSH-all')")
	@ApiOperation(value = "fetch释放台账", tags = {"OrmXmrypzxq" } ,notes = "fetch释放台账")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmrypzxqs/fetchsfsh")
	public ResponseEntity<List<OrmXmrypzxqDTO>> fetchSFSH(OrmXmrypzxqSearchContext context) {
        Page<OrmXmrypzxq> domains = ormxmrypzxqService.searchSFSH(context) ;
        List<OrmXmrypzxqDTO> list = ormxmrypzxqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-SFSH-all')")
	@ApiOperation(value = "search释放台账", tags = {"OrmXmrypzxq" } ,notes = "search释放台账")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmrypzxqs/searchsfsh")
	public ResponseEntity<Page<OrmXmrypzxqDTO>> searchSFSH(@RequestBody OrmXmrypzxqSearchContext context) {
        Page<OrmXmrypzxq> domains = ormxmrypzxqService.searchSFSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmrypzxqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-CURFQSF-all')")
	@ApiOperation(value = "fetch判定释放", tags = {"OrmXmrypzxq" } ,notes = "fetch判定释放")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmrypzxqs/fetchcurfqsf")
	public ResponseEntity<List<OrmXmrypzxqDTO>> fetchCURFQSF(OrmXmrypzxqSearchContext context) {
        Page<OrmXmrypzxq> domains = ormxmrypzxqService.searchCURFQSF(context) ;
        List<OrmXmrypzxqDTO> list = ormxmrypzxqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-CURFQSF-all')")
	@ApiOperation(value = "search判定释放", tags = {"OrmXmrypzxq" } ,notes = "search判定释放")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmrypzxqs/searchcurfqsf")
	public ResponseEntity<Page<OrmXmrypzxqDTO>> searchCURFQSF(@RequestBody OrmXmrypzxqSearchContext context) {
        Page<OrmXmrypzxq> domains = ormxmrypzxqService.searchCURFQSF(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmrypzxqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-TPSH-all')")
	@ApiOperation(value = "fetch调配审核", tags = {"OrmXmrypzxq" } ,notes = "fetch调配审核")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmrypzxqs/fetchtpsh")
	public ResponseEntity<List<OrmXmrypzxqDTO>> fetchTPSH(OrmXmrypzxqSearchContext context) {
        Page<OrmXmrypzxq> domains = ormxmrypzxqService.searchTPSH(context) ;
        List<OrmXmrypzxqDTO> list = ormxmrypzxqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-TPSH-all')")
	@ApiOperation(value = "search调配审核", tags = {"OrmXmrypzxq" } ,notes = "search调配审核")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmrypzxqs/searchtpsh")
	public ResponseEntity<Page<OrmXmrypzxqDTO>> searchTPSH(@RequestBody OrmXmrypzxqSearchContext context) {
        Page<OrmXmrypzxq> domains = ormxmrypzxqService.searchTPSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmrypzxqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-SFCXSJ-all')")
	@ApiOperation(value = "fetch释放数据查询", tags = {"OrmXmrypzxq" } ,notes = "fetch释放数据查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmrypzxqs/fetchsfcxsj")
	public ResponseEntity<List<OrmXmrypzxqDTO>> fetchSFCXSJ(OrmXmrypzxqSearchContext context) {
        Page<OrmXmrypzxq> domains = ormxmrypzxqService.searchSFCXSJ(context) ;
        List<OrmXmrypzxqDTO> list = ormxmrypzxqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-SFCXSJ-all')")
	@ApiOperation(value = "search释放数据查询", tags = {"OrmXmrypzxq" } ,notes = "search释放数据查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmrypzxqs/searchsfcxsj")
	public ResponseEntity<Page<OrmXmrypzxqDTO>> searchSFCXSJ(@RequestBody OrmXmrypzxqSearchContext context) {
        Page<OrmXmrypzxq> domains = ormxmrypzxqService.searchSFCXSJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmrypzxqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-MODSPSH-all')")
	@ApiOperation(value = "fetch拟用人员变更审核", tags = {"OrmXmrypzxq" } ,notes = "fetch拟用人员变更审核")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmrypzxqs/fetchmodspsh")
	public ResponseEntity<List<OrmXmrypzxqDTO>> fetchMODSPSH(OrmXmrypzxqSearchContext context) {
        Page<OrmXmrypzxq> domains = ormxmrypzxqService.searchMODSPSH(context) ;
        List<OrmXmrypzxqDTO> list = ormxmrypzxqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-MODSPSH-all')")
	@ApiOperation(value = "search拟用人员变更审核", tags = {"OrmXmrypzxq" } ,notes = "search拟用人员变更审核")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmrypzxqs/searchmodspsh")
	public ResponseEntity<Page<OrmXmrypzxqDTO>> searchMODSPSH(@RequestBody OrmXmrypzxqSearchContext context) {
        Page<OrmXmrypzxq> domains = ormxmrypzxqService.searchMODSPSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmrypzxqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"OrmXmrypzxq" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmrypzxqs/fetchdefault")
	public ResponseEntity<List<OrmXmrypzxqDTO>> fetchDefault(OrmXmrypzxqSearchContext context) {
        Page<OrmXmrypzxq> domains = ormxmrypzxqService.searchDefault(context) ;
        List<OrmXmrypzxqDTO> list = ormxmrypzxqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"OrmXmrypzxq" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmrypzxqs/searchdefault")
	public ResponseEntity<Page<OrmXmrypzxqDTO>> searchDefault(@RequestBody OrmXmrypzxqSearchContext context) {
        Page<OrmXmrypzxq> domains = ormxmrypzxqService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmrypzxqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-XMCBMX-all')")
	@ApiOperation(value = "fetch项目人力成本明细", tags = {"OrmXmrypzxq" } ,notes = "fetch项目人力成本明细")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmrypzxqs/fetchxmcbmx")
	public ResponseEntity<List<OrmXmrypzxqDTO>> fetchXMCBMX(OrmXmrypzxqSearchContext context) {
        Page<OrmXmrypzxq> domains = ormxmrypzxqService.searchXMCBMX(context) ;
        List<OrmXmrypzxqDTO> list = ormxmrypzxqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-OrmXmrypzxq-XMCBMX-all')")
	@ApiOperation(value = "search项目人力成本明细", tags = {"OrmXmrypzxq" } ,notes = "search项目人力成本明细")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmrypzxqs/searchxmcbmx")
	public ResponseEntity<Page<OrmXmrypzxqDTO>> searchXMCBMX(@RequestBody OrmXmrypzxqSearchContext context) {
        Page<OrmXmrypzxq> domains = ormxmrypzxqService.searchXMCBMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmrypzxqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

