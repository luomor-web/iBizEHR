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
import cn.ibizlab.ehr.core.pcm.domain.PCMBDSQDMX;
import cn.ibizlab.ehr.core.pcm.service.IPCMBDSQDMXService;
import cn.ibizlab.ehr.core.pcm.filter.PCMBDSQDMXSearchContext;




@Slf4j
@Api(tags = {"PCMBDSQDMX" })
@RestController("WebApi-pcmbdsqdmx")
@RequestMapping("")
public class PCMBDSQDMXResource {

    @Autowired
    private IPCMBDSQDMXService pcmbdsqdmxService;

    @Autowired
    @Lazy
    private PCMBDSQDMXMapping pcmbdsqdmxMapping;




    @ApiOperation(value = "职级晋升代码表", tags = {"PCMBDSQDMX" },  notes = "职级晋升代码表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/zjjsdmb")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> zJJSDMB(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx = pcmbdsqdmxService.zJJSDMB(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }




    @ApiOperation(value = "长期病休操作", tags = {"PCMBDSQDMX" },  notes = "长期病休操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/cqbxcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> cQBXCZ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx = pcmbdsqdmxService.cQBXCZ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }




    @ApiOperation(value = "", tags = {"PCMBDSQDMX" },  notes = "")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxjsdmb")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> sXJSDMB(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx = pcmbdsqdmxService.sXJSDMB(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }




    @ApiOperation(value = "判断职级", tags = {"PCMBDSQDMX" },  notes = "判断职级")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/pdzj")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> pDZJ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx = pcmbdsqdmxService.pDZJ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }




    @ApiOperation(value = "刷新代码表", tags = {"PCMBDSQDMX" },  notes = "刷新代码表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxjsdmb2")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> sXJSDMB2(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx = pcmbdsqdmxService.sXJSDMB2(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }




    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Create", tags = {"PCMBDSQDMX" },  notes = "Create")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> create(@RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
		pcmbdsqdmxService.create(domain);
        PCMBDSQDMXDTO dto = pcmbdsqdmxMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission('','Create',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "createBatch", tags = {"PCMBDSQDMX" },  notes = "createBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMBDSQDMXDTO> pcmbdsqdmxdtos) {
        pcmbdsqdmxService.createBatch(pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "自助申请", tags = {"PCMBDSQDMX" },  notes = "自助申请")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/zzsq")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> zZSQ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx = pcmbdsqdmxService.zZSQ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }




    @ApiOperation(value = "职级降职代码表", tags = {"PCMBDSQDMX" },  notes = "职级降职代码表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/sxdmb")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> sXDMB(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx = pcmbdsqdmxService.sXDMB(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }




    @ApiOperation(value = "待岗操作", tags = {"PCMBDSQDMX" },  notes = "待岗操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/dgcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> dGCZ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx = pcmbdsqdmxService.dGCZ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }




    @ApiOperation(value = "设置人员相关信息", tags = {"PCMBDSQDMX" },  notes = "设置人员相关信息")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/setpersoninfo")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> setPersonInfo(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx = pcmbdsqdmxService.setPersonInfo(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }




    @ApiOperation(value = "挂职操作", tags = {"PCMBDSQDMX" },  notes = "挂职操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/gzcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> gZCZ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx = pcmbdsqdmxService.gZCZ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }




    @ApiOperation(value = "解聘操作", tags = {"PCMBDSQDMX" },  notes = "解聘操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/jpcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> jPCZ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx = pcmbdsqdmxService.jPCZ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }




    @ApiOperation(value = "Save", tags = {"PCMBDSQDMX" },  notes = "Save")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.save(pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto)));
    }

    @ApiOperation(value = "SaveBatch", tags = {"PCMBDSQDMX" },  notes = "SaveBatch")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMBDSQDMXDTO> pcmbdsqdmxdtos) {
        pcmbdsqdmxService.saveBatch(pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @ApiOperation(value = "离职操作", tags = {"PCMBDSQDMX" },  notes = "离职操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/lzcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> lZCZ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx = pcmbdsqdmxService.lZCZ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }




    @ApiOperation(value = "内退操作", tags = {"PCMBDSQDMX" },  notes = "内退操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/ntcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> nTCZ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx = pcmbdsqdmxService.nTCZ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }




    @PreAuthorize("hasPermission(#pcmbdsqdmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Update", tags = {"PCMBDSQDMX" },  notes = "Update")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> update(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
		PCMBDSQDMX domain = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        domain.setPcmbdsqdmxid(pcmbdsqdmx_id);
		pcmbdsqdmxService.update(domain);
		PCMBDSQDMXDTO dto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(#pcmbdsqdmx_id,'Update',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "UpdateBatch", tags = {"PCMBDSQDMX" },  notes = "UpdateBatch")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmbdsqdmxes/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMBDSQDMXDTO> pcmbdsqdmxdtos) {
        pcmbdsqdmxService.updateBatch(pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }




    @PreAuthorize("hasPermission(#pcmbdsqdmx_id,'Get',{this.getEntity(),'Sql'})")
    @ApiOperation(value = "Get", tags = {"PCMBDSQDMX" },  notes = "Get")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    public ResponseEntity<PCMBDSQDMXDTO> get(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id) {
        PCMBDSQDMX domain = pcmbdsqdmxService.get(pcmbdsqdmx_id);
        PCMBDSQDMXDTO dto = pcmbdsqdmxMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }




    @PreAuthorize("hasPermission('Remove',{#pcmbdsqdmx_id,{this.getEntity(),'Sql'}})")
    @ApiOperation(value = "Remove", tags = {"PCMBDSQDMX" },  notes = "Remove")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.remove(pcmbdsqdmx_id));
    }

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




    @ApiOperation(value = "审核不通过", tags = {"PCMBDSQDMX" },  notes = "审核不通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/shbtg")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> sHBTG(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx = pcmbdsqdmxService.sHBTG(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }




    @ApiOperation(value = "职级变动操作", tags = {"PCMBDSQDMX" },  notes = "职级变动操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/zjbdcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> zJBDCZ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx = pcmbdsqdmxService.zJBDCZ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }




    @ApiOperation(value = "CheckKey", tags = {"PCMBDSQDMX" },  notes = "CheckKey")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxService.checkKey(pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto)));
    }




    @ApiOperation(value = "退休操作", tags = {"PCMBDSQDMX" },  notes = "退休操作")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/txcz")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> tXCZ(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx = pcmbdsqdmxService.tXCZ(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }




    @ApiOperation(value = "局职级晋升代码表", tags = {"PCMBDSQDMX" },  notes = "局职级晋升代码表")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/jzjjsdmb")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> jZJJSDMB(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx = pcmbdsqdmxService.jZJJSDMB(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }




    @ApiOperation(value = "审核通过", tags = {"PCMBDSQDMX" },  notes = "审核通过")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmbdsqdmxes/{pcmbdsqdmx_id}/shtg")
    @Transactional
    public ResponseEntity<PCMBDSQDMXDTO> sHTG(@PathVariable("pcmbdsqdmx_id") String pcmbdsqdmx_id, @RequestBody PCMBDSQDMXDTO pcmbdsqdmxdto) {
        PCMBDSQDMX pcmbdsqdmx = pcmbdsqdmxMapping.toDomain(pcmbdsqdmxdto);
        pcmbdsqdmx = pcmbdsqdmxService.sHTG(pcmbdsqdmx);
        pcmbdsqdmxdto = pcmbdsqdmxMapping.toDto(pcmbdsqdmx);
        return ResponseEntity.status(HttpStatus.OK).body(pcmbdsqdmxdto);
    }

    @PreAuthorize("hasPermission('Get',{#context,'JPSQMX',this.getEntity(),'Sql'})")
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

    @PreAuthorize("hasPermission('Get',{#context,'JPSQMX',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search解聘申请（未审核）", tags = {"PCMBDSQDMX" } ,notes = "search解聘申请（未审核）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/searchjpsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchJPSQMX(PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchJPSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'NTSQMX',this.getEntity(),'Sql'})")
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

    @PreAuthorize("hasPermission('Get',{#context,'NTSQMX',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search内退申请明细（未审核）", tags = {"PCMBDSQDMX" } ,notes = "search内退申请明细（未审核）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/searchntsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchNTSQMX(PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchNTSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'NTSQMXGR',this.getEntity(),'Sql'})")
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

    @PreAuthorize("hasPermission('Get',{#context,'NTSQMXGR',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search内退申请明细（个人）", tags = {"PCMBDSQDMX" } ,notes = "search内退申请明细（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/searchntsqmxgr")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchNTSQMXGR(PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchNTSQMXGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'TXSQMX',this.getEntity(),'Sql'})")
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

    @PreAuthorize("hasPermission('Get',{#context,'TXSQMX',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search退休申请明细（未审核）", tags = {"PCMBDSQDMX" } ,notes = "search退休申请明细（未审核）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/searchtxsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchTXSQMX(PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchTXSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'GZSQMX',this.getEntity(),'Sql'})")
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

    @PreAuthorize("hasPermission('Get',{#context,'GZSQMX',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search挂职申请明细（未审核）", tags = {"PCMBDSQDMX" } ,notes = "search挂职申请明细（未审核）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/searchgzsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchGZSQMX(PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchGZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'ZJBDSQMX',this.getEntity(),'Sql'})")
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

    @PreAuthorize("hasPermission('Get',{#context,'ZJBDSQMX',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search职级变动申请明细", tags = {"PCMBDSQDMX" } ,notes = "search职级变动申请明细")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/searchzjbdsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchZJBDSQMX(PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchZJBDSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'DGSQMX',this.getEntity(),'Sql'})")
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

    @PreAuthorize("hasPermission('Get',{#context,'DGSQMX',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search待岗申请明细", tags = {"PCMBDSQDMX" } ,notes = "search待岗申请明细")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/searchdgsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchDGSQMX(PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchDGSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'CQBXSQMXDS',this.getEntity(),'Sql'})")
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

    @PreAuthorize("hasPermission('Get',{#context,'CQBXSQMXDS',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search长期病休申请明细", tags = {"PCMBDSQDMX" } ,notes = "search长期病休申请明细")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/searchcqbxsqmxds")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchCQBXSQMXDS(PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchCQBXSQMXDS(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'LZSQMX',this.getEntity(),'Sql'})")
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

    @PreAuthorize("hasPermission('Get',{#context,'LZSQMX',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search离职申请明细", tags = {"PCMBDSQDMX" } ,notes = "search离职申请明细")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/searchlzsqmx")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchLZSQMX(PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchLZSQMX(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'LZSQMXGR',this.getEntity(),'Sql'})")
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

    @PreAuthorize("hasPermission('Get',{#context,'LZSQMXGR',this.getEntity(),'Sql'})")
	@ApiOperation(value = "search离职申请明细（个人）", tags = {"PCMBDSQDMX" } ,notes = "search离职申请明细（个人）")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/searchlzsqmxgr")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchLZSQMXGR(PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchLZSQMXGR(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
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

    @PreAuthorize("hasPermission('Get',{#context,'Default',this.getEntity(),'Sql'})")
	@ApiOperation(value = "searchDEFAULT", tags = {"PCMBDSQDMX" } ,notes = "searchDEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/pcmbdsqdmxes/searchdefault")
	public ResponseEntity<Page<PCMBDSQDMXDTO>> searchDefault(PCMBDSQDMXSearchContext context) {
        Page<PCMBDSQDMX> domains = pcmbdsqdmxService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmbdsqdmxMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}


    /**
     * 用户权限校验
     * @return
     */
	public PCMBDSQDMX getEntity(){
        return new PCMBDSQDMX();
    }

}