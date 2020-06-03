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
import cn.ibizlab.ehr.core.r7rt_dyna.domain.DynaChart;
import cn.ibizlab.ehr.core.r7rt_dyna.service.IDynaChartService;
import cn.ibizlab.ehr.core.r7rt_dyna.filter.DynaChartSearchContext;

@Slf4j
@Api(tags = {"动态图表" })
@RestController("WebApi-dynachart")
@RequestMapping("")
public class DynaChartResource {

    @Autowired
    public IDynaChartService dynachartService;

    @Autowired
    @Lazy
    public DynaChartMapping dynachartMapping;

    @ApiOperation(value = "获取动态图表", tags = {"动态图表" },  notes = "获取动态图表")
	@RequestMapping(method = RequestMethod.GET, value = "/dynacharts/{dynachart_id}")
    public ResponseEntity<DynaChartDTO> get(@PathVariable("dynachart_id") String dynachart_id) {
        DynaChart domain = dynachartService.get(dynachart_id);
        DynaChartDTO dto = dynachartMapping.toDto(domain);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "获取动态图表草稿", tags = {"动态图表" },  notes = "获取动态图表草稿")
	@RequestMapping(method = RequestMethod.GET, value = "/dynacharts/getdraft")
    public ResponseEntity<DynaChartDTO> getDraft() {
        return ResponseEntity.status(HttpStatus.OK).body(dynachartMapping.toDto(dynachartService.getDraft(new DynaChart())));
    }

    @ApiOperation(value = "检查动态图表", tags = {"动态图表" },  notes = "检查动态图表")
	@RequestMapping(method = RequestMethod.POST, value = "/dynacharts/checkkey")
    public ResponseEntity<Boolean> checkKey(@RequestBody DynaChartDTO dynachartdto) {
        return  ResponseEntity.status(HttpStatus.OK).body(dynachartService.checkKey(dynachartMapping.toDomain(dynachartdto)));
    }

    @ApiOperation(value = "更新动态图表", tags = {"动态图表" },  notes = "更新动态图表")
	@RequestMapping(method = RequestMethod.PUT, value = "/dynacharts/{dynachart_id}")

    public ResponseEntity<DynaChartDTO> update(@PathVariable("dynachart_id") String dynachart_id, @RequestBody DynaChartDTO dynachartdto) {
		DynaChart domain  = dynachartMapping.toDomain(dynachartdto);
        domain .setDynachartid(dynachart_id);
		dynachartService.update(domain );
		DynaChartDTO dto = dynachartMapping.toDto(domain );
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量更新动态图表", tags = {"动态图表" },  notes = "批量更新动态图表")
	@RequestMapping(method = RequestMethod.PUT, value = "/dynacharts/batch")
    public ResponseEntity<Boolean> updateBatch(@RequestBody List<DynaChartDTO> dynachartdtos) {
        dynachartService.updateBatch(dynachartMapping.toDomain(dynachartdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "删除动态图表", tags = {"动态图表" },  notes = "删除动态图表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/dynacharts/{dynachart_id}")

    public ResponseEntity<Boolean> remove(@PathVariable("dynachart_id") String dynachart_id) {
         return ResponseEntity.status(HttpStatus.OK).body(dynachartService.remove(dynachart_id));
    }

    @ApiOperation(value = "批量删除动态图表", tags = {"动态图表" },  notes = "批量删除动态图表")
	@RequestMapping(method = RequestMethod.DELETE, value = "/dynacharts/batch")
    public ResponseEntity<Boolean> removeBatch(@RequestBody List<String> ids) {
        dynachartService.removeBatch(ids);
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "新建动态图表", tags = {"动态图表" },  notes = "新建动态图表")
	@RequestMapping(method = RequestMethod.POST, value = "/dynacharts")

    public ResponseEntity<DynaChartDTO> create(@RequestBody DynaChartDTO dynachartdto) {
        DynaChart domain = dynachartMapping.toDomain(dynachartdto);
		dynachartService.create(domain);
        DynaChartDTO dto = dynachartMapping.toDto(domain);
		return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @ApiOperation(value = "批量新建动态图表", tags = {"动态图表" },  notes = "批量新建动态图表")
	@RequestMapping(method = RequestMethod.POST, value = "/dynacharts/batch")
    public ResponseEntity<Boolean> createBatch(@RequestBody List<DynaChartDTO> dynachartdtos) {
        dynachartService.createBatch(dynachartMapping.toDomain(dynachartdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

    @ApiOperation(value = "保存动态图表", tags = {"动态图表" },  notes = "保存动态图表")
	@RequestMapping(method = RequestMethod.POST, value = "/dynacharts/save")
    public ResponseEntity<Boolean> save(@RequestBody DynaChartDTO dynachartdto) {
        return ResponseEntity.status(HttpStatus.OK).body(dynachartService.save(dynachartMapping.toDomain(dynachartdto)));
    }

    @ApiOperation(value = "批量保存动态图表", tags = {"动态图表" },  notes = "批量保存动态图表")
	@RequestMapping(method = RequestMethod.POST, value = "/dynacharts/savebatch")
    public ResponseEntity<Boolean> saveBatch(@RequestBody List<DynaChartDTO> dynachartdtos) {
        dynachartService.saveBatch(dynachartMapping.toDomain(dynachartdtos));
        return  ResponseEntity.status(HttpStatus.OK).body(true);
    }

	@ApiOperation(value = "获取DEFAULT", tags = {"动态图表" } ,notes = "获取DEFAULT")
    @RequestMapping(method= RequestMethod.GET , value="/dynacharts/fetchdefault")
	public ResponseEntity<List<DynaChartDTO>> fetchDefault(DynaChartSearchContext context) {
        Page<DynaChart> domains = dynachartService.searchDefault(context) ;
        List<DynaChartDTO> list = dynachartMapping.toDto(domains.getContent());
        return ResponseEntity.status(HttpStatus.OK)
                .header("x-page", String.valueOf(context.getPageable().getPageNumber()))
                .header("x-per-page", String.valueOf(context.getPageable().getPageSize()))
                .header("x-total", String.valueOf(domains.getTotalElements()))
                .body(list);
	}

	@ApiOperation(value = "查询DEFAULT", tags = {"动态图表" } ,notes = "查询DEFAULT")
    @RequestMapping(method= RequestMethod.POST , value="/dynacharts/searchdefault")
	public ResponseEntity<Page<DynaChartDTO>> searchDefault(@RequestBody DynaChartSearchContext context) {
        Page<DynaChart> domains = dynachartService.searchDefault(context) ;
	    return ResponseEntity.status(HttpStatus.OK)
                .body(new PageImpl(dynachartMapping.toDto(domains.getContent()), context.getPageable(), domains.getTotalElements()));
	}
}

