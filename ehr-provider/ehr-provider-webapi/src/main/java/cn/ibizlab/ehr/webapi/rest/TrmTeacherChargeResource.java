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
import cn.ibizlab.ehr.core.trm.domain.TrmTeacherCharge;
import cn.ibizlab.ehr.core.trm.service.ITrmTeacherChargeService;
import cn.ibizlab.ehr.core.trm.filter.TrmTeacherChargeSearchContext;

@Slf4j
@Api(tags = {"讲师收费记录" })
@RestController("WebApi-trmteachercharge")
@RequestMapping("")
public class TrmTeacherChargeResource {

    @Autowired
    public ITrmTeacherChargeService trmteacherchargeService;

    @Autowired
    @Lazy
    public TrmTeacherChargeMapping trmteacherchargeMapping;

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedto),'ehr-TrmTeacherCharge-Save')")
    @ApiOperation(value = "保存讲师收费记录", tags = {"讲师收费记录" },  notes = "保存讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachercharges/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.save(trmteacherchargeMapping.toDomain(trmteacherchargedto)));
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos),'ehr-TrmTeacherCharge-Save')")
    @ApiOperation(value = "批量保存讲师收费记录", tags = {"讲师收费记录" },  notes = "批量保存讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachercharges/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        trmteacherchargeService.saveBatch(trmteacherchargeMapping.toDomain(trmteacherchargedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PostAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(returnObject.body),'ehr-TrmTeacherCharge-Get')")
    @ApiOperation(value = "获取讲师收费记录", tags = {"讲师收费记录" },  notes = "获取讲师收费记录")
	@RequestMapping(method = RequestMethod.GET, value = "/trmteachercharges/{trmteachercharge_id}")
    public ResponseEntity<TrmTeacherChargeDTO> get(@PathVariable("trmteachercharge_id") String trmteachercharge_id) {
        TrmTeacherCharge domain = trmteacherchargeService.get(trmteachercharge_id);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.get(#trmteachercharge_id),'ehr-TrmTeacherCharge-Remove')")
    @ApiOperation(value = "删除讲师收费记录", tags = {"讲师收费记录" },  notes = "删除讲师收费记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmteachercharges/{trmteachercharge_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmteachercharge_id") String trmteachercharge_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.remove(trmteachercharge_id));
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.getTrmteacherchargeByIds(#ids),'ehr-TrmTeacherCharge-Remove')")
    @ApiOperation(value = "批量删除讲师收费记录", tags = {"讲师收费记录" },  notes = "批量删除讲师收费记录")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmteachercharges/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmteacherchargeService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.get(#trmteachercharge_id),'ehr-TrmTeacherCharge-Update')")
    @ApiOperation(value = "更新讲师收费记录", tags = {"讲师收费记录" },  notes = "更新讲师收费记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmteachercharges/{trmteachercharge_id}")
    @Transactional
    public ResponseEntity<TrmTeacherChargeDTO> update(@PathVariable("trmteachercharge_id") String trmteachercharge_id, @RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
		TrmTeacherCharge domain  = trmteacherchargeMapping.toDomain(trmteacherchargedto);
        domain .setTrmteacherchargeid(trmteachercharge_id);
		trmteacherchargeService.update(domain );
		TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeService.getTrmteacherchargeByEntities(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos)),'ehr-TrmTeacherCharge-Update')")
    @ApiOperation(value = "批量更新讲师收费记录", tags = {"讲师收费记录" },  notes = "批量更新讲师收费记录")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmteachercharges/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        trmteacherchargeService.updateBatch(trmteacherchargeMapping.toDomain(trmteacherchargedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedto),'ehr-TrmTeacherCharge-Create')")
    @ApiOperation(value = "新建讲师收费记录", tags = {"讲师收费记录" },  notes = "新建讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachercharges")
    @Transactional
    public ResponseEntity<TrmTeacherChargeDTO> create(@RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        TrmTeacherCharge domain = trmteacherchargeMapping.toDomain(trmteacherchargedto);
		trmteacherchargeService.create(domain);
        TrmTeacherChargeDTO dto = trmteacherchargeMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmteacherchargeMapping.toDomain(#trmteacherchargedtos),'ehr-TrmTeacherCharge-Create')")
    @ApiOperation(value = "批量新建讲师收费记录", tags = {"讲师收费记录" },  notes = "批量新建讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachercharges/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmTeacherChargeDTO> trmteacherchargedtos) {
        trmteacherchargeService.createBatch(trmteacherchargeMapping.toDomain(trmteacherchargedtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取讲师收费记录草稿", tags = {"讲师收费记录" },  notes = "获取讲师收费记录草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmteachercharges/getdraft")
    public ResponseEntity<TrmTeacherChargeDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeMapping.toDto(trmteacherchargeService.getDraft(new TrmTeacherCharge())));
    }

    @ApiOperation(value = "检查讲师收费记录", tags = {"讲师收费记录" },  notes = "检查讲师收费记录")
	@RequestMapping(method = RequestMethod.POST, value = "/trmteachercharges/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmTeacherChargeDTO trmteacherchargedto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmteacherchargeService.checkKey(trmteacherchargeMapping.toDomain(trmteacherchargedto)));
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTeacherCharge-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"讲师收费记录" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmteachercharges/fetchdefault")
	public ResponseEntity<List<TrmTeacherChargeDTO>> fetchDefault(TrmTeacherChargeSearchContext context) {
        Page<TrmTeacherCharge> domains = trmteacherchargeService.searchDefault(context) ;
        List<TrmTeacherChargeDTO> list = trmteacherchargeMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmTeacherCharge-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"讲师收费记录" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmteachercharges/searchdefault")
	public ResponseEntity<Page<TrmTeacherChargeDTO>> searchDefault(@RequestBody TrmTeacherChargeSearchContext context) {
        Page<TrmTeacherCharge> domains = trmteacherchargeService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmteacherchargeMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

