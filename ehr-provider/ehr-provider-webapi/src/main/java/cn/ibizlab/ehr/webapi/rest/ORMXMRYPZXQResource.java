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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import cn.ibizlab.ehr.webapi.dto.*;
import cn.ibizlab.ehr.webapi.mapping.*;
import cn.ibizlab.ehr.core.orm.domain.ORMXMRYPZXQ;
import cn.ibizlab.ehr.core.orm.service.IORMXMRYPZXQService;
import cn.ibizlab.ehr.core.orm.filter.ORMXMRYPZXQSearchContext;




@Slf4j
@Api(tags = {"ORMXMRYPZXQ" })
@RestController("WebApi-ormxmrypzxq")
@RequestMapping("")
public class ORMXMRYPZXQResource {

    @Autowired
    private IORMXMRYPZXQService ormxmrypzxqService;

    @Autowired
    @Lazy
    private ORMXMRYPZXQMapping ormxmrypzxqMapping;




    @ApiOperation(value = "GetDraft", tags = {"ORMXMRYPZXQ" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmrypzxqs/getdraft")
    public ResponseEntity<ORMXMRYPZXQDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqMapping.toDto(ormxmrypzxqService.getDraft(new ORMXMRYPZXQ())));
    }




    @ApiOperation(value = "提交（拟用人员变更）", tags = {"ORMXMRYPZXQ" },  notes = "提交（拟用人员变更）")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/syntj")
    @Transactional
    public ResponseEntity<ORMXMRYPZXQDTO> synTJ(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody ORMXMRYPZXQDTO ormxmrypzxqdto) {
        ORMXMRYPZXQ ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq = ormxmrypzxqService.synTJ(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }




    @ApiOperation(value = "审批通过（拟用人员变更）", tags = {"ORMXMRYPZXQ" },  notes = "审批通过（拟用人员变更）")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/modsptg")
    @Transactional
    public ResponseEntity<ORMXMRYPZXQDTO> mODSPTG(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody ORMXMRYPZXQDTO ormxmrypzxqdto) {
        ORMXMRYPZXQ ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq = ormxmrypzxqService.mODSPTG(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }




    @ApiOperation(value = "CheckKey", tags = {"ORMXMRYPZXQ" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody ORMXMRYPZXQDTO ormxmrypzxqdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqService.checkKey(ormxmrypzxqMapping.toDomain(ormxmrypzxqdto)));
    }




    @ApiOperation(value = "驳回（释放）", tags = {"ORMXMRYPZXQ" },  notes = "驳回（释放）")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/sfbh")
    @Transactional
    public ResponseEntity<ORMXMRYPZXQDTO> sFBH(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody ORMXMRYPZXQDTO ormxmrypzxqdto) {
        ORMXMRYPZXQ ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq = ormxmrypzxqService.sFBH(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }




    @ApiOperation(value = "确认", tags = {"ORMXMRYPZXQ" },  notes = "确认")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/ensure")
    @Transactional
    public ResponseEntity<ORMXMRYPZXQDTO> ensure(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody ORMXMRYPZXQDTO ormxmrypzxqdto) {
        ORMXMRYPZXQ ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq = ormxmrypzxqService.ensure(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }




    @PreAuthorize("hasPermission(#ormxmrypzxq_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"ORMXMRYPZXQ" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/ormxmrypzxqs/{ormxmrypzxq_id}")
    public ResponseEntity<ORMXMRYPZXQDTO> get(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id) {
        ORMXMRYPZXQ domain = ormxmrypzxqService.get(ormxmrypzxq_id);
        ORMXMRYPZXQDTO dto = ormxmrypzxqMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "提交", tags = {"ORMXMRYPZXQ" },  notes = "提交")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/syndeployinfo")
    @Transactional
    public ResponseEntity<ORMXMRYPZXQDTO> synDeployInfo(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody ORMXMRYPZXQDTO ormxmrypzxqdto) {
        ORMXMRYPZXQ ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq = ormxmrypzxqService.synDeployInfo(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }




    @ApiOperation(value = "驳回（拟用人员变更）", tags = {"ORMXMRYPZXQ" },  notes = "驳回（拟用人员变更）")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/modbh")
    @Transactional
    public ResponseEntity<ORMXMRYPZXQDTO> mODBH(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody ORMXMRYPZXQDTO ormxmrypzxqdto) {
        ORMXMRYPZXQ ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq = ormxmrypzxqService.mODBH(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }




    @ApiOperation(value = "确认（释放）", tags = {"ORMXMRYPZXQ" },  notes = "确认（释放）")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/sfqr")
    @Transactional
    public ResponseEntity<ORMXMRYPZXQDTO> sFQR(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody ORMXMRYPZXQDTO ormxmrypzxqdto) {
        ORMXMRYPZXQ ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq = ormxmrypzxqService.sFQR(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }




    @ApiOperation(value = "计算人员信息", tags = {"ORMXMRYPZXQ" },  notes = "计算人员信息")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/synpersoninfo")
    @Transactional
    public ResponseEntity<ORMXMRYPZXQDTO> synPersonInfo(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody ORMXMRYPZXQDTO ormxmrypzxqdto) {
        ORMXMRYPZXQ ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq = ormxmrypzxqService.synPersonInfo(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }




    @PreAuthorize("hasPermission(#ormxmrypzxq_id,'Remove',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Remove", tags = {"ORMXMRYPZXQ" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmrypzxqs/{ormxmrypzxq_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id) {
         return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqService.remove(ormxmrypzxq_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"ORMXMRYPZXQ" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/ormxmrypzxqs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        ormxmrypzxqService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "提交", tags = {"ORMXMRYPZXQ" },  notes = "提交")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/synrelease")
    @Transactional
    public ResponseEntity<ORMXMRYPZXQDTO> synRelease(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody ORMXMRYPZXQDTO ormxmrypzxqdto) {
        ORMXMRYPZXQ ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq = ormxmrypzxqService.synRelease(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }




    @ApiOperation(value = "审核通过", tags = {"ORMXMRYPZXQ" },  notes = "审核通过")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/shtg")
    @Transactional
    public ResponseEntity<ORMXMRYPZXQDTO> sHTG(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody ORMXMRYPZXQDTO ormxmrypzxqdto) {
        ORMXMRYPZXQ ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq = ormxmrypzxqService.sHTG(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }




    @ApiOperation(value = "审批通过（调配）", tags = {"ORMXMRYPZXQ" },  notes = "审批通过（调配）")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/tpsptg")
    @Transactional
    public ResponseEntity<ORMXMRYPZXQDTO> tPSPTG(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody ORMXMRYPZXQDTO ormxmrypzxqdto) {
        ORMXMRYPZXQ ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq = ormxmrypzxqService.tPSPTG(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }




    @ApiOperation(value = "驳回", tags = {"ORMXMRYPZXQ" },  notes = "驳回")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/bh")
    @Transactional
    public ResponseEntity<ORMXMRYPZXQDTO> bH(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody ORMXMRYPZXQDTO ormxmrypzxqdto) {
        ORMXMRYPZXQ ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq = ormxmrypzxqService.bH(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }




    @ApiOperation(value = "Save", tags = {"ORMXMRYPZXQ" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/save")
    public ResponseEntity<Boolean> save(@RequestBody ORMXMRYPZXQDTO ormxmrypzxqdto) {
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqService.save(ormxmrypzxqMapping.toDomain(ormxmrypzxqdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"ORMXMRYPZXQ" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<ORMXMRYPZXQDTO> ormxmrypzxqdtos) {
        ormxmrypzxqService.saveBatch(ormxmrypzxqMapping.toDomain(ormxmrypzxqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "审批通过（释放）", tags = {"ORMXMRYPZXQ" },  notes = "审批通过（释放）")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/sfsptg")
    @Transactional
    public ResponseEntity<ORMXMRYPZXQDTO> sFSPTG(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody ORMXMRYPZXQDTO ormxmrypzxqdto) {
        ORMXMRYPZXQ ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq = ormxmrypzxqService.sFSPTG(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }




    @ApiOperation(value = "驳回（调配）", tags = {"ORMXMRYPZXQ" },  notes = "驳回（调配）")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/tpbh")
    @Transactional
    public ResponseEntity<ORMXMRYPZXQDTO> tPBH(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody ORMXMRYPZXQDTO ormxmrypzxqdto) {
        ORMXMRYPZXQ ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq = ormxmrypzxqService.tPBH(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }




    @ApiOperation(value = "确认（调配）", tags = {"ORMXMRYPZXQ" },  notes = "确认（调配）")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/{ormxmrypzxq_id}/tpqr")
    @Transactional
    public ResponseEntity<ORMXMRYPZXQDTO> tPQR(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody ORMXMRYPZXQDTO ormxmrypzxqdto) {
        ORMXMRYPZXQ ormxmrypzxq = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        ormxmrypzxq = ormxmrypzxqService.tPQR(ormxmrypzxq);
        ormxmrypzxqdto = ormxmrypzxqMapping.toDto(ormxmrypzxq);
        return ResponseEntity.status(HttpStatus.OK).body(ormxmrypzxqdto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"ORMXMRYPZXQ" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs")
    @Transactional
    public ResponseEntity<ORMXMRYPZXQDTO> create(@RequestBody ORMXMRYPZXQDTO ormxmrypzxqdto) {
        ORMXMRYPZXQ domain = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
		ormxmrypzxqService.create(domain);
        ORMXMRYPZXQDTO dto = ormxmrypzxqMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"ORMXMRYPZXQ" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/ormxmrypzxqs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<ORMXMRYPZXQDTO> ormxmrypzxqdtos) {
        ormxmrypzxqService.createBatch(ormxmrypzxqMapping.toDomain(ormxmrypzxqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#ormxmrypzxq_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"ORMXMRYPZXQ" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmrypzxqs/{ormxmrypzxq_id}")
    @Transactional
    public ResponseEntity<ORMXMRYPZXQDTO> update(@PathVariable("ormxmrypzxq_id") String ormxmrypzxq_id, @RequestBody ORMXMRYPZXQDTO ormxmrypzxqdto) {
		ORMXMRYPZXQ domain = ormxmrypzxqMapping.toDomain(ormxmrypzxqdto);
        domain.setOrmxmrypzxqid(ormxmrypzxq_id);
		ormxmrypzxqService.update(domain);
		ORMXMRYPZXQDTO dto = ormxmrypzxqMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#ormxmrypzxq_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"ORMXMRYPZXQ" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/ormxmrypzxqs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<ORMXMRYPZXQDTO> ormxmrypzxqdtos) {
        ormxmrypzxqService.updateBatch(ormxmrypzxqMapping.toDomain(ormxmrypzxqdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMRYPZXQ-RSSH-all')")
	@ApiOperation(value = "fetch人事审核", tags = {"ORMXMRYPZXQ" } ,notes = "fetch人事审核")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmrypzxqs/fetchrssh")
	public ResponseEntity<List<ORMXMRYPZXQDTO>> fetchRSSH(ORMXMRYPZXQSearchContext context) {
        Page<ORMXMRYPZXQ> domains = ormxmrypzxqService.searchRSSH(context) ;
        List<ORMXMRYPZXQDTO> list = ormxmrypzxqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMRYPZXQ-RSSH-all')")
	@ApiOperation(value = "search人事审核", tags = {"ORMXMRYPZXQ" } ,notes = "search人事审核")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmrypzxqs/searchrssh")
	public ResponseEntity<Page<ORMXMRYPZXQDTO>> searchRSSH(@RequestBody ORMXMRYPZXQSearchContext context) {
        Page<ORMXMRYPZXQ> domains = ormxmrypzxqService.searchRSSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmrypzxqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMRYPZXQ-CURFQTP-all')")
	@ApiOperation(value = "fetch判定调配", tags = {"ORMXMRYPZXQ" } ,notes = "fetch判定调配")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmrypzxqs/fetchcurfqtp")
	public ResponseEntity<List<ORMXMRYPZXQDTO>> fetchCURFQTP(ORMXMRYPZXQSearchContext context) {
        Page<ORMXMRYPZXQ> domains = ormxmrypzxqService.searchCURFQTP(context) ;
        List<ORMXMRYPZXQDTO> list = ormxmrypzxqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMRYPZXQ-CURFQTP-all')")
	@ApiOperation(value = "search判定调配", tags = {"ORMXMRYPZXQ" } ,notes = "search判定调配")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmrypzxqs/searchcurfqtp")
	public ResponseEntity<Page<ORMXMRYPZXQDTO>> searchCURFQTP(@RequestBody ORMXMRYPZXQSearchContext context) {
        Page<ORMXMRYPZXQ> domains = ormxmrypzxqService.searchCURFQTP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmrypzxqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMRYPZXQ-CXSJ-all')")
	@ApiOperation(value = "fetch查询调配数据", tags = {"ORMXMRYPZXQ" } ,notes = "fetch查询调配数据")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmrypzxqs/fetchcxsj")
	public ResponseEntity<List<ORMXMRYPZXQDTO>> fetchCXSJ(ORMXMRYPZXQSearchContext context) {
        Page<ORMXMRYPZXQ> domains = ormxmrypzxqService.searchCXSJ(context) ;
        List<ORMXMRYPZXQDTO> list = ormxmrypzxqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMRYPZXQ-CXSJ-all')")
	@ApiOperation(value = "search查询调配数据", tags = {"ORMXMRYPZXQ" } ,notes = "search查询调配数据")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmrypzxqs/searchcxsj")
	public ResponseEntity<Page<ORMXMRYPZXQDTO>> searchCXSJ(@RequestBody ORMXMRYPZXQSearchContext context) {
        Page<ORMXMRYPZXQ> domains = ormxmrypzxqService.searchCXSJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmrypzxqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMRYPZXQ-KZXMQX-all')")
	@ApiOperation(value = "fetch控制项目人员需求（修改、删除）权限", tags = {"ORMXMRYPZXQ" } ,notes = "fetch控制项目人员需求（修改、删除）权限")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmrypzxqs/fetchkzxmqx")
	public ResponseEntity<List<ORMXMRYPZXQDTO>> fetchKZXMQX(ORMXMRYPZXQSearchContext context) {
        Page<ORMXMRYPZXQ> domains = ormxmrypzxqService.searchKZXMQX(context) ;
        List<ORMXMRYPZXQDTO> list = ormxmrypzxqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMRYPZXQ-KZXMQX-all')")
	@ApiOperation(value = "search控制项目人员需求（修改、删除）权限", tags = {"ORMXMRYPZXQ" } ,notes = "search控制项目人员需求（修改、删除）权限")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmrypzxqs/searchkzxmqx")
	public ResponseEntity<Page<ORMXMRYPZXQDTO>> searchKZXMQX(@RequestBody ORMXMRYPZXQSearchContext context) {
        Page<ORMXMRYPZXQ> domains = ormxmrypzxqService.searchKZXMQX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmrypzxqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMRYPZXQ-SFSH-all')")
	@ApiOperation(value = "fetch释放台账", tags = {"ORMXMRYPZXQ" } ,notes = "fetch释放台账")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmrypzxqs/fetchsfsh")
	public ResponseEntity<List<ORMXMRYPZXQDTO>> fetchSFSH(ORMXMRYPZXQSearchContext context) {
        Page<ORMXMRYPZXQ> domains = ormxmrypzxqService.searchSFSH(context) ;
        List<ORMXMRYPZXQDTO> list = ormxmrypzxqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMRYPZXQ-SFSH-all')")
	@ApiOperation(value = "search释放台账", tags = {"ORMXMRYPZXQ" } ,notes = "search释放台账")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmrypzxqs/searchsfsh")
	public ResponseEntity<Page<ORMXMRYPZXQDTO>> searchSFSH(@RequestBody ORMXMRYPZXQSearchContext context) {
        Page<ORMXMRYPZXQ> domains = ormxmrypzxqService.searchSFSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmrypzxqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMRYPZXQ-CURFQSF-all')")
	@ApiOperation(value = "fetch判定释放", tags = {"ORMXMRYPZXQ" } ,notes = "fetch判定释放")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmrypzxqs/fetchcurfqsf")
	public ResponseEntity<List<ORMXMRYPZXQDTO>> fetchCURFQSF(ORMXMRYPZXQSearchContext context) {
        Page<ORMXMRYPZXQ> domains = ormxmrypzxqService.searchCURFQSF(context) ;
        List<ORMXMRYPZXQDTO> list = ormxmrypzxqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMRYPZXQ-CURFQSF-all')")
	@ApiOperation(value = "search判定释放", tags = {"ORMXMRYPZXQ" } ,notes = "search判定释放")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmrypzxqs/searchcurfqsf")
	public ResponseEntity<Page<ORMXMRYPZXQDTO>> searchCURFQSF(@RequestBody ORMXMRYPZXQSearchContext context) {
        Page<ORMXMRYPZXQ> domains = ormxmrypzxqService.searchCURFQSF(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmrypzxqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMRYPZXQ-TPSH-all')")
	@ApiOperation(value = "fetch调配审核", tags = {"ORMXMRYPZXQ" } ,notes = "fetch调配审核")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmrypzxqs/fetchtpsh")
	public ResponseEntity<List<ORMXMRYPZXQDTO>> fetchTPSH(ORMXMRYPZXQSearchContext context) {
        Page<ORMXMRYPZXQ> domains = ormxmrypzxqService.searchTPSH(context) ;
        List<ORMXMRYPZXQDTO> list = ormxmrypzxqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMRYPZXQ-TPSH-all')")
	@ApiOperation(value = "search调配审核", tags = {"ORMXMRYPZXQ" } ,notes = "search调配审核")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmrypzxqs/searchtpsh")
	public ResponseEntity<Page<ORMXMRYPZXQDTO>> searchTPSH(@RequestBody ORMXMRYPZXQSearchContext context) {
        Page<ORMXMRYPZXQ> domains = ormxmrypzxqService.searchTPSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmrypzxqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMRYPZXQ-SFCXSJ-all')")
	@ApiOperation(value = "fetch释放数据查询", tags = {"ORMXMRYPZXQ" } ,notes = "fetch释放数据查询")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmrypzxqs/fetchsfcxsj")
	public ResponseEntity<List<ORMXMRYPZXQDTO>> fetchSFCXSJ(ORMXMRYPZXQSearchContext context) {
        Page<ORMXMRYPZXQ> domains = ormxmrypzxqService.searchSFCXSJ(context) ;
        List<ORMXMRYPZXQDTO> list = ormxmrypzxqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMRYPZXQ-SFCXSJ-all')")
	@ApiOperation(value = "search释放数据查询", tags = {"ORMXMRYPZXQ" } ,notes = "search释放数据查询")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmrypzxqs/searchsfcxsj")
	public ResponseEntity<Page<ORMXMRYPZXQDTO>> searchSFCXSJ(@RequestBody ORMXMRYPZXQSearchContext context) {
        Page<ORMXMRYPZXQ> domains = ormxmrypzxqService.searchSFCXSJ(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmrypzxqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMRYPZXQ-MODSPSH-all')")
	@ApiOperation(value = "fetch拟用人员变更审核", tags = {"ORMXMRYPZXQ" } ,notes = "fetch拟用人员变更审核")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmrypzxqs/fetchmodspsh")
	public ResponseEntity<List<ORMXMRYPZXQDTO>> fetchMODSPSH(ORMXMRYPZXQSearchContext context) {
        Page<ORMXMRYPZXQ> domains = ormxmrypzxqService.searchMODSPSH(context) ;
        List<ORMXMRYPZXQDTO> list = ormxmrypzxqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMRYPZXQ-MODSPSH-all')")
	@ApiOperation(value = "search拟用人员变更审核", tags = {"ORMXMRYPZXQ" } ,notes = "search拟用人员变更审核")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmrypzxqs/searchmodspsh")
	public ResponseEntity<Page<ORMXMRYPZXQDTO>> searchMODSPSH(@RequestBody ORMXMRYPZXQSearchContext context) {
        Page<ORMXMRYPZXQ> domains = ormxmrypzxqService.searchMODSPSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmrypzxqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMRYPZXQ-Default-all')")
	@ApiOperation(value = "fetchDEFAULT", tags = {"ORMXMRYPZXQ" } ,notes = "fetchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmrypzxqs/fetchdefault")
	public ResponseEntity<List<ORMXMRYPZXQDTO>> fetchDefault(ORMXMRYPZXQSearchContext context) {
        Page<ORMXMRYPZXQ> domains = ormxmrypzxqService.searchDefault(context) ;
        List<ORMXMRYPZXQDTO> list = ormxmrypzxqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMRYPZXQ-Default-all')")
	@ApiOperation(value = "searchDEFAULT", tags = {"ORMXMRYPZXQ" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmrypzxqs/searchdefault")
	public ResponseEntity<Page<ORMXMRYPZXQDTO>> searchDefault(@RequestBody ORMXMRYPZXQSearchContext context) {
        Page<ORMXMRYPZXQ> domains = ormxmrypzxqService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmrypzxqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMRYPZXQ-XMCBMX-all')")
	@ApiOperation(value = "fetch项目人力成本明细", tags = {"ORMXMRYPZXQ" } ,notes = "fetch项目人力成本明细")
    @RequestMapping(method= RequestMethod.GET , value="/ormxmrypzxqs/fetchxmcbmx")
	public ResponseEntity<List<ORMXMRYPZXQDTO>> fetchXMCBMX(ORMXMRYPZXQSearchContext context) {
        Page<ORMXMRYPZXQ> domains = ormxmrypzxqService.searchXMCBMX(context) ;
        List<ORMXMRYPZXQDTO> list = ormxmrypzxqMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-ORMXMRYPZXQ-XMCBMX-all')")
	@ApiOperation(value = "search项目人力成本明细", tags = {"ORMXMRYPZXQ" } ,notes = "search项目人力成本明细")
    @RequestMapping(method= RequestMethod.POST , value="/ormxmrypzxqs/searchxmcbmx")
	public ResponseEntity<Page<ORMXMRYPZXQDTO>> searchXMCBMX(@RequestBody ORMXMRYPZXQSearchContext context) {
        Page<ORMXMRYPZXQ> domains = ormxmrypzxqService.searchXMCBMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(ormxmrypzxqMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public ORMXMRYPZXQ getEntity(){
        return new ORMXMRYPZXQ();
    }

}
