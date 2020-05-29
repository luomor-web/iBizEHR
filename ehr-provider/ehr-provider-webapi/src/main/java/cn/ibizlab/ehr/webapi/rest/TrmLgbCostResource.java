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
import cn.ibizlab.ehr.core.trm.domain.TrmLgbCost;
import cn.ibizlab.ehr.core.trm.service.ITrmLgbCostService;
import cn.ibizlab.ehr.core.trm.filter.TrmLgbCostSearchContext;

@Slf4j
@Api(tags = {"老干部费用" })
@RestController("WebApi-trmlgbcost")
@RequestMapping("")
public class TrmLgbCostResource {

    @Autowired
    public ITrmLgbCostService trmlgbcostService;

    @Autowired
    @Lazy
    public TrmLgbCostMapping trmlgbcostMapping;

    @PostAuthorize("hasPermission(this.trmlgbcostMapping.toDomain(returnObject.body),'ehr-TrmLgbCost-Get')")
    @ApiOperation(value = "获取老干部费用", tags = {"老干部费用" },  notes = "获取老干部费用")
	@RequestMapping(method = RequestMethod.GET, value = "/trmlgbcosts/{trmlgbcost_id}")
    public ResponseEntity<TrmLgbCostDTO> get(@PathVariable("trmlgbcost_id") String trmlgbcost_id) {
        TrmLgbCost domain = trmlgbcostService.get(trmlgbcost_id);
        TrmLgbCostDTO dto = trmlgbcostMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmlgbcostService.get(#trmlgbcost_id),'ehr-TrmLgbCost-Remove')")
    @ApiOperation(value = "删除老干部费用", tags = {"老干部费用" },  notes = "删除老干部费用")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmlgbcosts/{trmlgbcost_id}")
    @Transactional
    public ResponseEntity<Boolean> remove(@PathVariable("trmlgbcost_id") String trmlgbcost_id) {
         return ResponseEntity.status(HttpStatus.OK).body(trmlgbcostService.remove(trmlgbcost_id));
    }

    @PreAuthorize("hasPermission(this.trmlgbcostService.getTrmlgbcostByIds(#ids),'ehr-TrmLgbCost-Remove')")
    @ApiOperation(value = "批量删除老干部费用", tags = {"老干部费用" },  notes = "批量删除老干部费用")
	@RequestMapping(method = RequestMethod.DELETE, value = "/trmlgbcosts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        trmlgbcostService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "获取老干部费用草稿", tags = {"老干部费用" },  notes = "获取老干部费用草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/trmlgbcosts/getdraft")
    public ResponseEntity<TrmLgbCostDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(trmlgbcostMapping.toDto(trmlgbcostService.getDraft(new TrmLgbCost())));
    }

    @ApiOperation(value = "检查老干部费用", tags = {"老干部费用" },  notes = "检查老干部费用")
	@RequestMapping(method = RequestMethod.POST, value = "/trmlgbcosts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody TrmLgbCostDTO trmlgbcostdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(trmlgbcostService.checkKey(trmlgbcostMapping.toDomain(trmlgbcostdto)));
    }

    @PreAuthorize("hasPermission(this.trmlgbcostService.get(#trmlgbcost_id),'ehr-TrmLgbCost-Update')")
    @ApiOperation(value = "更新老干部费用", tags = {"老干部费用" },  notes = "更新老干部费用")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmlgbcosts/{trmlgbcost_id}")
    @Transactional
    public ResponseEntity<TrmLgbCostDTO> update(@PathVariable("trmlgbcost_id") String trmlgbcost_id, @RequestBody TrmLgbCostDTO trmlgbcostdto) {
		TrmLgbCost domain  = trmlgbcostMapping.toDomain(trmlgbcostdto);
        domain .setTrmlgbcostid(trmlgbcost_id);
		trmlgbcostService.update(domain );
		TrmLgbCostDTO dto = trmlgbcostMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmlgbcostService.getTrmlgbcostByEntities(this.trmlgbcostMapping.toDomain(#trmlgbcostdtos)),'ehr-TrmLgbCost-Update')")
    @ApiOperation(value = "批量更新老干部费用", tags = {"老干部费用" },  notes = "批量更新老干部费用")
	@RequestMapping(method = RequestMethod.PUT, value = "/trmlgbcosts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<TrmLgbCostDTO> trmlgbcostdtos) {
        trmlgbcostService.updateBatch(trmlgbcostMapping.toDomain(trmlgbcostdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmlgbcostMapping.toDomain(#trmlgbcostdto),'ehr-TrmLgbCost-Create')")
    @ApiOperation(value = "新建老干部费用", tags = {"老干部费用" },  notes = "新建老干部费用")
	@RequestMapping(method = RequestMethod.POST, value = "/trmlgbcosts")
    @Transactional
    public ResponseEntity<TrmLgbCostDTO> create(@RequestBody TrmLgbCostDTO trmlgbcostdto) {
        TrmLgbCost domain = trmlgbcostMapping.toDomain(trmlgbcostdto);
		trmlgbcostService.create(domain);
        TrmLgbCostDTO dto = trmlgbcostMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PreAuthorize("hasPermission(this.trmlgbcostMapping.toDomain(#trmlgbcostdtos),'ehr-TrmLgbCost-Create')")
    @ApiOperation(value = "批量新建老干部费用", tags = {"老干部费用" },  notes = "批量新建老干部费用")
	@RequestMapping(method = RequestMethod.POST, value = "/trmlgbcosts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<TrmLgbCostDTO> trmlgbcostdtos) {
        trmlgbcostService.createBatch(trmlgbcostMapping.toDomain(trmlgbcostdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasPermission(this.trmlgbcostMapping.toDomain(#trmlgbcostdto),'ehr-TrmLgbCost-Save')")
    @ApiOperation(value = "保存老干部费用", tags = {"老干部费用" },  notes = "保存老干部费用")
	@RequestMapping(method = RequestMethod.POST, value = "/trmlgbcosts/save")
    public ResponseEntity<Boolean> save(@RequestBody TrmLgbCostDTO trmlgbcostdto) {
        return ResponseEntity.status(HttpStatus.OK).body(trmlgbcostService.save(trmlgbcostMapping.toDomain(trmlgbcostdto)));
    }

    @PreAuthorize("hasPermission(this.trmlgbcostMapping.toDomain(#trmlgbcostdtos),'ehr-TrmLgbCost-Save')")
    @ApiOperation(value = "批量保存老干部费用", tags = {"老干部费用" },  notes = "批量保存老干部费用")
	@RequestMapping(method = RequestMethod.POST, value = "/trmlgbcosts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<TrmLgbCostDTO> trmlgbcostdtos) {
        trmlgbcostService.saveBatch(trmlgbcostMapping.toDomain(trmlgbcostdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmLgbCost-Default-all')")
	@ApiOperation(value = "获取DEFAULT", tags = {"老干部费用" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/trmlgbcosts/fetchdefault")
	public ResponseEntity<List<TrmLgbCostDTO>> fetchDefault(TrmLgbCostSearchContext context) {
        Page<TrmLgbCost> domains = trmlgbcostService.searchDefault(context) ;
        List<TrmLgbCostDTO> list = trmlgbcostMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

    @PreAuthorize("hasAnyAuthority('ROLE_SUPERADMIN','ehr-TrmLgbCost-Default-all')")
	@ApiOperation(value = "查询DEFAULT", tags = {"老干部费用" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/trmlgbcosts/searchdefault")
	public ResponseEntity<Page<TrmLgbCostDTO>> searchDefault(@RequestBody TrmLgbCostSearchContext context) {
        Page<TrmLgbCost> domains = trmlgbcostService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(trmlgbcostMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

