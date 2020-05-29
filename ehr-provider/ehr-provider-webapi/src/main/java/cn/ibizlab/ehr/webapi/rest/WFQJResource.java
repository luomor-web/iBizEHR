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
import cn.ibizlab.ehr.core.vac.domain.WFQJ;
import cn.ibizlab.ehr.core.vac.service.IWFQJService;
import cn.ibizlab.ehr.core.vac.filter.WFQJSearchContext;

@Slf4j
@Api(tags = {"请假（WF）" })
@RestController("WebApi-wfqj")
@RequestMapping("")
public class WFQJResource {

    @Autowired
    public IWFQJService wfqjService;

    @Autowired
    @Lazy
    public WFQJMapping wfqjMapping;

    @PreAuthorize("hasPermission(this.wfqjService.get(#wfqj_id),'ehr-WFQJ-Update')")
    @ApiOperation(value = "更新请假（WF）", tags = {"请假（WF）" },  notes = "更新请假（WF）")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfqjs/{wfqj_id}")
    @Transactional
    public ResponseEntity<WFQJDTO> update(@PathVariable("wfqj_id") String wfqj_id, @RequestBody WFQJDTO wfqjdto) {
		WFQJ domain  = wfqjMapping.toDomain(wfqjdto);
        domain .setWfqjid(wfqj_id);
		wfqjService.update(domain );
		WFQJDTO dto = wfqjMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.wfqjService.getWfqjByEntities(this.wfqjMapping.toDomain(#wfqjdtos)),'ehr-WFQJ-Update')")
    @ApiOperation(value = "批量更新请假（WF）", tags = {"请假（WF）" },  notes = "批量更新请假（WF）")
	@RequestMapping(method = RequestMethod.PUT, value = "/wfqjs/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<WFQJDTO> wfqjdtos) {
        wfqjService.updateBatch(wfqjMapping.toDomain(wfqjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "检查请假（WF）", tags = {"请假（WF）" },  notes = "检查请假（WF）")
	@RequestMapping(method = RequestMethod.POST, value = "/wfqjs/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody WFQJDTO wfqjdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(wfqjService.checkKey(wfqjMapping.toDomain(wfqjdto)));
    }

    @PreAuthorize("hasPermission(this.wfqjMapping.toDomain(#wfqjdto),'ehr-WFQJ-Create')")
    @ApiOperation(value = "新建请假（WF）", tags = {"请假（WF）" },  notes = "新建请假（WF）")
	@RequestMapping(method = RequestMethod.POST, value = "/wfqjs")
    @Transactional
    public ResponseEntity<WFQJDTO> create(@RequestBody WFQJDTO wfqjdto) {
        WFQJ domain = wfqjMapping.toDomain(wfqjdto);
		wfqjService.create(domain);
        WFQJDTO dto = wfqjMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.wfqjMapping.toDomain(#wfqjdtos),'ehr-WFQJ-Create')")
    @ApiOperation(value = "批量新建请假（WF）", tags = {"请假（WF）" },  notes = "批量新建请假（WF）")
	@RequestMapping(method = RequestMethod.POST, value = "/wfqjs/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<WFQJDTO> wfqjdtos) {
        wfqjService.createBatch(wfqjMapping.toDomain(wfqjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.wfqjMapping.toDomain(#wfqjdto),'ehr-WFQJ-Save')")
    @ApiOperation(value = "保存请假（WF）", tags = {"请假（WF）" },  notes = "保存请假（WF）")
	@RequestMapping(method = RequestMethod.POST, value = "/wfqjs/save")
    public ResponseEntity<Boolean> save(@RequestBody WFQJDTO wfqjdto) {
        return ResponseEntity.status(HttpStatus.OK).body(wfqjService.save(wfqjMapping.toDomain(wfqjdto)));
    }

    @PreAuthorize("hasPermission(this.wfqjMapping.toDomain(#wfqjdtos),'ehr-WFQJ-Save')")
    @ApiOperation(value = "批量保存请假（WF）", tags = {"请假（WF）" },  notes = "批量保存请假（WF）")
	@RequestMapping(method = RequestMethod.POST, value = "/wfqjs/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<WFQJDTO> wfqjdtos) {
        wfqjService.saveBatch(wfqjMapping.toDomain(wfqjdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取请假（WF）草稿", tags = {"请假（WF）" },  notes = "获取请假（WF）草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/wfqjs/getdraft")
    public ResponseEntity<WFQJDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(wfqjMapping.toDto(wfqjService.getDraft(new WFQJ())));
    }

    @PreAuthorize("hasPermission(this.wfqjService.get(#wfqj_id),'ehr-WFQJ-Remove')")
    @ApiOperation(value = "删除请假（WF）", tags = {"请假（WF）" },  notes = "删除请假（WF）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfqjs/{wfqj_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("wfqj_id") String wfqj_id) {
         return ResponseEntity.status(HttpStatus.OK).body(wfqjService.remove(wfqj_id));
    }

    @PreAuthorize("hasPermission(this.wfqjService.getWfqjByIds(#ids),'ehr-WFQJ-Remove')")
    @ApiOperation(value = "批量删除请假（WF）", tags = {"请假（WF）" },  notes = "批量删除请假（WF）")
	@RequestMapping(method = RequestMethod.DELETE, value = "/wfqjs/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        wfqjService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.wfqjMapping.toDomain(returnObject.body),'ehr-WFQJ-Get')")
    @ApiOperation(value = "获取请假（WF）", tags = {"请假（WF）" },  notes = "获取请假（WF）")
	@RequestMapping(method = RequestMethod.GET, value = "/wfqjs/{wfqj_id}")
    public ResponseEntity<WFQJDTO> get(@PathVariable("wfqj_id") String wfqj_id) {
        WFQJ domain = wfqjService.get(wfqj_id);
        WFQJDTO dto = wfqjMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFQJ-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"请假（WF）" } ,notes = "获取{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.GET , value="/wfqjs/fetchdefault")
	public ResponseEntity<List<WFQJDTO>> fetchDefault(WFQJSearchContext context) {
        Page<WFQJ> domains = wfqjService.searchDefault(context) ;
        List<WFQJDTO> list = wfqjMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-WFQJ-Default-all')")
	@ApiOperation(value = "查询{deds.getLogicName()}", tags = {"请假（WF）" } ,notes = "查询{deds.getLogicName()}")
    @RequestMapping(method= RequestMethod.POST , value="/wfqjs/searchdefault")
	public ResponseEntity<Page<WFQJDTO>> searchDefault(@RequestBody WFQJSearchContext context) {
        Page<WFQJ> domains = wfqjService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(wfqjMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

