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
import cn.ibizlab.ehr.core.pim.domain.PIMBYZZJLMX;
import cn.ibizlab.ehr.core.pim.service.IPIMBYZZJLMXService;
import cn.ibizlab.ehr.core.pim.filter.PIMBYZZJLMXSearchContext;




@Slf4j
@Api(tags = {"PIMBYZZJLMX" })
@RestController("WebApi-pimbyzzjlmx")
@RequestMapping("")
public class PIMBYZZJLMXResource {

    @Autowired
    private IPIMBYZZJLMXService pimbyzzjlmxService;

    @Autowired
    @Lazy
    private PIMBYZZJLMXMapping pimbyzzjlmxMapping;




    @ApiOperation(value = "局总部初审通过", tags = {"PIMBYZZJLMX" },  notes = "局总部初审通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/shtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> sHTG(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx = pimbyzzjlmxService.sHTG(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }




    @PreAuthorize("hasPermission(#pimbyzzjlmx_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PIMBYZZJLMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}")
    public ResponseEntity<PIMBYZZJLMXDTO> get(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id) {
        PIMBYZZJLMX domain = pimbyzzjlmxService.get(pimbyzzjlmx_id);
        PIMBYZZJLMXDTO dto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @ApiOperation(value = "失效", tags = {"PIMBYZZJLMX" },  notes = "失效")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/returnypz")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> returnYPZ(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx = pimbyzzjlmxService.returnYPZ(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }




    @ApiOperation(value = "局总部审批通过", tags = {"PIMBYZZJLMX" },  notes = "局总部审批通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/jsptg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> jSPTG(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx = pimbyzzjlmxService.jSPTG(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }




    @ApiOperation(value = "填充人员信息", tags = {"PIMBYZZJLMX" },  notes = "填充人员信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/fillpersoninfo")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> fillPersonInfo(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx = pimbyzzjlmxService.fillPersonInfo(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }




    @ApiOperation(value = "GetDraft", tags = {"PIMBYZZJLMX" },  notes = "GetDraft")
	@RequestMapping(method = RequestMethod.GET, value = "/pimbyzzjlmxes/getdraft")
    public ResponseEntity<PIMBYZZJLMXDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxMapping.toDto(pimbyzzjlmxService.getDraft(new PIMBYZZJLMX())));
    }




    @ApiOperation(value = "局总部审核通过", tags = {"PIMBYZZJLMX" },  notes = "局总部审核通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/jshtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> jSHTG(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx = pimbyzzjlmxService.jSHTG(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }




    @ApiOperation(value = "局总部审核不通过", tags = {"PIMBYZZJLMX" },  notes = "局总部审核不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/jshbtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> jSHBTG(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx = pimbyzzjlmxService.jSHBTG(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }




    @ApiOperation(value = "确认", tags = {"PIMBYZZJLMX" },  notes = "确认")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/ensure")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> ensure(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx = pimbyzzjlmxService.ensure(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }




    @ApiOperation(value = "局总部初审不通过", tags = {"PIMBYZZJLMX" },  notes = "局总部初审不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/shbtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> sHBTG(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx = pimbyzzjlmxService.sHBTG(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }




    @PreAuthorize("hasPermission('Remove',{#pimbyzzjlmx_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PIMBYZZJLMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxService.remove(pimbyzzjlmx_id));
    }

    @ApiOperation(value = "RemoveBatch", tags = {"PIMBYZZJLMX" },  notes = "RemoveBatch")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pimbyzzjlmxes/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pimbyzzjlmxService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "公司董事长审批同意", tags = {"PIMBYZZJLMX" },  notes = "公司董事长审批同意")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/gsdszsp")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> gSDSZSP(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx = pimbyzzjlmxService.gSDSZSP(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }




    @ApiOperation(value = "转正操作", tags = {"PIMBYZZJLMX" },  notes = "转正操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/zzcz")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> zZCZ(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx = pimbyzzjlmxService.zZCZ(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }




    @ApiOperation(value = "待上报", tags = {"PIMBYZZJLMX" },  notes = "待上报")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/dsb")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> dSB(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx = pimbyzzjlmxService.dSB(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }




    @PreAuthorize("hasPermission(#pimbyzzjlmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PIMBYZZJLMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> update(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
		PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        domain.setPimbyzzjlmxid(pimbyzzjlmx_id);
		pimbyzzjlmxService.update(domain);
		PIMBYZZJLMXDTO dto = pimbyzzjlmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pimbyzzjlmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PIMBYZZJLMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbyzzjlmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PIMBYZZJLMXDTO> pimbyzzjlmxdtos) {
        pimbyzzjlmxService.updateBatch(pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PIMBYZZJLMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> create(@RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX domain = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
		pimbyzzjlmxService.create(domain);
        PIMBYZZJLMXDTO dto = pimbyzzjlmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PIMBYZZJLMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PIMBYZZJLMXDTO> pimbyzzjlmxdtos) {
        pimbyzzjlmxService.createBatch(pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "确认", tags = {"PIMBYZZJLMX" },  notes = "确认")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/jzbshqr")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> jZBSHQR(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx = pimbyzzjlmxService.jZBSHQR(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }




    @ApiOperation(value = "公司董事长审批拒绝", tags = {"PIMBYZZJLMX" },  notes = "公司董事长审批拒绝")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/gsdszspbtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> gSDSZSPBTG(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx = pimbyzzjlmxService.gSDSZSPBTG(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }




    @ApiOperation(value = "公司初审拒绝", tags = {"PIMBYZZJLMX" },  notes = "公司初审拒绝")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/gscsbtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> gSCSBTG(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx = pimbyzzjlmxService.gSCSBTG(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }




    @ApiOperation(value = "局总部审批不通过", tags = {"PIMBYZZJLMX" },  notes = "局总部审批不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/jspbtg")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> jSPBTG(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx = pimbyzzjlmxService.jSPBTG(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }




    @ApiOperation(value = "Save", tags = {"PIMBYZZJLMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxService.save(pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PIMBYZZJLMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PIMBYZZJLMXDTO> pimbyzzjlmxdtos) {
        pimbyzzjlmxService.saveBatch(pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "公司初审同意", tags = {"PIMBYZZJLMX" },  notes = "公司初审同意")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/gscs")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> gSCS(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx = pimbyzzjlmxService.gSCS(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }




    @ApiOperation(value = "CheckKey", tags = {"PIMBYZZJLMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxService.checkKey(pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto)));
    }




    @ApiOperation(value = "刷新人数", tags = {"PIMBYZZJLMX" },  notes = "刷新人数")
	@RequestMapping(method = RequestMethod.PUT, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/updatepeoplenum")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> updatePeopleNum(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx = pimbyzzjlmxService.updatePeopleNum(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }




    @ApiOperation(value = "确认", tags = {"PIMBYZZJLMX" },  notes = "确认")
	@RequestMapping(method = RequestMethod.POST, value = "/pimbyzzjlmxes/{pimbyzzjlmx_id}/jzbspqr")
    @Transactional
    public ResponseEntity<PIMBYZZJLMXDTO> jZBSPQR(@PathVariable("pimbyzzjlmx_id") String pimbyzzjlmx_id, @RequestBody PIMBYZZJLMXDTO pimbyzzjlmxdto) {
        PIMBYZZJLMX pimbyzzjlmx = pimbyzzjlmxMapping.toDomain(pimbyzzjlmxdto);
        pimbyzzjlmx = pimbyzzjlmxService.jZBSPQR(pimbyzzjlmx);
        pimbyzzjlmxdto = pimbyzzjlmxMapping.toDto(pimbyzzjlmx);
        return ResponseEntity.status(HttpStatus.OK).body(pimbyzzjlmxdto);
    }

	@ApiOperation(value = "fetch转正未审核", tags = {"PIMBYZZJLMX" } ,notes = "fetch转正未审核")
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

	@ApiOperation(value = "search转正未审核", tags = {"PIMBYZZJLMX" } ,notes = "search转正未审核")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchzzwshds")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchZZWSHDS(@RequestBody PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchZZWSHDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch待公司初审", tags = {"PIMBYZZJLMX" } ,notes = "fetch待公司初审")
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

	@ApiOperation(value = "search待公司初审", tags = {"PIMBYZZJLMX" } ,notes = "search待公司初审")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchunapproved")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchUnApproved(@RequestBody PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchUnApproved(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch待局总部审核", tags = {"PIMBYZZJLMX" } ,notes = "fetch待局总部审核")
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

	@ApiOperation(value = "search待局总部审核", tags = {"PIMBYZZJLMX" } ,notes = "search待局总部审核")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchddjzbsh")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchDDJZBSH(@RequestBody PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDDJZBSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetchB/Y类员工转正记录", tags = {"PIMBYZZJLMX" } ,notes = "fetchB/Y类员工转正记录")
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

	@ApiOperation(value = "searchB/Y类员工转正记录", tags = {"PIMBYZZJLMX" } ,notes = "searchB/Y类员工转正记录")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchbylzzjl")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchBYLZZJL(@RequestBody PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchBYLZZJL(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch待公司董事长审批", tags = {"PIMBYZZJLMX" } ,notes = "fetch待公司董事长审批")
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

	@ApiOperation(value = "search待公司董事长审批", tags = {"PIMBYZZJLMX" } ,notes = "search待公司董事长审批")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchdgsdszsh")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchDGSDSZSH(@RequestBody PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDGSDSZSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch回退人员", tags = {"PIMBYZZJLMX" } ,notes = "fetch回退人员")
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

	@ApiOperation(value = "search回退人员", tags = {"PIMBYZZJLMX" } ,notes = "search回退人员")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchhtry")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchHTRY(@RequestBody PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchHTRY(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch待局总部审批", tags = {"PIMBYZZJLMX" } ,notes = "fetch待局总部审批")
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

	@ApiOperation(value = "search待局总部审批", tags = {"PIMBYZZJLMX" } ,notes = "search待局总部审批")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchdjzbsp")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchDJZBSP(@RequestBody PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDJZBSP(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch待上报", tags = {"PIMBYZZJLMX" } ,notes = "fetch待上报")
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

	@ApiOperation(value = "search待上报", tags = {"PIMBYZZJLMX" } ,notes = "search待上报")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchdsb")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchDSB(@RequestBody PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDSB(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch已变更员工编号名单", tags = {"PIMBYZZJLMX" } ,notes = "fetch已变更员工编号名单")
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

	@ApiOperation(value = "search已变更员工编号名单", tags = {"PIMBYZZJLMX" } ,notes = "search已变更员工编号名单")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchfinishygbh")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchFinishYGBH(@RequestBody PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchFinishYGBH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetch待局总部初审", tags = {"PIMBYZZJLMX" } ,notes = "fetch待局总部初审")
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

	@ApiOperation(value = "search待局总部初审", tags = {"PIMBYZZJLMX" } ,notes = "search待局总部初审")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchdjzbsh")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchDJZBSH(@RequestBody PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDJZBSH(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

	@ApiOperation(value = "fetchDEFAULT", tags = {"PIMBYZZJLMX" } ,notes = "fetchDEFAULT")
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

	@ApiOperation(value = "searchDEFAULT", tags = {"PIMBYZZJLMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/pimbyzzjlmxes/searchdefault")
	public ResponseEntity<Page<PIMBYZZJLMXDTO>> searchDefault(@RequestBody PIMBYZZJLMXSearchContext context) {
        Page<PIMBYZZJLMX> domains = pimbyzzjlmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pimbyzzjlmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PIMBYZZJLMX getEntity(){
        return new PIMBYZZJLMX();
    }

}
