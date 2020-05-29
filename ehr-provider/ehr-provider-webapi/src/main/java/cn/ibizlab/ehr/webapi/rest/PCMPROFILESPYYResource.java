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
import cn.ibizlab.ehr.core.pcm.domain.PCMPROFILESPYY;
import cn.ibizlab.ehr.core.pcm.service.IPCMPROFILESPYYService;
import cn.ibizlab.ehr.core.pcm.filter.PCMPROFILESPYYSearchContext;

@Slf4j
@Api(tags = {"应聘者审批原因" })
@RestController("WebApi-pcmprofilespyy")
@RequestMapping("")
public class PCMPROFILESPYYResource {

    @Autowired
    public IPCMPROFILESPYYService pcmprofilespyyService;

    @Autowired
    @Lazy
    public PCMPROFILESPYYMapping pcmprofilespyyMapping;

    @ApiOperation(value = "获取应聘者审批原因草稿", tags = {"应聘者审批原因" },  notes = "获取应聘者审批原因草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofilespyys/getdraft")
    public ResponseEntity<PCMPROFILESPYYDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofilespyyMapping.toDto(pcmprofilespyyService.getDraft(new PCMPROFILESPYY())));
    }

    @ApiOperation(value = "检查应聘者审批原因", tags = {"应聘者审批原因" },  notes = "检查应聘者审批原因")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilespyys/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody PCMPROFILESPYYDTO pcmprofilespyydto) {
        return  ResponseEntity.status(HttpStatus.OK).body(pcmprofilespyyService.checkKey(pcmprofilespyyMapping.toDomain(pcmprofilespyydto)));
    }

    @PostAuthorize("hasPermission(this.pcmprofilespyyMapping.toDomain(returnObject.body),'ehr-PCMPROFILESPYY-Get')")
    @ApiOperation(value = "获取应聘者审批原因", tags = {"应聘者审批原因" },  notes = "获取应聘者审批原因")
	@RequestMapping(method = RequestMethod.GET, value = "/pcmprofilespyys/{pcmprofilespyy_id}")
    public ResponseEntity<PCMPROFILESPYYDTO> get(@PathVariable("pcmprofilespyy_id") String pcmprofilespyy_id) {
        PCMPROFILESPYY domain = pcmprofilespyyService.get(pcmprofilespyy_id);
        PCMPROFILESPYYDTO dto = pcmprofilespyyMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofilespyyMapping.toDomain(#pcmprofilespyydto),'ehr-PCMPROFILESPYY-Save')")
    @ApiOperation(value = "保存应聘者审批原因", tags = {"应聘者审批原因" },  notes = "保存应聘者审批原因")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilespyys/save")
    public ResponseEntity<Boolean> save(@RequestBody PCMPROFILESPYYDTO pcmprofilespyydto) {
        return ResponseEntity.status(HttpStatus.OK).body(pcmprofilespyyService.save(pcmprofilespyyMapping.toDomain(pcmprofilespyydto)));
    }

    @PreAuthorize("hasPermission(this.pcmprofilespyyMapping.toDomain(#pcmprofilespyydtos),'ehr-PCMPROFILESPYY-Save')")
    @ApiOperation(value = "批量保存应聘者审批原因", tags = {"应聘者审批原因" },  notes = "批量保存应聘者审批原因")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilespyys/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<PCMPROFILESPYYDTO> pcmprofilespyydtos) {
        pcmprofilespyyService.saveBatch(pcmprofilespyyMapping.toDomain(pcmprofilespyydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmprofilespyyMapping.toDomain(#pcmprofilespyydto),'ehr-PCMPROFILESPYY-Create')")
    @ApiOperation(value = "新建应聘者审批原因", tags = {"应聘者审批原因" },  notes = "新建应聘者审批原因")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilespyys")
    @Transactional
    public ResponseEntity<PCMPROFILESPYYDTO> create(@RequestBody PCMPROFILESPYYDTO pcmprofilespyydto) {
        PCMPROFILESPYY domain = pcmprofilespyyMapping.toDomain(pcmprofilespyydto);
		pcmprofilespyyService.create(domain);
        PCMPROFILESPYYDTO dto = pcmprofilespyyMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofilespyyMapping.toDomain(#pcmprofilespyydtos),'ehr-PCMPROFILESPYY-Create')")
    @ApiOperation(value = "批量新建应聘者审批原因", tags = {"应聘者审批原因" },  notes = "批量新建应聘者审批原因")
	@RequestMapping(method = RequestMethod.POST, value = "/pcmprofilespyys/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<PCMPROFILESPYYDTO> pcmprofilespyydtos) {
        pcmprofilespyyService.createBatch(pcmprofilespyyMapping.toDomain(pcmprofilespyydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmprofilespyyService.get(#pcmprofilespyy_id),'ehr-PCMPROFILESPYY-Update')")
    @ApiOperation(value = "更新应聘者审批原因", tags = {"应聘者审批原因" },  notes = "更新应聘者审批原因")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofilespyys/{pcmprofilespyy_id}")
    @Transactional
    public ResponseEntity<PCMPROFILESPYYDTO> update(@PathVariable("pcmprofilespyy_id") String pcmprofilespyy_id, @RequestBody PCMPROFILESPYYDTO pcmprofilespyydto) {
		PCMPROFILESPYY domain  = pcmprofilespyyMapping.toDomain(pcmprofilespyydto);
        domain .setPcmprofilespyyid(pcmprofilespyy_id);
		pcmprofilespyyService.update(domain );
		PCMPROFILESPYYDTO dto = pcmprofilespyyMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.pcmprofilespyyService.getPcmprofilespyyByEntities(this.pcmprofilespyyMapping.toDomain(#pcmprofilespyydtos)),'ehr-PCMPROFILESPYY-Update')")
    @ApiOperation(value = "批量更新应聘者审批原因", tags = {"应聘者审批原因" },  notes = "批量更新应聘者审批原因")
	@RequestMapping(method = RequestMethod.PUT, value = "/pcmprofilespyys/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<PCMPROFILESPYYDTO> pcmprofilespyydtos) {
        pcmprofilespyyService.updateBatch(pcmprofilespyyMapping.toDomain(pcmprofilespyydtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.pcmprofilespyyService.get(#pcmprofilespyy_id),'ehr-PCMPROFILESPYY-Remove')")
    @ApiOperation(value = "删除应聘者审批原因", tags = {"应聘者审批原因" },  notes = "删除应聘者审批原因")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofilespyys/{pcmprofilespyy_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("pcmprofilespyy_id") String pcmprofilespyy_id) {
         return ResponseEntity.status(HttpStatus.OK).body(pcmprofilespyyService.remove(pcmprofilespyy_id));
    }

    @PreAuthorize("hasPermission(this.pcmprofilespyyService.getPcmprofilespyyByIds(#ids),'ehr-PCMPROFILESPYY-Remove')")
    @ApiOperation(value = "批量删除应聘者审批原因", tags = {"应聘者审批原因" },  notes = "批量删除应聘者审批原因")
	@RequestMapping(method = RequestMethod.DELETE, value = "/pcmprofilespyys/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        pcmprofilespyyService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILESPYY-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"应聘者审批原因" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/pcmprofilespyys/fetchdefault")
	public ResponseEntity<List<PCMPROFILESPYYDTO>> fetchDefault(PCMPROFILESPYYSearchContext context) {
        Page<PCMPROFILESPYY> domains = pcmprofilespyyService.searchDefault(context) ;
        List<PCMPROFILESPYYDTO> list = pcmprofilespyyMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-PCMPROFILESPYY-Default-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"应聘者审批原因" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/pcmprofilespyys/searchdefault")
	public ResponseEntity<Page<PCMPROFILESPYYDTO>> searchDefault(@RequestBody PCMPROFILESPYYSearchContext context) {
        Page<PCMPROFILESPYY> domains = pcmprofilespyyService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(pcmprofilespyyMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

